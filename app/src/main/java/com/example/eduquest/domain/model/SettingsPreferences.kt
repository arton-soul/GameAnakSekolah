package com.example.eduquest.domain.model

data class SettingsPreferences(
    val isSoundEnabled: Boolean = true,
    val isMusicEnabled: Boolean = true,
    val soundVolume: Float = 0.8f,
    val musicVolume: Float = 0.5f
)
