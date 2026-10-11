package com.example.eduquest.domain.usecase

import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository

class UpdatePlayerProfileUseCase(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(player: Player): Result<Unit> {
        val trimmed = player.nickname.trim()
        if (trimmed.isBlank()) {
            return Result.failure(IllegalArgumentException("Nama panggilan tidak boleh kosong"))
        }
        if (trimmed.length < 2) {
            return Result.failure(IllegalArgumentException("Nama panggilan minimal 2 karakter"))
        }
        if (trimmed.length > 20) {
            return Result.failure(IllegalArgumentException("Nama panggilan maksimal 20 karakter"))
        }
        val validGradeRange = when (player.educationLevel.trim().uppercase()) {
            "SMP" -> 7..9
            "SMA" -> 10..12
            else -> 1..6
        }
        if (player.grade !in validGradeRange) {
            return Result.failure(
                IllegalArgumentException("Kelas ${player.grade} tidak valid untuk jenjang ${player.educationLevel} ($validGradeRange)")
            )
        }
        val targetWorldId = when (player.educationLevel.trim().uppercase()) {
            "SMP" -> "WORLD_SMP_01"
            "SMA" -> "WORLD_SMA_01"
            else -> "WORLD_01"
        }
        return try {
            playerRepository.updatePlayer(player.copy(nickname = trimmed, currentWorldId = targetWorldId))
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
