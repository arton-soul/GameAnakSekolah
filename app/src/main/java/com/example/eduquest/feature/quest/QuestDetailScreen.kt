package com.example.eduquest.feature.quest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eduquest.core.ui.component.EduQuestTopBar
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.feature.player.PlayerViewModel

@Composable
fun QuestDetailScreen(
    questId: String,
    onNavigateBack: () -> Unit,
    onNavigateToQuiz: (String) -> Unit,
    questViewModel: QuestViewModel = viewModel(),
    playerViewModel: PlayerViewModel = viewModel()
) {
    val questState by questViewModel.uiState.collectAsState()
    val playerState by playerViewModel.uiState.collectAsState()

    val player = playerState.player
    val playerId = player?.id ?: "PLAYER_LOCAL"

    LaunchedEffect(questId, playerId) {
        questViewModel.loadQuestDetail(playerId, questId)
    }

    val questWithProgress = questState.questDetail
    val quest = questWithProgress?.quest
    val status = questWithProgress?.status ?: QuestStatus.AVAILABLE

    Scaffold(
        topBar = {
            EduQuestTopBar(
                title = "Detail Petualangan",
                onBackClick = onNavigateBack
            )
        }
    ) { paddingValues ->
        if (questState.isLoading && quest == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            StatusBadge(status = status, unlockLevel = quest?.unlockLevel ?: 1)
                            
                            val subjectLabel = when (quest?.subjectId) {
                                "MATH" -> "Matematika"
                                "SCIENCE" -> "Sains"
                                "LANGUAGE" -> "B. Indonesia"
                                else -> "Umum"
                            }
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = subjectLabel,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = quest?.title ?: "Tantangan Pengetahuan",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = quest?.description ?: "Selesaikan misi dan kuis untuk meningkatkan pemahaman pelajaran sekolah.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f),
                            lineHeight = 20.sp
                        )

                        if (status == QuestStatus.COMPLETED) {
                            Spacer(modifier = Modifier.height(14.dp))
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = Color(0xFFE8F5E9)
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    val totalCount = quest?.questionCount ?: 5
                                    val safeBestScore = (questWithProgress?.score ?: 0).coerceIn(0, totalCount)
                                    Text(
                                        text = "Skor Terbaik: $safeBestScore / $totalCount",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF2E7D32)
                                    )
                                }
                            }
                        }
                    }
                }

                // Info & Rewards Cards
                Text(
                    text = "Hadiah Petualangan",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    RewardCard(
                        modifier = Modifier.weight(1f),
                        icon = "⭐",
                        label = "XP Hadiah",
                        value = "+${quest?.xpReward ?: 150} XP",
                        accentColor = Color(0xFFFFA000)
                    )
                    RewardCard(
                        modifier = Modifier.weight(1f),
                        icon = "🪙",
                        label = "Koin Emas",
                        value = "+${quest?.coinReward ?: 20} Koin",
                        accentColor = Color(0xFFFBC02D)
                    )
                    RewardCard(
                        modifier = Modifier.weight(1f),
                        icon = "❓",
                        label = "Soal",
                        value = "${quest?.questionCount ?: 2} Soal",
                        accentColor = MaterialTheme.colorScheme.primary
                    )
                }

                if (status == QuestStatus.COMPLETED) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "🛡️", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Hadiah XP & Koin telah diklaim sebelumnya. Misi ini dapat diulang untuk melatih ingatan.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                // Level requirement info
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🎯",
                            fontSize = 24.sp,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                        Column {
                            Text(
                                text = "Syarat Membuka",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Level ${quest?.unlockLevel ?: 1} ke atas (Level Anda: ${player?.level ?: 1})",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Action Button
                val buttonText = when (status) {
                    QuestStatus.LOCKED -> "🔒 Terkunci (Perlu Level ${quest?.unlockLevel ?: 1})"
                    QuestStatus.AVAILABLE -> "🚀 Mulai Petualangan"
                    QuestStatus.IN_PROGRESS -> "⚡ Lanjutkan Misi"
                    QuestStatus.COMPLETED -> "🔄 Mainkan Lagi"
                }

                val isEnabled = status != QuestStatus.LOCKED

                Button(
                    onClick = {
                        if (status == QuestStatus.AVAILABLE) {
                            questViewModel.startQuest(playerId, questId) {
                                onNavigateToQuiz(questId)
                            }
                        } else {
                            onNavigateToQuiz(questId)
                        }
                    },
                    enabled = isEnabled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (status) {
                            QuestStatus.COMPLETED -> Color(0xFF2E7D32)
                            QuestStatus.IN_PROGRESS -> Color(0xFFEF6C00)
                            else -> MaterialTheme.colorScheme.primary
                        }
                    )
                ) {
                    Text(
                        text = buttonText,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusBadge(
    status: QuestStatus,
    unlockLevel: Int
) {
    val (text, bgColor, textColor) = when (status) {
        QuestStatus.LOCKED -> Triple("🔒 Terkunci (Lv.$unlockLevel)", Color(0xFFFFEBEE), Color(0xFFC62828))
        QuestStatus.AVAILABLE -> Triple("⚡ Siap Dimainkan", Color(0xFFE3F2FD), Color(0xFF1565C0))
        QuestStatus.IN_PROGRESS -> Triple("⏳ Berjalan", Color(0xFFFFF3E0), Color(0xFFE65100))
        QuestStatus.COMPLETED -> Triple("✅ Selesai", Color(0xFFE8F5E9), Color(0xFF2E7D32))
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = bgColor
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Composable
private fun RewardCard(
    modifier: Modifier = Modifier,
    icon: String,
    label: String,
    value: String,
    accentColor: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = icon, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = accentColor
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
