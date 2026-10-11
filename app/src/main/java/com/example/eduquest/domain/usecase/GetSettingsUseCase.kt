package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.SettingsPreferences
import com.example.eduquest.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

class GetSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(): Flow<SettingsPreferences> {
        return settingsRepository.getSettingsFlow()
    }
}
