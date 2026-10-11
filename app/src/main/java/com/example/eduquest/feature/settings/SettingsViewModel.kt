package com.example.eduquest.feature.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.audio.SoundManager
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.SettingsRepositoryImpl
import com.example.eduquest.domain.repository.SettingsRepository
import com.example.eduquest.domain.usecase.GetSettingsUseCase
import com.example.eduquest.domain.usecase.ResetGameProgressUseCase
import com.example.eduquest.domain.usecase.UpdateAudioSettingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SettingsUiState(
    val isLoading: Boolean = false,
    val isSoundEnabled: Boolean = true,
    val isMusicEnabled: Boolean = true,
    val soundVolume: Float = 0.8f,
    val musicVolume: Float = 0.5f,
    val isResetDialogOpen: Boolean = false,
    val isResetting: Boolean = false,
    val isResetSuccess: Boolean = false,
    val isSyncingQuestions: Boolean = false,
    val contentVersion: Int = 1,
    val message: String? = null
)

class SettingsViewModel @JvmOverloads constructor(
    application: Application,
    private val settingsRepository: SettingsRepository = SettingsRepositoryImpl(
        context = application.applicationContext,
        database = DatabaseProvider.getDatabase(application)
    ),
    private val syncService: com.example.eduquest.data.remote.RemoteQuestionSyncService = com.example.eduquest.data.remote.RemoteQuestionSyncService(
        context = application.applicationContext,
        questionDao = DatabaseProvider.getDatabase(application).questionDao()
    )
) : AndroidViewModel(application) {

    private val getSettingsUseCase = GetSettingsUseCase(settingsRepository)
    private val updateAudioSettingsUseCase = UpdateAudioSettingsUseCase(settingsRepository)
    private val resetGameProgressUseCase = ResetGameProgressUseCase(settingsRepository)

    private val _uiState = MutableStateFlow(SettingsUiState(contentVersion = syncService.getLocalContentVersion()))
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        observeSettings()
    }

    private fun observeSettings() {
        viewModelScope.launch {
            getSettingsUseCase().collectLatest { prefs ->
                _uiState.update {
                    it.copy(
                        isSoundEnabled = prefs.isSoundEnabled,
                        isMusicEnabled = prefs.isMusicEnabled,
                        soundVolume = prefs.soundVolume,
                        musicVolume = prefs.musicVolume
                    )
                }
            }
        }
    }

    fun setSoundEnabled(enabled: Boolean) {
        viewModelScope.launch {
            updateAudioSettingsUseCase.setSoundEnabled(enabled)
            if (enabled) {
                SoundManager.playClick()
            }
        }
    }

    fun setMusicEnabled(enabled: Boolean) {
        viewModelScope.launch {
            updateAudioSettingsUseCase.setMusicEnabled(enabled)
            if (enabled) {
                SoundManager.resumeBgm()
            } else {
                SoundManager.pauseBgm()
            }
        }
    }

    fun setSoundVolume(volume: Float) {
        viewModelScope.launch {
            updateAudioSettingsUseCase.setSoundVolume(volume)
            SoundManager.playVolumePreview(volume)
        }
    }

    fun setMusicVolume(volume: Float) {
        viewModelScope.launch {
            updateAudioSettingsUseCase.setMusicVolume(volume)
        }
    }

    fun openResetDialog() {
        SoundManager.playClick()
        _uiState.update { it.copy(isResetDialogOpen = true) }
    }

    fun dismissResetDialog() {
        SoundManager.playClick()
        _uiState.update { it.copy(isResetDialogOpen = false) }
    }

    fun confirmReset() {
        viewModelScope.launch {
            _uiState.update { it.copy(isResetting = true, isResetDialogOpen = false) }
            try {
                resetGameProgressUseCase()
                _uiState.update {
                    it.copy(
                        isResetting = false,
                        isResetSuccess = true,
                        message = "Semua progres belajar berhasil direset."
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isResetting = false,
                        message = "Gagal mereset data: ${e.localizedMessage}"
                    )
                }
            }
        }
    }

    fun syncQuestions(force: Boolean = true) {
        viewModelScope.launch {
            _uiState.update { it.copy(isSyncingQuestions = true) }
            val result = syncService.syncQuestionsFromGitHub(force)
            _uiState.update {
                it.copy(
                    isSyncingQuestions = false,
                    contentVersion = result.currentVersion,
                    message = result.message
                )
            }
        }
    }

    fun clearMessage() {
        _uiState.update { it.copy(message = null) }
    }
}
