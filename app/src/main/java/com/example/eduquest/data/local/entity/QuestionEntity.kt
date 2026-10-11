package com.example.eduquest.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "questions",
    indices = [
        Index(value = ["grade"]),
        Index(value = ["subjectId"]),
        Index(value = ["topicId"]),
        Index(value = ["educationLevel"]),
        Index(value = ["isExam"])
    ]
)
data class QuestionEntity(
    @PrimaryKey
    val id: String,
    val grade: Int,
    val subjectId: String,
    val topicId: String,
    val difficulty: String = "EASY",
    val type: String = "MULTIPLE_CHOICE",
    val question: String,
    val optionA: String = "",
    val optionB: String = "",
    val optionC: String = "",
    val optionD: String = "",
    val optionsJson: String = "",
    val answer: String,
    val explanation: String,
    val xp: Int = 100,
    val educationLevel: String = "SD",
    val isExam: Boolean = false
)

fun QuestionEntity.toDomain(): com.example.eduquest.domain.model.Question {
    val diff = try {
        com.example.eduquest.domain.model.Difficulty.valueOf(difficulty.uppercase())
    } catch (_: Exception) {
        com.example.eduquest.domain.model.Difficulty.EASY
    }
    val qType = try {
        com.example.eduquest.domain.model.QuestionType.valueOf(type.uppercase())
    } catch (_: Exception) {
        com.example.eduquest.domain.model.QuestionType.MULTIPLE_CHOICE
    }
    return com.example.eduquest.domain.model.Question(
        id = id,
        grade = grade,
        subjectId = subjectId,
        topicId = topicId,
        difficulty = diff,
        type = qType,
        questionText = question,
        optionA = optionA,
        optionB = optionB,
        optionC = optionC,
        optionD = optionD,
        correctAnswer = answer,
        explanation = explanation,
        xpReward = xp,
        educationLevel = educationLevel,
        isExam = isExam
    )
}

fun com.example.eduquest.domain.model.Question.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        grade = grade,
        subjectId = subjectId,
        topicId = topicId,
        difficulty = difficulty.name,
        type = type.name,
        question = questionText,
        optionA = optionA,
        optionB = optionB,
        optionC = optionC,
        optionD = optionD,
        optionsJson = "",
        answer = correctAnswer,
        explanation = explanation,
        xp = xpReward,
        educationLevel = educationLevel,
        isExam = isExam
    )
}
