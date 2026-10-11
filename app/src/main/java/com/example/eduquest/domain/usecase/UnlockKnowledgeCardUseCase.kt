package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.CardUnlockResult
import com.example.eduquest.domain.repository.KnowledgeCardRepository

class UnlockKnowledgeCardUseCase(
    private val repository: KnowledgeCardRepository
) {
    suspend operator fun invoke(playerId: String = "PLAYER_LOCAL", questId: String): List<CardUnlockResult> {
        return repository.unlockCardForQuest(playerId, questId)
    }
}
