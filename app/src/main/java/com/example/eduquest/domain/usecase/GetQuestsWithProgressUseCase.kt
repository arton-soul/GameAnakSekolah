package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.repository.QuestRepository
import kotlinx.coroutines.flow.Flow

class GetQuestsWithProgressUseCase(
    private val questRepository: QuestRepository
) {
    operator fun invoke(
        playerId: String,
        subjectId: String? = null
    ): Flow<List<QuestWithProgress>> {
        return questRepository.getQuestsWithProgress(playerId, subjectId)
    }
}
