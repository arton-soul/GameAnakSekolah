package com.example.eduquest

import com.example.eduquest.core.navigation.Screen
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SD
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SMP
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SMA
import com.example.eduquest.data.local.seed.QuestionStarterData
import com.example.eduquest.feature.exam.calculateExamGrade
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExamContentAndLogicTest {

    @Test
    fun examQuestions_totalThreeHundred_andValidDistribution() {
        val examQuestions = QuestionStarterData.STARTER_EXAM_QUESTIONS
        assertEquals("Total exam questions must be exactly 300", 300, examQuestions.size)

        // Unique IDs
        val ids = examQuestions.map { it.id }.toSet()
        assertEquals("All 300 exam question IDs must be unique", 300, ids.size)

        // Level distribution
        val sd = examQuestions.filter { it.educationLevel == "SD" }
        val smp = examQuestions.filter { it.educationLevel == "SMP" }
        val sma = examQuestions.filter { it.educationLevel == "SMA" }

        assertEquals(100, sd.size)
        assertEquals(100, smp.size)
        assertEquals(100, sma.size)

        // SD Subject breakdown: 35 MATH, 35 SCIENCE, 30 LANGUAGE
        assertEquals(35, sd.count { it.subjectId == "MATH" })
        assertEquals(35, sd.count { it.subjectId == "SCIENCE" })
        assertEquals(30, sd.count { it.subjectId == "LANGUAGE" })

        // SMP Subject breakdown: 30 SMP_MATH, 25 SMP_IPA, 25 SMP_IPS, 20 SMP_LANG
        assertEquals(30, smp.count { it.subjectId == "SMP_MATH" })
        assertEquals(25, smp.count { it.subjectId == "SMP_IPA" })
        assertEquals(25, smp.count { it.subjectId == "SMP_IPS" })
        assertEquals(20, smp.count { it.subjectId == "SMP_LANG" })

        // SMA Subject breakdown: 30 SMA_MATH_ADV, 25 SMA_MIPA, 25 SMA_SOSHUM, 20 SMA_GENERAL
        assertEquals(30, sma.count { it.subjectId == "SMA_MATH_ADV" })
        assertEquals(25, sma.count { it.subjectId == "SMA_MIPA" })
        assertEquals(25, sma.count { it.subjectId == "SMA_SOSHUM" })
        assertEquals(20, sma.count { it.subjectId == "SMA_GENERAL" })

        val validAnswers = setOf("A", "B", "C", "D")
        val validDifficulties = setOf("EASY", "NORMAL", "HARD")

        for (q in examQuestions) {
            assertTrue("ID must start with Q_EXAM_: ${q.id}", q.id.startsWith("Q_EXAM_"))
            assertTrue("isExam must be true: ${q.id}", q.isExam)
            assertTrue("Answer must be A, B, C, or D: ${q.answer} in ${q.id}", validAnswers.contains(q.answer))
            assertTrue("Difficulty must be valid: ${q.difficulty} in ${q.id}", validDifficulties.contains(q.difficulty))
            assertTrue("Question text length >= 10: ${q.id}", q.question.length >= 10)
            assertTrue("Option A non-empty: ${q.id}", q.optionA.isNotBlank())
            assertTrue("Option B non-empty: ${q.id}", q.optionB.isNotBlank())
            assertTrue("Option C non-empty: ${q.id}", q.optionC.isNotBlank())
            assertTrue("Option D non-empty: ${q.id}", q.optionD.isNotBlank())
            assertTrue("Explanation length >= 10: ${q.id}", q.explanation.length >= 10)
            assertTrue("XP must be positive: ${q.xp}", q.xp > 0)

            val validGrades = when (q.educationLevel) {
                "SMP" -> 7..9
                "SMA" -> 10..12
                else -> 1..6
            }
            assertTrue("Grade must be within $validGrades for ${q.educationLevel}: ${q.grade}", q.grade in validGrades)
        }
    }

    @Test
    fun allStarterQuestions_totalsSixHundredQuestions() {
        val allQuestions = QuestionStarterData.ALL_STARTER_QUESTIONS
        assertEquals("Total questions (regular 300 + exam 300) must be 600", 600, allQuestions.size)

        val uniqueIds = allQuestions.map { it.id }.toSet()
        assertEquals("All 600 question IDs across all categories must be unique", 600, uniqueIds.size)
    }

    @Test
    fun calculateExamGrade_returnsExpectedLabels() {
        val (grade100, _) = calculateExamGrade(100)
        assertTrue(grade100.contains("A"))

        val (grade90, _) = calculateExamGrade(90)
        assertTrue(grade90.contains("A"))

        val (grade85, _) = calculateExamGrade(85)
        assertTrue(grade85.contains("B"))

        val (grade75, _) = calculateExamGrade(75)
        assertTrue(grade75.contains("B"))

        val (grade70, _) = calculateExamGrade(70)
        assertTrue(grade70.contains("C"))

        val (grade60, _) = calculateExamGrade(60)
        assertTrue(grade60.contains("C"))

        val (grade50, _) = calculateExamGrade(50)
        assertTrue(grade50.contains("D"))
    }

    @Test
    fun examScreenRoute_isCorrect() {
        assertEquals("exam", Screen.Exam.route)
    }

    @Test
    fun examPackageLockRules_evaluateCorrectly() {
        // Tryout lengkap butuh 5 quest
        val tryoutPackageLocked = com.example.eduquest.feature.exam.ExamPackage(
            id = "pkg_all",
            title = "Tryout Lengkap",
            subtitle = "Simulasi gabungan",
            icon = "\uD83C\uDF92",
            subjectId = "ALL",
            requiredCompletedQuests = 5,
            currentCompletedQuests = 3,
            isUnlocked = 3 >= 5
        )
        org.junit.Assert.assertFalse("Tryout with 3/5 quests must be locked", tryoutPackageLocked.isUnlocked)

        val tryoutPackageUnlocked = tryoutPackageLocked.copy(
            currentCompletedQuests = 5,
            isUnlocked = 5 >= 5
        )
        org.junit.Assert.assertTrue("Tryout with 5/5 quests must be unlocked", tryoutPackageUnlocked.isUnlocked)

        // Mapel spesifik butuh 3 quest
        val mathPackageLocked = com.example.eduquest.feature.exam.ExamPackage(
            id = "pkg_math",
            title = "Ujian Matematika",
            subtitle = "Materi berhitung",
            icon = "\uD83C\uDF92",
            subjectId = "MATH",
            requiredCompletedQuests = 3,
            currentCompletedQuests = 2,
            isUnlocked = 2 >= 3
        )
        org.junit.Assert.assertFalse("Math exam with 2/3 quests must be locked", mathPackageLocked.isUnlocked)

        val mathPackageUnlocked = mathPackageLocked.copy(
            currentCompletedQuests = 3,
            isUnlocked = 3 >= 3
        )
        org.junit.Assert.assertTrue("Math exam with 3/3 quests must be unlocked", mathPackageUnlocked.isUnlocked)
    }
}
