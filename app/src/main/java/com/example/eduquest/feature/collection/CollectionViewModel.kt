package com.example.eduquest.feature.collection

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.KnowledgeCardRepositoryImpl
import com.example.eduquest.domain.model.KnowledgeCardWithStatus
import com.example.eduquest.domain.repository.KnowledgeCardRepository
import com.example.eduquest.domain.usecase.GetKnowledgeCardsUseCase
import com.example.eduquest.domain.usecase.SyncKnowledgeCardsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.domain.repository.PlayerRepository

data class CollectionUiState(
    val isLoading: Boolean = true,
    val cards: List<KnowledgeCardWithStatus> = emptyList(),
    val selectedCategory: String = "ALL",
    val categories: List<String> = listOf("ALL"),
    val unlockedCount: Int = 0,
    val totalCount: Int = 0,
    val selectedCard: KnowledgeCardWithStatus? = null,
    val error: String? = null
) {
    val filteredCards: List<KnowledgeCardWithStatus>
        get() = if (selectedCategory == "ALL" || selectedCategory == "Semua") {
            cards
        } else {
            cards.filter { it.card.category.equals(selectedCategory, ignoreCase = true) }
        }

    val collectionPercentage: Int
        get() = if (totalCount > 0) (unlockedCount * 100) / totalCount else 0
}

class CollectionViewModel @JvmOverloads constructor(
    application: Application,
    knowledgeCardRepository: KnowledgeCardRepository = KnowledgeCardRepositoryImpl(
        knowledgeCardDao = DatabaseProvider.getDatabase(application).knowledgeCardDao(),
        progressDao = DatabaseProvider.getDatabase(application).progressDao(),
        playerDao = DatabaseProvider.getDatabase(application).playerDao()
    ),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getKnowledgeCardsUseCase = GetKnowledgeCardsUseCase(knowledgeCardRepository)
    private val syncKnowledgeCardsUseCase = SyncKnowledgeCardsUseCase(knowledgeCardRepository)

    private val _uiState = MutableStateFlow(CollectionUiState())
    val uiState: StateFlow<CollectionUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            playerRepository.getActivePlayer().collect { player ->
                val activeId = player?.id ?: "PLAYER_LOCAL"
                loadCards(activeId)
            }
        }
    }

    fun loadCards(playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }

            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                // Ensure completed quests grant their cards
                syncKnowledgeCardsUseCase(effectivePlayerId)

                getKnowledgeCardsUseCase(effectivePlayerId, "ALL").collect { cardList ->
                    val distinctCategories = listOf("ALL") + cardList.map { it.card.category }.distinct()
                    val unlocked = cardList.count { it.isUnlocked }

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            cards = cardList,
                            categories = distinctCategories,
                            unlockedCount = unlocked,
                            totalCount = cardList.size
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Gagal memuat kartu pengetahuan"
                    )
                }
            }
        }
    }

    fun selectCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun openCardDetail(card: KnowledgeCardWithStatus) {
        _uiState.update { it.copy(selectedCard = card) }
    }

    fun closeCardDetail() {
        _uiState.update { it.copy(selectedCard = null) }
    }

    fun refresh(playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
                playerId
            } else {
                playerRepository.getActivePlayerDirect()?.id ?: playerId
            }
            loadCards(effectivePlayerId)
        }
    }
}
