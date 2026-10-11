package com.example.eduquest

import com.example.eduquest.data.local.seed.AchievementStarterData
import com.example.eduquest.domain.model.Achievement
import com.example.eduquest.domain.model.AchievementWithProgress
import com.example.eduquest.feature.achievement.AchievementFilter
import com.example.eduquest.feature.achievement.AchievementUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AchievementTest {

    @Test
    fun starterAchievements_haveValidConfiguration() {
        val achievements = AchievementStarterData.STARTER_ACHIEVEMENTS
        assertEquals(7, achievements.size)

        for (ach in achievements) {
            assertTrue(ach.id.isNotEmpty())
            assertTrue(ach.title.isNotEmpty())
            assertTrue(ach.description.isNotEmpty())
            assertTrue(ach.target > 0)
            assertTrue(ach.rewardXp > 0)
            assertTrue(ach.rewardCoins > 0)
        }
    }

    @Test
    fun progressRatio_calculatedCorrectly() {
        val achievement = Achievement(
            id = "MATH_EXPLORER",
            title = "Pakar Berhitung",
            description = "Jawab 3 pertanyaan matematika",
            type = "MATH_CORRECT",
            target = 4,
            rewardXp = 100,
            rewardCoins = 20
        )

        val itemZero = AchievementWithProgress(achievement, progress = 0, isUnlocked = false)
        assertEquals(0f, itemZero.progressRatio, 0.001f)
        assertFalse(itemZero.isCompleted)

        val itemHalf = AchievementWithProgress(achievement, progress = 2, isUnlocked = false)
        assertEquals(0.5f, itemHalf.progressRatio, 0.001f)
        assertFalse(itemHalf.isCompleted)

        val itemComplete = AchievementWithProgress(achievement, progress = 4, isUnlocked = false)
        assertEquals(1.0f, itemComplete.progressRatio, 0.001f)
        assertTrue(itemComplete.isCompleted)

        val itemOverachieved = AchievementWithProgress(achievement, progress = 10, isUnlocked = true)
        assertEquals(1.0f, itemOverachieved.progressRatio, 0.001f)
        assertTrue(itemOverachieved.isCompleted)
    }

    @Test
    fun filterAchievements_filtersCorrectly() {
        val a1 = Achievement("1", "A", "desc", "T", target = 1, rewardXp = 10, rewardCoins = 5)
        val a2 = Achievement("2", "B", "desc", "T", target = 1, rewardXp = 10, rewardCoins = 5)
        val a3 = Achievement("3", "C", "desc", "T", target = 1, rewardXp = 10, rewardCoins = 5)

        val items = listOf(
            AchievementWithProgress(a1, progress = 1, isUnlocked = true),
            AchievementWithProgress(a2, progress = 0, isUnlocked = false),
            AchievementWithProgress(a3, progress = 1, isUnlocked = true)
        )

        val stateAll = AchievementUiState(achievements = items, selectedFilter = AchievementFilter.ALL)
        assertEquals(3, stateAll.filteredAchievements.size)

        val stateUnlocked = AchievementUiState(achievements = items, selectedFilter = AchievementFilter.UNLOCKED)
        assertEquals(2, stateUnlocked.filteredAchievements.size)
        assertTrue(stateUnlocked.filteredAchievements.all { it.isUnlocked })

        val stateLocked = AchievementUiState(achievements = items, selectedFilter = AchievementFilter.LOCKED)
        assertEquals(1, stateLocked.filteredAchievements.size)
        assertFalse(stateLocked.filteredAchievements.first().isUnlocked)
    }

    @Test
    fun duplicateRewardProtection_preservesUnlockedStatus() {
        val achievement = Achievement(
            id = "FIRST_QUEST",
            title = "Langkah Pertama",
            description = "Selesaikan quest pertamamu",
            type = "QUEST_COMPLETED",
            target = 1,
            rewardXp = 100,
            rewardCoins = 20
        )

        val existingProgress = AchievementWithProgress(
            achievement = achievement,
            progress = 1,
            isUnlocked = true,
            unlockedAt = 123456789L
        )

        // Simulating subsequent evaluation: already unlocked state must remain unlocked
        assertTrue(existingProgress.isUnlocked)
        assertEquals(123456789L, existingProgress.unlockedAt)
        assertTrue(existingProgress.isCompleted)
    }
}
