package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.DailyMissionEntity
import com.example.eduquest.data.local.entity.PlayerDailyProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyMissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMission(mission: DailyMissionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMissions(missions: List<DailyMissionEntity>)

    @Query("SELECT * FROM daily_missions")
    fun getAllMissions(): Flow<List<DailyMissionEntity>>

    @Query("SELECT * FROM daily_missions")
    suspend fun getAllMissionsList(): List<DailyMissionEntity>

    @Query("SELECT COUNT(*) FROM daily_missions")
    suspend fun getMissionCount(): Int

    @Query("SELECT * FROM daily_missions WHERE id = :id")
    suspend fun getMissionById(id: String): DailyMissionEntity?

    @Query("SELECT * FROM daily_missions WHERE category = :category")
    suspend fun getMissionsByCategory(category: String): List<DailyMissionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDailyProgress(progress: PlayerDailyProgressEntity)

    @Query("SELECT * FROM player_daily_progress WHERE playerId = :playerId AND dateString = :dateString")
    fun getDailyProgress(playerId: String, dateString: String): Flow<List<PlayerDailyProgressEntity>>

    @Query("SELECT * FROM player_daily_progress WHERE playerId = :playerId AND dateString = :dateString")
    suspend fun getDailyProgressList(playerId: String, dateString: String): List<PlayerDailyProgressEntity>

    @Query("SELECT * FROM player_daily_progress WHERE playerId = :playerId AND missionId = :missionId AND dateString = :dateString")
    suspend fun getProgress(playerId: String, missionId: String, dateString: String): PlayerDailyProgressEntity?

    @Query("UPDATE player_daily_progress SET currentProgress = :progress, isCompleted = :isCompleted WHERE playerId = :playerId AND missionId = :missionId AND dateString = :dateString")
    suspend fun updateProgress(playerId: String, missionId: String, dateString: String, progress: Int, isCompleted: Boolean)

    @Query("UPDATE player_daily_progress SET isClaimed = 1 WHERE playerId = :playerId AND missionId = :missionId AND dateString = :dateString")
    suspend fun markClaimed(playerId: String, missionId: String, dateString: String)

    @Query("SELECT COUNT(*) FROM player_daily_progress WHERE playerId = :playerId AND dateString = :dateString AND isCompleted = 1")
    fun getCompletedMissionCountFlow(playerId: String, dateString: String): Flow<Int>

    @Query("SELECT COUNT(*) FROM player_daily_progress WHERE playerId = :playerId AND dateString = :dateString AND isClaimed = 1")
    fun getClaimedMissionCountFlow(playerId: String, dateString: String): Flow<Int>

    @Query("UPDATE player_daily_progress SET playerId = :newPlayerId WHERE playerId = 'PLAYER_LOCAL'")
    suspend fun migrateLocalProgressToPlayer(newPlayerId: String)

    @Query("DELETE FROM player_daily_progress")
    suspend fun deleteAllDailyProgress()
}
