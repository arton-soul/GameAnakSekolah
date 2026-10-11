package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.RewardClaimResult
import com.example.eduquest.domain.model.RewardType

class EvaluateQuestRewardUseCase {

    operator fun invoke(
        isAlreadyCompleted: Boolean,
        xpReward: Int,
        coinReward: Int
    ): RewardClaimResult {
        return if (isAlreadyCompleted) {
            // Hadiah latihan ulang: nilai lebih kecil (30% XP & 25% Koin, minimal 15 XP & 3 Koin)
            val repeatXp = maxOf(15, (xpReward * 0.3).toInt())
            val repeatCoins = maxOf(3, (coinReward * 0.25).toInt())
            RewardClaimResult(
                isGranted = true,
                xpEarned = repeatXp,
                coinsEarned = repeatCoins,
                rewardType = RewardType.QUEST_COMPLETION,
                isDuplicateProtected = false,
                message = "Hadiah Latihan Ulang (+${repeatXp} XP, +${repeatCoins} Koin)"
            )
        } else {
            RewardClaimResult(
                isGranted = true,
                xpEarned = maxOf(0, xpReward),
                coinsEarned = maxOf(0, coinReward),
                rewardType = RewardType.QUEST_COMPLETION,
                isDuplicateProtected = false,
                message = "Selamat! Hadiah misi berhasil diklaim"
            )
        }
    }
}
