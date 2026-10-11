package com.example.eduquest

import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.model.QuestionType
import com.example.eduquest.domain.usecase.ValidateAnswerUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class QuestionEngineTest {

    private lateinit var validateAnswerUseCase: ValidateAnswerUseCase

    private val sampleQuestion = Question(
        id = "TEST_Q_001",
        grade = 3,
        subjectId = "MATH",
        topicId = "Perkalian",
        difficulty = Difficulty.NORMAL,
        type = QuestionType.MULTIPLE_CHOICE,
        questionText = "Berapa 4 x 4?",
        optionA = "12",
        optionB = "14",
        optionC = "16",
        optionD = "18",
        correctAnswer = "C",
        explanation = "4 x 4 = 16",
        xpReward = 120
    )

    @Before
    fun setUp() {
        validateAnswerUseCase = ValidateAnswerUseCase()
    }

    @Test
    fun testValidateAnswerCorrect() {
        val result = validateAnswerUseCase(sampleQuestion, "C")
        assertTrue("Answer should be correct", result.isCorrect)
        assertEquals("XP earned should match question xpReward", 120, result.xpEarned)
        assertEquals("Correct answer should be C", "C", result.correctAnswer)
        assertEquals("Explanation should match", "4 x 4 = 16", result.explanation)
    }

    @Test
    fun testValidateAnswerWrong() {
        val result = validateAnswerUseCase(sampleQuestion, "A")
        assertFalse("Answer should be wrong", result.isCorrect)
        assertEquals("XP earned for wrong answer should be 0", 0, result.xpEarned)
        assertEquals("Correct answer should remain C", "C", result.correctAnswer)
    }

    @Test
    fun testValidateAnswerCaseInsensitive() {
        val result = validateAnswerUseCase(sampleQuestion, "c")
        assertTrue("Lowercase answer should be accepted", result.isCorrect)
        assertEquals(120, result.xpEarned)
    }

    @Test
    fun testQuestionOptionsHelperFourOptions() {
        val options = sampleQuestion.getOptions()
        assertEquals(4, options.size)
        assertEquals("A", options[0].key)
        assertEquals("12", options[0].text)
        assertEquals("C", options[2].key)
        assertEquals("16", options[2].text)
    }

    @Test
    fun testQuestionOptionsHelperTwoOptions() {
        val tfQuestion = Question(
            id = "TEST_TF_001",
            grade = 1,
            subjectId = "SCIENCE",
            topicId = "Hewan",
            type = QuestionType.TRUE_FALSE,
            questionText = "Sapi adalah hewan herbivora.",
            optionA = "Benar",
            optionB = "Salah",
            optionC = "",
            optionD = "",
            correctAnswer = "A",
            explanation = "Sapi memakan rumput, jadi herbivora.",
            xpReward = 100
        )
        val options = tfQuestion.getOptions()
        assertEquals(2, options.size)
        assertEquals("A", options[0].key)
        assertEquals("Benar", options[0].text)
        assertEquals("B", options[1].key)
        assertEquals("Salah", options[1].text)
    }

    @Test
    fun testQuestionValidationRules() {
        assertTrue("Question text must not be empty", sampleQuestion.questionText.isNotBlank())
        assertTrue("Correct answer must not be empty", sampleQuestion.correctAnswer.isNotBlank())
        assertTrue("Explanation must not be empty", sampleQuestion.explanation.isNotBlank())
        assertTrue("XP reward must be greater than 0", sampleQuestion.xpReward > 0)
    }
    @Test
    fun testWithShuffledOptionsPreservesCorrectAnswerText() {
        for (i in 1..20) {
            val shuffled = sampleQuestion.withShuffledOptions()
            val correctOptionText = when (shuffled.correctAnswer) {
                "A" -> shuffled.optionA
                "B" -> shuffled.optionB
                "C" -> shuffled.optionC
                "D" -> shuffled.optionD
                else -> ""
            }
            assertEquals("Correct option text must always remain '16' regardless of position", "16", correctOptionText)
            val validation = validateAnswerUseCase(shuffled, shuffled.correctAnswer)
            assertTrue("Submitting the updated correctAnswer must be validated as correct", validation.isCorrect)
        }
    }

    @Test
    fun testWithShuffledOptionsTrueFalsePreserved() {
        val tf = Question(
            id = "TF_TEST",
            grade = 1,
            subjectId = "SCIENCE",
            topicId = "Hewan",
            type = QuestionType.TRUE_FALSE,
            questionText = "Test True False",
            optionA = "Benar",
            optionB = "Salah",
            correctAnswer = "A",
            explanation = "Exp"
        )
        val shuffled = tf.withShuffledOptions()
        assertEquals("Benar", shuffled.optionA)
        assertEquals("Salah", shuffled.optionB)
        assertEquals("A", shuffled.correctAnswer)
    }

    @Test
    fun testWithShuffledOptionsProducesVariationAcrossRepeats() {
        val observedKeys = mutableSetOf<String>()
        for (i in 1..50) {
            val shuffled = sampleQuestion.withShuffledOptions()
            observedKeys.add(shuffled.correctAnswer)
        }
        assertTrue("Shuffling options over 50 iterations should produce varied answer keys, found: $observedKeys", observedKeys.size > 1)
    }
}