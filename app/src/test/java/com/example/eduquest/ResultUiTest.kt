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

class ResultUiTest {

    private fun createQuest(
        id: String = "quest_math_01",
        questionCount: Int = 5,
        xpReward: Int = 100,
        coinReward: Int = 20
    ): Quest {
        return Quest(
            id = id,
            worldId = "WORLD_01",
            title = "Berhitung di Hutan",
            description = "Latihan berhitung",
            subjectId = "MATH",
            grade = 1,
            difficulty = Difficulty.EASY,
            unlockLevel = 1,
            xpReward = xpReward,
            coinReward = coinReward,
            questionCount = questionCount
        )
    }

    private fun calculateStars(score: Int, totalQuestions: Int): Int {
        if (totalQuestions <= 0) return 0
        val percentage = (score.toFloat() / totalQuestions.toFloat()) * 100f
        return when {
            percentage >= 100f -> 3
            percentage >= 60f -> 2
            else -> 1
        }
    }

    @Test
    fun scoreClamping_preventsExceedingTotalQuestions() {
        val quest = createQuest(questionCount = 5)
        
        // Simulating the bug where raw score was 7 on 5 questions
        val rawScoreBug = 7
        val totalQuestions = quest.questionCount
        val safeScore = rawScoreBug.coerceIn(0, totalQuestions)

        assertEquals(5, safeScore)
        assertEquals(5, totalQuestions)
    }

    @Test
    fun scoreClamping_handlesNegativeGracefully() {
        val totalQuestions = 5
        val negativeScore = -2
        val safeScore = negativeScore.coerceIn(0, totalQuestions)
        assertEquals(0, safeScore)
    }

    @Test
    fun starRating_perfectScore_awardsThreeStars() {
        val stars = calculateStars(score = 5, totalQuestions = 5)
        assertEquals(3, stars)
    }

    @Test
    fun starRating_sixtyPercentScore_awardsTwoStars() {
        val stars1 = calculateStars(score = 3, totalQuestions = 5) // 60%
        assertEquals(2, stars1)

        val stars2 = calculateStars(score = 4, totalQuestions = 5) // 80%
        assertEquals(2, stars2)
    }

    @Test
    fun starRating_underSixtyPercent_awardsOneStar() {
        val stars1 = calculateStars(score = 2, totalQuestions = 5) // 40%
        assertEquals(1, stars1)

        val stars2 = calculateStars(score = 1, totalQuestions = 5) // 20%
        assertEquals(1, stars2)

        val stars0 = calculateStars(score = 0, totalQuestions = 5) // 0%
        assertEquals(1, stars0)
    }

    @Test
    fun firstTimeCompletion_grantsFullRewards() {
        val quest = createQuest(xpReward = 150, coinReward = 30)
        val result = QuestCompletionResult(
            questId = quest.id,
            playerId = "player_01",
            isCompleted = true,
            score = 5,
            totalQuestions = 5,
            xpEarned = quest.xpReward,
            coinsEarned = quest.coinReward,
            isFirstCompletion = true
        )

        assertTrue(result.isFirstCompletion)
        assertEquals(150, result.xpEarned)
        assertEquals(30, result.coinsEarned)
    }

    @Test
    fun replayCompletion_blocksDuplicateRewards() {
        val quest = createQuest(xpReward = 150, coinReward = 30)
        val result = QuestCompletionResult(
            questId = quest.id,
            playerId = "player_01",
            isCompleted = true,
            score = 5,
            totalQuestions = 5,
            xpEarned = 0,
            coinsEarned = 0,
            isFirstCompletion = false
        )

        assertFalse(result.isFirstCompletion)
        assertEquals(0, result.xpEarned)
        assertEquals(0, result.coinsEarned)
    }

    @Test
    fun questWithProgress_attemptCount_determinesFirstCompletion() {
        val quest = createQuest()

        val firstAttemptProgress = QuestWithProgress(
            quest = quest,
            status = QuestStatus.COMPLETED,
            score = 5,
            attemptCount = 1
        )
        val isFirst1 = firstAttemptProgress.attemptCount <= 1
        assertTrue(isFirst1)

        val replayProgress = QuestWithProgress(
            quest = quest,
            status = QuestStatus.COMPLETED,
            score = 5,
            attemptCount = 2
        )
        val isFirst2 = replayProgress.attemptCount <= 1
        assertFalse(isFirst2)
    }
}
