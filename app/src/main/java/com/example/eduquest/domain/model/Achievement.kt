package com.example.eduquest.domain.model

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val target: Int,
    val rewardXp: Int,
    val rewardCoins: Int,
    val icon: String = "🏆"
)
