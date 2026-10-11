package com.example.eduquest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.eduquest.data.local.database.EduQuestDatabase
import com.example.eduquest.data.local.entity.AchievementEntity
import com.example.eduquest.data.local.entity.DailyMissionEntity
import com.example.eduquest.data.local.entity.KnowledgeCardEntity
import com.example.eduquest.data.local.entity.PlayerAchievementEntity
import com.example.eduquest.data.local.entity.PlayerCardEntity
import com.example.eduquest.data.local.entity.PlayerDailyProgressEntity
import com.example.eduquest.data.local.entity.PlayerEntity
import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestProgressEntity
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseFoundationTest {

    private lateinit var db: EduQuestDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, EduQuestDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testPlayerOperations() = runBlocking {
        val player = PlayerEntity(
            id = "player_test_01",
            nickname = "Budi Petualang",
            educationLevel = "SD",
            grade = 3,
            level = 1,
            xp = 100,
            coins = 50
        )

        db.playerDao().insertPlayer(player)
        val loaded = db.playerDao().getPlayerDirect("player_test_01")

        assertNotNull(loaded)
        assertEquals("Budi Petualang", loaded?.nickname)
        assertEquals(3, loaded?.grade)
        assertEquals(100, loaded?.xp)
        assertEquals(50, loaded?.coins)

        val updated = loaded!!.copy(xp = 250, level = 2)
        db.playerDao().updatePlayer(updated)

        val reloaded = db.playerDao().getPlayerDirect("player_test_01")
        assertEquals(250, reloaded?.xp)
        assertEquals(2, reloaded?.level)
    }

    @Test
    fun testPlayerRepositoryOperations() = runBlocking {
        val repo = PlayerRepositoryImpl(db.playerDao())

        // Initially no player
        assertEquals(false, repo.hasPlayer())

        // Create player
        val created = repo.createPlayer(
            nickname = "Aisyah",
            educationLevel = "SD",
            grade = 4,
            avatar = "avatar_kancil"
        )
        assertNotNull(created)
        assertEquals("Aisyah", created.nickname)
        assertEquals(4, created.grade)
        assertEquals(true, repo.hasPlayer())

        // Read active player
        val active = repo.getActivePlayer().first()
        assertNotNull(active)
        assertEquals("Aisyah", active?.nickname)

        // Update player
        repo.updatePlayer(active!!.copy(nickname = "Aisyah Juara", coins = 100))
        val updated = repo.getActivePlayerDirect()
        assertEquals("Aisyah Juara", updated?.nickname)
        assertEquals(100, updated?.coins)

        // Reset
        repo.resetPlayerData()
        assertEquals(false, repo.hasPlayer())
    }

    @Test
    fun testQuestOperations() = runBlocking {
        val quest = QuestEntity(
            id = "quest_math_01",
            worldId = "WORLD_01",
            title = "Berhitung Cepat",
            description = "Latihan penjumlahan dasar",
            subjectId = "MATH",
            grade = 1,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        )

        db.questDao().insertQuest(quest)
        val loaded = db.questDao().getQuestById("quest_math_01")

        assertNotNull(loaded)
        assertEquals("Berhitung Cepat", loaded?.title)
        assertEquals("MATH", loaded?.subjectId)
        assertEquals(150, loaded?.xpReward)
    }

    @Test
    fun testProgressOperations() = runBlocking {
        val progress = QuestProgressEntity(
            playerId = "player_01",
            questId = "quest_math_01",
            status = "AVAILABLE",
            score = 0,
            attemptCount = 0
        )

        db.progressDao().upsertQuestProgress(progress)
        val loaded = db.progressDao().getQuestProgress("player_01", "quest_math_01")

        assertNotNull(loaded)
        assertEquals("AVAILABLE", loaded?.status)
        assertEquals(0, loaded?.score)

        val updated = loaded!!.copy(status = "COMPLETED", score = 100, attemptCount = 1)
        db.progressDao().upsertQuestProgress(updated)

        val reloaded = db.progressDao().getQuestProgress("player_01", "quest_math_01")
        assertEquals("COMPLETED", reloaded?.status)
        assertEquals(100, reloaded?.score)
        assertEquals(1, reloaded?.attemptCount)
    }

    @Test
    fun testQuestionRepositoryOperations() = runBlocking {
        val questionRepo = com.example.eduquest.data.repository.QuestionRepositoryImpl(
            db.questionDao(),
            db.progressDao()
        )

        // Seed starter questions
        questionRepo.ensureStarterQuestionsSeeded()
        val count = db.questionDao().getQuestionCount()
        assertTrue(count >= 15)

        // Load questions for quest
        val questions = questionRepo.getQuestionsForQuest("quest_01", grade = 1)
        assertTrue(questions.isNotEmpty())
        assertEquals(1, questions.first().grade)

        // Record answer
        questionRepo.recordAnswer(
            playerId = "player_test_01",
            questId = "quest_01",
            questionId = questions.first().id,
            selectedAnswer = "B",
            isCorrect = true,
            xpEarned = 100
        )

        val historyList = db.progressDao().getAnswerHistory("player_test_01", "quest_01").first()
        assertEquals(1, historyList.size)
        assertEquals("B", historyList.first().selectedAnswer)
        assertTrue(historyList.first().isCorrect)
        assertEquals(100, historyList.first().xpEarned)
    }

    @Test
    fun testQuestRepositoryOperations() = runBlocking {
        val questRepo = com.example.eduquest.data.repository.QuestRepositoryImpl(
            db.questDao(),
            db.progressDao(),
            db.playerDao()
        )

        // Seed starter quests
        questRepo.ensureStarterQuestsSeeded()
        val questCount = db.questDao().getQuestCount()
        assertTrue("Starter quests should be seeded", questCount >= 9)

        // Create player
        val player = PlayerEntity(
            id = "player_quest_test",
            nickname = "Sang Penjelajah",
            level = 1,
            xp = 0,
            coins = 0
        )
        db.playerDao().insertPlayer(player)

        // Verify quest list with progress
        val quests = questRepo.getQuestsWithProgress("player_quest_test", subjectId = "MATH").first()
        assertTrue(quests.isNotEmpty())

        val mathQuest1 = quests.first { it.quest.id == "quest_math_01" }
        assertEquals(com.example.eduquest.domain.model.QuestStatus.AVAILABLE, mathQuest1.status)

        // Start quest
        questRepo.startQuest("player_quest_test", "quest_math_01")
        val inProgressDetail = questRepo.getQuestWithProgress("player_quest_test", "quest_math_01")
        assertNotNull(inProgressDetail)
        assertEquals(com.example.eduquest.domain.model.QuestStatus.IN_PROGRESS, inProgressDetail?.status)

        // Complete quest (first completion)
        val completion1 = questRepo.completeQuest(
            playerId = "player_quest_test",
            questId = "quest_math_01",
            score = 2,
            totalQuestions = 2
        )
        assertTrue(completion1.isFirstCompletion)
        assertEquals(150, completion1.xpEarned)
        assertEquals(20, completion1.coinsEarned)

        // Verify player received rewards
        val playerAfterReward = db.playerDao().getPlayerDirect("player_quest_test")
        assertEquals(150, playerAfterReward?.xp)
        assertEquals(20, playerAfterReward?.coins)

        // Complete quest again (replay) -> duplicate protection!
        val completion2 = questRepo.completeQuest(
            playerId = "player_quest_test",
            questId = "quest_math_01",
            score = 2,
            totalQuestions = 2
        )
        assertFalse(completion2.isFirstCompletion)
        assertEquals(0, completion2.xpEarned)
        assertEquals(0, completion2.coinsEarned)

        // Verify player did NOT receive duplicate rewards
        val playerAfterReplay = db.playerDao().getPlayerDirect("player_quest_test")
        assertEquals(150, playerAfterReplay?.xp)
        assertEquals(20, playerAfterReplay?.coins)
    }

    @Test
    fun testAchievementOperations() = runBlocking {
        val achievement = AchievementEntity(
            id = "ACH_TEST_01",
            title = "Pena Emas",
            description = "Selesaikan 1 quest bahasa",
            type = "QUEST_COUNT",
            target = 1,
            rewardXp = 100,
            rewardCoins = 20
        )
        db.achievementDao().insertAchievement(achievement)
        assertEquals(1, db.achievementDao().getAchievementCount())

        val list = db.achievementDao().getAllAchievementsList()
        assertEquals("ACH_TEST_01", list.first().id)

        // Player Achievement progress
        val playerAch = PlayerAchievementEntity(
            playerId = "player_test_01",
            achievementId = "ACH_TEST_01",
            progress = 1,
            unlocked = true,
            unlockedAt = System.currentTimeMillis()
        )
        db.achievementDao().upsertPlayerAchievement(playerAch)

        val loadedAch = db.achievementDao().getPlayerAchievement("player_test_01", "ACH_TEST_01")
        assertNotNull(loadedAch)
        assertTrue(loadedAch!!.unlocked)
        assertEquals(1, loadedAch.progress)

        val unlockedCount = db.achievementDao().getUnlockedCountFlow("player_test_01").first()
        assertEquals(1, unlockedCount)
    }

    @Test
    fun testDailyMissionOperations() = runBlocking {
        val mission = DailyMissionEntity(
            id = "DAILY_TEST_01",
            title = "Belajar Ceria",
            category = "MATH",
            targetCount = 3,
            rewardXp = 50,
            rewardCoins = 10
        )
        db.dailyMissionDao().insertMission(mission)
        assertEquals(1, db.dailyMissionDao().getMissionCount())

        val loadedMission = db.dailyMissionDao().getMissionById("DAILY_TEST_01")
        assertNotNull(loadedMission)
        assertEquals("MATH", loadedMission?.category)

        // Progress
        val progress = PlayerDailyProgressEntity(
            playerId = "player_test_01",
            missionId = "DAILY_TEST_01",
            dateString = "2026-10-09",
            currentProgress = 3,
            isCompleted = true,
            isClaimed = false
        )
        db.dailyMissionDao().upsertDailyProgress(progress)

        val completedCount = db.dailyMissionDao().getCompletedMissionCountFlow("player_test_01", "2026-10-09").first()
        assertEquals(1, completedCount)

        // Mark claimed
        db.dailyMissionDao().markClaimed("player_test_01", "DAILY_TEST_01", "2026-10-09")
        val claimedCount = db.dailyMissionDao().getClaimedMissionCountFlow("player_test_01", "2026-10-09").first()
        assertEquals(1, claimedCount)
    }

    @Test
    fun testKnowledgeCardOperations() = runBlocking {
        val card = KnowledgeCardEntity(
            id = "CARD_TEST_01",
            title = "Galaksi Bima Sakti",
            category = "SPACE",
            description = "Galaksi tempat bumi berada",
            fact = "Berisi miliaran bintang",
            imageAsset = "asset_galaxy",
            unlockCondition = "quest_science_01"
        )
        db.knowledgeCardDao().insertCard(card)
        assertEquals(1, db.knowledgeCardDao().getCardCount())

        val loadedCard = db.knowledgeCardDao().getCardById("CARD_TEST_01")
        assertNotNull(loadedCard)
        assertEquals("Galaksi Bima Sakti", loadedCard?.title)

        // Unlock for player
        val playerCard = PlayerCardEntity(
            playerId = "player_test_01",
            cardId = "CARD_TEST_01"
        )
        db.knowledgeCardDao().insertPlayerCard(playerCard)

        val unlockedCards = db.knowledgeCardDao().getUnlockedCardCountFlow("player_test_01").first()
        assertEquals(1, unlockedCards)
    }

    @Test
    fun testFullDatabaseReset() = runBlocking {
        // Insert sample player and progress
        db.playerDao().insertPlayer(
            PlayerEntity(id = "p_reset", nickname = "ResetMe", level = 5, xp = 1000, coins = 500)
        )
        db.progressDao().upsertQuestProgress(
            QuestProgressEntity(playerId = "p_reset", questId = "q_1", status = "COMPLETED", score = 5)
        )
        db.achievementDao().upsertPlayerAchievement(
            PlayerAchievementEntity(playerId = "p_reset", achievementId = "ach_1", unlocked = true)
        )
        db.knowledgeCardDao().insertPlayerCard(
            PlayerCardEntity(playerId = "p_reset", cardId = "c_1")
        )

        // Perform clean reset of player progress tables
        db.playerDao().deletePlayer("p_reset")
        db.progressDao().clearAllProgress()
        db.achievementDao().deleteAllPlayerAchievements()
        db.knowledgeCardDao().deleteAllPlayerCards()

        // Verify clean slate
        val player = db.playerDao().getPlayerDirect("p_reset")
        val progress = db.progressDao().getQuestProgress("p_reset", "q_1")
        val achList = db.achievementDao().getPlayerAchievementsList("p_reset")
        val cardList = db.knowledgeCardDao().getPlayerCardsList("p_reset")

        assertEquals(null, player)
        assertEquals(null, progress)
        assertTrue(achList.isEmpty())
        assertTrue(cardList.isEmpty())
    }
}
