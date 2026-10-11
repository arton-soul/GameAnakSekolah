package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.repository.QuestionRepository

class RecordAnswerUseCase(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(
        playerId: String,
        questId: String,
        questionId: String,
        selectedAnswer: String,
        isCorrect: Boolean,
        xpEarned: Int
    ) {
        repository.recordAnswer(
            playerId = playerId,
            questId = questId,
            questionId = questionId,
            selectedAnswer = selectedAnswer,
            isCorrect = isCorrect,
            xpEarned = xpEarned
        )
    }
}
