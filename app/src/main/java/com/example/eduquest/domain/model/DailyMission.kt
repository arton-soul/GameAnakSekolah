package com.example.eduquest.domain.model

data class DailyMission(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val targetCount: Int,
    val rewardXp: Int,
    val rewardCoins: Int,
    val icon: String = "🎯"
)
