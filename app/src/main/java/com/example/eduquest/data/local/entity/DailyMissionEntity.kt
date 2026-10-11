package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.eduquest.domain.model.DailyMission

@Entity(tableName = "daily_missions")
data class DailyMissionEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val category: String,
    val targetCount: Int,
    val rewardXp: Int,
    val rewardCoins: Int
) {
    fun toDomain(): DailyMission {
        val (icon, desc) = when (category) {
            "MATH" -> "🔢" to "Jawab $targetCount soal matematika hari ini"
            "SCIENCE" -> "🔬" to "Jawab $targetCount soal sains / IPA hari ini"
            "LANGUAGE" -> "📖" to "Jawab $targetCount soal bahasa hari ini"
            "QUEST" -> "🗺️" to "Selesaikan $targetCount petualangan quest hari ini"
            "PERFECT_SCORE" -> "⭐" to "Raih nilai 100% sempurna pada quest"
            "ANY_QUESTION" -> "✏️" to "Jawab $targetCount soal pelajaran apa saja"
            else -> "🎯" to "Selesaikan target $targetCount kali hari ini"
        }
        return DailyMission(
            id = id,
            title = title,
            description = desc,
            category = category,
            targetCount = targetCount,
            rewardXp = rewardXp,
            rewardCoins = rewardCoins,
            icon = icon
        )
    }
}

@Entity(
    tableName = "player_daily_progress",
    primaryKeys = ["playerId", "missionId", "dateString"],
    indices = [
        Index(value = ["playerId"]),
        Index(value = ["missionId"]),
        Index(value = ["dateString"])
    ]
)
data class PlayerDailyProgressEntity(
    val playerId: String,
    val missionId: String,
    val dateString: String,
    val currentProgress: Int = 0,
    val isCompleted: Boolean = false,
    val isClaimed: Boolean = false
)
