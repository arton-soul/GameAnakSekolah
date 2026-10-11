package com.example.eduquest.feature.world

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eduquest.core.ui.component.EduQuestTopBar
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.model.WorldAreaWithProgress
import com.example.eduquest.domain.model.WorldWithProgress

@Composable
fun WorldScreen(
    onNavigateBack: () -> Unit,
    onNavigateToQuest: (String) -> Unit,
    initialSubjectId: String? = null,
    viewModel: WorldViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(initialSubjectId) {
        if (!initialSubjectId.isNullOrBlank()) {
            viewModel.selectSubject(initialSubjectId)
        }
    }

    LaunchedEffect(uiState.lockedNotice) {
        uiState.lockedNotice?.let { notice ->
            snackbarHostState.showSnackbar(notice)
            viewModel.dismissNotice()
        }
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let { err ->
            snackbarHostState.showSnackbar(err)
            viewModel.clearError()
        }
    }

    Scaffold(
        topBar = {
            EduQuestTopBar(
                title = "Peta Dunia",
                onBackClick = {
                    SoundManager.playClick()
                    onNavigateBack()
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        if (uiState.isLoading && uiState.worldWithProgress == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // World Overview Card
                item {
                    uiState.worldWithProgress?.let { worldWithProgress ->
                        WorldHeaderCard(
                            worldWithProgress = worldWithProgress,
                            playerLevel = uiState.playerLevel,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                    }
                }

                // Areas Section Header
                item {
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Text(
                            text = "Area Petualangan",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "Pilih area belajar untuk menjelajahi quest",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Areas Row
                item {
                    uiState.worldWithProgress?.areas?.let { areasList ->
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(areasList, key = { it.area.id }) { areaItem ->
                                AreaCardItem(
                                    areaWithProgress = areaItem,
                                    isSelected = uiState.selectedSubjectId.equals(areaItem.area.subjectId, ignoreCase = true),
                                    onClick = {
                                        SoundManager.playClick()
                                        if (uiState.selectedSubjectId.equals(areaItem.area.subjectId, ignoreCase = true)) {
                                            viewModel.selectSubject(null) // deselect / show all
                                        } else {
                                            viewModel.selectSubject(areaItem.area.subjectId)
                                        }
                                    }
                                )
                            }
                        }
                    }
                }

                // Filter Chips
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item {
                            FilterChip(
                                selected = uiState.selectedSubjectId == null,
                                onClick = {
                                    SoundManager.playClick()
                                    viewModel.selectSubject(null)
                                },
                                label = { Text("Semua Area") },
                                shape = RoundedCornerShape(12.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                        }

                        uiState.worldWithProgress?.areas?.forEach { areaItem ->
                            item {
                                val isSelected = uiState.selectedSubjectId.equals(areaItem.area.subjectId, ignoreCase = true)
                                FilterChip(
                                    selected = isSelected,
                                    onClick = {
                                        SoundManager.playClick()
                                        if (isSelected) viewModel.selectSubject(null)
                                        else viewModel.selectSubject(areaItem.area.subjectId)
                                    },
                                    label = {
                                        Text(
                                            text = if (areaItem.isUnlocked) "${areaItem.area.icon} ${areaItem.area.name}"
                                                   else "🔒 ${areaItem.area.name}"
                                        )
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                )
                            }
                        }
                    }
                }

                // Quest List Header
                item {
                    val activeArea = uiState.selectedArea
                    val completedCount = uiState.filteredQuests.count { it.status == QuestStatus.COMPLETED }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = if (activeArea != null) "Misi ${activeArea.area.name}" else "Semua Misi Petualangan",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                        ) {
                            Text(
                                text = "${uiState.filteredQuests.size} Quest • $completedCount Selesai",
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Quest Cards
                items(uiState.filteredQuests, key = { it.quest.id }) { questItem ->
                    QuestCardItem(
                        questWithProgress = questItem,
                        onQuestClick = {
                            SoundManager.playClick()
                            if (questItem.status == QuestStatus.LOCKED) {
                                viewModel.selectSubject(null)
                                // Show helpful notice
                            }
                            onNavigateToQuest(questItem.quest.id)
                        },
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WorldHeaderCard(
    worldWithProgress: WorldWithProgress,
    playerLevel: Int,
    modifier: Modifier = Modifier
) {
    val world = worldWithProgress.world

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = world.icon, fontSize = 32.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "DUNIA 1",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = world.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Black,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "Lv. $playerLevel",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = world.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
            )

            Spacer(modifier = Modifier.height(14.dp))

            val animatedWorldProgress by animateFloatAsState(
                targetValue = worldWithProgress.progressRatio,
                animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                label = "worldProgressAnim"
            )

            LinearProgressIndicator(
                progress = { animatedWorldProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp)),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${worldWithProgress.completedQuests} dari ${worldWithProgress.totalQuests} Quest Selesai",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "${worldWithProgress.completionPercentage}% Progres Dunia",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun AreaCardItem(
    areaWithProgress: WorldAreaWithProgress,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val area = areaWithProgress.area
    val isUnlocked = areaWithProgress.isUnlocked
    val isCompleted = areaWithProgress.isCompleted

    Card(
        modifier = Modifier
            .width(170.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = when {
                isSelected -> MaterialTheme.colorScheme.primaryContainer
                !isUnlocked -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                isCompleted -> Color(0xFFF1F8E9)
                else -> MaterialTheme.colorScheme.surface
            }
        ),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = when {
                isSelected -> MaterialTheme.colorScheme.primary
                !isUnlocked -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                isCompleted -> Color(0xFF81C784)
                else -> MaterialTheme.colorScheme.outlineVariant
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 3.dp else 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(
                            when {
                                !isUnlocked -> MaterialTheme.colorScheme.surfaceVariant
                                isCompleted -> Color(0xFFC8E6C9)
                                else -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isUnlocked) area.icon else "🔒",
                        fontSize = 18.sp
                    )
                }

                // Unlock/Completion Status Badge
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = when {
                        !isUnlocked -> Color(0xFFFFEBEE)
                        isCompleted -> Color(0xFFE8F5E9)
                        areaWithProgress.completedQuests > 0 -> Color(0xFFFFF3E0)
                        else -> Color(0xFFE3F2FD)
                    }
                ) {
                    Text(
                        text = when {
                            !isUnlocked -> "Lv. ${area.unlockLevel}"
                            isCompleted -> "✅ Selesai"
                            areaWithProgress.completedQuests > 0 -> "⏳ Berjalan"
                            else -> "Terbuka"
                        },
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                        fontWeight = FontWeight.Bold,
                        color = when {
                            !isUnlocked -> Color(0xFFC62828)
                            isCompleted -> Color(0xFF2E7D32)
                            areaWithProgress.completedQuests > 0 -> Color(0xFFE65100)
                            else -> Color(0xFF1565C0)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = area.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = if (isUnlocked) MaterialTheme.colorScheme.onSurface
                       else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Text(
                text = area.indonesianName,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            val animatedAreaProgress by animateFloatAsState(
                targetValue = areaWithProgress.progressRatio,
                animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
                label = "areaProgressAnim"
            )

            LinearProgressIndicator(
                progress = { animatedAreaProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = when {
                    !isUnlocked -> Color.Gray
                    isCompleted -> Color(0xFF4CAF50)
                    else -> MaterialTheme.colorScheme.primary
                },
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = when {
                    !isUnlocked -> "Terkunci (Lv. ${area.unlockLevel})"
                    isCompleted -> "✅ ${areaWithProgress.completedQuests} / ${areaWithProgress.totalQuests} Selesai"
                    else -> "${areaWithProgress.completedQuests} / ${areaWithProgress.totalQuests} Selesai"
                },
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                color = when {
                    !isUnlocked -> MaterialTheme.colorScheme.onSurfaceVariant
                    isCompleted -> Color(0xFF2E7D32)
                    else -> MaterialTheme.colorScheme.onSurfaceVariant
                },
                fontWeight = if (isCompleted) FontWeight.Bold else FontWeight.Medium
            )
        }
    }
}

@Composable
fun QuestCardItem(
    questWithProgress: QuestWithProgress,
    onQuestClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val quest = questWithProgress.quest
    val status = questWithProgress.status
    val isLocked = status == QuestStatus.LOCKED
    val isCompleted = status == QuestStatus.COMPLETED

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onQuestClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (status) {
                QuestStatus.COMPLETED -> Color(0xFFF1F8E9)
                QuestStatus.IN_PROGRESS -> Color(0xFFFFF8E1)
                QuestStatus.LOCKED -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                QuestStatus.AVAILABLE -> MaterialTheme.colorScheme.surface
            }
        ),
        border = BorderStroke(
            width = when (status) {
                QuestStatus.COMPLETED -> 1.5.dp
                QuestStatus.IN_PROGRESS -> 1.5.dp
                QuestStatus.AVAILABLE -> 1.dp
                QuestStatus.LOCKED -> 1.dp
            },
            color = when (status) {
                QuestStatus.COMPLETED -> Color(0xFF81C784)
                QuestStatus.IN_PROGRESS -> Color(0xFFFFB74D)
                QuestStatus.AVAILABLE -> MaterialTheme.colorScheme.outlineVariant
                QuestStatus.LOCKED -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isLocked) 0.dp else 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val (subjectBadge, badgeColor) = when (quest.subjectId) {
                    "MATH" -> "🔢 Matematika" to MaterialTheme.colorScheme.primaryContainer
                    "SCIENCE" -> "🔬 Sains" to MaterialTheme.colorScheme.secondaryContainer
                    "LANGUAGE" -> "📖 Bahasa" to MaterialTheme.colorScheme.tertiaryContainer
                    else -> "Umum" to MaterialTheme.colorScheme.surfaceVariant
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = badgeColor
                ) {
                    Text(
                        text = subjectBadge,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                QuestStatusBadge(status = status, unlockLevel = quest.unlockLevel)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${if (isCompleted) "✅ " else ""}${quest.title}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = when {
                    isLocked -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f)
                    isCompleted -> Color(0xFF1B5E20)
                    else -> MaterialTheme.colorScheme.onSurface
                }
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = quest.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "⭐ +${quest.xpReward} XP",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "🪙 +${quest.coinReward}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                Button(
                    onClick = onQuestClick,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when (status) {
                            QuestStatus.COMPLETED -> Color(0xFF2E7D32)
                            QuestStatus.IN_PROGRESS -> Color(0xFFEF6C00)
                            QuestStatus.LOCKED -> MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
                            QuestStatus.AVAILABLE -> MaterialTheme.colorScheme.primary
                        }
                    )
                ) {
                    val label = when (status) {
                        QuestStatus.LOCKED -> "🔒 Lv.${quest.unlockLevel}"
                        QuestStatus.AVAILABLE -> "Mulai ▶"
                        QuestStatus.IN_PROGRESS -> "Lanjut ▶"
                        QuestStatus.COMPLETED -> "Ulang ↺"
                    }
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun QuestStatusBadge(
    status: QuestStatus,
    unlockLevel: Int
) {
    val (text, bgColor, textColor) = when (status) {
        QuestStatus.LOCKED -> Triple("🔒 Belum Terbuka (Lv.$unlockLevel)", Color(0xFFFFEBEE), Color(0xFFC62828))
        QuestStatus.AVAILABLE -> Triple("⚡ Belum Selesai (Tersedia)", Color(0xFFE3F2FD), Color(0xFF1565C0))
        QuestStatus.IN_PROGRESS -> Triple("⏳ Sedang Berjalan", Color(0xFFFFF3E0), Color(0xFFE65100))
        QuestStatus.COMPLETED -> Triple("✅ Misi Selesai", Color(0xFFE8F5E9), Color(0xFF2E7D32))
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = bgColor
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}
