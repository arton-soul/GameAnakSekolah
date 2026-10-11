package com.example.eduquest

import com.example.eduquest.domain.model.DailyMission
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.feature.home.HomeUiState
import com.example.eduquest.feature.home.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeUiTest {

    private fun createDummyQuest(id: String, status: QuestStatus): QuestWithProgress {
        val quest = Quest(
            id = id,
            worldId = "WORLD_01",
            title = "Test Quest $id",
            description = "Desc",
            subjectId = "MATH",
            grade = 1,
            difficulty = Difficulty.EASY,
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        )
        return QuestWithProgress(
            quest = quest,
            status = status,
            score = 0
        )
    }

    @Test
    fun continueQuest_prefersInProgressQuest() {
        val q1 = createDummyQuest("q1", QuestStatus.AVAILABLE)
        val q2 = createDummyQuest("q2", QuestStatus.IN_PROGRESS)
        val q3 = createDummyQuest("q3", QuestStatus.COMPLETED)

        val selected = HomeViewModel.selectContinueQuest(listOf(q1, q2, q3))
        assertNotNull(selected)
        assertEquals("q2", selected?.quest?.id)
    }

    @Test
    fun continueQuest_fallbackToFirstAvailableQuest() {
        val q1 = createDummyQuest("q1", QuestStatus.AVAILABLE)
        val q2 = createDummyQuest("q2", QuestStatus.LOCKED)
        val q3 = createDummyQuest("q3", QuestStatus.COMPLETED)

        val selected = HomeViewModel.selectContinueQuest(listOf(q1, q2, q3))
        assertNotNull(selected)
        assertEquals("q1", selected?.quest?.id)
    }

    @Test
    fun continueQuest_fallbackToFirstCompletedQuestWhenNoOthers() {
        val q1 = createDummyQuest("q1", QuestStatus.COMPLETED)
        val q2 = createDummyQuest("q2", QuestStatus.LOCKED)

        val selected = HomeViewModel.selectContinueQuest(listOf(q1, q2))
        assertNotNull(selected)
        assertEquals("q1", selected?.quest?.id)
    }

    @Test
    fun continueQuest_returnsNullWhenEmpty() {
        val selected = HomeViewModel.selectContinueQuest(emptyList())
        assertNull(selected)
    }

    @Test
    fun dailyMissionSummary_emptyList_returnsZero() {
        val summary = HomeViewModel.buildDailySummary(emptyList())
        assertEquals(0, summary.totalMissions)
        assertEquals(0, summary.completedCount)
        assertEquals(0f, summary.progressRatio)
        assertFalse(summary.allCompleted)
    }

    @Test
    fun dailyMissionSummary_calculatesRatioAndRewardsCorrectly() {
        val m1 = DailyMission(
            id = "m1",
            title = "M1",
            description = "Desc",
            category = "ANY",
            targetCount = 1,
            rewardXp = 100,
            rewardCoins = 10
        )
        val m2 = DailyMission(
            id = "m2",
            title = "M2",
            description = "Desc",
            category = "MATH",
            targetCount = 2,
            rewardXp = 200,
            rewardCoins = 40
        )

        val missions = listOf(
            DailyMissionWithProgress(
                mission = m1,
                dateString = "2026-10-08",
                currentProgress = 1,
                isCompleted = true,
                isClaimed = false
            ),
            DailyMissionWithProgress(
                mission = m2,
                dateString = "2026-10-08",
                currentProgress = 1,
                isCompleted = false,
                isClaimed = false
            )
        )

        val summary = HomeViewModel.buildDailySummary(missions)
        assertEquals(2, summary.totalMissions)
        assertEquals(1, summary.completedCount)
        assertEquals(0.5f, summary.progressRatio, 0.01f)
        assertEquals(300, summary.totalXpReward)
        assertEquals(50, summary.totalCoinsReward)
        assertTrue(summary.hasUnclaimedReward)
    }

    @Test
    fun streakDays_todayActive_countsConsecutiveDays() {
        val activeDates = listOf("2026-10-08", "2026-10-07", "2026-10-06")
        val streak = HomeViewModel.calculateStreakDays(activeDates, "2026-10-08")
        assertEquals(3, streak)
    }

    @Test
    fun streakDays_yesterdayActive_countsConsecutiveDays() {
        val activeDates = listOf("2026-10-07", "2026-10-06")
        val streak = HomeViewModel.calculateStreakDays(activeDates, "2026-10-08")
        assertEquals(2, streak)
    }

    @Test
    fun streakDays_gapInDays_resetsToStreak() {
        val activeDates = listOf("2026-10-08", "2026-10-05")
        val streak = HomeViewModel.calculateStreakDays(activeDates, "2026-10-08")
        assertEquals(1, streak)
    }

    @Test
    fun homeUiState_initialDefaultsAreSafe() {
        val state = HomeUiState()
        assertTrue(state.isLoading)
        assertNull(state.player)
        assertFalse(state.hasPlayer)
        assertEquals(1, state.streakDays)
        assertNull(state.continueQuest)
        assertEquals(0, state.dailyMissionSummary.totalMissions)
    }
}
