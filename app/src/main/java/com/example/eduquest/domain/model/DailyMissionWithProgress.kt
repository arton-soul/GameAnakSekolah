package com.example.eduquest.domain.model

data class DailyMissionWithProgress(
    val mission: DailyMission,
    val dateString: String,
    val currentProgress: Int,
    val isCompleted: Boolean,
    val isClaimed: Boolean
) {
    val progressRatio: Float
        get() = if (mission.targetCount > 0) {
            (currentProgress.toFloat() / mission.targetCount).coerceIn(0f, 1f)
        } else 0f

    val isReadyToClaim: Boolean
        get() = isCompleted && !isClaimed
}
