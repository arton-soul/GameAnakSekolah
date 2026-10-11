package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.AnswerValidationResult
import com.example.eduquest.domain.model.Question

class ValidateAnswerUseCase {
    operator fun invoke(question: Question, selectedAnswer: String, isRepeat: Boolean = false): AnswerValidationResult {
        val trimmedSelected = selectedAnswer.trim()
        val trimmedCorrect = question.correctAnswer.trim()
        val isCorrect = trimmedSelected.equals(trimmedCorrect, ignoreCase = true)
        val baseXp = if (isCorrect) question.xpReward else 0
        val xpEarned = if (isCorrect && isRepeat) maxOf(3, (baseXp * 0.3).toInt()) else baseXp

        return AnswerValidationResult(
            questionId = question.id,
            selectedAnswer = trimmedSelected,
            isCorrect = isCorrect,
            correctAnswer = trimmedCorrect,
            explanation = question.explanation,
            xpEarned = xpEarned
        )
    }
}
