package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.eduquest.domain.model.Player

@Entity(tableName = "players")
data class PlayerEntity(
    @PrimaryKey
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

fun PlayerEntity.toDomain(): Player = Player(
    id = id,
    nickname = nickname,
    avatar = avatar,
    educationLevel = educationLevel,
    grade = grade,
    level = level,
    xp = xp,
    coins = coins,
    currentWorldId = currentWorldId,
    createdAt = createdAt,
    updatedAt = updatedAt
)

fun Player.toEntity(): PlayerEntity = PlayerEntity(
    id = id,
    nickname = nickname,
    avatar = avatar,
    educationLevel = educationLevel,
    grade = grade,
    level = level,
    xp = xp,
    coins = coins,
    currentWorldId = currentWorldId,
    createdAt = createdAt,
    updatedAt = updatedAt
)
