package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.SubjectEntity
import com.example.eduquest.data.local.entity.TopicEntity
import com.example.eduquest.data.local.entity.WorldEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorldDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorld(world: WorldEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorlds(worlds: List<WorldEntity>)

    @Query("SELECT * FROM worlds ORDER BY orderIndex ASC")
    fun getAllWorlds(): Flow<List<WorldEntity>>

    @Query("SELECT * FROM worlds ORDER BY orderIndex ASC")
    suspend fun getAllWorldsList(): List<WorldEntity>

    @Query("SELECT COUNT(*) FROM worlds")
    suspend fun getWorldCount(): Int

    @Query("SELECT * FROM worlds WHERE id = :id")
    suspend fun getWorldById(id: String): WorldEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: SubjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjects(subjects: List<SubjectEntity>)

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<SubjectEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopic(topic: TopicEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopics(topics: List<TopicEntity>)

    @Query("SELECT * FROM topics WHERE subjectId = :subjectId")
    fun getTopicsBySubject(subjectId: String): Flow<List<TopicEntity>>
}
