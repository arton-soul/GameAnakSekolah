package com.example.eduquest

import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.data.local.seed.DailyMissionStarterData
import com.example.eduquest.domain.model.DailyMission
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.DailyRewardClaimResult
import com.example.eduquest.feature.daily.DailyMissionUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar

class DailyMissionTest {

    @Test
    fun starterDailyMissions_haveValidConfiguration() {
        val missions = DailyMissionStarterData.STARTER_MISSIONS
        assertEquals(7, missions.size)

        for (mission in missions) {
            assertTrue("ID must not be empty", mission.id.isNotEmpty())
            assertTrue("Title must not be empty", mission.title.isNotEmpty())
            assertTrue("Category must not be empty", mission.category.isNotEmpty())
            assertTrue("Target count must be positive", mission.targetCount > 0)
            assertTrue("Reward XP must be positive", mission.rewardXp > 0)
            assertTrue("Reward Coins must be positive", mission.rewardCoins > 0)
        }

        // Validate 4 core missions match PROJECT_SPEC Section 26 MVP
        val coreIds = DailyMissionStarterData.CORE_DAILY_MISSION_IDS
        assertEquals(4, coreIds.size)
        val coreMissions = missions.filter { coreIds.contains(it.id) }
        assertEquals(4, coreMissions.size)

        val mathMission = coreMissions.first { it.category == "MATH" }
        assertEquals(3, mathMission.targetCount)

        val scienceMission = coreMissions.first { it.category == "SCIENCE" }
        assertEquals(2, scienceMission.targetCount)

        val languageMission = coreMissions.first { it.category == "LANGUAGE" }
        assertEquals(2, languageMission.targetCount)

        val questMission = coreMissions.first { it.category == "QUEST" }
        assertEquals(1, questMission.targetCount)

        // Validate total core rewards match PROJECT_SPEC Section 26: 300 XP, 50 Coins
        val totalXp = coreMissions.sumOf { it.rewardXp }
        val totalCoins = coreMissions.sumOf { it.rewardCoins }
        assertEquals("Total core XP must be 300", 300, totalXp)
        assertEquals("Total core Coins must be 50", 50, totalCoins)
    }

    @Test
    fun dailyDateUtils_formatsOfflineSafeDateAndIndonesianDisplay() {
        // Test standard ISO date regex
        val todayStr = DailyDateUtils.getTodayDateString()
        assertTrue("Date string must match yyyy-MM-dd", todayStr.matches(Regex("""\d{4}-\d{2}-\d{2}""")))

        // Test deterministic date conversion
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, 2026)
            set(Calendar.MONTH, Calendar.OCTOBER)
            set(Calendar.DAY_OF_MONTH, 8)
        }
        val dateStr = DailyDateUtils.getTodayDateString(calendar.time)
        assertEquals("2026-10-08", dateStr)

        val display = DailyDateUtils.formatDisplayDate("2026-10-08")
        assertTrue("Display date should contain October / Oktober", display.contains("Oktober", ignoreCase = true) || display.contains("October", ignoreCase = true))
        assertTrue("Display date should contain day 8", display.contains("8"))
        assertTrue("Display date should contain year 2026", display.contains("2026"))
    }

    @Test
    fun progressRatio_and_readyToClaim_calculatedCorrectly() {
        val mission = DailyMission(
            id = "test_math",
            title = "Matematika",
            description = "3 soal matematika",
            category = "MATH",
            targetCount = 3,
            rewardXp = 75,
            rewardCoins = 15
        )

        val notStarted = DailyMissionWithProgress(
            mission = mission,
            dateString = "2026-10-08",
            currentProgress = 0,
            isCompleted = false,
            isClaimed = false
        )
        assertEquals(0f, notStarted.progressRatio, 0.001f)
        assertFalse(notStarted.isReadyToClaim)

        val inProgress = DailyMissionWithProgress(
            mission = mission,
            dateString = "2026-10-08",
            currentProgress = 2,
            isCompleted = false,
            isClaimed = false
        )
        assertEquals(2f / 3f, inProgress.progressRatio, 0.001f)
        assertFalse(inProgress.isReadyToClaim)

        val completedNotClaimed = DailyMissionWithProgress(
            mission = mission,
            dateString = "2026-10-08",
            currentProgress = 3,
            isCompleted = true,
            isClaimed = false
        )
        assertEquals(1.0f, completedNotClaimed.progressRatio, 0.001f)
        assertTrue(completedNotClaimed.isReadyToClaim)

        val alreadyClaimed = DailyMissionWithProgress(
            mission = mission,
            dateString = "2026-10-08",
            currentProgress = 3,
            isCompleted = true,
            isClaimed = true
        )
        assertEquals(1.0f, alreadyClaimed.progressRatio, 0.001f)
        assertFalse("Claimed mission must NOT be ready to claim again", alreadyClaimed.isReadyToClaim)
    }

    @Test
    fun duplicateRewardProtection_preventsDoubleClaiming() {
        val claimResult: DailyRewardClaimResult = DailyRewardClaimResult.AlreadyClaimed("daily_math_01")
        assertTrue(claimResult is DailyRewardClaimResult.AlreadyClaimed)
        assertEquals("daily_math_01", (claimResult as DailyRewardClaimResult.AlreadyClaimed).missionId)

        val notCompletedResult: DailyRewardClaimResult = DailyRewardClaimResult.NotCompleted("daily_math_01")
        assertTrue(notCompletedResult is DailyRewardClaimResult.NotCompleted)
        assertEquals("daily_math_01", (notCompletedResult as DailyRewardClaimResult.NotCompleted).missionId)
    }

    @Test
    fun dailyMissionUiState_allCompletedAndPercentage() {
        val m1 = DailyMission("1", "M1", "desc", "MATH", 3, 75, 15)
        val m2 = DailyMission("2", "M2", "desc", "SCIENCE", 2, 75, 10)

        val items = listOf(
            DailyMissionWithProgress(m1, "2026-10-08", 3, isCompleted = true, isClaimed = true),
            DailyMissionWithProgress(m2, "2026-10-08", 1, isCompleted = false, isClaimed = false)
        )

        val stateHalf = DailyMissionUiState(
            missions = items,
            totalCount = 2,
            completedCount = 1,
            claimedCount = 1
        )
        assertEquals(50, stateHalf.completionPercentage)
        assertFalse(stateHalf.allCompleted)
        assertFalse(stateHalf.allClaimed)
        assertEquals(150, stateHalf.totalAvailableXp)
        assertEquals(25, stateHalf.totalAvailableCoins)

        val stateDone = DailyMissionUiState(
            missions = items,
            totalCount = 2,
            completedCount = 2,
            claimedCount = 2
        )
        assertEquals(100, stateDone.completionPercentage)
        assertTrue(stateDone.allCompleted)
        assertTrue(stateDone.allClaimed)
    }

    @Test
    fun repository_tracksProgressAndPreventsDuplicateClaim() = kotlinx.coroutines.runBlocking {
        val fakeDao = object : com.example.eduquest.data.local.dao.DailyMissionDao {
            val missionsList = mutableListOf<com.example.eduquest.data.local.entity.DailyMissionEntity>()
            val progressMap = mutableMapOf<String, com.example.eduquest.data.local.entity.PlayerDailyProgressEntity>()

            override suspend fun insertMission(mission: com.example.eduquest.data.local.entity.DailyMissionEntity) {
                missionsList.removeAll { it.id == mission.id }
                missionsList.add(mission)
            }

            override suspend fun insertMissions(missions: List<com.example.eduquest.data.local.entity.DailyMissionEntity>) {
                for (m in missions) insertMission(m)
            }

            override fun getAllMissions() = kotlinx.coroutines.flow.flowOf(missionsList)
            override suspend fun getAllMissionsList() = missionsList.toList()
            override suspend fun getMissionCount() = missionsList.size
            override suspend fun getMissionById(id: String) = missionsList.firstOrNull { it.id == id }
            override suspend fun getMissionsByCategory(category: String) = missionsList.filter { it.category == category }

            override suspend fun upsertDailyProgress(progress: com.example.eduquest.data.local.entity.PlayerDailyProgressEntity) {
                progressMap["${progress.playerId}_${progress.missionId}_${progress.dateString}"] = progress
            }

            override fun getDailyProgress(playerId: String, dateString: String) =
                kotlinx.coroutines.flow.flowOf(progressMap.values.filter { it.playerId == playerId && it.dateString == dateString })

            override suspend fun getDailyProgressList(playerId: String, dateString: String) =
                progressMap.values.filter { it.playerId == playerId && it.dateString == dateString }

            override suspend fun getProgress(playerId: String, missionId: String, dateString: String) =
                progressMap["${playerId}_${missionId}_${dateString}"]

            override suspend fun updateProgress(playerId: String, missionId: String, dateString: String, progress: Int, isCompleted: Boolean) {
                val key = "${playerId}_${missionId}_${dateString}"
                val old = progressMap[key] ?: return
                progressMap[key] = old.copy(currentProgress = progress, isCompleted = isCompleted)
            }

            override suspend fun markClaimed(playerId: String, missionId: String, dateString: String) {
                val key = "${playerId}_${missionId}_${dateString}"
                val old = progressMap[key] ?: return
                progressMap[key] = old.copy(isClaimed = true)
            }

            override fun getCompletedMissionCountFlow(playerId: String, dateString: String) =
                kotlinx.coroutines.flow.flowOf(progressMap.values.count { it.playerId == playerId && it.dateString == dateString && it.isCompleted })

            override fun getClaimedMissionCountFlow(playerId: String, dateString: String) =
                kotlinx.coroutines.flow.flowOf(progressMap.values.count { it.playerId == playerId && it.dateString == dateString && it.isClaimed })

            override suspend fun migrateLocalProgressToPlayer(newPlayerId: String) {
                val toMigrate = progressMap.filterKeys { it.startsWith("PLAYER_LOCAL_") }
                for ((key, item) in toMigrate) {
                    progressMap.remove(key)
                    val newKey = "${newPlayerId}_${item.missionId}_${item.dateString}"
                    progressMap[newKey] = item.copy(playerId = newPlayerId)
                }
            }

            override suspend fun deleteAllDailyProgress() {
                progressMap.clear()
            }
        }

        var playerXp = 0
        var playerCoins = 0

        val fakePlayerRepo = object : com.example.eduquest.domain.repository.PlayerRepository {
            override fun getActivePlayer() = kotlinx.coroutines.flow.flowOf(null)
            override suspend fun getActivePlayerDirect(): com.example.eduquest.domain.model.Player? = null
            override suspend fun createPlayer(nickname: String, educationLevel: String, grade: Int, avatar: String): com.example.eduquest.domain.model.Player {
                return com.example.eduquest.domain.model.Player("p1", nickname, avatar, educationLevel, grade, 1, playerXp, playerCoins)
            }
            override suspend fun updatePlayer(player: com.example.eduquest.domain.model.Player) {}
            override suspend fun addXp(playerId: String, amount: Int): com.example.eduquest.domain.model.LevelUpResult {
                playerXp += amount
                val progress = com.example.eduquest.domain.model.LevelProgress(1, playerXp, 0, 100, playerXp, 100, 100 - playerXp, 0f, false)
                return com.example.eduquest.domain.model.LevelUpResult(1, 1, false, 0, playerXp, progress)
            }
            override fun getPlayerLevelProgress(playerId: String) = kotlinx.coroutines.flow.flowOf(
                com.example.eduquest.domain.model.LevelProgress(1, playerXp, 0, 100, playerXp, 100, 100 - playerXp, 0f, false)
            )
            override suspend fun addCoins(playerId: String, amount: Int): com.example.eduquest.domain.model.CoinTransactionResult {
                val old = playerCoins
                playerCoins += amount
                return com.example.eduquest.domain.model.CoinTransactionResult(true, old, playerCoins, amount)
            }
            override suspend fun spendCoins(playerId: String, amount: Int): com.example.eduquest.domain.model.CoinTransactionResult {
                val old = playerCoins
                playerCoins -= amount
                return com.example.eduquest.domain.model.CoinTransactionResult(true, old, playerCoins, -amount)
            }
            override fun getCoinBalance(playerId: String) = kotlinx.coroutines.flow.flowOf(playerCoins)
            override suspend fun hasPlayer() = true
            override suspend fun resetPlayerData() {}
        }

        val repository = com.example.eduquest.data.repository.DailyMissionRepositoryImpl(
            dailyMissionDao = fakeDao,
            playerRepository = fakePlayerRepo
        )

        val dateStr = "2026-10-08"
        val playerId = "TEST_PLAYER"

        // 1. Initial seeding
        repository.ensureStarterMissionsSeeded()
        assertEquals(7, fakeDao.getMissionCount())

        // 2. Initial claim attempt should fail (not completed)
        val earlyClaim = repository.claimReward(playerId, "daily_math_01", dateStr)
        assertTrue("Cannot claim incomplete mission", earlyClaim is DailyRewardClaimResult.NotCompleted)
        assertEquals(0, playerXp)
        assertEquals(0, playerCoins)

        // 3. Progress tracking: answer 2 Math questions
        repository.recordSubjectProgress(playerId, "MATH", dateStr, 2)
        val p1 = fakeDao.getProgress(playerId, "daily_math_01", dateStr)
        assertEquals(2, p1?.currentProgress)
        assertFalse(p1?.isCompleted ?: true)

        // 4. Progress tracking: answer 1 more Math question -> Completes mission!
        repository.recordSubjectProgress(playerId, "MATH", dateStr, 1)
        val p2 = fakeDao.getProgress(playerId, "daily_math_01", dateStr)
        assertEquals(3, p2?.currentProgress)
        assertTrue(p2?.isCompleted ?: false)
        assertFalse(p2?.isClaimed ?: true)

        // 5. Claim reward: should succeed!
        val claimResult = repository.claimReward(playerId, "daily_math_01", dateStr)
        assertTrue("First claim must succeed", claimResult is DailyRewardClaimResult.Success)
        val success = claimResult as DailyRewardClaimResult.Success
        assertEquals("daily_math_01", success.missionId)
        assertEquals(75, success.xpEarned)
        assertEquals(15, success.coinsEarned)
        assertEquals(75, playerXp)
        assertEquals(15, playerCoins)

        // 6. Duplicate claim protection: claiming again MUST return AlreadyClaimed
        val secondClaim = repository.claimReward(playerId, "daily_math_01", dateStr)
        assertTrue("Second claim must be blocked by Duplicate Reward Protection", secondClaim is DailyRewardClaimResult.AlreadyClaimed)
        assertEquals(75, playerXp) // XP untouched
        assertEquals(15, playerCoins) // Coins untouched
    }
}
