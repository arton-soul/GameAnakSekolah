package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.CardUnlockResult
import com.example.eduquest.domain.repository.KnowledgeCardRepository

class SyncKnowledgeCardsUseCase(
    private val repository: KnowledgeCardRepository
) {
    suspend operator fun invoke(playerId: String = "PLAYER_LOCAL"): List<CardUnlockResult> {
        return repository.syncCardsForCompletedQuests(playerId)
    }
}
