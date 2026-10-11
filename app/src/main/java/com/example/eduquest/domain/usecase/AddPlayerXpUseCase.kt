package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.repository.PlayerRepository

class AddPlayerXpUseCase(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(playerId: String, xpToAdd: Int): LevelUpResult {
        return playerRepository.addXp(playerId, xpToAdd)
    }
}
