package com.example.eduquest.feature.exam

import com.example.eduquest.domain.model.Question

data class ExamPackage(
    val id: String,
    val title: String,
    val subtitle: String,
    val icon: String,
    val subjectId: String = "ALL",
    val questionCount: Int = 20,
    val durationMinutes: Int = 20,
    val xpRewardMax: Int = 300,
    val coinRewardMax: Int = 50,
    val requiredCompletedQuests: Int = 3,
    val currentCompletedQuests: Int = 0,
    val isUnlocked: Boolean = false,
    val unlockRequirementText: String = ""
)

data class ExamResultData(
    val educationLevel: String,
    val subjectTitle: String,
    val totalQuestions: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val score: Int, // 0 - 100
    val gradeLabel: String, // A, B, C, D
    val gradeDescription: String,
    val xpEarned: Int,
    val coinsEarned: Int,
    val timeSpentSeconds: Long,
    val questions: List<Question>,
    val userAnswers: Map<String, String> // questionId -> option ("A", "B", "C", "D")
)

fun calculateExamGrade(score: Int): Pair<String, String> {
    return when {
        score >= 90 -> Pair("Istimewa (A)", "Luar biasa! Penguasaan materi ujian sangat sempurna!")
        score >= 75 -> Pair("Sangat Baik (B)", "Hebat! Pertahankan pemahaman dan prestasimu!")
        score >= 60 -> Pair("Cukup (C)", "Bagus! Terus berlatih agar hasil ujianmu semakin maksimal.")
        else -> Pair("Perlu Belajar Lagi (D)", "Tetap semangat! Pelajari pembahasan soal dan ulangi ujian kembali.")
    }
}