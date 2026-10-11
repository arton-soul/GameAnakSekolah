package com.example.eduquest.data.repository

import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.data.local.dao.DailyMissionDao
import com.example.eduquest.data.local.entity.PlayerDailyProgressEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.seed.DailyMissionStarterData
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.DailyRewardClaimResult
import com.example.eduquest.domain.repository.DailyMissionRepository
import com.example.eduquest.domain.repository.KnowledgeCardRepository
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class DailyMissionRepositoryImpl(
    private val dailyMissionDao: DailyMissionDao,
    private val playerRepository: PlayerRepository,
    private val knowledgeCardRepository: KnowledgeCardRepository? = null
) : DailyMissionRepository {

    private suspend fun resolveEffectivePlayerId(playerId: String): String {
        val effectiveId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
            playerId
        } else {
            playerRepository.getActivePlayerDirect()?.id ?: playerId
        }
        if (effectiveId.isNotEmpty() && effectiveId != "PLAYER_LOCAL") {
            try {
                dailyMissionDao.migrateLocalProgressToPlayer(effectiveId)
            } catch (_: Exception) {
                // Ignore migration errors
            }
        }
        return effectiveId
    }

    private fun isSubjectMatchingCategory(subjectId: String, category: String): Boolean {
        val s = subjectId.uppercase()
        val c = category.uppercase()
        return when (c) {
            "MATH" -> s.contains("MATH")
            "SCIENCE" -> s.contains("SCIENCE") || s.contains("IPA") || s.contains("MIPA")
            "LANGUAGE" -> s.contains("LANG") || s.contains("GENERAL")
            "SOCIAL" -> s.contains("IPS") || s.contains("SOSHUM")
            else -> false
        }
    }

    override suspend fun ensureStarterMissionsSeeded() {
        if (dailyMissionDao.getMissionCount() == 0) {
            dailyMissionDao.insertMissions(DailyMissionStarterData.STARTER_MISSIONS)
        }
    }

    override fun getDailyMissionsWithProgress(
        playerId: String,
        dateString: String
    ): Flow<List<DailyMissionWithProgress>> = flow {
        ensureStarterMissionsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        emitAll(
            combine(
                dailyMissionDao.getAllMissions(),
                dailyMissionDao.getDailyProgress(effectivePlayerId, dateString)
            ) { allMissions, progressList ->
                val coreMissions = allMissions.filter { DailyMissionStarterData.CORE_DAILY_MISSION_IDS.contains(it.id) }
                    .ifEmpty { allMissions.take(4) }
                val progressMap = progressList.associateBy { it.missionId }

                coreMissions.map { missionEntity ->
                    val progress = progressMap[missionEntity.id]
                    DailyMissionWithProgress(
                        mission = missionEntity.toDomain(),
                        dateString = dateString,
                        currentProgress = progress?.currentProgress ?: 0,
                        isCompleted = progress?.isCompleted ?: false,
                        isClaimed = progress?.isClaimed ?: false
                    )
                }
            }
        )
    }

    override suspend fun recordSubjectProgress(
        playerId: String,
        subjectId: String,
        dateString: String,
        count: Int
    ) {
        ensureStarterMissionsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val missions = dailyMissionDao.getAllMissionsList()
        val matchingMissions = missions.filter {
            it.category.equals(subjectId, ignoreCase = true) ||
            it.category == "ANY_QUESTION" ||
            isSubjectMatchingCategory(subjectId, it.category)
        }

        for (mission in matchingMissions) {
            val existing = dailyMissionDao.getProgress(effectivePlayerId, mission.id, dateString)
            if (existing == null) {
                val newProgress = count.coerceAtMost(mission.targetCount)
                val isCompleted = newProgress >= mission.targetCount
                dailyMissionDao.upsertDailyProgress(
                    PlayerDailyProgressEntity(
                        playerId = effectivePlayerId,
                        missionId = mission.id,
                        dateString = dateString,
                        currentProgress = newProgress,
                        isCompleted = isCompleted,
                        isClaimed = false
                    )
                )
            } else if (!existing.isCompleted) {
                val newProgress = (existing.currentProgress + count).coerceAtMost(mission.targetCount)
                val isCompleted = newProgress >= mission.targetCount
                dailyMissionDao.updateProgress(effectivePlayerId, mission.id, dateString, newProgress, isCompleted)
            }
        }
    }

    override suspend fun recordQuestProgress(
        playerId: String,
        isPerfectScore: Boolean,
        dateString: String
    ) {
        ensureStarterMissionsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val missions = dailyMissionDao.getAllMissionsList()
        val matchingMissions = missions.filter {
            it.category == "QUEST" || (isPerfectScore && it.category == "PERFECT_SCORE")
        }

        for (mission in matchingMissions) {
            val existing = dailyMissionDao.getProgress(effectivePlayerId, mission.id, dateString)
            if (existing == null) {
                val newProgress = 1.coerceAtMost(mission.targetCount)
                val isCompleted = newProgress >= mission.targetCount
                dailyMissionDao.upsertDailyProgress(
                    PlayerDailyProgressEntity(
                        playerId = effectivePlayerId,
                        missionId = mission.id,
                        dateString = dateString,
                        currentProgress = newProgress,
                        isCompleted = isCompleted,
                        isClaimed = false
                    )
                )
            } else if (!existing.isCompleted) {
                val newProgress = (existing.currentProgress + 1).coerceAtMost(mission.targetCount)
                val isCompleted = newProgress >= mission.targetCount
                dailyMissionDao.updateProgress(effectivePlayerId, mission.id, dateString, newProgress, isCompleted)
            }
        }
    }

    override suspend fun claimReward(
        playerId: String,
        missionId: String,
        dateString: String
    ): DailyRewardClaimResult {
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val mission = dailyMissionDao.getMissionById(missionId)
            ?: return DailyRewardClaimResult.MissionNotFound(missionId)

        val progress = dailyMissionDao.getProgress(effectivePlayerId, missionId, dateString)
            ?: return DailyRewardClaimResult.NotCompleted(missionId)

        if (!progress.isCompleted) {
            return DailyRewardClaimResult.NotCompleted(missionId)
        }

        if (progress.isClaimed) {
            // Duplicate Reward Protection
            return DailyRewardClaimResult.AlreadyClaimed(missionId)
        }

        // Atomically mark claimed in Room database
        dailyMissionDao.markClaimed(effectivePlayerId, missionId, dateString)

        // Grant XP and Coins
        playerRepository.addXp(effectivePlayerId, mission.rewardXp)
        playerRepository.addCoins(effectivePlayerId, mission.rewardCoins)

        // Check if all core missions for today are completed
        val allMissions = dailyMissionDao.getAllMissionsList()
            .filter { DailyMissionStarterData.CORE_DAILY_MISSION_IDS.contains(it.id) }
        val allProgress = dailyMissionDao.getDailyProgressList(effectivePlayerId, dateString)
            .associateBy { it.missionId }

        val isAllCompleted = allMissions.isNotEmpty() && allMissions.all { m ->
            allProgress[m.id]?.isCompleted == true
        }

        return DailyRewardClaimResult.Success(
            missionId = missionId,
            xpEarned = mission.rewardXp,
            coinsEarned = mission.rewardCoins,
            unlockedCard = null,
            isAllMissionsCompleted = isAllCompleted
        )
    }

    override fun getCompletedCountFlow(playerId: String, dateString: String): Flow<Int> = flow {
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        emitAll(dailyMissionDao.getCompletedMissionCountFlow(effectivePlayerId, dateString))
    }

    override fun getClaimedCountFlow(playerId: String, dateString: String): Flow<Int> = flow {
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        emitAll(dailyMissionDao.getClaimedMissionCountFlow(effectivePlayerId, dateString))
    }
}
