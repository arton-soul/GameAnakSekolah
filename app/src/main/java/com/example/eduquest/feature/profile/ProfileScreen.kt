package com.example.eduquest.feature.profile

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import com.example.eduquest.core.audio.SoundManager
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eduquest.core.ui.AvatarHelper
import com.example.eduquest.core.ui.component.EduQuestTopBar
import com.example.eduquest.feature.player.PlayerViewModel

private object ProfileIcons {
    const val AVATAR = "\uD83D\uDC64"
    const val LEVEL = "\uD83C\uDF1F"
    const val XP = "\u26A1"
    const val COIN = "\uD83E\uDE99"
    const val STREAK = "\uD83D\uDD25"
    const val QUEST = "\uD83C\uDFAF"
    const val QUESTION = "\uD83D\uDCDD"
    const val CHECK = "\u2705"
    const val ACCURACY = "\uD83C\uDF96"
    const val ACHIEVEMENT = "\uD83C\uDFC6"
    const val CARD = "\uD83C\uDFB4"
    const val WORLD = "\uD83C\uDFF0"
    const val SCHOOL = "\uD83C\uDF92"
    const val EDIT = "\u270F\uFE0F"
    const val ARROW = "\u2794"
    const val STATS = "\uD83D\uDCCA"
}

@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    onNavigateToAchievements: () -> Unit = {},
    onNavigateToCollections: () -> Unit = {},
    viewModel: ProfileViewModel = viewModel(),
    playerViewModel: PlayerViewModel? = null
) {
    val uiState by viewModel.uiState.collectAsState()
    val player = uiState.player

    var showEditDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            EduQuestTopBar(
                title = "Profil Petualang",
                onBackClick = {
                    SoundManager.playClick()
                    onNavigateBack()
                }
            )
        }
    ) { paddingValues ->
        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (player == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Profil belum dibuat.\nSilakan buat profil di halaman utama.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            val avatar = AvatarHelper.getAvatar(player.avatar)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Hero Header Card
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
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(88.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surface)
                                .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = avatar.emoji, fontSize = 46.sp)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = player.nickname,
                            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "${player.educationLevel} Kelas ${player.grade} • ${avatar.name}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Coins & Streak Badges
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                                    .padding(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "${ProfileIcons.COIN} ${player.coins} Koin",
                                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                                    .padding(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "${ProfileIcons.STREAK} ${uiState.streakDays} Hari",
                                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedButton(
                            onClick = {
                                SoundManager.playClick()
                                showEditDialog = true
                            },
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("${ProfileIcons.EDIT} Edit Profil")
                        }
                    }
                }

                // Level Progression Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${ProfileIcons.LEVEL} Level ${player.level}",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "${ProfileIcons.XP} ${uiState.levelProgress.xpInCurrentLevel} / ${uiState.levelProgress.xpNeededForNextLevel} XP",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        val animatedLevelProgress by animateFloatAsState(
                            targetValue = uiState.levelProgress.progressPercentage / 100f,
                            animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                            label = "profileLevelProgress"
                        )

                        LinearProgressIndicator(
                            progress = { animatedLevelProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(10.dp)
                                .clip(RoundedCornerShape(5.dp)),
                            color = MaterialTheme.colorScheme.primary,
                            trackColor = MaterialTheme.colorScheme.surface
                        )

                        Text(
                            text = if (uiState.levelProgress.remainingXpToNextLevel > 0) {
                                "Butuh ${uiState.levelProgress.remainingXpToNextLevel} XP lagi untuk naik ke Level ${player.level + 1}!"
                            } else {
                                "Selamat! Level maksimal telah tercapai!"
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.85f)
                        )
                    }
                }

                // Learning Statistics Card (Section 31)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = "${ProfileIcons.STATS} Statistik Belajar",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            StatGridItem(
                                modifier = Modifier.weight(1f),
                                icon = ProfileIcons.QUEST,
                                title = "Quest Selesai",
                                value = "${uiState.completedQuestsCount} / ${uiState.totalQuestsCount}"
                            )
                            StatGridItem(
                                modifier = Modifier.weight(1f),
                                icon = ProfileIcons.QUESTION,
                                title = "Soal Dijawab",
                                value = "${uiState.totalQuestionsAnswered}"
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            StatGridItem(
                                modifier = Modifier.weight(1f),
                                icon = ProfileIcons.CHECK,
                                title = "Jawaban Benar",
                                value = "${uiState.correctAnswersCount}"
                            )
                            StatGridItem(
                                modifier = Modifier.weight(1f),
                                icon = ProfileIcons.ACCURACY,
                                title = "Akurasi Jawaban",
                                value = "${uiState.accuracyPercent}%"
                            )
                        }
                    }
                }

                // Achievements Card (Section 31 & TASK-014)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = ProfileIcons.ACHIEVEMENT, fontSize = 24.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "Pencapaian Petualang",
                                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${uiState.unlockedAchievementsCount} dari ${uiState.totalAchievementsCount} Terbuka",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                    )
                                }
                            }
                            OutlinedButton(
                                onClick = {
                                    SoundManager.playClick()
                                    onNavigateToAchievements()
                                },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Lihat ${ProfileIcons.ARROW}")
                            }
                        }

                        val achProgress = if (uiState.totalAchievementsCount > 0) {
                            uiState.unlockedAchievementsCount.toFloat() / uiState.totalAchievementsCount.toFloat()
                        } else 0f

                        val animatedAchProgress by animateFloatAsState(
                            targetValue = achProgress,
                            animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                            label = "profileAchProgress"
                        )

                        LinearProgressIndicator(
                            progress = { animatedAchProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = MaterialTheme.colorScheme.primary,
                            trackColor = MaterialTheme.colorScheme.surface
                        )
                    }
                }

                // Knowledge Cards Overview (Section 31 & TASK-014)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(text = ProfileIcons.CARD, fontSize = 24.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "Kartu Pengetahuan",
                                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Text(
                                        text = "${uiState.unlockedCardsCount} dari ${uiState.totalCardsCount} Terkumpul",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                    )
                                }
                            }
                            OutlinedButton(
                                onClick = {
                                    SoundManager.playClick()
                                    onNavigateToCollections()
                                },
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text("Lihat ${ProfileIcons.ARROW}")
                            }
                        }

                        val cardProgress = if (uiState.totalCardsCount > 0) {
                            uiState.unlockedCardsCount.toFloat() / uiState.totalCardsCount.toFloat()
                        } else 0f

                        val animatedCardProgress by animateFloatAsState(
                            targetValue = cardProgress,
                            animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
                            label = "profileCardProgress"
                        )

                        LinearProgressIndicator(
                            progress = { animatedCardProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = MaterialTheme.colorScheme.secondary,
                            trackColor = MaterialTheme.colorScheme.surface
                        )
                    }
                }

                // Active World & Grade Information
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Informasi Karakter",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        ProfileStatRow("${ProfileIcons.WORLD} Dunia Aktif", uiState.activeWorldName)
                        ProfileStatRow("${ProfileIcons.SCHOOL} Jenjang Belajar", "${player.educationLevel} (Kelas ${player.grade})")
                        ProfileStatRow("${ProfileIcons.XP} Akumulasi XP", "${player.xp} XP")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    // Edit Profile Dialog
    if (showEditDialog && player != null) {
        var editEducationLevel by remember { mutableStateOf(player.educationLevel) }
        var editNickname by remember { mutableStateOf(player.nickname) }
        var editGrade by remember { mutableIntStateOf(player.grade) }
        var editAvatarId by remember { mutableStateOf(player.avatar) }
        var validationError by remember { mutableStateOf<String?>(null) }
        var showConfirmResetDialog by remember { mutableStateOf(false) }

        val availableAvatars: List<com.example.eduquest.core.ui.AvatarOption> = remember(editEducationLevel) {
            AvatarHelper.getAvatarsForLevel(editEducationLevel)
        }

        val gradeRange = when (editEducationLevel.uppercase()) {
            "SMP" -> 7..9
            "SMA" -> 10..12
            else -> 1..6
        }

        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text("${ProfileIcons.EDIT} Edit Profil Petualang") },
            text = {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Pilih Karakter Avatar:",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        for (av in availableAvatars) {
                            val isSel = av.id == editAvatarId
                            val bgColor = if (isSel) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                            val borderColor = if (isSel) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(bgColor)
                                    .border(if (isSel) 2.5.dp else 1.dp, borderColor, CircleShape)
                                    .clickable {
                                        SoundManager.playClick()
                                        editAvatarId = av.id
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = av.emoji, fontSize = 22.sp)
                            }
                        }
                    }

                    OutlinedTextField(
                        value = editNickname,
                        onValueChange = {
                            editNickname = it
                            if (validationError != null) validationError = null
                        },
                        label = { Text("Nama Panggilan") },
                        isError = validationError != null,
                        supportingText = {
                            if (validationError != null) {
                                Text(text = validationError ?: "", color = MaterialTheme.colorScheme.error)
                            } else {
                                Text(text = "2 - 20 Karakter")
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Education Level Selector
                    Column {
                        Text(
                            text = "Pilih Jenjang Pendidikan:",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            listOf("SD", "SMP", "SMA").forEach { lvl ->
                                val isSelected = lvl.equals(editEducationLevel, ignoreCase = true)
                                FilterChip(
                                    selected = isSelected,
                                    onClick = {
                                        SoundManager.playClick()
                                        editEducationLevel = lvl
                                        when (lvl) {
                                            "SD" -> if (editGrade !in 1..6) editGrade = 1
                                            "SMP" -> if (editGrade !in 7..9) editGrade = 7
                                            "SMA" -> if (editGrade !in 10..12) editGrade = 10
                                        }
                                    },
                                    label = { Text(lvl, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                                    )
                                )
                            }
                        }
                    }

                    // Grade Selection
                    Column {
                        Text(
                            text = "Pilih Kelas ($editEducationLevel):",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            for (g in gradeRange) {
                                val isSelected = g == editGrade
                                Box(
                                    modifier = Modifier
                                        .size(38.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                                        )
                                        .border(
                                            1.dp,
                                            if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                                            RoundedCornerShape(8.dp)
                                        )
                                        .clickable {
                                            SoundManager.playClick()
                                            editGrade = g
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "$g",
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        SoundManager.playClick()
                        val trimmed = editNickname.trim()
                        if (trimmed.length < 2) {
                            validationError = "Nama minimal 2 karakter"
                            return@Button
                        }
                        if (trimmed.length > 20) {
                            validationError = "Nama maksimal 20 karakter"
                            return@Button
                        }

                        if (!editEducationLevel.equals(player.educationLevel, ignoreCase = true)) {
                            // User is switching education levels: require explicit confirmation
                            showConfirmResetDialog = true
                        } else {
                            viewModel.updateProfile(
                                nickname = trimmed,
                                grade = editGrade,
                                avatar = editAvatarId,
                                onSuccess = { showEditDialog = false }
                            )
                            playerViewModel?.updateProfile(
                                nickname = trimmed,
                                grade = editGrade,
                                avatar = editAvatarId
                            )
                        }
                    }
                ) {
                    Text("Simpan")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    SoundManager.playClick()
                    showEditDialog = false
                }) {
                    Text("Batal")
                }
            }
        )

        // Confirmation Dialog for changing education levels
        if (showConfirmResetDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmResetDialog = false },
                title = {
                    Text("⚠️ Ganti Jenjang Pendidikan")
                },
                text = {
                    Text(
                        "Perhatian!\n\nMengubah jenjang dari ${player.educationLevel} ke $editEducationLevel akan mereset seluruh kemajuan petualangan (level, XP, koin, riwayat misi, dan kartu pintar) kembali ke awal (Level 1) untuk petualangan baru di jenjang $editEducationLevel.\n\nApakah kamu yakin ingin berganti jenjang dan memulai dari awal?"
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            SoundManager.playClick()
                            val trimmed = editNickname.trim()
                            viewModel.changeEducationLevel(
                                nickname = trimmed,
                                educationLevel = editEducationLevel,
                                grade = editGrade,
                                avatar = editAvatarId,
                                onSuccess = {
                                    showConfirmResetDialog = false
                                    showEditDialog = false
                                }
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text("Ya, Ganti & Reset")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        SoundManager.playClick()
                        showConfirmResetDialog = false
                    }) {
                        Text("Batal")
                    }
                }
            )
        }
    }
}

@Composable
private fun StatGridItem(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    value: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = icon, fontSize = 18.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun ProfileStatRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
