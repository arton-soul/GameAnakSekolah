package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.AchievementUnlockResult
import com.example.eduquest.domain.repository.AchievementRepository

class EvaluateAchievementsUseCase(
    private val achievementRepository: AchievementRepository
) {
    suspend operator fun invoke(playerId: String = "PLAYER_LOCAL"): List<AchievementUnlockResult> {
        return achievementRepository.evaluateAchievements(playerId)
    }
}
