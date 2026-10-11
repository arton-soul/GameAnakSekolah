package com.example.eduquest.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eduquest.data.local.dao.AchievementDao
import com.example.eduquest.data.local.dao.DailyMissionDao
import com.example.eduquest.data.local.dao.KnowledgeCardDao
import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.dao.QuestDao
import com.example.eduquest.data.local.dao.QuestionDao
import com.example.eduquest.data.local.dao.WorldDao
import com.example.eduquest.data.local.entity.AchievementEntity
import com.example.eduquest.data.local.entity.AnswerHistoryEntity
import com.example.eduquest.data.local.entity.DailyMissionEntity
import com.example.eduquest.data.local.entity.KnowledgeCardEntity
import com.example.eduquest.data.local.entity.PlayerAchievementEntity
import com.example.eduquest.data.local.entity.PlayerCardEntity
import com.example.eduquest.data.local.entity.PlayerDailyProgressEntity
import com.example.eduquest.data.local.entity.PlayerEntity
import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestProgressEntity
import com.example.eduquest.data.local.entity.QuestQuestionEntity
import com.example.eduquest.data.local.entity.QuestionEntity
import com.example.eduquest.data.local.entity.SubjectEntity
import com.example.eduquest.data.local.entity.TopicEntity
import com.example.eduquest.data.local.entity.WorldEntity

@Database(
    entities = [
        PlayerEntity::class,
        SubjectEntity::class,
        TopicEntity::class,
        QuestionEntity::class,
        WorldEntity::class,
        QuestEntity::class,
        QuestQuestionEntity::class,
        QuestProgressEntity::class,
        AnswerHistoryEntity::class,
        AchievementEntity::class,
        PlayerAchievementEntity::class,
        KnowledgeCardEntity::class,
        PlayerCardEntity::class,
        DailyMissionEntity::class,
        PlayerDailyProgressEntity::class
    ],
    version = 4,
    exportSchema = false
)
abstract class EduQuestDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun questionDao(): QuestionDao
    abstract fun questDao(): QuestDao
    abstract fun progressDao(): ProgressDao
    abstract fun achievementDao(): AchievementDao
    abstract fun knowledgeCardDao(): KnowledgeCardDao
    abstract fun dailyMissionDao(): DailyMissionDao
    abstract fun worldDao(): WorldDao

    companion object {
        private const val DATABASE_NAME = "eduquest.db"

        @Volatile
        private var INSTANCE: EduQuestDatabase? = null

        fun getInstance(context: Context): EduQuestDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EduQuestDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
