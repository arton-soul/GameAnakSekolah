package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.SettingsPreferences
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getSettingsFlow(): Flow<SettingsPreferences>
    suspend fun getSettingsDirect(): SettingsPreferences
    suspend fun setSoundEnabled(enabled: Boolean)
    suspend fun setMusicEnabled(enabled: Boolean)
    suspend fun setSoundVolume(volume: Float)
    suspend fun setMusicVolume(volume: Float)
    suspend fun resetAllGameProgress()
}
