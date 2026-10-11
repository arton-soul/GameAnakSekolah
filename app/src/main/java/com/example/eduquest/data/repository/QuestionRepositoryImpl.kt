package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.dao.QuestionDao
import com.example.eduquest.data.local.entity.AnswerHistoryEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.entity.toEntity
import com.example.eduquest.data.local.seed.QuestionStarterData
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.repository.QuestionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao,
    private val progressDao: ProgressDao
) : QuestionRepository {

    override suspend fun ensureStarterQuestionsSeeded() {
        questionDao.insertQuestions(QuestionStarterData.ALL_STARTER_QUESTIONS)
    }

    override suspend fun getQuestionsForQuest(questId: String, grade: Int): List<Question> {
        ensureStarterQuestionsSeeded()
        val questQuestions = questionDao.getQuestionsForQuest(questId)
        if (questQuestions.isNotEmpty()) {
            return questQuestions.map { it.toDomain() }
        }

        // Fallback for starter/practice quests: load questions for player grade or general starter pool
        val gradeQuestions = questionDao.getQuestionsForGrade(grade, limit = 5)
        if (gradeQuestions.isNotEmpty()) {
            return gradeQuestions.map { it.toDomain() }
        }

        return questionDao.getAllQuestions(limit = 5).map { it.toDomain() }
    }

    override fun getQuestionsByGradeAndSubject(grade: Int, subjectId: String): Flow<List<Question>> {
        return questionDao.getQuestionsByGradeAndSubject(grade, subjectId).map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun getQuestionById(id: String): Question? {
        return questionDao.getQuestionById(id)?.toDomain()
    }

    override suspend fun recordAnswer(
        playerId: String,
        questId: String,
        questionId: String,
        selectedAnswer: String,
        isCorrect: Boolean,
        xpEarned: Int
    ) {
        progressDao.insertAnswerHistory(
            AnswerHistoryEntity(
                playerId = playerId,
                questId = questId,
                questionId = questionId,
                selectedAnswer = selectedAnswer,
                isCorrect = isCorrect,
                xpEarned = xpEarned
            )
        )
    }

    override suspend fun insertQuestions(questions: List<Question>) {
        questionDao.insertQuestions(questions.map { it.toEntity() })
    }

    override suspend fun getExamQuestions(educationLevel: String, limit: Int): List<Question> {
        ensureStarterQuestionsSeeded()
        return questionDao.getRandomExamQuestions(educationLevel, limit).map { it.toDomain() }
    }

    override suspend fun getExamQuestionsBySubject(educationLevel: String, subjectId: String, limit: Int): List<Question> {
        ensureStarterQuestionsSeeded()
        return questionDao.getRandomExamQuestionsBySubject(educationLevel, subjectId, limit).map { it.toDomain() }
    }

    override suspend fun getExamQuestionCount(educationLevel: String): Int {
        ensureStarterQuestionsSeeded()
        return questionDao.getExamQuestionCount(educationLevel)
    }
}