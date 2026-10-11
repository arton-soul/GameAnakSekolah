package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "knowledge_cards",
    indices = [Index(value = ["category"])]
)
data class KnowledgeCardEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val fact: String,
    val imageAsset: String,
    val unlockCondition: String
)

@Entity(
    tableName = "player_cards",
    primaryKeys = ["playerId", "cardId"],
    indices = [
        Index(value = ["playerId"]),
        Index(value = ["cardId"])
    ]
)
data class PlayerCardEntity(
    val playerId: String,
    val cardId: String,
    val unlockedAt: Long = System.currentTimeMillis()
)

fun KnowledgeCardEntity.toDomain(): com.example.eduquest.domain.model.KnowledgeCard {
    val icon = when (category.uppercase()) {
        "SPACE", "ANTARIKSA" -> "🪐"
        "ANIMALS", "HEWAN" -> "🐾"
        "SCIENCE", "SAINS", "IPA" -> "🔬"
        "MATHEMATICS", "MATH", "MATEMATIKA", "ALJABAR" -> "🔢"
        "GEOMETRI" -> "📐"
        "FISIKA" -> "⚡"
        "KIMIA" -> "🧪"
        "BIOLOGI" -> "🧬"
        "EKONOMI" -> "📈"
        "SOSIOLOGI", "SOSIAL" -> "👥"
        "SEJARAH" -> "📜"
        "TEKNOLOGI" -> "💻"
        "LOGIKA" -> "💡"
        "HUMAN_BODY", "TUBUH", "TUBUH MANUSIA" -> "❤️"
        "CULTURE", "BUDAYA" -> "🏛️"
        "LANGUAGE", "BAHASA" -> "📖"
        else -> "🃏"
    }
    return com.example.eduquest.domain.model.KnowledgeCard(
        id = id,
        title = title,
        category = category,
        description = description,
        fact = fact,
        imageAsset = imageAsset,
        unlockCondition = unlockCondition,
        icon = icon
    )
}
