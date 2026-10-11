package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository

class CreatePlayerUseCase(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(
        nickname: String,
        educationLevel: String = "SD",
        grade: Int = 1,
        avatar: String = "avatar_kancil"
    ): Result<Player> {
        val trimmed = nickname.trim()
        if (trimmed.isBlank()) {
            return Result.failure(IllegalArgumentException("Nama panggilan tidak boleh kosong"))
        }
        if (trimmed.length < 2) {
            return Result.failure(IllegalArgumentException("Nama panggilan minimal 2 karakter"))
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
            val player = playerRepository.createPlayer(
                nickname = trimmed,
                educationLevel = normalizedLevel,
                grade = grade,
                avatar = avatar
            )
            Result.success(player)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
