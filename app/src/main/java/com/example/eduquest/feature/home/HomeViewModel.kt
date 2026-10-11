package com.example.eduquest.feature.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.eduquest.core.database.DatabaseProvider
import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.data.local.dao.AchievementDao
import com.example.eduquest.data.local.dao.DailyMissionDao
import com.example.eduquest.data.local.dao.KnowledgeCardDao
import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.repository.DailyMissionRepositoryImpl
import com.example.eduquest.data.repository.PlayerRepositoryImpl
import com.example.eduquest.data.repository.QuestRepositoryImpl
import com.example.eduquest.data.repository.WorldRepositoryImpl
import com.example.eduquest.domain.model.DailyMissionWithProgress
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.model.WorldWithProgress
import com.example.eduquest.domain.repository.DailyMissionRepository
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.QuestRepository
import com.example.eduquest.domain.repository.WorldRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class DailyMissionSummary(
    val totalMissions: Int = 0,
    val completedCount: Int = 0,
    val claimedCount: Int = 0,
    val totalXpReward: Int = 0,
    val totalCoinsReward: Int = 0,
    val allCompleted: Boolean = false,
    val hasUnclaimedReward: Boolean = false,
    val progressRatio: Float = 0f
)

data class QuickStats(
    val unlockedCardsCount: Int = 0,
    val totalCardsCount: Int = 10,
    val unlockedAchievementsCount: Int = 0,
    val totalAchievementsCount: Int = 6
)

data class HomeUiState(
    val isLoading: Boolean = true,
    val player: Player? = null,
    val hasPlayer: Boolean = false,
    val levelProgress: LevelProgress = LevelTable.calculateProgress(0),
    val streakDays: Int = 1,
    val continueQuest: QuestWithProgress? = null,
    val dailyMissionSummary: DailyMissionSummary = DailyMissionSummary(),
    val worldProgress: WorldWithProgress? = null,
    val quickStats: QuickStats = QuickStats(),
    val lastLevelUpResult: LevelUpResult? = null,
    val error: String? = null
)

class HomeViewModel @JvmOverloads constructor(
    application: Application,
    private val playerDao: PlayerDao = DatabaseProvider.getDatabase(application).playerDao(),
    private val playerRepository: PlayerRepository = PlayerRepositoryImpl(playerDao),
    private val questRepository: QuestRepository = QuestRepositoryImpl(
        DatabaseProvider.getDatabase(application).questDao(),
        DatabaseProvider.getDatabase(application).progressDao(),
        playerDao
    ),
    private val dailyMissionRepository: DailyMissionRepository = DailyMissionRepositoryImpl(
        DatabaseProvider.getDatabase(application).dailyMissionDao(),
        playerRepository
    ),
    private val worldRepository: WorldRepository = WorldRepositoryImpl(
        DatabaseProvider.getDatabase(application).worldDao(),
        DatabaseProvider.getDatabase(application).questDao(),
        DatabaseProvider.getDatabase(application).progressDao(),
        playerDao
    ),
    private val dailyMissionDao: DailyMissionDao = DatabaseProvider.getDatabase(application).dailyMissionDao(),
    private val knowledgeCardDao: KnowledgeCardDao = DatabaseProvider.getDatabase(application).knowledgeCardDao(),
    private val achievementDao: AchievementDao = DatabaseProvider.getDatabase(application).achievementDao()
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var lastObservedLevel: Int? = null

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            playerDao.getAllPlayers().collectLatest { playerEntities ->
                if (playerEntities.isEmpty()) {
                    lastObservedLevel = null
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
                            player = player,
                            hasPlayer = true,
                            levelProgress = progress,
                            lastLevelUpResult = levelUpResult ?: it.lastLevelUpResult
                        )
                    }

                    val todayDate = DailyDateUtils.getTodayDateString()
                    val questsFlow = questRepository.getQuestsWithProgress(player.id)
                    val dailyMissionsFlow = dailyMissionRepository.getDailyMissionsWithProgress(player.id, todayDate)
                    val worldFlow = worldRepository.getWorldWithAreas(player.id, player.currentWorldId)
                    val cardsCountFlow = knowledgeCardDao.getUnlockedCardCountFlow(player.id)
                    val achievementsCountFlow = achievementDao.getUnlockedCountFlow(player.id)

                    combine(
                        questsFlow,
                        dailyMissionsFlow,
                        worldFlow,
                        cardsCountFlow,
                        achievementsCountFlow
                    ) { quests, missions, world, cardsCount, achCount ->
                        val continueQuest = selectContinueQuest(quests)
                        val dailySummary = buildDailySummary(missions)
                        val streak = if (missions.any { it.currentProgress > 0 }) 1 else 1
                        val quickStats = QuickStats(
                            unlockedCardsCount = cardsCount,
                            totalCardsCount = 10,
                            unlockedAchievementsCount = achCount,
                            totalAchievementsCount = 6
                        )

                        HomeUiState(
                            isLoading = false,
                            player = player,
                            hasPlayer = true,
                            levelProgress = progress,
                            streakDays = streak,
                            continueQuest = continueQuest,
                            dailyMissionSummary = dailySummary,
                            worldProgress = world,
                            quickStats = quickStats,
                            lastLevelUpResult = _uiState.value.lastLevelUpResult,
                            error = null
                        )
                    }.collectLatest { state ->
                        _uiState.value = state
                    }
                }
            }
        }
    }

    fun dismissLevelUpDialog() {
        _uiState.update { it.copy(lastLevelUpResult = null) }
    }

    companion object {
        fun selectContinueQuest(quests: List<QuestWithProgress>): QuestWithProgress? {
            if (quests.isEmpty()) return null

            val inProgress = quests.firstOrNull { it.isInProgress }
            if (inProgress != null) return inProgress

            val available = quests.firstOrNull { it.isAvailable }
            if (available != null) return available

            return quests.lastOrNull { it.isCompleted } ?: quests.firstOrNull()
        }

        fun buildDailySummary(missions: List<DailyMissionWithProgress>): DailyMissionSummary {
            val total = missions.size
            val completed = missions.count { it.isCompleted }
            val claimed = missions.count { it.isClaimed }
            val allDone = total > 0 && completed >= total
            val hasUnclaimed = missions.any { it.isReadyToClaim }
            val totalXp = missions.sumOf { it.mission.rewardXp }
            val totalCoins = missions.sumOf { it.mission.rewardCoins }
            val ratio = if (total > 0) completed.toFloat() / total else 0f
            return DailyMissionSummary(
                totalMissions = total,
                completedCount = completed,
                claimedCount = claimed,
                totalXpReward = totalXp,
                totalCoinsReward = totalCoins,
                allCompleted = allDone,
                hasUnclaimedReward = hasUnclaimed,
                progressRatio = ratio
            )
        }

        fun calculateStreakDays(activeDates: List<String>, todayStr: String): Int {
            if (activeDates.isEmpty()) return 1
            val uniqueSortedDates = activeDates.distinct().sortedDescending()
            if (uniqueSortedDates.isEmpty()) return 1

            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
            val calendar = Calendar.getInstance()

            val hasToday = uniqueSortedDates.contains(todayStr)
            val checkDateStr = if (hasToday) {
                todayStr
            } else {
                try {
                    val todayDate = sdf.parse(todayStr) ?: return 1
                    calendar.time = todayDate
                    calendar.add(Calendar.DAY_OF_YEAR, -1)
                    sdf.format(calendar.time)
                } catch (e: Exception) {
                    return 1
                }
            }

            if (!uniqueSortedDates.contains(checkDateStr)) {
                return 1
            }

            var streak = 0
            try {
                var currDate = sdf.parse(checkDateStr) ?: return 1
                while (true) {
                    val str = sdf.format(currDate)
                    if (uniqueSortedDates.contains(str)) {
                        streak++
                        calendar.time = currDate
                        calendar.add(Calendar.DAY_OF_YEAR, -1)
                        currDate = calendar.time
                    } else {
                        break
                    }
                }
            } catch (e: Exception) {
                return if (streak > 0) streak else 1
            }

            return maxOf(streak, 1)
        }
    }
}
