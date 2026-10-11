package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.KnowledgeCardDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.entity.PlayerCardEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.seed.KnowledgeCardStarterData
import com.example.eduquest.domain.model.CardUnlockResult
import com.example.eduquest.domain.model.KnowledgeCardWithStatus
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.repository.KnowledgeCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import com.example.eduquest.data.local.dao.PlayerDao
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

class KnowledgeCardRepositoryImpl(
    private val knowledgeCardDao: KnowledgeCardDao,
    private val progressDao: ProgressDao,
    private val playerDao: PlayerDao? = null
) : KnowledgeCardRepository {

    private suspend fun resolveEffectivePlayerId(playerId: String): String {
        if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") return playerId
        return playerDao?.getActivePlayerDirect()?.id ?: playerId
    }

    override suspend fun ensureStarterCardsSeeded() {
        if (knowledgeCardDao.getCardCount() < KnowledgeCardStarterData.STARTER_CARDS.size) {
            knowledgeCardDao.insertCards(KnowledgeCardStarterData.STARTER_CARDS)
        }
    }

    override fun getAllCardsWithStatus(playerId: String): Flow<List<KnowledgeCardWithStatus>> = flow {
        ensureStarterCardsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val cardsFlow = knowledgeCardDao.getAllCards()
        val playerCardsFlow = knowledgeCardDao.getPlayerCards(effectivePlayerId)

        emitAll(combine(cardsFlow, playerCardsFlow) { cards, playerCards ->
            val unlockedMap = playerCards.associateBy { it.cardId }

            cards.map { cardEntity ->
                val playerCard = unlockedMap[cardEntity.id]
                KnowledgeCardWithStatus(
                    card = cardEntity.toDomain(),
                    isUnlocked = playerCard != null,
                    unlockedAt = playerCard?.unlockedAt
                )
            }
        })
    }

    override fun getCardsByCategory(playerId: String, category: String): Flow<List<KnowledgeCardWithStatus>> = flow {
        ensureStarterCardsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val cardsFlow = if (category.uppercase() == "ALL" || category.uppercase() == "SEMUA") {
            knowledgeCardDao.getAllCards()
        } else {
            knowledgeCardDao.getCardsByCategory(category)
        }
        val playerCardsFlow = knowledgeCardDao.getPlayerCards(effectivePlayerId)

        emitAll(combine(cardsFlow, playerCardsFlow) { cards, playerCards ->
            val unlockedMap = playerCards.associateBy { it.cardId }

            cards.map { cardEntity ->
                val playerCard = unlockedMap[cardEntity.id]
                KnowledgeCardWithStatus(
                    card = cardEntity.toDomain(),
                    isUnlocked = playerCard != null,
                    unlockedAt = playerCard?.unlockedAt
                )
            }
        })
    }

    override suspend fun unlockCardForQuest(playerId: String, questId: String): List<CardUnlockResult> {
        ensureStarterCardsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val allCards = knowledgeCardDao.getAllCardsList()
        val matchingCards = allCards.filter { it.unlockCondition == questId }
        val results = mutableListOf<CardUnlockResult>()

        for (card in matchingCards) {
            val existing = knowledgeCardDao.getPlayerCard(effectivePlayerId, card.id)
            if (existing == null) {
                val now = System.currentTimeMillis()
                knowledgeCardDao.insertPlayerCard(
                    PlayerCardEntity(
                        playerId = effectivePlayerId,
                        cardId = card.id,
                        unlockedAt = now
                    )
                )
                results.add(
                    CardUnlockResult(
                        card = card.toDomain(),
                        unlockedAt = now,
                        isNewUnlock = true
                    )
                )
            }
        }

        return results
    }

    override suspend fun syncCardsForCompletedQuests(playerId: String): List<CardUnlockResult> {
        ensureStarterCardsSeeded()
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        val progressList = progressDao.getPlayerProgressFlow(effectivePlayerId).firstOrNull() ?: emptyList()
        val completedQuestIds = progressList
            .filter { it.status == QuestStatus.COMPLETED.name }
            .map { it.questId }
            .toSet()

        val newlyUnlocked = mutableListOf<CardUnlockResult>()
        for (questId in completedQuestIds) {
            val results = unlockCardForQuest(effectivePlayerId, questId)
            newlyUnlocked.addAll(results)
        }

        return newlyUnlocked
    }

    override fun getUnlockedCountFlow(playerId: String): Flow<Int> = flow {
        val effectivePlayerId = resolveEffectivePlayerId(playerId)
        emitAll(knowledgeCardDao.getUnlockedCardCountFlow(effectivePlayerId))
    }
}
