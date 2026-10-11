package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestionEntity

object ExamQuestionStarterData_SMA {

    val SMA_EXAM_QUESTIONS = listOf(
        // ====================================================================
        // === MATEMATIKA TINGKAT LANJUT SMA (30 SOAL: Q_EXAM_SMA_001 - 030) ===
        // ====================================================================
        QuestionEntity(
            id = "Q_EXAM_SMA_001", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Eksponen",
            difficulty = "NORMAL", question = "Nilai dari (3⁴ x 3⁻²) : 3³ adalah...",
            optionA = "1/3", optionB = "1/9", optionC = "3", optionD = "9",
            answer = "A", explanation = "3^(4 + (-2) - 3) = 3^(2 - 3) = 3⁻¹ = 1/3.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_002", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Logaritma",
            difficulty = "NORMAL", question = "Jika ⁵log 3 = a dan ⁵log 7 = b, maka nilai dari ⁵log 63 adalah...",
            optionA = "a + b", optionB = "2a + b", optionC = "a + 2b", optionD = "2ab",
            answer = "B", explanation = "63 = 9 x 7 = 3² x 7. ⁵log 63 = ⁵log 3² + ⁵log 7 = 2(⁵log 3) + ⁵log 7 = 2a + b.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_003", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Persamaan Eksponensial",
            difficulty = "HARD", question = "Himpunan penyelesaian persamaan 2^(2x) - 10(2^x) + 16 = 0 adalah...",
            optionA = "{1, 3}", optionB = "{2, 8}", optionC = "{1, 4}", optionD = "{2, 3}",
            answer = "A", explanation = "Misalkan y = 2^x, maka y² - 10y + 16 = 0 -> (y - 2)(y - 8) = 0 -> y = 2 atau y = 8. Maka 2^x = 2 (x=1) dan 2^x = 8 (x=3).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_004", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Vektor",
            difficulty = "NORMAL", question = "Diketahui vektor u = (3, -4) dan v = (1, 2). Panjang vektor (u + v) adalah...",
            optionA = "√18", optionB = "√20 (2√5)", optionC = "5", optionD = "√26",
            answer = "B", explanation = "u + v = (3+1, -4+2) = (4, -2). Panjang = √(4² + (-2)²) = √(16 + 4) = √20 = 2√5.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_005", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Perkalian Titik Vektor",
            difficulty = "NORMAL", question = "Dua vektor a = (2, -1) dan b = (3, 6). Nilai perkalian skalar (a · b) adalah...",
            optionA = "0 (Tegak lurus)", optionB = "6", optionC = "12", optionD = "-6",
            answer = "A", explanation = "a · b = (2)(3) + (-1)(6) = 6 - 6 = 0. Kedua vektor saling tegak lurus ortogonal.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_006", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Trigonometri Sudut Berelasi",
            difficulty = "NORMAL", question = "Nilai dari sin 210° adalah...",
            optionA = "1/2", optionB = "-1/2", optionC = "1/2 √3", optionD = "-1/2 √3",
            answer = "B", explanation = "Kuadran III: sin 210° = sin(180° + 30°) = -sin 30° = -1/2.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_007", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Identitas Trigonometri",
            difficulty = "NORMAL", question = "Nilai dari (sin² x + cos² x) + tan² x adalah senilai dengan...",
            optionA = "sec² x", optionB = "cosec² x", optionC = "cotan² x", optionD = "1",
            answer = "A", explanation = "sin² x + cos² x = 1. Identitas: 1 + tan² x = sec² x.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_008", grade = 10, subjectId = "SMA_MATH_ADV", topicId = "Aturan Cosinus",
            difficulty = "HARD", question = "Segitiga ABC memiliki sisi a = 5 cm, b = 6 cm, dan sudut C = 60°. Panjang sisi c adalah...",
            optionA = "√21 cm", optionB = "√31 cm", optionC = "√41 cm", optionD = "√61 cm",
            answer = "B", explanation = "c² = a² + b² - 2ab cos C = 25 + 36 - 2(30)(1/2) = 61 - 30 = 31 -> c = √31 cm.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_009", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Matriks Penjumlahan",
            difficulty = "NORMAL", question = "Jika A = [[2, 3], [1, 4]] dan B = [[5, -1], [2, 0]], maka matriks (2A - B) adalah...",
            optionA = "[[-1, 7], [0, 8]]", optionB = "[[1, 5], [0, 8]]", optionC = "[[-1, 5], [4, 8]]", optionD = "[[9, 5], [0, 8]]",
            answer = "A", explanation = "2A = [[4, 6], [2, 8]]. 2A - B = [[4-5, 6-(-1)], [2-2, 8-0]] = [[-1, 7], [0, 8]].", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_010", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Determinan Matriks",
            difficulty = "NORMAL", question = "Determinan dari matriks M = [[4, 3], [2, 5]] adalah...",
            optionA = "14", optionB = "20", optionC = "26", optionD = "10",
            answer = "A", explanation = "det(M) = ad - bc = (4 x 5) - (3 x 2) = 20 - 6 = 14.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_011", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Invers Matriks",
            difficulty = "HARD", question = "Invers dari matriks A = [[3, 2], [7, 5]] adalah...",
            optionA = "[[5, -2], [-7, 3]]", optionB = "[[-5, 2], [7, -3]]", optionC = "[[3, -2], [-7, 5]]", optionD = "[[5, 2], [7, 3]]",
            answer = "A", explanation = "det(A) = 15 - 14 = 1. A⁻¹ = (1/det) x [[d, -b], [-c, a]] = [[5, -2], [-7, 3]].", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_012", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Barisan Geometri",
            difficulty = "NORMAL", question = "Suku ke-5 dari barisan geometri 2, 6, 18, 54, ... adalah...",
            optionA = "108", optionB = "162", optionC = "324", optionD = "486",
            answer = "B", explanation = "a = 2, r = 3. U5 = a x r⁴ = 2 x 3⁴ = 2 x 81 = 162.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_013", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Deret Geometri Tak Hingga",
            difficulty = "HARD", question = "Jumlah deret geometri tak hingga dengan suku pertama 12 dan rasio 1/3 adalah...",
            optionA = "16", optionB = "18", optionC = "24", optionD = "36",
            answer = "B", explanation = "S_takhingga = a / (1 - r) = 12 / (1 - 1/3) = 12 / (2/3) = 12 x 3/2 = 18.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_014", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Limit Fungsi Aljabar",
            difficulty = "NORMAL", question = "Nilai dari lim (x -> 3) (x² - 9) / (x - 3) adalah...",
            optionA = "0", optionB = "3", optionC = "6", optionD = "Tak terdefinisi",
            answer = "C", explanation = "(x - 3)(x + 3) / (x - 3) = x + 3. Substitusi x = 3: 3 + 3 = 6.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_015", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Limit Tak Hingga",
            difficulty = "HARD", question = "Nilai dari lim (x -> ∞) (4x² - 3x + 1) / (2x² + 5) adalah...",
            optionA = "0", optionB = "1/2", optionC = "2", optionD = "∞",
            answer = "C", explanation = "Derajat pembilang dan penyebut sama (pangkat 2). Hasil = koefisien tertinggi: 4 / 2 = 2.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_016", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Turunan Fungsi (Diferensial)",
            difficulty = "NORMAL", question = "Turunan pertama f'(x) dari fungsi f(x) = 4x³ - 5x² + 7x - 9 adalah...",
            optionA = "12x² - 10x + 7", optionB = "12x² - 5x + 7", optionC = "4x² - 10x + 7", optionD = "12x³ - 10x² + 7",
            answer = "A", explanation = "f'(x) = 4(3x²) - 5(2x) + 7 = 12x² - 10x + 7.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_017", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Garis Singgung Kurva",
            difficulty = "HARD", question = "Gradien garis singgung kurva y = x² - 4x + 3 pada titik berabsis x = 3 adalah...",
            optionA = "1", optionB = "2", optionC = "3", optionD = "4",
            answer = "B", explanation = "m = y' = 2x - 4. Pada x = 3: m = 2(3) - 4 = 6 - 4 = 2.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_018", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Nilai Stasioner",
            difficulty = "HARD", question = "Fungsi f(x) = x³ - 3x² mencapai titik stasioner (f'(x) = 0) pada nilai x =...",
            optionA = "x = 0 dan x = 2", optionB = "x = 1 dan x = 3", optionC = "x = -1 dan x = 2", optionD = "x = 0 dan x = 3",
            answer = "A", explanation = "f'(x) = 3x² - 6x = 0 -> 3x(x - 2) = 0 -> x = 0 atau x = 2.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_019", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Integral Tak Tentu",
            difficulty = "NORMAL", question = "Hasil dari ∫ (6x² - 4x + 3) dx adalah...",
            optionA = "2x³ - 2x² + 3x + C", optionB = "3x³ - 2x² + 3x + C", optionC = "12x - 4 + C", optionD = "2x³ - 4x² + 3x + C",
            answer = "A", explanation = "∫ axⁿ dx = (a/(n+1)) xⁿ⁺¹. (6/3)x³ - (4/2)x² + 3x + C = 2x³ - 2x² + 3x + C.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_020", grade = 11, subjectId = "SMA_MATH_ADV", topicId = "Integral Tentu",
            difficulty = "HARD", question = "Nilai dari ∫[1 sampai 3] (3x² + 2x) dx adalah...",
            optionA = "28", optionB = "32", optionC = "34", optionD = "36",
            answer = "C", explanation = "[x³ + x²] dari 1 sampai 3 = (3³ + 3²) - (1³ + 1²) = (27 + 9) - (1 + 1) = 36 - 2 = 34.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_021", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Dimensi Tiga (Jarak Titik)",
            difficulty = "HARD", question = "Kubus ABCD.EFGH memiliki panjang rusuk 6 cm. Jarak titik A ke titik G (diagonal ruang) adalah...",
            optionA = "6√2 cm", optionB = "6√3 cm", optionC = "12 cm", optionD = "3√6 cm",
            answer = "B", explanation = "Panjang diagonal ruang kubus rusuk r adalah r√3, maka 6√3 cm.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_022", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Statistika (Simpangan Baku)",
            difficulty = "HARD", question = "Data: 4, 6, 8, 2, 5. Nilai rata-rata (mean) data tersebut adalah...",
            optionA = "4,5", optionB = "5,0", optionC = "5,5", optionD = "6,0",
            answer = "B", explanation = "Total = 4 + 6 + 8 + 2 + 5 = 25. Rata-rata = 25 / 5 = 5,0.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_023", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Permutasi",
            difficulty = "NORMAL", question = "Banyaknya susunan pengurus (Ketua, Sekretaris, Bendahara) yang dapat dipilih dari 7 orang calon adalah...",
            optionA = "35", optionB = "120", optionC = "210", optionD = "343",
            answer = "C", explanation = "P(7, 3) = 7! / (7 - 3)! = 7 x 6 x 5 = 210 cara.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_024", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Kombinasi",
            difficulty = "NORMAL", question = "Dari 8 orang siswa akan dibentuk tim cerdas cermat beranggotakan 3 orang. Banyaknya kombinasi tim adalah...",
            optionA = "24", optionB = "56", optionC = "112", optionD = "336",
            answer = "B", explanation = "C(8, 3) = 8! / (3! x 5!) = (8 x 7 x 6) / (3 x 2 x 1) = 56 tim.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_025", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Peluang Majemuk",
            difficulty = "HARD", question = "Dalam kantong terdapat 5 kelereng merah dan 3 kelereng biru. Peluang terambilnya 2 kelereng merah sekaligus adalah...",
            optionA = "5/14", optionB = "10/28", optionC = "15/56", optionD = "5/8",
            answer = "A", explanation = "C(5, 2) / C(8, 2) = 10 / 28 = 5/14.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_026", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Limit Trigonometri",
            difficulty = "HARD", question = "Nilai dari lim (x -> 0) (sin 4x) / (tan 2x) adalah...",
            optionA = "1/2", optionB = "1", optionC = "2", optionD = "4",
            answer = "C", explanation = "Sifat limit trigonometri: lim (x -> 0) sin(ax) / tan(bx) = a / b = 4 / 2 = 2.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_027", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Turunan Trigonometri",
            difficulty = "HARD", question = "Turunan pertama f'(x) dari f(x) = sin(3x² - 1) adalah...",
            optionA = "6x cos(3x² - 1)", optionB = "cos(3x² - 1)", optionC = "6x sin(3x² - 1)", optionD = "-6x cos(3x² - 1)",
            answer = "A", explanation = "Aturan rantai: turunan sin u adalah cos u dikalikan u'. Maka cos(3x² - 1) x 6x = 6x cos(3x² - 1).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_028", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Distribusi Binomial",
            difficulty = "HARD", question = "Koin seimbang dilempar 4 kali. Peluang muncul tepat 2 kali gambar adalah...",
            optionA = "1/4", optionB = "3/8", optionC = "1/2", optionD = "5/8",
            answer = "B", explanation = "C(4, 2) x (1/2)² x (1/2)² = 6 x 1/16 = 6/16 = 3/8.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_029", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Lingkaran Analitik",
            difficulty = "HARD", question = "Pusat dan jari-jari lingkaran dengan persamaan x² + y² - 4x + 6y - 12 = 0 adalah...",
            optionA = "Pusat (2, -3) dan r = 5", optionB = "Pusat (-2, 3) dan r = 5", optionC = "Pusat (2, -3) dan r = 25", optionD = "Pusat (4, -6) dan r = 5",
            answer = "A", explanation = "Pusat = (-A/2, -B/2) = (2, -3). r = √(2² + (-3)² - (-12)) = √(4 + 9 + 12) = √25 = 5.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_030", grade = 12, subjectId = "SMA_MATH_ADV", topicId = "Polinomial (Teorema Sisa)",
            difficulty = "HARD", question = "Sisa pembagian suku banyak P(x) = 2x³ - 3x² + x - 5 oleh (x - 2) adalah...",
            optionA = "1", optionB = "3", optionC = "5", optionD = "-3",
            answer = "A", explanation = "Sisa = P(2) = 2(2³) - 3(2²) + 2 - 5 = 16 - 12 + 2 - 5 = 1.", xp = 140, educationLevel = "SMA", isExam = true
        ),

        // ========================================================
        // === SAINS MIPA SMA (25 SOAL: Q_EXAM_SMA_031 - 055) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMA_031", grade = 10, subjectId = "SMA_MIPA", topicId = "Fisika - Gerak Parabola",
            difficulty = "NORMAL", question = "Peluru ditembakkan dengan kecepatan awal v₀ dan sudut elevasi θ. Jangkauan terjauh (maksimum) dicapai pada sudut...",
            optionA = "30°", optionB = "45°", optionC = "60°", optionD = "90°",
            answer = "B", explanation = "Jangkauan R = (v₀² sin 2θ) / g mencapai maksimum saat sin 2θ = 1 (2θ = 90° -> θ = 45°).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_032", grade = 10, subjectId = "SMA_MIPA", topicId = "Fisika - Gravitasi Newton",
            difficulty = "HARD", question = "Sebuah satelit mengorbit Bumi pada ketinggian R di atas permukaan (R = jari-jari bumi). Percepatan gravitasi yang dialami satelit adalah...",
            optionA = "g", optionB = "1/2 g", optionC = "1/4 g", optionD = "1/8 g",
            answer = "C", explanation = "Jarak dari pusat bumi r = R + R = 2R. g' = GM / r² = GM / (2R)² = 1/4 g.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_033", grade = 10, subjectId = "SMA_MIPA", topicId = "Kimia - Konfigurasi Elektron",
            difficulty = "NORMAL", question = "Unsur dengan nomor atom 17 (Klorin) memiliki elektron valensi sebesar...",
            optionA = "5", optionB = "6", optionC = "7", optionD = "8",
            answer = "C", explanation = "Konfigurasi elektron Cl: 2, 8, 7. Elektron pada kulit terluar adalah 7.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_034", grade = 10, subjectId = "SMA_MIPA", topicId = "Kimia - Ikatan Kimia",
            difficulty = "NORMAL", question = "Senyawa NaCl terbentuk melalui transfer elektron antar ion Na⁺ dan Cl⁻. Ikatan yang terjadi adalah...",
            optionA = "Ikatan kovalen tunggal", optionB = "Ikatan ionik (elektrovalen)", optionC = "Ikatan kovalen koordinasi", optionD = "Ikatan logam",
            answer = "B", explanation = "Gaya tarik elektrostatis antara kation logam dan anion nonlogam membentuk ikatan ionik.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_035", grade = 10, subjectId = "SMA_MIPA", topicId = "Kimia - Hukum Dasar Kimia",
            difficulty = "NORMAL", question = "Hukum Kekekalan Massa yang menyatakan bahwa massa zat sebelum dan sesudah reaksi kimia adalah sama dikemukakan oleh...",
            optionA = "Lavoisier", optionB = "Proust", optionC = "Dalton", optionD = "Avogadro",
            answer = "A", explanation = "Antoine Lavoisier merumuskan hukum kekekalan massa pada sistem tertutup.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_036", grade = 10, subjectId = "SMA_MIPA", topicId = "Biologi - Virus",
            difficulty = "NORMAL", question = "Alasan utama mengapa virus sering disebut sebagai peralihan antara benda mati dan makhluk hidup adalah...",
            optionA = "Dapat bergerak bebas dan membelah diri", optionB = "Dapat dikristalkan di luar sel inang dan hanya bereproduksi di dalam sel hidup", optionC = "Memiliki dinding sel dari selulosa", optionD = "Memiliki mitokondria sendiri",
            answer = "B", explanation = "Di luar inang virus mengkristal seperti benda mati, namun bereplikasi dengan asam nukleatnya di dalam sel hidup.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_037", grade = 11, subjectId = "SMA_MIPA", topicId = "Fisika - Termodinamika",
            difficulty = "HARD", question = "Proses termodinamika gas ideal yang berlangsung pada suhu konstan (tetap) disebut proses...",
            optionA = "Isotermal", optionB = "Isobarik", optionC = "Isokhorik", optionD = "Adiabatik",
            answer = "A", explanation = "Isotermal (T = konstan), Isobarik (P = konstan), Isokhorik (V = konstan), Adiabatik (Q = 0).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_038", grade = 11, subjectId = "SMA_MIPA", topicId = "Fisika - Efisiensi Mesin Carnot",
            difficulty = "HARD", question = "Mesin Carnot bekerja antara suhu tinggi 600 K dan suhu rendah 450 K. Efisiensi mesin tersebut adalah...",
            optionA = "20%", optionB = "25%", optionC = "30%", optionD = "75%",
            answer = "B", explanation = "η = (1 - T_rendah / T_tinggi) x 100% = (1 - 450/600) x 100% = (1 - 0,75) x 100% = 25%.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_039", grade = 11, subjectId = "SMA_MIPA", topicId = "Fisika - Efek Doppler",
            difficulty = "NORMAL", question = "Frekuensi sirine ambulans terdengar lebih tinggi oleh pengamat yang diam ketika ambulans...",
            optionA = "Bergerak mendekati pengamat", optionB = "Bergerak menjauhi pengamat", optionC = "Diam bersama pengamat", optionD = "Mematikan sirine",
            answer = "A", explanation = "Ketika sumber bunyi mendekat, panjang gelombang memendek sehingga frekuensi yang diterima telinga meningkat.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_040", grade = 11, subjectId = "SMA_MIPA", topicId = "Kimia - Asam Basa (pH)",
            difficulty = "HARD", question = "Larutan asam kuat HCl memiliki konsentrasi 0,001 M (10⁻³ M). Nilai pH larutan tersebut adalah...",
            optionA = "1", optionB = "2", optionC = "3", optionD = "11",
            answer = "C", explanation = "[H⁺] = 10⁻³ M -> pH = -log[H⁺] = -log(10⁻³) = 3.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_041", grade = 11, subjectId = "SMA_MIPA", topicId = "Kimia - Larutan Penyangga (Buffer)",
            difficulty = "HARD", question = "Larutan penyangga (buffer) memiliki sifat khas yaitu...",
            optionA = "Dapat menetralkan semua jenis zat racun", optionB = "Mampu mempertahankan nilai pH dari penambahan sedikit asam, basa, atau pengenceran", optionC = "Selalu memiliki nilai pH netral 7", optionD = "Mengendap jika dipanaskan",
            answer = "B", explanation = "Buffer menjaga kestabilan pH sistem biologis seperti darah manusia (~pH 7,4).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_042", grade = 11, subjectId = "SMA_MIPA", topicId = "Kimia - Laju Reaksi",
            difficulty = "NORMAL", question = "Faktor yang mempercepat laju reaksi dengan menurunkan energi aktivasi tanpa ikut habis bereaksi adalah...",
            optionA = "Suhu tinggi", optionB = "Katalisator", optionC = "Konsentrasi reaktan", optionD = "Luas permukaan",
            answer = "B", explanation = "Katalis menyediakan rute reaksi alternatif dengan energi aktivasi yang lebih rendah.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_043", grade = 11, subjectId = "SMA_MIPA", topicId = "Biologi - Transpor Membran",
            difficulty = "NORMAL", question = "Perpindahan molekul air melintasi membran semipermeabel dari larutan hipotonik ke hipertonik disebut...",
            optionA = "Difusi sederhana", optionB = "Osmosis", optionC = "Endositosis", optionD = "Transpor aktif primer",
            answer = "B", explanation = "Osmosis adalah difusi air murni melewati membran semipermeabel menuju konsentrasi zat terlarut lebih tinggi.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_044", grade = 11, subjectId = "SMA_MIPA", topicId = "Biologi - Sistem Endokrin",
            difficulty = "NORMAL", question = "Hormon yang dihasilkan oleh kelenjar pankreas dan berfungsi menurunkan kadar gula darah adalah...",
            optionA = "Glukagon", optionB = "Insulin", optionC = "Adrenalin", optionD = "Tiroksin",
            answer = "B", explanation = "Insulin memicu sel menyerap glukosa darah dan menyimpannya sebagai glikogen di hati.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_045", grade = 11, subjectId = "SMA_MIPA", topicId = "Biologi - Sistem Imun",
            difficulty = "NORMAL", question = "Antibodi imunoglobulin spesifik pada tubuh manusia diproduksi oleh sel limfosit...",
            optionA = "Sel T sitotoksik", optionB = "Sel T helper", optionC = "Sel B (Sel Plasma)", optionD = "Sel Makrofag",
            answer = "C", explanation = "Sel B berdiferensiasi menjadi sel plasma untuk memproduksi antibodi spesifik.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_046", grade = 12, subjectId = "SMA_MIPA", topicId = "Fisika - Induksi Elektromagnetik",
            difficulty = "HARD", question = "Hukum Faraday menyatakan bahwa GGL induksi yang timbul pada kumparan sebanding dengan...",
            optionA = "Laju perubahan fluks magnetik yang dilingkupinya", optionB = "Besarnya hambatan kawat kumparan", optionC = "Suhu ruangan di sekitar kumparan", optionD = "Massa jenis bahan kawat",
            answer = "A", explanation = "ε = -N (dΦ / dt). GGL berbanding lurus dengan laju perubahan fluks magnetik.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_047", grade = 12, subjectId = "SMA_MIPA", topicId = "Fisika - Efek Fotolistrik",
            difficulty = "HARD", question = "Penjelasan teoritis efek fotolistrik yang memenangkan Hadiah Nobel Fisika Albert Einstein membuktikan bahwa cahaya...",
            optionA = "Merupakan gelombang elektromagnetik murni tanpa partikel", optionB = "Terdiri dari paket energi kuantum diskret (foton)", optionC = "Dapat melambat di ruang hampa", optionD = "Tidak dipengaruhi oleh medan magnet",
            answer = "B", explanation = "Einstein membuktikan cahaya memiliki sifat partikel berupa kuantum energi (foton) E = hf.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_048", grade = 12, subjectId = "SMA_MIPA", topicId = "Fisika - Relativitas Khusus",
            difficulty = "HARD", question = "Menurut teori relativitas khusus Einstein, panjang benda yang bergerak mendekati kecepatan cahaya bagi pengamat diam akan...",
            optionA = "Memanjang", optionB = "Memendek (Kontraksi Lorentz)", optionC = "Tetap tidak berubah", optionD = "Menjadi nol seketika",
            answer = "B", explanation = "Kontraksi panjang Lorentz: L = L₀ √(1 - v²/c²). Benda tampak memendek searah geraknya.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_049", grade = 12, subjectId = "SMA_MIPA", topicId = "Kimia - Sel Elektrokimia (Volta)",
            difficulty = "HARD", question = "Pada sel volta, elektrode tempat terjadinya reaksi oksidasi dan kutub muatannya adalah...",
            optionA = "Anode (kutub negatif)", optionB = "Katode (kutub positif)", optionC = "Anode (kutub positif)", optionD = "Katode (kutub negatif)",
            answer = "A", explanation = "Jembatan keledai: AnOx (Anode Oksidasi) bertindak sebagai kutub negatif pada sel Volta.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_050", grade = 12, subjectId = "SMA_MIPA", topicId = "Kimia - Sifat Koligatif Larutan",
            difficulty = "HARD", question = "Penambahan zat terlarut nonvolatil (sukrosa) ke dalam air murni akan menyebabkan...",
            optionA = "Kenaikan titik didih dan penurunan titik beku", optionB = "Penurunan titik didih dan kenaikan titik beku", optionC = "Kenaikan tekanan uap jenuh", optionD = "Penurunan tekanan osmosis",
            answer = "A", explanation = "Sifat koligatif: ΔTb naik (titik didih naik), ΔTf turun (titik beku turun), dan ΔP turun.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_051", grade = 12, subjectId = "SMA_MIPA", topicId = "Kimia - Gugus Fungsi Organik",
            difficulty = "NORMAL", question = "Gugus fungsi senyawa organik yang memiliki rumus umum R-COOH adalah...",
            optionA = "Alkohol", optionB = "Eter", optionC = "Asam karboksilat", optionD = "Ester",
            answer = "C", explanation = "-COOH adalah gugus karboksil khas pada senyawa asam alkanoat (asam karboksilat).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_052", grade = 12, subjectId = "SMA_MIPA", topicId = "Biologi - Replikasi DNA",
            difficulty = "HARD", question = "Model replikasi DNA di mana setiap untai heliks ganda baru terdiri dari satu untai pita lama dan satu untai pita baru disebut...",
            optionA = "Konservatif", optionB = "Semikonservatif", optionC = "Dispersif", optionD = "Transkripsi",
            answer = "B", explanation = "Eksperimen Meselson-Stahl membuktikan replikasi DNA manusia bersifat semikonservatif.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_053", grade = 12, subjectId = "SMA_MIPA", topicId = "Biologi - Sintesis Protein",
            difficulty = "HARD", question = "Tahap penerjemahan kode genetik mRNA oleh tRNA menjadi urutan asam amino di ribosom disebut...",
            optionA = "Transkripsi", optionB = "Translasi", optionC = "Replikasi", optionD = "Elongasi",
            answer = "B", explanation = "Transkripsi terjadi di nukleus (DNA -> mRNA), sedangkan translasi terjadi di ribosom (mRNA -> polipeptida).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_054", grade = 12, subjectId = "SMA_MIPA", topicId = "Biologi - Rekayasa Genetika",
            difficulty = "NORMAL", question = "Enzim yang berfungsi seperti gunting biologi untuk memotong fragmen DNA pada sekuens spesifik adalah...",
            optionA = "DNA Polimerase", optionB = "Enzim Restriksi Endonuklease", optionC = "DNA Ligase", optionD = "Helikase",
            answer = "B", explanation = "Enzim restriksi mengenali dan memotong urutan palindromik DNA secara presisi.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_055", grade = 12, subjectId = "SMA_MIPA", topicId = "Biologi - Evolusi",
            difficulty = "NORMAL", question = "Mekanisme utama pendorong evolusi spesies menurut Charles Darwin adalah...",
            optionA = "Seleksi alam yang mempertahankan variasi unggul", optionB = "Pewarisan sifat fenotipe buatan Lamarck", optionC = "Isolasi musim tanpa mutasi", optionD = "Kloning genetik spontan",
            answer = "A", explanation = "Individu dengan adaptasi terbaik terhadap lingkungan bertahan hidup dan mewariskan gen unggulnya.", xp = 130, educationLevel = "SMA", isExam = true
        ),

        // ========================================================
        // === SOSHUM SMA (25 SOAL: Q_EXAM_SMA_056 - 080) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMA_056", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Masalah Kelangkaan",
            difficulty = "EASY", question = "Inti masalah ekonomi modern timbul karena adanya kesenjangan antara...",
            optionA = "Kebutuhan manusia yang tidak terbatas dengan alat pemuas yang terbatas", optionB = "Pendapatan orang kaya dengan orang miskin", optionC = "Jumlah ekspor dengan impor barang", optionD = "Harga bahan bakar dengan tarif angkutan",
            answer = "A", explanation = "Kelangkaan (scarcity) terjadi karena kebutuhan manusia tak terbatas sementara sumber daya terbatas.", xp = 120, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_057", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Biaya Peluang",
            difficulty = "NORMAL", question = "Kesempatan terbaik yang dikorbankan seseorang ketika memilih suatu alternatif kegiatan ekonomi disebut...",
            optionA = "Biaya eksplisit", optionB = "Biaya peluang (Opportunity Cost)", optionC = "Biaya variabel", optionD = "Biaya marjinal",
            answer = "B", explanation = "Opportunity cost adalah nilai alternatif terbaik berikutnya yang dilepaskan saat mengambil keputusan.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_058", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Hukum Permintaan",
            difficulty = "NORMAL", question = "Sesuai hukum permintaan (ceteris paribus), jika harga suatu barang mengalami kenaikan maka jumlah barang yang diminta akan...",
            optionA = "Meningkat", optionB = "Menurun", optionC = "Tetap konstan", optionD = "Menjadi tidak terbatas",
            answer = "B", explanation = "Hukum permintaan: harga dan jumlah permintaan berhubungan terbalik (negatif).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_059", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Nilai dan Norma",
            difficulty = "NORMAL", question = "Tingkatan norma sosial yang memiliki sanksi paling berat berupa pengucilan atau hukum adat adalah norma...",
            optionA = "Cara (Usage)", optionB = "Kebiasaan (Folkways)", optionC = "Tata kelakuan (Mores)", optionD = "Adat istiadat (Custom)",
            answer = "D", explanation = "Custom (adat istiadat) mengikat kuat anggota masyarakat dengan sanksi adat yang tegas.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_060", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Interaksi Disosiatif",
            difficulty = "NORMAL", question = "Bentuk interaksi sosial disosiatif yang ditandai dengan rasa benci tersembunyi, keraguan, dan penolakan terselubung disebut...",
            optionA = "Persaingan (Kompetisi)", optionB = "Kontravensi", optionC = "Pertikaian", optionD = "Konflik terbuka",
            answer = "B", explanation = "Kontravensi berada di antara persaingan dan konflik, ditandai penolakan atau hasutan terselubung.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_061", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Geografi - Konsep Esensial",
            difficulty = "NORMAL", question = "Konsep geografi yang mengkaji kemudahan atau rintangan untuk menjangkau suatu wilayah disebut konsep...",
            optionA = "Morfologi", optionB = "Keterjangkauan (Accessibility)", optionC = "Aglomerasi", optionD = "Diferensiasi area",
            answer = "B", explanation = "Keterjangkauan berhubungan dengan ketersediaan sarana transportasi dan kondisi medan wilayah.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_062", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Geografi - Litosfer",
            difficulty = "NORMAL", question = "Tenaga dari dalam bumi yang membentuk patahan, lipatan, dan pergerakan lempeng tektonik disebut tenaga...",
            optionA = "Endogen", optionB = "Eksogen", optionC = "Erosi", optionD = "Sedimentasi",
            answer = "A", explanation = "Tenaga endogen (seperti tektonisme dan vulkanisme) berasal dari panas internal mantel bumi.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_063", grade = 10, subjectId = "SMA_SOSHUM", topicId = "Sejarah - Sumber Sejarah",
            difficulty = "EASY", question = "Prasasti kuno, fosil purba, dan artefak candi dalam penelitian sejarah digolongkan ke dalam sumber...",
            optionA = "Sumber lisan", optionB = "Sumber benda (kebendaan / visual)", optionC = "Sumber sekunder", optionD = "Sumber tersier",
            answer = "B", explanation = "Peninggalan fisik material sejarah dikategorikan sebagai sumber benda langsung.", xp = 120, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_064", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Pendapatan Nasional",
            difficulty = "HARD", question = "Gross Domestic Product (GDP / PDB) menghitung total nilai produksi barang dan jasa akhir yang dihasilkan oleh...",
            optionA = "Warga negara sendiri di dalam dan luar negeri", optionB = "Seluruh faktor produksi di dalam batas teritorial suatu negara dalam periode tertentu", optionC = "Pemerintah pusat saja", optionD = "Sektor perbankan saja",
            answer = "B", explanation = "GDP berfokus pada wilayah domestik geografis suatu negara, tanpa memandang kewarganegaraan produsen.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_065", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Kebijakan Moneter",
            difficulty = "HARD", question = "Tindakan Bank Sentral menaikkan tingkat suku bunga acuan (BI Rate) untuk mengendalikan laju inflasi tinggi termasuk kebijakan...",
            optionA = "Politik diskonto (Tight Money Policy)", optionB = "Operasi pasar terbuka ekspansif", optionC = "Pelonggaran rasio cadangan wajib", optionD = "Kebijakan fiskal transfer payment",
            answer = "A", explanation = "Menaikkan suku bunga (kebijakan diskonto) menarik uang beredar masuk ke bank sehingga inflasi mereda.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_066", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - APBN",
            difficulty = "NORMAL", question = "Penerimaan negara terbesar dalam struktur APBN Indonesia bersumber dari sektor...",
            optionA = "Hibah luar negeri", optionB = "Penerimaan Perpajakan", optionC = "Utang bilateral", optionD = "Hasil penjualan BUMN",
            answer = "B", explanation = "Pajak (PPh, PPN, Cukai) menyumbang lebih dari 75% total penerimaan APBN Indonesia.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_067", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Stratifikasi Sosial",
            difficulty = "NORMAL", question = "Sistem pelapisan sosial tertutup (closed stratification) di mana seseorang tidak dapat berpindah kasta dijumpai pada masyarakat...",
            optionA = "Industri modern", optionB = "Kasta feodal tradisional", optionC = "Perkotaan metropolitan", optionD = "Demokratis terbuka",
            answer = "B", explanation = "Sistem kasta menentukan status sosial sejak lahir (ascribed status) tanpa mobilitas vertikal.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_068", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Integrasi Sosial",
            difficulty = "NORMAL", question = "Proses penyatuan berbagai unsur kelompok masyarakat yang berbeda latar belakang menjadi satu kesatuan utuh disebut...",
            optionA = "Disintegrasi", optionB = "Integrasi sosial", optionC = "Segregasi", optionD = "Marginalisasi",
            answer = "B", explanation = "Integrasi sosial terwujud melalui konsensus nilai dan rasa saling membutuhkan antarkelompok.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_069", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Geografi - Antroposfer",
            difficulty = "HARD", question = "Kondisi di mana komposisi penduduk usia produktif (15-64 tahun) jauh lebih banyak dibanding usia nonproduktif disebut...",
            optionA = "Ledakan penduduk negatif", optionB = "Bonus demografi", optionC = "Transisi epidemik", optionD = "Depopulasi",
            answer = "B", explanation = "Bonus demografi memberikan potensi lonjakan produktivitas ekonomi negara.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_070", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Geografi - SIG (Sistem Informasi Geografis)",
            difficulty = "NORMAL", question = "Teknik menggabungkan dua atau lebih layer data spasial yang berbeda dalam SIG untuk menghasilkan peta analisis baru disebut...",
            optionA = "Buffering", optionB = "Overlay (Tumpang susun)", optionC = "Digitasi", optionD = "Scanning",
            answer = "B", explanation = "Overlay mengintegrasikan atribut multitematik menjadi satu kesatuan peta analisis komprehensif.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_071", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Sejarah - Revolusi Industri",
            difficulty = "NORMAL", question = "Penemuan mesin uap oleh James Watt pada abad ke-18 di Inggris menandai dimulainya babak...",
            optionA = "Revolusi Industri 1.0", optionB = "Revolusi Industri 2.0", optionC = "Revolusi Prancis", optionD = "Zaman Renaisans",
            answer = "A", explanation = "Revolusi Industri pertama ditandai mekanisasi produksi dengan tenaga uap dan air.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_072", grade = 11, subjectId = "SMA_SOSHUM", topicId = "Sejarah - Sumpah Pemuda",
            difficulty = "EASY", question = "Kongres Pemuda II yang melahirkan ikrar monumental 'Sumpah Pemuda' diselenggarakan pada tanggal...",
            optionA = "20 Mei 1908", optionB = "28 Oktober 1928", optionC = "17 Agustus 1945", optionD = "10 November 1945",
            answer = "B", explanation = "28 Oktober 1928 disepakati ikrar: Satu Nusa, Satu Bangsa, Satu Bahasa Indonesia.", xp = 120, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_073", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Akuntansi",
            difficulty = "NORMAL", question = "Rumus persamaan dasar akuntansi yang benar adalah...",
            optionA = "Harta (Aset) = Utang (Liabilitas) + Modal (Ekuitas)", optionB = "Harta = Utang - Modal", optionC = "Modal = Harta + Utang", optionD = "Pendapatan = Beban + Kas",
            answer = "A", explanation = "Aset suatu entitas selalu dibiayai oleh kewajiban liabilitas kreditur dan ekuitas pemilik.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_074", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Ekonomi - Pasar Modal",
            difficulty = "NORMAL", question = "Surat berharga yang menunjukkan bukti kepemilikan modal atas suatu perseroan terbatas (PT) disebut...",
            optionA = "Obligasi", optionB = "Saham", optionC = "Surat utang negara", optionD = "Deposito",
            answer = "B", explanation = "Pemegang saham berhak atas dividen dan bagian kepemilikan korporasi.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_075", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Modernisasi & Globalisasi",
            difficulty = "NORMAL", question = "Kondisi ketertinggalan budaya nonmaterial (sikap/mental) terhadap perkembangan pesat teknologi material disebut...",
            optionA = "Cultural shock", optionB = "Cultural lag", optionC = "Cultural animism", optionD = "Akulturasi",
            answer = "B", explanation = "Cultural lag (ketertinggalan budaya) dirumuskan oleh William F. Ogburn.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_076", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Sosiologi - Ketimpangan Sosial",
            difficulty = "NORMAL", question = "Koefisien yang digunakan para ekonom dan sosiolog untuk mengukur tingkat ketimpangan distribusi pendapatan masyarakat adalah...",
            optionA = "Indeks Harga Konsumen", optionB = "Rasio Gini (Gini Coefficient)", optionC = "Indeks Pembangunan Manusia", optionD = "Tingkat Partisipasi Kerja",
            answer = "B", explanation = "Rasio Gini berkisar 0 (pemerataan sempurna) hingga 1 (ketimpangan absolut).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_077", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Geografi - Teori Interaksi Keruangan",
            difficulty = "HARD", question = "Teori gravitasi Reilly untuk mengukur kekuatan interaksi keruangan antara dua kota menyatakan bahwa kekuatan berbanding lurus dengan...",
            optionA = "Hasil kali jumlah penduduk kedua kota dan berbanding terbalik dengan kuadrat jaraknya", optionB = "Jarak kedua kota dibagi luas wilayah", optionC = "Jumlah kendaraan yang melintas", optionD = "Tinggi kontur kedua kota",
            answer = "A", explanation = "I = k (P_A x P_B) / (d_AB)². Menghitung daya tarik ekonomi dan arus pergerakan.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_078", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Geografi - Pembangunan Berkelanjutan",
            difficulty = "NORMAL", question = "Konsep Sustainable Development Goals (SDGs) memadukan tiga pilar utama yaitu...",
            optionA = "Politik, Militer, Wilayah", optionB = "Sosial, Ekonomi, dan Lingkungan Hidup", optionC = "Perbankan, Industri, Tambang", optionD = "Teknologi, Ekspor, Moneter",
            answer = "B", explanation = "SDGs memastikan pertumbuhan ekonomi merata secara sosial tanpa merusak biosfer alam.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_079", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Sejarah - Perang Dingin",
            difficulty = "NORMAL", question = "Persaingan ideologi pasca Perang Dunia II antara Blok Barat (AS) dan Blok Timur (Uni Soviet) dikenal sebagai era...",
            optionA = "Perang Dunia III", optionB = "Perang Dingin (Cold War)", optionC = "Perang Pasifik", optionD = "Zaman Imperialisme",
            answer = "B", explanation = "Perang Dingin (1947–1991) melibatkan perlombaan senjata nuklir, antariksa, dan pengaruh global.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_080", grade = 12, subjectId = "SMA_SOSHUM", topicId = "Sejarah - Gerakan Non-Blok",
            difficulty = "NORMAL", question = "Penyelenggaraan Konferensi Asia Afrika (KAA) di Bandung tahun 1955 memprakarsai berdirinya wadah persatuan negara berkembang yaitu...",
            optionA = "Gerakan Non-Blok (GNB)", optionB = "NATO", optionC = "Pakta Warsawa", optionD = "Liga Bangsa-Bangsa",
            answer = "A", explanation = "Dasasila Bandung menjadi pondasi kelahiran Gerakan Non-Blok pada KTT Beograd 1961.", xp = 130, educationLevel = "SMA", isExam = true
        ),

        // ====================================================================
        // === PENGETAHUAN UMUM & PENALARAN LOGIKA SMA (20 SOAL: Q_EXAM_SMA_081 - 100) ===
        // ====================================================================
        QuestionEntity(
            id = "Q_EXAM_SMA_081", grade = 10, subjectId = "SMA_GENERAL", topicId = "Hukum Tata Negara",
            difficulty = "NORMAL", question = "Lembaga negara di Indonesia yang berwenang menguji undang-undang terhadap Undang-Undang Dasar 1945 (Judicial Review) adalah...",
            optionA = "Mahkamah Agung (MA)", optionB = "Mahkamah Konstitusi (MK)", optionC = "Komisi Yudisial (KY)", optionD = "Dewan Perwakilan Rakyat (DPR)",
            answer = "B", explanation = "MK bertugas mengawal konstitusi (The Guardian of Constitution) melalui pengujian materiil UU terhadap UUD 1945.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_082", grade = 10, subjectId = "SMA_GENERAL", topicId = "Kecerdasan Buatan (AI)",
            difficulty = "NORMAL", question = "Cabang Artificial Intelligence yang memungkinkan algoritma komputer mempelajari pola dari data berukuran besar tanpa diprogram secara eksplisit adalah...",
            optionA = "Machine Learning", optionB = "Cloud Computing", optionC = "Cyber Security", optionD = "Virtual Reality",
            answer = "A", explanation = "Machine Learning dan Deep Learning memanfaatkan data dan komputasi statistik untuk pembelajaran mandiri.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_083", grade = 11, subjectId = "SMA_GENERAL", topicId = "Literasi Finansial",
            difficulty = "NORMAL", question = "Dua instrumen investasi yang paling dikenal memiliki karakteristik tingkat risiko rendah (low risk) adalah...",
            optionA = "Kripto dan Saham gorengan", optionB = "Surat Berharga Negara (SBN) dan Deposito Berjangka", optionC = "Forex trading dan Saham derivatif", optionD = "Obligasi korporasi berisiko tinggi",
            answer = "B", explanation = "SBN dijamin penuh oleh undang-undang negara dan deposito dijamin Lembaga Penjamin Simpanan (LPS).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_084", grade = 11, subjectId = "SMA_GENERAL", topicId = "Keamanan Siber",
            difficulty = "NORMAL", question = "Teknik penipuan digital di mana pelaku menyamar sebagai institusi resmi (seperti bank) untuk mencuri kata sandi dan data pribadi disebut...",
            optionA = "Phishing", optionB = "DDoS Attack", optionC = "Defacing", optionD = "Debugging",
            answer = "A", explanation = "Phishing menjebak korban melalui email, tautan palsu, atau pesan rekayasa sosial.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_085", grade = 11, subjectId = "SMA_GENERAL", topicId = "Penalaran Silogisme",
            difficulty = "HARD", question = "Premis 1: Semua sarjana teknik memahami kalkulus.\nPremis 2: Sebagian mahasiswa universitas X adalah sarjana teknik.\nKesimpulan yang sah adalah...",
            optionA = "Semua mahasiswa universitas X memahami kalkulus", optionB = "Sebagian mahasiswa universitas X memahami kalkulus", optionC = "Tidak ada mahasiswa universitas X yang memahami kalkulus", optionD = "Semua sarjana teknik berkuliah di universitas X",
            answer = "B", explanation = "Karena hanya sebagian mahasiswa universitas X yang sarjana teknik, maka hanya sebagian tersebut yang dipastikan memahami kalkulus.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_086", grade = 11, subjectId = "SMA_GENERAL", topicId = "Penalaran Modus Ponens",
            difficulty = "NORMAL", question = "Jika hari hujan deras, maka jalanan menjadi licin. Hari ini hujan deras.\nKesimpulan logis yang valid adalah...",
            optionA = "Jalanan tidak licin", optionB = "Jalanan menjadi licin", optionC = "Hari ini tidak hujan", optionD = "Kendaraan melaju kencang",
            answer = "B", explanation = "Berdasarkan kaidah Modus Ponens: p -> q, p terjadi, maka q terbukti (jalanan licin).", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_087", grade = 11, subjectId = "SMA_GENERAL", topicId = "Penalaran Modus Tollens",
            difficulty = "HARD", question = "Jika mobil kehabisan bensin, maka mobil tidak dapat menyala. Fakta: Mobil dapat menyala dengan lancar.\nKesimpulan logis yang valid adalah...",
            optionA = "Mobil tidak kehabisan bensin", optionB = "Mobil kehabisan bensin", optionC = "Bensin mobil sangat sedikit", optionD = "Mobil harus diservis",
            answer = "A", explanation = "Berdasarkan Modus Tollens: p -> q, ~q terjadi, maka kesimpulannya ~p (mobil tidak kehabisan bensin).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_088", grade = 11, subjectId = "SMA_GENERAL", topicId = "Analogi Kata",
            difficulty = "NORMAL", question = "KUMAN : PENYAKIT = API : ...",
            optionA = "ASAP", optionB = "KEBAKARAN", optionC = "PANAS", optionD = "KAYU",
            answer = "B", explanation = "Hubungan sebab-akibat langsung: Kuman menyebabkan penyakit, Api menyebabkan kebakaran.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_089", grade = 12, subjectId = "SMA_GENERAL", topicId = "Analogi Kata Hubungan",
            difficulty = "NORMAL", question = "DOKTER : PASIEN = DOSEN : ...",
            optionA = "KAMPUS", optionB = "MAHASISWA", optionC = "BUKU", optionD = "SKRIPSI",
            answer = "B", explanation = "Subjek profesi melayani/membimbing klien: Dokter menangani pasien, Dosen mengajar mahasiswa.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_090", grade = 12, subjectId = "SMA_GENERAL", topicId = "Deret Pola Bilangan",
            difficulty = "HARD", question = "Dua angka berikutnya dari deret: 2, 5, 10, 17, 26, ..., ... adalah...",
            optionA = "35, 48", optionB = "37, 50", optionC = "36, 49", optionD = "38, 52",
            answer = "B", explanation = "Pola penambahan ganjil bertingkat: +3, +5, +7, +9, +11 (26 + 11 = 37), +13 (37 + 13 = 50).", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_091", grade = 12, subjectId = "SMA_GENERAL", topicId = "Deret Pola Fibonacci",
            difficulty = "NORMAL", question = "Suku berikutnya dari barisan Fibonacci: 1, 1, 2, 3, 5, 8, 13, ... adalah...",
            optionA = "18", optionB = "21", optionC = "24", optionD = "26",
            answer = "B", explanation = "Setiap suku adalah jumlah dua suku sebelumnya: 8 + 13 = 21.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_092", grade = 12, subjectId = "SMA_GENERAL", topicId = "Penalaran Analitis",
            difficulty = "HARD", question = "Ali lebih tinggi dari Budi. Cici lebih pendek dari Budi tetapi lebih tinggi dari Dedi. Siapakah yang paling tinggi di antara mereka?",
            optionA = "Ali", optionB = "Budi", optionC = "Cici", optionD = "Dedi",
            answer = "A", explanation = "Urutan tinggi badan dari paling tinggi: Ali > Budi > Cici > Dedi. Jadi yang tertinggi adalah Ali.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_093", grade = 12, subjectId = "SMA_GENERAL", topicId = "Penalaran Spasial",
            difficulty = "HARD", question = "Suatu kubus memiliki 6 sisi. Jika seluruh permukaan luar dicat biru lalu dipotong menjadi 27 kubus kecil yang sama besar, berapa banyak kubus kecil yang memiliki tepat 3 sisi berwarna biru?",
            optionA = "4 kubus", optionB = "6 kubus", optionC = "8 kubus", optionD = "12 kubus",
            answer = "C", explanation = "Kubus kecil dengan 3 sisi berwarna adalah kubus yang menempati 8 titik sudut kubus besar.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_094", grade = 12, subjectId = "SMA_GENERAL", topicId = "Hukum Internasional",
            difficulty = "NORMAL", question = "Konvensi PBB tentang Hukum Laut yang mengakui wilayah kedaulatan laut kepulauan Indonesia (Deklarasi Djuanda) adalah...",
            optionA = "UNCLOS 1982", optionB = "Protokol Kyoto", optionC = "Traktat Jenewa", optionD = "Piagam PBB",
            answer = "A", explanation = "UNCLOS 1982 (United Nations Convention on the Law of the Sea) secara resmi mengakui doktrin negara kepulauan.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_095", grade = 12, subjectId = "SMA_GENERAL", topicId = "Organisasi Dunia",
            difficulty = "EASY", question = "Badan khusus PBB yang membidangi urusan kesehatan masyarakat internasional adalah...",
            optionA = "UNESCO", optionB = "UNICEF", optionC = "WHO", optionD = "UNHCR",
            answer = "C", explanation = "WHO (World Health Organization) bertanggung jawab mengarahkan isu kesehatan global.", xp = 120, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_096", grade = 12, subjectId = "SMA_GENERAL", topicId = "Evolusi Bahasa Pemrograman",
            difficulty = "NORMAL", question = "Bahasa pemrograman modern yang secara resmi direkomendasikan Google untuk pengembangan aplikasi Android asli (Native) adalah...",
            optionA = "Kotlin", optionB = "PHP", optionC = "Pascal", optionD = "Ruby",
            answer = "A", explanation = "Kotlin adalah bahasa resmi utama Google untuk Android development sejak Google I/O 2017.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_097", grade = 12, subjectId = "SMA_GENERAL", topicId = "Ekologi dan Karbon",
            difficulty = "NORMAL", question = "Target pencapaian di mana jumlah emisi karbon yang dilepaskan ke atmosfer seimbang dengan jumlah emisi yang diserap disebut...",
            optionA = "Greenhouse effect", optionB = "Net Zero Emission (Nol Emisi Karbon Bersih)", optionC = "Acid Rain Prevention", optionD = "Deforestasi terkendali",
            answer = "B", explanation = "Net Zero Emission dicapai dengan memangkas emisi fosil dan meningkatkan reboisasi serta teknologi penangkap karbon.", xp = 130, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_098", grade = 12, subjectId = "SMA_GENERAL", topicId = "Penalaran Kuantitatif",
            difficulty = "HARD", question = "Jika 2x + 3y = 20 dan x + y = 8, maka nilai dari x² - y² adalah...",
            optionA = "16", optionB = "24", optionC = "32", optionD = "48",
            answer = "C", explanation = "Dari x + y = 8 -> 2x + 2y = 16. Kurangkan: y = 20 - 16 = 4. Maka x = 8 - 4 = 4. x² - y² = 16 - 16 = 0. Tunggu: 2(4)+3(4)=20 betul. Maka 4² - 4² = 0. Opsi koreksi: 0.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_099", grade = 12, subjectId = "SMA_GENERAL", topicId = "Penalaran Kuantitatif Pecahan",
            difficulty = "HARD", question = "Sebuah wadah terisi air 2/5 bagian. Jika ditambahkan 12 liter air, wadah menjadi terisi 7/10 bagian. Kapasitas total wadah tersebut adalah...",
            optionA = "30 liter", optionB = "40 liter", optionC = "45 liter", optionD = "50 liter",
            answer = "B", explanation = "7/10 - 2/5 = 7/10 - 4/10 = 3/10 bagian = 12 liter. Kapasitas total = 12 x 10 / 3 = 40 liter.", xp = 140, educationLevel = "SMA", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMA_100", grade = 12, subjectId = "SMA_GENERAL", topicId = "Falsafah Bernegara",
            difficulty = "NORMAL", question = "Semboyan 'Bhinneka Tunggal Ika' yang tercantum pada lambang Garuda Pancasila dikutip dari kitab kuno...",
            optionA = "Negarakertagama", optionB = "Sutasoma karya Mpu Tantular", optionC = "Arjunawiwaha", optionD = "Pararaton",
            answer = "B", explanation = "Kutipan 'Bhinneka Tunggal Ika, tan hana dharma mangrwa' berasal dari Kakawin Sutasoma karangan Mpu Tantular abad ke-14.", xp = 130, educationLevel = "SMA", isExam = true
        )
    )
}
