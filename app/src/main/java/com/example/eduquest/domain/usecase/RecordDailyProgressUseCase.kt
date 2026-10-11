package com.example.eduquest.domain.usecase

import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.domain.repository.DailyMissionRepository

class RecordDailyProgressUseCase(
    private val dailyMissionRepository: DailyMissionRepository
) {
    suspend fun recordSubjectProgress(
        playerId: String,
        subjectId: String,
        dateString: String = DailyDateUtils.getTodayDateString(),
        count: Int = 1
    ) {
        dailyMissionRepository.recordSubjectProgress(playerId, subjectId, dateString, count)
    }

    suspend fun recordQuestProgress(
        playerId: String,
        isPerfectScore: Boolean = false,
        dateString: String = DailyDateUtils.getTodayDateString()
    ) {
        dailyMissionRepository.recordQuestProgress(playerId, isPerfectScore, dateString)
    }
}
