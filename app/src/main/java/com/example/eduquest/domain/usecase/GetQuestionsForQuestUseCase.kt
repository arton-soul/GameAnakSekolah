package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.repository.QuestionRepository

class GetQuestionsForQuestUseCase(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(questId: String, grade: Int = 1): List<Question> {
        return repository.getQuestionsForQuest(questId, grade).map { it.withShuffledOptions() }
    }
}