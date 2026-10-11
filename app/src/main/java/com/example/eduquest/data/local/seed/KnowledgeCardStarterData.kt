package com.example.eduquest.data.local.seed

import com.example.eduquest.data.local.entity.KnowledgeCardEntity

object KnowledgeCardStarterData {
    val STARTER_CARDS = listOf(
        // === MATEMATIKA ===
        KnowledgeCardEntity(
            id = "card_math_01",
            title = "Keajaiban Angka Nol",
            category = "Matematika",
            description = "Angka nol bukan sekadar ketiadaan, melainkan fondasi utama seluruh sistem matematika modern di dunia.",
            fact = "Konsep angka nol pertama kali dirumuskan di India kuno dan disempurnakan oleh ilmuwan Muslim Al-Khawarizmi!",
            imageAsset = "card_zero",
            unlockCondition = "quest_math_01"
        ),
        KnowledgeCardEntity(
            id = "card_math_02",
            title = "Jam Matahari Kuno",
            category = "Matematika",
            description = "Sebelum jam digital ditemukan, manusia zaman dahulu memanfaatkan bayangan sinar matahari untuk mengukur waktu.",
            fact = "Jam matahari tertua yang pernah ditemukan berasal dari Mesir Kuno, berumur lebih dari 3.500 tahun!",
            imageAsset = "card_sundial",
            unlockCondition = "quest_math_02"
        ),
        KnowledgeCardEntity(
            id = "card_math_03",
            title = "Trik Jari Sembilan",
            category = "Matematika",
            description = "Perkalian angka sembilan memiliki pola simetri unik yang memukau anak-anak di seluruh dunia.",
            fact = "Jika kamu menjumlahkan digit-digit hasil perkalian 9 (misal 9 x 4 = 36 -> 3 + 6 = 9), hasilnya akan selalu sama dengan 9!",
            imageAsset = "card_multiply",
            unlockCondition = "quest_math_03"
        ),
        KnowledgeCardEntity(
            id = "card_math_04",
            title = "Kekuatan Segitiga",
            category = "Geometri",
            description = "Bangun datar segitiga digunakan pada rangka jembatan dan atap rumah karena sifatnya yang kokoh.",
            fact = "Segitiga adalah satu-satunya bentuk geometri dua dimensi yang tidak bisa berubah sudutnya tanpa mengubah panjang sisinya!",
            imageAsset = "card_geometry",
            unlockCondition = "quest_math_05"
        ),
        KnowledgeCardEntity(
            id = "card_math_05",
            title = "Candi Borobudur & Simetri",
            category = "Matematika Nusantara",
            description = "Candi Borobudur di Magelang adalah mahakarya arsitektur kuno Nusantara dengan simetri dan proporsi matematika tinggi.",
            fact = "Candi ini dibangun dengan 2 juta balok batu vulkanik yang tersusun presisi tanpa menggunakan semen atau perekat modern sama sekali!",
            imageAsset = "card_borobudur",
            unlockCondition = "quest_math_06"
        ),
        KnowledgeCardEntity(
            id = "card_math_06",
            title = "Pecahan dalam Kehidupan",
            category = "Matematika",
            description = "Konsep pecahan sering kita gunakan saat membagi kue ulang tahun, piza, atau jus secara adil bersama teman.",
            fact = "Bangsa Mesir Kuno menggunakan pecahan mata Horus untuk melambangkan pecahan 1/2, 1/4, 1/8, 1/16, 1/32, dan 1/64!",
            imageAsset = "card_fractions",
            unlockCondition = "quest_math_07"
        ),

        // === SAINS / IPA ===
        KnowledgeCardEntity(
            id = "card_science_01",
            title = "Mata Elang Super",
            category = "Hewan",
            description = "Penglihatan elang merupakan salah satu keajaiban indra penglihatan paling tajam di alam liar.",
            fact = "Mata elang dapat melihat mangsa kecil seperti kelinci dari ketinggian 3 kilometer di udara dengan ketajaman 4-8 kali mata manusia!",
            imageAsset = "card_eagle",
            unlockCondition = "quest_science_01"
        ),
        KnowledgeCardEntity(
            id = "card_science_02",
            title = "Siklus Air Abadi",
            category = "Sains Bumi",
            description = "Air yang kita minum hari ini adalah air yang sama yang sudah ada di bumi selama miliaran tahun melalui siklus hidrologi.",
            fact = "Molekul air yang kamu minum hari ini mungkin saja pernah diminum oleh dinosaurus zaman purba jutaan tahun lalu!",
            imageAsset = "card_water_cycle",
            unlockCondition = "quest_science_02"
        ),
        KnowledgeCardEntity(
            id = "card_science_03",
            title = "Dapur Hijau Daun",
            category = "Tumbuhan",
            description = "Tumbuhan hijau memiliki zat klorofil yang bertindak seperti dapur penghasil oksigen dan energi bagi bumi.",
            fact = "Melalui fotosintesis, satu pohon rindang mampu menghasilkan oksigen bersih yang cukup untuk bernapas 4 orang manusia setiap hari!",
            imageAsset = "card_chlorophyll",
            unlockCondition = "quest_science_03"
        ),
        KnowledgeCardEntity(
            id = "card_science_04",
            title = "Komodo Sang Naga Indonesia",
            category = "Fauna Nusantara",
            description = "Komodo adalah kadal terbesar di dunia yang hanya hidup alami di Kepulauan Nusa Tenggara, Indonesia.",
            fact = "Panjang komodo dewasa bisa mencapai lebih dari 3 meter dengan berat hingga 130 kilogram!",
            imageAsset = "card_komodo",
            unlockCondition = "quest_science_04"
        ),
        KnowledgeCardEntity(
            id = "card_science_05",
            title = "Rafflesia Arnoldii",
            category = "Flora Nusantara",
            description = "Bunga raksasa tanpa daun dan tanpa batang asli hutan Sumatra dan Kalimantan yang merupakan puspa langka Indonesia.",
            fact = "Diameter bunga Rafflesia arnoldii dapat mencapai 1 meter dan berbobot hingga 11 kilogram saat mekar sempurna!",
            imageAsset = "card_rafflesia",
            unlockCondition = "quest_science_05"
        ),
        KnowledgeCardEntity(
            id = "card_science_06",
            title = "Pompa Hebat Jantung",
            category = "Tubuh Manusia",
            description = "Jantung manusia adalah organ berotot kuat yang memompa darah ke seluruh tubuh tanpa lelah setiap detik.",
            fact = "Jantungmu berdetak sekitar 100.000 kali setiap hari dan memompa lebih dari 7.500 liter darah tanpa pernah istirahat!",
            imageAsset = "card_heart",
            unlockCondition = "quest_science_06"
        ),
        KnowledgeCardEntity(
            id = "card_science_07",
            title = "Cincin Megah Saturnus",
            category = "Antariksa",
            description = "Saturnus adalah planet tercantik di tata surya dengan sistem cincin es dan debu yang spektakuler.",
            fact = "Cincin Saturnus membentang hingga 282.000 kilometer, namun ketebalannya sangat tipis, hanya sekitar 10 sampai 30 meter saja!",
            imageAsset = "card_saturn",
            unlockCondition = "quest_science_07"
        ),

        // === BAHASA INDONESIA ===
        KnowledgeCardEntity(
            id = "card_lang_01",
            title = "Kekayaan Bahasa Nusantara",
            category = "Bahasa",
            description = "Indonesia adalah salah satu negara dengan keragaman bahasa daerah terbanyak kedua di dunia.",
            fact = "Terdapat lebih dari 718 bahasa daerah di seluruh pelosok Indonesia yang disatukan dengan bangga oleh Bahasa Indonesia!",
            imageAsset = "card_language",
            unlockCondition = "quest_lang_01"
        ),
        KnowledgeCardEntity(
            id = "card_lang_02",
            title = "Aksara Nusantara",
            category = "Sejarah",
            description = "Sebelum alfabet Latin digunakan, nenek moyang bangsa Indonesia menulis menggunakan beragam aksara daerah yang elok.",
            fact = "Nusantara memiliki aksara kuno yang kaya seperti Aksara Jawa (Hanacaraka), Sunda, Batak, Bali, Kaganga, dan Bugis (Lontara)!",
            imageAsset = "card_script",
            unlockCondition = "quest_lang_02"
        ),
        KnowledgeCardEntity(
            id = "card_lang_03",
            title = "Pantun Warisan Dunia",
            category = "Budaya",
            description = "Pantun adalah bentuk puisi lama asli Melayu-Nusantara yang sarat makna, rima ab-ab, dan nasihat budi pekerti.",
            fact = "Pada tahun 2020, UNESCO secara resmi menetapkan Tradisi Pantun sebagai Warisan Budaya Takbenda Dunia dari Indonesia!",
            imageAsset = "card_pantun",
            unlockCondition = "quest_lang_05"
        ),

        // ==========================================
        // === KARTU PINTAR SMP ===
        // ==========================================
        KnowledgeCardEntity(
            id = "card_smp_pythagoras",
            title = "Misteri Teorema Pythagoras",
            category = "Geometri",
            description = "Hubungan kuadrat sisi miring pada segitiga siku-siku (a² + b² = c²) adalah pilar arsitektur dan navigasi global.",
            fact = "Bangsa Babilonia dan Mesir kuno telah memanfaatkan tali bersimpul 3-4-5 untuk membuat sudut siku-siku sempurna ribuan tahun lalu!",
            imageAsset = "card_pythagoras",
            unlockCondition = "quest_smp_math_03"
        ),
        KnowledgeCardEntity(
            id = "card_smp_newton",
            title = "Hukum Gerak Newton",
            category = "Fisika",
            description = "Tiga hukum gerak Sir Isaac Newton menjelaskan bagaimana benda diam, bergerak, dan bereaksi terhadap gaya di semesta.",
            fact = "Hukum III Newton (Aksi = -Reaksi) adalah prinsip dasar yang memungkinkan roket antariksa meluncur ke luar angkasa!",
            imageAsset = "card_newton",
            unlockCondition = "quest_smp_ipa_03"
        ),
        KnowledgeCardEntity(
            id = "card_smp_cell",
            title = "Dunia Mikroskopis Sel Hayati",
            category = "Biologi",
            description = "Sel adalah unit terkecil kehidupan yang memiliki pabrik energi mitokondria dan pusat kendali inti sel (nukleus).",
            fact = "Tubuh manusia dewasa terdiri dari lebih dari 37 triliun sel yang bekerja selaras setiap detik!",
            imageAsset = "card_cell",
            unlockCondition = "quest_smp_ipa_01"
        ),
        KnowledgeCardEntity(
            id = "card_smp_maritime",
            title = "Jalur Rempah Nusantara",
            category = "Sejarah",
            description = "Kepulauan Indonesia adalah pusat perdagangan rempah dunia (pala, cengkih, lada) yang mengubah peta maritim global.",
            fact = "Pulau Run di Maluku yang kaya pala pernah ditukar oleh Belanda dengan pulau Manhattan (kini Kota New York, AS) kepada Inggris pada 1667!",
            imageAsset = "card_spice_route",
            unlockCondition = "quest_smp_ips_02"
        ),
        KnowledgeCardEntity(
            id = "card_smp_asean",
            title = "Keluarga Bangsa ASEAN",
            category = "Sosial",
            description = "Perhimpunan bangsa Asia Tenggara yang didirikan di Bangkok tahun 1967 guna memelihara perdamaian dan kemakmuran kawasan.",
            fact = "Indonesia adalah salah satu dari 5 negara pemrakarsa berdirinya ASEAN melalui penandatanganan Deklarasi Bangkok oleh Adam Malik!",
            imageAsset = "card_asean",
            unlockCondition = "quest_smp_ips_05"
        ),
        KnowledgeCardEntity(
            id = "card_smp_gurindam",
            title = "Gurindam 12 Raja Ali Haji",
            category = "Bahasa",
            description = "Karya sastra puisi Melayu klasik dua baris berisi nasihat moral, agama, dan etika budi pekerti luhur manusia nusantara.",
            fact = "Pahlawan Nasional Raja Ali Haji dari Pulau Penyengat juga merupakan pencatat tata bahasa Melayu pertama yang menjadi cikal bakal Bahasa Indonesia!",
            imageAsset = "card_gurindam",
            unlockCondition = "quest_smp_lang_02"
        ),

        // ==========================================
        // === KARTU PINTAR SMA ===
        // ==========================================
        KnowledgeCardEntity(
            id = "card_sma_euler",
            title = "Keanggunan Bilangan Euler (e)",
            category = "Matematika",
            description = "Konstanta matematika e ≈ 2,71828 adalah fondasi pertumbuhan eksponensial, bunga majemuk, peluruhan radioaktif, dan kalkulus.",
            fact = "Rumus Identitas Euler (e^(iπ) + 1 = 0) dinobatkan sebagai persamaan matematika paling indah karena menggabungkan 5 konstanta fundamental!",
            imageAsset = "card_euler",
            unlockCondition = "quest_sma_math_01"
        ),
        KnowledgeCardEntity(
            id = "card_sma_calculus",
            title = "Kalkulus: Bahasa Alam Semesta",
            category = "Matematika",
            description = "Diferensial dan integral yang digagas Newton & Leibniz memungkinkan perhitungan laju perubahan dan akumulasi luas secara presisi.",
            fact = "Tanpa kalkulus, kalkulasi orbit satelit GPS, desain sayap pesawat supersonik, dan pemodelan kecerdasan buatan mustahil terwujud!",
            imageAsset = "card_calculus",
            unlockCondition = "quest_sma_math_05"
        ),
        KnowledgeCardEntity(
            id = "card_sma_thermo",
            title = "Hukum Termodinamika & Entropi",
            category = "Fisika",
            description = "Energi tidak dapat diciptakan atau dimusnahkan (Kekekalan Energi), dan entropi (derajat ketidakteraturan) alam semesta selalu meningkat.",
            fact = "Konsep entropi menjelaskan arah panah waktu di alam semesta: mengapa telur yang pecah tidak pernah bisa menyatu kembali secara alami!",
            imageAsset = "card_thermo",
            unlockCondition = "quest_sma_mipa_04"
        ),
        KnowledgeCardEntity(
            id = "card_sma_dna",
            title = "Kode Kehidupan DNA Heliks Ganda",
            category = "Biologi",
            description = "Asam Deoksiribonukleat (DNA) menyimpan cetak biru genetik seluruh makhluk hidup dengan pasangan basa adenin, timin, guanin, sitosin.",
            fact = "Jika seluruh untaian DNA di dalam sel-sel tubuh satu manusia direntangkan lurus, panjangnya bisa mencapai dari Bumi ke Matahari bolak-balik puluhan kali!",
            imageAsset = "card_dna",
            unlockCondition = "quest_sma_mipa_05"
        ),
        KnowledgeCardEntity(
            id = "card_sma_market",
            title = "Tangan Tak Terlihat Adam Smith",
            category = "Ekonomi",
            description = "Gagasan bahwa interaksi bebas pembeli dan penjual di pasar secara mandiri menciptakan alokasi sumber daya yang efisien bagi masyarakat.",
            fact = "Diterbitkan dalam karya legendaris 'The Wealth of Nations' tahun 1776, buku ini menjadi fondasi ilmu ekonomi modern di seluruh dunia!",
            imageAsset = "card_invisible_hand",
            unlockCondition = "quest_sma_sos_01"
        ),
        KnowledgeCardEntity(
            id = "card_sma_ai",
            title = "Revolusi Kecerdasan Buatan & AI",
            category = "Teknologi",
            description = "Perkembangan jaringan saraf tiruan (neural networks) dan model bahasa besar yang mampu memahami konteks dan bernalar adaptif.",
            fact = "Konsep dasar neuron komputasi pertama kali diusulkan oleh Warren McCulloch dan Walter Pitts sejak tahun 1943!",
            imageAsset = "card_ai",
            unlockCondition = "quest_sma_gen_02"
        ),
        KnowledgeCardEntity(
            id = "card_sma_logic",
            title = "Pisau Ockham & Nalar Kritis",
            category = "Logika",
            description = "Prinsip parsimoni bahwa dari berbagai penjelasan yang bersaing untuk suatu fenomena, penjelasan yang paling sederhana dan minim asumsi patut diprioritaskan.",
            fact = "Dirumuskan oleh filsuf William of Ockham pada abad ke-14, prinsip ini adalah standar emas metodologi sains modern dalam menguji hipotesis!",
            imageAsset = "card_ockham",
            unlockCondition = "quest_sma_gen_05"
        )
    )
}
