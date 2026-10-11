package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.eduquest.data.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Delete
    suspend fun deletePlayer(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id = :id")
    suspend fun getPlayerDirect(id: String): PlayerEntity?

    @Query("SELECT * FROM players WHERE id = :id")
    fun getPlayerFlow(id: String): Flow<PlayerEntity?>

    @Query("SELECT * FROM players ORDER BY createdAt ASC LIMIT 1")
    suspend fun getActivePlayerDirect(): PlayerEntity?

    @Query("SELECT * FROM players ORDER BY createdAt ASC LIMIT 1")
    fun getActivePlayerFlow(): Flow<PlayerEntity?>

    @Query("SELECT * FROM players ORDER BY createdAt ASC")
    fun getAllPlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT COUNT(*) FROM players")
    suspend fun getPlayerCount(): Int

    @Query("DELETE FROM players")
    suspend fun deleteAllPlayers()
}
