package com.example.eduquest.feature.quiz

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.example.eduquest.core.audio.SoundManager
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.QuestionOption
import com.example.eduquest.feature.player.PlayerViewModel

@Composable
fun QuizScreen(
    questId: String,
    onNavigateBack: () -> Unit,
    onNavigateToResult: (String) -> Unit,
    quizViewModel: QuizViewModel = viewModel(),
    playerViewModel: PlayerViewModel = viewModel()
) {
    val quizState by quizViewModel.uiState.collectAsState()
    val playerState by playerViewModel.uiState.collectAsState()

    val player = playerState.player
    val playerGrade = player?.grade ?: 1
    val playerId = player?.id ?: "PLAYER_LOCAL"

    LaunchedEffect(questId, playerGrade, playerId) {
        quizViewModel.loadQuiz(questId = questId, grade = playerGrade, playerId = playerId)
    }

    LaunchedEffect(quizState.isQuizFinished) {
        if (quizState.isQuizFinished) {
            onNavigateToResult(questId)
        }
    }

    Scaffold(
        topBar = {
            EduQuestTopBar(
                title = "Tantangan Kuis",
                onBackClick = {
                    SoundManager.playClick()
                    onNavigateBack()
                }
            )
        }
    ) { paddingValues ->
        when {
            quizState.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                }
            }

            quizState.error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Terjadi Kesalahan",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.error
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = quizState.error ?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { quizViewModel.loadQuiz(questId, playerGrade) }) {
                            Text("Coba Lagi")
                        }
                    }
                }
            }

            quizState.currentQuestion != null -> {
                val question = quizState.currentQuestion!!
                val options = question.getOptions()
                val isSubmitted = quizState.isAnswerSubmitted
                val validation = quizState.validationResult
                val isLastQuestion = quizState.currentIndex + 1 >= quizState.totalQuestions

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Progress Indicator Bar
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Soal ${quizState.currentIndex + 1} dari ${quizState.totalQuestions}",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "⚡ +${question.xpReward} XP",
                                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        val animatedQuizProgress by animateFloatAsState(
                            targetValue = quizState.progressPercentage,
                            animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
                            label = "quizProgressAnim"
                        )

                        LinearProgressIndicator(
                            progress = { animatedQuizProgress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = MaterialTheme.colorScheme.primary,
                            trackColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                        )
                    }

                    // Question Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        )
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
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = MaterialTheme.colorScheme.primaryContainer
                                ) {
                                    Text(
                                        text = "${question.subjectId} • ${question.topicId}",
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }

                                Text(
                                    text = when (question.difficulty) {
                                        Difficulty.EASY -> "Mudah"
                                        Difficulty.NORMAL -> "Sedang"
                                        Difficulty.HARD -> "Tantangan"
                                    },
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(
                                text = question.questionText,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontSize = 18.sp,
                                    lineHeight = 26.sp,
                                    fontWeight = FontWeight.SemiBold
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    // Options List
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        for (option in options) {
                            OptionItem(
                                option = option,
                                isSelected = quizState.selectedOption == option.key,
                                isSubmitted = isSubmitted,
                                isCorrectOption = option.key.equals(question.correctAnswer, ignoreCase = true),
                                onSelect = {
                                    if (!isSubmitted) {
                                        com.example.eduquest.core.audio.SoundManager.playClick()
                                        quizViewModel.selectOption(option.key)
                                    }
                                }
                            )
                        }
                    }

                    // Explanation Banner (when answered)
                    AnimatedVisibility(
                        visible = isSubmitted && validation != null,
                        enter = fadeIn(tween(300)) + expandVertically(tween(300)),
                        exit = fadeOut(tween(200)) + shrinkVertically(tween(200))
                    ) {
                        if (validation != null) {
                            val isCorrect = validation.isCorrect
                            val bannerBg = if (isCorrect) Color(0xFFE8F5E9) else Color(0xFFFFF3E0)
                            val bannerBorder = if (isCorrect) Color(0xFF4CAF50) else Color(0xFFFF9800)
                            val titleColor = if (isCorrect) Color(0xFF2E7D32) else Color(0xFFE65100)

                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = bannerBg)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(1.5.dp, bannerBorder, RoundedCornerShape(16.dp))
                                        .padding(16.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = if (isCorrect) "🎉 Hebat! Jawabanmu Benar!" else "💡 Belum Tepat",
                                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                            color = titleColor
                                        )
                                        if (isCorrect) {
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = Color(0xFFC8E6C9)
                                            ) {
                                                Text(
                                                    text = if (quizState.isRepeatQuest) "+${validation.xpEarned} XP (Latihan)" else "+${validation.xpEarned} XP",
                                                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                                    color = Color(0xFF1B5E20),
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                )
                                            }
                                        }
                                    }

                                    if (!isCorrect) {
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = "Jawaban yang benar adalah: Pilihan ${validation.correctAnswer}",
                                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                                            color = titleColor
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = validation.explanation,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFF212121)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Bottom Action Button
                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                com.example.eduquest.core.audio.SoundManager.playClick()
                                quizViewModel.submitAnswer(playerId = playerId)
                            },
                            enabled = quizState.selectedOption != null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                text = "Periksa Jawaban",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    } else {
                        Button(
                            onClick = {
                                com.example.eduquest.core.audio.SoundManager.playClick()
                                quizViewModel.nextQuestion(playerId = playerId)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(
                                text = if (isLastQuestion) "Lihat Hasil Kuis 🎉" else "Soal Berikutnya ➔",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }

            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Tidak ada soal untuk quest ini.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
private fun OptionItem(
    option: QuestionOption,
    isSelected: Boolean,
    isSubmitted: Boolean,
    isCorrectOption: Boolean,
    onSelect: () -> Unit
) {
    val containerColor = when {
        isSubmitted && isCorrectOption -> Color(0xFFE8F5E9)
        isSubmitted && isSelected && !isCorrectOption -> Color(0xFFFFEBEE)
        isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
        else -> MaterialTheme.colorScheme.surface
    }

    val borderColor = when {
        isSubmitted && isCorrectOption -> Color(0xFF4CAF50)
        isSubmitted && isSelected && !isCorrectOption -> Color(0xFFE53935)
        isSelected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)
    }

    val badgeBg = when {
        isSubmitted && isCorrectOption -> Color(0xFF4CAF50)
        isSubmitted && isSelected && !isCorrectOption -> Color(0xFFE53935)
        isSelected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    val badgeTextColor = when {
        isSelected || (isSubmitted && (isCorrectOption || isSelected)) -> Color.White
        else -> MaterialTheme.colorScheme.onSurfaceVariant
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .border(width = if (isSelected || (isSubmitted && isCorrectOption)) 2.dp else 1.dp, color = borderColor, shape = RoundedCornerShape(14.dp))
            .clickable(enabled = !isSubmitted, onClick = onSelect),
        color = containerColor,
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(badgeBg),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option.key,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = badgeTextColor
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = option.text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                ),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            if (isSubmitted) {
                if (isCorrectOption) {
                    Text(text = "✓", fontSize = 20.sp, color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
                } else if (isSelected) {
                    Text(text = "✗", fontSize = 20.sp, color = Color(0xFFC62828), fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
