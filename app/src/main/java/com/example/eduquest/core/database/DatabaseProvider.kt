package com.example.eduquest.core.database

import android.content.Context
import com.example.eduquest.data.local.database.EduQuestDatabase

object DatabaseProvider {
    @Volatile
    private var instance: EduQuestDatabase? = null

    fun getDatabase(context: Context): EduQuestDatabase {
        return instance ?: synchronized(this) {
            instance ?: EduQuestDatabase.getInstance(context).also { instance = it }
        }
    }
}
