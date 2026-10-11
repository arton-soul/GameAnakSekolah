package com.example.eduquest.domain.model

sealed class DailyRewardClaimResult {
    data class Success(
        val missionId: String,
        val xpEarned: Int,
        val coinsEarned: Int,
        val unlockedCard: KnowledgeCard? = null,
        val isAllMissionsCompleted: Boolean = false
    ) : DailyRewardClaimResult()

    data class AlreadyClaimed(val missionId: String) : DailyRewardClaimResult()
    data class NotCompleted(val missionId: String) : DailyRewardClaimResult()
    data class MissionNotFound(val missionId: String) : DailyRewardClaimResult()
    data class Error(val message: String) : DailyRewardClaimResult()
}
