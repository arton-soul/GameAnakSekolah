package com.example.eduquest.feature.exam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.audio.SoundManager
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.data.repository.QuestionRepositoryImpl
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.model.Question
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.QuestionRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

data class ExamUiState(
    val isLoading: Boolean = false,
    val player: Player? = null,
    val educationLevel: String = "SD",
    val availableQuestionCount: Int = 0,
    val packages: List<ExamPackage> = emptyList(),
    // Active Exam state
    val isExamActive: Boolean = false,
    val selectedPackageTitle: String = "",
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val userAnswers: Map<String, String> = emptyMap(), // questionId -> option
    val remainingSeconds: Int = 1200, // 20 minutes
    val totalSeconds: Int = 1200,
    val isFinished: Boolean = false,
    val examResult: ExamResultData? = null
) {
    val currentQuestion: Question?
        get() = questions.getOrNull(currentIndex)

    val answeredCount: Int
        get() = userAnswers.size

    val totalQuestions: Int
        get() = questions.size

    val formattedRemainingTime: String
        get() {
            val minutes = remainingSeconds / 60
            val seconds = remainingSeconds % 60
            return "%02d:%02d".format(minutes, seconds)
        }
}

class ExamViewModel @JvmOverloads constructor(
    application: Application,
    private val questionRepository: QuestionRepository = QuestionRepositoryImpl(
        DatabaseProvider.getDatabase(application).questionDao(),
        DatabaseProvider.getDatabase(application).progressDao()
    ),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(
        DatabaseProvider.getDatabase(application).playerDao()
    ),
    private val progressDao: ProgressDao = DatabaseProvider.getDatabase(application).progressDao()
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(ExamUiState(isLoading = true))
    val uiState: StateFlow<ExamUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    init {
        loadExamInfo()
    }

    fun loadExamInfo() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val player = playerRepository.getActivePlayerDirect()
            val level = player?.educationLevel ?: "SD"
            val count = questionRepository.getExamQuestionCount(level)
            val basePackages = getExamPackagesForLevel(level)

            val playerId = player?.id ?: ""
            val totalLevelQuests = if (playerId.isNotEmpty()) {
                progressDao.getCompletedQuestCountByLevel(playerId, level)
            } else 0

            val packagesWithLockStatus = basePackages.map { pkg ->
                if (pkg.subjectId == "ALL") {
                    val req = 5
                    val cur = totalLevelQuests
                    val unlocked = cur >= req
                    pkg.copy(
                        requiredCompletedQuests = req,
                        currentCompletedQuests = cur,
                        isUnlocked = unlocked,
                        unlockRequirementText = "Selesaikan minimal 5 Quest di Petualangan untuk membuka Tryout Lengkap"
                    )
                } else {
                    val req = 3
                    val cur = if (playerId.isNotEmpty()) {
                        progressDao.getCompletedQuestCountBySubject(playerId, level, pkg.subjectId)
                    } else 0
                    val unlocked = cur >= req
                    val mapelName = when (pkg.subjectId) {
                        "MATH" -> "Matematika SD"
                        "SCIENCE" -> "Sains & IPAS SD"
                        "LANGUAGE" -> "Bahasa Indonesia SD"
                        "SMP_MATH" -> "Matematika SMP"
                        "SMP_IPA" -> "IPA Terpadu SMP"
                        "SMP_IPS" -> "IPS Terpadu SMP"
                        "SMP_INDO" -> "Bahasa Indonesia SMP"
                        "SMA_MATH_ADV" -> "Matematika Lanjut SMA"
                        "SMA_MIPA" -> "Sains MIPA SMA"
                        "SMA_SOSHUM" -> "Soshum SMA"
                        "SMA_GENERAL" -> "Pengetahuan Umum & Logika SMA"
                        else -> "mata pelajaran ini"
                    }
                    pkg.copy(
                        requiredCompletedQuests = req,
                        currentCompletedQuests = cur,
                        isUnlocked = unlocked,
                        unlockRequirementText = "Selesaikan minimal 3 Quest $mapelName di Petualangan untuk membuka ujian ini"
                    )
                }
            }

            _uiState.update {
                it.copy(
                    isLoading = false,
                    player = player,
                    educationLevel = level,
                    availableQuestionCount = count,
                    packages = packagesWithLockStatus
                )
            }
        }
    }

    private fun getExamPackagesForLevel(level: String): List<ExamPackage> {
        return when (level) {
            "SMP" -> listOf(
                ExamPackage(
                    id = "pkg_smp_all",
                    title = "Simulasi Ujian Sekolah Lengkap",
                    subtitle = "Tryout gabungan 20 soal acak: Matematika, IPA, IPS, dan Bahasa.",
                    icon = "\uD83E\uDDED",
                    subjectId = "ALL",
                    questionCount = 20,
                    durationMinutes = 20,
                    xpRewardMax = 300,
                    coinRewardMax = 50
                ),
                ExamPackage(
                    id = "pkg_smp_math",
                    title = "Ujian Matematika SMP",
                    subtitle = "Aljabar, Bilangan, Geometri, Teorema Pythagoras, dan Statistik.",
                    icon = "\uD83D\uDCD0",
                    subjectId = "SMP_MATH",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 250,
                    coinRewardMax = 40
                ),
                ExamPackage(
                    id = "pkg_smp_ipa",
                    title = "Ujian IPA Terpadu SMP",
                    subtitle = "Fisika gerak & gaya, Biologi sel, dan Kimia dasar.",
                    icon = "\uD83D\uDD2C",
                    subjectId = "SMP_IPA",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 250,
                    coinRewardMax = 40
                ),
                ExamPackage(
                    id = "pkg_smp_ips",
                    title = "Ujian IPS Terpadu SMP",
                    subtitle = "Geografi ASEAN, Sejarah kemerdekaan, dan Ekonomi pasar.",
                    icon = "\uD83C\uDF0D",
                    subjectId = "SMP_IPS",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 250,
                    coinRewardMax = 40
                ),
                ExamPackage(
                    id = "pkg_smp_indo",
                    title = "Ujian Bahasa Indonesia SMP",
                    subtitle = "Teks deskripsi, Puisi, Struktur cerita fantasi, dan Tata bahasa.",
                    icon = "\uD83D\uDCDA",
                    subjectId = "SMP_INDO",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 250,
                    coinRewardMax = 40
                )
            )
            "SMA" -> listOf(
                ExamPackage(
                    id = "pkg_sma_all",
                    title = "Simulasi UTBK / Asesmen Akhir SMA",
                    subtitle = "Tryout komprehensif 20 soal acak: Matematika Lanjut, MIPA, Soshum, & Logika.",
                    icon = "\uD83C\uDF93",
                    subjectId = "ALL",
                    questionCount = 20,
                    durationMinutes = 20,
                    xpRewardMax = 350,
                    coinRewardMax = 60
                ),
                ExamPackage(
                    id = "pkg_sma_math",
                    title = "Ujian Matematika Tingkat Lanjut",
                    subtitle = "Kalkulus diferensial-integral, Vektor, Matriks, dan Trigonometri.",
                    icon = "\uD83C\uDFDB\uFE0F",
                    subjectId = "SMA_MATH_ADV",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 280,
                    coinRewardMax = 45
                ),
                ExamPackage(
                    id = "pkg_sma_mipa",
                    title = "Ujian Sains & MIPA Terpadu",
                    subtitle = "Fisika modern, Termodinamika, Kimia larutan, dan Genetika DNA.",
                    icon = "\u269B\uFE0F",
                    subjectId = "SMA_MIPA",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 280,
                    coinRewardMax = 45
                ),
                ExamPackage(
                    id = "pkg_sma_soshum",
                    title = "Ujian Soshum & Ekonomi SMA",
                    subtitle = "Ekonomi pasar, Sosiologi masyarakat, dan Dinamika sosial.",
                    icon = "\uD83D\uDCC8",
                    subjectId = "SMA_SOSHUM",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 280,
                    coinRewardMax = 45
                ),
                ExamPackage(
                    id = "pkg_sma_general",
                    title = "Ujian Penalaran Logika & Umum",
                    subtitle = "Silogisme, Analitis, Hubungan sebab-akibat, dan Wawasan Bernegara.",
                    icon = "\uD83D\uDCA1",
                    subjectId = "SMA_GENERAL",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 280,
                    coinRewardMax = 45
                )
            )
            else -> listOf(
                ExamPackage(
                    id = "pkg_sd_all",
                    title = "Simulasi Ujian Sekolah Dasar",
                    subtitle = "Tryout gabungan 20 soal acak: Matematika Dasar, IPAS Sains, & Bahasa.",
                    icon = "\uD83C\uDF92",
                    subjectId = "ALL",
                    questionCount = 20,
                    durationMinutes = 20,
                    xpRewardMax = 250,
                    coinRewardMax = 40
                ),
                ExamPackage(
                    id = "pkg_sd_math",
                    title = "Ujian Berhitung & Matematika SD",
                    subtitle = "Operasi hitung, Pecahan, Pengukuran, Bangun ruang, dan Data.",
                    icon = "\uD83D\uDD22",
                    subjectId = "MATH",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 200,
                    coinRewardMax = 35
                ),
                ExamPackage(
                    id = "pkg_sd_science",
                    title = "Ujian Sains & IPAS SD",
                    subtitle = "Makhluk hidup, Lingkungan, Energi alternatif, Tata surya, dan Tubuh kita.",
                    icon = "\uD83C\uDF3F",
                    subjectId = "SCIENCE",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 200,
                    coinRewardMax = 35
                ),
                ExamPackage(
                    id = "pkg_sd_lang",
                    title = "Ujian Bahasa Indonesia SD",
                    subtitle = "Membaca pemahaman, Kosakata baku, Pantun, Ejaan, dan Kalimat efektif.",
                    icon = "\uD83D\uDCD6",
                    subjectId = "LANGUAGE",
                    questionCount = 15,
                    durationMinutes = 15,
                    xpRewardMax = 200,
                    coinRewardMax = 35
                )
            )
        }
    }

    fun startExam(pkg: ExamPackage) {
        if (!pkg.isUnlocked) return
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val level = _uiState.value.educationLevel
            val questions = if (pkg.subjectId == "ALL") {
                questionRepository.getExamQuestions(level, limit = pkg.questionCount)
            } else {
                questionRepository.getExamQuestionsBySubject(level, pkg.subjectId, limit = pkg.questionCount)
            }.map { it.withShuffledOptions() }

            val totalSec = pkg.durationMinutes * 60

            _uiState.update {
                it.copy(
                    isLoading = false,
                    isExamActive = true,
                    isFinished = false,
                    selectedPackageTitle = pkg.title,
                    questions = questions,
                    currentIndex = 0,
                    userAnswers = emptyMap(),
                    remainingSeconds = totalSec,
                    totalSeconds = totalSec,
                    examResult = null
                )
            }

            startTimer()
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (isActive && _uiState.value.remainingSeconds > 0) {
                delay(1000L)
                _uiState.update {
                    val nextSec = it.remainingSeconds - 1
                    it.copy(remainingSeconds = nextSec)
                }
                if (_uiState.value.remainingSeconds <= 0) {
                    finishExam()
                    break
                }
            }
        }
    }

    fun selectAnswer(questionId: String, optionKey: String) {
        val currentAnswers = _uiState.value.userAnswers.toMutableMap()
        currentAnswers[questionId] = optionKey
        _uiState.update { it.copy(userAnswers = currentAnswers) }
        SoundManager.playClick()
    }

    fun goToIndex(index: Int) {
        if (index in 0 until _uiState.value.questions.size) {
            SoundManager.playClick()
            _uiState.update { it.copy(currentIndex = index) }
        }
    }

    fun nextQuestion() {
        val next = _uiState.value.currentIndex + 1
        if (next < _uiState.value.questions.size) {
            goToIndex(next)
        }
    }

    fun previousQuestion() {
        val prev = _uiState.value.currentIndex - 1
        if (prev >= 0) {
            goToIndex(prev)
        }
    }

    fun finishExam() {
        timerJob?.cancel()
        val state = _uiState.value
        val questions = state.questions
        val answers = state.userAnswers

        var correct = 0
        for (q in questions) {
            val userAns = answers[q.id]
            if (userAns != null && userAns.equals(q.correctAnswer, ignoreCase = true)) {
                correct++
            }
        }
        val total = questions.size.coerceAtLeast(1)
        val score = (correct * 100) / total
        val (gradeLabel, gradeDesc) = calculateExamGrade(score)

        val baseMultiplier = score.toFloat() / 100f
        val xpEarned = (250 * baseMultiplier).toInt().coerceAtLeast(50)
        val coinsEarned = (40 * baseMultiplier).toInt().coerceAtLeast(10)
        val timeSpent = (state.totalSeconds - state.remainingSeconds).toLong().coerceAtLeast(1)

        val resultData = ExamResultData(
            educationLevel = state.educationLevel,
            subjectTitle = state.selectedPackageTitle,
            totalQuestions = total,
            correctCount = correct,
            wrongCount = total - correct,
            score = score,
            gradeLabel = gradeLabel,
            gradeDescription = gradeDesc,
            xpEarned = xpEarned,
            coinsEarned = coinsEarned,
            timeSpentSeconds = timeSpent,
            questions = questions,
            userAnswers = answers
        )

        viewModelScope.launch {
            val player = state.player ?: playerRepository.getActivePlayerDirect()
            if (player != null) {
                playerRepository.addXp(player.id, xpEarned)
                playerRepository.addCoins(player.id, coinsEarned)
            }
        }

        if (score >= 60) {
            SoundManager.playLevelUp()
        } else {
            SoundManager.playWrong()
        }

        _uiState.update {
            it.copy(
                isFinished = true,
                examResult = resultData
            )
        }
    }

    fun resetExam() {
        timerJob?.cancel()
        _uiState.update {
            it.copy(
                isExamActive = false,
                isFinished = false,
                questions = emptyList(),
                currentIndex = 0,
                userAnswers = emptyMap(),
                examResult = null
            )
        }
        loadExamInfo()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}