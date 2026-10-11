package com.example.eduquest.domain.model

data class CoinTransactionResult(
    val isSuccess: Boolean,
    val previousBalance: Int,
    val newBalance: Int,
    val amountChanged: Int,
    val errorMessage: String? = null
)
