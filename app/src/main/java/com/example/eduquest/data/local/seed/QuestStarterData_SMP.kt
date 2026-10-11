package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestQuestionEntity

object QuestStarterData_SMP {

    val SMP_QUESTS = listOf(
        // ==========================================
        // === MATEMATIKA SMP (5 QUEST: 25 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_smp_math_01",
            worldId = "WORLD_SMP_01",
            title = "Bilangan Bulat & Pecahan Rasional",
            description = "Kuasai operasi bilangan bulat, pecahan campuran, FPB, KPK, dan aplikasinya.",
            subjectId = "SMP_MATH",
            grade = 7,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 160,
            coinReward = 20,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_math_02",
            worldId = "WORLD_SMP_01",
            title = "Aljabar & Persamaan Linear",
            description = "Pecahkan bentuk aljabar, persamaan linear satu variabel, dan pertidaksamaan.",
            subjectId = "SMP_MATH",
            grade = 7,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_math_03",
            worldId = "WORLD_SMP_01",
            title = "Teorema Pythagoras & Segitiga",
            description = "Eksplorasi tripel Pythagoras, diagonal bidang, dan penerapan sudut segitiga siku-siku.",
            subjectId = "SMP_MATH",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_math_04",
            worldId = "WORLD_SMP_01",
            title = "Statistika Dasar & Olah Data",
            description = "Hitung mean (rata-rata), median, modus, jangkauan, dan interpretasi diagram lingkaran.",
            subjectId = "SMP_MATH",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 210,
            coinReward = 30,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_math_05",
            worldId = "WORLD_SMP_01",
            title = "Peluang & Probabilitas",
            description = "Tentukan titik sampel, ruang sampel, peluang teoritis, frekuensi harapan, dan komplemen.",
            subjectId = "SMP_MATH",
            grade = 9,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3,
            educationLevel = "SMP"
        ),

        // ==========================================
        // === IPA TERPADU SMP (5 QUEST: 25 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_smp_ipa_01",
            worldId = "WORLD_SMP_01",
            title = "Sel & Organisasi Kehidupan",
            description = "Pelajari organel sel, perbedaan sel hewan dan tumbuhan, serta tingkatan organisasi hayati.",
            subjectId = "SMP_IPA",
            grade = 7,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 160,
            coinReward = 20,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ipa_02",
            worldId = "WORLD_SMP_01",
            title = "Kalor, Suhu & Pemuaian",
            description = "Konversi skala termometer, asas Black, perpindahan kalor, dan pemuaian zat.",
            subjectId = "SMP_IPA",
            grade = 7,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ipa_03",
            worldId = "WORLD_SMP_01",
            title = "Gerak Lurus & Hukum Newton",
            description = "Pahami GLB, GLBB, kelembaman, gaya aksi-reaksi, dan penerapan Hukum I, II, III Newton.",
            subjectId = "SMP_IPA",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ipa_04",
            worldId = "WORLD_SMP_01",
            title = "Sistem Pencernaan & Nutrisi",
            description = "Kenali enzim pencernaan, uji zat makanan, organ pencernaan mekanik dan kimiawi.",
            subjectId = "SMP_IPA",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 210,
            coinReward = 30,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ipa_05",
            worldId = "WORLD_SMP_01",
            title = "Listrik Dinamis & Kemagnetan",
            description = "Hukum Ohm, hambatan rangkaian seri-paralel, energi daya listrik, dan medan magnet.",
            subjectId = "SMP_IPA",
            grade = 9,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3,
            educationLevel = "SMP"
        ),

        // ==========================================
        // === IPS TERPADU SMP (5 QUEST: 25 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_smp_ips_01",
            worldId = "WORLD_SMP_01",
            title = "Peta & Geografis Nusantara",
            description = "Pelajari skala peta, letak astronomis dan geografis Indonesia, serta pengaruh iklim muson.",
            subjectId = "SMP_IPS",
            grade = 7,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 160,
            coinReward = 20,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ips_02",
            worldId = "WORLD_SMP_01",
            title = "Kerajaan Maritim Nusantara",
            description = "Telusuri jejak kejayaan Sriwijaya, Majapahit, Samudera Pasai, dan jalur rempah nusantara.",
            subjectId = "SMP_IPS",
            grade = 7,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ips_03",
            worldId = "WORLD_SMP_01",
            title = "Interaksi Sosial & Pranata",
            description = "Pahami kontak sosial, akomodasi, asimilasi, dan peran vital lembaga keluarga serta sosial.",
            subjectId = "SMP_IPS",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ips_04",
            worldId = "WORLD_SMP_01",
            title = "Kegiatan Ekonomi & Perdagangan",
            description = "Faktor produksi, hukum permintaan-penawaran, pelaku ekonomi, dan perdagangan antardaerah.",
            subjectId = "SMP_IPS",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 210,
            coinReward = 30,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_ips_05",
            worldId = "WORLD_SMP_01",
            title = "ASEAN & Globalisasi Modern",
            description = "Sejarah deklarasi Bangkok, pilar MEA, ZOPFAN, serta dampak positif dan negatif globalisasi.",
            subjectId = "SMP_IPS",
            grade = 9,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3,
            educationLevel = "SMP"
        ),

        // ==========================================
        // === BAHASA SMP (5 QUEST: 25 SOAL) ===
        // ==========================================
        QuestEntity(
            id = "quest_smp_lang_01",
            worldId = "WORLD_SMP_01",
            title = "Teks LHO & Prosedur",
            description = "Struktur teks laporan hasil observasi, kalimat definisi, konjungsi syarat, dan langkah prosedur.",
            subjectId = "SMP_LANG",
            grade = 7,
            difficulty = "EASY",
            questionCount = 5,
            xpReward = 160,
            coinReward = 20,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_lang_02",
            worldId = "WORLD_SMP_01",
            title = "Puisi Rakyat & Cerita Fabel",
            description = "Karakteristik gurindam, syair nusantara, serta struktur orientasi dan koda dalam fabel.",
            subjectId = "SMP_LANG",
            grade = 7,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_lang_03",
            worldId = "WORLD_SMP_01",
            title = "English Basics: Daily & Time",
            description = "Penggunaan Simple Present Tense, to be, subject pronouns, dan ungkapan telling time.",
            subjectId = "SMP_LANG",
            grade = 7,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 180,
            coinReward = 25,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_lang_04",
            worldId = "WORLD_SMP_01",
            title = "Teks Eksplanasi & Tata Baku",
            description = "Konjungsi kausalitas sebab-akibat, kalimat efektif, verba pasif, dan kata baku KBBI.",
            subjectId = "SMP_LANG",
            grade = 8,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 210,
            coinReward = 30,
            unlockLevel = 2,
            educationLevel = "SMP"
        ),
        QuestEntity(
            id = "quest_smp_lang_05",
            worldId = "WORLD_SMP_01",
            title = "English Reading: Recount & Desc",
            description = "Teks recount liburan masa lalu (Past Tense), descriptive text, dan comparative adjective.",
            subjectId = "SMP_LANG",
            grade = 8,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 3,
            educationLevel = "SMP"
        )
    )

    val SMP_QUEST_QUESTIONS = listOf(
        // === SMP_MATH ===
        QuestQuestionEntity(questId = "quest_smp_math_01", questionId = "Q_SMP_M_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_math_01", questionId = "Q_SMP_M_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_math_01", questionId = "Q_SMP_M_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_math_01", questionId = "Q_SMP_M_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_math_01", questionId = "Q_SMP_M_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_math_02", questionId = "Q_SMP_M_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_math_02", questionId = "Q_SMP_M_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_math_02", questionId = "Q_SMP_M_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_math_02", questionId = "Q_SMP_M_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_math_02", questionId = "Q_SMP_M_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_math_03", questionId = "Q_SMP_M_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_math_03", questionId = "Q_SMP_M_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_math_03", questionId = "Q_SMP_M_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_math_03", questionId = "Q_SMP_M_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_math_03", questionId = "Q_SMP_M_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_math_04", questionId = "Q_SMP_M_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_math_04", questionId = "Q_SMP_M_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_math_04", questionId = "Q_SMP_M_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_math_04", questionId = "Q_SMP_M_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_math_04", questionId = "Q_SMP_M_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_math_05", questionId = "Q_SMP_M_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_math_05", questionId = "Q_SMP_M_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_math_05", questionId = "Q_SMP_M_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_math_05", questionId = "Q_SMP_M_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_math_05", questionId = "Q_SMP_M_025", orderIndex = 4),

        // === SMP_IPA ===
        QuestQuestionEntity(questId = "quest_smp_ipa_01", questionId = "Q_SMP_IPA_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ipa_01", questionId = "Q_SMP_IPA_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ipa_01", questionId = "Q_SMP_IPA_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ipa_01", questionId = "Q_SMP_IPA_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ipa_01", questionId = "Q_SMP_IPA_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ipa_02", questionId = "Q_SMP_IPA_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ipa_02", questionId = "Q_SMP_IPA_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ipa_02", questionId = "Q_SMP_IPA_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ipa_02", questionId = "Q_SMP_IPA_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ipa_02", questionId = "Q_SMP_IPA_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ipa_03", questionId = "Q_SMP_IPA_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ipa_03", questionId = "Q_SMP_IPA_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ipa_03", questionId = "Q_SMP_IPA_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ipa_03", questionId = "Q_SMP_IPA_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ipa_03", questionId = "Q_SMP_IPA_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ipa_04", questionId = "Q_SMP_IPA_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ipa_04", questionId = "Q_SMP_IPA_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ipa_04", questionId = "Q_SMP_IPA_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ipa_04", questionId = "Q_SMP_IPA_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ipa_04", questionId = "Q_SMP_IPA_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ipa_05", questionId = "Q_SMP_IPA_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ipa_05", questionId = "Q_SMP_IPA_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ipa_05", questionId = "Q_SMP_IPA_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ipa_05", questionId = "Q_SMP_IPA_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ipa_05", questionId = "Q_SMP_IPA_025", orderIndex = 4),

        // === SMP_IPS ===
        QuestQuestionEntity(questId = "quest_smp_ips_01", questionId = "Q_SMP_IPS_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ips_01", questionId = "Q_SMP_IPS_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ips_01", questionId = "Q_SMP_IPS_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ips_01", questionId = "Q_SMP_IPS_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ips_01", questionId = "Q_SMP_IPS_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ips_02", questionId = "Q_SMP_IPS_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ips_02", questionId = "Q_SMP_IPS_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ips_02", questionId = "Q_SMP_IPS_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ips_02", questionId = "Q_SMP_IPS_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ips_02", questionId = "Q_SMP_IPS_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ips_03", questionId = "Q_SMP_IPS_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ips_03", questionId = "Q_SMP_IPS_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ips_03", questionId = "Q_SMP_IPS_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ips_03", questionId = "Q_SMP_IPS_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ips_03", questionId = "Q_SMP_IPS_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ips_04", questionId = "Q_SMP_IPS_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ips_04", questionId = "Q_SMP_IPS_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ips_04", questionId = "Q_SMP_IPS_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ips_04", questionId = "Q_SMP_IPS_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ips_04", questionId = "Q_SMP_IPS_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_ips_05", questionId = "Q_SMP_IPS_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_ips_05", questionId = "Q_SMP_IPS_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_ips_05", questionId = "Q_SMP_IPS_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_ips_05", questionId = "Q_SMP_IPS_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_ips_05", questionId = "Q_SMP_IPS_025", orderIndex = 4),

        // === SMP_LANG ===
        QuestQuestionEntity(questId = "quest_smp_lang_01", questionId = "Q_SMP_LNG_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_lang_01", questionId = "Q_SMP_LNG_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_lang_01", questionId = "Q_SMP_LNG_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_lang_01", questionId = "Q_SMP_LNG_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_lang_01", questionId = "Q_SMP_LNG_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_lang_02", questionId = "Q_SMP_LNG_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_lang_02", questionId = "Q_SMP_LNG_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_lang_02", questionId = "Q_SMP_LNG_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_lang_02", questionId = "Q_SMP_LNG_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_lang_02", questionId = "Q_SMP_LNG_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_lang_03", questionId = "Q_SMP_LNG_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_lang_03", questionId = "Q_SMP_LNG_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_lang_03", questionId = "Q_SMP_LNG_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_lang_03", questionId = "Q_SMP_LNG_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_lang_03", questionId = "Q_SMP_LNG_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_lang_04", questionId = "Q_SMP_LNG_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_lang_04", questionId = "Q_SMP_LNG_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_lang_04", questionId = "Q_SMP_LNG_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_lang_04", questionId = "Q_SMP_LNG_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_lang_04", questionId = "Q_SMP_LNG_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_smp_lang_05", questionId = "Q_SMP_LNG_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_smp_lang_05", questionId = "Q_SMP_LNG_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_smp_lang_05", questionId = "Q_SMP_LNG_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_smp_lang_05", questionId = "Q_SMP_LNG_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_smp_lang_05", questionId = "Q_SMP_LNG_025", orderIndex = 4)
    )
}
