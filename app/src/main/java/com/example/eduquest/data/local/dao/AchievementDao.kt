package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.AchievementEntity
import com.example.eduquest.data.local.entity.PlayerAchievementEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AchievementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievement(achievement: AchievementEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievements(achievements: List<AchievementEntity>)

    @Query("SELECT * FROM achievements")
    fun getAllAchievements(): Flow<List<AchievementEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPlayerAchievement(playerAchievement: PlayerAchievementEntity)

    @Query("SELECT * FROM player_achievements WHERE playerId = :playerId")
    fun getPlayerAchievements(playerId: String): Flow<List<PlayerAchievementEntity>>

    @Query("SELECT * FROM player_achievements WHERE playerId = :playerId AND achievementId = :achievementId")
    suspend fun getPlayerAchievement(playerId: String, achievementId: String): PlayerAchievementEntity?

    @Query("SELECT COUNT(*) FROM achievements")
    suspend fun getAchievementCount(): Int

    @Query("SELECT * FROM achievements")
    suspend fun getAllAchievementsList(): List<AchievementEntity>

    @Query("SELECT * FROM player_achievements WHERE playerId = :playerId")
    suspend fun getPlayerAchievementsList(playerId: String): List<PlayerAchievementEntity>

    @Query("SELECT COUNT(*) FROM player_achievements WHERE playerId = :playerId AND unlocked = 1")
    fun getUnlockedCountFlow(playerId: String): Flow<Int>

    @Query("DELETE FROM player_achievements")
    suspend fun deleteAllPlayerAchievements()
}
