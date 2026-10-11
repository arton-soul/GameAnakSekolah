package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Quest

@Entity(
    tableName = "worlds",
    indices = [Index(value = ["educationLevel"])]
)
data class WorldEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val unlockLevel: Int = 1,
    val orderIndex: Int = 0,
    val educationLevel: String = "SD"
)

@Entity(
    tableName = "quests",
    indices = [
        Index(value = ["worldId"]),
        Index(value = ["subjectId"]),
        Index(value = ["grade"]),
        Index(value = ["educationLevel"])
    ]
)
data class QuestEntity(
    @PrimaryKey
    val id: String,
    val worldId: String,
    val title: String,
    val description: String,
    val subjectId: String,
    val grade: Int,
    val difficulty: String,
    val questionCount: Int,
    val xpReward: Int,
    val coinReward: Int,
    val unlockLevel: Int,
    val educationLevel: String = "SD"
)

fun QuestEntity.toDomain(): Quest = Quest(
    id = id,
    worldId = worldId,
    title = title,
    description = description,
    subjectId = subjectId,
    grade = grade,
    difficulty = try { Difficulty.valueOf(difficulty) } catch (e: Exception) { Difficulty.EASY },
    questionCount = questionCount,
    xpReward = xpReward,
    coinReward = coinReward,
    unlockLevel = unlockLevel,
    educationLevel = educationLevel
)

fun Quest.toEntity(): QuestEntity = QuestEntity(
    id = id,
    worldId = worldId,
    title = title,
    description = description,
    subjectId = subjectId,
    grade = grade,
    difficulty = difficulty.name,
    questionCount = questionCount,
    xpReward = xpReward,
    coinReward = coinReward,
    unlockLevel = unlockLevel,
    educationLevel = educationLevel
)

@Entity(
    tableName = "quest_questions",
    primaryKeys = ["questId", "questionId"],
    indices = [
        Index(value = ["questId"]),
        Index(value = ["questionId"])
    ]
)
data class QuestQuestionEntity(
    val questId: String,
    val questionId: String,
    val orderIndex: Int = 0
)

@Entity(
    tableName = "quest_progress",
    primaryKeys = ["playerId", "questId"],
    indices = [
        Index(value = ["playerId"]),
        Index(value = ["questId"])
    ]
)
data class QuestProgressEntity(
    val playerId: String,
    val questId: String,
    val status: String,
    val score: Int = 0,
    val completedAt: Long? = null,
    val attemptCount: Int = 0
)

@Entity(
    tableName = "answer_history",
    indices = [
        Index(value = ["playerId"]),
        Index(value = ["questId"]),
        Index(value = ["questionId"])
    ]
)
data class AnswerHistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val playerId: String,
    val questId: String,
    val questionId: String,
    val selectedAnswer: String,
    val isCorrect: Boolean,
    val xpEarned: Int,
    val answeredAt: Long = System.currentTimeMillis()
)
