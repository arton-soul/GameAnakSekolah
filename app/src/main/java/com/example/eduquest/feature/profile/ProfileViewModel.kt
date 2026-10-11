package com.example.eduquest.feature.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.local.dao.AchievementDao
import com.example.eduquest.data.local.dao.KnowledgeCardDao
import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.dao.QuestDao
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.data.repository.SettingsRepositoryImpl
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.SettingsRepository
import com.example.eduquest.domain.usecase.ChangeEducationLevelUseCase
import com.example.eduquest.domain.usecase.UpdatePlayerProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ProfileUiState(
    val isLoading: Boolean = true,
    val player: Player? = null,
    val hasPlayer: Boolean = false,
    val levelProgress: LevelProgress = LevelTable.calculateProgress(0),
    val completedQuestsCount: Int = 0,
    val totalQuestsCount: Int = 9,
    val totalQuestionsAnswered: Int = 0,
    val correctAnswersCount: Int = 0,
    val accuracyPercent: Int = 0,
    val unlockedAchievementsCount: Int = 0,
    val totalAchievementsCount: Int = 6,
    val unlockedCardsCount: Int = 0,
    val totalCardsCount: Int = 10,
    val activeWorldName: String = "Kota Pengetahuan",
    val streakDays: Int = 1,
    val error: String? = null
)

class ProfileViewModel @JvmOverloads constructor(
    application: Application,
    private val playerDao: PlayerDao = DatabaseProvider.getDatabase(application).playerDao(),
    private val progressDao: ProgressDao = DatabaseProvider.getDatabase(application).progressDao(),
    private val achievementDao: AchievementDao = DatabaseProvider.getDatabase(application).achievementDao(),
    private val knowledgeCardDao: KnowledgeCardDao = DatabaseProvider.getDatabase(application).knowledgeCardDao(),
    private val questDao: QuestDao = DatabaseProvider.getDatabase(application).questDao(),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(playerDao),
    private val settingsRepository: SettingsRepository = SettingsRepositoryImpl(
        application.applicationContext,
        DatabaseProvider.getDatabase(application)
    )
) : AndroidViewModel(application) {

    private val updatePlayerProfileUseCase = UpdatePlayerProfileUseCase(playerRepository)
    private val changeEducationLevelUseCase = ChangeEducationLevelUseCase(playerRepository, settingsRepository)

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfileData()
    }

    private fun loadProfileData() {
        viewModelScope.launch {
            playerDao.getAllPlayers().collectLatest { playerEntities ->
                if (playerEntities.isEmpty()) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            player = null,
                            hasPlayer = false
                        )
                    }
                } else {
                    val player = playerEntities.first().toDomain()
                    val progress = LevelTable.calculateProgress(player.xp)

                    val completedQuestsFlow = progressDao.getCompletedQuestCountFlow(player.id)
                    val answersCountFlow = progressDao.getTotalAnswersCountFlow(player.id)
                    val correctAnswersFlow = progressDao.getTotalCorrectAnswersCountFlow(player.id)
                    val unlockedAchievementsFlow = achievementDao.getUnlockedCountFlow(player.id)
                    val unlockedCardsFlow = knowledgeCardDao.getUnlockedCardCountFlow(player.id)

                    val totalQuests = try { questDao.getQuestCount() } catch (_: Exception) { 9 }
                    val totalAchievements = try { achievementDao.getAchievementCount() } catch (_: Exception) { 6 }
                    val totalCards = try { knowledgeCardDao.getCardCount() } catch (_: Exception) { 10 }

                    combine(
                        completedQuestsFlow,
                        answersCountFlow,
                        correctAnswersFlow,
                        unlockedAchievementsFlow,
                        unlockedCardsFlow
                    ) { completedQuests, totalAnswers, correctAnswers, achCount, cardCount ->
                        val accuracy = calculateAccuracy(correctAnswers, totalAnswers)
                        val worldTitle = when (player.educationLevel.uppercase()) {
                            "SMP" -> "Benua Eksplorasi Cendekia"
                            "SMA" -> "Akademi Puncak Cendekiawan"
                            else -> "Kota Pengetahuan"
                        }

                        ProfileUiState(
                            isLoading = false,
                            player = player,
                            hasPlayer = true,
                            levelProgress = progress,
                            completedQuestsCount = completedQuests,
                            totalQuestsCount = if (totalQuests > 0) totalQuests else 9,
                            totalQuestionsAnswered = totalAnswers,
                            correctAnswersCount = correctAnswers,
                            accuracyPercent = accuracy,
                            unlockedAchievementsCount = achCount,
                            totalAchievementsCount = if (totalAchievements > 0) totalAchievements else 6,
                            unlockedCardsCount = cardCount,
                            totalCardsCount = if (totalCards > 0) totalCards else 10,
                            activeWorldName = worldTitle,
                            streakDays = 1,
                            error = null
                        )
                        }.collectLatest { state ->
                            _uiState.value = state
                        }
                    }
                }
            }
        }

    fun updateProfile(
        nickname: String,
        grade: Int,
        avatar: String,
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            val currentPlayer = _uiState.value.player ?: return@launch
            val updated = currentPlayer.copy(
                nickname = nickname,
                grade = grade,
                avatar = avatar
            )
            updatePlayerProfileUseCase(updated).fold(
                onSuccess = {
                    _uiState.update { it.copy(player = updated, error = null) }
                    onSuccess()
                },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

    fun changeEducationLevel(
        nickname: String,
        educationLevel: String,
        grade: Int,
        avatar: String,
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            changeEducationLevelUseCase(
                nickname = nickname,
                educationLevel = educationLevel,
                grade = grade,
                avatar = avatar
            ).fold(
                onSuccess = { newPlayer ->
                    _uiState.update { it.copy(player = newPlayer, error = null) }
                    onSuccess()
                },
                onFailure = { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
            )
        }
    }

    companion object {
        fun calculateAccuracy(correctAnswers: Int, totalAnswers: Int): Int {
            if (totalAnswers <= 0) return 0
            if (correctAnswers <= 0) return 0
            val pct = (correctAnswers.toDouble() / totalAnswers.toDouble()) * 100.0
            return pct.toInt().coerceIn(0, 100)
        }
    }
}
