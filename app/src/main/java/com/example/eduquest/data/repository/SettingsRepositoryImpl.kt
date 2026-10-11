package com.example.eduquest.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.eduquest.data.local.database.EduQuestDatabase
import com.example.eduquest.domain.model.SettingsPreferences
import com.example.eduquest.domain.repository.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class SettingsRepositoryImpl(
    private val context: Context,
    private val database: EduQuestDatabase
) : SettingsRepository {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    private val _settingsFlow = MutableStateFlow(readPreferences())

    private fun readPreferences(): SettingsPreferences {
        return try {
            val sound = prefs.getBoolean(KEY_SOUND_ENABLED, true)
            val music = prefs.getBoolean(KEY_MUSIC_ENABLED, true)
            val soundVol = prefs.getFloat(KEY_SOUND_VOLUME, 0.8f)
            val musicVol = prefs.getFloat(KEY_MUSIC_VOLUME, 0.5f)
            SettingsPreferences(
                isSoundEnabled = sound,
                isMusicEnabled = music,
                soundVolume = soundVol.coerceIn(0f, 1f),
                musicVolume = musicVol.coerceIn(0f, 1f)
            )
        } catch (e: Exception) {
            SettingsPreferences(
                isSoundEnabled = true,
                isMusicEnabled = true,
                soundVolume = 0.8f,
                musicVolume = 0.5f
            )
        }
    }

    override fun getSettingsFlow(): Flow<SettingsPreferences> = _settingsFlow.asStateFlow()

    override suspend fun getSettingsDirect(): SettingsPreferences = _settingsFlow.value

    override suspend fun setSoundEnabled(enabled: Boolean) = withContext(Dispatchers.IO) {
        try {
            prefs.edit().putBoolean(KEY_SOUND_ENABLED, enabled).apply()
        } catch (e: Exception) {
            // Ignore SharedPreferences write failures
        }
        _settingsFlow.value = _settingsFlow.value.copy(isSoundEnabled = enabled)
    }

    override suspend fun setMusicEnabled(enabled: Boolean) = withContext(Dispatchers.IO) {
        try {
            prefs.edit().putBoolean(KEY_MUSIC_ENABLED, enabled).apply()
        } catch (e: Exception) {
            // Ignore SharedPreferences write failures
        }
        _settingsFlow.value = _settingsFlow.value.copy(isMusicEnabled = enabled)
    }

    override suspend fun setSoundVolume(volume: Float) = withContext(Dispatchers.IO) {
        val clamped = volume.coerceIn(0f, 1f)
        try {
            prefs.edit().putFloat(KEY_SOUND_VOLUME, clamped).apply()
        } catch (e: Exception) {
            // Ignore write failures
        }
        _settingsFlow.value = _settingsFlow.value.copy(soundVolume = clamped)
    }

    override suspend fun setMusicVolume(volume: Float) = withContext(Dispatchers.IO) {
        val clamped = volume.coerceIn(0f, 1f)
        try {
            prefs.edit().putFloat(KEY_MUSIC_VOLUME, clamped).apply()
        } catch (e: Exception) {
            // Ignore write failures
        }
        _settingsFlow.value = _settingsFlow.value.copy(musicVolume = clamped)
    }

    override suspend fun resetAllGameProgress() = withContext(Dispatchers.IO) {
        // Reset all player progression data across all local tables
        database.playerDao().deleteAllPlayers()
        database.progressDao().deleteAllQuestProgress()
        database.progressDao().deleteAllAnswerHistory()
        database.dailyMissionDao().deleteAllDailyProgress()
        database.achievementDao().deleteAllPlayerAchievements()
        database.knowledgeCardDao().deleteAllPlayerCards()
        database.questDao().deleteAllQuestQuestions()
        database.questDao().deleteAllQuests()
    }

    companion object {
        const val PREFS_NAME = "eduquest_settings_prefs"
        const val KEY_SOUND_ENABLED = "key_sound_enabled"
        const val KEY_MUSIC_ENABLED = "key_music_enabled"
        const val KEY_SOUND_VOLUME = "key_sound_volume"
        const val KEY_MUSIC_VOLUME = "key_music_volume"
    }
}
