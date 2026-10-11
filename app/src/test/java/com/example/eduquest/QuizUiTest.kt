package com.example.eduquest

import com.example.eduquest.domain.model.AnswerValidationResult
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.model.QuestionType
import com.example.eduquest.feature.quiz.QuizUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class QuizUiTest {

    private fun createQuestion(id: String, text: String, correct: String, xp: Int = 100): Question {
        return Question(
            id = id,
            grade = 1,
            subjectId = "MATH",
            topicId = "Penjumlahan",
            difficulty = Difficulty.EASY,
            type = QuestionType.MULTIPLE_CHOICE,
            questionText = text,
            optionA = "1",
            optionB = "2",
            optionC = "3",
            optionD = "4",
            correctAnswer = correct,
            explanation = "Pembahasan $id",
            xpReward = xp
        )
    }

    @Test
    fun defaultState_hasExpectedDefaults() {
        val state = QuizUiState()
        assertTrue(state.isLoading)
        assertEquals("", state.questId)
        assertTrue(state.questions.isEmpty())
        assertEquals(0, state.currentIndex)
        assertNull(state.selectedOption)
        assertNull(state.validationResult)
        assertFalse(state.isAnswerSubmitted)
        assertEquals(0, state.correctCount)
        assertEquals(0, state.totalXpEarned)
        assertFalse(state.isQuizFinished)
        assertNull(state.error)
        assertNull(state.currentQuestion)
        assertEquals(0, state.totalQuestions)
        assertEquals(0f, state.progressPercentage, 0.001f)
    }

    @Test
    fun loadedQuestions_computesCurrentQuestionAndProgress() {
        val q1 = createQuestion("q1", "1 + 1 = ?", "B")
        val q2 = createQuestion("q2", "2 + 1 = ?", "C")
        val q3 = createQuestion("q3", "3 + 1 = ?", "D")

        val state = QuizUiState(
            isLoading = false,
            questId = "quest_math_01",
            questions = listOf(q1, q2, q3),
            currentIndex = 0
        )

        assertEquals(3, state.totalQuestions)
        assertNotNull(state.currentQuestion)
        assertEquals("q1", state.currentQuestion?.id)
        // Question 1 of 3: progress = 1/3 = ~0.333f
        assertEquals(1f / 3f, state.progressPercentage, 0.001f)

        val stateQuestion2 = state.copy(currentIndex = 1)
        assertEquals("q2", stateQuestion2.currentQuestion?.id)
        assertEquals(2f / 3f, stateQuestion2.progressPercentage, 0.001f)

        val stateQuestion3 = state.copy(currentIndex = 2)
        assertEquals("q3", stateQuestion3.currentQuestion?.id)
        assertEquals(1.0f, stateQuestion3.progressPercentage, 0.001f)
    }

    @Test
    fun selectingOption_updatesSelectedOption() {
        val q1 = createQuestion("q1", "1 + 1 = ?", "B")
        var state = QuizUiState(
            isLoading = false,
            questId = "quest_math_01",
            questions = listOf(q1)
        )
        assertNull(state.selectedOption)

        state = state.copy(selectedOption = "B")
        assertEquals("B", state.selectedOption)
    }

    @Test
    fun answerSubmission_setsValidationResultAndXp() {
        val q1 = createQuestion("q1", "1 + 1 = ?", "B", xp = 120)
        val validation = AnswerValidationResult(
            questionId = q1.id,
            selectedAnswer = "B",
            isCorrect = true,
            correctAnswer = "B",
            explanation = "1 + 1 = 2",
            xpEarned = 120
        )

        val state = QuizUiState(
            isLoading = false,
            questId = "quest_math_01",
            questions = listOf(q1),
            currentIndex = 0,
            selectedOption = "B",
            validationResult = validation,
            isAnswerSubmitted = true,
            correctCount = 1,
            totalXpEarned = 120
        )

        assertTrue(state.isAnswerSubmitted)
        assertNotNull(state.validationResult)
        assertTrue(state.validationResult!!.isCorrect)
        assertEquals(120, state.validationResult!!.xpEarned)
        assertEquals(1, state.correctCount)
        assertEquals(120, state.totalXpEarned)
    }

    @Test
    fun quizCompletion_isFlaggedOnLastQuestion() {
        val q1 = createQuestion("q1", "1 + 1 = ?", "B")
        val q2 = createQuestion("q2", "2 + 1 = ?", "C")

        val state = QuizUiState(
            isLoading = false,
            questId = "quest_math_01",
            questions = listOf(q1, q2),
            currentIndex = 1,
            isAnswerSubmitted = true,
            isQuizFinished = true
        )

        assertTrue(state.isQuizFinished)
        assertEquals(1, state.currentIndex)
        assertEquals(2, state.totalQuestions)
    }
}
