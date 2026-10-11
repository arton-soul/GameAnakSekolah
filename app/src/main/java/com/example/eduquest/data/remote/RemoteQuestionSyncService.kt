package com.example.eduquest.data.remote

import android.content.Context
import com.example.eduquest.data.local.dao.QuestionDao
import com.example.eduquest.data.local.entity.QuestionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

data class SyncResult(
    val isSuccess: Boolean,
    val updatedCount: Int = 0,
    val currentVersion: Int = 1,
    val remoteVersion: Int = 1,
    val message: String
)

class RemoteQuestionSyncService(
    private val context: Context,
    private val questionDao: QuestionDao
) {

    companion object {
        private const val PREFS_NAME = "eduquest_remote_sync"
        private const val KEY_CONTENT_VERSION = "local_content_version"
        private const val KEY_LAST_SYNC_TIME = "last_sync_timestamp"

        // Official GitHub Raw repository URL
        private const val BASE_GITHUB_URL = "https://raw.githubusercontent.com/arton-soul/GameAnakSekolah/main/"
        private const val MANIFEST_URL = BASE_GITHUB_URL + "bank_soal/manifest.json"
        private const val TIMEOUT_MS = 10000
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getLocalContentVersion(): Int {
        return prefs.getInt(KEY_CONTENT_VERSION, 1)
    }

    fun getLastSyncTime(): Long {
        return prefs.getLong(KEY_LAST_SYNC_TIME, 0L)
    }

    suspend fun syncQuestionsFromGitHub(force: Boolean = false): SyncResult = withContext(Dispatchers.IO) {
        try {
            val localVersion = getLocalContentVersion()

            // 1. Fetch remote manifest
            val manifestJsonString = fetchUrl(MANIFEST_URL)
                ?: return@withContext SyncResult(
                    isSuccess = false,
                    currentVersion = localVersion,
                    message = "Gagal menghubungkan ke server GitHub. Periksa koneksi internet."
                )

            val manifestObj = JSONObject(manifestJsonString)
            val remoteVersion = manifestObj.optInt("content_version", 1)

            if (!force && remoteVersion <= localVersion) {
                return@withContext SyncResult(
                    isSuccess = true,
                    updatedCount = 0,
                    currentVersion = localVersion,
                    remoteVersion = remoteVersion,
                    message = "Bank soal sudah versi terbaru (v$localVersion)."
                )
            }

            // 2. Fetch questions from each endpoint declared in manifest
            val endpoints = manifestObj.optJSONObject("endpoints")
            val allParsedQuestions = mutableListOf<QuestionEntity>()

            val keys = endpoints?.keys() ?: return@withContext SyncResult(
                isSuccess = false,
                currentVersion = localVersion,
                message = "Format endpoints bank soal di manifest tidak valid."
            )

            while (keys.hasNext()) {
                val key = keys.next()
                val relativePath = endpoints.getString(key)
                val fullUrl = BASE_GITHUB_URL + relativePath
                val questionsJsonString = fetchUrl(fullUrl)

                if (questionsJsonString != null) {
                    val parsed = parseQuestionsArray(questionsJsonString)
                    allParsedQuestions.addAll(parsed)
                }
            }

            if (allParsedQuestions.isNotEmpty()) {
                // 3. Upsert questions into Room SQLite Database
                questionDao.insertQuestions(allParsedQuestions)

                // 4. Update saved version in SharedPreferences
                prefs.edit()
                    .putInt(KEY_CONTENT_VERSION, remoteVersion)
                    .putLong(KEY_LAST_SYNC_TIME, System.currentTimeMillis())
                    .apply()

                return@withContext SyncResult(
                    isSuccess = true,
                    updatedCount = allParsedQuestions.size,
                    currentVersion = remoteVersion,
                    remoteVersion = remoteVersion,
                    message = "Berhasil memperbarui ${allParsedQuestions.size} soal baru dari GitHub (v$remoteVersion)!"
                )
            } else {
                return@withContext SyncResult(
                    isSuccess = false,
                    currentVersion = localVersion,
                    remoteVersion = remoteVersion,
                    message = "Tidak ada soal baru yang dapat diunduh."
                )
            }
        } catch (e: Exception) {
            SyncResult(
                isSuccess = false,
                currentVersion = getLocalContentVersion(),
                message = "Kesalahan sinkronisasi: ${e.localizedMessage ?: "Koneksi terputus"}"
            )
        }
    }

    private fun parseQuestionsArray(jsonString: String): List<QuestionEntity> {
        val list = mutableListOf<QuestionEntity>()
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)
            list.add(
                QuestionEntity(
                    id = obj.getString("id"),
                    grade = obj.optInt("grade", 1),
                    subjectId = obj.optString("subjectId", "GENERAL"),
                    topicId = obj.optString("topicId", "Umum"),
                    difficulty = obj.optString("difficulty", "EASY"),
                    type = obj.optString("type", "MULTIPLE_CHOICE"),
                    question = obj.getString("question"),
                    optionA = obj.optString("optionA", ""),
                    optionB = obj.optString("optionB", ""),
                    optionC = obj.optString("optionC", ""),
                    optionD = obj.optString("optionD", ""),
                    answer = obj.getString("answer"),
                    explanation = obj.optString("explanation", ""),
                    xp = obj.optInt("xp", 100),
                    educationLevel = obj.optString("educationLevel", "SD"),
                    isExam = obj.optBoolean("isExam", false)
                )
            )
        }
        return list
    }

    private fun fetchUrl(urlString: String): String? {
        var conn: HttpURLConnection? = null
        return try {
            val url = URL(urlString)
            conn = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "GET"
                connectTimeout = TIMEOUT_MS
                readTimeout = TIMEOUT_MS
                setRequestProperty("User-Agent", "EduQuest-Android-App")
            }

            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader(InputStreamReader(conn.inputStream, Charsets.UTF_8)).use { reader ->
                    reader.readText()
                }
            } else {
                null
            }
        } catch (_: Exception) {
            null
        } finally {
            conn?.disconnect()
        }
    }
}
