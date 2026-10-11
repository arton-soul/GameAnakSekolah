package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.DailyRewardClaimResult
import kotlinx.coroutines.flow.Flow

interface DailyMissionRepository {
    suspend fun ensureStarterMissionsSeeded()
    fun getDailyMissionsWithProgress(playerId: String, dateString: String): Flow<List<DailyMissionWithProgress>>
    suspend fun recordSubjectProgress(playerId: String, subjectId: String, dateString: String, count: Int = 1)
    suspend fun recordQuestProgress(playerId: String, isPerfectScore: Boolean, dateString: String)
    suspend fun claimReward(playerId: String, missionId: String, dateString: String): DailyRewardClaimResult
    fun getCompletedCountFlow(playerId: String, dateString: String): Flow<Int>
    fun getClaimedCountFlow(playerId: String, dateString: String): Flow<Int>
}
