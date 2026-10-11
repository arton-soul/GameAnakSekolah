package com.example.eduquest.core.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.SettingsRepositoryImpl
import com.example.eduquest.domain.repository.SettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin

object SoundManager {

    private const val SAMPLE_RATE = 44100

    @Volatile
    var isSoundEnabled: Boolean = true
        private set

    @Volatile
    var isMusicEnabled: Boolean = true
        private set

    @Volatile
    var soundVolume: Float = 0.8f
        private set

    @Volatile
    var musicVolume: Float = 0.5f
        private set

    private var isInitialized = false
    private var bgmJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    fun init(
        context: Context,
        settingsRepository: SettingsRepository = SettingsRepositoryImpl(
            context = context.applicationContext,
            database = DatabaseProvider.getDatabase(context.applicationContext)
        )
    ) {
        if (isInitialized) return
        isInitialized = true

        scope.launch {
            settingsRepository.getSettingsFlow().collect { prefs ->
                val prevMusicEnabled = isMusicEnabled
                val prevMusicVol = musicVolume

                isSoundEnabled = prefs.isSoundEnabled
                isMusicEnabled = prefs.isMusicEnabled
                soundVolume = prefs.soundVolume.coerceIn(0f, 1f)
                musicVolume = prefs.musicVolume.coerceIn(0f, 1f)

                if (isMusicEnabled && musicVolume > 0f) {
                    if (bgmJob == null || !prevMusicEnabled || prevMusicVol <= 0f) {
                        startBgmLoop()
                    }
                } else {
                    stopBgmLoop()
                }
            }
        }
    }

    // ==========================================
    // === SOUND EFFECTS (SFX) ===
    // ==========================================

    fun playClick(volumeMultiplier: Float = 1.0f) {
        if (!isSoundEnabled || soundVolume <= 0f) return
        val vol = (soundVolume * volumeMultiplier).coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            playTone(frequency = 1200.0, durationMs = 35, volume = vol)
        }
    }

    fun playCorrect(volumeMultiplier: Float = 1.0f) {
        if (!isSoundEnabled || soundVolume <= 0f) return
        val vol = (soundVolume * volumeMultiplier).coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            // Ascending cheerful chime: C5 -> E5 -> G5 -> C6
            playTone(frequency = 523.25, durationMs = 70, volume = vol)
            playTone(frequency = 659.25, durationMs = 70, volume = vol)
            playTone(frequency = 783.99, durationMs = 70, volume = vol)
            playTone(frequency = 1046.50, durationMs = 150, volume = vol)
        }
    }

    fun playWrong(volumeMultiplier: Float = 1.0f) {
        if (!isSoundEnabled || soundVolume <= 0f) return
        val vol = (soundVolume * volumeMultiplier).coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            // Gentle low two-tone bonk
            playTone(frequency = 349.23, durationMs = 110, volume = vol * 0.9f)
            playTone(frequency = 277.18, durationMs = 150, volume = vol * 0.9f)
        }
    }

    fun playCoin(volumeMultiplier: Float = 1.0f) {
        if (!isSoundEnabled || soundVolume <= 0f) return
        val vol = (soundVolume * volumeMultiplier).coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            // High sparkling gold coin ping
            playTone(frequency = 987.77, durationMs = 60, volume = vol)
            playTone(frequency = 1318.51, durationMs = 140, volume = vol)
        }
    }

    fun playLevelUp(volumeMultiplier: Float = 1.0f) {
        if (!isSoundEnabled || soundVolume <= 0f) return
        val vol = (soundVolume * volumeMultiplier).coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            // Triumphant 5-tone fanfare
            playTone(frequency = 523.25, durationMs = 80, volume = vol)
            playTone(frequency = 659.25, durationMs = 80, volume = vol)
            playTone(frequency = 783.99, durationMs = 80, volume = vol)
            playTone(frequency = 1046.50, durationMs = 100, volume = vol)
            playTone(frequency = 1318.51, durationMs = 240, volume = vol)
        }
    }

    fun playVolumePreview(volume: Float) {
        if (!isSoundEnabled) return
        val vol = volume.coerceIn(0f, 1f)
        scope.launch(Dispatchers.IO) {
            playTone(frequency = 783.99, durationMs = 70, volume = vol)
            playTone(frequency = 1046.50, durationMs = 120, volume = vol)
        }
    }

    // ==========================================
    // === BACKGROUND MUSIC (BGM) ===
    // ==========================================

    fun resumeBgm() {
        if (isMusicEnabled && musicVolume > 0f && bgmJob == null) {
            startBgmLoop()
        }
    }

    fun pauseBgm() {
        stopBgmLoop()
    }

    private fun startBgmLoop() {
        bgmJob?.cancel()
        bgmJob = scope.launch(Dispatchers.IO) {
            // Soothing fantasy pentatonic melody: C4, E4, G4, A4, C5, A4, G4, E4
            val melody = listOf(
                Pair(261.63, 300L), // C4
                Pair(329.63, 300L), // E4
                Pair(392.00, 350L), // G4
                Pair(440.00, 250L), // A4
                Pair(523.25, 450L), // C5
                Pair(440.00, 250L), // A4
                Pair(392.00, 350L), // G4
                Pair(329.63, 400L), // E4
                Pair(293.66, 300L), // D4
                Pair(392.00, 300L), // G4
                Pair(329.63, 350L), // E4
                Pair(261.63, 500L)  // C4
            )

            while (isActive && isMusicEnabled && musicVolume > 0f) {
                for ((freq, dur) in melody) {
                    if (!isActive || !isMusicEnabled || musicVolume <= 0f) break
                    val vol = (musicVolume * 0.35f).coerceIn(0.01f, 0.5f)
                    playSoftTone(frequency = freq, durationMs = dur.toInt(), volume = vol)
                    delay(50L) // subtle breathing gap between notes
                }
                delay(600L) // pause between phrase loops
            }
        }
    }

    private fun stopBgmLoop() {
        bgmJob?.cancel()
        bgmJob = null
    }

    // ==========================================
    // === LOW-LEVEL PCM TONE SYNTHESIS ===
    // ==========================================

    private fun playTone(frequency: Double, durationMs: Int, volume: Float) {
        if (volume <= 0f) return
        val numSamples = (SAMPLE_RATE * durationMs) / 1000
        val buffer = ShortArray(numSamples)
        val angularFreq = 2.0 * PI * frequency / SAMPLE_RATE

        for (i in 0 until numSamples) {
            // Smooth exponential decay envelope
            val t = i.toDouble() / numSamples
            val envelope = exp(-2.5 * t)
            val sample = sin(angularFreq * i) * envelope * Short.MAX_VALUE * volume
            buffer[i] = sample.toInt().coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
        }

        writeAudioTrack(buffer)
    }

    private fun playSoftTone(frequency: Double, durationMs: Int, volume: Float) {
        if (volume <= 0f) return
        val numSamples = (SAMPLE_RATE * durationMs) / 1000
        val buffer = ShortArray(numSamples)
        val angularFreq = 2.0 * PI * frequency / SAMPLE_RATE

        // Bell/Flute attack & decay envelope
        val attackSamples = (numSamples * 0.15).toInt().coerceAtLeast(1)
        for (i in 0 until numSamples) {
            val env = if (i < attackSamples) {
                i.toDouble() / attackSamples
            } else {
                val t = (i - attackSamples).toDouble() / (numSamples - attackSamples)
                exp(-1.8 * t)
            }
            // Add warm 2nd harmonic (octave overtone at 25% amplitude)
            val wave = sin(angularFreq * i) + 0.25 * sin(angularFreq * 2 * i)
            val sample = (wave / 1.25) * env * Short.MAX_VALUE * volume
            buffer[i] = sample.toInt().coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
        }

        writeAudioTrack(buffer)
    }

    private fun writeAudioTrack(buffer: ShortArray) {
        var track: AudioTrack? = null
        try {
            val bufferSize = buffer.size * 2
            track = AudioTrack.Builder()
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build()
                )
                .setAudioFormat(
                    AudioFormat.Builder()
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setSampleRate(SAMPLE_RATE)
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .build()
                )
                .setBufferSizeInBytes(bufferSize)
                .setTransferMode(AudioTrack.MODE_STATIC)
                .build()

            track.write(buffer, 0, buffer.size)
            track.play()

            // Wait for static buffer playback to complete
            val playTimeMs = (buffer.size * 1000L) / SAMPLE_RATE
            Thread.sleep(playTimeMs + 10)
        } catch (_: Exception) {
            // Ignore audio interruptions
        } finally {
            try {
                track?.stop()
                track?.release()
            } catch (_: Exception) {
                // Ignore
            }
        }
    }
}
