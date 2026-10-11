package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.SettingsRepository

class ChangeEducationLevelUseCase(
    private val playerRepository: PlayerRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(
        nickname: String,
        educationLevel: String,
        grade: Int,
        avatar: String
    ): Result<Player> {
        val trimmed = nickname.trim()
        if (trimmed.isBlank()) {
            return Result.failure(IllegalArgumentException("Nama panggilan tidak boleh kosong"))
        }
        if (trimmed.length < 2) {
            return Result.failure(IllegalArgumentException("Nama panggilan minimal 2 karakter"))
        }
        if (trimmed.length > 20) {
            return Result.failure(IllegalArgumentException("Nama panggilan maksimal 20 karakter"))
        }

        val normalizedLevel = educationLevel.trim().uppercase()
        val validGradeRange = when (normalizedLevel) {
            "SD" -> 1..6
            "SMP" -> 7..9
            "SMA" -> 10..12
            else -> return Result.failure(IllegalArgumentException("Jenjang harus SD, SMP, atau SMA"))
        }

        if (grade !in validGradeRange) {
            return Result.failure(
                IllegalArgumentException("Kelas $grade tidak valid untuk jenjang $normalizedLevel ($validGradeRange)")
            )
        }

        return try {
            settingsRepository.resetAllGameProgress()

            val newPlayer = playerRepository.createPlayer(
                nickname = trimmed,
                educationLevel = normalizedLevel,
                grade = grade,
                avatar = avatar
            )
            Result.success(newPlayer)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
