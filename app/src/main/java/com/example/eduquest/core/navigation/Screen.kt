package com.example.eduquest.core.navigation

sealed class Screen(val route: String) {
    data object Onboarding : Screen("onboarding")
    data object Home : Screen("home")
    data object World : Screen("world")
    data object QuestDetail : Screen("quest/{questId}") {
        fun createRoute(questId: String) = "quest/$questId"
    }
    data object Quiz : Screen("quiz/{questId}") {
        fun createRoute(questId: String) = "quiz/$questId"
    }
    data object Result : Screen("result/{questId}") {
        fun createRoute(questId: String) = "result/$questId"
    }
    data object Profile : Screen("profile")
    data object Achievement : Screen("achievement")
    data object Collection : Screen("collection")
    data object DailyMission : Screen("daily_mission")
    data object Settings : Screen("settings")
    data object Exam : Screen("exam")
    data object Leaderboard : Screen("leaderboard")
}