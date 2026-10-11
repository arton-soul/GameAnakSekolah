package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.QuestionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>)

    @Query("SELECT * FROM questions WHERE id = :id")
    suspend fun getQuestionById(id: String): QuestionEntity?

    @Query("SELECT * FROM questions WHERE grade = :grade AND subjectId = :subjectId")
    fun getQuestionsByGradeAndSubject(grade: Int, subjectId: String): Flow<List<QuestionEntity>>

    @Query("SELECT * FROM questions WHERE topicId = :topicId")
    fun getQuestionsByTopic(topicId: String): Flow<List<QuestionEntity>>

    @Query("""
        SELECT q.* FROM questions q
        INNER JOIN quest_questions qq ON q.id = qq.questionId
        WHERE qq.questId = :questId
        ORDER BY qq.orderIndex ASC
    """)
    suspend fun getQuestionsForQuest(questId: String): List<QuestionEntity>

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getQuestionCount(): Int

    @Query("SELECT * FROM questions WHERE grade = :grade LIMIT :limit")
    suspend fun getQuestionsForGrade(grade: Int, limit: Int = 5): List<QuestionEntity>

    @Query("SELECT * FROM questions LIMIT :limit")
    suspend fun getAllQuestions(limit: Int = 10): List<QuestionEntity>

    @Query("SELECT * FROM questions WHERE isExam = 1 AND educationLevel = :educationLevel ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomExamQuestions(educationLevel: String, limit: Int): List<QuestionEntity>

    @Query("SELECT * FROM questions WHERE isExam = 1 AND educationLevel = :educationLevel AND subjectId = :subjectId ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomExamQuestionsBySubject(educationLevel: String, subjectId: String, limit: Int): List<QuestionEntity>

    @Query("SELECT COUNT(*) FROM questions WHERE isExam = 1 AND educationLevel = :educationLevel")
    suspend fun getExamQuestionCount(educationLevel: String): Int
}
