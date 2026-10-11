package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.KnowledgeCardWithStatus
import com.example.eduquest.domain.repository.KnowledgeCardRepository
import kotlinx.coroutines.flow.Flow

class GetKnowledgeCardsUseCase(
    private val repository: KnowledgeCardRepository
) {
    operator fun invoke(playerId: String = "PLAYER_LOCAL", category: String = "ALL"): Flow<List<KnowledgeCardWithStatus>> {
        return repository.getCardsByCategory(playerId, category)
    }
}
