package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestEntity
import com.example.eduquest.data.local.entity.QuestQuestionEntity

object QuestStarterData_SMA {

    val SMA_QUESTS = listOf(
        // ========================================================
        // === MATEMATIKA TINGKAT LANJUT (5 QUEST: 25 SOAL) ===
        // ========================================================
        QuestEntity(
            id = "quest_sma_math_01",
            worldId = "WORLD_SMA_01",
            title = "Fungsi Eksponen & Logaritma",
            description = "Eksplorasi sifat eksponen, logaritma basis 10 dan natural, serta persamaan eksponensial.",
            subjectId = "SMA_MATH_ADV",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_math_02",
            worldId = "WORLD_SMA_01",
            title = "Trigonometri Analitik",
            description = "Sudut istimewa kuadran, sudut berelasi, identitas trigonometri, dan aturan sinus-cosinus.",
            subjectId = "SMA_MATH_ADV",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_math_03",
            worldId = "WORLD_SMA_01",
            title = "Aljabar Matriks & SPLDV/SPLTV",
            description = "Operasi matriks, determinan ordo 2x2 dan 3x3, invers matriks, dan transpose.",
            subjectId = "SMA_MATH_ADV",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_math_04",
            worldId = "WORLD_SMA_01",
            title = "Diferensial / Turunan Aljabar",
            description = "Aturan turunan, gradien garis singgung kurva, nilai stasioner, dan aturan rantai.",
            subjectId = "SMA_MATH_ADV",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 280,
            coinReward = 40,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_math_05",
            worldId = "WORLD_SMA_01",
            title = "Integral Kalkulus & Terapan",
            description = "Integral tak tentu, integral tentu, metode substitusi, dan kalkulasi luas daerah di bawah kurva.",
            subjectId = "SMA_MATH_ADV",
            grade = 12,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 300,
            coinReward = 50,
            unlockLevel = 3,
            educationLevel = "SMA"
        ),

        // ========================================================
        // === SAINS MIPA: FISIKA, KIMIA, BIOLOGI (5 QUEST: 25 SOAL) ===
        // ========================================================
        QuestEntity(
            id = "quest_sma_mipa_01",
            worldId = "WORLD_SMA_01",
            title = "Fisika: Vektor & Kinematika",
            description = "Vektor resultan, analisis gerak parabola, ketinggian maksimum, gravitasi Newton, dan energi mekanik.",
            subjectId = "SMA_MIPA",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_mipa_02",
            worldId = "WORLD_SMA_01",
            title = "Kimia: Atom & Ikatan Kimia",
            description = "Partikel subatom, konfigurasi elektron, sistem periodik unsur, ikatan ion, dan ikatan kovalen.",
            subjectId = "SMA_MIPA",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_mipa_03",
            worldId = "WORLD_SMA_01",
            title = "Biologi: Sel & Metabolisme",
            description = "Transpor membran pasif-aktif, enzim katalase, reaksi fotosintesis, dan respirasi seluler ATP.",
            subjectId = "SMA_MIPA",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_mipa_04",
            worldId = "WORLD_SMA_01",
            title = "Fisika: Termo & Gelombang",
            description = "Hukum Termodinamika, mesin Carnot, gelombang bunyi, efek Doppler, dan taraf intensitas desibel.",
            subjectId = "SMA_MIPA",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 280,
            coinReward = 40,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_mipa_05",
            worldId = "WORLD_SMA_01",
            title = "Biologi: Genetika DNA & Mendel",
            description = "Struktur DNA/RNA, sintesis protein transkripsi-translasi, persilangan monohibrid/dihibrid, dan mutasi.",
            subjectId = "SMA_MIPA",
            grade = 12,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 300,
            coinReward = 50,
            unlockLevel = 3,
            educationLevel = "SMA"
        ),

        // ========================================================
        // === SOSIAL HUMANIORA: EKONOMI & SOSIOLOGI (5 QUEST: 25 SOAL) ===
        // ========================================================
        QuestEntity(
            id = "quest_sma_sos_01",
            worldId = "WORLD_SMA_01",
            title = "Ekonomi: Mekanisme Pasar",
            description = "Konsep kelangkaan, biaya peluang, kurva permintaan-penawaran, elastisitas harga, dan titik ekuilibrium.",
            subjectId = "SMA_SOSHUM",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_sos_02",
            worldId = "WORLD_SMA_01",
            title = "Sosiologi: Mobilitas & Norma",
            description = "Struktur sosial, mobilitas vertikal-horizontal, nilai norma, sosialisasi, dan diferensiasi budaya.",
            subjectId = "SMA_SOSHUM",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_sos_03",
            worldId = "WORLD_SMA_01",
            title = "Ekonomi: Pendapatan & Kebijakan",
            description = "PDB / GDP, pendapatan per kapita, kebijakan moneter Bank Sentral, instrumen fiskal, dan Indeks Gini.",
            subjectId = "SMA_SOSHUM",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_sos_04",
            worldId = "WORLD_SMA_01",
            title = "Sosiologi: Resolusi Konflik",
            description = "Diferensiasi sosial klan, integrasi nasional, resolusi konflik mediasi-arbitrase, dan kearifan lokal.",
            subjectId = "SMA_SOSHUM",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 280,
            coinReward = 40,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_sos_05",
            worldId = "WORLD_SMA_01",
            title = "Akuntansi & Perdagangan Global",
            description = "Persamaan dasar akuntansi, jurnal umum debit-kredit, keunggulan komparatif Ricardian, neraca pembayaran, dan pasar modal.",
            subjectId = "SMA_SOSHUM",
            grade = 12,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 300,
            coinReward = 50,
            unlockLevel = 3,
            educationLevel = "SMA"
        ),

        // ========================================================
        // === PENGETAHUAN UMUM & LITERASI GLOBAL (5 QUEST: 25 SOAL) ===
        // ========================================================
        QuestEntity(
            id = "quest_sma_gen_01",
            worldId = "WORLD_SMA_01",
            title = "Wawasan Kebangsaan & Diplomasi",
            description = "Politik Bebas Aktif Mohammad Hatta, KAA Bandung 1955, Deklarasi Djuanda 1957, MK, dan Kebangkitan Nasional.",
            subjectId = "SMA_GENERAL",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 200,
            coinReward = 25,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_gen_02",
            worldId = "WORLD_SMA_01",
            title = "Sains Populer & Teknologi Modern",
            description = "Artificial Intelligence (Machine Learning), komputasi kuantum qubit, energi surya terbarukan, CRISPR-Cas9, dan IoT.",
            subjectId = "SMA_GENERAL",
            grade = 10,
            difficulty = "NORMAL",
            questionCount = 5,
            xpReward = 220,
            coinReward = 30,
            unlockLevel = 1,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_gen_03",
            worldId = "WORLD_SMA_01",
            title = "English Advanced: Text & Logic",
            description = "Analytical Exposition text, Conditional Sentence type 2/3, Advanced Passive Voice, cause-effect, dan inference.",
            subjectId = "SMA_GENERAL",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 250,
            coinReward = 35,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_gen_04",
            worldId = "WORLD_SMA_01",
            title = "Geopolitik Dunia & SDGs Global",
            description = "Hak veto 5 Dewan Keamanan PBB, Perjanjian Iklim Paris COP21, forum ekonomi G20, transisi demografi, dan SDGs 2030.",
            subjectId = "SMA_GENERAL",
            grade = 11,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 280,
            coinReward = 40,
            unlockLevel = 2,
            educationLevel = "SMA"
        ),
        QuestEntity(
            id = "quest_sma_gen_05",
            worldId = "WORLD_SMA_01",
            title = "Nalar Kritis & Metode Ilmiah",
            description = "Kekeliruan berpikir (logical fallacies), silogisme deduktif, pengujian hipotesis ilmiah, verifikasi hoaks, dan pisau Ockham.",
            subjectId = "SMA_GENERAL",
            grade = 12,
            difficulty = "HARD",
            questionCount = 5,
            xpReward = 300,
            coinReward = 50,
            unlockLevel = 3,
            educationLevel = "SMA"
        )
    )

    val SMA_QUEST_QUESTIONS = listOf(
        // === SMA_MATH_ADV ===
        QuestQuestionEntity(questId = "quest_sma_math_01", questionId = "Q_SMA_M_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_math_01", questionId = "Q_SMA_M_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_math_01", questionId = "Q_SMA_M_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_math_01", questionId = "Q_SMA_M_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_math_01", questionId = "Q_SMA_M_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_math_02", questionId = "Q_SMA_M_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_math_02", questionId = "Q_SMA_M_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_math_02", questionId = "Q_SMA_M_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_math_02", questionId = "Q_SMA_M_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_math_02", questionId = "Q_SMA_M_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_math_03", questionId = "Q_SMA_M_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_math_03", questionId = "Q_SMA_M_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_math_03", questionId = "Q_SMA_M_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_math_03", questionId = "Q_SMA_M_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_math_03", questionId = "Q_SMA_M_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_math_04", questionId = "Q_SMA_M_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_math_04", questionId = "Q_SMA_M_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_math_04", questionId = "Q_SMA_M_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_math_04", questionId = "Q_SMA_M_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_math_04", questionId = "Q_SMA_M_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_math_05", questionId = "Q_SMA_M_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_math_05", questionId = "Q_SMA_M_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_math_05", questionId = "Q_SMA_M_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_math_05", questionId = "Q_SMA_M_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_math_05", questionId = "Q_SMA_M_025", orderIndex = 4),

        // === SMA_MIPA ===
        QuestQuestionEntity(questId = "quest_sma_mipa_01", questionId = "Q_SMA_MIPA_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_mipa_01", questionId = "Q_SMA_MIPA_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_mipa_01", questionId = "Q_SMA_MIPA_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_mipa_01", questionId = "Q_SMA_MIPA_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_mipa_01", questionId = "Q_SMA_MIPA_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_mipa_02", questionId = "Q_SMA_MIPA_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_mipa_02", questionId = "Q_SMA_MIPA_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_mipa_02", questionId = "Q_SMA_MIPA_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_mipa_02", questionId = "Q_SMA_MIPA_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_mipa_02", questionId = "Q_SMA_MIPA_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_mipa_03", questionId = "Q_SMA_MIPA_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_mipa_03", questionId = "Q_SMA_MIPA_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_mipa_03", questionId = "Q_SMA_MIPA_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_mipa_03", questionId = "Q_SMA_MIPA_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_mipa_03", questionId = "Q_SMA_MIPA_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_mipa_04", questionId = "Q_SMA_MIPA_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_mipa_04", questionId = "Q_SMA_MIPA_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_mipa_04", questionId = "Q_SMA_MIPA_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_mipa_04", questionId = "Q_SMA_MIPA_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_mipa_04", questionId = "Q_SMA_MIPA_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_mipa_05", questionId = "Q_SMA_MIPA_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_mipa_05", questionId = "Q_SMA_MIPA_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_mipa_05", questionId = "Q_SMA_MIPA_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_mipa_05", questionId = "Q_SMA_MIPA_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_mipa_05", questionId = "Q_SMA_MIPA_025", orderIndex = 4),

        // === SMA_SOSHUM ===
        QuestQuestionEntity(questId = "quest_sma_sos_01", questionId = "Q_SMA_SOS_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_sos_01", questionId = "Q_SMA_SOS_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_sos_01", questionId = "Q_SMA_SOS_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_sos_01", questionId = "Q_SMA_SOS_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_sos_01", questionId = "Q_SMA_SOS_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_sos_02", questionId = "Q_SMA_SOS_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_sos_02", questionId = "Q_SMA_SOS_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_sos_02", questionId = "Q_SMA_SOS_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_sos_02", questionId = "Q_SMA_SOS_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_sos_02", questionId = "Q_SMA_SOS_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_sos_03", questionId = "Q_SMA_SOS_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_sos_03", questionId = "Q_SMA_SOS_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_sos_03", questionId = "Q_SMA_SOS_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_sos_03", questionId = "Q_SMA_SOS_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_sos_03", questionId = "Q_SMA_SOS_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_sos_04", questionId = "Q_SMA_SOS_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_sos_04", questionId = "Q_SMA_SOS_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_sos_04", questionId = "Q_SMA_SOS_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_sos_04", questionId = "Q_SMA_SOS_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_sos_04", questionId = "Q_SMA_SOS_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_sos_05", questionId = "Q_SMA_SOS_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_sos_05", questionId = "Q_SMA_SOS_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_sos_05", questionId = "Q_SMA_SOS_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_sos_05", questionId = "Q_SMA_SOS_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_sos_05", questionId = "Q_SMA_SOS_025", orderIndex = 4),

        // === SMA_GENERAL ===
        QuestQuestionEntity(questId = "quest_sma_gen_01", questionId = "Q_SMA_GEN_001", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_gen_01", questionId = "Q_SMA_GEN_002", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_gen_01", questionId = "Q_SMA_GEN_003", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_gen_01", questionId = "Q_SMA_GEN_004", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_gen_01", questionId = "Q_SMA_GEN_005", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_gen_02", questionId = "Q_SMA_GEN_006", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_gen_02", questionId = "Q_SMA_GEN_007", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_gen_02", questionId = "Q_SMA_GEN_008", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_gen_02", questionId = "Q_SMA_GEN_009", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_gen_02", questionId = "Q_SMA_GEN_010", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_gen_03", questionId = "Q_SMA_GEN_011", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_gen_03", questionId = "Q_SMA_GEN_012", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_gen_03", questionId = "Q_SMA_GEN_013", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_gen_03", questionId = "Q_SMA_GEN_014", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_gen_03", questionId = "Q_SMA_GEN_015", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_gen_04", questionId = "Q_SMA_GEN_016", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_gen_04", questionId = "Q_SMA_GEN_017", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_gen_04", questionId = "Q_SMA_GEN_018", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_gen_04", questionId = "Q_SMA_GEN_019", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_gen_04", questionId = "Q_SMA_GEN_020", orderIndex = 4),

        QuestQuestionEntity(questId = "quest_sma_gen_05", questionId = "Q_SMA_GEN_021", orderIndex = 0),
        QuestQuestionEntity(questId = "quest_sma_gen_05", questionId = "Q_SMA_GEN_022", orderIndex = 1),
        QuestQuestionEntity(questId = "quest_sma_gen_05", questionId = "Q_SMA_GEN_023", orderIndex = 2),
        QuestQuestionEntity(questId = "quest_sma_gen_05", questionId = "Q_SMA_GEN_024", orderIndex = 3),
        QuestQuestionEntity(questId = "quest_sma_gen_05", questionId = "Q_SMA_GEN_025", orderIndex = 4)
    )
}
