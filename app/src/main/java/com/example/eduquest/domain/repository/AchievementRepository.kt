package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.AchievementUnlockResult
import com.example.eduquest.domain.model.AchievementWithProgress
import kotlinx.coroutines.flow.Flow

interface AchievementRepository {
    suspend fun ensureStarterAchievementsSeeded()
    fun getAchievementsWithProgress(playerId: String): Flow<List<AchievementWithProgress>>
    suspend fun evaluateAchievements(playerId: String): List<AchievementUnlockResult>
    fun getUnlockedCountFlow(playerId: String): Flow<Int>
}
