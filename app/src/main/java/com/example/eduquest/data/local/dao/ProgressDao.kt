package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.AnswerHistoryEntity
import com.example.eduquest.data.local.entity.QuestProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertQuestProgress(progress: QuestProgressEntity)

    @Query("SELECT * FROM quest_progress WHERE playerId = :playerId AND questId = :questId")
    suspend fun getQuestProgress(playerId: String, questId: String): QuestProgressEntity?

    @Query("SELECT * FROM quest_progress WHERE playerId = :playerId")
    fun getPlayerProgressFlow(playerId: String): Flow<List<QuestProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswerHistory(history: AnswerHistoryEntity)

    @Query("SELECT * FROM answer_history WHERE playerId = :playerId AND questId = :questId ORDER BY answeredAt ASC")
    fun getAnswerHistory(playerId: String, questId: String): Flow<List<AnswerHistoryEntity>>

    @Query("SELECT COUNT(*) FROM quest_progress WHERE playerId = :playerId AND status = 'COMPLETED'")
    suspend fun getCompletedQuestCount(playerId: String): Int

    @Query("SELECT COUNT(*) FROM quest_progress WHERE playerId = :playerId AND status = 'COMPLETED'")
    fun getCompletedQuestCountFlow(playerId: String): Flow<Int>

    @Query("SELECT COUNT(DISTINCT qp.questId) FROM quest_progress qp JOIN quests q ON qp.questId = q.id WHERE qp.playerId = :playerId AND qp.status = 'COMPLETED' AND q.educationLevel = :educationLevel")
    suspend fun getCompletedQuestCountByLevel(playerId: String, educationLevel: String): Int

    @Query("SELECT COUNT(DISTINCT qp.questId) FROM quest_progress qp JOIN quests q ON qp.questId = q.id WHERE qp.playerId = :playerId AND qp.status = 'COMPLETED' AND q.educationLevel = :educationLevel AND q.subjectId = :subjectId")
    suspend fun getCompletedQuestCountBySubject(playerId: String, educationLevel: String, subjectId: String): Int

    @Query("SELECT COUNT(*) FROM quest_progress qp JOIN quests q ON qp.questId = q.id WHERE qp.playerId = :playerId AND qp.status = 'COMPLETED' AND qp.score >= q.questionCount")
    suspend fun getPerfectScoreQuestCount(playerId: String): Int

    @Query("SELECT COUNT(*) FROM answer_history a JOIN questions q ON a.questionId = q.id WHERE a.playerId = :playerId AND a.isCorrect = 1 AND q.subjectId = :subjectId")
    suspend fun getCorrectCountBySubject(playerId: String, subjectId: String): Int

    @Query("SELECT COUNT(*) FROM answer_history WHERE playerId = :playerId AND isCorrect = 1")
    suspend fun getTotalCorrectAnswersCount(playerId: String): Int

    @Query("SELECT COUNT(*) FROM answer_history WHERE playerId = :playerId AND isCorrect = 1")
    fun getTotalCorrectAnswersCountFlow(playerId: String): Flow<Int>

    @Query("SELECT COUNT(*) FROM answer_history WHERE playerId = :playerId")
    suspend fun getTotalAnswersCount(playerId: String): Int

    @Query("SELECT COUNT(*) FROM answer_history WHERE playerId = :playerId")
    fun getTotalAnswersCountFlow(playerId: String): Flow<Int>

    @Query("DELETE FROM quest_progress")
    suspend fun deleteAllQuestProgress()

    @Query("DELETE FROM answer_history")
    suspend fun deleteAllAnswerHistory()
}