package com.example.eduquest

import com.example.eduquest.data.local.seed.KnowledgeCardStarterData
import com.example.eduquest.domain.model.KnowledgeCard
import com.example.eduquest.domain.model.KnowledgeCardWithStatus
import com.example.eduquest.feature.collection.CollectionUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class KnowledgeCardTest {

    @Test
    fun starterCards_haveValidConfiguration() {
        val cards = KnowledgeCardStarterData.STARTER_CARDS
        assertTrue("Starter cards should not be empty", cards.isNotEmpty())
        assertEquals(29, cards.size)

        for (card in cards) {
            assertTrue("ID should not be empty", card.id.isNotEmpty())
            assertTrue("Title should not be empty", card.title.isNotEmpty())
            assertTrue("Category should not be empty", card.category.isNotEmpty())
            assertTrue("Description should not be empty", card.description.isNotEmpty())
            assertTrue("Fact should not be empty", card.fact.isNotEmpty())
            assertTrue("Unlock condition should not be empty", card.unlockCondition.isNotEmpty())
        }
    }

    @Test
    fun collectionPercentage_calculatedCorrectly() {
        val stateZero = CollectionUiState(totalCount = 8, unlockedCount = 0)
        assertEquals(0, stateZero.collectionPercentage)

        val stateQuarter = CollectionUiState(totalCount = 8, unlockedCount = 2)
        assertEquals(25, stateQuarter.collectionPercentage)

        val stateHalf = CollectionUiState(totalCount = 8, unlockedCount = 4)
        assertEquals(50, stateHalf.collectionPercentage)

        val stateFull = CollectionUiState(totalCount = 8, unlockedCount = 8)
        assertEquals(100, stateFull.collectionPercentage)

        val stateEmptyTotal = CollectionUiState(totalCount = 0, unlockedCount = 0)
        assertEquals(0, stateEmptyTotal.collectionPercentage)
    }

    @Test
    fun categoryFiltering_filtersCorrectly() {
        val c1 = KnowledgeCard("1", "Nol", "Matematika", "desc", "fact", "asset", "q1")
        val c2 = KnowledgeCard("2", "Elang", "Hewan", "desc", "fact", "asset", "q2")
        val c3 = KnowledgeCard("3", "Saturnus", "Antariksa", "desc", "fact", "asset", "q3")

        val cardItems = listOf(
            KnowledgeCardWithStatus(c1, isUnlocked = true),
            KnowledgeCardWithStatus(c2, isUnlocked = false),
            KnowledgeCardWithStatus(c3, isUnlocked = true)
        )

        val stateAll = CollectionUiState(cards = cardItems, selectedCategory = "ALL")
        assertEquals(3, stateAll.filteredCards.size)

        val stateMath = CollectionUiState(cards = cardItems, selectedCategory = "Matematika")
        assertEquals(1, stateMath.filteredCards.size)
        assertEquals("Matematika", stateMath.filteredCards.first().card.category)

        val stateAnimals = CollectionUiState(cards = cardItems, selectedCategory = "Hewan")
        assertEquals(1, stateAnimals.filteredCards.size)
        assertEquals("Hewan", stateAnimals.filteredCards.first().card.category)

        val stateNonExistent = CollectionUiState(cards = cardItems, selectedCategory = "Robot")
        assertEquals(0, stateNonExistent.filteredCards.size)
    }

    @Test
    fun duplicateUnlock_preservesOriginalUnlockTimestamp() {
        val card = KnowledgeCard("card_01", "Nol", "Matematika", "desc", "fact", "asset", "q1")
        val originalTimestamp = 1600000000000L

        val unlockedCard = KnowledgeCardWithStatus(
            card = card,
            isUnlocked = true,
            unlockedAt = originalTimestamp
        )

        assertTrue(unlockedCard.isUnlocked)
        assertEquals(originalTimestamp, unlockedCard.unlockedAt)
    }
}
