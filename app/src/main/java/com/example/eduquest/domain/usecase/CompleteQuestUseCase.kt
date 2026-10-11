package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.repository.QuestRepository

class CompleteQuestUseCase(
    private val questRepository: QuestRepository
) {
    suspend operator fun invoke(
        playerId: String,
        questId: String,
        score: Int,
        totalQuestions: Int
    ): QuestCompletionResult {
        return questRepository.completeQuest(
            playerId = playerId,
            questId = questId,
            score = score,
            totalQuestions = totalQuestions
        )
    }
}
