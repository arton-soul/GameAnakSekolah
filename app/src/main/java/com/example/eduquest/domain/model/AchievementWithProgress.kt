package com.example.eduquest.domain.model

data class AchievementWithProgress(
    val achievement: Achievement,
    val progress: Int,
    val isUnlocked: Boolean,
    val unlockedAt: Long? = null
) {
    val displayProgress: Int
        get() = if (achievement.target > 0) minOf(progress, achievement.target) else progress

    val progressRatio: Float
        get() = if (achievement.target > 0) {
            (displayProgress.toFloat() / achievement.target).coerceIn(0f, 1f)
        } else 0f

    val isCompleted: Boolean
        get() = isUnlocked || progress >= achievement.target
}
