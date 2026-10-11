package com.example.eduquest.domain.model

data class LevelProgress(
    val currentLevel: Int,
    val currentXp: Int,
    val currentLevelBaseXp: Int,
    val nextLevelTargetXp: Int,
    val xpInCurrentLevel: Int,
    val xpNeededForNextLevel: Int,
    val remainingXpToNextLevel: Int,
    val progressPercentage: Float,
    val isMaxLevel: Boolean
)
