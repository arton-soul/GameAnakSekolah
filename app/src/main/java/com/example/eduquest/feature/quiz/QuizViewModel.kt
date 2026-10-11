package com.example.eduquest.feature.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.repository.AchievementRepositoryImpl
import com.example.eduquest.data.repository.KnowledgeCardRepositoryImpl
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.data.repository.QuestionRepositoryImpl
import com.example.eduquest.data.repository.QuestRepositoryImpl
import com.example.eduquest.data.repository.DailyMissionRepositoryImpl
import com.example.eduquest.domain.model.AnswerValidationResult
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.repository.QuestionRepository
import com.example.eduquest.domain.repository.QuestRepository
import com.example.eduquest.domain.repository.DailyMissionRepository
import com.example.eduquest.domain.usecase.AddPlayerXpUseCase
import com.example.eduquest.domain.usecase.CompleteQuestUseCase
import com.example.eduquest.domain.usecase.EvaluateAchievementsUseCase
import com.example.eduquest.domain.usecase.RecordDailyProgressUseCase
import com.example.eduquest.domain.usecase.UnlockKnowledgeCardUseCase
import com.example.eduquest.domain.usecase.GetQuestionsForQuestUseCase
import com.example.eduquest.domain.usecase.RecordAnswerUseCase
import com.example.eduquest.domain.usecase.ValidateAnswerUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuizUiState(
    val isLoading: Boolean = true,
    val questId: String = "",
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOption: String? = null,
    val validationResult: AnswerValidationResult? = null,
    val isAnswerSubmitted: Boolean = false,
    val correctCount: Int = 0,
    val totalXpEarned: Int = 0,
    val isRepeatQuest: Boolean = false,
    val isQuizFinished: Boolean = false,
    val error: String? = null
) {
    val currentQuestion: Question?
        get() = questions.getOrNull(currentIndex)

    val totalQuestions: Int
        get() = questions.size

    val progressPercentage: Float
        get() = if (totalQuestions > 0) ((currentIndex + 1).toFloat() / totalQuestions) else 0f
}

class QuizViewModel @JvmOverloads constructor(
    application: Application,
    questionRepository: QuestionRepository = QuestionRepositoryImpl(
        DatabaseProvider.getDatabase(application).questionDao(),
        DatabaseProvider.getDatabase(application).progressDao()
    ),
    private val questRepository: QuestRepository = QuestRepositoryImpl(
        questDao = DatabaseProvider.getDatabase(application).questDao(),
        progressDao = DatabaseProvider.getDatabase(application).progressDao(),
        playerDao = DatabaseProvider.getDatabase(application).playerDao(),
        evaluateAchievementsUseCase = EvaluateAchievementsUseCase(
            AchievementRepositoryImpl(
                DatabaseProvider.getDatabase(application).achievementDao(),
                DatabaseProvider.getDatabase(application).progressDao(),
                DatabaseProvider.getDatabase(application).playerDao(),
                PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao())
            )
        ),
        unlockKnowledgeCardUseCase = UnlockKnowledgeCardUseCase(
            KnowledgeCardRepositoryImpl(
                DatabaseProvider.getDatabase(application).knowledgeCardDao(),
                DatabaseProvider.getDatabase(application).progressDao()
            )
        )
    ),
    private val addPlayerXpUseCase: AddPlayerXpUseCase = AddPlayerXpUseCase(
        PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao())
    ),
    dailyMissionRepository: DailyMissionRepository = DailyMissionRepositoryImpl(
        dailyMissionDao = DatabaseProvider.getDatabase(application).dailyMissionDao(),
        playerRepository = PlayerRepositoryImpl(DatabaseProvider.getDatabase(application).playerDao())
    )
) : AndroidViewModel(application) {

    private val getQuestionsForQuestUseCase = GetQuestionsForQuestUseCase(questionRepository)
    private val validateAnswerUseCase = ValidateAnswerUseCase()
    private val recordAnswerUseCase = RecordAnswerUseCase(questionRepository)
    private val completeQuestUseCase = CompleteQuestUseCase(questRepository)
    private val recordDailyProgressUseCase = RecordDailyProgressUseCase(dailyMissionRepository)

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    fun loadQuiz(questId: String, grade: Int = 1, playerId: String = "PLAYER_LOCAL") {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, questId = questId, error = null) }
            try {
                val questions = getQuestionsForQuestUseCase(questId, grade)
                val questProgress = questRepository.getQuestWithProgress(playerId, questId)
                val isRepeat = questProgress?.status == com.example.eduquest.domain.model.QuestStatus.COMPLETED
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        questions = questions,
                        currentIndex = 0,
                        selectedOption = null,
                        validationResult = null,
                        isAnswerSubmitted = false,
                        correctCount = 0,
                        totalXpEarned = 0,
                        isRepeatQuest = isRepeat,
                        isQuizFinished = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "Gagal memuat kuis"
                    )
                }
            }
        }
    }

    fun selectOption(key: String) {
        if (_uiState.value.isAnswerSubmitted) return
        _uiState.update { it.copy(selectedOption = key) }
    }

    fun submitAnswer(playerId: String = "PLAYER_LOCAL") {
        val currentState = _uiState.value
        val question = currentState.currentQuestion ?: return
        val selected = currentState.selectedOption ?: return
        if (currentState.isAnswerSubmitted) return

        val validation = validateAnswerUseCase(question, selected, isRepeat = currentState.isRepeatQuest)
        if (validation.isCorrect) {
            com.example.eduquest.core.audio.SoundManager.playCorrect()
        } else {
            com.example.eduquest.core.audio.SoundManager.playWrong()
        }

        viewModelScope.launch {
            recordAnswerUseCase(
                playerId = playerId,
                questId = currentState.questId,
                questionId = question.id,
                selectedAnswer = selected,
                isCorrect = validation.isCorrect,
                xpEarned = validation.xpEarned
            )

            if (validation.isCorrect && validation.xpEarned > 0) {
                try {
                    addPlayerXpUseCase(playerId, validation.xpEarned)
                } catch (e: Exception) {
                    // Gracefully ignore error
                }
            }

            try {
                recordDailyProgressUseCase.recordSubjectProgress(
                    playerId = playerId,
                    subjectId = question.subjectId
                )
            } catch (e: Exception) {
                // Gracefully ignore error
            }
        }

        _uiState.update {
            it.copy(
                isAnswerSubmitted = true,
                validationResult = validation,
                correctCount = if (validation.isCorrect) it.correctCount + 1 else it.correctCount,
                totalXpEarned = it.totalXpEarned + validation.xpEarned
            )
        }
    }

    fun nextQuestion(playerId: String = "PLAYER_LOCAL") {
        val currentState = _uiState.value
        if (currentState.currentIndex + 1 < currentState.questions.size) {
            _uiState.update {
                it.copy(
                    currentIndex = it.currentIndex + 1,
                    selectedOption = null,
                    validationResult = null,
                    isAnswerSubmitted = false
                )
            }
        } else {
            viewModelScope.launch {
                try {
                    completeQuestUseCase(
                        playerId = playerId,
                        questId = currentState.questId,
                        score = currentState.correctCount,
                        totalQuestions = currentState.totalQuestions
                    )
                } catch (e: Exception) {
                    // Gracefully ignore or log
                }

                try {
                    val isPerfect = currentState.correctCount == currentState.totalQuestions && currentState.totalQuestions > 0
                    recordDailyProgressUseCase.recordQuestProgress(
                        playerId = playerId,
                        isPerfectScore = isPerfect
                    )
                } catch (e: Exception) {
                    // Gracefully ignore or log
                }

                _uiState.update { it.copy(isQuizFinished = true) }
            }
        }
    }
}
