package com.example.eduquest.feature.leaderboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.remote.FirebaseLeaderboardRepository
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.domain.model.LeaderboardEntry
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.LeaderboardRepository
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LeaderboardUiState(
    val isLoading: Boolean = false,
    val selectedLevel: String = "SD",
    val entries: List<LeaderboardEntry> = emptyList(),
    val currentPlayer: Player? = null,
    val currentPlayerEntry: LeaderboardEntry? = null,
    val message: String? = null
) {
    val topThree: List<LeaderboardEntry>
        get() = entries.take(3)

    val remainingEntries: List<LeaderboardEntry>
        get() = if (entries.size > 3) entries.drop(3) else emptyList()
}

class LeaderboardViewModel @JvmOverloads constructor(
    application: Application,
    private val leaderboardRepository: LeaderboardRepository = FirebaseLeaderboardRepository(application.applicationContext),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao())
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(LeaderboardUiState(isLoading = true))
    val uiState: StateFlow<LeaderboardUiState> = _uiState.asStateFlow()

    init {
        observeActivePlayer()
    }

    private fun observeActivePlayer() {
        viewModelScope.launch {
            playerRepository.getActivePlayer().collectLatest { player ->
                val targetLevel = player?.educationLevel?.uppercase() ?: "SD"
                _uiState.update {
                    it.copy(
                        currentPlayer = player,
                        selectedLevel = targetLevel
                    )
                }
                loadLeaderboard(targetLevel, player)

                // Sync current player's score to cloud in background
                if (player != null) {
                    try {
                        leaderboardRepository.syncPlayerScoreToCloud(player)
                    } catch (_: Exception) {}
                }
            }
        }
    }

    fun selectLevel(level: String) {
        val upper = level.uppercase()
        _uiState.update { it.copy(selectedLevel = upper) }
        loadLeaderboard(upper, _uiState.value.currentPlayer)
    }

    private fun loadLeaderboard(level: String, player: Player?) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            leaderboardRepository.getLeaderboardFlow(level, player).collectLatest { list ->
                val myEntry = list.firstOrNull { it.isCurrentPlayer }
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        entries = list,
                        currentPlayerEntry = myEntry
                    )
                }
            }
        }
    }

    fun clearMessage() {
        _uiState.update { it.copy(message = null) }
    }
}
