package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestionEntity

object QuestionStarterData_SMP {
    val SMP_QUESTIONS = listOf(
        // ==========================================
        // === MATEMATIKA SMP (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Bilangan Bulat & Pecahan Rasional (Kelas 7, EASY) ---
        QuestionEntity(
            id = "Q_SMP_M_001", grade = 7, subjectId = "SMP_MATH", topicId = "Bilangan Bulat",
            difficulty = "EASY", question = "Hasil perhitungan dari -15 + (-8) - (-12) adalah...",
            optionA = "-11", optionB = "-19", optionC = "-35", optionD = "9",
            answer = "A", explanation = "-15 + (-8) = -23. Lalu -23 - (-12) = -23 + 12 = -11.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_002", grade = 7, subjectId = "SMP_MATH", topicId = "Pecahan",
            difficulty = "EASY", question = "Bentuk paling sederhana dari pecahan 36/84 adalah...",
            optionA = "4/9", optionB = "3/7", optionC = "6/14", optionD = "9/21",
            answer = "B", explanation = "FPB dari 36 dan 84 adalah 12. 36:12 = 3 dan 84:12 = 7, sehingga menjadi 3/7.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_003", grade = 7, subjectId = "SMP_MATH", topicId = "Suhu & Operasi",
            difficulty = "EASY", question = "Suhu di dalam freezer kulkas -6°C. Saat listrik padam, suhu naik 2°C setiap 15 menit. Suhu setelah 45 menit adalah...",
            optionA = "-2°C", optionB = "0°C", optionC = "2°C", optionD = "-4°C",
            answer = "B", explanation = "Dalam 45 menit terjadi 3 kali kenaikan (45/15 = 3). Kenaikan = 3 x 2°C = 6°C. Suhu akhir = -6°C + 6°C = 0°C.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_004", grade = 7, subjectId = "SMP_MATH", topicId = "Pecahan Campuran",
            difficulty = "EASY", question = "Hasil dari 2 1/4 : 3/4 adalah...",
            optionA = "2", optionB = "3", optionC = "4", optionD = "1 1/2",
            answer = "B", explanation = "2 1/4 = 9/4. Pembagian pecahan: 9/4 x 4/3 = 36/12 = 3.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_005", grade = 7, subjectId = "SMP_MATH", topicId = "FPB & KPK",
            difficulty = "EASY", question = "KPK dari bilangan 12 dan 18 adalah...",
            optionA = "72", optionB = "48", optionC = "36", optionD = "24",
            answer = "C", explanation = "Faktorisasi: 12 = 2^2 x 3, 18 = 2 x 3^2. KPK = 2^2 x 3^2 = 4 x 9 = 36.",
            xp = 110, educationLevel = "SMP"
        ),

        // --- Quest 2: Aljabar & Persamaan Linear (Kelas 7, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_M_006", grade = 7, subjectId = "SMP_MATH", topicId = "Bentuk Aljabar",
            difficulty = "NORMAL", question = "Bentuk sederhana dari 3(2x - 4) + 5x adalah...",
            optionA = "6x - 12", optionB = "11x - 4", optionC = "11x + 12", optionD = "11x - 12",
            answer = "D", explanation = "3(2x - 4) = 6x - 12. Lalu 6x - 12 + 5x = (6x + 5x) - 12 = 11x - 12.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_007", grade = 7, subjectId = "SMP_MATH", topicId = "PLSV",
            difficulty = "NORMAL", question = "Penyelesaian dari persamaan 4x - 7 = 2x + 9 adalah...",
            optionA = "x = 8", optionB = "x = 4", optionC = "x = 6", optionD = "x = 7",
            answer = "A", explanation = "4x - 2x = 9 + 7 -> 2x = 16 -> x = 8.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_008", grade = 7, subjectId = "SMP_MATH", topicId = "Aljabar Nilai",
            difficulty = "NORMAL", question = "Jika nilai p = 3 dan q = -2, maka nilai dari 2p^2 - 3q adalah...",
            optionA = "12", optionB = "24", optionC = "18", optionD = "30",
            answer = "B", explanation = "2(3)^2 - 3(-2) = 2(9) + 6 = 18 + 6 = 24.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_009", grade = 7, subjectId = "SMP_MATH", topicId = "Pertidaksamaan",
            difficulty = "NORMAL", question = "Penyelesaian dari pertidaksamaan 3x + 2 < 14 untuk x bilangan bulat positif adalah...",
            optionA = "{0, 1, 2, 3}", optionB = "{1, 2, 3, 4}", optionC = "{1, 2, 3}", optionD = "{2, 3, 4}",
            answer = "C", explanation = "3x < 12 -> x < 4. Bilangan bulat positif yang kurang dari 4 adalah {1, 2, 3}.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_010", grade = 7, subjectId = "SMP_MATH", topicId = "Soal Cerita Aljabar",
            difficulty = "NORMAL", question = "Umur Ayah 3 kali umur Budi. Selisih umur mereka 30 tahun. Berapakah umur Budi?",
            optionA = "12 tahun", optionB = "10 tahun", optionC = "20 tahun", optionD = "15 tahun",
            answer = "D", explanation = "Misal umur Budi = x, Ayah = 3x. Selisih: 3x - x = 30 -> 2x = 30 -> x = 15 tahun.",
            xp = 120, educationLevel = "SMP"
        ),

        // --- Quest 3: Teorema Pythagoras (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_M_011", grade = 8, subjectId = "SMP_MATH", topicId = "Pythagoras",
            difficulty = "NORMAL", question = "Sebuah segitiga siku-siku memiliki sisi siku-siku 6 cm dan 8 cm. Panjang sisi miringnya (hipotenusa) adalah...",
            optionA = "10 cm", optionB = "12 cm", optionC = "14 cm", optionD = "9 cm",
            answer = "A", explanation = "c = \u221A(a^2 + b^2) = \u221A(6^2 + 8^2) = \u221A(36 + 64) = \u221A100 = 10 cm.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_012", grade = 8, subjectId = "SMP_MATH", topicId = "Tripel Pythagoras",
            difficulty = "NORMAL", question = "Kelompok bilangan berikut yang merupakan tripel Pythagoras adalah...",
            optionA = "4, 6, 8", optionB = "5, 12, 13", optionC = "7, 9, 12", optionD = "8, 14, 17",
            answer = "B", explanation = "5^2 + 12^2 = 25 + 144 = 169 = 13^2. Terbukti tripel Pythagoras.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_013", grade = 8, subjectId = "SMP_MATH", topicId = "Tangga Pythagoras",
            difficulty = "NORMAL", question = "Tangga sepanjang 5 meter disandarkan pada dinding. Jarak ujung bawah tangga ke dinding 3 meter. Tinggi dinding yang dicapai tangga adalah...",
            optionA = "4.2 meter", optionB = "3.5 meter", optionC = "4 meter", optionD = "4.5 meter",
            answer = "C", explanation = "Tinggi dinding = \u221A(5^2 - 3^2) = \u221A(25 - 9) = \u221A16 = 4 meter.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_014", grade = 8, subjectId = "SMP_MATH", topicId = "Jenis Segitiga",
            difficulty = "NORMAL", question = "Segitiga dengan panjang sisi 7 cm, 10 cm, dan 13 cm termasuk jenis segitiga...",
            optionA = "Sama sisi", optionB = "Lancip", optionC = "Siku-siku", optionD = "Tumpul",
            answer = "D", explanation = "7^2 + 10^2 = 49 + 100 = 149. Sisi terpanjang kuadrat: 13^2 = 169. Karena 169 > 149 (c^2 > a^2 + b^2), maka segitiga tumpul.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_015", grade = 8, subjectId = "SMP_MATH", topicId = "Keliling Persegi Panjang",
            difficulty = "NORMAL", question = "Diagonal persegi panjang 15 cm dan lebarnya 9 cm. Keliling persegi panjang tersebut adalah...",
            optionA = "42 cm", optionB = "36 cm", optionC = "48 cm", optionD = "54 cm",
            answer = "A", explanation = "Panjang = \u221A(15^2 - 9^2) = \u221A(225 - 81) = \u221A144 = 12 cm. Keliling = 2 x (12 + 9) = 2 x 21 = 42 cm.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 4: Statistika Dasar & Olah Data (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_M_016", grade = 8, subjectId = "SMP_MATH", topicId = "Rata-rata",
            difficulty = "NORMAL", question = "Nilai ulangan Matematika 6 siswa: 7, 8, 6, 9, 8, 10. Nilai rata-rata (mean) mereka adalah...",
            optionA = "7.8", optionB = "8.0", optionC = "8.2", optionD = "7.5",
            answer = "B", explanation = "Jumlah nilai = 7+8+6+9+8+10 = 48. Rata-rata = 48 / 6 = 8.0.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_017", grade = 8, subjectId = "SMP_MATH", topicId = "Median",
            difficulty = "NORMAL", question = "Diberikan data: 5, 8, 6, 9, 7, 8, 10. Nilai median (nilai tengah) dari data tersebut adalah...",
            optionA = "7.5", optionB = "7", optionC = "8", optionD = "8.5",
            answer = "C", explanation = "Urutkan data: 5, 6, 7, 8, 8, 9, 10. Data ke-4 (tengah) adalah 8.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_018", grade = 8, subjectId = "SMP_MATH", topicId = "Modus",
            difficulty = "NORMAL", question = "Modus dari data: 4, 6, 5, 7, 6, 8, 6, 9, 5 adalah...",
            optionA = "8", optionB = "5", optionC = "7", optionD = "6",
            answer = "D", explanation = "Angka 6 muncul paling banyak, yaitu sebanyak 3 kali.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_019", grade = 8, subjectId = "SMP_MATH", topicId = "Jangkauan",
            difficulty = "NORMAL", question = "Jangkauan (range) dari data 15, 23, 18, 32, 29, 14, 27 adalah...",
            optionA = "18", optionB = "17", optionC = "16", optionD = "19",
            answer = "A", explanation = "Nilai maksimum = 32, minimum = 14. Jangkauan = 32 - 14 = 18.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_020", grade = 8, subjectId = "SMP_MATH", topicId = "Diagram Lingkaran",
            difficulty = "NORMAL", question = "Dari 60 siswa, 25% gemar olahraga. Banyak siswa yang gemar olahraga adalah...",
            optionA = "12 anak", optionB = "15 anak", optionC = "18 anak", optionD = "20 anak",
            answer = "B", explanation = "25% dari 60 = 25/100 x 60 = 1/4 x 60 = 15 siswa.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 5: Peluang & Probabilitas (Kelas 9, HARD) ---
        QuestionEntity(
            id = "Q_SMP_M_021", grade = 9, subjectId = "SMP_MATH", topicId = "Peluang Dadu",
            difficulty = "HARD", question = "Peluang munculnya mata dadu prima ganjil pada pelemparan satu buah dadu adalah...",
            optionA = "1/6", optionB = "1/2", optionC = "1/3", optionD = "2/3",
            answer = "C", explanation = "Mata dadu = {1,2,3,4,5,6}. Prima ganjil = {3, 5} ada 2 angka. Peluang = 2/6 = 1/3.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_022", grade = 9, subjectId = "SMP_MATH", topicId = "Peluang Koin",
            difficulty = "HARD", question = "Dua buah koin dilempar bersamaan. Peluang muncul minimal satu sisi angka adalah...",
            optionA = "2/3", optionB = "1/2", optionC = "1/4", optionD = "3/4",
            answer = "D", explanation = "Ruang sampel: {(A,A), (A,G), (G,A), (G,G)} = 4. Minimal satu angka ada 3 kejadian. Peluang = 3/4.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_023", grade = 9, subjectId = "SMP_MATH", topicId = "Peluang Kelereng",
            difficulty = "HARD", question = "Dalam kantong terdapat 5 kelereng merah, 3 biru, dan 2 kuning. Peluang terambil kelereng biru adalah...",
            optionA = "3/10", optionB = "1/2", optionC = "1/5", optionD = "3/8",
            answer = "A", explanation = "Total kelereng = 5 + 3 + 2 = 10. Kelereng biru = 3. Peluang = 3/10.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_024", grade = 9, subjectId = "SMP_MATH", topicId = "Frekuensi Harapan",
            difficulty = "HARD", question = "Satu koin dilempar sebanyak 80 kali. Frekuensi harapan munculnya sisi gambar adalah...",
            optionA = "30 kali", optionB = "40 kali", optionC = "50 kali", optionD = "20 kali",
            answer = "B", explanation = "Peluang gambar = 1/2. Frekuensi harapan = P(A) x N = 1/2 x 80 = 40 kali.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_M_025", grade = 9, subjectId = "SMP_MATH", topicId = "Peluang Komplemen",
            difficulty = "HARD", question = "Peluang hari esok turun hujan adalah 0.35. Peluang hari esok tidak turun hujan adalah...",
            optionA = "0.55", optionB = "0.75", optionC = "0.65", optionD = "0.60",
            answer = "C", explanation = "Peluang komplemen: P(A') = 1 - P(A) = 1 - 0.35 = 0.65.",
            xp = 150, educationLevel = "SMP"
        ),

        // ==========================================
        // === IPA TERPADU SMP (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Sel & Organisasi Kehidupan (Kelas 7, EASY) ---
        QuestionEntity(
            id = "Q_SMP_IPA_001", grade = 7, subjectId = "SMP_IPA", topicId = "Organel Sel",
            difficulty = "EASY", question = "Organel sel yang berfungsi sebagai pusat pengendali seluruh kegiatan sel adalah...",
            optionA = "Vakuola", optionB = "Mitokondria", optionC = "Ribosom", optionD = "Nukleus (Inti Sel)",
            answer = "D", explanation = "Nukleus mengandung materi genetik dan mengatur metabolisme serta aktivitas hidup seluruh sel.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_002", grade = 7, subjectId = "SMP_IPA", topicId = "Sel Tumbuhan",
            difficulty = "EASY", question = "Bagian sel yang hanya dimiliki oleh sel tumbuhan dan tidak ada pada sel hewan adalah...",
            optionA = "Dinding sel dan Kloroplas", optionB = "Membran sel dan Ribosom", optionC = "Mitokondria dan Nukleus", optionD = "Sitoplasma dan Lisosom",
            answer = "A", explanation = "Dinding sel memberikan bentuk kaku dan kloroplas mengandung klorofil untuk fotosintesis, hanya ada pada tumbuhan.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_003", grade = 7, subjectId = "SMP_IPA", topicId = "Jaringan Tumbuhan",
            difficulty = "EASY", question = "Jaringan pengangkut pada tumbuhan yang mengangkut air dan mineral dari akar ke daun adalah...",
            optionA = "Floem (Pembuluh Tapis)", optionB = "Xilem (Pembuluh Kayu)", optionC = "Kambium", optionD = "Epidermis",
            answer = "B", explanation = "Xilem mengangkut air dan hara mineral dari akar ke daun. Floem mengedarkan hasil fotosintesis dari daun ke seluruh tubuh.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_004", grade = 7, subjectId = "SMP_IPA", topicId = "Tingkatan Organisasi",
            difficulty = "EASY", question = "Urutan tingkatan organisasi kehidupan dari yang paling sederhana hingga kompleks adalah...",
            optionA = "Sel -> Organ -> Jaringan -> Sistem Organ -> Organisme", optionB = "Jaringan -> Sel -> Organ -> Organisme -> Sistem Organ", optionC = "Sel -> Jaringan -> Organ -> Sistem Organ -> Organisme", optionD = "Organisme -> Sistem Organ -> Organ -> Jaringan -> Sel",
            answer = "C", explanation = "Unit terkecil penyusun kehidupan adalah sel, kumpulan sel sejenis membentuk jaringan, organ, sistem organ, dan organisme.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_005", grade = 7, subjectId = "SMP_IPA", topicId = "Mikroskop",
            difficulty = "EASY", question = "Bagian mikroskop yang berfungsi memperbesar bayangan objek yang dekat dengan mata pengamat adalah...",
            optionA = "Revolver", optionB = "Lensa Objektif", optionC = "Diafragma", optionD = "Lensa Okuler",
            answer = "D", explanation = "Lensa okuler berada di bagian atas tempat mata memandang, memperbesar bayangan dari lensa objektif.",
            xp = 110, educationLevel = "SMP"
        ),

        // --- Quest 2: Kalor, Suhu & Pemuaian (Kelas 7, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPA_006", grade = 7, subjectId = "SMP_IPA", topicId = "Konversi Suhu",
            difficulty = "NORMAL", question = "Suhu zat cair 50°C setara dengan berapa derajat Fahrenheit (°F)?",
            optionA = "122°F", optionB = "102°F", optionC = "112°F", optionD = "90°F",
            answer = "A", explanation = "Rumus: F = (9/5 x C) + 32 = (9/5 x 50) + 32 = 90 + 32 = 122°F.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_007", grade = 7, subjectId = "SMP_IPA", topicId = "Perpindahan Kalor",
            difficulty = "NORMAL", question = "Perpindahan kalor tanpa melalui zat perantara (seperti pancaran panas sinar matahari ke bumi) disebut...",
            optionA = "Konveksi", optionB = "Radiasi", optionC = "Konduksi", optionD = "Evaporasi",
            answer = "B", explanation = "Radiasi adalah perpindahan panas melalui gelombang elektromagnetik tanpa memerlukan media zat perantara.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_008", grade = 7, subjectId = "SMP_IPA", topicId = "Pemuaian Rel",
            difficulty = "NORMAL", question = "Pemasangan sambungan rel kereta api sengaja diberi celah longgar bertujuan untuk...",
            optionA = "Memudahkan penggantian bantalan rel saat rusak", optionB = "Membuat kereta melaju lebih kencang tanpa gesekan", optionC = "Memberikan ruang pemuaian pada siang hari agar rel tidak bengkok", optionD = "Mengurangi suara bising gesekan roda baja",
            answer = "C", explanation = "Logam memuai memanjang saat menerima panas matahari. Celah memberi toleransi panjang agar rel tetap lurus.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_009", grade = 7, subjectId = "SMP_IPA", topicId = "Kalor Jenis",
            difficulty = "NORMAL", question = "Berapakah kalor yang diperlukan untuk memanaskan 2 kg air (c = 4.200 J/kg°C) dari 20°C menjadi 50°C?",
            optionA = "420.000 Joule", optionB = "126.000 Joule", optionC = "315.000 Joule", optionD = "252.000 Joule",
            answer = "D", explanation = "Q = m x c x Î”T = 2 x 4.200 x (50 - 20) = 8.400 x 30 = 252.000 Joule.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_010", grade = 7, subjectId = "SMP_IPA", topicId = "Perubahan Wujud",
            difficulty = "NORMAL", question = "Perubahan wujud zat dari gas langsung menjadi padat (seperti terbentuknya bunga es di kulkas) disebut...",
            optionA = "Mengkristal (Deposisi)", optionB = "Menyublim", optionC = "Mengembun", optionD = "Membeku",
            answer = "A", explanation = "Deposisi atau mengkristal adalah perubahan fasa dari gas langsung menjadi zat padat.",
            xp = 120, educationLevel = "SMP"
        ),

        // --- Quest 3: Gerak Lurus & Hukum Newton (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPA_011", grade = 8, subjectId = "SMP_IPA", topicId = "GLBB",
            difficulty = "NORMAL", question = "Sebuah mobil mula-mula diam lalu dipercepat konstan 3 m/s^2 selama 4 detik. Kecepatan akhir mobil adalah...",
            optionA = "7 m/s", optionB = "12 m/s", optionC = "9 m/s", optionD = "16 m/s",
            answer = "B", explanation = "vt = v0 + a.t = 0 + (3 x 4) = 12 m/s.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_012", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum Newton I",
            difficulty = "NORMAL", question = "Ketika bus direm mendadak, tubuh penumpang terdorong ke depan. Hal ini merupakan penerapan dari...",
            optionA = "Hukum III Newton (Aksi-Reaksi)", optionB = "Hukum II Newton (F = m.a)", optionC = "Hukum I Newton (Kelembaman/Inersia)", optionD = "Hukum Gravitasi Universal",
            answer = "C", explanation = "Hukum I Newton menyatakan benda cenderung mempertahankan keadaan diam atau gerak lurus beraturannya (kelembaman).",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_013", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum Newton II",
            difficulty = "NORMAL", question = "Gaya sebesar 50 Newton bekerja pada benda bermassa 10 kg. Percepatan yang dialami benda adalah...",
            optionA = "10 m/s^2", optionB = "0.5 m/s^2", optionC = "500 m/s^2", optionD = "5 m/s^2",
            answer = "D", explanation = "a = F / m = 50 N / 10 kg = 5 m/s^2.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_014", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum Newton III",
            difficulty = "NORMAL", question = "Peristiwa roket yang meluncur ke atas akibat gas panas menyembur ke bawah merupakan contoh pasangan gaya...",
            optionA = "Aksi dan Reaksi (Hukum III Newton)", optionB = "Gaya gesek dan gaya normal", optionC = "Gaya sentripetal", optionD = "Gaya pegas elastis",
            answer = "A", explanation = "Semburan gas ke bawah memberi gaya dorong reaksi yang sama besar dengan arah berlawanan ke atas.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_015", grade = 8, subjectId = "SMP_IPA", topicId = "Kecepatan Rata-rata",
            difficulty = "NORMAL", question = "Seorang atlet menempuh jarak 100 meter dalam waktu 12.5 detik. Kecepatan larinya adalah...",
            optionA = "7.5 m/s", optionB = "8 m/s", optionC = "8.5 m/s", optionD = "9 m/s",
            answer = "B", explanation = "v = s / t = 100 m / 12.5 s = 8 m/s.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 4: Sistem Pencernaan & Nutrisi Manusia (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPA_016", grade = 8, subjectId = "SMP_IPA", topicId = "Enzim Pencernaan",
            difficulty = "NORMAL", question = "Enzim ptialin (amilase) yang terdapat di dalam rongga mulut berfungsi untuk mengubah...",
            optionA = "Lemak menjadi asam lemak dan gliserol", optionB = "Protein menjadi asam amino", optionC = "Amilum (karbohidrat) menjadi maltosa (glukosa sederhana)", optionD = "Pepsinogen menjadi pepsin aktif",
            answer = "C", explanation = "Enzim ptialin dari kelenjar ludah memecah pati/amilum menjadi gula yang lebih sederhana di mulut.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_017", grade = 8, subjectId = "SMP_IPA", topicId = "Penyerapan Nutrisi",
            difficulty = "NORMAL", question = "Penyerapan sari-sari makanan hasil pencernaan sebagian besar berlangsung pada organ...",
            optionA = "Kerongkongan", optionB = "Lambung", optionC = "Usus Besar (Kolon)", optionD = "Usus Halus (Ileum & Jejunum)",
            answer = "D", explanation = "Dinding usus halus dipenuhi jonjot usus (vili) yang memperluas bidang penyerapan nutrisi ke peredaran darah.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_018", grade = 8, subjectId = "SMP_IPA", topicId = "Asam Lambung",
            difficulty = "NORMAL", question = "Asam klorida (HCl) di dalam lambung manusia berfungsi untuk...",
            optionA = "Membunuh bakteri patogen pada makanan dan mengaktifkan pepsin", optionB = "Mengemulsikan lemak makanan", optionC = "Menyerap air dan garam mineral", optionD = "Memecah glukosa menjadi energi",
            answer = "A", explanation = "HCl menciptakan suasana asam untuk mengaktifkan pepsinogen menjadi pepsin dan mensterilkan makanan dari kuman.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_019", grade = 8, subjectId = "SMP_IPA", topicId = "Zat Aditif",
            difficulty = "NORMAL", question = "Bahan alami berikut yang sering digunakan sebagai pewarna kuning alami pada olahan makanan adalah...",
            optionA = "Daun Suji", optionB = "Kunyit", optionC = "Cabai Merah", optionD = "Kluwek",
            answer = "B", explanation = "Kunyit mengandung senyawa kurkuminoid yang memberikan warna kuning cerah alami yang aman dikonsumsi.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_020", grade = 8, subjectId = "SMP_IPA", topicId = "Uji Nutrisi",
            difficulty = "NORMAL", question = "Bahan makanan yang ditetesi larutan Lugol (Iodin) berubah warna menjadi biru kehitaman menunjukkan makanan mengandung...",
            optionA = "Lemak", optionB = "Protein", optionC = "Amilum / Karbohidrat", optionD = "Glukosa",
            answer = "C", explanation = "Reagen Lugol merupakan indikator spesifik untuk menguji keberadaan amilum (pati).",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 5: Listrik Dinamis & Kemagnetan (Kelas 9, HARD) ---
        QuestionEntity(
            id = "Q_SMP_IPA_021", grade = 9, subjectId = "SMP_IPA", topicId = "Hukum Ohm",
            difficulty = "HARD", question = "Sebuah lampu memiliki hambatan 20 Ohm dihubungkan dengan sumber tegangan 100 Volt. Arus listrik yang mengalir adalah...",
            optionA = "0.2 Ampere", optionB = "2 Ampere", optionC = "2000 Ampere", optionD = "5 Ampere",
            answer = "D", explanation = "Hukum Ohm: I = V / R = 100 V / 20 Ohm = 5 Ampere.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_022", grade = 9, subjectId = "SMP_IPA", topicId = "Rangkaian Seri-Paralel",
            difficulty = "HARD", question = "Dua hambatan masing-masing 6 Ohm disusun secara paralel. Hambatan pengganti totalnya adalah...",
            optionA = "3 Ohm", optionB = "12 Ohm", optionC = "6 Ohm", optionD = "1.5 Ohm",
            answer = "A", explanation = "1/Rp = 1/6 + 1/6 = 2/6 -> Rp = 6/2 = 3 Ohm.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_023", grade = 9, subjectId = "SMP_IPA", topicId = "Daya Listrik",
            difficulty = "HARD", question = "Sebuah setrika listrik berdaya 300 Watt digunakan selama 2 jam setiap hari. Energi listrik yang digunakan per hari adalah...",
            optionA = "600 kWh", optionB = "0.6 kWh", optionC = "1.5 kWh", optionD = "0.3 kWh",
            answer = "B", explanation = "W = P x t = 300 Watt x 2 jam = 600 Wh = 0.6 kWh.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_024", grade = 9, subjectId = "SMP_IPA", topicId = "Kutub Magnet",
            difficulty = "HARD", question = "Dua kutub magnet yang senama (misalnya Utara dengan Utara) jika didekatkan akan...",
            optionA = "Berputar tanpa henti", optionB = "Tarik-menarik", optionC = "Tolak-menolak", optionD = "Tidak terjadi gaya apapun",
            answer = "C", explanation = "Sifat dasar magnet: kutub senama tolak-menolak, sedangkan kutub tidak senama akan tarik-menarik.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPA_025", grade = 9, subjectId = "SMP_IPA", topicId = "Elektromagnetik",
            difficulty = "HARD", question = "Kekuatan elektromagnet (kemagnetan kawat berarus) dapat ditingkatkan dengan cara...",
            optionA = "Mengganti inti besi dengan inti kayu", optionB = "Mengurangi jumlah lilitan kawat kumparan", optionC = "Memperkecil tegangan sumber listrik", optionD = "Memperbanyak jumlah lilitan kawat dan memperbesar kuat arus",
            answer = "D", explanation = "Makin banyak lilitan dan makin besar arus yang mengalir, medan magnet yang dihasilkan kumparan solenoida semakin kuat.",
            xp = 150, educationLevel = "SMP"
        ),

        // ==========================================
        // === IPS TERPADU SMP (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Peta, Letak Geografis & Iklim Nusantara (Kelas 7, EASY) ---
        QuestionEntity(
            id = "Q_SMP_IPS_001", grade = 7, subjectId = "SMP_IPS", topicId = "Letak Astronomis",
            difficulty = "EASY", question = "Letak astronomis wilayah Indonesia berada pada koordinat...",
            optionA = "6° LU - 11° LS dan 95° BT - 141° BT", optionB = "11° LU - 6° LS dan 90° BT - 140° BT", optionC = "6° LU - 11° LS dan 90° BT - 145° BT", optionD = "0° - 15° LS dan 95° BT - 141° BT",
            answer = "A", explanation = "Letak astronomis Indonesia menyebabkan Indonesia beriklim tropis dengan kelembapan tinggi sepanjang tahun.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_002", grade = 7, subjectId = "SMP_IPS", topicId = "Skala Peta",
            difficulty = "EASY", question = "Jarak kota A ke kota B pada peta berskala 1 : 500.000 adalah 4 cm. Jarak sebenarnya di lapangan adalah...",
            optionA = "2 km", optionB = "20 km", optionC = "200 km", optionD = "50 km",
            answer = "B", explanation = "Jarak sebenarnya = 4 cm x 500.000 = 2.000.000 cm = 20 km.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_003", grade = 7, subjectId = "SMP_IPS", topicId = "Zona Waktu",
            difficulty = "EASY", question = "Indonesia memiliki 3 zona waktu. Jika di Jakarta (WIB) pukul 08.00 pagi, maka di Jayapura (WIT) menunjukkan pukul...",
            optionA = "07.00 pagi", optionB = "09.00 pagi", optionC = "10.00 pagi", optionD = "11.00 pagi",
            answer = "C", explanation = "Perbedaan waktu WIB ke WIT adalah +2 jam (WIB ke WITA +1 jam, WITA ke WIT +1 jam). 08.00 + 2 = 10.00.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_004", grade = 7, subjectId = "SMP_IPS", topicId = "Angin Muson",
            difficulty = "EASY", question = "Angin muson barat yang bertiup dari benua Asia menuju Australia melewati samudera luas menyebabkan Indonesia mengalami musim...",
            optionA = "Dingin bersalju", optionB = "Kemarau", optionC = "Pancaroba", optionD = "Hujan",
            answer = "D", explanation = "Angin muson barat membawa banyak uap air dari Samudera Pasifik/Hindia, mengakibatkan musim penghujan di Indonesia (Oktober - April).",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_005", grade = 7, subjectId = "SMP_IPS", topicId = "Garis Wallace",
            difficulty = "EASY", question = "Garis khayal yang memisahkan persebaran fauna tipe Asiatis dan tipe Peralihan di Indonesia adalah...",
            optionA = "Garis Wallace", optionB = "Garis Weber", optionC = "Garis Khatulistiwa", optionD = "Garis Meridian",
            answer = "A", explanation = "Garis Wallace membatasi wilayah Asiatis (Sumatra, Jawa, Kalimantan) dengan wilayah peralihan (Sulawesi, Nusa Tenggara).",
            xp = 110, educationLevel = "SMP"
        ),

        // --- Quest 2: Kejayaan Kerajaan Maritim Nusantara (Kelas 7, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPS_006", grade = 7, subjectId = "SMP_IPS", topicId = "Sriwijaya",
            difficulty = "NORMAL", question = "Kerajaan maritim Buddha terbesar di Nusantara yang berpusat di Sumatera dan menguasai Selat Malaka adalah...",
            optionA = "Kerajaan Majapahit", optionB = "Kerajaan Sriwijaya", optionC = "Kerajaan Kutai", optionD = "Kerajaan Tarumanegara",
            answer = "B", explanation = "Sriwijaya berkembang pesat sebagai pusat perdagangan maritim dan pusat pembelajaran agama Buddha internasional di Asia Tenggara.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_007", grade = 7, subjectId = "SMP_IPS", topicId = "Sumpah Palapa",
            difficulty = "NORMAL", question = "Tokoh Mahapatih Majapahit yang mengucapkan Sumpah Palapa untuk menyatukan wilayah Nusantara adalah...",
            optionA = "Raden Wijaya", optionB = "Hayam Wuruk", optionC = "Gajah Mada", optionD = "Kertanegara",
            answer = "C", explanation = "Mahapatih Gajah Mada mengikrarkan Sumpah Palapa pada masa pemerintahan Ratu Tribhuwana Tunggadewi demi keutuhan Nusantara.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_008", grade = 7, subjectId = "SMP_IPS", topicId = "Samudera Pasai",
            difficulty = "NORMAL", question = "Kerajaan Islam pertama yang tercatat berdiri di wilayah kepulauan Indonesia adalah...",
            optionA = "Kesultanan Banten", optionB = "Kesultanan Demak", optionC = "Kesultanan Mataram", optionD = "Samudera Pasai",
            answer = "D", explanation = "Samudera Pasai berdiri pada abad ke-13 di pesisir utara Aceh dipimpin Sultan Malik as-Saleh.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_009", grade = 7, subjectId = "SMP_IPS", topicId = "Prasasti Yupa",
            difficulty = "NORMAL", question = "Bukti peninggalan tertua sejarah kerajaan bercorak Hindu di Indonesia adalah tiang batu bertulis (Yupa) dari kerajaan...",
            optionA = "Kutai Martadipura", optionB = "Tarumanegara", optionC = "Mataram Kuno", optionD = "Singasari",
            answer = "A", explanation = "7 prasasti Yupa bertarikh abad ke-4 Masehi ditemukan di Muara Kaman, Kutai, Kalimantan Timur pada masa Raja Mulawarman.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_010", grade = 7, subjectId = "SMP_IPS", topicId = "Jalur Sutra Maritim",
            difficulty = "NORMAL", question = "Komoditas rempah-rempah bernilai tinggi dari Maluku yang menjadi magnet jalur perdagangan dunia adalah...",
            optionA = "Kopi dan Teh", optionB = "Cengkih dan Pala", optionC = "Beras dan Gandum", optionD = "Tembakau dan Karet",
            answer = "B", explanation = "Cengkih dan buah pala hanya tumbuh di Kepulauan Maluku pada masa lampau dan bernilai setara emas di Eropa dan Tiongkok.",
            xp = 120, educationLevel = "SMP"
        ),

        // --- Quest 3: Interaksi Sosial & Lembaga Kemasyarakatan (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPS_011", grade = 8, subjectId = "SMP_IPS", topicId = "Syarat Interaksi",
            difficulty = "NORMAL", question = "Dua syarat mutlak terjadinya interaksi sosial dalam masyarakat adalah...",
            optionA = "Bahasa dan Surat kabar", optionB = "Tatap muka dan Uang", optionC = "Kontak sosial dan Komunikasi", optionD = "Norma dan Sanksi",
            answer = "C", explanation = "Interaksi sosial memerlukan kontak sosial (hubungan antarpihak) dan komunikasi (penyampaian dan penerimaan pesan).",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_012", grade = 8, subjectId = "SMP_IPS", topicId = "Bentuk Akomodasi",
            difficulty = "NORMAL", question = "Bentuk penyelesaian konflik sosial melalui pihak ketiga yang bersifat netral dan keputusannya mengikat disebut...",
            optionA = "Koersi", optionB = "Mediasi", optionC = "Kompromi", optionD = "Arbitrase",
            answer = "D", explanation = "Pada arbitrase, pihak ketiga (wasit/hakim) berhak memutuskan perkara yang wajib dipatuhi kedua pihak yang bersengketa.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_013", grade = 8, subjectId = "SMP_IPS", topicId = "Fungsi Lembaga Keluarga",
            difficulty = "NORMAL", question = "Lembaga keluarga memiliki fungsi sosialisasi primer, yang artinya...",
            optionA = "Tempat pertama kali anak belajar nilai, moral, dan aturan dasar kehidupan", optionB = "Tempat anak memperoleh gelar akademis formal", optionC = "Pusat kegiatan produksi ekonomi massal", optionD = "Sarana penegakan hukum dan keamanan lingkungan",
            answer = "A", explanation = "Sosialisasi primer berlangsung di keluarga saat anak membentuk kepribadian dan mengenal norma sosial awal.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_014", grade = 8, subjectId = "SMP_IPS", topicId = "Asimilasi & Akulturasi",
            difficulty = "NORMAL", question = "Percampuran dua kebudayaan atau lebih yang menghasilkan budaya baru tanpa menghilangkan unsur asli budaya lama disebut...",
            optionA = "Asimilasi", optionB = "Akulturasi", optionC = "Difusi", optionD = "Segregasi",
            answer = "B", explanation = "Akulturasi memadukan unsur baru dengan mempertahankan ciri khas budaya lama, berbeda dengan asimilasi yang melebur jadi satu.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_015", grade = 8, subjectId = "SMP_IPS", topicId = "Gotong Royong",
            difficulty = "NORMAL", question = "Bentuk interaksi sosial asosiatif yang mencerminkan kerjasama tradisional masyarakat pedesaan Indonesia adalah...",
            optionA = "Kontravensi terselubung", optionB = "Kompetisi antardesa", optionC = "Gotong royong (Sambatan / Gugur Gunung)", optionD = "Akomodasi koersif",
            answer = "C", explanation = "Gotong royong merupakan kearifan lokal bangsa Indonesia yang memperkuat persatuan dan kohesi sosial.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 4: Kegiatan Ekonomi & Perdagangan Antardaerah (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_IPS_016", grade = 8, subjectId = "SMP_IPS", topicId = "Faktor Produksi",
            difficulty = "NORMAL", question = "Empat faktor produksi utama dalam kegiatan ekonomi adalah...",
            optionA = "Tanah, Mesin, Toko, dan Bank", optionB = "Bahan baku, Pabrik, Uang, dan Konsumen", optionC = "Petani, Buruh, Pedagang, dan Pembeli", optionD = "Alam, Tenaga Kerja, Modal, dan Kewirausahaan",
            answer = "D", explanation = "Produksi membutuhkan sumber daya alam, sumber daya manusia (tenaga kerja), modal alat/uang, dan keahlian wirausaha.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_017", grade = 8, subjectId = "SMP_IPS", topicId = "Hukum Permintaan",
            difficulty = "NORMAL", question = "Menurut hukum permintaan, jika harga suatu barang mengalami kenaikan (ceteris paribus), maka jumlah barang yang diminta akan...",
            optionA = "Menurun", optionB = "Meningkat tajam", optionC = "Tetap sama", optionD = "Menjadi tidak terbatas",
            answer = "A", explanation = "Hukum permintaan berbanding terbalik: semakin tinggi harga, semakin sedikit jumlah barang yang bersedia dibeli konsumen.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_018", grade = 8, subjectId = "SMP_IPS", topicId = "Perdagangan Antarpulau",
            difficulty = "NORMAL", question = "Perdagangan antarpulau di Indonesia dipicu oleh faktor utama yaitu...",
            optionA = "Persaingan harga barang impor antarprovinsi", optionB = "Perbedaan potensi sumber daya alam dan keunggulan komparatif antardaerah", optionC = "Perbedaan mata uang antarpulau", optionD = "Penetapan pajak bea cukai antardaerah",
            answer = "B", explanation = "Wilayah surplus hasil bumi (misal beras di Jawa, ikan di Maluku) saling berdagang memenuhi kebutuhan yang belum tercukupi.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_019", grade = 8, subjectId = "SMP_IPS", topicId = "Pelaku Ekonomi",
            difficulty = "NORMAL", question = "Penyedia faktor produksi (tenaga kerja, tanah, modal) dalam arus lingkaran kegiatan ekonomi adalah...",
            optionA = "Pemerintah", optionB = "Rumah Tangga Produsen (RTP)", optionC = "Rumah Tangga Konsumen (RTK)", optionD = "Masyarakat Luar Negeri",
            answer = "C", explanation = "RTK menyediakan tanah, tenaga kerja, modal, dan menerima balas jasa berupa sewa, upah, bunga, dan laba.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_020", grade = 8, subjectId = "SMP_IPS", topicId = "Ekonomi Maritim",
            difficulty = "NORMAL", question = "Kegiatan ekonomi maritim di Indonesia mencakup sektor...",
            optionA = "Penambangan batubara di pedalaman hutan", optionB = "Budi daya ikan air tawar di danau", optionC = "Pertanian sawah irigasi teknis", optionD = "Navigasi pelayaran, industri galangan kapal, dan pelabuhan laut",
            answer = "D", explanation = "Ekonomi maritim berfokus pada transportasi laut, industri maritim, dan kepelabuhanan yang menopang konektivitas kepulauan.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 5: Kerjasama Regional ASEAN & Integrasi (Kelas 9, HARD) ---
        QuestionEntity(
            id = "Q_SMP_IPS_021", grade = 9, subjectId = "SMP_IPS", topicId = "Deklarasi Bangkok",
            difficulty = "HARD", question = "Organisasi ASEAN resmi didirikan di Bangkok pada 8 Agustus 1967 oleh lima negara pemrakarsa, yaitu...",
            optionA = "Indonesia, Malaysia, Filipina, Singapura, dan Thailand", optionB = "Indonesia, Brunei, Vietnam, Kamboja, dan Laos", optionC = "Indonesia, Thailand, Myanmar, Vietnam, dan Filipina", optionD = "Indonesia, Malaysia, Brunei, Singapura, dan Timor Leste",
            answer = "A", explanation = "Deklarasi Bangkok ditandatangani oleh Adam Malik, Tun Abdul Razak, Narciso Ramos, S. Rajaratnam, dan Thanat Khoman.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_022", grade = 9, subjectId = "SMP_IPS", topicId = "Sekretariat ASEAN",
            difficulty = "HARD", question = "Gedung Sekretariat Jenderal ASEAN berkedudukan permanen di kota...",
            optionA = "Bangkok, Thailand", optionB = "Jakarta, Indonesia", optionC = "Kuala Lumpur, Malaysia", optionD = "Singapura",
            answer = "B", explanation = "Gedung Sekretariat ASEAN terletak di Jalan Sisingamangaraja, Kebayoran Baru, Jakarta Selatan.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_023", grade = 9, subjectId = "SMP_IPS", topicId = "MEA",
            difficulty = "HARD", question = "Integrasi ekonomi regional di kawasan Asia Tenggara yang memberlakukan pasar bebas arus barang, jasa, dan modal dikenal sebagai...",
            optionA = "APEC", optionB = "AFTA (Asean Free Trade)", optionC = "MEA (Masyarakat Ekonomi ASEAN)", optionD = "OPEC",
            answer = "C", explanation = "MEA bertujuan menciptakan pasar tunggal dan basis produksi yang kompetitif di Asia Tenggara.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_024", grade = 9, subjectId = "SMP_IPS", topicId = "Dampak Globalisasi",
            difficulty = "HARD", question = "Sikap bijak pelajar dalam menghadapi arus deras globalisasi dan modernisasi adalah...",
            optionA = "Menutup diri dari pergaulan internasional", optionB = "Menolak secara mutlak seluruh teknologi dari luar negeri", optionC = "Meniru seluruh gaya hidup barat tanpa seleksi", optionD = "Menyaring budaya asing dengan berpegang teguh pada nilai Pancasila dan kearifan lokal",
            answer = "D", explanation = "Sikap selektif dan adaptif memungkinkan kita mengambil manfaat kemajuan teknologi tanpa kehilangan jati diri bangsa.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_IPS_025", grade = 9, subjectId = "SMP_IPS", topicId = "ZOPFAN",
            difficulty = "HARD", question = "Komitmen negara-negara ASEAN untuk menjaga kawasan Asia Tenggara tetap bebas dari campur tangan kekuatan luar dirumuskan dalam konsep...",
            optionA = "ZOPFAN (Zone of Peace, Freedom and Neutrality)", optionB = "SEATO Military Alliance", optionC = "NATO Partnership", optionD = "Pakta Warsawa Asia",
            answer = "A", explanation = "ZOPFAN dideklarasikan di Kuala Lumpur (1971) untuk menjamin Asia Tenggara yang damai, bebas, dan netral.",
            xp = 150, educationLevel = "SMP"
        ),

        // ==========================================
        // === BAHASA & KOMUNIKASI SMP (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Teks LHO & Teks Prosedur (Kelas 7, EASY) ---
        QuestionEntity(
            id = "Q_SMP_LNG_001", grade = 7, subjectId = "SMP_LANG", topicId = "Struktur LHO",
            difficulty = "EASY", question = "Struktur teks Laporan Hasil Observasi (LHO) yang tepat adalah...",
            optionA = "Orientasi -> Komplikasi -> Resolusi", optionB = "Pernyataan umum (klasifikasi) -> Deskripsi bagian -> Deskripsi manfaat", optionC = "Tesis -> Argumen -> Penegasan ulang", optionD = "Tujuan -> Langkah-langkah -> Penutup",
            answer = "B", explanation = "Teks LHO diawali definisi/klasifikasi umum, diikuti rincian bagian objek observasi, dan diakhiri manfaatnya.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_002", grade = 7, subjectId = "SMP_LANG", topicId = "Ciri Bahasa LHO",
            difficulty = "EASY", question = "Bahasa yang digunakan dalam teks laporan hasil observasi harus bersifat...",
            optionA = "Fiksi dan imajinatif", optionB = "Subjektif dan penuh opini pribadi", optionC = "Objektif, faktual, dan ilmiah", optionD = "Kiasan dan puitis",
            answer = "C", explanation = "LHO menyajikan fakta empiris apa adanya tanpa rekayasa atau bumbu opini emosional.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_003", grade = 7, subjectId = "SMP_LANG", topicId = "Teks Prosedur",
            difficulty = "EASY", question = "Ciri kebahasaan yang paling menonjol pada teks prosedur adalah penggunaan...",
            optionA = "Ungkapan perasaan hati pengarang", optionB = "Kalimat tanya retoris", optionC = "Majas metafora dan hiperbola", optionD = "Kalimat perintah (imperatif) dan konjungsi urutan waktu",
            answer = "D", explanation = "Teks prosedur memandu tahapan tindakan sehingga banyak memuat verba imperatif (aduklah, panaskan) dan urutan (lalu, kemudian).",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_004", grade = 7, subjectId = "SMP_LANG", topicId = "Konjungsi Syarat",
            difficulty = "EASY", question = "Kata penghubung (konjungsi) yang menyatakan hubungan syarat dalam kalimat adalah...",
            optionA = "Jika / Apabila", optionB = "Karena", optionC = "Walaupun", optionD = "Kemudian",
            answer = "A", explanation = "Konjungsi 'jika', 'apabila', 'kalau', dan 'asalkan' menunjukkan peristiwa yang menjadi prasyarat kejadian lain.",
            xp = 110, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_005", grade = 7, subjectId = "SMP_LANG", topicId = "Kalimat Definisi",
            difficulty = "EASY", question = "Manakah kalimat di bawah ini yang merupakan kalimat definisi?",
            optionA = "Komodo sedang berjemur di bawah terik sinar matahari pagi.", optionB = "Komodo adalah kadal terbesar di dunia yang hidup di Nusa Tenggara Timur.", optionC = "Banyak wisatawan takjub melihat cara komodo berjalan.", optionD = "Jangan mendekati komodo tanpa didampingi pemandu wisata!",
            answer = "B", explanation = "Kalimat definisi ditandai dengan kopula 'adalah', 'merupakan', atau 'yaitu' untuk merumuskan makna objek.",
            xp = 110, educationLevel = "SMP"
        ),

        // --- Quest 2: Puisi Rakyat & Cerita Fabel Edukatif (Kelas 7, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_LNG_006", grade = 7, subjectId = "SMP_LANG", topicId = "Ciri Gurindam",
            difficulty = "NORMAL", question = "Puisi lama dua baris sebait dengan rima a-a, di mana baris kedua berisi isi atau akibat nasihat disebut...",
            optionA = "Syair", optionB = "Pantun", optionC = "Gurindam", optionD = "Karmina",
            answer = "C", explanation = "Gurindam terdiri dari 2 baris bersajak sama; baris pertama masalah/syarat, baris kedua pesan/jawaban.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_007", grade = 7, subjectId = "SMP_LANG", topicId = "Ciri Syair",
            difficulty = "NORMAL", question = "Salah satu ciri utama syair adalah pola persajakannya yang berbunyi...",
            optionA = "a - b - b - a", optionB = "a - b - a - b", optionC = "a - a - b - b", optionD = "a - a - a - a",
            answer = "D", explanation = "Syair berasal dari tradisi Arab-Melayu berima akhir sama a-a-a-a dan semua barisnya merupakan isi cerita.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_008", grade = 7, subjectId = "SMP_LANG", topicId = "Karakter Fabel",
            difficulty = "NORMAL", question = "Cerita fabel adalah cerita fiksi yang menampilkan tokoh berupa...",
            optionA = "Binatang yang berperilaku dan berbicara menyerupai manusia", optionB = "Para dewa-dewi mitologi", optionC = "Tokoh sejarah masa lampau", optionD = "Makhluk luar angkasa",
            answer = "A", explanation = "Fabel menggunakan personifikasi hewan sebagai metafora mendidik budi pekerti dan watak manusia.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_009", grade = 7, subjectId = "SMP_LANG", topicId = "Struktur Fabel",
            difficulty = "NORMAL", question = "Bagian akhir pada cerita fabel yang memuat pesan moral atau petuah pengarang disebut...",
            optionA = "Resolusi", optionB = "Koda", optionC = "Komplikasi", optionD = "Orientasi",
            answer = "B", explanation = "Koda merupakan simpulan penutup cerita fabel yang menegaskan amanat nilai moral kepada pembaca.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_010", grade = 7, subjectId = "SMP_LANG", topicId = "Amanat Fabel",
            difficulty = "NORMAL", question = "Dalam kisah perlombaan kura-kura dan kelinci, nilai moral utama yang dapat dipetik adalah...",
            optionA = "Kecerdikan licik diperlukan untuk memenangkan perlombaan", optionB = "Kecepatan selalu menjadi penentu mutlak kesuksesan", optionC = "Ketekunan dan konsistensi mengalahkan kesombongan dan kemalasan", optionD = "Beristirahat sejenak tidak akan memengaruhi hasil akhir",
            answer = "C", explanation = "Kura-kura yang gigih pantang menyerah berhasil melampaui kelinci sombong yang tidur di tengah jalan.",
            xp = 120, educationLevel = "SMP"
        ),

        // --- Quest 3: English Basics (Kelas 7, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_LNG_011", grade = 7, subjectId = "SMP_LANG", topicId = "Simple Present",
            difficulty = "NORMAL", question = "Complete the sentence: 'Sarah always ... her teeth before going to bed.'",
            optionA = "brushed", optionB = "brush", optionC = "brushing", optionD = "brushes",
            answer = "D", explanation = "Subject 'Sarah' is third person singular (she), so in Simple Present tense we add -es to the verb 'brush' -> 'brushes'.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_012", grade = 7, subjectId = "SMP_LANG", topicId = "To Be Present",
            difficulty = "NORMAL", question = "Choose the correct sentence:",
            optionA = "They are active students in our junior high school.", optionB = "They is active students in our junior high school.", optionC = "They am active students in our junior high school.", optionD = "They be active students in our junior high school.",
            answer = "A", explanation = "Plural subject 'They' pairs with to be 'are' in present tense.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_013", grade = 7, subjectId = "SMP_LANG", topicId = "Greetings",
            difficulty = "NORMAL", question = "When you meet your English teacher at 07:00 AM, the best greeting is...",
            optionA = "Good night, Sir!", optionB = "Good morning, Sir!", optionC = "Good afternoon, Sir!", optionD = "Good bye, Sir!",
            answer = "B", explanation = "'Good morning' is used from sunrise until 12:00 PM noon.",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_014", grade = 7, subjectId = "SMP_LANG", topicId = "Telling Time",
            difficulty = "NORMAL", question = "How do you say '08:45' in English time expression?",
            optionA = "Half past eight", optionB = "A quarter past eight", optionC = "A quarter to nine", optionD = "Eight forty five seconds",
            answer = "C", explanation = "'A quarter to nine' means 15 minutes before 9:00 o'clock (08:45).",
            xp = 120, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_015", grade = 7, subjectId = "SMP_LANG", topicId = "Pronoun",
            difficulty = "NORMAL", question = "Look at that cat! ... fur is very soft and white.",
            optionA = "His", optionB = "It's", optionC = "Their", optionD = "Its",
            answer = "D", explanation = "'Its' is the possessive adjective for animals/objects. ('It's' is short for 'It is').",
            xp = 120, educationLevel = "SMP"
        ),

        // --- Quest 4: Teks Eksplanasi & Kalimat Efektif (Kelas 8, NORMAL) ---
        QuestionEntity(
            id = "Q_SMP_LNG_016", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Eksplanasi",
            difficulty = "NORMAL", question = "Teks eksplanasi bertujuan untuk menerangkan...",
            optionA = "Proses terjadinya suatu peristiwa alam, sosial, atau budaya secara kausalitas", optionB = "Langkah-langkah membuat kerajinan tangan", optionC = "Kisah petualangan seorang pendekar", optionD = "Iklan promosi produk baru",
            answer = "A", explanation = "Teks eksplanasi menjelaskan pertanyaan 'mengapa' dan 'bagaimana' suatu fenomena alam/sosial terjadi.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_017", grade = 8, subjectId = "SMP_LANG", topicId = "Konjungsi Kausalitas",
            difficulty = "NORMAL", question = "Konjungsi kausalitas (sebab-akibat) yang tepat dalam teks eksplanasi adalah...",
            optionA = "Lalu, kemudian, dan setelahnya", optionB = "Oleh karena itu, sehingga, dan menyebabkan", optionC = "Atau, melainkan, dan tetapi", optionD = "Di mana, dari pada, dan ke sana",
            answer = "B", explanation = "Kata penghubung sebab-akibat menghubungkan peristiwa penyebab dengan dampak yang ditimbulkannya.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_018", grade = 8, subjectId = "SMP_LANG", topicId = "Kalimat Efektif",
            difficulty = "NORMAL", question = "Manakah kalimat berikut yang merupakan kalimat efektif yang benar?",
            optionA = "Banyak para tamu-tamu sudah hadir.", optionB = "Para siswa-siswa saling berkumpul bersama di lapangan sekolah.", optionC = "Para siswa berkumpul di lapangan sekolah.", optionD = "Demi untuk mempersingkat waktu, acara kita mulai.",
            answer = "C", explanation = "Pilihan B, C, D pleonasme/pemborosan kata. Pilihan A lugas, hemat, dan memenuhi kaidah tata bahasa baku.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_019", grade = 8, subjectId = "SMP_LANG", topicId = "Kalimat Pasif",
            difficulty = "NORMAL", question = "Bentuk pasif dari kalimat 'Pemerintah membangun jembatan gantung itu' adalah...",
            optionA = "Dibangunnya jembatan oleh pemerintah itu.", optionB = "Jembatan gantung itu membangun pemerintah.", optionC = "Pemerintah terbangun jembatan gantung itu.", optionD = "Jembatan gantung itu dibangun oleh pemerintah.",
            answer = "D", explanation = "Objek 'Jembatan gantung itu' dipindah ke posisi subjek dan verba aktif 'membangun' diubah menjadi pasif 'dibangun'.",
            xp = 130, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_020", grade = 8, subjectId = "SMP_LANG", topicId = "Kata Baku",
            difficulty = "NORMAL", question = "Kelompok kata baku yang sesuai dengan KBBI adalah...",
            optionA = "Apotek, Praktik, Nasihat, Sistem", optionB = "Apotik, Praktek, Nasehat, Sistim", optionC = "Apotek, Praktek, Nasihat, Sistim", optionD = "Apotik, Praktik, Nasehat, Sistem",
            answer = "A", explanation = "Bentuk baku menurut Kamus Besar Bahasa Indonesia adalah apotek, praktik, nasihat, dan sistem.",
            xp = 130, educationLevel = "SMP"
        ),

        // --- Quest 5: English Reading: Recount & Descriptive (Kelas 8, HARD) ---
        QuestionEntity(
            id = "Q_SMP_LNG_021", grade = 8, subjectId = "SMP_LANG", topicId = "Recount Text",
            difficulty = "HARD", question = "The social function of a Recount Text is to...",
            optionA = "Persuade readers to buy a product", optionB = "Retell past experiences or historical events in chronological order", optionC = "Explain the step-by-step procedure of an experiment", optionD = "Describe an imaginary creature",
            answer = "B", explanation = "Recount text menceritakan kembali peristiwa masa lalu untuk menghibur atau memberi informasi kepada pembaca.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_022", grade = 8, subjectId = "SMP_LANG", topicId = "Past Tense",
            difficulty = "HARD", question = "Complete with the correct Simple Past verb: 'Last holiday, my family ... to Bali by airplane.'",
            optionA = "gone", optionB = "go", optionC = "went", optionD = "going",
            answer = "C", explanation = "'Went' is the irregular past form (V2) of the verb 'go'.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_023", grade = 8, subjectId = "SMP_LANG", topicId = "Descriptive Text",
            difficulty = "HARD", question = "The generic structure of a Descriptive Text consists of...",
            optionA = "Thesis, Arguments, and Reiteration", optionB = "Orientation, Complication, and Resolution", optionC = "Goal, Materials, and Steps", optionD = "Identification and Description",
            answer = "D", explanation = "Descriptive text introduces the specific person/place/thing in 'Identification', followed by detailed features in 'Description'.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_024", grade = 8, subjectId = "SMP_LANG", topicId = "Comparative Adjective",
            difficulty = "HARD", question = "Mount Everest is ... than Mount Merapi in Indonesia.",
            optionA = "higher", optionB = "highest", optionC = "more high", optionD = "as high",
            answer = "A", explanation = "For one-syllable adjectives like 'high', we add suffix '-er' for comparative degree: 'higher than'.",
            xp = 150, educationLevel = "SMP"
        ),
        QuestionEntity(
            id = "Q_SMP_LNG_025", grade = 8, subjectId = "SMP_LANG", topicId = "Conjunction",
            difficulty = "HARD", question = "He was very tired, ... he kept running until he reached the finish line.",
            optionA = "because", optionB = "yet / but", optionC = "so", optionD = "if",
            answer = "B", explanation = "'Yet' or 'but' expresses a contrast between being tired and persevering to the finish line.",
            xp = 150, educationLevel = "SMP"
        )
    )
}
