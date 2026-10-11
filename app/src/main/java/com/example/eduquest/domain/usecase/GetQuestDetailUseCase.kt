package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.repository.QuestRepository

class GetQuestDetailUseCase(
    private val questRepository: QuestRepository
) {
    suspend operator fun invoke(
        playerId: String,
        questId: String
    ): QuestWithProgress? {
        return questRepository.getQuestWithProgress(playerId, questId)
    }
}
