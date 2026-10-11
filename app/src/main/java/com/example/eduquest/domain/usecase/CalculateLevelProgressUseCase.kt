package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable

class CalculateLevelProgressUseCase {
    operator fun invoke(totalXp: Int): LevelProgress {
        return LevelTable.calculateProgress(totalXp)
    }
}
