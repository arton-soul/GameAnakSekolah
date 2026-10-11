package com.example.eduquest.domain.model

enum class RewardType {
    QUEST_COMPLETION,
    LEVEL_UP,
    DAILY_MISSION,
    ACHIEVEMENT,
    BONUS
}

data class RewardClaimResult(
    val isGranted: Boolean,
    val xpEarned: Int,
    val coinsEarned: Int,
    val rewardType: RewardType,
    val isDuplicateProtected: Boolean = false,
    val message: String = ""
)
