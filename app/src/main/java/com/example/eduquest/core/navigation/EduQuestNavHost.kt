package com.example.eduquest.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eduquest.feature.achievement.AchievementScreen
import com.example.eduquest.feature.collection.CollectionScreen
import com.example.eduquest.feature.daily.DailyMissionScreen
import com.example.eduquest.feature.exam.ExamScreen
import com.example.eduquest.feature.home.HomeScreen
import com.example.eduquest.feature.leaderboard.LeaderboardScreen
import com.example.eduquest.feature.onboarding.OnboardingScreen
import com.example.eduquest.feature.player.PlayerViewModel
import com.example.eduquest.feature.profile.ProfileScreen
import com.example.eduquest.feature.quest.QuestDetailScreen
import com.example.eduquest.feature.quiz.QuizScreen
import com.example.eduquest.feature.result.ResultScreen
import com.example.eduquest.feature.settings.SettingsScreen
import com.example.eduquest.feature.world.WorldScreen

@Composable
fun EduQuestNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route,
    initialSubject: String? = null,
    playerViewModel: PlayerViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onStartClick = { navController.navigate(Screen.World.route) },
                onProfileClick = { navController.navigate(Screen.Profile.route) },
                onAchievementClick = { navController.navigate(Screen.Achievement.route) },
                onCollectionClick = { navController.navigate(Screen.Collection.route) },
                onDailyMissionClick = { navController.navigate(Screen.DailyMission.route) },
                onLeaderboardClick = { navController.navigate(Screen.Leaderboard.route) },
                onSettingsClick = { navController.navigate(Screen.Settings.route) },
                onExamClick = { navController.navigate(Screen.Exam.route) },
                onNavigateToOnboarding = { navController.navigate(Screen.Onboarding.route) },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.World.route) {
            WorldScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuest = { questId ->
                    navController.navigate(Screen.QuestDetail.createRoute(questId))
                },
                initialSubjectId = initialSubject
            )
        }

        composable(
            route = Screen.QuestDetail.route,
            arguments = listOf(
                navArgument("questId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val questId = backStackEntry.arguments?.getString("questId") ?: ""
            QuestDetailScreen(
                questId = questId,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToQuiz = { qId ->
                    navController.navigate(Screen.Quiz.createRoute(qId))
                }
            )
        }

        composable(
            route = Screen.Quiz.route,
            arguments = listOf(
                navArgument("questId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val questId = backStackEntry.arguments?.getString("questId") ?: ""
            QuizScreen(
                questId = questId,
                onNavigateBack = { navController.popBackStack() },
                onNavigateToResult = { qId ->
                    navController.navigate(Screen.Result.createRoute(qId)) {
                        popUpTo(Screen.QuestDetail.createRoute(qId)) { inclusive = false }
                    }
                },
                playerViewModel = playerViewModel
            )
        }

        composable(
            route = Screen.Result.route,
            arguments = listOf(
                navArgument("questId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val questId = backStackEntry.arguments?.getString("questId") ?: ""
            ResultScreen(
                questId = questId,
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onNavigateToWorld = {
                    navController.navigate(Screen.World.route) {
                        popUpTo(Screen.World.route) { inclusive = true }
                    }
                },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToAchievements = { navController.navigate(Screen.Achievement.route) },
                onNavigateToCollections = { navController.navigate(Screen.Collection.route) },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.Achievement.route) {
            AchievementScreen(
                onNavigateBack = { navController.popBackStack() },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.Collection.route) {
            CollectionScreen(
                onNavigateBack = { navController.popBackStack() },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.DailyMission.route) {
            DailyMissionScreen(
                onNavigateBack = { navController.popBackStack() },
                playerViewModel = playerViewModel
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToOnboarding = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Leaderboard.route) {
            LeaderboardScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Exam.route) {
            ExamScreen(
                onNavigateBack = { navController.popBackStack() },
                onGoToWorld = {
                    navController.navigate(Screen.World.route) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }
    }
}