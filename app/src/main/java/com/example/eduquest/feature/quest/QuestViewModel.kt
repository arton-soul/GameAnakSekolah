package com.example.eduquest.feature.quest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.QuestRepositoryImpl
import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.repository.QuestRepository
import com.example.eduquest.domain.usecase.CompleteQuestUseCase
import com.example.eduquest.domain.usecase.GetQuestDetailUseCase
import com.example.eduquest.domain.usecase.GetQuestsWithProgressUseCase
import com.example.eduquest.domain.usecase.StartQuestUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuestUiState(
    val isLoading: Boolean = false,
    val questDetail: QuestWithProgress? = null,
    val quests: List<QuestWithProgress> = emptyList(),
    val lastCompletionResult: QuestCompletionResult? = null,
    val error: String? = null
)

class QuestViewModel @JvmOverloads constructor(
    application: Application,
    repository: QuestRepository = QuestRepositoryImpl(
        DatabaseProvider.getDatabase(application).questDao(),
        DatabaseProvider.getDatabase(application).progressDao(),
        DatabaseProvider.getDatabase(application).playerDao()
    )
) : AndroidViewModel(application) {

    private val getQuestsWithProgressUseCase = GetQuestsWithProgressUseCase(repository)
    private val getQuestDetailUseCase = GetQuestDetailUseCase(repository)
    private val startQuestUseCase = StartQuestUseCase(repository)
    private val completeQuestUseCase = CompleteQuestUseCase(repository)

    private val _uiState = MutableStateFlow(QuestUiState())
    val uiState: StateFlow<QuestUiState> = _uiState.asStateFlow()

    fun loadQuestDetail(playerId: String, questId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val detail = getQuestDetailUseCase(playerId, questId)
                _uiState.update { it.copy(isLoading = false, questDetail = detail) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.localizedMessage) }
            }
        }
    }

    fun loadQuests(playerId: String, subjectId: String? = null) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            getQuestsWithProgressUseCase(playerId, subjectId)
                .catch { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.localizedMessage) }
                }
                .collect { list ->
                    _uiState.update { it.copy(isLoading = false, quests = list) }
                }
        }
    }

    fun startQuest(playerId: String, questId: String, onStarted: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                startQuestUseCase(playerId, questId)
                val detail = getQuestDetailUseCase(playerId, questId)
                _uiState.update { it.copy(questDetail = detail) }
                onStarted()
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage) }
            }
        }
    }

    fun completeQuest(
        playerId: String,
        questId: String,
        score: Int,
        totalQuestions: Int,
        onCompleted: (QuestCompletionResult) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                val result = completeQuestUseCase(playerId, questId, score, totalQuestions)
                val detail = getQuestDetailUseCase(playerId, questId)
                _uiState.update {
                    it.copy(
                        lastCompletionResult = result,
                        questDetail = detail
                    )
                }
                onCompleted(result)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage) }
            }
        }
    }
}
