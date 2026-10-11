package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "achievements")
data class AchievementEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val type: String,
    val target: Int,
    val rewardXp: Int,
    val rewardCoins: Int
)

@Entity(
    tableName = "player_achievements",
    primaryKeys = ["playerId", "achievementId"],
    indices = [
        Index(value = ["playerId"]),
        Index(value = ["achievementId"])
    ]
)
data class PlayerAchievementEntity(
    val playerId: String,
    val achievementId: String,
    val progress: Int = 0,
    val unlocked: Boolean = false,
    val unlockedAt: Long? = null
)

fun AchievementEntity.toDomain(): com.example.eduquest.domain.model.Achievement {
    val icon = when (id) {
        "FIRST_QUEST" -> "🚀"
        "QUEST_EXPLORER" -> "🗺️"
        "MATH_EXPLORER" -> "🔢"
        "SCIENCE_STARTER" -> "🔬"
        "LANGUAGE_PIONEER" -> "📖"
        "PERFECT_STAR" -> "⭐"
        "LEVEL_UP_HERO" -> "👑"
        else -> when (type) {
            "QUEST_COMPLETED" -> "🗺️"
            "MATH_CORRECT" -> "🔢"
            "SCIENCE_CORRECT" -> "🔬"
            "LANGUAGE_CORRECT" -> "📖"
            "PERFECT_SCORE" -> "⭐"
            "LEVEL_REACHED" -> "👑"
            else -> "🏆"
        }
    }
    return com.example.eduquest.domain.model.Achievement(
        id = id,
        title = title,
        description = description,
        type = type,
        target = target,
        rewardXp = rewardXp,
        rewardCoins = rewardCoins,
        icon = icon
    )
}
