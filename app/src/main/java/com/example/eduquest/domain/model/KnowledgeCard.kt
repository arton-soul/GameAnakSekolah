package com.example.eduquest.domain.model

data class KnowledgeCard(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val fact: String,
    val imageAsset: String,
    val unlockCondition: String,
    val icon: String = "🃏"
)
