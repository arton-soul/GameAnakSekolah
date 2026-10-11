package com.example.eduquest.domain.model

data class Player(
    val id: String,
    val nickname: String,
    val avatar: String = "avatar_kancil",
    val educationLevel: String = "SD",
    val grade: Int = 1,
    val level: Int = 1,
    val xp: Int = 0,
    val coins: Int = 0,
    val currentWorldId: String = "WORLD_01",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
