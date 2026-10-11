package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.QuestionEntity

object ExamQuestionStarterData_SD {

    val SD_EXAM_QUESTIONS = listOf(
        // ========================================================
        // === MATEMATIKA SD (35 SOAL: Q_EXAM_SD_001 - 035) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SD_001", grade = 1, subjectId = "MATH", topicId = "Penjumlahan",
            difficulty = "EASY", question = "Berapakah hasil dari 9 + 8?",
            optionA = "16", optionB = "17", optionC = "18", optionD = "19",
            answer = "B", explanation = "9 + 8 = 17.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_002", grade = 1, subjectId = "MATH", topicId = "Pengurangan",
            difficulty = "EASY", question = "Ibu membawa 15 butir telur, 6 butir pecah di jalan. Sisa telur ibu yang utuh adalah...",
            optionA = "8", optionB = "9", optionC = "10", optionD = "11",
            answer = "B", explanation = "15 - 6 = 9 butir telur.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_003", grade = 1, subjectId = "MATH", topicId = "Urutan Bilangan",
            difficulty = "EASY", question = "Urutan bilangan dari yang terkecil: 12, 7, 19, 15 adalah...",
            optionA = "7, 12, 15, 19", optionB = "7, 15, 12, 19", optionC = "12, 7, 15, 19", optionD = "19, 15, 12, 7",
            answer = "A", explanation = "Urutan dari paling kecil adalah 7, lalu 12, 15, dan 19.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_004", grade = 2, subjectId = "MATH", topicId = "Nilai Tempat",
            difficulty = "EASY", question = "Pada angka 248, angka 4 menempati nilai tempat...",
            optionA = "Satuan", optionB = "Puluhan", optionC = "Ratusan", optionD = "Ribuan",
            answer = "B", explanation = "2 adalah ratusan, 4 adalah puluhan, dan 8 adalah satuan.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_005", grade = 2, subjectId = "MATH", topicId = "Penjumlahan Ratusan",
            difficulty = "EASY", question = "Hasil dari 125 + 134 adalah...",
            optionA = "249", optionB = "259", optionC = "269", optionD = "279",
            answer = "B", explanation = "125 + 134 = 259.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_006", grade = 2, subjectId = "MATH", topicId = "Perkalian Dasar",
            difficulty = "EASY", question = "Ada 4 kantong kelereng. Tiap kantong berisi 6 kelereng. Jumlah seluruh kelereng adalah...",
            optionA = "20", optionB = "24", optionC = "28", optionD = "32",
            answer = "B", explanation = "4 x 6 = 24 butir kelereng.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_007", grade = 2, subjectId = "MATH", topicId = "Bangun Datar",
            difficulty = "EASY", question = "Bangun datar yang memiliki 3 sisi dan 3 titik sudut adalah...",
            optionA = "Persegi", optionB = "Segitiga", optionC = "Lingkaran", optionD = "Persegi Panjang",
            answer = "B", explanation = "Segitiga memiliki 3 sisi dan 3 sudut.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_008", grade = 3, subjectId = "MATH", topicId = "Pembagian",
            difficulty = "EASY", question = "Hasil dari 56 : 7 adalah...",
            optionA = "6", optionB = "7", optionC = "8", optionD = "9",
            answer = "C", explanation = "56 : 7 = 8 karena 8 x 7 = 56.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_009", grade = 3, subjectId = "MATH", topicId = "Satuan Panjang",
            difficulty = "EASY", question = "3 meter sama dengan berapa sentimeter?",
            optionA = "30 cm", optionB = "300 cm", optionC = "3.000 cm", optionD = "30.000 cm",
            answer = "B", explanation = "1 m = 100 cm, maka 3 m = 3 x 100 = 300 cm.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_010", grade = 3, subjectId = "MATH", topicId = "Pecahan Sederhana",
            difficulty = "NORMAL", question = "Pecahan 2/4 senilai dengan pecahan...",
            optionA = "1/2", optionB = "1/3", optionC = "1/4", optionD = "2/3",
            answer = "A", explanation = "Pembilang dan penyebut dibagi 2: 2:2 / 4:2 = 1/2.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_011", grade = 3, subjectId = "MATH", topicId = "Waktu",
            difficulty = "NORMAL", question = "Pukul 07.15 ditambah 45 menit menjadi pukul...",
            optionA = "07.45", optionB = "08.00", optionC = "08.15", optionD = "08.30",
            answer = "B", explanation = "15 menit + 45 menit = 60 menit (1 jam), jadi 07.00 + 1 jam = 08.00.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_012", grade = 4, subjectId = "MATH", topicId = "Keliling Persegi",
            difficulty = "NORMAL", question = "Panjang sisi persegi adalah 8 cm. Keliling persegi tersebut adalah...",
            optionA = "16 cm", optionB = "24 cm", optionC = "32 cm", optionD = "64 cm",
            answer = "C", explanation = "Keliling persegi = 4 x sisi = 4 x 8 = 32 cm.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_013", grade = 4, subjectId = "MATH", topicId = "Luas Persegi Panjang",
            difficulty = "NORMAL", question = "Persegi panjang berukuran panjang 12 cm dan lebar 5 cm. Luasnya adalah...",
            optionA = "17 cm²", optionB = "34 cm²", optionC = "60 cm²", optionD = "70 cm²",
            answer = "C", explanation = "Luas = panjang x lebar = 12 x 5 = 60 cm².", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_014", grade = 4, subjectId = "MATH", topicId = "FPB",
            difficulty = "NORMAL", question = "Faktor Persekutuan Terbesar (FPB) dari 12 dan 18 adalah...",
            optionA = "2", optionB = "3", optionC = "6", optionD = "12",
            answer = "C", explanation = "Faktor 12: 1, 2, 3, 4, 6, 12. Faktor 18: 1, 2, 3, 6, 9, 18. FPB = 6.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_015", grade = 4, subjectId = "MATH", topicId = "KPK",
            difficulty = "NORMAL", question = "Kelipatan Persekutuan Terkecil (KPK) dari 4 dan 6 adalah...",
            optionA = "12", optionB = "16", optionC = "20", optionD = "24",
            answer = "A", explanation = "Kelipatan 4: 4, 8, 12, 16... Kelipatan 6: 6, 12, 18... KPK = 12.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_016", grade = 4, subjectId = "MATH", topicId = "Pecahan Campuran",
            difficulty = "NORMAL", question = "Bentuk pecahan biasa dari 2 3/5 adalah...",
            optionA = "11/5", optionB = "13/5", optionC = "15/5", optionD = "16/5",
            answer = "B", explanation = "(2 x 5) + 3 = 10 + 3 = 13/5.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_017", grade = 5, subjectId = "MATH", topicId = "Operasi Pecahan",
            difficulty = "NORMAL", question = "Hasil dari 1/2 + 2/3 adalah...",
            optionA = "3/5", optionB = "5/6", optionC = "7/6", optionD = "1 1/6",
            answer = "C", explanation = "1/2 + 2/3 = 3/6 + 4/6 = 7/6 (atau 1 1/6).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_018", grade = 5, subjectId = "MATH", topicId = "Perkalian Pecahan",
            difficulty = "NORMAL", question = "Hasil dari 3/4 x 2/5 adalah...",
            optionA = "5/9", optionB = "6/20", optionC = "3/10", optionD = "6/10",
            answer = "C", explanation = "(3 x 2) / (4 x 5) = 6/20 disederhanakan menjadi 3/10.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_019", grade = 5, subjectId = "MATH", topicId = "Kecepatan",
            difficulty = "NORMAL", question = "Sebuah mobil menempuh jarak 120 km dalam waktu 2 jam. Kecepatan rata-rata mobil adalah...",
            optionA = "50 km/jam", optionB = "60 km/jam", optionC = "70 km/jam", optionD = "80 km/jam",
            answer = "B", explanation = "Kecepatan = jarak : waktu = 120 : 2 = 60 km/jam.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_020", grade = 5, subjectId = "MATH", topicId = "Debit",
            difficulty = "NORMAL", question = "Kran air mengalirkan 60 liter air dalam waktu 3 menit. Debit kran tersebut adalah...",
            optionA = "15 liter/menit", optionB = "20 liter/menit", optionC = "25 liter/menit", optionD = "30 liter/menit",
            answer = "B", explanation = "Debit = volume : waktu = 60 : 3 = 20 liter/menit.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_021", grade = 5, subjectId = "MATH", topicId = "Skala Peta",
            difficulty = "NORMAL", question = "Jarak pada peta 4 cm, skala peta 1 : 500.000. Jarak sebenarnya adalah...",
            optionA = "2 km", optionB = "20 km", optionC = "200 km", optionD = "2.000 km",
            answer = "B", explanation = "Jarak = 4 x 500.000 cm = 2.000.000 cm = 20 km.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_022", grade = 5, subjectId = "MATH", topicId = "Volume Kubus",
            difficulty = "NORMAL", question = "Bak penampung air berbentuk kubus memiliki panjang rusuk 10 cm. Volume kubus adalah...",
            optionA = "100 cm³", optionB = "600 cm³", optionC = "1.000 cm³", optionD = "10.000 cm³",
            answer = "C", explanation = "Volume kubus = s x s x s = 10 x 10 x 10 = 1.000 cm³.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_023", grade = 6, subjectId = "MATH", topicId = "Bilangan Bulat Negatif",
            difficulty = "NORMAL", question = "Hasil perhitungan dari -12 + 25 - 8 adalah...",
            optionA = "5", optionB = "-5", optionC = "13", optionD = "21",
            answer = "A", explanation = "-12 + 25 = 13, kemudian 13 - 8 = 5.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_024", grade = 6, subjectId = "MATH", topicId = "Operasi Campuran",
            difficulty = "NORMAL", question = "Hasil dari 250 + 50 x 4 - 100 adalah...",
            optionA = "1.100", optionB = "350", optionC = "450", optionD = "200",
            answer = "B", explanation = "Dahulukan perkalian: 50 x 4 = 200. Lalu 250 + 200 - 100 = 450 - 100 = 350.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_025", grade = 6, subjectId = "MATH", topicId = "Lingkaran",
            difficulty = "NORMAL", question = "Diameter sebuah lingkaran adalah 14 cm. Keliling lingkaran tersebut adalah... (π = 22/7)",
            optionA = "22 cm", optionB = "44 cm", optionC = "88 cm", optionD = "154 cm",
            answer = "B", explanation = "Keliling = π x d = 22/7 x 14 = 44 cm.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_026", grade = 6, subjectId = "MATH", topicId = "Luas Lingkaran",
            difficulty = "NORMAL", question = "Jari-jari lingkaran adalah 7 cm. Luas lingkaran tersebut adalah...",
            optionA = "44 cm²", optionB = "88 cm²", optionC = "154 cm²", optionD = "308 cm²",
            answer = "C", explanation = "Luas = π x r² = 22/7 x 7 x 7 = 154 cm².", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_027", grade = 6, subjectId = "MATH", topicId = "Volume Tabung",
            difficulty = "HARD", question = "Tabung dengan jari-jari alas 7 cm dan tinggi 10 cm memiliki volume sebesar...",
            optionA = "770 cm³", optionB = "1.540 cm³", optionC = "2.200 cm³", optionD = "3.080 cm³",
            answer = "B", explanation = "Volume = π x r² x t = 154 x 10 = 1.540 cm³.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_028", grade = 6, subjectId = "MATH", topicId = "Rata-rata (Mean)",
            difficulty = "HARD", question = "Nilai ulangan matematika Budi: 8, 7, 9, 8, 8. Nilai rata-rata Budi adalah...",
            optionA = "7,5", optionB = "8,0", optionC = "8,2", optionD = "8,5",
            answer = "B", explanation = "Total = 8 + 7 + 9 + 8 + 8 = 40. Mean = 40 : 5 = 8,0.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_029", grade = 6, subjectId = "MATH", topicId = "Modus",
            difficulty = "NORMAL", question = "Data berat badan siswa (kg): 32, 34, 32, 35, 33, 32, 34. Modus dari data tersebut adalah...",
            optionA = "32 kg", optionB = "33 kg", optionC = "34 kg", optionD = "35 kg",
            answer = "A", explanation = "Modus adalah nilai yang paling sering muncul. Angka 32 muncul 3 kali.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_030", grade = 6, subjectId = "MATH", topicId = "Median",
            difficulty = "HARD", question = "Data terurut nilai siswa: 6, 7, 7, 8, 8, 9, 9. Nilai median (nilai tengah) adalah...",
            optionA = "7", optionB = "7,5", optionC = "8", optionD = "8,5",
            answer = "C", explanation = "Ada 7 data ganjil, data tengah ke-4 adalah angka 8.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_031", grade = 5, subjectId = "MATH", topicId = "Perbandingan",
            difficulty = "NORMAL", question = "Perbandingan umur Ali dan Budi adalah 2 : 3. Jika umur Ali 10 tahun, umur Budi adalah...",
            optionA = "12 tahun", optionB = "15 tahun", optionC = "18 tahun", optionD = "20 tahun",
            answer = "B", explanation = "Umur Budi = (3/2) x 10 = 15 tahun.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_032", grade = 6, subjectId = "MATH", topicId = "Akar Pangkat Dua",
            difficulty = "NORMAL", question = "Nilai dari √144 + √81 adalah...",
            optionA = "19", optionB = "20", optionC = "21", optionD = "23",
            answer = "C", explanation = "√144 = 12 dan √81 = 9. 12 + 9 = 21.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_033", grade = 6, subjectId = "MATH", topicId = "Akar Pangkat Tiga",
            difficulty = "HARD", question = "Akar pangkat tiga dari 1.728 adalah...",
            optionA = "11", optionB = "12", optionC = "13", optionD = "14",
            answer = "B", explanation = "12 x 12 x 12 = 144 x 12 = 1.728.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_034", grade = 5, subjectId = "MATH", topicId = "Persentase",
            difficulty = "NORMAL", question = "Bentuk persen dari pecahan 3/4 adalah...",
            optionA = "25%", optionB = "50%", optionC = "75%", optionD = "80%",
            answer = "C", explanation = "3/4 x 100% = 75%.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_035", grade = 6, subjectId = "MATH", topicId = "Diagram Lingkaran",
            difficulty = "HARD", question = "Siswa satu kelas berjumlah 40 orang. Jika 25% gemar melukis, berapa orang yang gemar melukis?",
            optionA = "8 orang", optionB = "10 orang", optionC = "12 orang", optionD = "15 orang",
            answer = "B", explanation = "25% x 40 = 1/4 x 40 = 10 orang.", xp = 140, educationLevel = "SD", isExam = true
        ),

        // ========================================================
        // === SAINS / IPAS SD (35 SOAL: Q_EXAM_SD_036 - 070) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SD_036", grade = 1, subjectId = "SCIENCE", topicId = "Panca Indra",
            difficulty = "EASY", question = "Bagian tubuh yang kita gunakan untuk mengecap rasa manis dan asin adalah...",
            optionA = "Hidung", optionB = "Lidah", optionC = "Telinga", optionD = "Kulit",
            answer = "B", explanation = "Lidah berfungsi sebagai indra pengecap rasa makanan.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_037", grade = 1, subjectId = "SCIENCE", topicId = "Benda Hidup & Mati",
            difficulty = "EASY", question = "Di bawah ini yang merupakan ciri-ciri makhluk hidup adalah...",
            optionA = "Tidak bertambah besar", optionB = "Memerlukan makanan dan air", optionC = "Tidak bernapas", optionD = "Diam selamanya",
            answer = "B", explanation = "Makhluk hidup membutuhkan makan, minum, dan bernapas untuk bertahan hidup.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_038", grade = 2, subjectId = "SCIENCE", topicId = "Pertumbuhan Hewan",
            difficulty = "EASY", question = "Ayam berkembang biak dengan cara...",
            optionA = "Bertelur (Ovipar)", optionB = "Melahirkan (Vivipar)", optionC = "Membelah diri", optionD = "Tunas",
            answer = "A", explanation = "Ayam bertelur untuk menghasilkan keturunan (ovipar).", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_039", grade = 2, subjectId = "SCIENCE", topicId = "Bagian Tumbuhan",
            difficulty = "EASY", question = "Bagian tumbuhan yang berfungsi menyerap air dan zat hara dari dalam tanah adalah...",
            optionA = "Daun", optionB = "Batang", optionC = "Akar", optionD = "Bunga",
            answer = "C", explanation = "Akar menyerap air dan mineral dari tanah serta menopang tanaman.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_040", grade = 3, subjectId = "SCIENCE", topicId = "Wujud Benda",
            difficulty = "EASY", question = "Perubahan wujud benda dari padat menjadi cair disebut...",
            optionA = "Membeku", optionB = "Mencair", optionC = "Menguap", optionD = "Mengembun",
            answer = "B", explanation = "Contoh mencair adalah es batu yang terkena panas menjadi air.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_041", grade = 3, subjectId = "SCIENCE", topicId = "Sifat Benda Gas",
            difficulty = "NORMAL", question = "Benda gas memiliki sifat yaitu...",
            optionA = "Bentuk dan volume tetap", optionB = "Bentuk berubah sesuai wadah dan menekan ke segala arah", optionC = "Tidak dapat dirasakan", optionD = "Bentuk tetap tapi volume berubah",
            answer = "B", explanation = "Gas mengisi seluruh ruangan wadahnya dan menekan ke semua arah.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_042", grade = 3, subjectId = "SCIENCE", topicId = "Daur Hidup Kupu-kupu",
            difficulty = "NORMAL", question = "Urutan metamorfosis sempurna pada kupu-kupu yang benar adalah...",
            optionA = "Telur -> Kepompong -> Ulat -> Kupu-kupu", optionB = "Telur -> Ulat -> Kepompong -> Kupu-kupu", optionC = "Ulat -> Telur -> Kepompong -> Kupu-kupu", optionD = "Kepompong -> Ulat -> Telur -> Kupu-kupu",
            answer = "B", explanation = "Daur hidup: telur menetas menjadi ulat (larva), menjadi kepompong (pupa), lalu kupu-kupu dewasa.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_043", grade = 4, subjectId = "SCIENCE", topicId = "Fotosintesis",
            difficulty = "NORMAL", question = "Gas yang diserap tumbuhan saat fotosintesis dan gas yang dihasilkan adalah...",
            optionA = "Menyerap Oksigen, menghasilkan Karbondioksida", optionB = "Menyerap Karbondioksida, menghasilkan Oksigen", optionC = "Menyerap Nitrogen, menghasilkan Oksigen", optionD = "Menyerap Air, menghasilkan Nitrogen",
            answer = "B", explanation = "Tumbuhan menyerap CO2 dan air menggunakan klorofil serta cahaya matahari, menghasilkan O2 dan glukosa.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_044", grade = 4, subjectId = "SCIENCE", topicId = "Gaya & Gerak",
            difficulty = "NORMAL", question = "Gaya yang menyebabkan buah apel jatuh dari pohon menuju tanah adalah...",
            optionA = "Gaya pegas", optionB = "Gaya magnet", optionC = "Gaya gravitasi bumi", optionD = "Gaya gesek",
            answer = "C", explanation = "Gravitasi bumi menarik semua benda bermassa ke arah pusat bumi.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_045", grade = 4, subjectId = "SCIENCE", topicId = "Energi Alternatif",
            difficulty = "NORMAL", question = "Sumber energi yang tidak akan habis dan ramah lingkungan adalah...",
            optionA = "Batu bara", optionB = "Minyak bumi", optionC = "Matahari dan angin", optionD = "Gas alam",
            answer = "C", explanation = "Matahari, angin, dan air adalah energi terbarukan ramah lingkungan.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_046", grade = 4, subjectId = "SCIENCE", topicId = "Sifat Cahaya",
            difficulty = "NORMAL", question = "Peristiwa pensil yang terlihat patah saat dimasukkan ke dalam gelas berisi air membuktikan bahwa cahaya dapat...",
            optionA = "Dipantulkan", optionB = "Dibiaskan", optionC = "Merambat lurus", optionD = "Menembus benda bening",
            answer = "B", explanation = "Pembiasan (refraksi) terjadi karena cahaya melewati medium berbeda kerapatan.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_047", grade = 4, subjectId = "SCIENCE", topicId = "Rantai Makanan",
            difficulty = "NORMAL", question = "Pada rantai makanan: Padi -> Belalang -> Katak -> Ular, yang berperan sebagai konsumen tingkat I adalah...",
            optionA = "Padi", optionB = "Belalang", optionC = "Katak", optionD = "Ular",
            answer = "B", explanation = "Padi adalah produsen. Belalang memakan produsen langsung, sehingga konsumen tingkat I.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_048", grade = 5, subjectId = "SCIENCE", topicId = "Alat Pernapasan Manusia",
            difficulty = "NORMAL", question = "Tempat terjadinya pertukaran gas oksigen dan karbondioksida di dalam paru-paru adalah...",
            optionA = "Trakea", optionB = "Bronkus", optionC = "Alveolus", optionD = "Laring",
            answer = "C", explanation = "Alveolus adalah kantung udara kecil tempat difusi O2 dan CO2.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_049", grade = 5, subjectId = "SCIENCE", topicId = "Pencernaan Makanan",
            difficulty = "NORMAL", question = "Organ pencernaan yang berfungsi menyerap sari-sari makanan ke dalam darah adalah...",
            optionA = "Lambung", optionB = "Usus halus", optionC = "Usus besar", optionD = "Kerongkongan",
            answer = "B", explanation = "Penyerapan nutrisi makanan berlangsung terutama di usus halus (ileum).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_050", grade = 5, subjectId = "SCIENCE", topicId = "Peredaran Darah",
            difficulty = "NORMAL", question = "Bagian jantung yang bertugas memompa darah kaya oksigen ke seluruh tubuh adalah...",
            optionA = "Serambi kanan", optionB = "Bilik kanan", optionC = "Serambi kiri", optionD = "Bilik kiri",
            answer = "D", explanation = "Bilik kiri memiliki otot tebal untuk memompa darah bersih ke seluruh tubuh.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_051", grade = 5, subjectId = "SCIENCE", topicId = "Simbiosis",
            difficulty = "NORMAL", question = "Hubungan antara lebah madu dan bunga merupakan contoh simbiosis...",
            optionA = "Mutualisme", optionB = "Komensalisme", optionC = "Parasitisme", optionD = "Netralisme",
            answer = "A", explanation = "Lebah mendapat nektar, bunga terbantu proses penyerbukannya (saling menguntungkan).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_052", grade = 5, subjectId = "SCIENCE", topicId = "Siklus Air",
            difficulty = "NORMAL", question = "Proses penguapan air dari laut dan danau ke atmosfer akibat panas matahari disebut...",
            optionA = "Kondensasi", optionB = "Evaporasi", optionC = "Presipitasi", optionD = "Infiltrasi",
            answer = "B", explanation = "Evaporasi adalah penguapan air permukaan bumi menuju atmosfer.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_053", grade = 5, subjectId = "SCIENCE", topicId = "Perpindahan Panas",
            difficulty = "NORMAL", question = "Ujung sendok logam terasa panas saat mengaduk teh panas. Peristiwa ini adalah contoh perpindahan panas secara...",
            optionA = "Konduksi", optionB = "Konveksi", optionC = "Radiasi", optionD = "Kondensasi",
            answer = "A", explanation = "Konduksi adalah hantaran panas melalui benda padat tanpa perpindahan partikel zat.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_054", grade = 6, subjectId = "SCIENCE", topicId = "Perkembangbiakan Vegetatif",
            difficulty = "NORMAL", question = "Kentang dan ubi jalar berkembang biak secara vegetatif alami menggunakan...",
            optionA = "Tunas", optionB = "Umbi batang", optionC = "Spora", optionD = "Geragih",
            answer = "B", explanation = "Kentang menyimpan cadangan makanan dan tunas pada umbi batangnya.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_055", grade = 6, subjectId = "SCIENCE", topicId = "Adaptasi Hewan",
            difficulty = "NORMAL", question = "Bunglon mengubah warna kulitnya sesuai lingkungan untuk mengelabui musuh. Kemampuan ini disebut...",
            optionA = "Mimikri", optionB = "Autotomi", optionC = "Ekolokasi", optionD = "Kamuflase",
            answer = "A", explanation = "Perubahan warna kulit bunglon menyerupai warna lingkungan disebut mimikri.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_056", grade = 6, subjectId = "SCIENCE", topicId = "Adaptasi Hewan",
            difficulty = "NORMAL", question = "Cecak memutuskan ekornya saat terancam bahaya. Peristiwa ini disebut...",
            optionA = "Mimikri", optionB = "Autotomi", optionC = "Hibernasi", optionD = "Estivasi",
            answer = "B", explanation = "Autotomi adalah pelepasan anggota tubuh (seperti ekor cecak) untuk meloloskan diri.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_057", grade = 6, subjectId = "SCIENCE", topicId = "Rangkaian Listrik",
            difficulty = "NORMAL", question = "Pada rangkaian seri, jika satu lampu padam maka lampu lainnya akan...",
            optionA = "Menyala lebih terang", optionB = "Ikut padam", optionC = "Tetap menyala", optionD = "Berkedip-kedip",
            answer = "B", explanation = "Rangkaian seri hanya memiliki satu jalur arus. Jika putus, aliran arus terhenti total.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_058", grade = 6, subjectId = "SCIENCE", topicId = "Tata Surya",
            difficulty = "NORMAL", question = "Planet dalam tata surya yang dikenal sebagai 'Planet Merah' adalah...",
            optionA = "Merkurius", optionB = "Venus", optionC = "Mars", optionD = "Jupiter",
            answer = "C", explanation = "Mars tampak kemerahan karena permukaannya banyak mengandung besi oksida.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_059", grade = 6, subjectId = "SCIENCE", topicId = "Rotasi Bumi",
            difficulty = "HARD", question = "Akibat dari peristiwa rotasi bumi mengelilingi porosnya adalah...",
            optionA = "Pergantian musim", optionB = "Pergantian siang dan malam", optionC = "Perubahan lamanya siang dan malam", optionD = "Terlihatnya rasi bintang yang berbeda",
            answer = "B", explanation = "Rotasi bumi (24 jam) menyebabkan terjadinya siang dan malam serta perbedaan waktu.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_060", grade = 6, subjectId = "SCIENCE", topicId = "Revolusi Bumi",
            difficulty = "HARD", question = "Peristiwa revolusi bumi mengelilingi matahari mengakibatkan...",
            optionA = "Gerak semu harian matahari", optionB = "Terjadinya pasang surut air laut", optionC = "Pergantian musim di berbagai belahan bumi", optionD = "Perbedaan waktu antar kota",
            answer = "C", explanation = "Revolusi bumi bersama kemiringan poros bumi menyebabkan pergantian musim.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_061", grade = 6, subjectId = "SCIENCE", topicId = "Gerhana",
            difficulty = "HARD", question = "Gerhana matahari terjadi apabila posisi benda langit sejajar dengan urutan...",
            optionA = "Matahari - Bumi - Bulan", optionB = "Matahari - Bulan - Bumi", optionC = "Bumi - Matahari - Bulan", optionD = "Bulan - Matahari - Bumi",
            answer = "B", explanation = "Gerhana matahari terjadi saat bayangan Bulan menutupi permukaan Bumi.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_062", grade = 5, subjectId = "SCIENCE", topicId = "Magnet",
            difficulty = "NORMAL", question = "Benda yang dapat ditarik dengan kuat oleh magnet dikelompokkan sebagai benda...",
            optionA = "Feromagnetik", optionB = "Paramagnetik", optionC = "Diamagnetik", optionD = "Nonmagnetik",
            answer = "A", explanation = "Besi, baja, dan nikel adalah benda feromagnetik yang ditarik kuat oleh magnet.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_063", grade = 5, subjectId = "SCIENCE", topicId = "Bunyi",
            difficulty = "NORMAL", question = "Bunyi tidak dapat merambat di dalam medium...",
            optionA = "Zat padat", optionB = "Zat cair", optionC = "Udara", optionD = "Ruang hampa udara",
            answer = "D", explanation = "Bunyi memerlukan partikel medium untuk merambat, jadi tidak bisa merambat di ruang hampa.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_064", grade = 6, subjectId = "SCIENCE", topicId = "Pubertas",
            difficulty = "NORMAL", question = "Ciri perkembangan fisik primer pada anak laki-laki saat masa pubertas adalah...",
            optionA = "Suara membesar", optionB = "Tumbuh jakun", optionC = "Mimpi basah (produksi sel sperma)", optionD = "Dada membidang",
            answer = "C", explanation = "Ciri primer berkaitan langsung dengan kematangan organ reproduksi.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_065", grade = 6, subjectId = "SCIENCE", topicId = "Pelestarian Alam",
            difficulty = "NORMAL", question = "Pelestarian komodo di habitat aslinya di Pulau Komodo merupakan contoh pelestarian...",
            optionA = "Ex-situ", optionB = "In-situ", optionC = "Reboisasi", optionD = "Domestikasi",
            answer = "B", explanation = "In-situ adalah pelestarian flora/fauna langsung di dalam habitat alaminya.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_066", grade = 4, subjectId = "SCIENCE", topicId = "Sumber Daya Alam",
            difficulty = "EASY", question = "Berikut ini yang merupakan sumber daya alam yang dapat diperbarui adalah...",
            optionA = "Minyak bumi", optionB = "Hutan dan air", optionC = "Batu bara", optionD = "Gas alam",
            answer = "B", explanation = "Hutan, air, dan tanah dapat dipulihkan kembali secara alami.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_067", grade = 5, subjectId = "SCIENCE", topicId = "Kandungan Nutrisi",
            difficulty = "NORMAL", question = "Zat gizi yang berfungsi utama sebagai zat pembangun dan memperbaiki sel tubuh yang rusak adalah...",
            optionA = "Karbohidrat", optionB = "Lemak", optionC = "Protein", optionD = "Vitamin",
            answer = "C", explanation = "Protein (pada telur, ikan, tahu, tempe) berperan membangun dan memperbaiki jaringan sel.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_068", grade = 6, subjectId = "SCIENCE", topicId = "Hemat Energi",
            difficulty = "EASY", question = "Tindakan bijak untuk menghemat energi listrik di rumah adalah...",
            optionA = "Menyalakan lampu di siang hari", optionB = "Mematikan televisi dan lampu saat tidak digunakan", optionC = "Membiarkan kulkas terbuka", optionD = "Menyalakan AC saat jendela terbuka",
            answer = "B", explanation = "Mematikan perangkat listrik yang tidak dipakai menghemat daya dan biaya.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_069", grade = 6, subjectId = "SCIENCE", topicId = "Pencemaran Lingkungan",
            difficulty = "NORMAL", question = "Gas rumah kaca yang paling dominan menyebabkan pemanasan global adalah...",
            optionA = "Oksigen", optionB = "Nitrogen", optionC = "Karbon dioksida (CO2)", optionD = "Hidrogen",
            answer = "C", explanation = "CO2 memerangkap panas matahari di atmosfer sehingga memicu kenaikan suhu bumi.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_070", grade = 6, subjectId = "SCIENCE", topicId = "Organ Ekskresi",
            difficulty = "HARD", question = "Organ tubuh manusia yang berfungsi menyaring sisa metabolisme dari darah dan menghasilkan urine adalah...",
            optionA = "Hati", optionB = "Ginjal", optionC = "Paru-paru", optionD = "Lambung",
            answer = "B", explanation = "Ginjal bertugas menyaring darah dan membuang limbah cair dalam bentuk urine.", xp = 140, educationLevel = "SD", isExam = true
        ),

        // ========================================================
        // === BAHASA INDONESIA SD (30 SOAL: Q_EXAM_SD_071 - 100) ===
        // ========================================================
        QuestionEntity(
            id = "Q_EXAM_SD_071", grade = 1, subjectId = "LANGUAGE", topicId = "Huruf Vokal",
            difficulty = "EASY", question = "Huruf vokal pada kata 'SEKOLAH' adalah...",
            optionA = "S, K, L, H", optionB = "E, O, A", optionC = "S, E, O", optionD = "K, L, A",
            answer = "B", explanation = "Huruf vokal dalam alfabet bahasa Indonesia adalah A, I, U, E, O.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_072", grade = 1, subjectId = "LANGUAGE", topicId = "Tanda Titik",
            difficulty = "EASY", question = "Tanda baca yang digunakan untuk mengakhiri kalimat berita adalah...",
            optionA = "Tanda koma (,)", optionB = "Tanda tanya (?)", optionC = "Tanda titik (.)", optionD = "Tanda seru (!)",
            answer = "C", explanation = "Kalimat pernyataan/berita diakhiri dengan tanda titik.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_073", grade = 2, subjectId = "LANGUAGE", topicId = "Huruf Kapital",
            difficulty = "EASY", question = "Penulisan huruf kapital yang benar pada nama kota adalah...",
            optionA = "jakarta", optionB = "Jakarta", optionC = "JaKarta", optionD = "JAKARta",
            answer = "B", explanation = "Huruf pertama nama kota dan tempat ditulis dengan huruf kapital.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_074", grade = 2, subjectId = "LANGUAGE", topicId = "Sinonim Dasar",
            difficulty = "EASY", question = "Persamaan kata (sinonim) dari kata 'GEMBIRA' adalah...",
            optionA = "Sedih", optionB = "Senang", optionC = "Marah", optionD = "Takut",
            answer = "B", explanation = "Gembira bersinonim dengan senang atau bahagia.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_075", grade = 2, subjectId = "LANGUAGE", topicId = "Antonim Dasar",
            difficulty = "EASY", question = "Lawan kata (antonim) dari kata 'BESAR' adalah...",
            optionA = "Tinggi", optionB = "Lebar", optionC = "Kecil", optionD = "Panjang",
            answer = "C", explanation = "Lawan kata besar adalah kecil.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_076", grade = 3, subjectId = "LANGUAGE", topicId = "Kata Tanya",
            difficulty = "EASY", question = "Kata tanya yang tepat untuk menanyakan tempat berlangsungnya suatu peristiwa adalah...",
            optionA = "Siapa", optionB = "Kapan", optionC = "Di mana", optionD = "Mengapa",
            answer = "C", explanation = "'Di mana' digunakan untuk menanyakan lokasi atau tempat.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_077", grade = 3, subjectId = "LANGUAGE", topicId = "Kalimat Perintah",
            difficulty = "EASY", question = "Kalimat di bawah ini yang merupakan kalimat perintah adalah...",
            optionA = "Budi sedang membaca buku.", optionB = "Tolong tutup pintu itu dengan rapat!", optionC = "Apakah kamu sudah makan?", optionD = "Wah, pemandangan ini indah sekali!",
            answer = "B", explanation = "Kalimat perintah meminta seseorang melakukan sesuatu dan diakhiri tanda seru (!).", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_078", grade = 3, subjectId = "LANGUAGE", topicId = "Imbuhan me-",
            difficulty = "NORMAL", question = "Kata dasar 'sapu' jika diberi awalan 'me-' berubah menjadi...",
            optionA = "Mesapu", optionB = "Mensapu", optionC = "Menyapu", optionD = "Mengsapu",
            answer = "C", explanation = "Awalan me- bertemu huruf awal S luluh menjadi meny- (menyapu).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_079", grade = 4, subjectId = "LANGUAGE", topicId = "Gagasan Pokok",
            difficulty = "NORMAL", question = "Inti atau pokok permasalahan dalam suatu paragraf disebut...",
            optionA = "Kalimat penjelas", optionB = "Gagasan pokok (ide pokok)", optionC = "Ringkasan", optionD = "Amanat",
            answer = "B", explanation = "Gagasan pokok adalah topik utama yang mendasari sebuah paragraf.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_080", grade = 4, subjectId = "LANGUAGE", topicId = "Paragraf Deduktif",
            difficulty = "NORMAL", question = "Paragraf yang letak gagasan pokoknya berada di awal paragraf disebut paragraf...",
            optionA = "Deduktif", optionB = "Induktif", optionC = "Campuran", optionD = "Naratif",
            answer = "A", explanation = "Deduktif meletakkan ide pokok di awal, kemudian diikuti kalimat-kalimat pengembang.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_081", grade = 4, subjectId = "LANGUAGE", topicId = "Paragraf Induktif",
            difficulty = "NORMAL", question = "Paragraf yang letak gagasan pokoknya berada di akhir paragraf disebut paragraf...",
            optionA = "Deduktif", optionB = "Induktif", optionC = "Deskriptif", optionD = "Persuasif",
            answer = "B", explanation = "Induktif diawali penjelasan-penjelasan khusus dan diakhiri kesimpulan di akhir.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_082", grade = 4, subjectId = "LANGUAGE", topicId = "Unsur Intrinsik Cerita",
            difficulty = "NORMAL", question = "Pesan moral atau nasihat yang ingin disampaikan pengarang melalui cerita disebut...",
            optionA = "Alur", optionB = "Latar", optionC = "Amanat", optionD = "Tokoh",
            answer = "C", explanation = "Amanat adalah pesan kebaikan yang dapat dipetik pembaca dari sebuah cerita.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_083", grade = 4, subjectId = "LANGUAGE", topicId = "Tokoh Antagonis",
            difficulty = "EASY", question = "Tokoh dalam cerita yang berwatak jahat atau menentang tokoh utama disebut...",
            optionA = "Protagonis", optionB = "Antagonis", optionC = "Tritagonis", optionD = "Figuran",
            answer = "B", explanation = "Antagonis adalah tokoh penentang berwatak jahat, sedangkan protagonis berwatak baik.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_084", grade = 5, subjectId = "LANGUAGE", topicId = "Pantun",
            difficulty = "NORMAL", question = "Ciri-ciri pantun yang benar di bawah ini adalah...",
            optionA = "Satu bait terdiri atas 4 baris dengan rima a-b-a-b", optionB = "Semua baris adalah isi cerita", optionC = "Terdiri dari 10 baris tiap bait", optionD = "Bersajak a-a-a-a tanpa sampiran",
            answer = "A", explanation = "Pantun terdiri dari 4 baris: baris 1-2 sampiran, baris 3-4 isi, bersajak a-b-a-b.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_085", grade = 5, subjectId = "LANGUAGE", topicId = "Ungkapan (Idiom)",
            difficulty = "NORMAL", question = "Ungkapan 'kutu buku' memiliki arti orang yang...",
            optionA = "Suka merawat buku tua", optionB = "Sangat gemar membaca buku", optionC = "Menjual buku di toko", optionD = "Merusak buku sekolah",
            answer = "B", explanation = "Kutu buku adalah kiasan bagi orang yang sangat suka dan rajin membaca buku.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_086", grade = 5, subjectId = "LANGUAGE", topicId = "Ungkapan (Idiom)",
            difficulty = "NORMAL", question = "Anak yang suka mencuri sering diungkapkan dengan kiasan...",
            optionA = "Panjang tangan", optionB = "Ringan tangan", optionC = "Tangan dingin", optionD = "Buah tangan",
            answer = "A", explanation = "Panjang tangan artinya suka mencuri, sedangkan ringan tangan artinya suka menolong/bekerja.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_087", grade = 5, subjectId = "LANGUAGE", topicId = "Peribahasa",
            difficulty = "NORMAL", question = "Arti dari peribahasa 'Besar pasak daripada tiang' adalah...",
            optionA = "Membangun rumah yang sangat kokoh", optionB = "Pengeluaran lebih besar daripada pendapatan", optionC = "Memiliki cita-cita yang tinggi", optionD = "Hemat pangkal kaya",
            answer = "B", explanation = "Peribahasa ini bermakna berbelanja melebihi penghasilan yang dimiliki.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_088", grade = 5, subjectId = "LANGUAGE", topicId = "Kalimat Efektif",
            difficulty = "NORMAL", question = "Kalimat berikut yang merupakan kalimat efektif dan hemat kata adalah...",
            optionA = "Para hadirin sekalian dipersilakan duduk.", optionB = "Hadirin dipersilakan duduk.", optionC = "Semua para hadirin dipersilakan duduk.", optionD = "Para hadirin semuanya dipersilakan duduk.",
            answer = "B", explanation = "'Hadirin' sudah bermakna jamak, sehingga tidak perlu ditambah 'para' atau 'sekalian'.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_089", grade = 6, subjectId = "LANGUAGE", topicId = "Kata Baku",
            difficulty = "NORMAL", question = "Kelompok kata yang semuanya merupakan kata baku menurut KBBI adalah...",
            optionA = "Apotik, ijin, nasehat", optionB = "Apotek, izin, nasihat", optionC = "Apotek, idzin, nasehat", optionD = "Apotik, izin, nasihat",
            answer = "B", explanation = "Bentuk baku: Apotek (bukan apotik), Izin (bukan ijin), Nasihat (bukan nasehat).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_090", grade = 6, subjectId = "LANGUAGE", topicId = "Kata Baku",
            difficulty = "NORMAL", question = "Bentuk baku dari kata 'praktek' dan 'jadual' adalah...",
            optionA = "Praktik dan Jadwal", optionB = "Praktek dan Jadwal", optionC = "Praktik dan Jadual", optionD = "Praktis dan Jadwal",
            answer = "A", explanation = "Kata baku yang tepat adalah 'praktik' dan 'jadwal'.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_091", grade = 6, subjectId = "LANGUAGE", topicId = "Pidato",
            difficulty = "NORMAL", question = "Bagian teks pidato yang berisi salam dan ucapan syukur adalah...",
            optionA = "Pembukaan", optionB = "Isi pidato", optionC = "Penutup", optionD = "Kesimpulan",
            answer = "A", explanation = "Pembukaan pidato memuat salam pembuka, penghormatan, dan ungkapan puji syukur.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_092", grade = 6, subjectId = "LANGUAGE", topicId = "Teks Eksplanasi",
            difficulty = "HARD", question = "Teks yang menjelaskan tentang proses terjadinya fenomena alam atau sosial disebut teks...",
            optionA = "Narasi", optionB = "Eksplanasi", optionC = "Deskripsi", optionD = "Eksposisi",
            answer = "B", explanation = "Teks eksplanasi menerangkan hubungan sebab-akibat terjadinya peristiwa ilmiah/alam.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_093", grade = 6, subjectId = "LANGUAGE", topicId = "Laporan Pengamatan",
            difficulty = "NORMAL", question = "Unsur yang wajib ada di dalam sebuah laporan hasil pengamatan adalah...",
            optionA = "Daftar belanja", optionB = "Waktu, tempat, objek, dan hasil pengamatan", optionC = "Cerita fiksi tokoh", optionD = "Gambar kartun lucu",
            answer = "B", explanation = "Laporan pengamatan harus faktual memuat waktu, lokasi, objek diamati, dan hasilnya.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_094", grade = 6, subjectId = "LANGUAGE", topicId = "Kalimat Aktif & Pasif",
            difficulty = "NORMAL", question = "Kalimat pasif dari 'Rian menanam bibit pohon mangga di kebun' adalah...",
            optionA = "Bibit pohon mangga ditanam Rian di kebun.", optionB = "Rian menanam bibit pohon di kebun.", optionC = "Di kebun Rian menanam pohon.", optionD = "Pohon mangga menanam Rian di kebun.",
            answer = "A", explanation = "Objek (bibit mangga) menjadi subjek di depan dengan predikat berawalan di- (ditanam).", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_095", grade = 5, subjectId = "LANGUAGE", topicId = "Iklan",
            difficulty = "NORMAL", question = "Kalimat pada media iklan bertujuan untuk...",
            optionA = "Menghibur pembaca dengan lelucon", optionB = "Membujuk atau mengajak masyarakat menggunakan produk/jasa", optionC = "Menceritakan sejarah masa lalu", optionD = "Mengkritik pembeli secara tegas",
            answer = "B", explanation = "Kalimat iklan bersifat persuasif untuk menarik minat calon konsumen.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_096", grade = 5, subjectId = "LANGUAGE", topicId = "Formulir",
            difficulty = "EASY", question = "Lembaran kertas yang berisi kolom-kolom identitas diri yang harus diisi disebut...",
            optionA = "Kuitansi", optionB = "Formulir", optionC = "Kupon", optionD = "Surat kabar",
            answer = "B", explanation = "Formulir digunakan untuk mendata identitas pendaftaran atau keanggotaan.", xp = 120, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_097", grade = 6, subjectId = "LANGUAGE", topicId = "Ringkasan",
            difficulty = "NORMAL", question = "Tindakan memperpendek bacaan dengan tetap mempertahankan isi pokok bacaan disebut...",
            optionA = "Meringkas", optionB = "Menyalin", optionC = "Mengarang", optionD = "Mendongeng",
            answer = "A", explanation = "Ringkasan (rangkuman) menyajikan intisari teks secara padat dan jelas.", xp = 130, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_098", grade = 6, subjectId = "LANGUAGE", topicId = "Majas Personifikasi",
            difficulty = "HARD", question = "Kalimat yang mengandung majas personifikasi (menggambarkan benda mati seolah bersikap seperti manusia) adalah...",
            optionA = "Angin malam berbisik lembut menyapa lamunanku.", optionB = "Rumahnya megah bagaikan istana raja.", optionC = "Dia anak yang sangat cerdas di kelas.", optionD = "Ayah membelikan tas baru untuk adik.",
            answer = "A", explanation = "Angin malam digambarkan dapat 'berbisik' dan 'menyapa' seperti manusia.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_099", grade = 6, subjectId = "LANGUAGE", topicId = "Fakta dan Opini",
            difficulty = "HARD", question = "Pernyataan di bawah ini yang merupakan kalimat FAKTA adalah...",
            optionA = "Pemandangan pantai itu paling indah di dunia.", optionB = "Indonesia merdeka pada tanggal 17 Agustus 1945.", optionC = "Masakan ibu adalah yang terenak di dunia.", optionD = "Hari ini udara terasa sangat sejuk sekali.",
            answer = "B", explanation = "Kalimat B adalah peristiwa sejarah nyata yang memiliki bukti dan data objektif pasti.", xp = 140, educationLevel = "SD", isExam = true
        ),
        QuestionEntity(
            id = "Q_EXAM_SD_100", grade = 6, subjectId = "LANGUAGE", topicId = "Surat Resmi",
            difficulty = "HARD", question = "Bagian yang membedakan surat resmi (dinas) dengan surat pribadi adalah adanya...",
            optionA = "Salam pembuka", optionB = "Kepala surat (kop surat) dan nomor surat", optionC = "Isi surat", optionD = "Tanda tangan pengirim",
            answer = "B", explanation = "Surat dinas resmi wajib memiliki kop surat instansi, nomor surat, dan perihal.", xp = 140, educationLevel = "SD", isExam = true
        )
    )
}
