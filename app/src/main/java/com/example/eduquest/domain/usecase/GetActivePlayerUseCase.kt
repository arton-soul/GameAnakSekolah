package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetActivePlayerUseCase(
    private val playerRepository: PlayerRepository
) {
    operator fun invoke(): Flow<Player?> = playerRepository.getActivePlayer()
    suspend fun getDirect(): Player? = playerRepository.getActivePlayerDirect()
}
