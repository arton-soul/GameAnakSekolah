package com.example.eduquest.domain.model

data class AnswerValidationResult(
    val questionId: String,
    val selectedAnswer: String,
    val isCorrect: Boolean,
    val correctAnswer: String,
    val explanation: String,
    val xpEarned: Int
)
