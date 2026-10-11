package com.example.eduquest.domain.model

data class CardUnlockResult(
    val card: KnowledgeCard,
    val unlockedAt: Long,
    val isNewUnlock: Boolean
)
