package com.example.eduquest.domain.usecase

import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.domain.model.DailyRewardClaimResult
import com.example.eduquest.domain.repository.DailyMissionRepository

class ClaimDailyRewardUseCase(
    private val dailyMissionRepository: DailyMissionRepository
) {
    suspend operator fun invoke(
        playerId: String,
        missionId: String,
        dateString: String = DailyDateUtils.getTodayDateString()
    ): DailyRewardClaimResult {
        return dailyMissionRepository.claimReward(playerId, missionId, dateString)
    }
}
