package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.WorldAreaWithProgress
import com.example.eduquest.domain.model.WorldWithProgress
import kotlinx.coroutines.flow.Flow

interface WorldRepository {
    suspend fun ensureStarterWorldsSeeded()
    fun getWorldWithAreas(playerId: String, worldId: String = "WORLD_01"): Flow<WorldWithProgress?>
    fun getAllWorldsWithProgress(playerId: String): Flow<List<WorldWithProgress>>
    fun getAreasForWorld(playerId: String, worldId: String = "WORLD_01"): Flow<List<WorldAreaWithProgress>>
}
