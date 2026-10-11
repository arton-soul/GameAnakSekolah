package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.dao.QuestDao
import com.example.eduquest.data.local.entity.QuestProgressEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.seed.QuestStarterData
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.repository.QuestRepository
import com.example.eduquest.domain.usecase.EvaluateAchievementsUseCase
import com.example.eduquest.domain.usecase.EvaluateQuestRewardUseCase
import com.example.eduquest.domain.usecase.UnlockKnowledgeCardUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class QuestRepositoryImpl(
    private val questDao: QuestDao,
    private val progressDao: ProgressDao,
    private val playerDao: PlayerDao,
    private val evaluateQuestRewardUseCase: EvaluateQuestRewardUseCase = EvaluateQuestRewardUseCase(),
    private val evaluateAchievementsUseCase: EvaluateAchievementsUseCase? = null,
    private val unlockKnowledgeCardUseCase: UnlockKnowledgeCardUseCase? = null
) : QuestRepository {

    override suspend fun ensureStarterQuestsSeeded() {
        val questCount = questDao.getQuestCount()
        val linkCount = questDao.getQuestQuestionCount()
        if (questCount < QuestStarterData.STARTER_QUESTS.size || linkCount != QuestStarterData.STARTER_QUEST_QUESTIONS.size) {
            questDao.deleteAllQuestQuestions()
            questDao.insertQuests(QuestStarterData.STARTER_QUESTS)
            questDao.insertQuestQuestions(QuestStarterData.STARTER_QUEST_QUESTIONS)
        }
    }

    override fun getQuestsByWorld(worldId: String): Flow<List<Quest>> = flow {
        ensureStarterQuestsSeeded()
        emitAll(questDao.getQuestsByWorld(worldId).map { entities ->
            entities.map { it.toDomain() }
        })
    }

    override fun getQuestsBySubject(subjectId: String): Flow<List<Quest>> = flow {
        ensureStarterQuestsSeeded()
        emitAll(questDao.getQuestsBySubject(subjectId).map { entities ->
            entities.map { it.toDomain() }
        })
    }

    override fun getQuestsWithProgress(
        playerId: String,
        subjectId: String?
    ): Flow<List<QuestWithProgress>> = flow {
        ensureStarterQuestsSeeded()
        val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
            playerId
        } else {
            playerDao.getActivePlayerDirect()?.id ?: playerId
        }
        val questsFlow = if (subjectId.isNullOrEmpty()) {
            questDao.getAllQuests()
        } else {
            questDao.getQuestsBySubject(subjectId)
        }
        val progressFlow = progressDao.getPlayerProgressFlow(effectivePlayerId)
        val playerFlow = playerDao.getAllPlayers().map { list -> list.firstOrNull { it.id == effectivePlayerId } ?: list.firstOrNull() }

        emitAll(combine(questsFlow, progressFlow, playerFlow) { quests, progressList, player ->
            val playerLevel = player?.level ?: 1
            val progressMap = progressList.associateBy { it.questId }
            val playerEduLevel = player?.educationLevel ?: "SD"
            val targetWorldId = when (playerEduLevel.uppercase()) {
                "SMP" -> "WORLD_SMP_01"
                "SMA" -> "WORLD_SMA_01"
                else -> "WORLD_01"
            }

            val filteredQuests = if (subjectId.isNullOrEmpty()) {
                quests.filter { it.worldId == targetWorldId || it.educationLevel.equals(playerEduLevel, ignoreCase = true) }
            } else {
                quests
            }

            filteredQuests.map { questEntity ->
                val quest = questEntity.toDomain()
                val progress = progressMap[quest.id]

                val status = when {
                    progress?.status == QuestStatus.COMPLETED.name -> QuestStatus.COMPLETED
                    progress?.status == QuestStatus.IN_PROGRESS.name -> QuestStatus.IN_PROGRESS
                    playerLevel >= quest.unlockLevel -> QuestStatus.AVAILABLE
                    else -> QuestStatus.LOCKED
                }

                QuestWithProgress(
                    quest = quest,
                    status = status,
                    score = progress?.score ?: 0,
                    attemptCount = progress?.attemptCount ?: 0,
                    completedAt = progress?.completedAt
                )
            }
        })
    }

    override suspend fun getQuestById(questId: String): Quest? {
        ensureStarterQuestsSeeded()
        return questDao.getQuestById(questId)?.toDomain()
    }

    override suspend fun getQuestWithProgress(
        playerId: String,
        questId: String
    ): QuestWithProgress? {
        ensureStarterQuestsSeeded()
        val questEntity = questDao.getQuestById(questId) ?: return null
        val quest = questEntity.toDomain()
        val progress = progressDao.getQuestProgress(playerId, questId)
        val player = playerDao.getPlayerDirect(playerId) ?: playerDao.getActivePlayerDirect()
        val playerLevel = player?.level ?: 1

        val status = when {
            progress?.status == QuestStatus.COMPLETED.name -> QuestStatus.COMPLETED
            progress?.status == QuestStatus.IN_PROGRESS.name -> QuestStatus.IN_PROGRESS
            playerLevel >= quest.unlockLevel -> QuestStatus.AVAILABLE
            else -> QuestStatus.LOCKED
        }

        return QuestWithProgress(
            quest = quest,
            status = status,
            score = progress?.score ?: 0,
            attemptCount = progress?.attemptCount ?: 0,
            completedAt = progress?.completedAt
        )
    }

    override suspend fun startQuest(playerId: String, questId: String) {
        ensureStarterQuestsSeeded()
        val existing = progressDao.getQuestProgress(playerId, questId)
        if (existing == null) {
            progressDao.upsertQuestProgress(
                QuestProgressEntity(
                    playerId = playerId,
                    questId = questId,
                    status = QuestStatus.IN_PROGRESS.name,
                    score = 0,
                    completedAt = null,
                    attemptCount = 1
                )
            )
        } else if (existing.status != QuestStatus.COMPLETED.name) {
            progressDao.upsertQuestProgress(
                existing.copy(
                    status = QuestStatus.IN_PROGRESS.name,
                    attemptCount = existing.attemptCount + 1
                )
            )
        }
    }

    override suspend fun completeQuest(
        playerId: String,
        questId: String,
        score: Int,
        totalQuestions: Int
    ): QuestCompletionResult {
        ensureStarterQuestsSeeded()
        val quest = questDao.getQuestById(questId)?.toDomain() ?: Quest(
            id = questId,
            worldId = "WORLD_01",
            title = "Quest Selesai",
            description = "",
            subjectId = "GENERAL",
            grade = 1
        )

        val existing = progressDao.getQuestProgress(playerId, questId)
        val isAlreadyCompleted = existing != null && existing.status == QuestStatus.COMPLETED.name
        val rewardClaimResult = evaluateQuestRewardUseCase(
            isAlreadyCompleted = isAlreadyCompleted,
            xpReward = quest.xpReward,
            coinReward = quest.coinReward
        )
        val isFirstCompletion = !isAlreadyCompleted
        val now = System.currentTimeMillis()
        val maxScore = quest.questionCount
        val safeScore = score.coerceIn(0, maxScore)
        val bestScore = maxOf(existing?.score ?: 0, safeScore).coerceIn(0, maxScore)
        val attempts = if (isFirstCompletion) 1 else (existing?.attemptCount ?: 1) + 1

        // Persist completed status
        progressDao.upsertQuestProgress(
            QuestProgressEntity(
                playerId = playerId,
                questId = questId,
                status = QuestStatus.COMPLETED.name,
                score = bestScore,
                completedAt = now,
                attemptCount = attempts
            )
        )

        // Award XP & coins (full on first completion, scaled down on replay)
        val xpEarned = rewardClaimResult.xpEarned
        val coinsEarned = rewardClaimResult.coinsEarned

        var levelUpResult: LevelUpResult? = null
        if (xpEarned > 0 || coinsEarned > 0) {
            val player = playerDao.getPlayerDirect(playerId) ?: playerDao.getActivePlayerDirect()
            player?.let { p ->
                val newXp = p.xp + xpEarned
                val oldLevel = p.level
                val newLevel = LevelTable.calculateLevel(newXp)
                val hasLeveledUp = newLevel > oldLevel
                val levelBonusCoins = if (hasLeveledUp) (newLevel - oldLevel) * LevelTable.LEVEL_UP_COIN_REWARD else 0
                val totalNewCoins = p.coins + coinsEarned + levelBonusCoins

                playerDao.updatePlayer(
                    p.copy(
                        xp = newXp,
                        level = newLevel,
                        coins = totalNewCoins,
                        updatedAt = now
                    )
                )

                levelUpResult = LevelUpResult(
                    oldLevel = oldLevel,
                    newLevel = newLevel,
                    hasLeveledUp = hasLeveledUp,
                    bonusCoins = levelBonusCoins,
                    totalXp = newXp,
                    levelProgress = LevelTable.calculateProgress(newXp)
                )
            }
        }

        val unlockedAchievements = try {
            evaluateAchievementsUseCase?.invoke(playerId)?.map { it.achievement } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }

        val unlockedCards = try {
            unlockKnowledgeCardUseCase?.invoke(playerId, questId)?.map { it.card } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }

        return QuestCompletionResult(
            questId = questId,
            playerId = playerId,
            isCompleted = true,
            score = score,
            totalQuestions = totalQuestions,
            xpEarned = xpEarned,
            coinsEarned = coinsEarned,
            isFirstCompletion = isFirstCompletion,
            levelUpResult = levelUpResult,
            rewardClaimResult = rewardClaimResult,
            unlockedAchievements = unlockedAchievements,
            unlockedCards = unlockedCards,
            completedAt = now
        )
    }
}
