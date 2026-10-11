package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestionEntity

object ExamQuestionStarterData_SMP {

    val SMP_EXAM_QUESTIONS = listOf(
        // ========================================================
        // === MATEMATIKA SMP (30 SOAL: Q_EXAM_SMP_001 - 030) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMP_001", grade = 7, subjectId = "SMP_MATH", topicId = "Bilangan Bulat",
            difficulty = "EASY", question = "Hasil dari (-18) + 24 : (-4) - (-7) adalah...",
            optionA = "-17", optionB = "-19", optionC = "-5", optionD = "13",
            answer = "A", explanation = "24 : (-4) = -6. Lalu (-18) + (-6) - (-7) = -24 + 7 = -17.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_002", grade = 7, subjectId = "SMP_MATH", topicId = "Operasi Pecahan",
            difficulty = "EASY", question = "Hasil dari 3 1/2 x 4/7 adalah...",
            optionA = "1 1/2", optionB = "2", optionC = "2 1/4", optionD = "2 1/2",
            answer = "B", explanation = "3 1/2 = 7/2. Maka 7/2 x 4/7 = 28/14 = 2.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_003", grade = 7, subjectId = "SMP_MATH", topicId = "Himpunan",
            difficulty = "NORMAL", question = "Jika A = {bilangan prima kurang dari 12}, maka banyaknya anggota himpunan A adalah...",
            optionA = "4", optionB = "5", optionC = "6", optionD = "7",
            answer = "B", explanation = "A = {2, 3, 5, 7, 11}, jumlah anggotanya n(A) = 5.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_004", grade = 7, subjectId = "SMP_MATH", topicId = "Bentuk Aljabar",
            difficulty = "NORMAL", question = "Bentuk sederhana dari 5(2x - 3y) - 3(x - 4y) adalah...",
            optionA = "7x - 3y", optionB = "7x - 27y", optionC = "7x + 3y", optionD = "13x - 3y",
            answer = "A", explanation = "10x - 15y - 3x + 12y = (10x - 3x) + (-15y + 12y) = 7x - 3y.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_005", grade = 7, subjectId = "SMP_MATH", topicId = "Persamaan Linear Satu Variabel",
            difficulty = "NORMAL", question = "Penyelesaian dari persamaan 4x - 7 = 2x + 9 adalah...",
            optionA = "x = 4", optionB = "x = 6", optionC = "x = 8", optionD = "x = 10",
            answer = "C", explanation = "4x - 2x = 9 + 7 -> 2x = 16 -> x = 8.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_006", grade = 7, subjectId = "SMP_MATH", topicId = "Pertidaksamaan Linear",
            difficulty = "NORMAL", question = "Himpunan penyelesaian dari 3x + 2 < 14 untuk x bilangan bulat adalah...",
            optionA = "x < 4", optionB = "x > 4", optionC = "x < 5", optionD = "x ≤ 4",
            answer = "A", explanation = "3x < 14 - 2 -> 3x < 12 -> x < 4.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_007", grade = 7, subjectId = "SMP_MATH", topicId = "Perbandingan Berbalik Nilai",
            difficulty = "NORMAL", question = "Pembangunan gedung dapat diselesaikan oleh 15 pekerja dalam 20 hari. Jika dikerjakan oleh 25 pekerja, waktu yang dibutuhkan adalah...",
            optionA = "10 hari", optionB = "12 hari", optionC = "14 hari", optionD = "16 hari",
            answer = "B", explanation = "Perbandingan berbalik nilai: 15 x 20 = 25 x h -> 300 = 25h -> h = 12 hari.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_008", grade = 7, subjectId = "SMP_MATH", topicId = "Aritmetika Sosial",
            difficulty = "NORMAL", question = "Sebuah barang dibeli seharga Rp 200.000 dan dijual dengan keuntungan 15%. Harga jual barang tersebut adalah...",
            optionA = "Rp 215.000", optionB = "Rp 220.000", optionC = "Rp 230.000", optionD = "Rp 240.000",
            answer = "C", explanation = "Untung = 15% x 200.000 = Rp 30.000. Harga jual = 200.000 + 30.000 = Rp 230.000.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_009", grade = 7, subjectId = "SMP_MATH", topicId = "Sudut",
            difficulty = "NORMAL", question = "Dua sudut saling berpenyiku (komplemen). Jika besar sudut pertama adalah 38°, besar sudut kedua adalah...",
            optionA = "42°", optionB = "52°", optionC = "62°", optionD = "142°",
            answer = "B", explanation = "Sudut berpenyiku berjumlah 90°. Sudut kedua = 90° - 38° = 52°.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_010", grade = 8, subjectId = "SMP_MATH", topicId = "Pola Bilangan",
            difficulty = "NORMAL", question = "Suku ke-10 dari barisan aritmetika 3, 7, 11, 15, ... adalah...",
            optionA = "35", optionB = "37", optionC = "39", optionD = "41",
            answer = "C", explanation = "a = 3, b = 4. U10 = a + (10 - 1)b = 3 + 9(4) = 3 + 36 = 39.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_011", grade = 8, subjectId = "SMP_MATH", topicId = "Koordinat Kartesius",
            difficulty = "EASY", question = "Titik P(-4, 6) terletak pada kuadran...",
            optionA = "Kuadran I", optionB = "Kuadran II", optionC = "Kuadran III", optionD = "Kuadran IV",
            answer = "B", explanation = "Kuadran II memiliki nilai x negatif dan nilai y positif.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_012", grade = 8, subjectId = "SMP_MATH", topicId = "Relasi dan Fungsi",
            difficulty = "NORMAL", question = "Suatu fungsi f(x) = 3x - 5. Nilai dari f(4) adalah...",
            optionA = "5", optionB = "7", optionC = "9", optionD = "11",
            answer = "B", explanation = "f(4) = 3(4) - 5 = 12 - 5 = 7.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_013", grade = 8, subjectId = "SMP_MATH", topicId = "Gradien Garis",
            difficulty = "NORMAL", question = "Gradien garis yang melalui titik (2, 3) dan (6, 11) adalah...",
            optionA = "1", optionB = "2", optionC = "3", optionD = "4",
            answer = "B", explanation = "m = (y2 - y1) / (x2 - x1) = (11 - 3) / (6 - 2) = 8 / 4 = 2.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_014", grade = 8, subjectId = "SMP_MATH", topicId = "SPLDV",
            difficulty = "HARD", question = "Penyelesaian sistem persamaan x + y = 12 dan x - y = 4 adalah...",
            optionA = "x = 7, y = 5", optionB = "x = 8, y = 4", optionC = "x = 9, y = 3", optionD = "x = 6, y = 6",
            answer = "B", explanation = "Jumlahkan kedua persamaan: 2x = 16 -> x = 8. Maka y = 12 - 8 = 4.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_015", grade = 8, subjectId = "SMP_MATH", topicId = "Teorema Pythagoras",
            difficulty = "NORMAL", question = "Panjang sisi siku-siku segitiga adalah 9 cm dan 12 cm. Panjang sisi miringnya adalah...",
            optionA = "13 cm", optionB = "15 cm", optionC = "17 cm", optionD = "21 cm",
            answer = "B", explanation = "c = √(9² + 12²) = √(81 + 144) = √225 = 15 cm.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_016", grade = 8, subjectId = "SMP_MATH", topicId = "Panjang Busur",
            difficulty = "HARD", question = "Lingkaran berjari-jari 14 cm memiliki sudut pusat 90°. Panjang busurnya adalah... (π = 22/7)",
            optionA = "11 cm", optionB = "22 cm", optionC = "44 cm", optionD = "88 cm",
            answer = "B", explanation = "Panjang busur = (90/360) x 2 x 22/7 x 14 = 1/4 x 88 = 22 cm.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_017", grade = 8, subjectId = "SMP_MATH", topicId = "Luas Permukaan Balok",
            difficulty = "NORMAL", question = "Balok berukuran 8 cm x 6 cm x 5 cm. Luas permukaan balok tersebut adalah...",
            optionA = "188 cm²", optionB = "214 cm²", optionC = "236 cm²", optionD = "240 cm²",
            answer = "C", explanation = "L = 2(pl + pt + lt) = 2(48 + 40 + 30) = 2(118) = 236 cm².", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_018", grade = 8, subjectId = "SMP_MATH", topicId = "Peluang Empiris",
            difficulty = "NORMAL", question = "Sebuah dadu bersisi enam dilempar sekali. Peluang munculnya mata dadu faktor dari 6 adalah...",
            optionA = "1/2", optionB = "2/3", optionC = "1/3", optionD = "5/6",
            answer = "B", explanation = "Faktor dari 6 pada dadu: {1, 2, 3, 6} -> ada 4 titik sampel. P = 4/6 = 2/3.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_019", grade = 9, subjectId = "SMP_MATH", topicId = "Perpangkatan",
            difficulty = "NORMAL", question = "Nilai dari 2⁵ x 2⁻² adalah...",
            optionA = "4", optionB = "8", optionC = "16", optionD = "32",
            answer = "B", explanation = "Sifat eksponen: 2^(5 + (-2)) = 2³ = 8.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_020", grade = 9, subjectId = "SMP_MATH", topicId = "Bentuk Akar",
            difficulty = "NORMAL", question = "Bentuk sederhana dari √75 - √12 + √27 adalah...",
            optionA = "4√3", optionB = "5√3", optionC = "6√3", optionD = "8√3",
            answer = "C", explanation = "5√3 - 2√3 + 3√3 = (5 - 2 + 3)√3 = 6√3.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_021", grade = 9, subjectId = "SMP_MATH", topicId = "Merasionalkan Penyebut",
            difficulty = "HARD", question = "Bentuk rasional dari pecahan 6 / √3 adalah...",
            optionA = "2√3", optionB = "3√3", optionC = "6√3", optionD = "√3",
            answer = "A", explanation = "(6 / √3) x (√3 / √3) = 6√3 / 3 = 2√3.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_022", grade = 9, subjectId = "SMP_MATH", topicId = "Persamaan Kuadrat",
            difficulty = "NORMAL", question = "Akar-akar dari persamaan kuadrat x² - 5x + 6 = 0 adalah...",
            optionA = "x = 1 atau x = 6", optionB = "x = 2 atau x = 3", optionC = "x = -2 atau x = -3", optionD = "x = -1 atau x = -6",
            answer = "B", explanation = "(x - 2)(x - 3) = 0 -> x = 2 atau x = 3.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_023", grade = 9, subjectId = "SMP_MATH", topicId = "Diskriminan",
            difficulty = "HARD", question = "Nilai diskriminan (D = b² - 4ac) dari persamaan 2x² + 5x - 3 = 0 adalah...",
            optionA = "1", optionB = "19", optionC = "49", optionD = "51",
            answer = "C", explanation = "D = 5² - 4(2)(-3) = 25 + 24 = 49.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_024", grade = 9, subjectId = "SMP_MATH", topicId = "Titik Puncak Parabola",
            difficulty = "HARD", question = "Sumbu simetri dari fungsi kuadrat f(x) = x² - 6x + 8 adalah...",
            optionA = "x = 2", optionB = "x = 3", optionC = "x = 4", optionD = "x = 6",
            answer = "B", explanation = "Rumus sumbu simetri: x = -b / (2a) = -(-6) / (2 x 1) = 6 / 2 = 3.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_025", grade = 9, subjectId = "SMP_MATH", topicId = "Translasi",
            difficulty = "NORMAL", question = "Titik A(3, -5) ditranslasikan oleh T(2, 4). Koordinat bayangannya adalah...",
            optionA = "A'(5, -1)", optionB = "A'(1, -9)", optionC = "A'(5, 1)", optionD = "A'(-1, -1)",
            answer = "A", explanation = "A' = (3 + 2, -5 + 4) = (5, -1).", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_026", grade = 9, subjectId = "SMP_MATH", topicId = "Refleksi",
            difficulty = "NORMAL", question = "Bayangan titik B(4, 7) jika dicerminkan terhadap sumbu X adalah...",
            optionA = "B'(-4, 7)", optionB = "B'(4, -7)", optionC = "B'(-4, -7)", optionD = "B'(7, 4)",
            answer = "B", explanation = "Refleksi sumbu X memetakan (x, y) -> (x, -y), sehingga menjadi (4, -7).", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_027", grade = 9, subjectId = "SMP_MATH", topicId = "Kesebangunan",
            difficulty = "HARD", question = "Dua segitiga sebangun. Panjang sisi segitiga pertama 6 cm, 8 cm, 10 cm. Jika sisi terpendek segitiga kedua 15 cm, sisi terpanjangnya adalah...",
            optionA = "20 cm", optionB = "24 cm", optionC = "25 cm", optionD = "30 cm",
            answer = "C", explanation = "Faktor skala k = 15/6 = 2,5. Sisi terpanjang kedua = 10 x 2,5 = 25 cm.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_028", grade = 9, subjectId = "SMP_MATH", topicId = "Volume Kerucut",
            difficulty = "HARD", question = "Kerucut memiliki jari-jari 7 cm dan tinggi 12 cm. Volume kerucut tersebut adalah...",
            optionA = "308 cm³", optionB = "616 cm³", optionC = "924 cm³", optionD = "1.848 cm³",
            answer = "B", explanation = "V = 1/3 x π x r² x t = 1/3 x 22/7 x 49 x 12 = 1/3 x 154 x 12 = 616 cm³.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_029", grade = 9, subjectId = "SMP_MATH", topicId = "Volume Bola",
            difficulty = "HARD", question = "Rumus volume bola dengan jari-jari r adalah...",
            optionA = "4/3 π r³", optionB = "4 π r²", optionC = "2/3 π r³", optionD = "1/3 π r³",
            answer = "A", explanation = "Volume bola dirumuskan dengan V = 4/3 π r³.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_030", grade = 8, subjectId = "SMP_MATH", topicId = "Rata-rata Gabungan",
            difficulty = "HARD", question = "Nilai rata-rata 10 siswa adalah 75. Jika ditambah 2 siswa dengan nilai masing-masing 85 dan 95, nilai rata-rata sekarang adalah...",
            optionA = "76,5", optionB = "77,5", optionC = "78,0", optionD = "79,0",
            answer = "B", explanation = "Jumlah awal = 10 x 75 = 750. Ditambah 85 + 95 = 180 -> total 930. Rata-rata = 930 / 12 = 77,5.", xp = 140, educationLevel = "SMP", isExam = true
        ),

        // ========================================================
        // === IPA TERPADU SMP (25 SOAL: Q_EXAM_SMP_031 - 055) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMP_031", grade = 7, subjectId = "SMP_IPA", topicId = "Besaran & Satuan",
            difficulty = "EASY", question = "Besaran pokok dalam Sistem Internasional (SI) yang memiliki satuan Kelvin adalah...",
            optionA = "Massa", optionB = "Waktu", optionC = "Suhu", optionD = "Intensitas cahaya",
            answer = "C", explanation = "Satuan SI untuk suhu mutlak adalah Kelvin (K).", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_032", grade = 7, subjectId = "SMP_IPA", topicId = "Klasifikasi Materi",
            difficulty = "NORMAL", question = "Air garam (larutan garam dapur) dalam klasifikasi materi termasuk ke dalam...",
            optionA = "Unsur", optionB = "Senyawa murni", optionC = "Campuran homogen", optionD = "Campuran heterogen",
            answer = "C", explanation = "Larutan garam partikelnya tercampur merata tanpa batas fasa, sehingga merupakan campuran homogen.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_033", grade = 7, subjectId = "SMP_IPA", topicId = "Kalor & Asas Black",
            difficulty = "HARD", question = "Berapakah kalor yang dibutuhkan untuk menaikkan suhu 2 kg air dari 30°C menjadi 80°C? (c = 4.200 J/kg°C)",
            optionA = "210.000 J", optionB = "420.000 J", optionC = "630.000 J", optionD = "840.000 J",
            answer = "B", explanation = "Q = m x c x ΔT = 2 x 4.200 x (80 - 30) = 8.400 x 50 = 420.000 J.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_034", grade = 7, subjectId = "SMP_IPA", topicId = "Organisasi Kehidupan",
            difficulty = "NORMAL", question = "Urutan hierarki organisasi kehidupan dari yang terkecil hingga terbesar adalah...",
            optionA = "Sel -> Jaringan -> Organ -> Sistem Organ -> Organisme", optionB = "Jaringan -> Sel -> Organ -> Sistem Organ -> Organisme", optionC = "Sel -> Organ -> Jaringan -> Sistem Organ -> Organisme", optionD = "Organisme -> Sistem Organ -> Organ -> Jaringan -> Sel",
            answer = "A", explanation = "Sel berkumpul membentuk jaringan, membentuk organ, membentuk sistem organ, dan menjadi individu organisme.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_035", grade = 7, subjectId = "SMP_IPA", topicId = "Sel Tumbuhan",
            difficulty = "NORMAL", question = "Organel sel yang hanya dijumpai pada sel tumbuhan dan berfungsi menghasilkan makanan adalah...",
            optionA = "Mitokondria", optionB = "Kloroplas", optionC = "Ribosom", optionD = "Sentriol",
            answer = "B", explanation = "Kloroplas mengandung klorofil untuk melangsungkan fotosintesis.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_036", grade = 7, subjectId = "SMP_IPA", topicId = "Pencemaran Air",
            difficulty = "NORMAL", question = "Ledakan populasi alga akibat penumpukan limbah pupuk fosfat di danau disebut peristiwa...",
            optionA = "Biomagnifikasi", optionB = "Eutrofikasi", optionC = "Akumulasi", optionD = "Denitrifikasi",
            answer = "B", explanation = "Eutrofikasi mempercepat pertumbuhan alga yang menyerap oksigen terlarut dan mematikan ikan.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_037", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum Newton",
            difficulty = "NORMAL", question = "Peristiwa penumpang terdorong ke depan saat bus direm mendadak merupakan contoh penerapan Hukum...",
            optionA = "I Newton (Kelembaman)", optionB = "II Newton", optionC = "III Newton (Aksi-Reaksi)", optionD = "Kekekalan Energi",
            answer = "A", explanation = "Hukum I Newton menyatakan benda cenderung mempertahankan keadaan geraknya (inersia).", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_038", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum II Newton",
            difficulty = "NORMAL", question = "Sebuah balok bermassa 5 kg didorong dengan gaya 20 N. Percepatan yang dialami balok adalah...",
            optionA = "2 m/s²", optionB = "4 m/s²", optionC = "5 m/s²", optionD = "100 m/s²",
            answer = "B", explanation = "a = F / m = 20 / 5 = 4 m/s².", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_039", grade = 8, subjectId = "SMP_IPA", topicId = "Pesawat Sederhana",
            difficulty = "NORMAL", question = "Gunting dan tang merupakan contoh pesawat sederhana tuas (pengungkit) jenis ke-...",
            optionA = "Pertama (Titik tumpu di antara titik beban dan kuasa)", optionB = "Kedua (Titik beban di antara tumpu dan kuasa)", optionC = "Ketiga (Titik kuasa di antara tumpu dan beban)", optionD = "Keempat",
            answer = "A", explanation = "Tuas jenis pertama memiliki titik tumpu di tengah antara kuasa dan beban.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_040", grade = 8, subjectId = "SMP_IPA", topicId = "Tekanan Hidrostatis",
            difficulty = "HARD", question = "Penyelam berada pada kedalaman 10 meter di bawah permukaan air (ρ = 1.000 kg/m³, g = 10 m/s²). Tekanan hidrostatisnya adalah...",
            optionA = "1.000 Pa", optionB = "10.000 Pa", optionC = "100.000 Pa", optionD = "1.000.000 Pa",
            answer = "C", explanation = "P = ρ x g x h = 1.000 x 10 x 10 = 100.000 Pa (100 kPa).", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_041", grade = 8, subjectId = "SMP_IPA", topicId = "Hukum Archimedes",
            difficulty = "NORMAL", question = "Suatu benda terapung di air jika...",
            optionA = "Massa jenis benda lebih besar dari massa jenis air", optionB = "Massa jenis benda sama dengan massa jenis air", optionC = "Massa jenis benda lebih kecil dari massa jenis air", optionD = "Gaya berat benda lebih besar dari gaya angkat ke atas",
            answer = "C", explanation = "Benda terapung bila ρ_benda < ρ_cairan.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_042", grade = 8, subjectId = "SMP_IPA", topicId = "Enzim Pencernaan",
            difficulty = "NORMAL", question = "Enzim yang dihasilkan oleh lambung dan berfungsi membunuh kuman serta mengaktifkan pepsinogen adalah...",
            optionA = "Asam Klorida (HCl)", optionB = "Ptialin", optionC = "Lipase", optionD = "Amilase",
            answer = "A", explanation = "Asam klorida (HCl) di lambung menciptakan suasana asam dan membasmi bakteri patogen.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_043", grade = 8, subjectId = "SMP_IPA", topicId = "Sistem Ekskresi",
            difficulty = "HARD", question = "Proses pembentukan urine di nefron ginjal meliputi tiga tahap berurutan yaitu...",
            optionA = "Filtrasi -> Reabsorpsi -> Augmentasi", optionB = "Reabsorpsi -> Filtrasi -> Augmentasi", optionC = "Filtrasi -> Augmentasi -> Reabsorpsi", optionD = "Augmentasi -> Reabsorpsi -> Filtrasi",
            answer = "A", explanation = "Filtrasi (di glomerulus) -> Reabsorpsi (di TKP) -> Augmentasi (di TKD) menghasilkan urine sesungguhnya.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_044", grade = 8, subjectId = "SMP_IPA", topicId = "Getaran & Gelombang",
            difficulty = "NORMAL", question = "Sebuah ayunan melakukan 60 getaran dalam waktu 30 detik. Frekuensi getaran tersebut adalah...",
            optionA = "0,5 Hz", optionB = "2 Hz", optionC = "30 Hz", optionD = "1.800 Hz",
            answer = "B", explanation = "Frekuensi f = n / t = 60 / 30 = 2 Hz.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_045", grade = 8, subjectId = "SMP_IPA", topicId = "Cepat Rambat Gelombang",
            difficulty = "NORMAL", question = "Gelombang dengan panjang gelombang 2 meter memiliki frekuensi 150 Hz. Cepat rambat gelombang tersebut adalah...",
            optionA = "75 m/s", optionB = "152 m/s", optionC = "300 m/s", optionD = "600 m/s",
            answer = "C", explanation = "v = λ x f = 2 x 150 = 300 m/s.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_046", grade = 8, subjectId = "SMP_IPA", topicId = "Cermin & Lensa",
            difficulty = "NORMAL", question = "Sifat bayangan yang selalu dibentuk oleh cermin cembung adalah...",
            optionA = "Maya, tegak, diperkecil", optionB = "Nyata, terbalik, diperkecil", optionC = "Maya, terbalik, diperbesar", optionD = "Nyata, tegak, sama besar",
            answer = "A", explanation = "Cermin cembung (seperti kaca spion) selalu menghasilkan bayangan maya, tegak, dan diperkecil.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_047", grade = 9, subjectId = "SMP_IPA", topicId = "Pembelahan Sel",
            difficulty = "HARD", question = "Pembelahan sel yang menghasilkan 4 sel anakan dengan jumlah kromosom separuh (haploid / n) dari sel induk adalah...",
            optionA = "Mitosis", optionB = "Meiosis", optionC = "Amitosis", optionD = "Fragmentasi",
            answer = "B", explanation = "Meiosis terjadi pada pembentukan sel kelamin (gametogenesis) dan menghasilkan 4 sel haploid.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_048", grade = 9, subjectId = "SMP_IPA", topicId = "Sistem Reproduksi Manusia",
            difficulty = "NORMAL", question = "Tempat terjadinya proses fertilisasi (pembuahan ovum oleh sperma) pada manusia adalah di...",
            optionA = "Ovarium", optionB = "Tuba Fallopii (Oviduk)", optionC = "Uterus (Rahim)", optionD = "Vagina",
            answer = "B", explanation = "Fertilisasi normal berlangsung di saluran tuba fallopii.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_049", grade = 9, subjectId = "SMP_IPA", topicId = "Pewarisan Sifat (Genetika)",
            difficulty = "HARD", question = "Persilangan monohibrid dominan penuh antara BB (bulat) dan bb (keriput) menghasilkan F2 dengan rasio fenotipe...",
            optionA = "1 : 2 : 1", optionB = "3 : 1", optionC = "9 : 3 : 3 : 1", optionD = "2 : 2",
            answer = "B", explanation = "F2 fenotipe: 3 Bulat (BB, Bb, Bb) : 1 Keriput (bb). Rasio 3 : 1.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_050", grade = 9, subjectId = "SMP_IPA", topicId = "Hukum Coulomb",
            difficulty = "HARD", question = "Jika jarak antara dua muatan listrik diperbesar menjadi 2 kali semula, besar gaya tarik/tolak Coulomb menjadi...",
            optionA = "2 kali semula", optionB = "4 kali semula", optionC = "1/2 kali semula", optionD = "1/4 kali semula",
            answer = "D", explanation = "F berbanding terbalik dengan kuadrat jarak (r²). Jika r menjadi 2r, F menjadi 1/(2²) = 1/4 kali semula.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_051", grade = 9, subjectId = "SMP_IPA", topicId = "Hukum Ohm",
            difficulty = "NORMAL", question = "Sebuah lampu memiliki hambatan 20 Ohm dipasang pada tegangan 100 Volt. Kuat arus yang mengalir adalah...",
            optionA = "0,2 A", optionB = "5 A", optionC = "80 A", optionD = "2.000 A",
            answer = "B", explanation = "I = V / R = 100 / 20 = 5 Ampere.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_052", grade = 9, subjectId = "SMP_IPA", topicId = "Daya Listrik",
            difficulty = "NORMAL", question = "Lampu bertuliskan 220V/50W dinyalakan selama 10 jam setiap hari. Energi listrik per hari yang digunakan adalah...",
            optionA = "500 Wh (0,5 kWh)", optionB = "5.000 Wh", optionC = "2.200 Wh", optionD = "50 Wh",
            answer = "A", explanation = "W = P x t = 50 W x 10 jam = 500 Wh = 0,5 kWh.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_053", grade = 9, subjectId = "SMP_IPA", topicId = "Transformator",
            difficulty = "HARD", question = "Sebuah trafo step-down memiliki tegangan primer 220 V dan jumlah lilitan primer 1.100 lilitan. Jika lilitan sekunder 100 lilitan, tegangan sekundernya adalah...",
            optionA = "10 V", optionB = "20 V", optionC = "40 V", optionD = "50 V",
            answer = "B", explanation = "Vs / Vp = Ns / Np -> Vs = 220 x (100 / 1.100) = 220 / 11 = 20 Volt.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_054", grade = 9, subjectId = "SMP_IPA", topicId = "Bioteknologi Konvensional",
            difficulty = "NORMAL", question = "Mikroorganisme yang digunakan dalam pembuatan tempe dari kedelai adalah jamur...",
            optionA = "Saccharomyces cerevisiae", optionB = "Rhizopus oryzae", optionC = "Lactobacillus bulgaricus", optionD = "Aspergillus wentii",
            answer = "B", explanation = "Rhizopus oryzae (jamur tempe) membentuk miselium putih yang merekatkan butir kedelai.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_055", grade = 9, subjectId = "SMP_IPA", topicId = "Zat Aditif Makanan",
            difficulty = "NORMAL", question = "Pemanis sintetis yang biasa digunakan sebagai pengganti gula pasir untuk penderita diabetes adalah...",
            optionA = "Sakarin dan Aspartam", optionB = "Monosodium glutamat (MSG)", optionC = "Tartrazin", optionD = "Natrium benzoat",
            answer = "A", explanation = "Sakarin dan aspartam adalah pemanis buatan berkalori rendah.", xp = 130, educationLevel = "SMP", isExam = true
        ),

        // ========================================================
        // === IPS TERPADU SMP (25 SOAL: Q_EXAM_SMP_056 - 080) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMP_056", grade = 7, subjectId = "SMP_IPS", topicId = "Letak Geografis Indonesia",
            difficulty = "EASY", question = "Secara geografis, Indonesia terletak di antara dua benua dan dua samudera, yaitu...",
            optionA = "Benua Asia - Australia dan Samudera Hindia - Pasifik", optionB = "Benua Asia - Afrika dan Samudera Pasifik - Atlantik", optionC = "Benua Eropa - Asia dan Samudera Hindia - Atlantik", optionD = "Benua Amerika - Asia dan Samudera Hindia - Arktik",
            answer = "A", explanation = "Indonesia diapit Benua Asia dan Benua Australia, serta Samudera Hindia dan Samudera Pasifik.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_057", grade = 7, subjectId = "SMP_IPS", topicId = "Iklim Indonesia",
            difficulty = "EASY", question = "Angin muson barat yang bertiup dari Benua Asia menuju Benua Australia menyebabkan wilayah Indonesia mengalami...",
            optionA = "Musim kemarau", optionB = "Musim hujan", optionC = "Musim pancaroba", optionD = "Musim salju",
            answer = "B", explanation = "Angin muson barat membawa uap air yang banyak dari Laut Natuna/Cina Selatan sehingga terjadi musim hujan.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_058", grade = 7, subjectId = "SMP_IPS", topicId = "Interaksi Sosial",
            difficulty = "NORMAL", question = "Bentuk interaksi sosial asosiatif yang berupa usaha bersama antara orang perorangan atau kelompok untuk mencapai tujuan bersama disebut...",
            optionA = "Akomodasi", optionB = "Kerjasama (Cooperation)", optionC = "Asimilasi", optionD = "Kompetisi",
            answer = "B", explanation = "Kerjasama adalah bentuk interaksi asosiatif untuk mencapai kepentingan bersama.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_059", grade = 7, subjectId = "SMP_IPS", topicId = "Lembaga Sosial",
            difficulty = "NORMAL", question = "Lembaga sosial pertama dan utama tempat seorang anak memperoleh sosialisasi primer nilai dan norma adalah...",
            optionA = "Lembaga pendidikan", optionB = "Lembaga keluarga", optionC = "Lembaga agama", optionD = "Lembaga ekonomi",
            answer = "B", explanation = "Keluarga merupakan media sosialisasi paling awal dan mendasar bagi perkembangan kepribadian anak.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_060", grade = 7, subjectId = "SMP_IPS", topicId = "Kerajaan Hindu-Buddha",
            difficulty = "NORMAL", question = "Kerajaan bercorak Hindu tertua di Indonesia yang dibuktikan dengan penemuan prasasti Yupa adalah...",
            optionA = "Kutai", optionB = "Tarumanegara", optionC = "Sriwijaya", optionD = "Majapahit",
            answer = "A", explanation = "Kerajaan Kutai di Kalimantan Timur (abad ke-4 Masehi) dengan Raja Mulawarman.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_061", grade = 8, subjectId = "SMP_IPS", topicId = "Negara-negara ASEAN",
            difficulty = "EASY", question = "Satu-satunya negara anggota ASEAN yang wilayahnya tidak memiliki garis pantai sama sekali (landlocked country) adalah...",
            optionA = "Kamboja", optionB = "Laos", optionC = "Myanmar", optionD = "Vietnam",
            answer = "B", explanation = "Laos terkurung daratan oleh Vietnam, Thailand, Kamboja, Cina, dan Myanmar.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_062", grade = 8, subjectId = "SMP_IPS", topicId = "Mobilitas Sosial",
            difficulty = "NORMAL", question = "Seorang guru teladan diangkat menjadi kepala sekolah. Peristiwa ini merupakan contoh mobilitas sosial...",
            optionA = "Vertikal ke atas (Social Climbing)", optionB = "Vertikal ke bawah (Social Sinking)", optionC = "Horizontal", optionD = "Antargenerasi menurun",
            answer = "A", explanation = "Kenaikan jabatan dari guru menjadi kepala sekolah meningkatkan status kedudukan sosial (social climbing).", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_063", grade = 8, subjectId = "SMP_IPS", topicId = "Pluralitas Masyarakat",
            difficulty = "NORMAL", question = "Sikap menghormati dan menghargai perbedaan suku, agama, dan budaya di masyarakat disebut...",
            optionA = "Etnosentrisme", optionB = "Toleransi", optionC = "Primordialisme", optionD = "Chauvinisme",
            answer = "B", explanation = "Toleransi adalah keterbukaan dan sikap saling menghargai keberagaman dalam bingkai persatuan.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_064", grade = 8, subjectId = "SMP_IPS", topicId = "Perlawanan Kolonial",
            difficulty = "NORMAL", question = "Perang Diponegoro melawan pemerintah kolonial Belanda berlangsung pada kurun waktu...",
            optionA = "1808 - 1811", optionB = "1825 - 1830", optionC = "1873 - 1904", optionD = "1945 - 1949",
            answer = "B", explanation = "Perang Jawa yang dipimpin Pangeran Diponegoro terjadi pada tahun 1825 hingga 1830.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_065", grade = 8, subjectId = "SMP_IPS", topicId = "Organisasi Pergerakan Nasional",
            difficulty = "NORMAL", question = "Organisasi pergerakan modern pertama di Indonesia yang didirikan pada tanggal 20 Mei 1908 adalah...",
            optionA = "Sarekat Islam", optionB = "Budi Utomo", optionC = "Indische Partij", optionD = "Perhimpunan Indonesia",
            answer = "B", explanation = "Budi Utomo didirikan oleh Dr. Soetomo dkk., kini diperingati sebagai Hari Kebangkitan Nasional.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_066", grade = 8, subjectId = "SMP_IPS", topicId = "Kegiatan Ekonomi",
            difficulty = "NORMAL", question = "Faktor produksi turunan yang berperan menggabungkan dan mengelola faktor-faktor produksi lainnya adalah...",
            optionA = "Alam (Tanah)", optionB = "Tenaga Kerja", optionC = "Kewirausahaan (Keahlian)", optionD = "Modal",
            answer = "C", explanation = "Kewirausahaan (entrepreneurship) bertugas mengelola dan mengkombinasikan seluruh faktor produksi.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_067", grade = 8, subjectId = "SMP_IPS", topicId = "Perdagangan Antarpulau",
            difficulty = "NORMAL", question = "Tujuan utama dilakukannya perdagangan antarpulau atau antardaerah adalah...",
            optionA = "Menciptakan persaingan pasar yang ketat", optionB = "Memperoleh keuntungan dan memperluas jangkauan pasar", optionC = "Menghabiskan stok barang berlebih", optionD = "Mengurangi tenaga kerja",
            answer = "B", explanation = "Perdagangan antarpulau bertujuan memenuhi kebutuhan daerah lain serta memperluas pasar produk.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_068", grade = 9, subjectId = "SMP_IPS", topicId = "Benua di Dunia",
            difficulty = "EASY", question = "Benua terluas di dunia yang juga memiliki jumlah penduduk terbanyak adalah Benua...",
            optionA = "Afrika", optionB = "Amerika", optionC = "Asia", optionD = "Eropa",
            answer = "C", explanation = "Benua Asia mencakup hampir 30% luas daratan bumi dan dihuni lebih dari 4,7 miliar jiwa.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_069", grade = 9, subjectId = "SMP_IPS", topicId = "Terusan Suez",
            difficulty = "NORMAL", question = "Terusan buatan yang menghubungkan Laut Mediterania dengan Laut Merah di Mesir adalah...",
            optionA = "Terusan Panama", optionB = "Terusan Suez", optionC = "Selat Gibraltar", optionD = "Selat Malaka",
            answer = "B", explanation = "Terusan Suez memperpendek rute pelayaran kapal dari Eropa menuju Asia.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_070", grade = 9, subjectId = "SMP_IPS", topicId = "Globalisasi",
            difficulty = "NORMAL", question = "Dampak positif dari terjadinya globalisasi di bidang ilmu pengetahuan dan teknologi adalah...",
            optionA = "Meningkatnya sikap individualisme", optionB = "Kemudahan mengakses informasi edukatif dan riset ilmiah secara cepat", optionC = "Lunturnya budaya lokal", optionD = "Pola hidup konsumtif",
            answer = "B", explanation = "Globalisasi teknologi mempermudah penyebaran ilmu, komunikasi, dan pertukaran riset antarnegara.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_071", grade = 9, subjectId = "SMP_IPS", topicId = "Perubahan Sosial Budaya",
            difficulty = "NORMAL", question = "Faktor pendorong perubahan sosial budaya yang berasal dari dalam masyarakat (internal) adalah...",
            optionA = "Pengaruh bencana alam besar", optionB = "Peperangan dengan negara lain", optionC = "Penemuan baru (inovasi) dan pertambahan penduduk", optionD = "Pengaruh kebudayaan masyarakat luar",
            answer = "C", explanation = "Inovasi teknologi dan demografi penduduk merupakan pendorong perubahan dari dalam masyarakat.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_072", grade = 9, subjectId = "SMP_IPS", topicId = "Ekonomi Kreatif",
            difficulty = "NORMAL", question = "Perekonomian yang berbasis pada pemanfaatan kreativitas, keterampilan, dan bakat individu untuk menciptakan kesejahteraan disebut...",
            optionA = "Ekonomi digital", optionB = "Ekonomi kreatif", optionC = "Ekonomi maritim", optionD = "Ekonomi agraris",
            answer = "B", explanation = "Ekonomi kreatif mengandalkan daya cipta dan kekayaan intelektual (seperti seni, animasi, kuliner, desain).", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_073", grade = 9, subjectId = "SMP_IPS", topicId = "Perdagangan Internasional",
            difficulty = "NORMAL", question = "Kegiatan menjual barang dan jasa dari dalam negeri ke pasar luar negeri disebut kegiatan...",
            optionA = "Impor", optionB = "Ekspor", optionC = "Barter", optionD = "Distribusi",
            answer = "B", explanation = "Ekspor adalah pengiriman dan penjualan komoditas ke luar negeri menghasilkan devisa.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_074", grade = 9, subjectId = "SMP_IPS", topicId = "Kebijakan Tarif",
            difficulty = "HARD", question = "Pajak atau bea yang dikenakan pemerintah terhadap barang-barang impor bertujuan untuk...",
            optionA = "Menurunkan harga barang impor", optionB = "Melindungi produk industri dalam negeri agar tetap berdaya saing", optionC = "Menghilangkan perdagangan internasional", optionD = "Meningkatkan konsumsi barang impor",
            answer = "B", explanation = "Tarif impor memproteksi produsen domestik dari gempuran barang impor murah.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_075", grade = 9, subjectId = "SMP_IPS", topicId = "Proklamasi Kemerdekaan",
            difficulty = "NORMAL", question = "Peristiwa pengamanan Soekarno dan Hatta oleh para pemuda sebelum proklamasi kemerdekaan dikenal dengan peristiwa...",
            optionA = "Rengasdengklok", optionB = "Bandung Lautan Api", optionC = "Ambarawa", optionD = "Medan Area",
            answer = "A", explanation = "Pemuda membawa Soekarno-Hatta ke Rengasdengklok pada 16 Agustus 1945 agar terbebas dari pengaruh Jepang.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_076", grade = 9, subjectId = "SMP_IPS", topicId = "Perjanjian Linggarjati",
            difficulty = "HARD", question = "Dalam Perundingan Linggarjati (1947), Belanda secara de facto hanya mengakui wilayah Republik Indonesia meliputi...",
            optionA = "Jawa, Madura, dan Sumatera", optionB = "Seluruh wilayah bekas Hindia Belanda", optionC = "Jawa dan Bali saja", optionD = "Sumatera dan Kalimantan saja",
            answer = "A", explanation = "Belanda hanya mengakui kedaulatan de facto RI atas pulau Jawa, Madura, dan Sumatera.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_077", grade = 9, subjectId = "SMP_IPS", topicId = "Konferensi Meja Bundar (KMB)",
            difficulty = "HARD", question = "Konferensi Meja Bundar (KMB) tahun 1949 yang menghasilkan penyerahan kedaulatan penuh kepada RIS diselenggarakan di kota...",
            optionA = "Jakarta", optionB = "Den Haag", optionC = "Amsterdam", optionD = "Geneva",
            answer = "B", explanation = "KMB dilaksanakan di Den Haag, Belanda dari Agustus hingga November 1949.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_078", grade = 9, subjectId = "SMP_IPS", topicId = "Uang dan Perbankan",
            difficulty = "NORMAL", question = "Bank yang bertugas memelihara kestabilan nilai rupiah dan mengatur kebijakan moneter di Indonesia adalah...",
            optionA = "Bank Indonesia (Bank Sentral)", optionB = "Bank Mandiri", optionC = "Bank Rakyat Indonesia", optionD = "Otoritas Jasa Keuangan",
            answer = "A", explanation = "Bank Indonesia adalah bank sentral independen yang menjaga kestabilan nilai tukar dan inflasi.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_079", grade = 9, subjectId = "SMP_IPS", topicId = "Pasar Bebas MEA",
            difficulty = "NORMAL", question = "Kawasan perdagangan bebas integrasi ekonomi di kawasan Asia Tenggara disebut...",
            optionA = "AFTA / MEA (Masyarakat Ekonomi ASEAN)", optionB = "APEC", optionC = "NAFTA", optionD = "Uni Eropa",
            answer = "A", explanation = "Masyarakat Ekonomi ASEAN (MEA) mengintegrasikan aliran barang, jasa, dan tenaga kerja antaranggota ASEAN.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_080", grade = 9, subjectId = "SMP_IPS", topicId = "Demokrasi Pancasila",
            difficulty = "EASY", question = "Pengambilan keputusan bersama dalam masyarakat Indonesia mengutamakan prinsip...",
            optionA = "Suara terbanyak mutlak", optionB = "Musyawarah untuk mufakat", optionC = "Keputusan pemimpin tunggal", optionD = "Aklamasi sepihak",
            answer = "B", explanation = "Sila ke-4 Pancasila menjunjung tinggi musyawarah mufakat yang berlandaskan akal sehat.", xp = 120, educationLevel = "SMP", isExam = true
        ),

        // ========================================================
        // === BAHASA INDONESIA SMP (20 SOAL: Q_EXAM_SMP_081 - 100) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SMP_081", grade = 7, subjectId = "SMP_LANG", topicId = "Teks Deskripsi",
            difficulty = "EASY", question = "Ciri utama teks deskripsi yang membedakannya dengan teks lain adalah...",
            optionA = "Menggambarkan objek secara rinci sehingga pembaca seolah merasakan langsung", optionB = "Menyajikan argumen untuk memenangkan debat", optionC = "Memuat data angka dan tabel statistik saja", optionD = "Mengisahkan cerita fiksi tokoh khayalan",
            answer = "A", explanation = "Teks deskripsi melibatkan pancaindra untuk menggambarkan keindahan, bentuk, dan suasana objek.", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_082", grade = 7, subjectId = "SMP_LANG", topicId = "Teks Prosedur",
            difficulty = "NORMAL", question = "Struktur teks prosedur yang runtut terdiri atas...",
            optionA = "Orientasi, Komplikasi, Resolusi", optionB = "Tujuan, Alat/Bahan, Langkah-langkah, Penutup", optionC = "Tesis, Rangkaian Argumen, Rekomendasi", optionD = "Pernyataan Umum, Deretan Penjelas, Interpretasi",
            answer = "B", explanation = "Teks prosedur menjelaskan cara membuat atau melakukan sesuatu secara bertahap.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_083", grade = 7, subjectId = "SMP_LANG", topicId = "Teks Laporan Hasil Observasi (LHO)",
            difficulty = "NORMAL", question = "Teks Laporan Hasil Observasi harus ditulis berdasarkan sifat...",
            optionA = "Subjektif dan emosional", optionB = "Objektif, faktual, dan sistematis", optionC = "Imajinatif dan dramatis", optionD = "Rahasia dan spekulatif",
            answer = "B", explanation = "Teks LHO menyajikan fakta ilmiah apa adanya dari hasil pengamatan lapangan langsung.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_084", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Berita (5W + 1H)",
            difficulty = "NORMAL", question = "Unsur berita yang menerangkan latar belakang penyebab terjadinya suatu peristiwa adalah unsur...",
            optionA = "What (Apa)", optionB = "Where (Di mana)", optionC = "Why (Mengapa)", optionD = "Who (Siapa)",
            answer = "C", explanation = "Unsur 'Why' (Mengapa) menjawab alasan atau sebab terjadinya suatu peristiwa dalam berita.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_085", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Iklan, Slogan, dan Poster",
            difficulty = "EASY", question = "Kalimat pendek yang menarik, mudah diingat, dan digunakan untuk menyampaikan prinsip atau visi disebut...",
            optionA = "Slogan", optionB = "Sinopsis", optionC = "Tajuk rencana", optionD = "Prolog",
            answer = "A", explanation = "Slogan mengutamakan kepadatan makna dan kemudahan diingat (misal: 'Buku adalah jendela dunia').", xp = 120, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_086", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Eksposisi",
            difficulty = "NORMAL", question = "Bagian struktur teks eksposisi yang berisi sudut pandang penulis mengenai topik yang dibahas adalah...",
            optionA = "Tesis (Pernyataan pendapat)", optionB = "Rangkaian argumen", optionC = "Penegasan ulang", optionD = "Resolusi",
            answer = "A", explanation = "Tesis mengawali eksposisi dengan mengemukakan pendapat atau gagasan utama penulis.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_087", grade = 8, subjectId = "SMP_LANG", topicId = "Majas Metafora",
            difficulty = "NORMAL", question = "Contoh kalimat yang menggunakan majas metafora (perbandingan langsung tanpa kata hubung) adalah...",
            optionA = "Raja siang membakar bumi dengan teriknya.", optionB = "Senyumnya manis laksana gula tebu.", optionC = "Ombak menari-nari di bibir pantai.", optionD = "Suaranya halilintar membelah angkasa.",
            answer = "A", explanation = "'Raja siang' merupakan metafora langsung untuk menyebut matahari.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_088", grade = 8, subjectId = "SMP_LANG", topicId = "Puisi Rakyat (Gurindam)",
            difficulty = "HARD", question = "Puisi lama dua baris serima (a-a) yang baris keduanya memuat akibat atau nasihat disebut...",
            optionA = "Syair", optionB = "Gurindam", optionC = "Pantun kilat (Karmina)", optionD = "Talibun",
            answer = "B", explanation = "Gurindam terdiri dari dua baris bersajak sama, baris pertama syarat dan baris kedua jawaban/akibat.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_089", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Ulasan (Resensi)",
            difficulty = "NORMAL", question = "Bagian teks ulasan yang berisi pandangan pengulas mengenai kelebihan dan kekurangan karya disebut...",
            optionA = "Orientasi", optionB = "Tafsiran", optionC = "Evaluasi", optionD = "Rangkuman",
            answer = "C", explanation = "Evaluasi membedah kualitas, keunggulan, serta kelemahan karya buku atau film.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_090", grade = 8, subjectId = "SMP_LANG", topicId = "Teks Persuasi",
            difficulty = "NORMAL", question = "Ciri kebahasaan yang menonjol pada teks persuasi adalah adanya kata-kata ajakan seperti...",
            optionA = "Ayo, mari, hendaknya, sebaiknya", optionB = "Adalah, yaitu, merupakan", optionC = "Kemarin, lusa, sebelumnya", optionD = "Tetapi, sedangkan, melainkan",
            answer = "A", explanation = "Teks persuasi berorientasi mengajak pembaca dengan partikel ajakan dan rekomendasi.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_091", grade = 9, subjectId = "SMP_LANG", topicId = "Teks Laporan Percobaan",
            difficulty = "NORMAL", question = "Ringkasan padat dan menyeluruh mengenai seluruh isi laporan percobaan yang diletakkan di bagian awal disebut...",
            optionA = "Abstrak", optionB = "Lampiran", optionC = "Indeks", optionD = "Glosarium",
            answer = "A", explanation = "Abstrak merangkum latar belakang, metode, hasil utama, dan kesimpulan percobaan secara singkat.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_092", grade = 9, subjectId = "SMP_LANG", topicId = "Pidato Persuasif",
            difficulty = "NORMAL", question = "Metode berpidato yang dilakukan secara spontan tanpa naskah atau persiapan khusus disebut metode...",
            optionA = "Manuskrip (Naskah)", optionB = "Impromptu", optionC = "Ekstemporan", optionD = "Memoriter (Hafalan)",
            answer = "B", explanation = "Metode impromptu dibawakan secara serta-merta tanpa persiapan tertulis sebelumnya.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_093", grade = 9, subjectId = "SMP_LANG", topicId = "Cerpen (Sudut Pandang)",
            difficulty = "NORMAL", question = "Jika pengarang menggunakan kata ganti 'aku' atau 'saya' dalam menceritakan pengalamannya, sudut pandang yang dipakai adalah...",
            optionA = "Orang pertama pelaku utama", optionB = "Orang ketiga serbatahu", optionC = "Orang ketiga pengamat", optionD = "Orang kedua",
            answer = "A", explanation = "Penggunaan 'aku' menjadikan pengarang sebagai orang pertama dalam cerita.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_094", grade = 9, subjectId = "SMP_LANG", topicId = "Teks Tanggapan Kritis",
            difficulty = "HARD", question = "Unsur yang harus diperhatikan dalam menyampaikan kritik yang santun dan membangun adalah...",
            optionA = "Menyerang pribadi pembuat karya", optionB = "Menyertakan alasan logis, data objektif, dan saran perbaikan", optionC = "Menggunakan kata-kata kasar agar diperhatikan", optionD = "Hanya memuji tanpa evaluasi nyata",
            answer = "B", explanation = "Kritik santun fokus pada karya dengan data objektif dan solusi solutif.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_095", grade = 9, subjectId = "SMP_LANG", topicId = "Teks Diskusi",
            difficulty = "NORMAL", question = "Bagian teks diskusi yang memuat argumen yang bertentangan atau tidak sependapat disebut...",
            optionA = "Argumen pro (mendukung)", optionB = "Argumen kontra (menentang)", optionC = "Isu permasalahan", optionD = "Simpulan akhir",
            answer = "B", explanation = "Argumen kontra menyajikan sanggahan dan alasan ketidaksetujuan terhadap suatu isu.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_096", grade = 9, subjectId = "SMP_LANG", topicId = "Cerita Inspiratif",
            difficulty = "NORMAL", question = "Bagian akhir cerita inspiratif yang memuat pesan moral atau simpulan hikmah yang dapat dipetik disebut...",
            optionA = "Orientasi", optionB = "Perumitan peristiwa", optionC = "Komplikasi", optionD = "Koda",
            answer = "D", explanation = "Koda adalah penutup cerita yang berisi pelajaran hidup berharga bagi pembaca.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_097", grade = 9, subjectId = "SMP_LANG", topicId = "Kalimat Efektif & PUEBI",
            difficulty = "HARD", question = "Penulisan gabungan kata yang benar menurut kaidah EYD/PUEBI adalah...",
            optionA = "Tanggung jawab dan mempertanggungjawabkan", optionB = "Tanggungjawab dan mempertanggung jawabkan", optionC = "Tanggung-jawab dan mempertanggungjawabkan", optionD = "Tanggung jawab dan mempertanggung jawabkan",
            answer = "A", explanation = "Ditulis terpisah jika tanpa awalan-akhiran serentak (tanggung jawab), ditulis serangkai jika berimbuhan gabung (mempertanggungjawabkan).", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_098", grade = 9, subjectId = "SMP_LANG", topicId = "Tanda Baca Titik Dua (:)",
            difficulty = "NORMAL", question = "Penggunaan tanda baca titik dua (:) yang tepat adalah...",
            optionA = "Ibu membeli: apel, jeruk, dan mangga.", optionB = "Ibu membeli buah-buahan segar: apel, jeruk, dan mangga.", optionC = "Ibu: membeli apel, jeruk dan mangga.", optionD = "Apel: jeruk dan mangga dibeli ibu.",
            answer = "B", explanation = "Titik dua dipakai pada akhir pernyataan lengkap yang diikuti perincian penjelasan.", xp = 130, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_099", grade = 9, subjectId = "SMP_LANG", topicId = "Kata Serapan",
            difficulty = "HARD", question = "Kata serapan asing di bawah ini yang penulisannya baku menurut kaidah bahasa Indonesia adalah...",
            optionA = "Analisa, metoda, sistim", optionB = "Analisis, metode, sistem", optionC = "Analisa, metode, sistem", optionD = "Analisis, metoda, sistim",
            answer = "B", explanation = "Penyerapan baku: Analysis -> Analisis, Method -> Metode, System -> Sistem.", xp = 140, educationLevel = "SMP", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SMP_100", grade = 9, subjectId = "SMP_LANG", topicId = "Konjungsi Korelatif",
            difficulty = "HARD", question = "Pasangan konjungsi korelatif yang tepat di dalam kalimat adalah...",
            optionA = "Bukan hanya ... melainkan juga ...", optionB = "Tidak hanya ... melainkan juga ...", optionC = "Bukan hanya ... tetapi juga ...", optionD = "Bukan saja ... serta juga ...",
            answer = "A", explanation = "Pasangan baku korelatif: 'Bukan hanya ... melainkan juga ...' dan 'Tidak hanya ... tetapi juga ...'.", xp = 140, educationLevel = "SMP", isExam = true
        )
    )
}
