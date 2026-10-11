package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.AchievementEntity

object AchievementStarterData {
    val STARTER_ACHIEVEMENTS = listOf(
        AchievementEntity(
            id = "FIRST_QUEST",
            title = "Langkah Pertama",
            description = "Selesaikan misi petualangan pertamamu di EduQuest.",
            type = "QUEST_COMPLETED",
            target = 1,
            rewardXp = 100,
            rewardCoins = 20
        ),
        AchievementEntity(
            id = "QUEST_EXPLORER",
            title = "Penjelajah Cilik",
            description = "Selesaikan 3 misi petualangan yang berbeda.",
            type = "QUEST_COMPLETED",
            target = 3,
            rewardXp = 200,
            rewardCoins = 35
        ),
        AchievementEntity(
            id = "MATH_EXPLORER",
            title = "Pakar Berhitung",
            description = "Jawab 3 pertanyaan matematika dengan benar.",
            type = "MATH_CORRECT",
            target = 3,
            rewardXp = 150,
            rewardCoins = 25
        ),
        AchievementEntity(
            id = "SCIENCE_STARTER",
            title = "Peneliti Alam",
            description = "Jawab 2 pertanyaan sains dengan benar.",
            type = "SCIENCE_CORRECT",
            target = 2,
            rewardXp = 150,
            rewardCoins = 25
        ),
        AchievementEntity(
            id = "LANGUAGE_PIONEER",
            title = "Kutu Buku Cilik",
            description = "Jawab 2 pertanyaan bahasa dengan benar.",
            type = "LANGUAGE_CORRECT",
            target = 2,
            rewardXp = 150,
            rewardCoins = 25
        ),
        AchievementEntity(
            id = "PERFECT_STAR",
            title = "Bintang Cemerlang",
            description = "Selesaikan petualangan dengan nilai sempurna (100%).",
            type = "PERFECT_SCORE",
            target = 1,
            rewardXp = 200,
            rewardCoins = 30
        ),
        AchievementEntity(
            id = "LEVEL_UP_HERO",
            title = "Ksatria Edukasi",
            description = "Tingkatkan karaktermu hingga mencapai Level 2.",
            type = "LEVEL_REACHED",
            target = 2,
            rewardXp = 250,
            rewardCoins = 50
        )
    )
}
