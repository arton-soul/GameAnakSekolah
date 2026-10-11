package com.example.eduquest.domain.model

data class LevelUpResult(
    val oldLevel: Int,
    val newLevel: Int,
    val hasLeveledUp: Boolean,
    val bonusCoins: Int,
    val totalXp: Int,
    val levelProgress: LevelProgress
)
