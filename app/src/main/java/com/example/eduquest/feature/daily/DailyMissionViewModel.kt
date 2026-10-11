package com.example.eduquest.feature.daily

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.data.repository.DailyMissionRepositoryImpl
import com.example.eduquest.data.repository.KnowledgeCardRepositoryImpl
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.DailyRewardClaimResult
import com.example.eduquest.domain.repository.DailyMissionRepository
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.usecase.ClaimDailyRewardUseCase
import com.example.eduquest.domain.usecase.GetDailyMissionsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DailyMissionUiState(
    val isLoading: Boolean = true,
    val missions: List<DailyMissionWithProgress> = emptyList(),
    val dateString: String = "",
    val displayDate: String = "",
    val completedCount: Int = 0,
    val claimedCount: Int = 0,
    val totalCount: Int = 0,
    val claimSuccessResult: DailyRewardClaimResult.Success? = null,
    val error: String? = null
) {
    val allCompleted: Boolean
        get() = totalCount > 0 && completedCount >= totalCount

    val allClaimed: Boolean
        get() = totalCount > 0 && claimedCount >= totalCount

    val completionPercentage: Int
        get() = if (totalCount > 0) (completedCount * 100) / totalCount else 0

    val totalAvailableXp: Int
        get() = missions.sumOf { it.mission.rewardXp }

    val totalAvailableCoins: Int
        get() = missions.sumOf { it.mission.rewardCoins }
}

class DailyMissionViewModel @JvmOverloads constructor(
    application: Application,
    dailyMissionRepository: DailyMissionRepository = DailyMissionRepositoryImpl(
        dailyMissionDao = DatabaseProvider.getDatabase(application).dailyMissionDao(),
        playerRepository = PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao()),
        knowledgeCardRepository = KnowledgeCardRepositoryImpl(
            knowledgeCardDao = DatabaseProvider.getDatabase(application).knowledgeCardDao(),
            progressDao = DatabaseProvider.getDatabase(application).progressDao()
        )
    ),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getDailyMissionsUseCase = GetDailyMissionsUseCase(dailyMissionRepository)
    private val claimDailyRewardUseCase = ClaimDailyRewardUseCase(dailyMissionRepository)

    private val _uiState = MutableStateFlow(DailyMissionUiState())
    val uiState: StateFlow<DailyMissionUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            playerRepository.getActivePlayer().collect { player ->
                val activeId = player?.id ?: "PLAYER_LOCAL"
                loadDailyMissions(activeId)
            }
        }
    }

    fun loadDailyMissions(
        playerId: String = "PLAYER_LOCAL",
        dateString: String = DailyDateUtils.getTodayDateString()
    ) {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }

            _uiState.update {
                it.copy(
                    isLoading = true,
                    dateString = dateString,
                    displayDate = DailyDateUtils.formatDisplayDate(dateString),
                    error = null
                )
            }

            try {
                getDailyMissionsUseCase(effectivePlayerId, dateString).collect { missionList ->
                    val completed = missionList.count { it.isCompleted }
                    val claimed = missionList.count { it.isClaimed }

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            missions = missionList,
                            totalCount = missionList.size,
                            completedCount = completed,
                            claimedCount = claimed
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Gagal memuat misi harian"
                    )
                }
            }
        }
    }

    fun claimReward(missionId: String, playerId: String = "PLAYER_LOCAL") {
        val currentDate = _uiState.value.dateString.ifEmpty { DailyDateUtils.getTodayDateString() }
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }
            when (val result = claimDailyRewardUseCase(effectivePlayerId, missionId, currentDate)) {
                is DailyRewardClaimResult.Success -> {
                    _uiState.update { it.copy(claimSuccessResult = result) }
                }
                is DailyRewardClaimResult.AlreadyClaimed -> {
                    _uiState.update { it.copy(error = "Hadiah misi ini sudah pernah diklaim hari ini.") }
                }
                is DailyRewardClaimResult.NotCompleted -> {
                    _uiState.update { it.copy(error = "Misi belum selesai. Selesaikan target misi terlebih dahulu!") }
                }
                is DailyRewardClaimResult.MissionNotFound -> {
                    _uiState.update { it.copy(error = "Misi tidak ditemukan.") }
                }
                is DailyRewardClaimResult.Error -> {
                    _uiState.update { it.copy(error = result.message) }
                }
            }
        }
    }

    fun dismissClaimSuccess() {
        _uiState.update { it.copy(claimSuccessResult = null) }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    fun refresh(playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }
            loadDailyMissions(effectivePlayerId, _uiState.value.dateString.ifEmpty { DailyDateUtils.getTodayDateString() })
        }
    }
}
