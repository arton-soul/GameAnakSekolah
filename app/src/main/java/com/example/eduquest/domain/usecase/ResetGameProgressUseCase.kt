package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.repository.SettingsRepository

class ResetGameProgressUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke() {
        settingsRepository.resetAllGameProgress()
    }
}
