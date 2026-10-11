package com.example.eduquest

import com.example.eduquest.core.navigation.Screen
import org.junit.Assert.assertEquals
import org.junit.Test

class NavigationRoutesTest {

    @Test
    fun testScreenRoutes() {
        assertEquals("onboarding", Screen.Onboarding.route)
        assertEquals("home", Screen.Home.route)
        assertEquals("world", Screen.World.route)
        assertEquals("quest/{questId}", Screen.QuestDetail.route)
        assertEquals("quiz/{questId}", Screen.Quiz.route)
        assertEquals("result/{questId}", Screen.Result.route)
        assertEquals("profile", Screen.Profile.route)
        assertEquals("achievement", Screen.Achievement.route)
        assertEquals("collection", Screen.Collection.route)
        assertEquals("daily_mission", Screen.DailyMission.route)
        assertEquals("settings", Screen.Settings.route)
        assertEquals("exam", Screen.Exam.route)
    }

    @Test
    fun testRouteCreation() {
        assertEquals("quest/math_101", Screen.QuestDetail.createRoute("math_101"))
        assertEquals("quiz/math_101", Screen.Quiz.createRoute("math_101"))
        assertEquals("result/math_101", Screen.Result.createRoute("math_101"))
    }
}