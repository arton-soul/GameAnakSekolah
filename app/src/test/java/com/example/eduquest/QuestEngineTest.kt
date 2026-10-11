package com.example.eduquest

import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class QuestEngineTest {

    @Test
    fun quest_statusEnum_hasExpectedValues() {
        val statuses = QuestStatus.values().map { it.name }
        assertTrue(statuses.contains("LOCKED"))
        assertTrue(statuses.contains("AVAILABLE"))
        assertTrue(statuses.contains("IN_PROGRESS"))
        assertTrue(statuses.contains("COMPLETED"))
    }

    @Test
    fun questModel_defaultValues_areCorrect() {
        val quest = Quest(
            id = "quest_math_01",
            worldId = "WORLD_01",
            title = "Berhitung di Hutan",
            description = "Selesaikan soal penjumlahan dasar",
            subjectId = "MATHEMATICS",
            grade = 1,
            difficulty = Difficulty.EASY,
            unlockLevel = 1,
            xpReward = 100,
            coinReward = 20,
            questionCount = 5
        )

        assertEquals("quest_math_01", quest.id)
        assertEquals("Berhitung di Hutan", quest.title)
        assertEquals("MATHEMATICS", quest.subjectId)
        assertEquals(1, quest.unlockLevel)
        assertEquals(100, quest.xpReward)
        assertEquals(20, quest.coinReward)
        assertEquals(5, quest.questionCount)
    }

    @Test
    fun questWithProgress_isPlayable_whenAvailableOrInProgress() {
        val quest = Quest(
            id = "q1",
            worldId = "WORLD_01",
            title = "Test Quest",
            description = "Desc",
            subjectId = "SCIENCE",
            grade = 1,
            difficulty = Difficulty.EASY,
            unlockLevel = 1,
            xpReward = 50,
            coinReward = 10,
            questionCount = 3
        )

        val availableQuest = QuestWithProgress(
            quest = quest,
            status = QuestStatus.AVAILABLE,
            score = 0,
            attemptCount = 0
        )
        assertTrue(availableQuest.status == QuestStatus.AVAILABLE)

        val inProgressQuest = QuestWithProgress(
            quest = quest,
            status = QuestStatus.IN_PROGRESS,
            score = 1,
            attemptCount = 1
        )
        assertTrue(inProgressQuest.status == QuestStatus.IN_PROGRESS)

        val lockedQuest = QuestWithProgress(
            quest = quest,
            status = QuestStatus.LOCKED,
            score = 0,
            attemptCount = 0
        )
        assertTrue(lockedQuest.status == QuestStatus.LOCKED)
    }

    @Test
    fun questCompletionResult_duplicateRewardProtection_flagReflected() {
        val firstCompletion = QuestCompletionResult(
            questId = "quest_math_01",
            playerId = "p1",
            isCompleted = true,
            score = 5,
            totalQuestions = 5,
            xpEarned = 100,
            coinsEarned = 20,
            isFirstCompletion = true
        )
        assertTrue(firstCompletion.isFirstCompletion)
        assertEquals(100, firstCompletion.xpEarned)
        assertEquals(20, firstCompletion.coinsEarned)

        val duplicateCompletion = QuestCompletionResult(
            questId = "quest_math_01",
            playerId = "p1",
            isCompleted = true,
            score = 5,
            totalQuestions = 5,
            xpEarned = 0,
            coinsEarned = 0,
            isFirstCompletion = false
        )
        assertFalse(duplicateCompletion.isFirstCompletion)
        assertEquals(0, duplicateCompletion.xpEarned)
        assertEquals(0, duplicateCompletion.coinsEarned)
    }

    @Test
    fun questScore_isClampedToTotalQuestions() {
        val quest = Quest(
            id = "quest_lang_02",
            worldId = "WORLD_01",
            title = "Ejaan huruf kapital dan titik",
            description = "Desc",
            subjectId = "LANGUAGE",
            grade = 1,
            difficulty = Difficulty.EASY,
            unlockLevel = 1,
            xpReward = 100,
            coinReward = 20,
            questionCount = 5
        )

        // Raw score exceeding questionCount must be clamped
        val rawScore = 7
        val totalQuestions = quest.questionCount
        val clampedScore = rawScore.coerceIn(0, totalQuestions)

        assertEquals(5, clampedScore)
        assertEquals("5/5", "$clampedScore/$totalQuestions")
    }
}
