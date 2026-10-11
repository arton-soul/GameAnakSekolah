package com.example.eduquest.domain.model

data class KnowledgeCardWithStatus(
    val card: KnowledgeCard,
    val isUnlocked: Boolean,
    val unlockedAt: Long? = null
)
