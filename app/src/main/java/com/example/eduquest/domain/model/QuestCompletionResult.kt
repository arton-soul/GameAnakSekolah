package com.example.eduquest.domain.model

data class QuestCompletionResult(
    val questId: String,
    val playerId: String,
    val isCompleted: Boolean,
    val score: Int,
    val totalQuestions: Int,
    val xpEarned: Int,
    val coinsEarned: Int,
    val isFirstCompletion: Boolean,
    val levelUpResult: LevelUpResult? = null,
    val rewardClaimResult: RewardClaimResult? = null,
    val unlockedAchievements: List<Achievement> = emptyList(),
    val unlockedCards: List<KnowledgeCard> = emptyList(),
    val completedAt: Long = System.currentTimeMillis()
)
