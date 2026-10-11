package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.LeaderboardEntry
import com.example.eduquest.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface LeaderboardRepository {
    fun getLeaderboardFlow(educationLevel: String, currentPlayer: Player?): Flow<List<LeaderboardEntry>>
    suspend fun syncPlayerScoreToCloud(player: Player)
}
