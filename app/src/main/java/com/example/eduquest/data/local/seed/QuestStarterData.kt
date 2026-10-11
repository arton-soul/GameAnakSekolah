package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestQuestionEntity

object QuestStarterData {
    val STARTER_QUESTS_SD = listOf(
        // ==========================================
        // === MATEMATIKA (7 QUEST: 35 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_math_01",
            worldId = "WORLD_01",
            title = "Petualangan Angka & Penjumlahan",
            description = "Petualangan awal menghitung angka dan operasi penjumlahan ceria.",
            subjectId = "MATH",
            grade = 1,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_math_02",
            worldId = "WORLD_01",
            title = "Misteri Pengurangan & Kelereng",
            description = "Pecahkan teka-teki pengurangan benda dan hitungan sehari-hari.",
            subjectId = "MATH",
            grade = 2,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_math_03",
            worldId = "WORLD_01",
            title = "Tantangan Perkalian Ceria",
            description = "Kuasai konsep penjumlahan berulang dan tabel perkalian dasar.",
            subjectId = "MATH",
            grade = 3,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_math_04",
            worldId = "WORLD_01",
            title = "Petualangan Pembagian Adil",
            description = "Bagi benda sama rata dan selesaikan operasi hitung pembagian.",
            subjectId = "MATH",
            grade = 3,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_math_05",
            worldId = "WORLD_01",
            title = "Pakar Bangun Datar & Sudut",
            description = "Kenali berbagai jenis bangun datar, simetri lipat, dan jenis sudut.",
            subjectId = "MATH",
            grade = 4,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 190,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_math_06",
            worldId = "WORLD_01",
            title = "Ksatria Keliling & Luas",
            description = "Hitung keliling dan luas bangun persegi, persegi panjang, dan segitiga.",
            subjectId = "MATH",
            grade = 5,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 3
        ),
        QuestEntity(
            id = "quest_math_07",
            worldId = "WORLD_01",
            title = "Master Pecahan & Desimal",
            description = "Sederhanakan pecahan, hitung operasi pecahan, dan ubah ke bentuk desimal.",
            subjectId = "MATH",
            grade = 6,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3
        ),

        // ==========================================
        // === SAINS / IPA (7 QUEST: 35 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_science_01",
            worldId = "WORLD_01",
            title = "Panca Indra Sang Penjelajah",
            description = "Kenali fungsi kelima panca indra manusia dalam menjelajahi alam sekitar.",
            subjectId = "SCIENCE",
            grade = 1,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_science_02",
            worldId = "WORLD_01",
            title = "Wujud Benda & Perubahannya",
            description = "Pelajari sifat benda padat, cair, gas, serta peristiwa mencair dan membeku.",
            subjectId = "SCIENCE",
            grade = 2,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_science_03",
            worldId = "WORLD_01",
            title = "Rahasia Dapur Daun Tumbuhan",
            description = "Temukan kehebatan klorofil, fungsi akar, dan proses fotosintesis pada daun.",
            subjectId = "SCIENCE",
            grade = 3,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_science_04",
            worldId = "WORLD_01",
            title = "Dunia Hewan & Pengelompokannya",
            description = "Klasifikasi hewan berdasarkan jenis makanannya dan cara berkembang biaknya.",
            subjectId = "SCIENCE",
            grade = 3,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_science_05",
            worldId = "WORLD_01",
            title = "Rantai Makanan & Ekosistem",
            description = "Pahami hubungan produsen, konsumen, pengurai, dan ragam simbiosis.",
            subjectId = "SCIENCE",
            grade = 4,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 190,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_science_06",
            worldId = "WORLD_01",
            title = "Gaya, Gerak & Energi di Sekitar",
            description = "Eksplorasi gaya gravitasi, gesek, pegas, dan pemanfaatan energi alternatif.",
            subjectId = "SCIENCE",
            grade = 5,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 3
        ),
        QuestEntity(
            id = "quest_science_07",
            worldId = "WORLD_01",
            title = "Jelajah Tata Surya & Bumi",
            description = "Observasi peredaran planet, matahari, dan peristiwa rotasi serta revolusi.",
            subjectId = "SCIENCE",
            grade = 6,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3
        ),

        // ==========================================
        // === BAHASA INDONESIA (6 QUEST: 30 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_lang_01",
            worldId = "WORLD_01",
            title = "Lawan Kata & Persamaan Kata",
            description = "Kembangkan wawasan kosakata dengan memahami antonim dan sinonim kata.",
            subjectId = "LANGUAGE",
            grade = 1,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_lang_02",
            worldId = "WORLD_01",
            title = "Ejaan Huruf Kapital & Titik",
            description = "Terapkan aturan penulisan huruf kapital nama orang, kota, dan tanda baca.",
            subjectId = "LANGUAGE",
            grade = 2,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 150,
            coinReward = 20,
            unlockLevel = 1
        ),
        QuestEntity(
            id = "quest_lang_03",
            worldId = "WORLD_01",
            title = "Kalimat Tanya & Percakapan",
            description = "Gunakan kata tanya apa, di mana, kapan, siapa, mengapa, dan tanda seru.",
            subjectId = "LANGUAGE",
            grade = 3,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_lang_04",
            worldId = "WORLD_01",
            title = "Menemukan Ide Pokok Paragraf",
            description = "Cari gagasan utama, bedakan paragraf deduktif-induktif, dan kalimat penjelas.",
            subjectId = "LANGUAGE",
            grade = 4,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 190,
            coinReward = 25,
            unlockLevel = 2
        ),
        QuestEntity(
            id = "quest_lang_05",
            worldId = "WORLD_01",
            title = "Rima Pantun & Puisi Indah",
            description = "Pahami struktur pantun (sampiran & isi), sajak a-b-a-b, dan keindahan puisi.",
            subjectId = "LANGUAGE",
            grade = 5,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 3
        ),
        QuestEntity(
            id = "quest_lang_06",
            worldId = "WORLD_01",
            title = "Ungkapan, Peribahasa & Kata Baku",
            description = "Pelajari ungkapan kiasan, peribahasa bijak, dan kata baku sesuai KBBI.",
            subjectId = "LANGUAGE",
            grade = 6,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3
        )
    )

    val STARTER_QUEST_QUESTIONS_SD = listOf(
        // === MATEMATIKA QUESTS (35 mappings) ===
        // quest_math_01: Q_MATH_001..005
        QuestQuestionEntity(questId = "quest_math_01", questionId = "Q_MATH_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_01", questionId = "Q_MATH_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_01", questionId = "Q_MATH_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_01", questionId = "Q_MATH_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_01", questionId = "Q_MATH_005", orderIndex = 4),

        // quest_math_02: Q_MATH_006..010
        QuestQuestionEntity(questId = "quest_math_02", questionId = "Q_MATH_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_02", questionId = "Q_MATH_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_02", questionId = "Q_MATH_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_02", questionId = "Q_MATH_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_02", questionId = "Q_MATH_010", orderIndex = 4),

        // quest_math_03: Q_MATH_011..015
        QuestQuestionEntity(questId = "quest_math_03", questionId = "Q_MATH_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_03", questionId = "Q_MATH_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_03", questionId = "Q_MATH_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_03", questionId = "Q_MATH_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_03", questionId = "Q_MATH_015", orderIndex = 4),

        // quest_math_04: Q_MATH_016..020
        QuestQuestionEntity(questId = "quest_math_04", questionId = "Q_MATH_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_04", questionId = "Q_MATH_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_04", questionId = "Q_MATH_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_04", questionId = "Q_MATH_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_04", questionId = "Q_MATH_020", orderIndex = 4),

        // quest_math_05: Q_MATH_021..025
        QuestQuestionEntity(questId = "quest_math_05", questionId = "Q_MATH_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_05", questionId = "Q_MATH_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_05", questionId = "Q_MATH_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_05", questionId = "Q_MATH_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_05", questionId = "Q_MATH_025", orderIndex = 4),

        // quest_math_06: Q_MATH_026..030
        QuestQuestionEntity(questId = "quest_math_06", questionId = "Q_MATH_026", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_06", questionId = "Q_MATH_027", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_06", questionId = "Q_MATH_028", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_06", questionId = "Q_MATH_029", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_06", questionId = "Q_MATH_030", orderIndex = 4),

        // quest_math_07: Q_MATH_031..035
        QuestQuestionEntity(questId = "quest_math_07", questionId = "Q_MATH_031", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_math_07", questionId = "Q_MATH_032", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_math_07", questionId = "Q_MATH_033", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_math_07", questionId = "Q_MATH_034", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_math_07", questionId = "Q_MATH_035", orderIndex = 4),

        // === SAINS / IPA QUESTS (35 mappings) ===
        // quest_science_01: Q_SCI_001..005
        QuestQuestionEntity(questId = "quest_science_01", questionId = "Q_SCI_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_01", questionId = "Q_SCI_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_01", questionId = "Q_SCI_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_01", questionId = "Q_SCI_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_01", questionId = "Q_SCI_005", orderIndex = 4),

        // quest_science_02: Q_SCI_006..010
        QuestQuestionEntity(questId = "quest_science_02", questionId = "Q_SCI_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_02", questionId = "Q_SCI_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_02", questionId = "Q_SCI_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_02", questionId = "Q_SCI_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_02", questionId = "Q_SCI_010", orderIndex = 4),

        // quest_science_03: Q_SCI_011..015
        QuestQuestionEntity(questId = "quest_science_03", questionId = "Q_SCI_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_03", questionId = "Q_SCI_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_03", questionId = "Q_SCI_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_03", questionId = "Q_SCI_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_03", questionId = "Q_SCI_015", orderIndex = 4),

        // quest_science_04: Q_SCI_016..020
        QuestQuestionEntity(questId = "quest_science_04", questionId = "Q_SCI_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_04", questionId = "Q_SCI_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_04", questionId = "Q_SCI_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_04", questionId = "Q_SCI_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_04", questionId = "Q_SCI_020", orderIndex = 4),

        // quest_science_05: Q_SCI_021..025
        QuestQuestionEntity(questId = "quest_science_05", questionId = "Q_SCI_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_05", questionId = "Q_SCI_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_05", questionId = "Q_SCI_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_05", questionId = "Q_SCI_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_05", questionId = "Q_SCI_025", orderIndex = 4),

        // quest_science_06: Q_SCI_026..030
        QuestQuestionEntity(questId = "quest_science_06", questionId = "Q_SCI_026", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_06", questionId = "Q_SCI_027", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_06", questionId = "Q_SCI_028", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_06", questionId = "Q_SCI_029", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_06", questionId = "Q_SCI_030", orderIndex = 4),

        // quest_science_07: Q_SCI_031..035
        QuestQuestionEntity(questId = "quest_science_07", questionId = "Q_SCI_031", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_science_07", questionId = "Q_SCI_032", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_science_07", questionId = "Q_SCI_033", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_science_07", questionId = "Q_SCI_034", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_science_07", questionId = "Q_SCI_035", orderIndex = 4),

        // === BAHASA INDONESIA QUESTS (30 mappings) ===
        // quest_lang_01: Q_LANG_001..005
        QuestQuestionEntity(questId = "quest_lang_01", questionId = "Q_LANG_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_01", questionId = "Q_LANG_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_01", questionId = "Q_LANG_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_01", questionId = "Q_LANG_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_01", questionId = "Q_LANG_005", orderIndex = 4),

        // quest_lang_02: Q_LANG_006..010
        QuestQuestionEntity(questId = "quest_lang_02", questionId = "Q_LANG_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_02", questionId = "Q_LANG_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_02", questionId = "Q_LANG_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_02", questionId = "Q_LANG_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_02", questionId = "Q_LANG_010", orderIndex = 4),

        // quest_lang_03: Q_LANG_011..015
        QuestQuestionEntity(questId = "quest_lang_03", questionId = "Q_LANG_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_03", questionId = "Q_LANG_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_03", questionId = "Q_LANG_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_03", questionId = "Q_LANG_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_03", questionId = "Q_LANG_015", orderIndex = 4),

        // quest_lang_04: Q_LANG_016..020
        QuestQuestionEntity(questId = "quest_lang_04", questionId = "Q_LANG_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_04", questionId = "Q_LANG_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_04", questionId = "Q_LANG_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_04", questionId = "Q_LANG_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_04", questionId = "Q_LANG_020", orderIndex = 4),

        // quest_lang_05: Q_LANG_021..025
        QuestQuestionEntity(questId = "quest_lang_05", questionId = "Q_LANG_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_05", questionId = "Q_LANG_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_05", questionId = "Q_LANG_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_05", questionId = "Q_LANG_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_05", questionId = "Q_LANG_025", orderIndex = 4),

        // quest_lang_06: Q_LANG_026..030
        QuestQuestionEntity(questId = "quest_lang_06", questionId = "Q_LANG_026", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_lang_06", questionId = "Q_LANG_027", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_lang_06", questionId = "Q_LANG_028", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_lang_06", questionId = "Q_LANG_029", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_lang_06", questionId = "Q_LANG_030", orderIndex = 4)
    )

    val STARTER_QUESTS: List<QuestEntity> =
        STARTER_QUESTS_SD + QuestStarterData_SMP.SMP_QUESTS + QuestStarterData_SMA.SMA_QUESTS

    val STARTER_QUEST_QUESTIONS: List<QuestQuestionEntity> =
        STARTER_QUEST_QUESTIONS_SD + QuestStarterData_SMP.SMP_QUEST_QUESTIONS + QuestStarterData_SMA.SMA_QUEST_QUESTIONS
}
