package com.example.eduquest.domain.repository

import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getActivePlayer(): Flow<Player?>
    suspend fun getActivePlayerDirect(): Player?
    suspend fun createPlayer(
        nickname: String,
        educationLevel: String = "SD",
        grade: Int = 1,
        avatar: String = "avatar_kancil"
    ): Player
    suspend fun updatePlayer(player: Player)
    suspend fun addXp(playerId: String, amount: Int): LevelUpResult
    fun getPlayerLevelProgress(playerId: String): Flow<LevelProgress>
    suspend fun addCoins(playerId: String, amount: Int): CoinTransactionResult
    suspend fun spendCoins(playerId: String, amount: Int): CoinTransactionResult
    fun getCoinBalance(playerId: String): Flow<Int>
    suspend fun hasPlayer(): Boolean
    suspend fun resetPlayerData()
}
