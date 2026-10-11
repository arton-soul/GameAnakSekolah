package com.example.eduquest.domain.model

data class World(
    val id: String,
    val title: String,
    val description: String,
    val unlockLevel: Int = 1,
    val orderIndex: Int = 0,
    val icon: String = "🏰"
)

data class WorldArea(
    val id: String,
    val worldId: String,
    val subjectId: String,
    val name: String,
    val indonesianName: String,
    val icon: String,
    val description: String,
    val unlockLevel: Int = 1,
    val orderIndex: Int = 0
)

data class WorldAreaWithProgress(
    val area: WorldArea,
    val isUnlocked: Boolean,
    val totalQuests: Int,
    val completedQuests: Int
) {
    val progressRatio: Float
        get() = if (totalQuests > 0) (completedQuests.toFloat() / totalQuests).coerceIn(0f, 1f) else 0f

    val completionPercentage: Int
        get() = if (totalQuests > 0) (completedQuests * 100) / totalQuests else 0

    val isCompleted: Boolean
        get() = totalQuests > 0 && completedQuests >= totalQuests
}

data class WorldWithProgress(
    val world: World,
    val isUnlocked: Boolean,
    val areas: List<WorldAreaWithProgress>,
    val totalQuests: Int,
    val completedQuests: Int
) {
    val progressRatio: Float
        get() = if (totalQuests > 0) (completedQuests.toFloat() / totalQuests).coerceIn(0f, 1f) else 0f

    val completionPercentage: Int
        get() = if (totalQuests > 0) (completedQuests * 100) / totalQuests else 0

    val isCompleted: Boolean
        get() = totalQuests > 0 && completedQuests >= totalQuests
}
