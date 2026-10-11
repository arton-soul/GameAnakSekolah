package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.repository.SettingsRepository

class UpdateAudioSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend fun setSoundEnabled(enabled: Boolean) {
        settingsRepository.setSoundEnabled(enabled)
    }

    suspend fun setMusicEnabled(enabled: Boolean) {
        settingsRepository.setMusicEnabled(enabled)
    }

    suspend fun setSoundVolume(volume: Float) {
        settingsRepository.setSoundVolume(volume)
    }

    suspend fun setMusicVolume(volume: Float) {
        settingsRepository.setMusicVolume(volume)
    }
}
