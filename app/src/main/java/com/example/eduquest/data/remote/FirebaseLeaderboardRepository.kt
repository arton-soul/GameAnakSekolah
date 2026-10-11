package com.example.eduquest.data.remote

import android.content.Context
import com.example.eduquest.domain.model.LeaderboardEntry
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.LeaderboardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class FirebaseLeaderboardRepository(
    private val context: Context,
    private val projectId: String = "gameanaksekolah-eduquest"
) : LeaderboardRepository {

    // Default National Competitors (Simulasi Pelajar Berprestasi se-Nusantara)
    private val starterSdLeaderboard = listOf(
        LeaderboardEntry(playerId = "BOT_SD_01", nickname = "Rafi Pratama", avatar = "Singa", educationLevel = "SD", grade = 5, totalXp = 4850, level = 12),
        LeaderboardEntry(playerId = "BOT_SD_02", nickname = "Aisyah Putri", avatar = "Hantu", educationLevel = "SD", grade = 6, totalXp = 4320, level = 11),
        LeaderboardEntry(playerId = "BOT_SD_03", nickname = "Dimas Setiawan", avatar = "Elang", educationLevel = "SD", grade = 4, totalXp = 3780, level = 10),
        LeaderboardEntry(playerId = "BOT_SD_04", nickname = "Siti Rahma", avatar = "Lumba", educationLevel = "SD", grade = 5, totalXp = 3250, level = 9),
        LeaderboardEntry(playerId = "BOT_SD_05", nickname = "Bima Sakti", avatar = "Kancil", educationLevel = "SD", grade = 3, totalXp = 2900, level = 8),
        LeaderboardEntry(playerId = "BOT_SD_06", nickname = "Dewi Lestari", avatar = "Hantu", educationLevel = "SD", grade = 4, totalXp = 2540, level = 7),
        LeaderboardEntry(playerId = "BOT_SD_07", nickname = "Kevin Wijaya", avatar = "Singa", educationLevel = "SD", grade = 2, totalXp = 2100, level = 6),
        LeaderboardEntry(playerId = "BOT_SD_08", nickname = "Nabila Syakieb", avatar = "Lumba", educationLevel = "SD", grade = 3, totalXp = 1750, level = 5),
        LeaderboardEntry(playerId = "BOT_SD_09", nickname = "Arka Pratama", avatar = "Elang", educationLevel = "SD", grade = 1, totalXp = 1420, level = 4),
        LeaderboardEntry(playerId = "BOT_SD_10", nickname = "Cinta Laura", avatar = "Kancil", educationLevel = "SD", grade = 2, totalXp = 980, level = 3)
    )

    private val starterSmpLeaderboard = listOf(
        LeaderboardEntry(playerId = "BOT_SMP_01", nickname = "Fajar Nusantara", avatar = "Elang", educationLevel = "SMP", grade = 9, totalXp = 7200, level = 16),
        LeaderboardEntry(playerId = "BOT_SMP_02", nickname = "Zahra Anindya", avatar = "Hantu", educationLevel = "SMP", grade = 9, totalXp = 6840, level = 15),
        LeaderboardEntry(playerId = "BOT_SMP_03", nickname = "Rizky Ramadhan", avatar = "Singa", educationLevel = "SMP", grade = 8, totalXp = 6120, level = 14),
        LeaderboardEntry(playerId = "BOT_SMP_04", nickname = "Tiara Andini", avatar = "Lumba", educationLevel = "SMP", grade = 8, totalXp = 5400, level = 13),
        LeaderboardEntry(playerId = "BOT_SMP_05", nickname = "Aldi Taher", avatar = "Kancil", educationLevel = "SMP", grade = 7, totalXp = 4950, level = 12),
        LeaderboardEntry(playerId = "BOT_SMP_06", nickname = "Salma Salsabil", avatar = "Hantu", educationLevel = "SMP", grade = 7, totalXp = 4210, level = 11),
        LeaderboardEntry(playerId = "BOT_SMP_07", nickname = "Gibran Rakabumi", avatar = "Singa", educationLevel = "SMP", grade = 7, totalXp = 3600, level = 10)
    )

    private val starterSmaLeaderboard = listOf(
        LeaderboardEntry(playerId = "BOT_SMA_01", nickname = "Maulana Malik", avatar = "Elang", educationLevel = "SMA", grade = 12, totalXp = 11400, level = 22),
        LeaderboardEntry(playerId = "BOT_SMA_02", nickname = "Cantika Abigail", avatar = "Hantu", educationLevel = "SMA", grade = 12, totalXp = 10850, level = 21),
        LeaderboardEntry(playerId = "BOT_SMA_03", nickname = "Rehan Kurniawan", avatar = "Singa", educationLevel = "SMA", grade = 11, totalXp = 9920, level = 20),
        LeaderboardEntry(playerId = "BOT_SMA_04", nickname = "Tasya Kamila", avatar = "Lumba", educationLevel = "SMA", grade = 11, totalXp = 8750, level = 18),
        LeaderboardEntry(playerId = "BOT_SMA_05", nickname = "Bagus Suryanto", avatar = "Kancil", educationLevel = "SMA", grade = 10, totalXp = 7600, level = 16),
        LeaderboardEntry(playerId = "BOT_SMA_06", nickname = "Putri Marino", avatar = "Hantu", educationLevel = "SMA", grade = 10, totalXp = 6450, level = 14)
    )

    override fun getLeaderboardFlow(
        educationLevel: String,
        currentPlayer: Player?
    ): Flow<List<LeaderboardEntry>> = flow {
        val baseList = when (educationLevel.uppercase()) {
            "SMP" -> starterSmpLeaderboard
            "SMA" -> starterSmaLeaderboard
            else -> starterSdLeaderboard
        }.toMutableList()

        // Insert / Merge Current Player if player matches this level
        if (currentPlayer != null && currentPlayer.educationLevel.equals(educationLevel, ignoreCase = true)) {
            val playerEntry = LeaderboardEntry(
                playerId = currentPlayer.id,
                nickname = "${currentPlayer.nickname} (Saya)",
                avatar = currentPlayer.avatar,
                educationLevel = currentPlayer.educationLevel,
                grade = currentPlayer.grade,
                totalXp = currentPlayer.xp,
                level = currentPlayer.level,
                isCurrentPlayer = true
            )
            // Remove previous duplicate if any
            baseList.removeAll { it.playerId == currentPlayer.id }
            baseList.add(playerEntry)
        }

        // Sort descending by totalXp and assign ranks
        val rankedList = baseList
            .sortedByDescending { it.totalXp }
            .mapIndexed { index, entry ->
                entry.copy(rank = index + 1)
            }

        emit(rankedList)
    }.flowOn(Dispatchers.IO)

    override suspend fun syncPlayerScoreToCloud(player: Player): Unit = withContext(Dispatchers.IO) {
        try {
            // Firestore REST API Endpoint (non-blocking, fallback graceful)
            val restUrl = "https://firestore.googleapis.com/v1/projects/$projectId/databases/(default)/documents/leaderboard/${player.id}"
            val url = URL(restUrl)
            val conn = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "PATCH"
                connectTimeout = 5000
                readTimeout = 5000
                doOutput = true
                setRequestProperty("Content-Type", "application/json")
            }

            val payload = JSONObject()
            val fields = JSONObject()

            fields.put("nickname", JSONObject().apply { put("stringValue", player.nickname) })
            fields.put("avatar", JSONObject().apply { put("stringValue", player.avatar) })
            fields.put("educationLevel", JSONObject().apply { put("stringValue", player.educationLevel) })
            fields.put("grade", JSONObject().apply { put("integerValue", player.grade.toString()) })
            fields.put("totalXp", JSONObject().apply { put("integerValue", player.xp.toString()) })
            fields.put("level", JSONObject().apply { put("integerValue", player.level.toString()) })

            payload.put("fields", fields)

            OutputStreamWriter(conn.outputStream).use { writer ->
                writer.write(payload.toString())
                writer.flush()
            }

            conn.responseCode // execute
            conn.disconnect()
        } catch (_: Exception) {
            // Gracefully ignore network errors in offline mode
        }
    }
}
