package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.entity.PlayerEntity
import com.example.eduquest.data.local.entity.toDomain
import com.example.eduquest.data.local.entity.toEntity
import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelTable
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class PlayerRepositoryImpl(
    private val playerDao: PlayerDao
) : PlayerRepository {

    override fun getActivePlayer(): Flow<Player?> {
        return playerDao.getAllPlayers().map { it.firstOrNull()?.toDomain() }
    }

    override suspend fun getActivePlayerDirect(): Player? {
        return playerDao.getActivePlayerDirect()?.toDomain()
    }

    override suspend fun createPlayer(
        nickname: String,
        educationLevel: String,
        grade: Int,
        avatar: String
    ): Player {
        playerDao.deleteAllPlayers()
        val id = "player_" + UUID.randomUUID().toString().take(8)
        val now = System.currentTimeMillis()
        val entity = PlayerEntity(
            id = id,
            nickname = nickname.trim(),
            avatar = avatar,
            educationLevel = educationLevel,
            grade = grade,
            level = 1,
            xp = 0,
            coins = 0,
            currentWorldId = when (educationLevel.trim().uppercase()) {
                "SMP" -> "WORLD_SMP_01"
                "SMA" -> "WORLD_SMA_01"
                else -> "WORLD_01"
            },
            createdAt = now,
            updatedAt = now
        )
        playerDao.insertPlayer(entity)
        return entity.toDomain()
    }

    override suspend fun updatePlayer(player: Player) {
        val calculatedLevel = LevelTable.calculateLevel(player.xp)
        val updated = player.toEntity().copy(
            level = calculatedLevel,
            updatedAt = System.currentTimeMillis()
        )
        playerDao.updatePlayer(updated)
    }

    override suspend fun addXp(playerId: String, amount: Int): LevelUpResult {
        val player = playerDao.getPlayerDirect(playerId)
            ?: playerDao.getActivePlayerDirect()
            ?: throw IllegalStateException("Player not found with id: $playerId")

        val safeAmount = maxOf(0, amount)
        val oldXp = player.xp
        val newXp = oldXp + safeAmount
        val oldLevel = player.level
        val newLevel = LevelTable.calculateLevel(newXp)
        val hasLeveledUp = newLevel > oldLevel
        val bonusCoins = if (hasLeveledUp) (newLevel - oldLevel) * LevelTable.LEVEL_UP_COIN_REWARD else 0
        val newCoins = player.coins + bonusCoins

        val updatedEntity = player.copy(
            xp = newXp,
            level = newLevel,
            coins = newCoins,
            updatedAt = System.currentTimeMillis()
        )
        playerDao.updatePlayer(updatedEntity)

        val progress = LevelTable.calculateProgress(newXp)
        return LevelUpResult(
            oldLevel = oldLevel,
            newLevel = newLevel,
            hasLeveledUp = hasLeveledUp,
            bonusCoins = bonusCoins,
            totalXp = newXp,
            levelProgress = progress
        )
    }

    override fun getPlayerLevelProgress(playerId: String): Flow<LevelProgress> {
        return playerDao.getActivePlayerFlow().map { entity ->
            val xp = entity?.xp ?: 0
            LevelTable.calculateProgress(xp)
        }
    }

    override suspend fun addCoins(playerId: String, amount: Int): CoinTransactionResult {
        if (amount <= 0) {
            val player = playerDao.getPlayerDirect(playerId) ?: playerDao.getActivePlayerDirect()
            val balance = player?.coins ?: 0
            return CoinTransactionResult(
                isSuccess = false,
                previousBalance = balance,
                newBalance = balance,
                amountChanged = 0,
                errorMessage = "Jumlah koin yang ditambahkan harus lebih besar dari 0"
            )
        }

        val player = playerDao.getPlayerDirect(playerId)
            ?: playerDao.getActivePlayerDirect()
            ?: throw IllegalStateException("Player not found with id: $playerId")

        val prevBalance = player.coins
        val newBalance = prevBalance + amount
        playerDao.updatePlayer(player.copy(coins = newBalance, updatedAt = System.currentTimeMillis()))

        return CoinTransactionResult(
            isSuccess = true,
            previousBalance = prevBalance,
            newBalance = newBalance,
            amountChanged = amount
        )
    }

    override suspend fun spendCoins(playerId: String, amount: Int): CoinTransactionResult {
        if (amount <= 0) {
            val player = playerDao.getPlayerDirect(playerId) ?: playerDao.getActivePlayerDirect()
            val balance = player?.coins ?: 0
            return CoinTransactionResult(
                isSuccess = false,
                previousBalance = balance,
                newBalance = balance,
                amountChanged = 0,
                errorMessage = "Jumlah koin yang digunakan harus lebih besar dari 0"
            )
        }

        val player = playerDao.getPlayerDirect(playerId)
            ?: playerDao.getActivePlayerDirect()
            ?: throw IllegalStateException("Player not found with id: $playerId")

        val prevBalance = player.coins
        if (prevBalance < amount) {
            return CoinTransactionResult(
                isSuccess = false,
                previousBalance = prevBalance,
                newBalance = prevBalance,
                amountChanged = 0,
                errorMessage = "Koin tidak mencukupi (Saldo: $prevBalance, Butuh: $amount)"
            )
        }

        val newBalance = prevBalance - amount
        playerDao.updatePlayer(player.copy(coins = newBalance, updatedAt = System.currentTimeMillis()))

        return CoinTransactionResult(
            isSuccess = true,
            previousBalance = prevBalance,
            newBalance = newBalance,
            amountChanged = -amount
        )
    }

    override fun getCoinBalance(playerId: String): Flow<Int> {
        return playerDao.getActivePlayerFlow().map { it?.coins ?: 0 }
    }

    override suspend fun hasPlayer(): Boolean {
        return playerDao.getPlayerCount() > 0
    }

    override suspend fun resetPlayerData() {
        playerDao.deleteAllPlayers()
    }
}
