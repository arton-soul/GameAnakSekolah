package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    suspend fun getQuestionsForQuest(questId: String, grade: Int = 1): List<Question>
    fun getQuestionsByGradeAndSubject(grade: Int, subjectId: String): Flow<List<Question>>
    suspend fun getQuestionById(id: String): Question?
    suspend fun recordAnswer(
        playerId: String,
        questId: String,
        questionId: String,
        selectedAnswer: String,
        isCorrect: Boolean,
        xpEarned: Int
    )
    suspend fun ensureStarterQuestionsSeeded()
    suspend fun insertQuestions(questions: List<Question>)
    suspend fun getExamQuestions(educationLevel: String, limit: Int = 20): List<Question>
    suspend fun getExamQuestionsBySubject(educationLevel: String, subjectId: String, limit: Int = 15): List<Question>
    suspend fun getExamQuestionCount(educationLevel: String): Int
}