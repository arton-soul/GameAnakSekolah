package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.repository.PlayerRepository

class SpendCoinsUseCase(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(playerId: String, amount: Int): CoinTransactionResult {
        return playerRepository.spendCoins(playerId, amount)
    }
}
