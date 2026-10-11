package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestionEntity

object QuestionStarterData_SMA {
    val SMA_QUESTIONS = listOf(
        // ==========================================
        // === MATEMATIKA TINGKAT LANJUT SMA (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Fungsi Eksponen & Logaritma (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_M_001", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Eksponen",
            difficulty = "NORMAL", question = "Nilai dari (2^5 x 2^3) : 2^6 adalah...",
            optionA = "4", optionB = "8", optionC = "16", optionD = "2",
            answer = "A", explanation = "Sifat eksponen: 2^(5+3) : 2^6 = 2^8 : 2^6 = 2^(8-6) = 2^2 = 4.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_002", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Logaritma",
            difficulty = "NORMAL", question = "Jika ^2log 3 = a dan ^2log 5 = b, maka nilai ^2log 45 adalah...",
            optionA = "a + 2b", optionB = "2a + b", optionC = "a^2 + b", optionD = "2ab",
            answer = "B", explanation = "45 = 9 x 5 = 3^2 x 5. ^2log 45 = ^2log 3^2 + ^2log 5 = 2(^2log 3) + ^2log 5 = 2a + b.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_003", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Persamaan Eksponen",
            difficulty = "NORMAL", question = "Penyelesaian persamaan 3^(2x - 1) = 27 adalah...",
            optionA = "x = 1.5", optionB = "x = 3", optionC = "x = 2", optionD = "x = 4",
            answer = "C", explanation = "27 = 3^3. Maka 2x - 1 = 3 -> 2x = 4 -> x = 2.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_004", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Bentuk Akar",
            difficulty = "NORMAL", question = "Bentuk rasional dari 6 / (\u221A5 - \u221A2) adalah...",
            optionA = "\u221A5 + \u221A2", optionB = "3(\u221A5 + \u221A2)", optionC = "6(\u221A5 + \u221A2)", optionD = "2(\u221A5 + \u221A2)",
            answer = "D", explanation = "Kalikan sekawan: 6(\u221A5 + \u221A2) / (5 - 2) = 6(\u221A5 + \u221A2) / 3 = 2(\u221A5 + \u221A2).",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_005", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Sifat Logaritma",
            difficulty = "NORMAL", question = "Nilai dari ^3log 54 + ^3log 18 - ^3log 12 adalah...",
            optionA = "4", optionB = "3", optionC = "5", optionD = "2",
            answer = "A", explanation = "^3log ( (54 x 18) / 12 ) = ^3log (972 / 12) = ^3log 81 = ^3log 3^4 = 4.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 2: Trigonometri Analitik (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_M_006", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Sudut Istimewa",
            difficulty = "NORMAL", question = "Nilai eksak dari sin 30° + cos 60° - tan 45° adalah...",
            optionA = "1/2", optionB = "0", optionC = "1", optionD = "-1/2",
            answer = "B", explanation = "sin 30° = 1/2, cos 60° = 1/2, tan 45° = 1. Maka 1/2 + 1/2 - 1 = 1 - 1 = 0.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_007", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Sudut Berelasi",
            difficulty = "NORMAL", question = "Nilai dari cos 150° adalah...",
            optionA = "-1/2", optionB = "1/2 \u221A3", optionC = "-1/2 \u221A3", optionD = "1/2",
            answer = "C", explanation = "Sudut di kuadran II: cos 150° = cos(180° - 30°) = -cos 30° = -1/2 \u221A3.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_008", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Identitas Trigonometri",
            difficulty = "NORMAL", question = "Bentuk sederhana dari (sin^2 x + cos^2 x) / (1 + tan^2 x) adalah...",
            optionA = "sec^2 x", optionB = "sin^2 x", optionC = "tan^2 x", optionD = "cos^2 x",
            answer = "D", explanation = "sin^2 x + cos^2 x = 1, dan 1 + tan^2 x = sec^2 x. Maka 1 / sec^2 x = cos^2 x.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_009", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Aturan Sinus",
            difficulty = "NORMAL", question = "Pada segitiga ABC, sudut A = 30°, sudut B = 45°, dan sisi a = 6 cm. Panjang sisi b adalah...",
            optionA = "6\u221A2 cm", optionB = "3\u221A2 cm", optionC = "6\u221A3 cm", optionD = "12 cm",
            answer = "A", explanation = "Aturan sinus: a / sin A = b / sin B -> 6 / (1/2) = b / (1/2 \u221A2) -> 12 = 2b / \u221A2 -> b = 6\u221A2 cm.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_010", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Luas Segitiga Trigonometri",
            difficulty = "NORMAL", question = "Luas segitiga dengan panjang dua sisi 8 cm dan 10 cm serta sudut apit 30° adalah...",
            optionA = "40 cm^2", optionB = "20 cm^2", optionC = "20\u221A3 cm^2", optionD = "10 cm^2",
            answer = "B", explanation = "L = 1/2 x a x b x sin C = 1/2 x 8 x 10 x sin 30° = 40 x 1/2 = 20 cm^2.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 3: Aljabar Matriks & Sistem Persamaan (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_M_011", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Determinan Matriks",
            difficulty = "HARD", question = "Determinan dari matriks A = [[4, 3], [2, 5]] adalah...",
            optionA = "11", optionB = "26", optionC = "14", optionD = "-14",
            answer = "C", explanation = "Det(A) = (ad - bc) = (4 x 5) - (3 x 2) = 20 - 6 = 14.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_012", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Perkalian Matriks",
            difficulty = "HARD", question = "Syarat dua matriks A dan B dapat dikalikan (A x B) adalah...",
            optionA = "Determinan kedua matriks tidak boleh nol", optionB = "Kedua matriks harus berordo sama", optionC = "Banyak baris A sama dengan banyak baris B", optionD = "Banyak kolom matriks A sama dengan banyak baris matriks B",
            answer = "D", explanation = "Operasi perkalian matriks (m x k) dengan (k x n) menghasilkan matriks berordo (m x n).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_013", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Invers Matriks",
            difficulty = "HARD", question = "Jika matriks tidak memiliki invers, maka nilai determinannya adalah...",
            optionA = "0 (Matriks Singular)", optionB = "1", optionC = "-1", optionD = "Tak terhingga",
            answer = "A", explanation = "Matriks yang determinannya nol disebut matriks singular dan tidak memiliki invers karena pembagian dengan nol tidak terdefinisi.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_014", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Transpose Matriks",
            difficulty = "HARD", question = "Transpose dari matriks baris [3, 7, -2] adalah...",
            optionA = "Matriks baris [-2, 7, 3]", optionB = "Matriks kolom [[3], [7], [-2]]", optionC = "Matriks nol", optionD = "Matriks identitas",
            answer = "B", explanation = "Transpose mengubah elemen baris menjadi kolom dan elemen kolom menjadi baris.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_015", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Matriks Identitas",
            difficulty = "HARD", question = "Sifat dari perkalian suatu matriks A dengan matriks identitas I adalah...",
            optionA = "A x I = I", optionB = "A x I = 0", optionC = "A x I = I x A = A", optionD = "A x I = A^2",
            answer = "C", explanation = "Matriks identitas bertindak sebagai unsur netral (seperti angka 1) pada perkalian matriks.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 4: Diferensial / Turunan Fungsi Aljabar (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_M_016", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Turunan Polinomial",
            difficulty = "HARD", question = "Turunan pertama dari f(x) = 3x^4 - 5x^2 + 7x - 9 adalah f'(x) = ...",
            optionA = "12x^4 - 10x^2 + 7", optionB = "12x^3 - 5x + 7", optionC = "7x^3 - 10x + 7", optionD = "12x^3 - 10x + 7",
            answer = "D", explanation = "Aturan turunan: d/dx(a.x^n) = n.a.x^(n-1). 4(3)x^3 - 2(5)x^1 + 7 - 0 = 12x^3 - 10x + 7.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_017", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Gradien Garis Singgung",
            difficulty = "HARD", question = "Gradien garis singgung kurva y = x^2 - 4x + 3 di titik (3, 0) adalah...",
            optionA = "2", optionB = "0", optionC = "-1", optionD = "4",
            answer = "A", explanation = "m = y' = 2x - 4. Pada absis x = 3, m = 2(3) - 4 = 6 - 4 = 2.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_018", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Titik Stasioner",
            difficulty = "HARD", question = "Syarat utama agar kurva fungsi f(x) mencapai titik stasioner (maksimum/minimum) adalah...",
            optionA = "f''(x) = 0", optionB = "f'(x) = 0", optionC = "f(x) = 0", optionD = "f'(x) > 0",
            answer = "B", explanation = "Titik balik atau stasioner terjadi ketika laju perubahan sesaat (garis singgung horizontal), yaitu f'(x) = 0.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_019", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Aturan Rantai",
            difficulty = "HARD", question = "Turunan pertama dari f(x) = (2x + 3)^4 adalah...",
            optionA = "2(2x + 3)^3", optionB = "4(2x + 3)^3", optionC = "8(2x + 3)^3", optionD = "8(2x + 3)^4",
            answer = "C", explanation = "Aturan rantai: f'(x) = 4(2x + 3)^3 x (turunan dalam yaitu 2) = 8(2x + 3)^3.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_020", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Kecepatan Sesaat",
            difficulty = "HARD", question = "Persamaan gerak benda s(t) = 2t^3 - 4t. Kecepatan benda pada saat t = 2 detik adalah...",
            optionA = "12 m/s", optionB = "16 m/s", optionC = "24 m/s", optionD = "20 m/s",
            answer = "D", explanation = "v(t) = s'(t) = 6t^2 - 4. Pada t = 2 -> v(2) = 6(2^2) - 4 = 24 - 4 = 20 m/s.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 5: Integral Kalkulus & Penerapan Luas (Kelas 12, HARD) ---
        QuestionEntity(
            id = "Q_SMA_M_021", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Integral Tak Tentu",
            difficulty = "HARD", question = "Hasil dari \u222B (6x^2 - 4x + 5) dx adalah...",
            optionA = "2x^3 - 2x^2 + 5x + C", optionB = "3x^3 - 2x^2 + 5x + C", optionC = "12x - 4 + C", optionD = "2x^3 - 4x^2 + 5x + C",
            answer = "A", explanation = "\u222B a.x^n dx = (a/(n+1)) x^(n+1). (6/3)x^3 - (4/2)x^2 + 5x + C = 2x^3 - 2x^2 + 5x + C.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_022", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Integral Tentu",
            difficulty = "HARD", question = "Nilai dari \u222B[0 sampai 2] (3x^2 + 2x) dx adalah...",
            optionA = "10", optionB = "12", optionC = "14", optionD = "8",
            answer = "B", explanation = "[x^3 + x^2] dari 0 sampai 2 = (2^3 + 2^2) - (0) = 8 + 4 = 12.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_023", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Luas di Bawah Kurva",
            difficulty = "HARD", question = "Luas daerah yang dibatasi oleh garis y = 2x, sumbu X, x = 1 dan x = 4 adalah...",
            optionA = "16 satuan luas", optionB = "12 satuan luas", optionC = "15 satuan luas", optionD = "18 satuan luas",
            answer = "C", explanation = "L = \u222B[1 sampai 4] 2x dx = [x^2] dari 1 sampai 4 = 4^2 - 1^2 = 16 - 1 = 15.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_024", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Integral Substitusi",
            difficulty = "HARD", question = "Metode integral substitusi digunakan terutama ketika fungsi integran memuat...",
            optionA = "Penjumlahan bilangan bulat murni", optionB = "Pecahan berulang tak hingga", optionC = "Hanya konstanta numerik", optionD = "Perkalian fungsi dengan turunan dari salah satu faktor fungsinya",
            answer = "D", explanation = "Substitusi u = g(x) menyederhanakan bentuk \u222B f(g(x)) g'(x) dx menjadi \u222B f(u) du.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_M_025", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Volume Benda Putar",
            difficulty = "HARD", question = "Rumus volume benda putar yang diputar 360° mengelilingi sumbu X adalah...",
            optionA = "V = \u03C0 \u222B y^2 dx", optionB = "V = 2\u03C0 \u222B y dx", optionC = "V = \u03C0 \u222B y dx", optionD = "V = \u222B y^2 dx",
            answer = "A", explanation = "Metode cakram tegak lurus sumbu X memiliki elemen volume dV = \u03C0.r^2.dx = \u03C0.y^2.dx.",
            xp = 150, educationLevel = "SMA"
        ),

        // ==========================================
        // === SAINS MIPA SMA (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Fisika: Vektor & Gerak Parabola (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_MIPA_001", grade = 10, subjectId = "SMA_MIPA", topicId = "Vektor Resultan",
            difficulty = "NORMAL", question = "Dua buah vektor gaya F1 = 6 N dan F2 = 8 N saling tegak lurus (90°). Resultan kedua gaya adalah...",
            optionA = "14 N", optionB = "10 N", optionC = "2 N", optionD = "12 N",
            answer = "B", explanation = "R = \u221A(F1^2 + F2^2 + 2.F1.F2.cos 90°) = \u221A(36 + 64 + 0) = \u221A100 = 10 N.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_002", grade = 10, subjectId = "SMA_MIPA", topicId = "Gerak Parabola",
            difficulty = "NORMAL", question = "Pada gerak parabola, komponen kecepatan pada sumbu horizontal (sumbu X) bersifat...",
            optionA = "Diperlambat hingga nol di puncak", optionB = "Dipercepat beraturan oleh gravitasi", optionC = "Konstan (Gerak Lurus Beraturan / GLB)", optionD = "Selalu berubah-ubah arah",
            answer = "C", explanation = "Karena tidak ada gaya gesekan udara horizontal, vx = v0.cos Î¸ nilainya selalu konstan.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_003", grade = 10, subjectId = "SMA_MIPA", topicId = "Ketinggian Maksimum",
            difficulty = "NORMAL", question = "Sebuah bola ditendang dengan kecepatan awal 20 m/s dan sudut elevasi 30° (g = 10 m/s^2). Tinggi maksimum bola adalah...",
            optionA = "7.5 meter", optionB = "10 meter", optionC = "2.5 meter", optionD = "5 meter",
            answer = "D", explanation = "Hmax = (v0^2 . sin^2 Î¸) / (2g) = (400 x (1/2)^2) / 20 = (400 x 1/4) / 20 = 100 / 20 = 5 meter.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_004", grade = 10, subjectId = "SMA_MIPA", topicId = "Gaya Gravitasi Newton",
            difficulty = "NORMAL", question = "Jika jarak antara dua planet dilipatgandakan menjadi 2 kali lipat semula, gaya gravitasi tarik-menariknya menjadi...",
            optionA = "1/4 kali semula", optionB = "1/2 kali semula", optionC = "2 kali semula", optionD = "4 kali semula",
            answer = "A", explanation = "Hukum Gravitasi Newton: F berbanding terbalik dengan kuadrat jarak (1 / r^2). (1 / 2^2) = 1/4.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_005", grade = 10, subjectId = "SMA_MIPA", topicId = "Usaha & Energi",
            difficulty = "NORMAL", question = "Sebuah balok bermassa 4 kg bergerak dengan kecepatan 10 m/s. Energi kinetik balok tersebut adalah...",
            optionA = "400 Joule", optionB = "200 Joule", optionC = "100 Joule", optionD = "50 Joule",
            answer = "B", explanation = "Ek = 1/2 . m . v^2 = 1/2 x 4 x (10^2) = 2 x 100 = 200 Joule.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 2: Kimia: Struktur Atom & Ikatan (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_MIPA_006", grade = 10, subjectId = "SMA_MIPA", topicId = "Nomor Atom & Massa",
            difficulty = "NORMAL", question = "Suatu unsur memiliki nomor atom 11 dan nomor massa 23. Jumlah proton, neutron, dan elektronnya berturut-turut adalah...",
            optionA = "12, 11, dan 12", optionB = "11, 23, dan 11", optionC = "11, 12, dan 11", optionD = "11, 11, dan 12",
            answer = "C", explanation = "Proton = nomor atom = 11. Elektron = proton = 11. Neutron = nomor massa - nomor atom = 23 - 11 = 12.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_007", grade = 10, subjectId = "SMA_MIPA", topicId = "Ikatan Kimia",
            difficulty = "NORMAL", question = "Ikatan yang terbentuk akibat serah-terima elektron antara unsur logam (melepas elektron) dan nonlogam (menangkap elektron) adalah...",
            optionA = "Ikatan Logam", optionB = "Ikatan Kovalen Polar", optionC = "Ikatan Kovalen Nonpolar", optionD = "Ikatan Ionik",
            answer = "D", explanation = "Contoh ikatan ionik adalah garam dapur NaCl (Na+ melepas 1 elektron dan Cl- menangkap 1 elektron).",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_008", grade = 10, subjectId = "SMA_MIPA", topicId = "Konfigurasi Elektron",
            difficulty = "NORMAL", question = "Konfigurasi elektron atom Klorin dengan nomor atom 17 menurut kulit Bohr adalah...",
            optionA = "2, 8, 7", optionB = "2, 8, 8", optionC = "2, 7, 8", optionD = "2, 10, 5",
            answer = "A", explanation = "Kulit K maks 2, kulit L maks 8, sisa 7 elektron berada di kulit terluar (M) yaitu 2, 8, 7.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_009", grade = 10, subjectId = "SMA_MIPA", topicId = "Konsep Mol",
            difficulty = "NORMAL", question = "Jumlah mol dari 36 gram air (H2O) jika diketahui Ar H = 1 dan Ar O = 16 adalah...",
            optionA = "1 mol", optionB = "2 mol", optionC = "3 mol", optionD = "0.5 mol",
            answer = "B", explanation = "Mr H2O = (2 x 1) + 16 = 18 g/mol. Mol = massa / Mr = 36 / 18 = 2 mol.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_010", grade = 10, subjectId = "SMA_MIPA", topicId = "Hukum Lavoisier",
            difficulty = "NORMAL", question = "Hukum Kekekalan Massa yang dikemukakan oleh Antoine Lavoisier menyatakan bahwa...",
            optionA = "Volume gas berbanding lurus dengan jumlah molnya", optionB = "Perbandingan massa unsur penyusun senyawa selalu tetap", optionC = "Massa total zat-zat sebelum reaksi sama dengan massa total zat-zat sesudah reaksi dalam sistem tertutup", optionD = "Tekanan berbanding terbalik dengan volume gas",
            answer = "C", explanation = "Dalam ruang tertutup, atom tidak diciptakan atau dimusnahkan selama reaksi kimia, hanya disusun ulang.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 3: Biologi: Transpor Sel & Metabolisme (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_MIPA_011", grade = 11, subjectId = "SMA_MIPA", topicId = "Osmosis",
            difficulty = "HARD", question = "Perpindahan molekul air melintasi membran semipermeabel dari larutan hipotonik ke hipertonik disebut...",
            optionA = "Eksositosis", optionB = "Difusi terfasilitasi", optionC = "Endositosis", optionD = "Osmosis",
            answer = "D", explanation = "Osmosis adalah difusi pelarut (air) melalui membran selektif permeabel menuju konsentrasi zat terlarut lebih tinggi.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_012", grade = 11, subjectId = "SMA_MIPA", topicId = "Respirasi Sel",
            difficulty = "HARD", question = "Tahapan katabolisme glukosa (respirasi aerob) yang menghasilkan paling banyak molekul ATP adalah...",
            optionA = "Rantai Transpor Elektron", optionB = "Glikolisis", optionC = "Dekarboksilasi Oksidatif", optionD = "Siklus Krebs",
            answer = "A", explanation = "Transpor elektron di krista mitokondria menghasilkan sekitar 32-34 ATP dari transfer elektron NADH dan FADH2.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_013", grade = 11, subjectId = "SMA_MIPA", topicId = "Sifat Enzim",
            difficulty = "HARD", question = "Sifat enzim sebagai biokatalisator adalah...",
            optionA = "Menyediakan energi panas bagi sel", optionB = "Mempercepat laju reaksi kimia dengan menurunkan energi aktivasi tanpa ikut habis bereaksi", optionC = "Mengubah hasil akhir reaksi secara permanen", optionD = "Bekerja optimum pada sembarang suhu ekstrem",
            answer = "B", explanation = "Enzim bekerja spesifik menurunkan energi aktivasi reaksi biokimia sehingga reaksi berlangsung cepat pada suhu tubuh normal.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_014", grade = 11, subjectId = "SMA_MIPA", topicId = "Fotosintesis Terang",
            difficulty = "HARD", question = "Reaksi terang fotosintesis berlangsung di tilakoid kloroplas dan menghasilkan...",
            optionA = "Asam piruvat", optionB = "Glukosa dan CO2", optionC = "ATP, NADPH, dan O2", optionD = "H2O dan Asam sitrat",
            answer = "C", explanation = "Fotolisis air pada reaksi terang menghasilkan oksigen (O2) serta energi kimia ATP dan NADPH untuk reaksi gelap (Calvin).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_015", grade = 11, subjectId = "SMA_MIPA", topicId = "Fermentasi Asam Laktat",
            difficulty = "HARD", question = "Pada saat otot beraktivitas keras tanpa kecukupan oksigen, terjadi respirasi anaerob yang menghasilkan penumpukan...",
            optionA = "Kolesterol", optionB = "Etanol dan CO2", optionC = "Asam amino", optionD = "Asam laktat",
            answer = "D", explanation = "Asam laktat terbentuk saat piruvat direduksi oleh NADH tanpa O2, memicu rasa pegal dan lelah pada otot.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 4: Fisika: Termodinamika & Gelombang Bunyi (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_MIPA_016", grade = 11, subjectId = "SMA_MIPA", topicId = "Hukum Termodinamika I",
            difficulty = "HARD", question = "Hukum I Termodinamika merupakan prinsip kekekalan energi yang dirumuskan sebagai...",
            optionA = "Q = Î”U + W", optionB = "W = Q x Î”U", optionC = "Î”U = Q + W", optionD = "P1.V1 = P2.V2",
            answer = "A", explanation = "Kalor yang diserap sistem (Q) digunakan untuk mengubah energi dalam (Î”U) dan melakukan usaha luar (W).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_017", grade = 11, subjectId = "SMA_MIPA", topicId = "Efek Doppler",
            difficulty = "HARD", question = "Ketika mobil ambulans yang membunyikan sirine mendekati pendengar yang diam, frekuensi bunyi yang terdengar akan...",
            optionA = "Lebih rendah dari frekuensi sumber", optionB = "Lebih tinggi dari frekuensi sumber", optionC = "Sama persis dengan frekuensi sumber", optionD = "Hilang sama sekali",
            answer = "B", explanation = "Efek Doppler: sumber mendekati pengamat memadatkan muka gelombang bunyi sehingga frekuensi terdeteksi meningkat.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_018", grade = 11, subjectId = "SMA_MIPA", topicId = "Mesin Carnot",
            difficulty = "HARD", question = "Efisiensi maksimum mesin kalor Carnot yang bekerja antara reservoir 600 K dan 300 K adalah...",
            optionA = "25%", optionB = "75%", optionC = "50%", optionD = "60%",
            answer = "C", explanation = "Î· = (1 - T_rendah / T_tinggi) x 100% = (1 - 300 / 600) x 100% = 0.5 x 100% = 50%.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_019", grade = 11, subjectId = "SMA_MIPA", topicId = "Taraf Intensitas Bunyi",
            difficulty = "HARD", question = "Taraf intensitas satu mesin pabrik adalah 60 dB. Jika ada 10 mesin serupa yang menyala bersamaan, taraf intensitasnya menjadi...",
            optionA = "65 dB", optionB = "600 dB", optionC = "80 dB", optionD = "70 dB",
            answer = "D", explanation = "TI_n = TI_1 + 10 log(n) = 60 + 10 log(10) = 60 + 10(1) = 70 dB.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_020", grade = 11, subjectId = "SMA_MIPA", topicId = "Gelombang Stasioner",
            difficulty = "HARD", question = "Perpaduan dua gelombang koheren yang merambat berlawanan arah dengan frekuensi dan amplitudo sama menghasilkan gelombang...",
            optionA = "Stasioner (Gelombang Berdiri)", optionB = "Elektromagnetik", optionC = "Transversal murni", optionD = "Longitudinal murni",
            answer = "A", explanation = "Superposisi menghasilkan simpul (amplitudo nol) dan perut (amplitudo maksimum) yang stasioner di posisinya.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 5: Biologi: Genetika DNA/RNA & Hukum Mendel (Kelas 12, HARD) ---
        QuestionEntity(
            id = "Q_SMA_MIPA_021", grade = 12, subjectId = "SMA_MIPA", topicId = "Basa Nitrogen DNA",
            difficulty = "HARD", question = "Pasangan basa nitrogen yang tepat pada rantai ganda DNA adalah...",
            optionA = "Adenin berpasangan dengan Urasil; Guanin dengan Timin", optionB = "Adenin berpasangan dengan Timin; Guanin dengan Sitosin", optionC = "Adenin berpasangan dengan Sitosin; Guanin dengan Timin", optionD = "Timin berpasangan dengan Urasil; Guanin dengan Sitosin",
            answer = "B", explanation = "Aturan Chargaff: A berikatan hidrogen ganda dengan T (A=T), dan G berikatan hidrogen tripel dengan C (G\u2261C). Urasil hanya ada pada RNA.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_022", grade = 12, subjectId = "SMA_MIPA", topicId = "Hukum Mendel I",
            difficulty = "HARD", question = "Persilangan monohibrid dominan penuh antara tanaman berbunga merah (MM) dan putih (mm) menghasilkan rasio fenotipe F2...",
            optionA = "9 : 3 : 3 : 1", optionB = "1 Merah : 2 Merah Muda : 1 Putih", optionC = "3 Merah : 1 Putih", optionD = "1 Merah : 1 Putih",
            answer = "C", explanation = "Genotipe F2: 1 MM : 2 Mm : 1 mm. Karena M dominan penuh terhadap m, maka 3 tanaman berbunga merah dan 1 putih.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_023", grade = 12, subjectId = "SMA_MIPA", topicId = "Transkripsi Sintesis Protein",
            difficulty = "HARD", question = "Proses pencetakan rantai mRNA dari cetakan (template) DNA di dalam nukleus disebut...",
            optionA = "Elongasi", optionB = "Translasi", optionC = "Replikasi", optionD = "Transkripsi",
            answer = "D", explanation = "Transkripsi menyalin kode genetik DNA ke mRNA oleh RNA polimerase sebelum diterjemahkan (translasi) di ribosom.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_024", grade = 12, subjectId = "SMA_MIPA", topicId = "Kromosom Manusia",
            difficulty = "HARD", question = "Kariotipe kromosom pada sel gamet (spermatozoa) manusia normal adalah...",
            optionA = "22A + X atau 22A + Y", optionB = "44A + XY", optionC = "46A + XY", optionD = "23A + XY",
            answer = "A", explanation = "Sel gamet bersifat haploid (n = 23 kromosom), terdiri dari 22 autosom dan 1 gonosom (X atau Y).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_MIPA_025", grade = 12, subjectId = "SMA_MIPA", topicId = "Mutasi Gen",
            difficulty = "HARD", question = "Penyakit anemia sel sabit (sickle cell anemia) disebabkan oleh mutasi genetik berupa...",
            optionA = "Kelebihan satu kromosom nomor 21 (Trisomi)", optionB = "Substitusi satu basa nitrogen pada rantai hemoglobin", optionC = "Pelepasan seluruh lengan kromosom X", optionD = "Kekurangan asupan zat besi semasa balita",
            answer = "B", explanation = "Pergantian basa adenin menjadi timin menyebabkan asam glutamat digantikan oleh valin pada molekul hemoglobin.",
            xp = 150, educationLevel = "SMA"
        ),

        // ==========================================
        // === SOSIAL HUMANIORA / SOSHUM SMA (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Ekonomi: Kelangkaan & Mekanisme Pasar (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_SOS_001", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Kelangkaan",
            difficulty = "NORMAL", question = "Inti masalah ekonomi modern timbul karena adanya kesenjangan antara...",
            optionA = "Pemerintah dan investor swasta", optionB = "Jumlah uang beredar dan jumlah emas di bank", optionC = "Kebutuhan manusia yang tak terbatas dan alat pemuas kebutuhan yang terbatas (langka)", optionD = "Penduduk desa dan penduduk kota",
            answer = "C", explanation = "Kelangkaan (scarcity) mengharuskan manusia membuat pilihan dan menentukan skala prioritas kebutuhan.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_002", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Biaya Peluang",
            difficulty = "NORMAL", question = "Seorang lulusan SMA memilih kuliah daripada menerima tawaran kerja bergaji Rp4.000.000 per bulan. Biaya peluangnya adalah...",
            optionA = "Biaya transportasi harian", optionB = "Biaya uang kuliah per semester", optionC = "Biaya tempat tinggal kost", optionD = "Gaji Rp4.000.000 per bulan yang dikorbankan",
            answer = "D", explanation = "Opportunity cost adalah nilai kesempatan terbaik yang harus dilepaskan karena memilih alternatif lain.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_003", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Harga Keseimbangan",
            difficulty = "NORMAL", question = "Titik keseimbangan pasar (ekuilibrium) tercapai ketika...",
            optionA = "Jumlah barang yang diminta sama dengan jumlah barang yang ditawarkan (Qd = Qs)", optionB = "Harga jual barang mencapai titik tertinggi", optionC = "Produsen menghentikan proses produksi", optionD = "Pemerintah menetapkan harga batas atas",
            answer = "A", explanation = "Ekuilibrium adalah titik temu kurva permintaan dan penawaran di mana pasar berada pada kondisi stabil.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_004", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Elastisitas Permintaan",
            difficulty = "NORMAL", question = "Barang-barang kebutuhan pokok pangan (seperti beras dan garam) umumnya memiliki sifat elastisitas permintaan...",
            optionA = "Elastis (E > 1)", optionB = "Inelastis (E < 1)", optionC = "Elastis uniter (E = 1)", optionD = "Elastis sempurna (E = \u221E)",
            answer = "B", explanation = "Perubahan harga beras tidak banyak mengubah jumlah konsumsi karena beras sangat vital dan sulit digantikan.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_005", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Sistem Ekonomi Pancasila",
            difficulty = "NORMAL", question = "Ciri khas sistem ekonomi Indonesia yang berlandaskan Pasal 33 UUD 1945 adalah...",
            optionA = "Sentralisasi komando total oleh otoritas negara", optionB = "Monopoli swasta mutlak tanpa campur tangan pemerintah", optionC = "Berasaskan kekeluargaan dan cabang produksi penting dikuasai negara untuk kemakmuran rakyat", optionD = "Persaingan bebas tanpa batas aturan moral",
            answer = "C", explanation = "Sistem Ekonomi Pancasila mengutamakan keadilan sosial, koperasi, dan penguasaan bumi/air oleh negara demi hajat hidup orang banyak.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 2: Sosiologi: Mobilitas Sosial & Nilai Budaya (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_SOS_006", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Mobilitas Vertikal",
            difficulty = "NORMAL", question = "Seorang anak petani sukses menuntaskan pendidikan kedokteran dan diangkat menjadi direktur rumah sakit. Ini merupakan contoh mobilitas...",
            optionA = "Geografis", optionB = "Vertikal ke bawah (Social Sinking)", optionC = "Horizontal", optionD = "Vertikal ke atas (Social Climbing)",
            answer = "D", explanation = "Social climbing adalah perpindahan status sosial individu ke lapisan yang lebih tinggi dalam struktur stratifikasi sosial.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_007", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Saluran Mobilitas",
            difficulty = "NORMAL", question = "Lembaga yang paling efektif dan terbuka bagi seluruh lapisan masyarakat sebagai saluran mobilitas sosial adalah...",
            optionA = "Lembaga Pendidikan Formal", optionB = "Organisasi Kekerabatan Trah", optionC = "Kasta Keagamaan", optionD = "Klub Hobi Eksklusif",
            answer = "A", explanation = "Pendidikan membekali ilmu dan keterampilan (meritokrasi) yang memungkinkan siapa pun meningkatkan status hidupnya.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_008", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Nilai dan Norma",
            difficulty = "NORMAL", question = "Norma sosial dengan daya pengikat paling kuat yang sanksinya berupa hukuman pidana formal dari penegak hukum adalah...",
            optionA = "Norma Kebiasaan (Folkways)", optionB = "Norma Hukum (Laws)", optionC = "Norma Tata Kelakuan (Mores)", optionD = "Norma Cara (Usage)",
            answer = "B", explanation = "Norma hukum tertulis memiliki kekuatan memaksa dan sanksi tegas dari aparatur negara berwenang.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_009", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Sosialisasi Sekunder",
            difficulty = "NORMAL", question = "Proses sosialisasi sekunder berlangsung di lingkungan...",
            optionA = "Keluarga batih masa balita", optionB = "Keluarga inti ayah dan ibu", optionC = "Sekolah, teman sebaya (peer group), dan media massa", optionD = "Ruang bersalin rumah sakit",
            answer = "C", explanation = "Sosialisasi sekunder mengenalkan individu pada pergaulan sosial yang lebih luas di luar lingkungan inti keluarga.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_010", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Etnosentrisme",
            difficulty = "NORMAL", question = "Sikap memandang dan menilai kebudayaan kelompok lain secara sepihak hanya menggunakan standar ukuran budayanya sendiri disebut...",
            optionA = "Primordialisme", optionB = "Relativisme Budaya", optionC = "Pluralisme", optionD = "Etnosentrisme",
            answer = "D", explanation = "Etnosentrisme berlebih dapat memicu prasangka, stereotip negatif, dan perpecahan antarsuku dalam masyarakat majemuk.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 3: Ekonomi: Pendapatan Nasional & Kebijakan Inflasi (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_SOS_011", grade = 11, subjectId = "SMA_SOSHUM", topicId = "PDB / GDP",
            difficulty = "HARD", question = "Produk Domestik Bruto (PDB/GDP) menghitung nilai total barang dan jasa akhir yang dihasilkan oleh...",
            optionA = "Seluruh unit produksi di dalam batas wilayah suatu negara selama satu tahun, termasuk warga asing di negara itu", optionB = "Warga negara asli saja, baik di dalam maupun di luar negeri", optionC = "Pemerintah pusat melalui APBN", optionD = "Nilai ekspor neto dikurangi devisa negara",
            answer = "A", explanation = "PDB berbasis wilayah (domestik): memperhitungkan produksi siapa pun yang berada di dalam negeri.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_012", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Kebijakan Moneter",
            difficulty = "HARD", question = "Ketika terjadi inflasi tinggi (harga-harga melonjak), langkah kebijakan moneter kontraktif yang diambil Bank Sentral adalah...",
            optionA = "Menurunkan suku bunga dan mencetak uang baru sebanyak-banyaknya", optionB = "Menaikkan suku bunga acuan (BI-Rate) dan menaikkan cadangan kas wajib bank umum", optionC = "Membeli surat berharga pemerintah di pasar terbuka", optionD = "Mempermudah persyaratan penyaluran kredit konsumtif",
            answer = "B", explanation = "Kenaikan suku bunga menarik minat menabung masyarakat sehingga mengurangi jumlah uang beredar dan meredam laju inflasi.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_013", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Pendapatan Per Kapita",
            difficulty = "HARD", question = "Pendapatan per kapita suatu negara dihitung dengan cara membagi...",
            optionA = "Penerimaan pajak dengan jumlah angkatan kerja", optionB = "Total ekspor dengan total impor", optionC = "Pendapatan Nasional dengan jumlah total penduduk", optionD = "Belanja negara dengan luas wilayah",
            answer = "C", explanation = "Pendapatan per kapita merefleksikan rata-rata pendapatan penduduk suatu negara dalam periode satu tahun.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_014", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Kebijakan Fiskal",
            difficulty = "HARD", question = "Instrumen utama pemerintah dalam melaksanakan kebijakan fiskal adalah melalui pengaturan...",
            optionA = "Batas minimum modal pendirian perseroan terbatas", optionB = "Tingkat suku bunga perbankan dan kurs valuta asing", optionC = "Pencetakan uang kartal dan giral", optionD = "Pajak dan Pengeluaran Belanja Negara (APBN)",
            answer = "D", explanation = "Kebijakan fiskal dikelola oleh Kementerian Keuangan lewat instrumen perpajakan dan alokasi anggaran belanja negara.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_015", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Indeks Gini",
            difficulty = "HARD", question = "Rasio Gini (Koefisien Gini) digunakan ekonom untuk mengukur tingkat...",
            optionA = "Ketimpangan distribusi pendapatan masyarakat", optionB = "Pertumbuhan volume ekspor komoditas", optionC = "Efisiensi pengumpulan pajak penghasilan", optionD = "Nilai tukar mata uang domestik",
            answer = "A", explanation = "Nilai rasio Gini berkisar antara 0 (pemerataan sempurna) hingga 1 (ketimpangan absolut).",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 4: Sosiologi: Resolusi Konflik & Integrasi Bangsa (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_SOS_016", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Diferensiasi Sosial",
            difficulty = "HARD", question = "Pengelompokan masyarakat secara horizontal berdasarkan suku, ras, klan, dan agama tanpa membedakan tingkatan status disebut...",
            optionA = "Stratifikasi Sosial", optionB = "Diferensiasi Sosial", optionC = "Polarisasi Politik", optionD = "Hierarki Kekuasaan",
            answer = "B", explanation = "Diferensiasi bersifat kesetaraan horizontal, sedangkan stratifikasi bersifat hierarkis bertingkat (vertikal).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_017", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Integrasi Sosial",
            difficulty = "HARD", question = "Bhinneka Tunggal Ika menjadi pilar utama integrasi nasional Indonesia karena berfungsi sebagai...",
            optionA = "Strategi eliminasi kebudayaan minoritas", optionB = "Alat penyeragaman budaya daerah menjadi satu jenis budaya saja", optionC = "Konsensus nasional yang mengikat keberagaman dalam satu kesatuan identitas bangsa", optionD = "Batasan interaksi antarsuku bangsa",
            answer = "C", explanation = "Semboyan Bhinneka Tunggal Ika mengapresiasi kebhinekaan sebagai kekayaan yang terpadu dalam bingkai NKRI.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_018", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Bentuk Konflik",
            difficulty = "HARD", question = "Kekerasan struktural dalam perspektif sosiologi terjadi apabila...",
            optionA = "Terjadi tawuran pelajar antarsekolah", optionB = "Dua orang berkelahi di jalan raya", optionC = "Pencuri tertangkap tangan oleh warga", optionD = "Sistem sosial atau institusi menempatkan kelompok tertentu dalam ketidakadilan atau diskriminasi terselubung",
            answer = "D", explanation = "Kekerasan struktural lahir dari ketimpangan aturan kelembagaan, bukan benturan fisik langsung antarpribadi.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_019", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Mediasi Konflik",
            difficulty = "HARD", question = "Peran mediator dalam proses mediasi penyelesaian sengketa masyarakat adalah...",
            optionA = "Memfasilitasi dialog dan membantu para pihak menemukan solusi yang disepakati bersama", optionB = "Menghukum pihak yang bersalah di penjara", optionC = "Memutuskan pemenang sengketa secara sepihak", optionD = "Memungut denda ganti rugi materi",
            answer = "A", explanation = "Mediator adalah penengah netral tanpa hak memaksa putusan, bertujuan memulihkan rekonsiliasi para pihak.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_020", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Kearifan Lokal",
            difficulty = "HARD", question = "Tradisi musyawarah mufakat di Nusantara mencerminkan sila Pancasila ke-...",
            optionA = "Sila ke-2", optionB = "Sila ke-4", optionC = "Sila ke-3", optionD = "Sila ke-5",
            answer = "B", explanation = "Kerakyatan yang dipimpin oleh hikmat kebijaksanaan dalam permusyawaratan/perwakilan mengedepankan mufakat.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 5: Akuntansi Neraca & Perdagangan Global (Kelas 12, HARD) ---
        QuestionEntity(
            id = "Q_SMA_SOS_021", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Persamaan Akuntansi",
            difficulty = "HARD", question = "Persamaan dasar akuntansi yang benar adalah...",
            optionA = "Modal = Aset + Utang", optionB = "Aset = Utang - Modal", optionC = "Aset (Harta) = Liabilitas (Utang) + Ekuitas (Modal)", optionD = "Utang = Aset x Modal",
            answer = "C", explanation = "Harta perusahaan selalu seimbang dengan jumlah klaim kreditor (liabilitas) ditambah hak pemilik (ekuitas).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_022", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Jurnal Umum",
            difficulty = "HARD", question = "Transaksi 'Pembelian perlengkapan kantor tunai Rp1.000.000' dicatat pada jurnal umum sebagai...",
            optionA = "Modal (Debit); Kas (Kredit)", optionB = "Kas (Debit) Rp1.000.000; Perlengkapan (Kredit) Rp1.000.000", optionC = "Beban Perlengkapan (Debit); Utang Usaha (Kredit)", optionD = "Perlengkapan Kantor (Debit) Rp1.000.000; Kas (Kredit) Rp1.000.000",
            answer = "D", explanation = "Harta perlengkapan bertambah di sisi Debit, dan harta kas berkurang di sisi Kredit sebesar nilai yang sama.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_023", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Keunggulan Komparatif",
            difficulty = "HARD", question = "Teori Keunggulan Komparatif David Ricardo mendasari terjadinya perdagangan internasional karena...",
            optionA = "Negara berspesialisasi memproduksi barang dengan biaya peluang (opportunity cost) lebih rendah", optionB = "Suatu negara mampu memproduksi semua jenis barang dengan murah", optionC = "Pemerintah melarang seluruh impor produk industri", optionD = "Kedua negara menggunakan mata uang yang persis sama",
            answer = "A", explanation = "Spesialisasi pada keunggulan komparatif memaksimalkan efisiensi produksi global dan menguntungkan kedua belah pihak.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_024", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Neraca Pembayaran",
            difficulty = "HARD", question = "Kondisi neraca perdagangan surplus terjadi jika...",
            optionA = "Nilai impor lebih besar daripada ekspor", optionB = "Nilai ekspor barang lebih besar daripada nilai impor barang", optionC = "Cadangan devisa negara habis", optionD = "Pemerintah menerbitkan surat utang negara",
            answer = "B", explanation = "Surplus neraca perdagangan menghasilkan aliran masuk devisa yang memperkuat stabilitas nilai tukar rupiah.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_SOS_025", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Pasar Modal",
            difficulty = "HARD", question = "Surat berharga bukti kepemilikan atas sebagian modal atau aset suatu perseroan terbuka disebut...",
            optionA = "Deposito berjangka", optionB = "Obligasi", optionC = "Saham", optionD = "Surat Wesel",
            answer = "C", explanation = "Pemegang saham berhak atas dividen laba perusahaan dan hak suara dalam Rapat Umum Pemegang Saham (RUPS).",
            xp = 150, educationLevel = "SMA"
        ),

        // ==========================================
        // === PENGETAHUAN UMUM & BAHASA LANJUT SMA (25 SOAL) ===
        // ==========================================

        // --- Quest 1: Wawasan Kebangsaan & Sejarah Diplomasi RI (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_GEN_001", grade = 10, subjectId = "SMA_GENERAL", topicId = "Politik Bebas Aktif",
            difficulty = "NORMAL", question = "Prinsip dasar politik luar negeri Indonesia yang dirumuskan Drs. Moh. Hatta dalam pidato 'Mendayung Antara Dua Karang' adalah...",
            optionA = "Proteksionisme Mutlak", optionB = "Netral dan Pasif", optionC = "Aliansi Militer Blok Timur", optionD = "Bebas dan Aktif",
            answer = "D", explanation = "Bebas menentukan sikap tanpa terikat blok adidaya, serta aktif memperjuangkan perdamaian dunia abadi.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_002", grade = 10, subjectId = "SMA_GENERAL", topicId = "Konferensi Asia Afrika",
            difficulty = "NORMAL", question = "Konferensi Asia Afrika (KAA) diselenggarakan pada tahun 1955 di kota Bandung dan melahirkan rumusan...",
            optionA = "Dasasila Bandung", optionB = "Deklarasi Djuanda", optionC = "Piagam Jakarta", optionD = "Dekret Presiden",
            answer = "A", explanation = "Dasasila Bandung menjadi pedoman penghormatan hak asasi, kedaulatan negara, dan penentangan terhadap segala bentuk kolonialisme.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_003", grade = 10, subjectId = "SMA_GENERAL", topicId = "Deklarasi Djuanda",
            difficulty = "NORMAL", question = "Deklarasi Djuanda pada 13 Desember 1957 sangat berjasa bagi kedaulatan NKRI karena berhasil memperjuangkan...",
            optionA = "Bantuan ekonomi luar negeri pascaperang", optionB = "Konsep negara kepulauan (Archipelagic State) yang menyatukan laut antarpulau sebagai wilayah kedaulatan utuh RI", optionC = "Pengakuan mata uang rupiah internasional", optionD = "Pembangunan jalan tol lintas Jawa",
            answer = "B", explanation = "Deklarasi Djuanda menghapus hukum kolonial yang menganggap laut antarpulau sebagai laut bebas internasional.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_004", grade = 10, subjectId = "SMA_GENERAL", topicId = "Lembaga Konstitusi",
            difficulty = "NORMAL", question = "Lembaga yudikatif di Indonesia yang berwenang menguji undang-undang terhadap Undang-Undang Dasar 1945 adalah...",
            optionA = "Komisi Yudisial (KY)", optionB = "Mahkamah Agung (MA)", optionC = "Mahkamah Konstitusi (MK)", optionD = "Dewan Perwakilan Rakyat (DPR)",
            answer = "C", explanation = "MK bertugas mengawal konstitusi (the guardian of the constitution) melalui pengujian materiil undang-undang.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_005", grade = 10, subjectId = "SMA_GENERAL", topicId = "Hari Kebangkitan Nasional",
            difficulty = "NORMAL", question = "Hari Kebangkitan Nasional setiap 20 Mei diperingati berdasarkan tonggak berdirinya organisasi modern pertama yaitu...",
            optionA = "Perhimpunan Indonesia", optionB = "Sarekat Dagang Islam", optionC = "Indische Partij", optionD = "Boedi Oetomo (1908)",
            answer = "D", explanation = "Didirikan oleh dr. Soetomo dan mahasiswa STOVIA atas dorongan dr. Wahidin Soedirohoesodo untuk memajukan pendidikan bangsa.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 2: Sains Populer & Terobosan Teknologi Modern (Kelas 10, NORMAL) ---
        QuestionEntity(
            id = "Q_SMA_GEN_006", grade = 10, subjectId = "SMA_GENERAL", topicId = "Kecerdasan Buatan",
            difficulty = "NORMAL", question = "Teknologi komputer yang mampu belajar dari data masukan untuk mengenali pola dan mengambil keputusan mandiri disebut...",
            optionA = "Artificial Intelligence (AI) / Machine Learning", optionB = "Sistem Operasi Disk (DOS)", optionC = "Transistor Analog", optionD = "Mikroprosesor Mekanik",
            answer = "A", explanation = "AI dan Machine Learning memproses data skala besar dengan algoritma jaringan saraf tiruan (neural networks).",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_007", grade = 10, subjectId = "SMA_GENERAL", topicId = "Komputasi Kuantum",
            difficulty = "NORMAL", question = "Unit dasar pemrosesan informasi pada komputer kuantum yang dapat berada dalam kondisi superposisi disebut...",
            optionA = "Byte", optionB = "Qubit (Quantum Bit)", optionC = "Transistor Silikon", optionD = "Nanometer",
            answer = "B", explanation = "Qubit memanfaatkan prinsip kuantum superposisi (bisa bernilai 0 dan 1 sekaligus) untuk memproses kalkulasi eksponensial supercepat.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_008", grade = 10, subjectId = "SMA_GENERAL", topicId = "Energi Terbarukan",
            difficulty = "NORMAL", question = "Pembangkit listrik ramah lingkungan yang memanfaatkan panas dari perut bumi di kawasan vulkanik disebut PLT...",
            optionA = "Bayu (Angin)", optionB = "Surya (Fotovoltaik)", optionC = "Panas Bumi (Geotermal)", optionD = "Nuklir Fisi",
            answer = "C", explanation = "Indonesia memiliki sekitar 40% potensi geotermal dunia karena dilintasi jalur gunung api Cincin Api Pasifik (Ring of Fire).",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_009", grade = 10, subjectId = "SMA_GENERAL", topicId = "Bioteknologi CRISPR",
            difficulty = "NORMAL", question = "Teknologi gunting genetik mutakhir yang memungkinkan ilmuwan menyunting dan memperbaiki untaian DNA spesifik dikenal sebagai...",
            optionA = "Kromatografi Gas", optionB = "Kloning Dolly", optionC = "Polymerase Chain Reaction (PCR)", optionD = "CRISPR-Cas9",
            answer = "D", explanation = "CRISPR-Cas9 merevolusi terapi penyakit genetik dengan mengedit bagian DNA yang cacat dengan presisi tinggi.",
            xp = 130, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_010", grade = 10, subjectId = "SMA_GENERAL", topicId = "Internet of Things",
            difficulty = "NORMAL", question = "Konsep keterhubungan berbagai perangkat fisik (lampu, mobil, sensor) ke jaringan internet untuk berbagi data otomatis disebut...",
            optionA = "Internet of Things (IoT)", optionB = "Cloud Backup", optionC = "Local Area Network", optionD = "Broadband Cable",
            answer = "A", explanation = "IoT memungkinkan otomatisasi rumah pintar, pemantauan pertanian presisi, dan manajemen lalu lintas cerdas di perkotaan.",
            xp = 130, educationLevel = "SMA"
        ),

        // --- Quest 3: English Advanced: Analytical Exposition (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_GEN_011", grade = 11, subjectId = "SMA_GENERAL", topicId = "Analytical Exposition",
            difficulty = "HARD", question = "The primary communicative purpose of an Analytical Exposition text is to...",
            optionA = "Entertain the audience with a fictional story", optionB = "Persuade the reader that a phenomenon or issue is important and warrants attention", optionC = "Instruct someone how to operate a mechanical device", optionD = "Report historical biographies",
            answer = "B", explanation = "Analytical exposition presents arguments to persuade the reader about the validity of a viewpoint or the urgency of an issue.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_012", grade = 11, subjectId = "SMA_GENERAL", topicId = "Conditional Sentence",
            difficulty = "HARD", question = "Choose the grammatically correct Conditional Type 3 sentence:",
            optionA = "If she studies harder, she would have passed the examination.", optionB = "If she studied harder, she will pass the scholarship examination.", optionC = "If she had studied harder, she would have passed the scholarship examination.", optionD = "If she has studied harder, she would pass the examination.",
            answer = "C", explanation = "Type 3 expresses an unreal past condition: If + Past Perfect (had studied), would have + Past Participle (would have passed).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_013", grade = 11, subjectId = "SMA_GENERAL", topicId = "Passive Voice Advanced",
            difficulty = "HARD", question = "Change into passive: 'The environmental committee has launched a new reforestation program.'",
            optionA = "A new reforestation program had been launched by the committee.", optionB = "A new reforestation program was launched by the committee.", optionC = "A new reforestation program is launched by the committee.", optionD = "A new reforestation program has been launched by the environmental committee.",
            answer = "D", explanation = "Present Perfect Passive: Object + has/have + been + Verb 3 (has been launched).",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_014", grade = 11, subjectId = "SMA_GENERAL", topicId = "Cause and Effect",
            difficulty = "HARD", question = "Select the sentence with correct cause-and-effect transition:",
            optionA = "Due to the severe drought, agricultural yields dropped significantly across the region.", optionB = "Because of it rained, the outdoor concert was cancelled.", optionC = "Although the storm, the ship arrived on time.", optionD = "Owing to he was late, he missed the presentation.",
            answer = "A", explanation = "'Due to' is followed by a noun phrase ('the severe drought'), correctly indicating the cause of the drop in yields.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_015", grade = 11, subjectId = "SMA_GENERAL", topicId = "Inference Skill",
            difficulty = "HARD", question = "What does the idiom 'break the ice' mean in an international conference setting?",
            optionA = "Lower the air conditioning temperature", optionB = "Initiate friendly conversation in an awkward or formal situation", optionC = "Cancel the diplomatic session", optionD = "Shatter glass during negotiation",
            answer = "B", explanation = "'Break the ice' means to overcome initial social stiffness and make people feel comfortable talking to each other.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 4: Geopolitik Dunia & Isu Global (Kelas 11, HARD) ---
        QuestionEntity(
            id = "Q_SMA_GEN_016", grade = 11, subjectId = "SMA_GENERAL", topicId = "Dewan Keamanan PBB",
            difficulty = "HARD", question = "Lima anggota tetap Dewan Keamanan Perserikatan Bangsa-Bangsa (PBB) yang memiliki hak veto adalah...",
            optionA = "Rusia, Tiongkok, India, Brasil, dan Afrika Selatan", optionB = "Amerika Serikat, Jerman, Jepang, Tiongkok, dan Inggris", optionC = "Amerika Serikat, Rusia, Tiongkok, Inggris, dan Prancis", optionD = "Amerika Serikat, Kanada, Australia, Prancis, dan Italia",
            answer = "C", explanation = "Hak veto memberikan kewenangan bagi 5 negara anggota tetap (P5) untuk membatalkan draf resolusi Dewan Keamanan PBB.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_017", grade = 11, subjectId = "SMA_GENERAL", topicId = "Perjanjian Paris",
            difficulty = "HARD", question = "Kesepakatan global Paris Agreement (2015) bertujuan untuk menahan kenaikan suhu rata-rata bumi di bawah...",
            optionA = "10.0°C sepanjang abad ke-21", optionB = "5.0°C di atas tingkat praindustri", optionC = "0.5°C di bawah nol", optionD = "2.0°C (dengan upaya menekan hingga 1.5°C) di atas tingkat praindustri",
            answer = "D", explanation = "Paris Agreement mengikat negara-negara dunia membatasi emisi gas rumah kaca guna mencegah bencana iklim katastropik.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_018", grade = 11, subjectId = "SMA_GENERAL", topicId = "G20",
            difficulty = "HARD", question = "Forum kerjasama multilateral G20 merepresentasikan kekuatan ekonomi global sebesar sekitar...",
            optionA = "80% dari PDB dunia dan 75% dari perdagangan internasional", optionB = "20% dari populasi global", optionC = "50% dari negara-negara kepulauan saja", optionD = "100% seluruh negara berdaulat di bumi",
            answer = "A", explanation = "G20 menghimpun 19 negara ekonomi utama ditambah Uni Eropa dan Uni Afrika sebagai motor penggerak stabilitas keuangan dunia.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_019", grade = 11, subjectId = "SMA_GENERAL", topicId = "Piramida Penduduk",
            difficulty = "HARD", question = "Bonus demografi yang dialami Indonesia terjadi ketika...",
            optionA = "Tingkat kelahiran bayi melonjak dua kali lipat", optionB = "Jumlah penduduk usia produktif (15-64 tahun) lebih besar dibandingkan usia nonproduktif", optionC = "Jumlah lansia melebihi jumlah anak muda", optionD = "Tingkat migrasi ke luar negeri meningkat tajam",
            answer = "B", explanation = "Bonus demografi menjadi peluang emas percepatan pertumbuhan ekonomi jika didukung kualitas pendidikan dan kesehatan prima.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_020", grade = 11, subjectId = "SMA_GENERAL", topicId = "SDGs",
            difficulty = "HARD", question = "Tujuan Pembangunan Berkelanjutan (Sustainable Development Goals / SDGs) memuat berapa pilar tujuan utama?",
            optionA = "8 Goals", optionB = "10 Goals", optionC = "17 Goals", optionD = "25 Goals",
            answer = "C", explanation = "Agenda 2030 SDGs memuat 17 tujuan global seperti pengentasan kemiskinan, pendidikan bermutu, energi bersih, dan aksi iklim.",
            xp = 150, educationLevel = "SMA"
        ),

        // --- Quest 5: Logika Penalaran Kritis & Pemikiran Ilmiah (Kelas 12, HARD) ---
        QuestionEntity(
            id = "Q_SMA_GEN_021", grade = 12, subjectId = "SMA_GENERAL", topicId = "Sesat Pikir",
            difficulty = "HARD", question = "Kesesatan berpikir (logical fallacy) berupa menyerang pribadi lawan debat alih-alih membantah argumennya disebut...",
            optionA = "False Dilemma", optionB = "Strawman Fallacy", optionC = "Appeal to False Authority", optionD = "Argumentum ad Hominem",
            answer = "D", explanation = "Ad hominem mengalihkan substansi perdebatan dengan mendiskreditkan karakter, fisik, atau latar belakang pribadi lawan bicara.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_022", grade = 12, subjectId = "SMA_GENERAL", topicId = "Penalaran Deduktif",
            difficulty = "HARD", question = "Premis Mayor: 'Semua logam menghantarkan panas.' Premis Minor: 'Tembaga adalah logam.' Kesimpulan logisnya adalah...",
            optionA = "Tembaga menghantarkan panas.", optionB = "Sebagian logam adalah tembaga panas.", optionC = "Semua penghantar panas adalah tembaga.", optionD = "Tembaga tidak menghantarkan listrik.",
            answer = "A", explanation = "Silogisme kategoris deduktif menarik simpulan khusus dari kebenaran premis umum yang telah terbukti.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_023", grade = 12, subjectId = "SMA_GENERAL", topicId = "Metode Ilmiah",
            difficulty = "HARD", question = "Langkah pertama yang sistematis dalam melakukan penelitian ilmiah adalah...",
            optionA = "Menarik kesimpulan akhir", optionB = "Merumuskan masalah dan mengidentifikasi variabel", optionC = "Mempublikasikan hasil di media sosial", optionD = "Memanipulasi data hasil pengamatan",
            answer = "B", explanation = "Penelitian ilmiah diawali observasi fenomena, merumuskan masalah yang terukur, mengajukan hipotesis, dan mengujinya.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_024", grade = 12, subjectId = "SMA_GENERAL", topicId = "Literasi Media Digital",
            difficulty = "HARD", question = "Langkah paling rasional saat menerima informasi viral di media sosial yang bombastis dan meragukan adalah...",
            optionA = "Menambahkan bumbu opini agar semakin viral", optionB = "Langsung membagikan ke seluruh grup pesan singkat", optionC = "Melakukan verifikasi fakta (fact-checking) ke sumber kredibel sebelum menyebarkan", optionD = "Mempercayai kebenarannya karena banyak yang membagikan",
            answer = "C", explanation = "Kroscek sumber primer, tanggal rilis, dan validitas ahli melindungi kita dari jebakan hoaks dan misinformasi digital.",
            xp = 150, educationLevel = "SMA"
        ),
        QuestionEntity(
            id = "Q_SMA_GEN_025", grade = 12, subjectId = "SMA_GENERAL", topicId = "Prinsip Ockham",
            difficulty = "HARD", question = "Prinsip ilmiah 'Occam's Razor' menyatakan bahwa...",
            optionA = "Pengetahuan hanya diperoleh melalui wahyu mistis", optionB = "Teori yang paling rumit selalu paling akurat", optionC = "Semua percobaan laboratorium harus menggunakan pisau bedah", optionD = "Di antara beberapa hipotesis yang bersaing, penjelasan yang paling sederhana dengan asumsi paling sedikit cenderung benar",
            answer = "D", explanation = "Occam's razor mengajarkan efisiensi logika: jangan menambah asumsi berlebihan jika fenomena dapat diterangkan secara lugas.",
            xp = 150, educationLevel = "SMA"
        )
    )
}
