package com.example.eduquest.feature.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.example.eduquest.core.audio.SoundManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eduquest.core.ui.AvatarHelper
import com.example.eduquest.core.ui.component.LevelUpDialog
import com.example.eduquest.core.util.DailyDateUtils
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.feature.player.PlayerViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private object HomeIcons {
    const val WORLD = "\uD83C\uDFF0"
    const val TARGET = "\uD83C\uDFAF"
    const val STAR = "\uD83C\uDF1F"
    const val BOLT = "\u26A1"
    const val COIN = "\uD83E\uDE99"
    const val FIRE = "\uD83D\uDD25"
    const val TROPHY = "\uD83C\uDFC6"
    const val CARD = "\uD83C\uDFB4"
    const val PROFILE = "\uD83D\uDC64"
    const val GEAR = "\u2699\uFE0F"
    const val GIFT = "\uD83C\uDF81"
    const val PARTY = "\uD83C\uDF89"
    const val MATH = "\uD83D\uDD22"
    const val SCIENCE = "\uD83D\uDD2C"
    const val LANGUAGE = "\uD83D\uDCD6"
    const val NOTES = "\uD83D\uDCDD"
    const val XP_STAR = "\u2B50"
    const val WAVE = "\uD83D\uDC4B"
    const val PLAY = "\u25B6"
    const val REPLAY = "\u21BA"
    const val ARROW = "\u2794"
    const val DOT = "\u2022"
    const val HOURGLASS = "\u23F3"
    const val CHECK = "\u2705"
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onStartClick: () -> Unit = {},
    onContinueQuest: (String) -> Unit = { onStartClick() },
    onProfileClick: () -> Unit = {},
    onAchievementClick: () -> Unit = {},
    onCollectionClick: () -> Unit = {},
    onDailyMissionClick: () -> Unit = {},
    onLeaderboardClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onExamClick: () -> Unit = {},
    onNavigateToOnboarding: () -> Unit = {},
    homeViewModel: HomeViewModel = viewModel(),
    playerViewModel: PlayerViewModel? = null
) {
    val uiState by homeViewModel.uiState.collectAsState()
    val player = uiState.player

    LaunchedEffect(uiState.isLoading, uiState.hasPlayer) {
        if (!uiState.isLoading && !uiState.hasPlayer) {
            onNavigateToOnboarding()
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .widthIn(max = 500.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // 1. App Header / Title
                    Text(
                        text = "EDUQUEST",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.Black,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )

                    // 2. Player Profile & Welcome Card
                    if (player != null) {
                        PlayerWelcomeCard(
                            player = player,
                            level = uiState.levelProgress.currentLevel,
                            coins = player.coins,
                            streakDays = uiState.streakDays,
                            xpProgress = uiState.levelProgress.progressPercentage,
                            currentXp = uiState.levelProgress.xpInCurrentLevel,
                            neededXp = uiState.levelProgress.xpNeededForNextLevel,
                            remainingXp = uiState.levelProgress.remainingXpToNextLevel,
                            isMaxLevel = uiState.levelProgress.isMaxLevel,
                            onProfileClick = {
                                SoundManager.playClick()
                                onProfileClick()
                            }
                        )
                    } else {
                        // Empty Profile Prompt
                        EmptyProfileCard(onNavigateToOnboarding = {
                            SoundManager.playClick()
                            onNavigateToOnboarding()
                        })
                    }

                    // 3. PRIORITY 1: Continue Quest (Lanjut Belajar)
                    val continueQuest = uiState.continueQuest
                    if (continueQuest != null) {
                        ContinueQuestCard(
                            questWithProgress = continueQuest,
                            onContinueClick = {
                                SoundManager.playClick()
                                onContinueQuest(continueQuest.quest.id)
                            }
                        )
                    }

                    // 4. PRIORITY 2: Daily Mission Summary
                    DailyMissionSummaryCard(
                        summary = uiState.dailyMissionSummary,
                        onDailyMissionClick = {
                            SoundManager.playClick()
                            onDailyMissionClick()
                        }
                    )

                    // 5. World Progress Card
                    val worldProgress = uiState.worldProgress
                    if (worldProgress != null) {
                        WorldProgressCard(
                            worldName = worldProgress.world.title,
                            completedQuests = worldProgress.completedQuests,
                            totalQuests = worldProgress.totalQuests,
                            progressPercent = worldProgress.completionPercentage,
                            onWorldClick = {
                                SoundManager.playClick()
                                onStartClick()
                            }
                        )
                    }

                    // 5b. Ruang Ujian Sekolah (Exam Mode)
                    ExamBannerCard(
                        educationLevel = player?.educationLevel ?: "SD",
                        onExamClick = {
                            SoundManager.playClick()
                            onExamClick()
                        }
                    )

                    // 6. Quick Access Menu Grid (Peringkat, Pencapaian, Koleksi, Profil, Pengaturan)
                    QuickAccessMenuGrid(
                        quickStats = uiState.quickStats,
                        onLeaderboardClick = {
                            SoundManager.playClick()
                            onLeaderboardClick()
                        },
                        onAchievementClick = {
                            SoundManager.playClick()
                            onAchievementClick()
                        },
                        onCollectionClick = {
                            SoundManager.playClick()
                            onCollectionClick()
                        },
                        onProfileClick = {
                            SoundManager.playClick()
                            onProfileClick()
                        },
                        onSettingsClick = {
                            SoundManager.playClick()
                            onSettingsClick()
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }

        // Level Up Celebration Dialog
        uiState.lastLevelUpResult?.let { result ->
            LevelUpDialog(
                oldLevel = result.oldLevel,
                newLevel = result.newLevel,
                bonusCoins = result.bonusCoins,
                onDismiss = { homeViewModel.dismissLevelUpDialog() }
            )
        }
    }
}

@Composable
private fun PlayerWelcomeCard(
    player: Player,
    level: Int,
    coins: Int,
    streakDays: Int,
    xpProgress: Float,
    currentXp: Int,
    neededXp: Int,
    remainingXp: Int,
    isMaxLevel: Boolean,
    onProfileClick: () -> Unit
) {
    val avatar = AvatarHelper.getAvatar(player.avatar)
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Avatar with clickable circle
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .clickable { onProfileClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = avatar.emoji, fontSize = 28.sp)
                }

                Spacer(modifier = Modifier.width(14.dp))

                // Name & Grade
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Halo, ${player.nickname}! ${HomeIcons.WAVE}",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "${player.educationLevel} Kelas ${player.grade}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    )
                }

                // Streak & Coins
                Column(horizontalAlignment = Alignment.End) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    ) {
                        Text(
                            text = "${HomeIcons.COIN} $coins",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    ) {
                        Text(
                            text = "${HomeIcons.FIRE} $streakDays Hari",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Level & XP Progress Card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${HomeIcons.STAR} Level $level",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = if (isMaxLevel) "Level Maksimal!" else "${HomeIcons.BOLT} $currentXp / $neededXp XP",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    val animatedXpProgress by animateFloatAsState(
                        targetValue = xpProgress,
                        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                        label = "homeXpProgressAnim"
                    )

                    LinearProgressIndicator(
                        progress = { animatedXpProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = if (isMaxLevel) "Total ${player.xp} XP terkumpul ${HomeIcons.PARTY}"
                        else "Butuh $remainingXp XP lagi untuk naik level!",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun ContinueQuestCard(
    questWithProgress: QuestWithProgress,
    onContinueClick: () -> Unit
) {
    val quest = questWithProgress.quest
    val isRunning = questWithProgress.isInProgress
    val isCompleted = questWithProgress.isCompleted

    val subjectEmoji = when (quest.subjectId.uppercase()) {
        "MATH" -> HomeIcons.MATH
        "SCIENCE" -> HomeIcons.SCIENCE
        "LANGUAGE" -> HomeIcons.LANGUAGE
        else -> HomeIcons.WORLD
    }

    val subjectLabel = when (quest.subjectId.uppercase()) {
        "MATH" -> "Matematika"
        "SCIENCE" -> "Sains"
        "LANGUAGE" -> "Bahasa"
        else -> quest.subjectId
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(
                if (isRunning) MaterialTheme.colorScheme.secondary
                else MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
            )
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = HomeIcons.TARGET, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Lanjut Belajar",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                // Status Badge
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = when {
                        isRunning -> MaterialTheme.colorScheme.secondaryContainer
                        isCompleted -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.tertiaryContainer
                    }
                ) {
                    Text(
                        text = when {
                            isRunning -> "${HomeIcons.HOURGLASS} Sedang Berjalan"
                            isCompleted -> "${HomeIcons.CHECK} Selesai"
                            else -> "${HomeIcons.BOLT} Siap Dimulai"
                        },
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = when {
                            isRunning -> MaterialTheme.colorScheme.onSecondaryContainer
                            isCompleted -> MaterialTheme.colorScheme.onPrimaryContainer
                            else -> MaterialTheme.colorScheme.onTertiaryContainer
                        },
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Subject Pill & Quest Title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = "$subjectEmoji $subjectLabel",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = quest.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )

            if (quest.description.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = quest.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Rewards Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = "${HomeIcons.XP_STAR} +${quest.xpReward} XP",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = "${HomeIcons.COIN} +${quest.coinReward}",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Text(
                        text = "${HomeIcons.NOTES} ${quest.questionCount} Soal",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // CTA Button
            Button(
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = when {
                        isRunning -> "Lanjutkan Petualangan ${HomeIcons.PLAY}"
                        isCompleted -> "Ulangi Quest ${HomeIcons.REPLAY}"
                        else -> "Mulai Petualangan ${HomeIcons.PLAY}"
                    },
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Composable
private fun DailyMissionSummaryCard(
    summary: DailyMissionSummary,
    onDailyMissionClick: () -> Unit
) {
    val shortDate = remember {
        try {
            SimpleDateFormat("EEEE, d MMM", Locale("id", "ID")).format(Date())
        } catch (e: Exception) {
            DailyDateUtils.getTodayDateString()
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDailyMissionClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = HomeIcons.TARGET, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Misi Harian",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
                ) {
                    Text(
                        text = shortDate,
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${summary.completedCount} dari ${summary.totalMissions} Selesai",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = "${HomeIcons.XP_STAR} +${summary.totalXpReward} XP ${HomeIcons.DOT} ${HomeIcons.COIN} +${summary.totalCoinsReward}",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            val animatedDailyProgress by animateFloatAsState(
                targetValue = summary.progressRatio,
                animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                label = "homeDailyProgressAnim"
            )

            LinearProgressIndicator(
                progress = { animatedDailyProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
            )

            if (summary.hasUnclaimedReward) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${HomeIcons.GIFT} Hadiah Misi Siap Diklaim!",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            } else {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (summary.allCompleted) "Semua misi hari ini tuntas! ${HomeIcons.PARTY}"
                    else "Selesaikan misi harian untuk raih bonus belajar!",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
private fun WorldProgressCard(
    worldName: String,
    completedQuests: Int,
    totalQuests: Int,
    progressPercent: Int,
    onWorldClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onWorldClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.45f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = HomeIcons.WORLD, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = worldName,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
                ) {
                    Text(
                        text = "$progressPercent%",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$completedQuests dari $totalQuests Quest Selesai",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.85f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { if (totalQuests > 0) completedQuests.toFloat() / totalQuests else 0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = MaterialTheme.colorScheme.tertiary,
                trackColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${HomeIcons.MATH} Math ${HomeIcons.DOT} ${HomeIcons.SCIENCE} Science ${HomeIcons.DOT} ${HomeIcons.LANGUAGE} Bahasa",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.7f)
                )
                Text(
                    text = "Buka Peta ${HomeIcons.ARROW}",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
private fun QuickAccessMenuGrid(
    quickStats: QuickStats,
    onLeaderboardClick: () -> Unit,
    onAchievementClick: () -> Unit,
    onCollectionClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Menu Petualang",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )

        // Row 1: Leaderboard & Achievement
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickMenuItem(
                modifier = Modifier.weight(1f),
                icon = "👑",
                title = "Peringkat",
                subtitle = "Papan Skor SD-SMA",
                onClick = onLeaderboardClick
            )
            QuickMenuItem(
                modifier = Modifier.weight(1f),
                icon = HomeIcons.TROPHY,
                title = "Pencapaian",
                subtitle = "${quickStats.unlockedAchievementsCount} Terbuka",
                onClick = onAchievementClick
            )
        }

        // Row 2: Collection & Profile
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickMenuItem(
                modifier = Modifier.weight(1f),
                icon = HomeIcons.CARD,
                title = "Kartu Pintar",
                subtitle = "${quickStats.unlockedCardsCount} Kartu",
                onClick = onCollectionClick
            )
            QuickMenuItem(
                modifier = Modifier.weight(1f),
                icon = HomeIcons.PROFILE,
                title = "Profil",
                subtitle = "Statistik Belajar",
                onClick = onProfileClick
            )
        }

        // Row 3: Settings
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickMenuItem(
                modifier = Modifier.fillMaxWidth(),
                icon = HomeIcons.GEAR,
                title = "Pengaturan",
                subtitle = "Suara, Preferensi & Update Soal (GitHub)",
                onClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun QuickMenuItem(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = icon, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun EmptyProfileCard(onNavigateToOnboarding: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Belum Ada Profil Petualang",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Buat karakter dan mulai petualangan belajarmu!",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onNavigateToOnboarding,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Buat Profil Petualang")
            }
        }
    }
}

@Composable
private fun ExamBannerCard(
    educationLevel: String,
    onExamClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onExamClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.85f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.secondary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = when (educationLevel) {
                            "SMP" -> "\uD83E\uDDED"
                            "SMA" -> "\uD83C\uDF93"
                            else -> "\uD83C\uDF92"
                        },
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Ruang Ujian Sekolah",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = MaterialTheme.colorScheme.secondary
                        ) {
                            Text(
                                text = "TRYOUT",
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Black),
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "100 Soal Ujian Khusus Jenjang $educationLevel dengan batas waktu dan rapor nilai.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.85f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = onExamClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Masuk Ruang Ujian $educationLevel",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "\u25B6")
                }
            }
        }
    }
}
