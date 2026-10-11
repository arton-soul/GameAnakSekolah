package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.CardUnlockResult
import com.example.eduquest.domain.model.KnowledgeCardWithStatus
import kotlinx.coroutines.flow.Flow

interface KnowledgeCardRepository {
    suspend fun ensureStarterCardsSeeded()
    fun getAllCardsWithStatus(playerId: String): Flow<List<KnowledgeCardWithStatus>>
    fun getCardsByCategory(playerId: String, category: String): Flow<List<KnowledgeCardWithStatus>>
    suspend fun unlockCardForQuest(playerId: String, questId: String): List<CardUnlockResult>
    suspend fun syncCardsForCompletedQuests(playerId: String): List<CardUnlockResult>
    fun getUnlockedCountFlow(playerId: String): Flow<Int>
}
