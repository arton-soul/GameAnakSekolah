package com.example.eduquest.domain.model

data class Quest(
    val id: String,
    val worldId: String,
    val title: String,
    val description: String,
    val subjectId: String,
    val grade: Int,
    val difficulty: Difficulty = Difficulty.EASY,
    val questionCount: Int = 5,
    val xpReward: Int = 150,
    val coinReward: Int = 20,
    val unlockLevel: Int = 1,
    val educationLevel: String = "SD"
)
