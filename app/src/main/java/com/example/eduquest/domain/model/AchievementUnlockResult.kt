package com.example.eduquest.domain.model

data class AchievementUnlockResult(
    val achievement: Achievement,
    val unlockedAt: Long,
    val xpEarned: Int,
    val coinsEarned: Int
)
