package com.example.eduquest

import com.example.eduquest.domain.model.SettingsPreferences
import com.example.eduquest.domain.repository.SettingsRepository
import com.example.eduquest.domain.usecase.GetSettingsUseCase
import com.example.eduquest.domain.usecase.ResetGameProgressUseCase
import com.example.eduquest.domain.usecase.UpdateAudioSettingsUseCase
import com.example.eduquest.feature.settings.SettingsUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SettingsTest {

    private class FakeSettingsRepository : SettingsRepository {
        private val state = MutableStateFlow(SettingsPreferences(isSoundEnabled = true, isMusicEnabled = true))
        var resetCalledCount = 0

        override fun getSettingsFlow(): Flow<SettingsPreferences> = state

        override suspend fun getSettingsDirect(): SettingsPreferences = state.value

        override suspend fun setSoundEnabled(enabled: Boolean) {
            state.value = state.value.copy(isSoundEnabled = enabled)
        }

        override suspend fun setMusicEnabled(enabled: Boolean) {
            state.value = state.value.copy(isMusicEnabled = enabled)
        }

        override suspend fun setSoundVolume(volume: Float) {
            state.value = state.value.copy(soundVolume = volume)
        }

        override suspend fun setMusicVolume(volume: Float) {
            state.value = state.value.copy(musicVolume = volume)
        }

        override suspend fun resetAllGameProgress() {
            resetCalledCount++
        }
    }

    private lateinit var fakeRepository: FakeSettingsRepository
    private lateinit var getSettingsUseCase: GetSettingsUseCase
    private lateinit var updateAudioSettingsUseCase: UpdateAudioSettingsUseCase
    private lateinit var resetGameProgressUseCase: ResetGameProgressUseCase

    @Before
    fun setUp() {
        fakeRepository = FakeSettingsRepository()
        getSettingsUseCase = GetSettingsUseCase(fakeRepository)
        updateAudioSettingsUseCase = UpdateAudioSettingsUseCase(fakeRepository)
        resetGameProgressUseCase = ResetGameProgressUseCase(fakeRepository)
    }

    @Test
    fun defaultSettingsPreferences_hasAudioEnabled() {
        val defaultPrefs = SettingsPreferences()
        assertTrue("Sound should be enabled by default", defaultPrefs.isSoundEnabled)
        assertTrue("Music should be enabled by default", defaultPrefs.isMusicEnabled)
    }

    @Test
    fun defaultSettingsUiState_hasCorrectInitialValues() {
        val initialState = SettingsUiState()
        assertFalse("isLoading should be false by default", initialState.isLoading)
        assertTrue("isSoundEnabled should be true by default", initialState.isSoundEnabled)
        assertTrue("isMusicEnabled should be true by default", initialState.isMusicEnabled)
        assertFalse("isResetDialogOpen should be false by default", initialState.isResetDialogOpen)
        assertFalse("isResetting should be false by default", initialState.isResetting)
        assertFalse("isResetSuccess should be false by default", initialState.isResetSuccess)
        assertNull("message should be null by default", initialState.message)
    }

    @Test
    fun getSettingsUseCase_emitsInitialPreferences() = runBlocking {
        val prefs = getSettingsUseCase().first()
        assertTrue(prefs.isSoundEnabled)
        assertTrue(prefs.isMusicEnabled)
    }

    @Test
    fun updateAudioSettingsUseCase_togglesSound() = runBlocking {
        updateAudioSettingsUseCase.setSoundEnabled(false)
        val updatedPrefs = getSettingsUseCase().first()
        assertFalse("Sound should be disabled after setting to false", updatedPrefs.isSoundEnabled)
        assertTrue("Music should still be enabled", updatedPrefs.isMusicEnabled)

        updateAudioSettingsUseCase.setSoundEnabled(true)
        val revertedPrefs = getSettingsUseCase().first()
        assertTrue("Sound should be re-enabled", revertedPrefs.isSoundEnabled)
    }

    @Test
    fun updateAudioSettingsUseCase_togglesMusic() = runBlocking {
        updateAudioSettingsUseCase.setMusicEnabled(false)
        val updatedPrefs = getSettingsUseCase().first()
        assertTrue("Sound should still be enabled", updatedPrefs.isSoundEnabled)
        assertFalse("Music should be disabled after setting to false", updatedPrefs.isMusicEnabled)

        updateAudioSettingsUseCase.setMusicEnabled(true)
        val revertedPrefs = getSettingsUseCase().first()
        assertTrue("Music should be re-enabled", revertedPrefs.isMusicEnabled)
    }

    @Test
    fun updateAudioSettingsUseCase_updatesSoundVolume() = runBlocking {
        updateAudioSettingsUseCase.setSoundVolume(0.4f)
        val updatedPrefs = getSettingsUseCase().first()
        assertEquals(0.4f, updatedPrefs.soundVolume, 0.01f)

        updateAudioSettingsUseCase.setSoundVolume(1.0f)
        val maxPrefs = getSettingsUseCase().first()
        assertEquals(1.0f, maxPrefs.soundVolume, 0.01f)
    }

    @Test
    fun updateAudioSettingsUseCase_updatesMusicVolume() = runBlocking {
        updateAudioSettingsUseCase.setMusicVolume(0.25f)
        val updatedPrefs = getSettingsUseCase().first()
        assertEquals(0.25f, updatedPrefs.musicVolume, 0.01f)

        updateAudioSettingsUseCase.setMusicVolume(0.0f)
        val mutePrefs = getSettingsUseCase().first()
        assertEquals(0.0f, mutePrefs.musicVolume, 0.01f)
    }

    @Test
    fun resetGameProgressUseCase_invokesRepositoryReset() = runBlocking {
        assertEquals(0, fakeRepository.resetCalledCount)

        resetGameProgressUseCase()

        assertEquals(1, fakeRepository.resetCalledCount)
    }

    @Test
    fun settingsUiState_resetDialogFlow() {
        var state = SettingsUiState()
        assertFalse(state.isResetDialogOpen)

        // Open dialog
        state = state.copy(isResetDialogOpen = true)
        assertTrue(state.isResetDialogOpen)

        // Dismiss dialog
        state = state.copy(isResetDialogOpen = false)
        assertFalse(state.isResetDialogOpen)

        // Confirm reset started
        state = state.copy(isResetting = true, isResetDialogOpen = false)
        assertTrue(state.isResetting)
        assertFalse(state.isResetDialogOpen)

        // Reset succeeded
        state = state.copy(
            isResetting = false,
            isResetSuccess = true,
            message = "Semua progres belajar berhasil direset."
        )
        assertFalse(state.isResetting)
        assertTrue(state.isResetSuccess)
        assertNotNull(state.message)
        assertEquals("Semua progres belajar berhasil direset.", state.message)
    }
}
