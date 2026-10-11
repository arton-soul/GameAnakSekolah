package com.example.eduquest.feature.achievement

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.AchievementRepositoryImpl
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.domain.model.AchievementWithProgress
import com.example.eduquest.domain.repository.AchievementRepository
import com.example.eduquest.domain.usecase.EvaluateAchievementsUseCase
import com.example.eduquest.domain.usecase.GetAchievementsWithProgressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import com.example.eduquest.domain.repository.PlayerRepository

enum class AchievementFilter {
    ALL,
    UNLOCKED,
    LOCKED
}

data class AchievementUiState(
    val isLoading: Boolean = true,
    val achievements: List<AchievementWithProgress> = emptyList(),
    val selectedFilter: AchievementFilter = AchievementFilter.ALL,
    val totalCount: Int = 0,
    val unlockedCount: Int = 0,
    val completionPercentage: Int = 0,
    val error: String? = null
) {
    val filteredAchievements: List<AchievementWithProgress>
        get() = when (selectedFilter) {
            AchievementFilter.ALL -> achievements
            AchievementFilter.UNLOCKED -> achievements.filter { it.isUnlocked }
            AchievementFilter.LOCKED -> achievements.filter { !it.isUnlocked }
        }
}

class AchievementViewModel @JvmOverloads constructor(
    application: Application,
    achievementRepository: AchievementRepository = AchievementRepositoryImpl(
        achievementDao = DatabaseProvider.getDatabase(application).achievementDao(),
        progressDao = DatabaseProvider.getDatabase(application).progressDao(),
        playerDao = DatabaseProvider.getDatabase(application).playerDao(),
        playerRepository = PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao())
    ),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getAchievementsWithProgressUseCase = GetAchievementsWithProgressUseCase(achievementRepository)
    private val evaluateAchievementsUseCase = EvaluateAchievementsUseCase(achievementRepository)

    private val _uiState = MutableStateFlow(AchievementUiState())
    val uiState: StateFlow<AchievementUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            playerRepository.getActivePlayer().collect { player ->
                val activeId = player?.id ?: "PLAYER_LOCAL"
                loadAchievements(activeId)
            }
        }
    }

    fun loadAchievements(playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }

            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                // Synchronize progress and evaluate any newly reached goals
                evaluateAchievementsUseCase(effectivePlayerId)

                getAchievementsWithProgressUseCase(effectivePlayerId).collect { list ->
                    val unlocked = list.count { it.isUnlocked }
                    val total = list.size
                    val percent = if (total > 0) (unlocked * 100) / total else 0

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            achievements = list,
                            totalCount = total,
                            unlockedCount = unlocked,
                            completionPercentage = percent
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Gagal memuat pencapaian"
                    )
                }
            }
        }
    }

    fun setFilter(filter: AchievementFilter) {
        _uiState.update { it.copy(selectedFilter = filter) }
    }

    fun refresh(playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }
            try {
                evaluateAchievementsUseCase(effectivePlayerId)
            } catch (e: Exception) {
                // Ignore
            }
        }
    }
}
