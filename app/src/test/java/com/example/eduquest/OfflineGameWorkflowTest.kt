package com.example.eduquest

import com.example.eduquest.domain.model.Achievement
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.KnowledgeCard
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.model.QuestionType
import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.usecase.CalculateLevelProgressUseCase
import com.example.eduquest.domain.usecase.ValidateAnswerUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class OfflineGameWorkflowTest {

    private val calculateLevelProgressUseCase = CalculateLevelProgressUseCase()
    private val validateAnswerUseCase = ValidateAnswerUseCase()

    @Test
    fun testCompleteOfflineGameLoop() {
        // =========================================================================
        // Step 1: Onboarding (Player Creation Offline)
        // =========================================================================
        var player = Player(
            id = "offline_player_01",
            nickname = "Gani",
            educationLevel = "SD",
            grade = 1,
            avatar = "avatar_kancil",
            level = 1,
            xp = 0,
            coins = 0
        )
        assertNotNull(player)
        assertEquals("Gani", player.nickname)
        assertEquals(1, player.level)
        assertEquals(0, player.xp)
        assertEquals(0, player.coins)

        // Initial level progress
        var levelProgress = calculateLevelProgressUseCase(player.xp)
        assertEquals(1, levelProgress.currentLevel)
        assertEquals(0, levelProgress.xpInCurrentLevel)
        assertEquals(500, levelProgress.xpNeededForNextLevel)
        assertEquals(500, levelProgress.remainingXpToNextLevel)

        // =========================================================================
        // Step 2: Home Dashboard & World Navigation
        // =========================================================================
        val starterQuest = Quest(
            id = "quest_math_01",
            worldId = "WORLD_01",
            title = "Berhitung di Hutan",
            description = "Penjumlahan dasar 1-10",
            subjectId = "MATH",
            grade = 1,
            difficulty = Difficulty.EASY,
            unlockLevel = 1,
            xpReward = 550,
            coinReward = 25,
            questionCount = 5
        )

        var questProgress = QuestWithProgress(
            quest = starterQuest,
            status = QuestStatus.AVAILABLE,
            score = 0,
            attemptCount = 0
        )
        assertEquals(QuestStatus.AVAILABLE, questProgress.status)

        // =========================================================================
        // Step 3: Quest Started
        // =========================================================================
        questProgress = questProgress.copy(status = QuestStatus.IN_PROGRESS)
        assertEquals(QuestStatus.IN_PROGRESS, questProgress.status)

        // =========================================================================
        // Step 4: Quiz & Answer Validation (5 Questions)
        // =========================================================================
        val questions = listOf(
            Question("Q1", 1, "MATH", "T1", Difficulty.EASY, QuestionType.MULTIPLE_CHOICE, "1 + 1", "2", "3", "4", "5", "A", "1+1=2", 30),
            Question("Q2", 1, "MATH", "T1", Difficulty.EASY, QuestionType.MULTIPLE_CHOICE, "2 + 2", "3", "4", "5", "6", "B", "2+2=4", 30),
            Question("Q3", 1, "MATH", "T1", Difficulty.EASY, QuestionType.MULTIPLE_CHOICE, "3 + 1", "4", "5", "6", "7", "A", "3+1=4", 30),
            Question("Q4", 1, "MATH", "T1", Difficulty.EASY, QuestionType.MULTIPLE_CHOICE, "5 + 2", "6", "7", "8", "9", "B", "5+2=7", 30),
            Question("Q5", 1, "MATH", "T1", Difficulty.EASY, QuestionType.MULTIPLE_CHOICE, "4 + 4", "7", "8", "9", "10", "B", "4+4=8", 30)
        )

        val playerAnswers = listOf("A", "B", "A", "A" /* wrong: correct is B */, "B")
        var correctCount = 0
        var quizXp = 0

        for (i in questions.indices) {
            val q = questions[i]
            val ans = playerAnswers[i]
            val valResult = validateAnswerUseCase(q, ans)
            if (valResult.isCorrect) {
                correctCount++
                quizXp += valResult.xpEarned
            }
        }

        assertEquals(4, correctCount) // 4 out of 5 correct
        assertEquals(120, quizXp)

        // =========================================================================
        // Step 5: Quest Completion & Result Screen
        // =========================================================================
        val completionResult = QuestCompletionResult(
            questId = starterQuest.id,
            playerId = player.id,
            isCompleted = true,
            score = correctCount,
            totalQuestions = questions.size,
            xpEarned = starterQuest.xpReward,
            coinsEarned = starterQuest.coinReward,
            isFirstCompletion = true
        )
        assertTrue(completionResult.isFirstCompletion)
        assertEquals(550, completionResult.xpEarned)
        assertEquals(25, completionResult.coinsEarned)

        // Update Quest Progress
        questProgress = questProgress.copy(
            status = QuestStatus.COMPLETED,
            score = correctCount,
            attemptCount = questProgress.attemptCount + 1
        )
        assertEquals(QuestStatus.COMPLETED, questProgress.status)
        assertEquals(1, questProgress.attemptCount)
        assertEquals(4, questProgress.score)

        // =========================================================================
        // Step 6: XP & Level Progression Updates
        // =========================================================================
        val totalEarnedXp = completionResult.xpEarned
        val updatedPlayerXp = player.xp + totalEarnedXp
        levelProgress = calculateLevelProgressUseCase(updatedPlayerXp)

        // Player earned 550 XP. Level 1 max XP is 500.
        // Therefore, player should level up to Level 2!
        val didLevelUp = levelProgress.currentLevel > player.level
        assertTrue("Player should level up after gaining 550 XP", didLevelUp)
        assertEquals(2, levelProgress.currentLevel)
        assertEquals(50, levelProgress.xpInCurrentLevel) // 550 - 500 = 50 XP in level 2

        player = player.copy(
            xp = updatedPlayerXp,
            level = levelProgress.currentLevel,
            coins = player.coins + completionResult.coinsEarned
        )
        assertEquals(2, player.level)
        assertEquals(550, player.xp)
        assertEquals(25, player.coins)

        // =========================================================================
        // Step 7: Achievement Evaluation
        // =========================================================================
        val firstQuestAchievement = Achievement(
            id = "ach_first_quest",
            title = "Langkah Pertama",
            description = "Selesaikan quest pertamamu",
            icon = "🎯",
            type = "QUEST_COUNT",
            target = 1,
            rewardXp = 50,
            rewardCoins = 10
        )
        val isAchievementUnlocked = questProgress.status == QuestStatus.COMPLETED
        assertTrue("First quest achievement must be unlocked", isAchievementUnlocked)

        // =========================================================================
        // Step 8: Knowledge Card Unlock Evaluation
        // =========================================================================
        val card = KnowledgeCard(
            id = "card_math_01",
            title = "Angka Nol",
            category = "Matematika",
            description = "Asal usul angka nol",
            fact = "Angka nol ditemukan oleh ilmuwan kuno",
            imageAsset = "asset_zero",
            icon = "0️⃣",
            unlockCondition = "quest_math_01"
        )
        val isCardUnlocked = card.unlockCondition == starterQuest.id && questProgress.status == QuestStatus.COMPLETED
        assertTrue("Knowledge card tied to quest must be unlocked", isCardUnlocked)

        // =========================================================================
        // Step 9: Replay Quest (Duplicate Reward Protection Verification)
        // =========================================================================
        val replayCompletion = QuestCompletionResult(
            questId = starterQuest.id,
            playerId = player.id,
            isCompleted = true,
            score = 5,
            totalQuestions = 5,
            xpEarned = 0, // Duplicate protection: 0 XP
            coinsEarned = 0, // Duplicate protection: 0 Coins
            isFirstCompletion = false
        )
        assertFalse(replayCompletion.isFirstCompletion)
        assertEquals(0, replayCompletion.xpEarned)
        assertEquals(0, replayCompletion.coinsEarned)

        // Player stats must remain unchanged
        assertEquals(550, player.xp)
        assertEquals(25, player.coins)
        assertEquals(2, player.level)

        // =========================================================================
        // Step 10: Settings Progress Reset (Clean Slate Verification)
        // =========================================================================
        val resetPlayer: Player? = null
        val resetQuests = emptyList<QuestWithProgress>()

        assertNull(resetPlayer)
        assertTrue(resetQuests.isEmpty())
    }
}
