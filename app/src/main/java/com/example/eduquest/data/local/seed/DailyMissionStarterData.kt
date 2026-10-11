package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.DailyMissionEntity

object DailyMissionStarterData {
    val STARTER_MISSIONS = listOf(
        DailyMissionEntity(
            id = "daily_math_01",
            title = "Pakar Matematika Cilik",
            category = "MATH",
            targetCount = 3,
            rewardXp = 75,
            rewardCoins = 15
        ),
        DailyMissionEntity(
            id = "daily_science_01",
            title = "Penjelajah Sains Alam",
            category = "SCIENCE",
            targetCount = 2,
            rewardXp = 75,
            rewardCoins = 10
        ),
        DailyMissionEntity(
            id = "daily_lang_01",
            title = "Kosa Kata Pintar",
            category = "LANGUAGE",
            targetCount = 2,
            rewardXp = 75,
            rewardCoins = 10
        ),
        DailyMissionEntity(
            id = "daily_quest_01",
            title = "Petualang Hari Ini",
            category = "QUEST",
            targetCount = 1,
            rewardXp = 75,
            rewardCoins = 15
        ),
        DailyMissionEntity(
            id = "daily_all_01",
            title = "Semangat Belajar Tiada Henti",
            category = "ANY_QUESTION",
            targetCount = 5,
            rewardXp = 100,
            rewardCoins = 20
        ),
        DailyMissionEntity(
            id = "daily_perfect_01",
            title = "Bintang Cemerlang Sempurna",
            category = "PERFECT_SCORE",
            targetCount = 1,
            rewardXp = 100,
            rewardCoins = 20
        ),
        DailyMissionEntity(
            id = "daily_quest_02",
            title = "Penjelajah Dua Dunia",
            category = "QUEST",
            targetCount = 2,
            rewardXp = 150,
            rewardCoins = 25
        )
    )

    val CORE_DAILY_MISSION_IDS = listOf(
        "daily_math_01",
        "daily_science_01",
        "daily_lang_01",
        "daily_quest_01"
    )
}
