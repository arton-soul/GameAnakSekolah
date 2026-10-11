package com.example.eduquest

import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.usecase.CalculateLevelProgressUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LevelProgressTest {

    private val calculateLevelProgressUseCase = CalculateLevelProgressUseCase()

    @Test
    fun levelThresholds_matchSpecification() {
        assertEquals(1, LevelTable.calculateLevel(0))
        assertEquals(1, LevelTable.calculateLevel(250))
        assertEquals(1, LevelTable.calculateLevel(499))
        assertEquals(2, LevelTable.calculateLevel(500))
        assertEquals(2, LevelTable.calculateLevel(1199))
        assertEquals(3, LevelTable.calculateLevel(1200))
        assertEquals(4, LevelTable.calculateLevel(2000))
        assertEquals(5, LevelTable.calculateLevel(3000))
        assertEquals(6, LevelTable.calculateLevel(4200))
        assertEquals(7, LevelTable.calculateLevel(5600))
        assertEquals(8, LevelTable.calculateLevel(7200))
        assertEquals(9, LevelTable.calculateLevel(9000))
        assertEquals(10, LevelTable.calculateLevel(11000))
        assertEquals(10, LevelTable.calculateLevel(15000))
    }

    @Test
    fun negativeXp_clampedToLevel1() {
        assertEquals(1, LevelTable.calculateLevel(-100))
        val progress = LevelTable.calculateProgress(-50)
        assertEquals(1, progress.currentLevel)
        assertEquals(0, progress.currentXp)
        assertEquals(0.0f, progress.progressPercentage, 0.001f)
    }

    @Test
    fun level1_halfwayProgress_calculatedCorrectly() {
        val progress = LevelTable.calculateProgress(250)
        assertEquals(1, progress.currentLevel)
        assertEquals(250, progress.currentXp)
        assertEquals(0, progress.currentLevelBaseXp)
        assertEquals(500, progress.nextLevelTargetXp)
        assertEquals(250, progress.xpInCurrentLevel)
        assertEquals(500, progress.xpNeededForNextLevel)
        assertEquals(250, progress.remainingXpToNextLevel)
        assertEquals(0.5f, progress.progressPercentage, 0.001f)
        assertFalse(progress.isMaxLevel)
    }

    @Test
    fun level2_startAndIntermediateProgress() {
        val startProgress = LevelTable.calculateProgress(500)
        assertEquals(2, startProgress.currentLevel)
        assertEquals(500, startProgress.currentXp)
        assertEquals(500, startProgress.currentLevelBaseXp)
        assertEquals(1200, startProgress.nextLevelTargetXp)
        assertEquals(0, startProgress.xpInCurrentLevel)
        assertEquals(700, startProgress.xpNeededForNextLevel)
        assertEquals(700, startProgress.remainingXpToNextLevel)
        assertEquals(0.0f, startProgress.progressPercentage, 0.001f)
        assertFalse(startProgress.isMaxLevel)

        val midProgress = LevelTable.calculateProgress(850)
        assertEquals(2, midProgress.currentLevel)
        assertEquals(850, midProgress.currentXp)
        assertEquals(350, midProgress.xpInCurrentLevel)
        assertEquals(700, midProgress.xpNeededForNextLevel)
        assertEquals(350, midProgress.remainingXpToNextLevel)
        assertEquals(0.5f, midProgress.progressPercentage, 0.001f)
    }

    @Test
    fun maxLevel_returnsCompleteProgress() {
        val maxProgress = LevelTable.calculateProgress(11000)
        assertEquals(10, maxProgress.currentLevel)
        assertEquals(11000, maxProgress.currentXp)
        assertEquals(1.0f, maxProgress.progressPercentage, 0.001f)
        assertEquals(0, maxProgress.remainingXpToNextLevel)
        assertTrue(maxProgress.isMaxLevel)

        val beyondMax = LevelTable.calculateProgress(20000)
        assertEquals(10, beyondMax.currentLevel)
        assertEquals(1.0f, beyondMax.progressPercentage, 0.001f)
        assertEquals(0, beyondMax.remainingXpToNextLevel)
        assertTrue(beyondMax.isMaxLevel)
    }

    @Test
    fun calculateLevelProgressUseCase_matchesLevelTable() {
        val progress = calculateLevelProgressUseCase(600)
        assertEquals(2, progress.currentLevel)
        assertEquals(100, progress.xpInCurrentLevel)
        assertEquals(700, progress.xpNeededForNextLevel)
        assertEquals(600, progress.remainingXpToNextLevel)
    }

    @Test
    fun levelUpRewardBonus_is50CoinsPerLevel() {
        assertEquals(50, LevelTable.LEVEL_UP_COIN_REWARD)

        val oldLevel = 1
        val newLevel = 2
        val bonusCoins = (newLevel - oldLevel) * LevelTable.LEVEL_UP_COIN_REWARD
        assertEquals(50, bonusCoins)

        val multiLevelJumpBonus = (3 - 1) * LevelTable.LEVEL_UP_COIN_REWARD
        assertEquals(100, multiLevelJumpBonus)
    }
}
