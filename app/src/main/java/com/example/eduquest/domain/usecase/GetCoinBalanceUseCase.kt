package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow

class GetCoinBalanceUseCase(
    private val playerRepository: PlayerRepository
) {
    operator fun invoke(playerId: String): Flow<Int> {
        return playerRepository.getCoinBalance(playerId)
    }
}
