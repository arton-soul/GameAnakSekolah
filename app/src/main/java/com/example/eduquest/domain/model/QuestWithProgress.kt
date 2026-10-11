package com.example.eduquest.domain.model

data class QuestWithProgress(
    val quest: Quest,
    val status: QuestStatus,
    val score: Int = 0,
    val attemptCount: Int = 0,
    val completedAt: Long? = null
) {
    val isLocked: Boolean get() = status == QuestStatus.LOCKED
    val isCompleted: Boolean get() = status == QuestStatus.COMPLETED
    val isAvailable: Boolean get() = status == QuestStatus.AVAILABLE
    val isInProgress: Boolean get() = status == QuestStatus.IN_PROGRESS
}
