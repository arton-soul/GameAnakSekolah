package com.example.eduquest.feature.player

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.usecase.AddCoinsUseCase
import com.example.eduquest.domain.usecase.AddPlayerXpUseCase
import com.example.eduquest.domain.usecase.CreatePlayerUseCase
import com.example.eduquest.domain.usecase.GetActivePlayerUseCase
import com.example.eduquest.domain.usecase.SpendCoinsUseCase
import com.example.eduquest.domain.usecase.UpdatePlayerProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PlayerUiState(
    val isLoading: Boolean = true,
    val player: Player? = null,
    val hasPlayer: Boolean = false,
    val levelProgress: LevelProgress = LevelTable.calculateProgress(0),
    val error: String? = null,
    val isCreatedSuccessfully: Boolean = false,
    val lastLevelUpResult: LevelUpResult? = null,
    val lastCoinTransaction: CoinTransactionResult? = null
)

class PlayerViewModel @JvmOverloads constructor(
    application: Application,
    repository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getActivePlayerUseCase = GetActivePlayerUseCase(repository)
    private val createPlayerUseCase = CreatePlayerUseCase(repository)
    private val updatePlayerProfileUseCase = UpdatePlayerProfileUseCase(repository)
    private val addPlayerXpUseCase = AddPlayerXpUseCase(repository)
    private val addCoinsUseCase = AddCoinsUseCase(repository)
    private val spendCoinsUseCase = SpendCoinsUseCase(repository)

    private val _uiState = MutableStateFlow(PlayerUiState())
    val uiState: StateFlow<PlayerUiState> = _uiState.asStateFlow()

    private var lastObservedLevel: Int? = null

    init {
        loadPlayer()
    }

    private fun loadPlayer() {
        viewModelScope.launch {
            getActivePlayerUseCase().collectLatest { player ->
                if (player != null) {
                    val progress = LevelTable.calculateProgress(player.xp)
                    val prevLevel = lastObservedLevel
                    var levelUpResult: LevelUpResult? = null
                    if (prevLevel != null && player.level > prevLevel) {
                        levelUpResult = LevelUpResult(
                            oldLevel = prevLevel,
                            newLevel = player.level,
                            hasLeveledUp = true,
                            bonusCoins = (player.level - prevLevel) * LevelTable.LEVEL_UP_COIN_REWARD,
                            totalXp = player.xp,
                            levelProgress = progress
                        )
                    }
                    lastObservedLevel = player.level

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            player = player,
                            hasPlayer = true,
                            levelProgress = progress,
                            lastLevelUpResult = levelUpResult ?: it.lastLevelUpResult,
                            error = null
                        )
                    }
                } else {
                    lastObservedLevel = null
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            player = null,
                            hasPlayer = false,
                            error = null
                        )
                    }
                }
            }
        }
    }

    fun createPlayer(
        nickname: String,
        educationLevel: String = "SD",
        grade: Int = 1,
        avatar: String = "avatar_kancil",
        onSuccess: () -> Unit = {}
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            val result = createPlayerUseCase(
                nickname = nickname,
                educationLevel = educationLevel,
                grade = grade,
                avatar = avatar
            )
            result.onSuccess { player ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        player = player,
                        hasPlayer = true,
                        levelProgress = LevelTable.calculateProgress(player.xp),
                        isCreatedSuccessfully = true,
                        error = null
                    )
                }
                onSuccess()
            }.onFailure { ex ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = ex.message ?: "Gagal membuat profil"
                    )
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
        val current = _uiState.value.player ?: return
        viewModelScope.launch {
            val updated = current.copy(
                nickname = nickname,
                grade = grade,
                avatar = avatar
            )
            val result = updatePlayerProfileUseCase(updated)
            result.onSuccess {
                onSuccess()
            }.onFailure { ex ->
                _uiState.update { it.copy(error = ex.message) }
            }
        }
    }

    fun addXp(amount: Int, onResult: (LevelUpResult) -> Unit = {}) {
        val player = _uiState.value.player ?: return
        viewModelScope.launch {
            try {
                val result = addPlayerXpUseCase(player.id, amount)
                if (result.hasLeveledUp) {
                    _uiState.update { it.copy(lastLevelUpResult = result) }
                }
                onResult(result)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage) }
            }
        }
    }

    fun addCoins(amount: Int, onResult: (CoinTransactionResult) -> Unit = {}) {
        val player = _uiState.value.player ?: return
        viewModelScope.launch {
            try {
                val result = addCoinsUseCase(player.id, amount)
                _uiState.update { it.copy(lastCoinTransaction = result) }
                onResult(result)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage) }
            }
        }
    }

    fun spendCoins(amount: Int, onResult: (CoinTransactionResult) -> Unit = {}) {
        val player = _uiState.value.player ?: return
        viewModelScope.launch {
            try {
                val result = spendCoinsUseCase(player.id, amount)
                _uiState.update { it.copy(lastCoinTransaction = result) }
                onResult(result)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage) }
            }
        }
    }

    fun clearCoinTransaction() {
        _uiState.update { it.copy(lastCoinTransaction = null) }
    }

    fun dismissLevelUpDialog() {
        _uiState.update { it.copy(lastLevelUpResult = null) }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}
