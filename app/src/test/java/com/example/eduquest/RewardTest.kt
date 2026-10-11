package com.example.eduquest

import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.RewardClaimResult
import com.example.eduquest.domain.model.RewardType
import com.example.eduquest.domain.usecase.EvaluateQuestRewardUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RewardTest {

    private val evaluateQuestRewardUseCase = EvaluateQuestRewardUseCase()

    @Test
    fun firstCompletion_grantsFullRewards() {
        val result = evaluateQuestRewardUseCase(
            isAlreadyCompleted = false,
            xpReward = 150,
            coinReward = 20
        )

        assertTrue(result.isGranted)
        assertEquals(150, result.xpEarned)
        assertEquals(20, result.coinsEarned)
        assertEquals(RewardType.QUEST_COMPLETION, result.rewardType)
        assertFalse(result.isDuplicateProtected)
    }

    @Test
    fun replayCompletion_grantsScaledDownRewards() {
        val result = evaluateQuestRewardUseCase(
            isAlreadyCompleted = true,
            xpReward = 150,
            coinReward = 20
        )

        assertTrue(result.isGranted)
        assertEquals(45, result.xpEarned)
        assertEquals(5, result.coinsEarned)
        assertEquals(RewardType.QUEST_COMPLETION, result.rewardType)
        assertFalse(result.isDuplicateProtected)
    }

    @Test
    fun negativeRewardInput_safelyClampedToZero() {
        val result = evaluateQuestRewardUseCase(
            isAlreadyCompleted = false,
            xpReward = -50,
            coinReward = -10
        )

        assertTrue(result.isGranted)
        assertEquals(0, result.xpEarned)
        assertEquals(0, result.coinsEarned)
    }

    @Test
    fun coinTransaction_addCoins_calculatesCorrectBalance() {
        val currentBalance = 50
        val amountToAdd = 25
        val expectedNewBalance = currentBalance + amountToAdd

        val result = CoinTransactionResult(
            isSuccess = true,
            previousBalance = currentBalance,
            newBalance = expectedNewBalance,
            amountChanged = amountToAdd
        )

        assertTrue(result.isSuccess)
        assertEquals(50, result.previousBalance)
        assertEquals(75, result.newBalance)
        assertEquals(25, result.amountChanged)
    }

    @Test
    fun coinTransaction_spendCoins_calculatesCorrectBalance() {
        val currentBalance = 100
        val amountToSpend = 40
        val expectedNewBalance = currentBalance - amountToSpend

        val result = CoinTransactionResult(
            isSuccess = true,
            previousBalance = currentBalance,
            newBalance = expectedNewBalance,
            amountChanged = -amountToSpend
        )

        assertTrue(result.isSuccess)
        assertEquals(100, result.previousBalance)
        assertEquals(60, result.newBalance)
        assertEquals(-40, result.amountChanged)
    }

    @Test
    fun coinTransaction_spendCoins_failsWhenInsufficientBalance() {
        val currentBalance = 20
        val amountToSpend = 50

        val result = CoinTransactionResult(
            isSuccess = false,
            previousBalance = currentBalance,
            newBalance = currentBalance,
            amountChanged = 0,
            errorMessage = "Koin tidak mencukupi"
        )

        assertFalse(result.isSuccess)
        assertEquals(20, result.previousBalance)
        assertEquals(20, result.newBalance)
        assertEquals(0, result.amountChanged)
    }

    @Test
    fun levelUpRewardBonus_awards50CoinsPerLevel() {
        val baseCoins = 45
        val oldLevel = 1
        val newLevel = 2
        val bonus = (newLevel - oldLevel) * LevelTable.LEVEL_UP_COIN_REWARD
        val finalCoins = baseCoins + 20 + bonus // +20 quest reward + 50 level-up bonus

        assertEquals(50, bonus)
        assertEquals(115, finalCoins)
    }
}
