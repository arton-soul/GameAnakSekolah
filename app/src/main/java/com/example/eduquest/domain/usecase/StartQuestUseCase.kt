package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.repository.QuestRepository

class StartQuestUseCase(
    private val questRepository: QuestRepository
) {
    suspend operator fun invoke(
        playerId: String,
        questId: String
    ) {
        questRepository.startQuest(playerId, questId)
    }
}
