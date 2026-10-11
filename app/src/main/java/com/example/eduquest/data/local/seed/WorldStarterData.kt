package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.WorldEntity
import com.example.eduquest.domain.model.WorldArea

object WorldStarterData {
    val STARTER_WORLDS = listOf(
        WorldEntity(
            id = "WORLD_01",
            title = "Kota Pengetahuan Cilik",
            description = "Pusat petualangan ilmu para petualang cilik SD. Temukan lembah matematika ceria, laboratorium sains alam, dan perpustakaan kata!",
            unlockLevel = 1,
            orderIndex = 0,
            educationLevel = "SD"
        ),
        WorldEntity(
            id = "WORLD_SMP_01",
            title = "Benua Eksplorasi Cendekia",
            description = "Pusat eksplorasi sains terpadu, logika aljabar, wawasan sosial, dan komunikasi bagi petualang SMP.",
            unlockLevel = 1,
            orderIndex = 1,
            educationLevel = "SMP"
        ),
        WorldEntity(
            id = "WORLD_SMA_01",
            title = "Akademi Puncak Cendekiawan",
            description = "Kawah candradimuka ilmu pengetahuan tingkat lanjut: Sains MIPA, Matematika Lanjut, Soshum, dan Wawasan Global.",
            unlockLevel = 1,
            orderIndex = 2,
            educationLevel = "SMA"
        )
    )

    val STARTER_AREAS = listOf(
        // =====================================
        // === AREA BELAJAR SD (WORLD_01) ===
        // =====================================
        WorldArea(
            id = "area_math",
            worldId = "WORLD_01",
            subjectId = "MATH",
            name = "Math Valley",
            indonesianName = "Lembah Matematika",
            icon = "🔢",
            description = "Jelajahi lembah angka, penjumlahan ceria, perkalian, dan teka-teki bangun datar.",
            unlockLevel = 1,
            orderIndex = 1
        ),
        WorldArea(
            id = "area_science",
            worldId = "WORLD_01",
            subjectId = "SCIENCE",
            name = "Science Lab",
            indonesianName = "Laboratorium Sains",
            icon = "🔬",
            description = "Observasi keajaiban alam, panca indra, flora, fauna, wujud zat, dan tata surya.",
            unlockLevel = 1,
            orderIndex = 2
        ),
        WorldArea(
            id = "area_language",
            worldId = "WORLD_01",
            subjectId = "LANGUAGE",
            name = "Language Library",
            indonesianName = "Perpustakaan Bahasa",
            icon = "📖",
            description = "Buka wawasan kosakata baru, tanda baca, ejaan huruf kapital, dan pantun nusantara.",
            unlockLevel = 2,
            orderIndex = 3
        ),

        // =========================================
        // === AREA BELAJAR SMP (WORLD_SMP_01) ===
        // =========================================
        WorldArea(
            id = "area_smp_math",
            worldId = "WORLD_SMP_01",
            subjectId = "SMP_MATH",
            name = "Kubah Matematika & Aljabar",
            indonesianName = "Matematika SMP",
            icon = "📐",
            description = "Kuasai bilangan bulat, bentuk aljabar, teorema Pythagoras, statistik, dan peluang.",
            unlockLevel = 1,
            orderIndex = 1
        ),
        WorldArea(
            id = "area_smp_science",
            worldId = "WORLD_SMP_01",
            subjectId = "SMP_IPA",
            name = "Laboratorium IPA Terpadu",
            indonesianName = "IPA Terpadu (Fisika & Biologi)",
            icon = "⚡",
            description = "Eksplorasi gerak lurus, gaya Newton, kalor, sel, fotosintesis, dan sistem organ manusia.",
            unlockLevel = 1,
            orderIndex = 2
        ),
        WorldArea(
            id = "area_smp_social",
            worldId = "WORLD_SMP_01",
            subjectId = "SMP_IPS",
            name = "Balairung IPS Terpadu",
            indonesianName = "IPS Terpadu (Geografi & Sejarah)",
            icon = "🏛️",
            description = "Pahami letak geografis nusantara, kerajaan maritim, kegiatan ekonomi, dan dinamika sosial.",
            unlockLevel = 1,
            orderIndex = 3
        ),
        WorldArea(
            id = "area_smp_language",
            worldId = "WORLD_SMP_01",
            subjectId = "SMP_LANG",
            name = "Balai Bahasa & Komunikasi",
            indonesianName = "Bahasa Indonesia & Inggris",
            icon = "🌐",
            description = "Teks laporan observasi, prosedur, fabel, dan keterampilan bahasa Inggris komunikatif.",
            unlockLevel = 1,
            orderIndex = 4
        ),

        // =========================================
        // === AREA BELAJAR SMA (WORLD_SMA_01) ===
        // =========================================
        WorldArea(
            id = "area_sma_math_adv",
            worldId = "WORLD_SMA_01",
            subjectId = "SMA_MATH_ADV",
            name = "Institut Matematika Lanjut",
            indonesianName = "Matematika Tingkat Lanjut",
            icon = "📊",
            description = "Eksplorasi fungsi analitik, trigonometri, matriks, vektor, dan kalkulus diferensial-integral.",
            unlockLevel = 1,
            orderIndex = 1
        ),
        WorldArea(
            id = "area_sma_mipa",
            worldId = "WORLD_SMA_01",
            subjectId = "SMA_MIPA",
            name = "Observatorium Sains MIPA",
            indonesianName = "Sains MIPA (Fisika, Kimia, Biologi)",
            icon = "🔭",
            description = "Dinamika rotasi, termodinamika, ikatan kimia stoikiometri, serta genetika DNA/RNA dan metabolisme.",
            unlockLevel = 1,
            orderIndex = 2
        ),
        WorldArea(
            id = "area_sma_soshum",
            worldId = "WORLD_SMA_01",
            subjectId = "SMA_SOSHUM",
            name = "Fakultas Sosial Humaniora",
            indonesianName = "Ekonomi & Sosiologi (Soshum)",
            icon = "📈",
            description = "Mekanisme pasar, akuntansi, inflasi, stratifikasi sosial, dan konflik integrasi masyarakat.",
            unlockLevel = 1,
            orderIndex = 3
        ),
        WorldArea(
            id = "area_sma_general",
            worldId = "WORLD_SMA_01",
            subjectId = "SMA_GENERAL",
            name = "Balai Wawasan Global",
            indonesianName = "Pengetahuan Umum & Bahasa Lanjut",
            icon = "💡",
            description = "Wawasan kebangsaan, geopolitik dunia, sains teknologi modern, dan analisis teks bahasa Inggris.",
            unlockLevel = 1,
            orderIndex = 4
        )
    )
}
