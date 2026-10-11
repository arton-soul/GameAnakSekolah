package com.example.eduquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.eduquest.core.audio.SoundManager
import com.example.eduquest.core.navigation.EduQuestNavHost
import com.example.eduquest.core.navigation.Screen
import com.example.eduquest.core.ui.theme.EduQuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        SoundManager.init(applicationContext)

        val hasPlayer = try {
            kotlinx.coroutines.runBlocking(kotlinx.coroutines.Dispatchers.IO) {
                com.example.eduquest.core.database.DatabaseProvider.getDatabase(applicationContext).playerDao().getPlayerCount() > 0
            }
        } catch (_: Exception) {
            false
        }

        val defaultRoute = if (hasPlayer) Screen.Home.route else Screen.Onboarding.route
        val startDestination = intent?.getStringExtra("startDestination") ?: defaultRoute
        val initialSubject = intent?.getStringExtra("initialSubject")
        setContent {
            EduQuestTheme {
                EduQuestNavHost(
                    startDestination = startDestination,
                    initialSubject = initialSubject
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        SoundManager.resumeBgm()
    }

    override fun onPause() {
        super.onPause()
        SoundManager.pauseBgm()
    }
}
