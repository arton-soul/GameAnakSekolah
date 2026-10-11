package com.example.eduquest.domain.usecase

import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.repository.DailyMissionRepository
import kotlinx.coroutines.flow.Flow

class GetDailyMissionsUseCase(
    private val dailyMissionRepository: DailyMissionRepository
) {
    operator fun invoke(
        playerId: String,
        dateString: String = DailyDateUtils.getTodayDateString()
    ): Flow<List<DailyMissionWithProgress>> {
        return dailyMissionRepository.getDailyMissionsWithProgress(playerId, dateString)
    }
}
