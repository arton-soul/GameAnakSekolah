package com.example.eduquest.core.ui

data class AvatarOption(
    val id: String,
    val name: String,
    val emoji: String,
    val description: String,
    val targetLevel: String = "ALL" // "SD", "TEEN", "ALL"
)

object AvatarHelper {
    val AVATARS = listOf(
        // === AVATAR SATWA CERIA (SD & SEMUA) ===
        AvatarOption("avatar_kancil", "Kancil", "🦊", "Cerdik & Cepat", "SD"),
        AvatarOption("avatar_singa", "Singa", "🦁", "Pemberani", "SD"),
        AvatarOption("avatar_burung", "Hantu", "🦉", "Bijaksana", "SD"),
        AvatarOption("avatar_lumba", "Lumba", "🐬", "Ceria & Cerdas", "SD"),
        AvatarOption("avatar_elang", "Elang", "🦅", "Fokus Tinggi", "SD"),
        AvatarOption("avatar_kucing", "Kucing", "🐱", "Ramah & Hangat", "SD"),

        // === AVATAR PELAJAR / REMAJA MODERN (SMP, SMA & SEMUA) ===
        AvatarOption("avatar_cendekia", "Cendekia", "🧑‍🎓", "Pelajar Teladan", "TEEN"),
        AvatarOption("avatar_inovator", "Inovator", "🧑‍💻", "Digital & Tekno", "TEEN"),
        AvatarOption("avatar_ilmuwan", "Ilmuwan", "🧑‍🔬", "Peneliti Muda", "TEEN"),
        AvatarOption("avatar_penjelajah", "Penjelajah", "🧭", "Petualang Tangguh", "TEEN"),
        AvatarOption("avatar_nalar", "Ahli Nalar", "🧠", "Pemikir Strategis", "TEEN"),
        AvatarOption("avatar_cyber", "Cyber Scout", "🚀", "Pionir Masa Depan", "TEEN"),
        AvatarOption("avatar_atlet", "Atlet", "⚡", "Bugar & Gesit", "TEEN"),
        AvatarOption("avatar_kreator", "Kreator Seni", "🎨", "Jiwa Kreatif", "TEEN")
    )

    fun getAvatar(id: String): AvatarOption {
        return AVATARS.find { it.id == id } ?: AVATARS.first()
    }

    fun getAvatarsForLevel(educationLevel: String): List<AvatarOption> {
        return when (educationLevel.uppercase()) {
            "SMP", "SMA" -> {
                // Tampilkan avatar remaja/pelajar di baris awal, disusul satwa
                AVATARS.filter { it.targetLevel == "TEEN" } + AVATARS.filter { it.targetLevel == "SD" }
            }
            else -> {
                // SD: Tampilkan avatar satwa cilik di baris awal
                AVATARS.filter { it.targetLevel == "SD" } + AVATARS.filter { it.targetLevel == "TEEN" }
            }
        }
    }
}