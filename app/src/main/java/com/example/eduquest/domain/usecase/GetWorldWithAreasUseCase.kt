package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.WorldWithProgress
import com.example.eduquest.domain.repository.WorldRepository
import kotlinx.coroutines.flow.Flow

class GetWorldWithAreasUseCase(
    private val worldRepository: WorldRepository
) {
    operator fun invoke(
        playerId: String,
        worldId: String = "WORLD_01"
    ): Flow<WorldWithProgress?> {
        return worldRepository.getWorldWithAreas(playerId, worldId)
    }
}
