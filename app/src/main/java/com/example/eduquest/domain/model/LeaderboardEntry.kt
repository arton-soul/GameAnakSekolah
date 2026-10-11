package com.example.eduquest.domain.model

data class LeaderboardEntry(
    val rank: Int = 0,
    val playerId: String = "",
    val nickname: String = "",
    val avatar: String = "Kancil",
    val educationLevel: String = "SD",
    val grade: Int = 1,
    val totalXp: Int = 0,
    val level: Int = 1,
    val isCurrentPlayer: Boolean = false
)
