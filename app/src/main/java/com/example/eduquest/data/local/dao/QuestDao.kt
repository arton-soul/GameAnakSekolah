package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestQuestionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuest(quest: QuestEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuests(quests: List<QuestEntity>)

    @Query("SELECT * FROM quests WHERE id = :id")
    suspend fun getQuestById(id: String): QuestEntity?

    @Query("SELECT * FROM quests WHERE worldId = :worldId")
    fun getQuestsByWorld(worldId: String): Flow<List<QuestEntity>>

    @Query("SELECT * FROM quests WHERE subjectId = :subjectId")
    fun getQuestsBySubject(subjectId: String): Flow<List<QuestEntity>>

    @Query("SELECT * FROM quests")
    fun getAllQuests(): Flow<List<QuestEntity>>

    @Query("SELECT * FROM quests")
    suspend fun getAllQuestsDirect(): List<QuestEntity>

    @Query("SELECT * FROM quests WHERE subjectId = :subjectId")
    suspend fun getQuestsBySubjectDirect(subjectId: String): List<QuestEntity>

    @Query("SELECT COUNT(*) FROM quests")
    suspend fun getQuestCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestQuestions(questQuestions: List<QuestQuestionEntity>)

    @Query("SELECT COUNT(*) FROM quest_questions")
    suspend fun getQuestQuestionCount(): Int

    @Query("DELETE FROM quest_questions")
    suspend fun deleteAllQuestQuestions()

    @Query("DELETE FROM quests")
    suspend fun deleteAllQuests()
}
