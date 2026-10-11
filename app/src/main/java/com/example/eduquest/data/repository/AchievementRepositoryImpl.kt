package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.AchievementDao
import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.entity.PlayerAchievementEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.seed.AchievementStarterData
import com.example.eduquest.domain.model.AchievementUnlockResult
import com.example.eduquest.domain.model.AchievementWithProgress
import com.example.eduquest.domain.repository.AchievementRepository
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class AchievementRepositoryImpl(
    private val achievementDao: AchievementDao,
    private val progressDao: ProgressDao,
    private val playerDao: PlayerDao,
    private val playerRepository: PlayerRepository
) : AchievementRepository {

    private suspend fun resolveEffectivePlayerId(playerId: String): String {
        if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") return playerId
        return playerDao.getActivePlayerDirect()?.id ?: playerId
    }

    override suspend fun ensureStarterAchievementsSeeded() {
        if (achievementDao.getAchievementCount() < AchievementStarterData.STARTER_ACHIEVEMENTS.size) {
            achievementDao.insertAchievements(AchievementStarterData.STARTER_ACHIEVEMENTS)
        }
    }

    override fun getAchievementsWithProgress(playerId: String): Flow<List<AchievementWithProgress>> = flow {
        ensureStarterAchievementsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val achievementsFlow = achievementDao.getAllAchievements()
        val playerAchievementsFlow = achievementDao.getPlayerAchievements(effectivePlayerId)

        emitAll(combine(achievementsFlow, playerAchievementsFlow) { achievements, playerAchievements ->
            val progressMap = playerAchievements.associateBy { it.achievementId }

            achievements.map { achievementEntity ->
                val achievement = achievementEntity.toDomain()
                val playerProgress = progressMap[achievement.id]
                val rawProgress = playerProgress?.progress ?: 0
                val cappedProgress = if (achievement.target > 0) minOf(rawProgress, achievement.target) else rawProgress

                AchievementWithProgress(
                    achievement = achievement,
                    progress = cappedProgress,
                    isUnlocked = playerProgress?.unlocked ?: false,
                    unlockedAt = playerProgress?.unlockedAt
                )
            }
        })
    }

    override suspend fun evaluateAchievements(playerId: String): List<AchievementUnlockResult> {
        ensureStarterAchievementsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)

        val completedQuests = progressDao.getCompletedQuestCount(effectivePlayerId)
        val perfectQuests = progressDao.getPerfectScoreQuestCount(effectivePlayerId)
        val mathCorrect = progressDao.getCorrectCountBySubject(effectivePlayerId, "MATH")
        val scienceCorrect = progressDao.getCorrectCountBySubject(effectivePlayerId, "SCIENCE")
        val languageCorrect = progressDao.getCorrectCountBySubject(effectivePlayerId, "LANGUAGE")
        val playerLevel = (playerDao.getPlayerDirect(effectivePlayerId) ?: playerDao.getActivePlayerDirect())?.level ?: 1

        val achievements = achievementDao.getAllAchievementsList()
        val newlyUnlocked = mutableListOf<AchievementUnlockResult>()

        for (entity in achievements) {
            val metric = when (entity.type) {
                "QUEST_COMPLETED" -> completedQuests
                "MATH_CORRECT" -> mathCorrect
                "SCIENCE_CORRECT" -> scienceCorrect
                "LANGUAGE_CORRECT" -> languageCorrect
                "PERFECT_SCORE" -> perfectQuests
                "LEVEL_REACHED" -> playerLevel
                else -> 0
            }

            val existing = achievementDao.getPlayerAchievement(effectivePlayerId, entity.id)
            val alreadyUnlocked = existing?.unlocked ?: false
            val cappedMetric = if (entity.target > 0) minOf(metric, entity.target) else metric

            if (alreadyUnlocked && existing != null) {
                // If progress improved, keep track but do not re-reward (Duplicate Reward Protection)
                if (cappedMetric > existing.progress) {
                    achievementDao.upsertPlayerAchievement(existing.copy(progress = cappedMetric))
                }
            } else {
                val isNowUnlocked = metric >= entity.target
                if (isNowUnlocked) {
                    val now = System.currentTimeMillis()
                    achievementDao.upsertPlayerAchievement(
                        PlayerAchievementEntity(
                            playerId = effectivePlayerId,
                            achievementId = entity.id,
                            progress = entity.target,
                            unlocked = true,
                            unlockedAt = now
                        )
                    )

                    // Grant rewards safely and atomically
                    if (entity.rewardXp > 0) {
                        try {
                            playerRepository.addXp(effectivePlayerId, entity.rewardXp)
                        } catch (e: Exception) {
                            // Log or ignore
                        }
                    }
                    if (entity.rewardCoins > 0) {
                        try {
                            playerRepository.addCoins(effectivePlayerId, entity.rewardCoins)
                        } catch (e: Exception) {
                            // Log or ignore
                        }
                    }

                    newlyUnlocked.add(
                        AchievementUnlockResult(
                            achievement = entity.toDomain(),
                            unlockedAt = now,
                            xpEarned = entity.rewardXp,
                            coinsEarned = entity.rewardCoins
                        )
                    )
                } else {
                    achievementDao.upsertPlayerAchievement(
                        PlayerAchievementEntity(
                            playerId = effectivePlayerId,
                            achievementId = entity.id,
                            progress = cappedMetric,
                            unlocked = false,
                            unlockedAt = null
                        )
                    )
                }
            }
        }

        return newlyUnlocked
    }

    override fun getUnlockedCountFlow(playerId: String): Flow<Int> = flow {
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        emitAll(achievementDao.getUnlockedCountFlow(effectivePlayerId))
    }
}
