package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.AchievementWithProgress
import com.example.eduquest.domain.repository.AchievementRepository
import kotlinx.coroutines.flow.Flow

class GetAchievementsWithProgressUseCase(
    private val achievementRepository: AchievementRepository
) {
    operator fun invoke(playerId: String = "PLAYER_LOCAL"): Flow<List<AchievementWithProgress>> {
        return achievementRepository.getAchievementsWithProgress(playerId)
    }
}
