package com.example.eduquest.feature.world

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.data.repository.QuestRepositoryImpl
import com.example.eduquest.data.repository.WorldRepositoryImpl
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.seed.QuestStarterData
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.model.WorldAreaWithProgress
import com.example.eduquest.domain.model.WorldWithProgress
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.QuestRepository
import com.example.eduquest.domain.repository.WorldRepository
import com.example.eduquest.domain.usecase.GetQuestsWithProgressUseCase
import com.example.eduquest.domain.usecase.GetWorldWithAreasUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class WorldUiState(
    val isLoading: Boolean = true,
    val worldWithProgress: WorldWithProgress? = null,
    val selectedSubjectId: String? = null,
    val quests: List<QuestWithProgress> = emptyList(),
    val playerLevel: Int = 1,
    val lockedNotice: String? = null,
    val error: String? = null
) {
    val filteredQuests: List<QuestWithProgress>
        get() = if (selectedSubjectId == null) {
            quests
        } else {
            quests.filter { it.quest.subjectId.equals(selectedSubjectId, ignoreCase = true) }
        }

    val selectedArea: WorldAreaWithProgress?
        get() = worldWithProgress?.areas?.firstOrNull { it.area.subjectId.equals(selectedSubjectId, ignoreCase = true) }
}

class WorldViewModel @JvmOverloads constructor(
    application: Application,
    private val worldRepository: WorldRepository = WorldRepositoryImpl(
        worldDao = DatabaseProvider.getDatabase(application).worldDao(),
        questDao = DatabaseProvider.getDatabase(application).questDao(),
        progressDao = DatabaseProvider.getDatabase(application).progressDao(),
        playerDao = DatabaseProvider.getDatabase(application).playerDao()
    ),
    private val questRepository: QuestRepository = QuestRepositoryImpl(
        questDao = DatabaseProvider.getDatabase(application).questDao(),
        progressDao = DatabaseProvider.getDatabase(application).progressDao(),
        playerDao = DatabaseProvider.getDatabase(application).playerDao()
    ),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getWorldWithAreasUseCase = GetWorldWithAreasUseCase(worldRepository)
    private val getQuestsWithProgressUseCase = GetQuestsWithProgressUseCase(questRepository)

    private val _uiState = MutableStateFlow(WorldUiState())
    val uiState: StateFlow<WorldUiState> = _uiState.asStateFlow()

    init {
        loadWorld()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun loadWorld(
        playerId: String? = null,
        worldId: String = "WORLD_01"
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                questRepository.ensureStarterQuestsSeeded()
                worldRepository.ensureStarterWorldsSeeded()

                playerRepository.getActivePlayer().flatMapLatest { player ->
                    val activePlayerId = playerId ?: player?.id ?: "PLAYER_LOCAL"
                    val resolvedLevel = player?.level ?: 1
                    val targetWorldId = player?.currentWorldId ?: worldId

                    combine(
                        getWorldWithAreasUseCase(activePlayerId, targetWorldId),
                        getQuestsWithProgressUseCase(activePlayerId, null)
                    ) { worldData, questsList ->
                        val resolvedQuests = questsList.ifEmpty {
                            QuestStarterData.STARTER_QUESTS.map { qe ->
                                QuestWithProgress(
                                    quest = qe.toDomain(),
                                    status = if (resolvedLevel >= qe.unlockLevel) QuestStatus.AVAILABLE else QuestStatus.LOCKED
                                )
                            }
                        }
                        Triple(worldData, resolvedQuests, resolvedLevel)
                    }
                }.collectLatest { triple ->
                    val (worldData, questsList, resolvedLevel) = triple
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            worldWithProgress = worldData,
                            quests = questsList,
                            playerLevel = resolvedLevel
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Gagal memuat dunia petualangan"
                    )
                }
            }
        }
    }

    fun selectSubject(subjectId: String?) {
        if (subjectId == null) {
            _uiState.update { it.copy(selectedSubjectId = null, lockedNotice = null) }
            return
        }

        val area = _uiState.value.worldWithProgress?.areas?.firstOrNull {
            it.area.subjectId.equals(subjectId, ignoreCase = true)
        }

        if (area != null && !area.isUnlocked) {
            _uiState.update {
                it.copy(
                    lockedNotice = "🔒 Area ${area.area.name} terkunci! Capai Level ${area.area.unlockLevel} untuk membuka petualangan ini."
                )
            }
        } else {
            _uiState.update {
                it.copy(selectedSubjectId = subjectId, lockedNotice = null)
            }
        }
    }

    fun dismissNotice() {
        _uiState.update { it.copy(lockedNotice = null) }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    fun refresh(playerId: String = "PLAYER_LOCAL") {
        loadWorld(playerId)
    }
}
