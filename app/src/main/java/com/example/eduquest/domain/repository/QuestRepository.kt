package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestCompletionResult
import com.example.eduquest.domain.model.QuestWithProgress
import kotlinx.coroutines.flow.Flow

interface QuestRepository {
    fun getQuestsByWorld(worldId: String): Flow<List<Quest>>
    fun getQuestsBySubject(subjectId: String): Flow<List<Quest>>
    fun getQuestsWithProgress(playerId: String, subjectId: String? = null): Flow<List<QuestWithProgress>>
    suspend fun getQuestById(questId: String): Quest?
    suspend fun getQuestWithProgress(playerId: String, questId: String): QuestWithProgress?
    suspend fun startQuest(playerId: String, questId: String)
    suspend fun completeQuest(
        playerId: String,
        questId: String,
        score: Int,
        totalQuestions: Int
    ): QuestCompletionResult
    suspend fun ensureStarterQuestsSeeded()
}
