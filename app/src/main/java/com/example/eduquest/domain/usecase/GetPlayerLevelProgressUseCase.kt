package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetPlayerLevelProgressUseCase(
    private val playerRepository: PlayerRepository
) {
    operator fun invoke(playerId: String): Flow<LevelProgress> {
        return playerRepository.getPlayerLevelProgress(playerId)
    }
}
