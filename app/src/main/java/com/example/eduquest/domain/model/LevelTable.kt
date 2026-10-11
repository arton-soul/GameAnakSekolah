package com.example.eduquest.domain.model

object LevelTable {
    val LEVEL_THRESHOLDS: List<Pair<Int, Int>> = listOf(
        1 to 0,
        2 to 500,
        3 to 1200,
        4 to 2000,
        5 to 3000,
        6 to 4200,
        7 to 5600,
        8 to 7200,
        9 to 9000,
        10 to 11000
    )

    const val MIN_LEVEL = 1
    const val MAX_LEVEL = 10
    const val LEVEL_UP_COIN_REWARD = 50

    fun getThresholdForLevel(level: Int): Int {
        val clamped = level.coerceIn(MIN_LEVEL, MAX_LEVEL)
        return LEVEL_THRESHOLDS.firstOrNull { it.first == clamped }?.second ?: 0
    }

    fun getNextLevelThreshold(level: Int): Int? {
        if (level >= MAX_LEVEL) return null
        return getThresholdForLevel(level + 1)
    }

    fun calculateLevel(totalXp: Int): Int {
        val safeXp = maxOf(0, totalXp)
        var level = MIN_LEVEL
        for ((lvl, reqXp) in LEVEL_THRESHOLDS) {
            if (safeXp >= reqXp) {
                level = lvl
            } else {
                break
            }
        }
        return level.coerceIn(MIN_LEVEL, MAX_LEVEL)
    }

    fun calculateProgress(totalXp: Int): LevelProgress {
        val safeXp = maxOf(0, totalXp)
        val currentLevel = calculateLevel(safeXp)
        val isMaxLevel = currentLevel >= MAX_LEVEL

        val currentBaseXp = getThresholdForLevel(currentLevel)
        val nextLevelTargetXp = if (isMaxLevel) currentBaseXp else getThresholdForLevel(currentLevel + 1)

        val xpInCurrentLevel = if (isMaxLevel) {
            safeXp - currentBaseXp
        } else {
            (safeXp - currentBaseXp).coerceAtLeast(0)
        }

        val xpNeededForNextLevel = if (isMaxLevel) {
            0
        } else {
            nextLevelTargetXp - currentBaseXp
        }

        val percentage = if (isMaxLevel) {
            1.0f
        } else if (xpNeededForNextLevel > 0) {
            (xpInCurrentLevel.toFloat() / xpNeededForNextLevel.toFloat()).coerceIn(0f, 1f)
        } else {
            0f
        }

        val remainingXp = if (isMaxLevel) 0 else (nextLevelTargetXp - safeXp).coerceAtLeast(0)

        return LevelProgress(
            currentLevel = currentLevel,
            currentXp = safeXp,
            currentLevelBaseXp = currentBaseXp,
            nextLevelTargetXp = nextLevelTargetXp,
            xpInCurrentLevel = xpInCurrentLevel,
            xpNeededForNextLevel = xpNeededForNextLevel,
            remainingXpToNextLevel = remainingXp,
            progressPercentage = percentage,
            isMaxLevel = isMaxLevel
        )
    }
}
