# Rancangan Game Edukasi Anak --- EduQuest

## 1. Identitas Proyek

**Nama kerja:** EduQuest\
**Platform utama:** Android\
**IDE:** VS Code\
**AI coding assistant:** Antigravity\
**Model distribusi:** Google Play Store\
**Model data:** Offline-first, database lokal\
**Hosting wajib:** Tidak diperlukan untuk gameplay inti\
**Monetisasi:** Freemium + AdMob + Premium + Rewarded Ads yang dirancang
sesuai kebijakan untuk aplikasi anak\
**Target pengguna:** SD, SMP, SMA

> Prinsip utama:
>
> **"Game petualangan yang menggunakan pengetahuan sebagai kekuatan."**
>
> EduQuest tidak boleh terasa seperti buku soal yang diberi animasi.
> Anak harus merasa sedang bermain game, sementara proses belajarnya
> terjadi secara alami di dalam gameplay.

------------------------------------------------------------------------

# 2. Visi Produk

EduQuest adalah game edukasi berbasis petualangan, quest, progression,
skill tree, achievement, koleksi pengetahuan, dan tantangan.

Pemain menyelesaikan misi menggunakan kemampuan akademik dan logika.

Contoh:

-   Matematika digunakan untuk membuka jalan.
-   Sains digunakan untuk menyelesaikan eksperimen.
-   Bahasa digunakan untuk memecahkan teka-teki.
-   Pengetahuan umum digunakan untuk membuka kartu koleksi.
-   Logika digunakan untuk menyelesaikan puzzle.

Tujuan jangka panjang:

1.  Membuat belajar terasa seperti bermain.
2.  Membuat anak termotivasi oleh progress, bukan hanya nilai.
3.  Membuat kesalahan terasa sebagai bagian dari proses belajar.
4.  Menyediakan pengalaman berbeda untuk SD, SMP, dan SMA.
5.  Tetap dapat dimainkan tanpa internet.
6.  Menjaga biaya operasional sangat rendah.
7.  Dapat dikembangkan bertahun-tahun tanpa harus membangun ulang
    aplikasi.

------------------------------------------------------------------------

# 3. Prinsip Produk

## 3.1 Offline First

Fungsi utama harus berjalan tanpa internet:

-   bermain quest
-   menjawab soal
-   mendapatkan XP
-   level up
-   achievement
-   skill tree
-   knowledge card
-   statistik lokal
-   daily mission yang sudah tersedia
-   progress pemain

Internet hanya diperlukan untuk fungsi tambahan seperti:

-   iklan
-   pembelian Premium
-   sinkronisasi opsional jika kelak ditambahkan
-   distribusi konten baru jika arsitektur remote-content ditambahkan

## 3.2 Learning Through Gameplay

Jangan membuat alur:

`Soal -> Jawab -> Nilai`

Gunakan:

`Quest -> Tantangan -> Pengetahuan -> Aksi -> Reward -> Progress`

## 3.3 Progress Lebih Penting daripada Kesempurnaan

Pemain tetap mendapat reward karena:

-   mencoba
-   memperbaiki kesalahan
-   menyelesaikan tantangan
-   mempelajari konsep
-   menyelesaikan misi

## 3.4 Sesuai Usia

SD, SMP, dan SMA tidak hanya berbeda pada tingkat kesulitan soal.

Perbedaannya juga mencakup:

-   visual
-   bahasa
-   mekanik game
-   kompleksitas quest
-   jenis reward
-   tingkat problem solving

------------------------------------------------------------------------

# 4. Target Pengguna

## 4.1 SD

Fokus:

-   membaca
-   matematika dasar
-   sains dasar
-   pengetahuan umum
-   puzzle sederhana
-   eksplorasi

Gaya:

-   warna cerah
-   karakter ramah
-   animasi ringan
-   instruksi pendek
-   reward cepat

## 4.2 SMP

Fokus:

-   matematika
-   IPA
-   bahasa
-   IPS
-   logika
-   problem solving
-   pengetahuan umum

Gaya:

-   lebih kompetitif
-   lebih banyak strategi
-   quest lebih kompleks
-   challenge bertingkat

## 4.3 SMA

Fokus:

-   matematika
-   fisika
-   kimia
-   biologi
-   bahasa
-   ekonomi
-   logika
-   problem solving
-   literasi digital

Gaya:

-   lebih serius
-   problem solving dunia nyata
-   simulasi sederhana
-   misi berbasis keputusan

------------------------------------------------------------------------

# 5. Konsep Gameplay Utama

Game loop:

``` text
LOGIN / PILIH PROFIL
        |
        v
   HOME / WORLD MAP
        |
        v
   PILIH QUEST
        |
        v
    TANTANGAN
        |
        v
   JAWAB / PUZZLE
        |
   +----+----+
   |         |
 BENAR     SALAH
   |         |
   v         v
 XP/REWARD  PENJELASAN
   |         |
   +----+----+
        |
        v
   QUEST SELESAI
        |
        v
     LEVEL UP
        |
        v
   SKILL / ITEM
        |
        v
 AREA / QUEST BARU
```

------------------------------------------------------------------------

# 6. Dunia Game

MVP dimulai dengan satu dunia:

## World 01 --- Kota Pengetahuan

Area:

1.  Math Valley
2.  Science Lab
3.  Language Library
4.  Logic Forest
5.  Knowledge Museum

Setiap area memiliki quest.

### Pengembangan berikutnya

World 02 --- Space Station

World 03 --- Lost Civilization

World 04 --- Future City

World 05 --- Earth Explorer

World 06 --- Innovation Lab

------------------------------------------------------------------------

# 7. Quest System

Setiap quest memiliki:

-   ID
-   nama
-   deskripsi
-   level minimum
-   subject
-   difficulty
-   daftar challenge
-   XP reward
-   item reward
-   achievement terkait

Contoh:

``` text
Quest:
"Jembatan Kota Rusak"

Subject:
Matematika

Challenge:
Hitung panjang bahan yang diperlukan.

Reward:
+150 XP
+1 Knowledge Card
+25 Coins
```

------------------------------------------------------------------------

# 8. Sistem Soal

Database soal harus mendukung berbagai tipe.

## 8.1 Multiple Choice

Empat pilihan jawaban.

## 8.2 True / False

Cocok untuk pengetahuan umum dan sains.

## 8.3 Input Answer

Pemain mengetik jawaban.

## 8.4 Matching

Pasangkan konsep dengan jawaban.

## 8.5 Ordering

Urutkan:

-   angka
-   proses
-   kejadian sejarah
-   langkah eksperimen

## 8.6 Puzzle

Contoh:

-   pola angka
-   logika
-   susunan objek
-   urutan
-   klasifikasi

## 8.7 Scenario Decision

Terutama untuk SMP/SMA.

Contoh:

> Kamu memiliki modal Rp1.000.000. Pilih strategi bisnis yang
> menghasilkan keuntungan terbaik.

------------------------------------------------------------------------

# 9. Sistem Difficulty

Gunakan:

``` text
Easy
Normal
Hard
Expert
Master
```

Kesulitan dapat dipengaruhi oleh:

-   tingkat pendidikan
-   kelas
-   subject
-   topik
-   tingkat penguasaan pemain

------------------------------------------------------------------------

# 10. Sistem XP

Contoh:

``` text
Jawaban benar          +100 XP
Quest selesai          +150 XP
Soal sulit             +150 XP
Menyelesaikan puzzle   +200 XP
Mencoba ulang          +20 XP
Daily Mission selesai  +300 XP
```

XP digunakan untuk:

-   naik level
-   membuka area
-   membuka skill
-   membuka kosmetik

XP tidak boleh menjadi sistem yang membuat pemain harus membayar untuk
menang.

------------------------------------------------------------------------

# 11. Level System

Contoh:

``` text
Level 1
Level 2
Level 3
...
Level 50
```

Setiap level dapat membuka:

-   quest
-   skill
-   knowledge card
-   avatar item
-   title
-   area baru

Contoh title:

``` text
Level 5  : Curious Learner
Level 10 : Knowledge Explorer
Level 20 : Problem Solver
Level 30 : Young Scholar
Level 40 : Knowledge Master
Level 50 : EduQuest Legend
```

------------------------------------------------------------------------

# 12. Skill Tree

Skill tree menjadi salah satu sistem utama.

``` text
                KNOWLEDGE
                    |
        +-----------+-----------+
        |           |           |
    MATHEMATICS    SCIENCE     LANGUAGE
        |           |           |
      Algebra     Physics     English
        |           |           |
     Geometry    Chemistry    Writing
```

Skill memberikan:

-   akses quest
-   bonus XP tertentu
-   akses challenge
-   kosmetik
-   knowledge card

Skill tidak boleh membuat pemain yang membayar menjadi jauh lebih kuat
secara akademik.

------------------------------------------------------------------------

# 13. Knowledge Card

Setiap penyelesaian quest tertentu memberikan kartu pengetahuan.

Contoh:

``` text
KNOWLEDGE CARD

Nama:
Saturnus

Kategori:
Space

Fakta:
Planet keenam dari Matahari.

Unlocked:
YES

Quiz:
3 pertanyaan
```

Kategori:

-   Space
-   Animals
-   Science
-   Earth
-   History
-   Technology
-   Human Body
-   Culture
-   Mathematics
-   Environment

Koleksi:

``` text
Space       24 / 50
Animals     31 / 50
Science     27 / 50
History     15 / 50
Technology  12 / 30
```

------------------------------------------------------------------------

# 14. Achievement System

Contoh:

### Math Explorer

Selesaikan 100 soal matematika.

### Science Master

Kuasai 10 topik sains.

### Never Give Up

Berhasil setelah melakukan beberapa percobaan.

### Speed Thinker

Selesaikan tantangan dengan waktu terbaik.

### Knowledge Collector

Kumpulkan 50 Knowledge Card.

### Daily Learner

Selesaikan Daily Mission selama beberapa hari.

Achievement harus mendorong perilaku belajar positif, bukan sekadar
bermain lebih lama.

------------------------------------------------------------------------

# 15. Daily Mission

Daily Mission menjadi fitur retention utama.

Contoh:

``` text
TODAY'S MISSION

[ ] 3 Matematika
[ ] 2 Sains
[ ] 2 Bahasa
[ ] 1 Puzzle Logika

Reward:
+500 XP
+1 Knowledge Card
+1 Achievement Progress
```

Target waktu:

**5--15 menit per hari.**

Jangan mendesain sistem yang memaksa anak bermain berjam-jam.

------------------------------------------------------------------------

# 16. Streak

Contoh:

``` text
🔥 1 Day
🔥 3 Days
🔥 7 Days
🔥 14 Days
🔥 30 Days
```

Streak dapat memberikan:

-   badge
-   kosmetik
-   knowledge card
-   bonus kecil

Sediakan mekanisme yang tidak menghukum anak secara berlebihan ketika
melewatkan hari.

------------------------------------------------------------------------

# 17. Reward System

Reward dapat berupa:

-   XP
-   Coins
-   Knowledge Card
-   Badge
-   Avatar Item
-   Title
-   Area Unlock
-   Achievement

Hindari loot box berbayar untuk anak.

------------------------------------------------------------------------

# 18. Avatar

Pemain dapat memilih karakter.

Contoh:

-   robot
-   explorer
-   scientist
-   inventor
-   astronaut

Kosmetik:

-   pakaian
-   topi
-   backpack
-   badge
-   pet

Avatar sebaiknya kosmetik dan tidak menciptakan pay-to-win.

------------------------------------------------------------------------

# 19. Pet System

Fitur fase lanjutan.

Contoh:

``` text
Knowledge Pet

🦉 Owl
Bonus visual: Science

🤖 Robot
Bonus visual: Technology

🦊 Fox
Bonus visual: Logic
```

Pet dapat berkembang berdasarkan progress belajar.

------------------------------------------------------------------------

# 20. Mode Belajar

Selain Adventure Mode:

## Practice Mode

Pemain memilih:

-   subject
-   kelas
-   topik
-   difficulty

## Quick Challenge

5 soal cepat.

## Daily Challenge

Tantangan harian.

## Review Mistakes

Soal-soal yang sebelumnya salah.

Fitur **Review Mistakes** sangat penting karena langsung mengubah
kesalahan menjadi pembelajaran.

------------------------------------------------------------------------

# 21. Sistem Penjelasan Jawaban

Jangan hanya:

`Salah.`

Gunakan:

``` text
❌ Jawaban belum tepat.

Jawaban yang benar:
24

Mengapa?
Karena 6 × 4 = 24.

Tips:
Perkalian adalah penjumlahan berulang.
```

Untuk level lebih tinggi, penjelasan dapat lebih lengkap.

------------------------------------------------------------------------

# 22. Sistem Adaptive Learning

Fase lanjutan.

Game mencatat:

-   soal benar
-   soal salah
-   waktu menjawab
-   topik lemah
-   topik kuat
-   tingkat kesulitan

Kemudian memberikan rekomendasi:

``` text
Rekomendasi Hari Ini

Matematika:
Pecahan — perlu latihan

Sains:
Sistem tata surya — bagus

Bahasa:
Grammar — perlu latihan
```

------------------------------------------------------------------------

# 23. Parent Mode

Fase lanjutan.

Orang tua dapat melihat:

-   waktu belajar
-   subject yang dipelajari
-   progress
-   topik yang dikuasai
-   topik yang perlu latihan
-   achievement

Contoh:

``` text
WEEKLY LEARNING

Matematika     ████████ 80%
Sains          ██████   60%
Bahasa         █████████ 90%
Logika         ███████  70%

Total:
42 menit
```

Parent Mode harus memprioritaskan informasi pendidikan, bukan metrik
engagement semata.

------------------------------------------------------------------------

# 24. Arsitektur Aplikasi

Gunakan pendekatan modular.

``` text
app/
├── core/
│   ├── database/
│   ├── navigation/
│   ├── theme/
│   ├── utilities/
│   └── constants/
│
├── data/
│   ├── questions/
│   ├── quests/
│   ├── knowledge/
│   ├── achievements/
│   └── lessons/
│
├── domain/
│   ├── player/
│   ├── quest/
│   ├── learning/
│   ├── reward/
│   └── progression/
│
├── feature/
│   ├── onboarding/
│   ├── home/
│   ├── world/
│   ├── quest/
│   ├── quiz/
│   ├── skill/
│   ├── achievement/
│   ├── collection/
│   ├── profile/
│   └── settings/
│
└── monetization/
    ├── ads/
    └── premium/
```

------------------------------------------------------------------------

# 25. Database Lokal

Gunakan database lokal Android yang sesuai dengan stack aplikasi.

Entitas minimal:

``` text
Player
Profile
Question
AnswerOption
Subject
Topic
Quest
QuestProgress
PlayerAnswer
XPTransaction
Achievement
PlayerAchievement
Skill
PlayerSkill
KnowledgeCard
PlayerCard
DailyMission
DailyMissionProgress
AvatarItem
PlayerItem
Settings
```

------------------------------------------------------------------------

# 26. Contoh Struktur Question

``` text
Question
---------
id
educationLevel
grade
subjectId
topicId
difficulty
questionText
questionType
options
correctAnswer
explanation
xpReward
timeLimit
```

------------------------------------------------------------------------

# 27. Contoh Struktur Quest

``` text
Quest
-----
id
worldId
title
description
educationLevel
grade
subjectId
difficulty
xpReward
coinReward
unlockRequirement
```

------------------------------------------------------------------------

# 28. Contoh Player

``` text
Player
------
id
name
educationLevel
grade
level
xp
coins
currentWorld
currentQuest
createdAt
lastPlayedAt
```

------------------------------------------------------------------------

# 29. Content Strategy

Konten adalah aset terbesar game.

Jangan menanam seluruh soal langsung di source code.

Pisahkan:

``` text
GAME ENGINE
+
CONTENT DATABASE
```

Dengan begitu:

-   soal dapat diperbarui
-   kesalahan soal dapat diperbaiki
-   konten baru dapat ditambahkan
-   developer tidak perlu mengubah game engine

MVP tetap dapat memakai database lokal.

Fase selanjutnya dapat menggunakan **content pack** yang dapat diunduh
secara opsional.

------------------------------------------------------------------------

# 30. Content Pack

Struktur masa depan:

``` text
Base App
    |
    +-- SD Pack
    +-- SMP Pack
    +-- SMA Pack
    +-- Math Pack
    +-- Science Pack
    +-- English Pack
    +-- History Pack
```

Keuntungan:

-   APK tidak perlu terlalu besar
-   konten dapat diperbarui
-   konten premium dapat dipisahkan
-   event khusus dapat dibuat

------------------------------------------------------------------------

# 31. Offline Architecture

Prinsip:

``` text
UI
 |
ViewModel / State
 |
Domain
 |
Repository
 |
Local Database
```

Tidak boleh ada ketergantungan internet untuk gameplay dasar.

Jika internet tersedia:

``` text
Local Data
    |
Optional Sync / Content Update
    |
Server / Static Content
```

------------------------------------------------------------------------

# 32. Hosting

MVP:

**Tidak membutuhkan server.**

Konten awal dapat dibundel di aplikasi.

Fase lanjutan dapat memakai sumber statis murah atau gratis untuk
content update, selama keamanan, lisensi, integritas konten, dan
kebijakan platform diperhatikan.

Jangan membuat backend kompleks sebelum benar-benar diperlukan.

------------------------------------------------------------------------

# 33. Monetisasi

## Free Tier

-   game inti
-   quest dasar
-   beberapa world
-   iklan terbatas
-   daily mission

## Premium

Contoh:

``` text
EduQuest Premium

✓ Tanpa iklan
✓ Semua World
✓ Semua Quest Premium
✓ Semua Knowledge Card
✓ Avatar tambahan
✓ Statistik belajar
✓ Review Mistakes lanjutan
✓ Content Pack Premium
```

## Rewarded Ads

Dapat digunakan untuk bonus terbatas seperti:

-   Extra Life
-   bonus XP
-   bonus coin
-   membuka bonus kosmetik

Namun seluruh desain iklan harus mengikuti kebijakan Google Play dan
AdMob yang berlaku untuk konten yang ditujukan kepada anak.

------------------------------------------------------------------------

# 34. Prinsip Monetisasi Anak

Jangan:

-   memaksa anak menonton iklan
-   membuat iklan menutupi gameplay
-   membuat pembelian sulit dibedakan dari reward
-   membuat pay-to-win
-   menggunakan mekanisme manipulatif
-   mengeksploitasi rasa takut kehilangan progress

Prioritas:

**orang tua merasa aman menggunakan aplikasi.**

------------------------------------------------------------------------

# 35. MVP --- Versi 0.1

Jangan langsung membuat SD + SMP + SMA lengkap.

MVP harus sangat kecil.

## Scope MVP

### Gameplay

-   1 World
-   3 area
-   3 subject
-   100 soal
-   20 quest
-   10 level
-   XP
-   Level Up
-   Achievement
-   Daily Mission
-   Knowledge Card

### Subject

SD sebagai target pertama:

1.  Matematika
2.  Sains
3.  Bahasa

### UI

-   Splash
-   Onboarding
-   Pilih kelas
-   Home
-   World Map
-   Quest Detail
-   Quiz
-   Result
-   Profile
-   Achievement
-   Knowledge Collection
-   Settings

------------------------------------------------------------------------

# 36. MVP Game Loop

``` text
OPEN APP
   ↓
SELECT PROFILE
   ↓
HOME
   ↓
DAILY MISSION
   ↓
WORLD
   ↓
QUEST
   ↓
3–5 CHALLENGES
   ↓
RESULT
   ↓
XP
   ↓
LEVEL UP
   ↓
REWARD
   ↓
NEXT QUEST
```

------------------------------------------------------------------------

# 37. Roadmap Pengembangan

## Phase 0 --- Planning

-   finalisasi konsep
-   desain database
-   desain navigation
-   definisi game rules
-   definisi coding standards
-   definisi content format

Output:

`PROJECT_SPEC.md`

------------------------------------------------------------------------

## Phase 1 --- Technical Foundation

-   project Android
-   theme
-   navigation
-   local database
-   repository
-   state management
-   logging
-   error handling

Output:

Aplikasi dapat berjalan.

------------------------------------------------------------------------

## Phase 2 --- Core Gameplay

-   player
-   XP
-   level
-   question engine
-   answer checking
-   explanation
-   quest engine

Output:

Game sudah dapat dimainkan dari awal sampai akhir quest.

------------------------------------------------------------------------

## Phase 3 --- Progression

-   achievement
-   skill
-   knowledge card
-   rewards
-   unlock system

Output:

Pemain mempunyai alasan untuk terus berkembang.

------------------------------------------------------------------------

## Phase 4 --- Content

-   100 soal
-   20 quest
-   3 subject
-   1 world
-   balancing difficulty

Output:

MVP playable.

------------------------------------------------------------------------

## Phase 5 --- UX Polish

-   animasi
-   sound effect
-   feedback
-   onboarding
-   accessibility
-   loading
-   empty states
-   error states

------------------------------------------------------------------------

## Phase 6 --- Monetization

-   AdMob
-   rewarded ad
-   Premium
-   purchase flow
-   ad-free state
-   consent/privacy implementation

Monetisasi baru dimasukkan setelah gameplay inti stabil.

------------------------------------------------------------------------

## Phase 7 --- Testing

### Functional Testing

-   soal
-   XP
-   level
-   achievement
-   reward
-   database

### Edge Case

-   aplikasi ditutup saat quiz
-   device rotate jika relevan
-   database kosong
-   progress corrupt
-   jawaban kosong
-   double tap
-   offline
-   internet berubah saat bermain

### UX Testing

-   anak memahami tombol?
-   instruksi jelas?
-   reward terasa?
-   soal terlalu sulit?
-   game terlalu lama?

------------------------------------------------------------------------

# 38. Phase 2 Setelah MVP

Setelah MVP terbukti:

### SD

-   kelas 1--6
-   matematika
-   IPA
-   Bahasa Indonesia
-   Bahasa Inggris
-   IPS

### SMP

-   kelas 7--9
-   matematika
-   IPA
-   Bahasa
-   IPS
-   logika

### SMA

-   kelas 10--12
-   matematika
-   fisika
-   kimia
-   biologi
-   ekonomi
-   bahasa

------------------------------------------------------------------------

# 39. Phase 3 --- Advanced Learning

-   adaptive learning
-   rekomendasi soal
-   review mistakes
-   learning analytics
-   parent mode
-   progress report
-   content packs

------------------------------------------------------------------------

# 40. Phase 4 --- Advanced Game

-   pet
-   avatar customization
-   mini games
-   boss challenge
-   seasonal event
-   special quest
-   world baru
-   cooperative challenge jika suatu saat diperlukan

Multiplayer tidak menjadi prioritas awal karena meningkatkan
kompleksitas server, moderasi, keamanan, dan biaya.

------------------------------------------------------------------------

# 41. Struktur Folder Project

Contoh:

``` text
EduQuest/
├── .github/
├── docs/
│   ├── PROJECT_SPEC.md
│   ├── GAME_DESIGN.md
│   ├── DATABASE.md
│   ├── CONTENT_GUIDE.md
│   ├── MONETIZATION.md
│   ├── TESTING.md
│   └── CHANGELOG.md
│
├── app/
│   └── ...
│
├── content/
│   ├── questions/
│   ├── quests/
│   ├── knowledge/
│   └── achievements/
│
└── README.md
```

------------------------------------------------------------------------

# 42. Workflow VS Code + Antigravity

Jangan meminta AI membuat seluruh aplikasi sekaligus.

Gunakan pendekatan:

``` text
PLAN
 ↓
IMPLEMENT
 ↓
BUILD
 ↓
TEST
 ↓
FIX
 ↓
DOCUMENT
 ↓
NEXT TASK
```

Setiap task harus kecil.

Contoh:

``` text
TASK-001
Create local database schema.

TASK-002
Create Player entity.

TASK-003
Create Question entity.

TASK-004
Create quiz screen.

TASK-005
Implement answer validation.

TASK-006
Implement XP system.
```

Setelah setiap task:

1.  build
2.  test
3.  review
4.  commit

------------------------------------------------------------------------

# 43. Aturan untuk Antigravity

Instruksi utama:

> Jangan mengubah file yang tidak berhubungan dengan task.
>
> Jangan menghapus fitur yang sudah bekerja.
>
> Sebelum coding, pahami struktur project.
>
> Implementasikan perubahan sekecil mungkin.
>
> Setelah implementasi, lakukan build/test.
>
> Jika ada error, perbaiki error tersebut sebelum melanjutkan.
>
> Dokumentasikan perubahan penting.
>
> Jangan menambahkan dependency baru jika tidak diperlukan.
>
> Prioritaskan solusi offline-first.
>
> Jangan membuat backend sebelum benar-benar dibutuhkan.

------------------------------------------------------------------------

# 44. Git Strategy

Branch:

``` text
main
develop
feature/*
fix/*
```

Contoh:

``` text
feature/player-system
feature/quiz-engine
feature/xp-system
feature/achievement
```

Commit:

``` text
feat: add player database
feat: add quiz engine
feat: add xp progression
fix: prevent duplicate reward
```

------------------------------------------------------------------------

# 45. Definition of Done

Sebuah fitur dianggap selesai jika:

-   kode selesai
-   build berhasil
-   tidak ada error baru
-   fungsi berjalan
-   edge case dasar ditangani
-   UI dapat digunakan
-   database migration aman jika ada
-   dokumentasi diperbarui
-   tidak merusak fitur sebelumnya

------------------------------------------------------------------------

# 46. Testing Matrix

Minimal:

``` text
Android version
Screen size
Offline
Online
Fresh install
Existing database
Empty state
Low battery scenario
App restart
Process recreation
```

Untuk MVP tidak perlu mengejar semua device sekaligus.

Prioritaskan perangkat Android low-end sampai mid-range karena target
pengguna anak sangat luas.

------------------------------------------------------------------------

# 47. Performance

Prioritas:

-   startup cepat
-   penggunaan RAM rendah
-   database query efisien
-   animasi ringan
-   asset terkompresi
-   tidak melakukan network request yang tidak perlu
-   game dapat dimainkan di perangkat kelas bawah

------------------------------------------------------------------------

# 48. Accessibility

Pertimbangkan:

-   ukuran font
-   kontras
-   touch target
-   teks alternatif jika diperlukan
-   feedback visual + audio
-   jangan mengandalkan warna saja
-   instruksi sederhana

------------------------------------------------------------------------

# 49. Sound

MVP cukup:

-   correct answer
-   wrong answer
-   button click
-   reward
-   level up
-   achievement

Sediakan:

`Sound ON/OFF`

dan

`Music ON/OFF`

------------------------------------------------------------------------

# 50. Analytics

Jika analytics ditambahkan, gunakan secara minimal dan
privacy-conscious.

Yang lebih penting untuk MVP:

-   quest selesai
-   soal sering salah
-   crash
-   retention agregat
-   conversion Premium

Jangan mengumpulkan data pribadi anak yang tidak diperlukan.

------------------------------------------------------------------------

# 51. Privacy & Child Safety

Karena target termasuk anak-anak, privacy dan child safety harus menjadi
bagian desain sejak awal.

Checklist:

-   minimalkan data pribadi
-   jangan meminta data yang tidak diperlukan
-   parent mode dipikirkan sejak desain awal
-   iklan mengikuti aturan untuk audiens anak
-   consent/privacy flow sesuai wilayah target
-   hindari chat bebas antar pengguna
-   hindari fitur sosial yang membutuhkan moderasi pada MVP
-   jangan menggunakan dark pattern

Sebelum publikasi, kebijakan Google Play, AdMob, dan aturan privasi yang
berlaku harus diperiksa kembali karena dapat berubah.

------------------------------------------------------------------------

# 52. Content Quality

Setiap soal harus melalui checklist:

``` text
[ ] Jawaban benar
[ ] Tidak ambigu
[ ] Bahasa sesuai usia
[ ] Tidak memiliki typo
[ ] Penjelasan tersedia
[ ] Tingkat kesulitan sesuai
[ ] Tidak mengandung informasi menyesatkan
[ ] Tidak membutuhkan internet
```

Untuk materi akademik, sebaiknya konten ditinjau dengan referensi
kurikulum dan/atau reviewer manusia.

------------------------------------------------------------------------

# 53. Sistem Content Versioning

Setiap content pack mempunyai:

``` text
contentVersion
minAppVersion
packId
updatedAt
```

Contoh:

``` text
SD-MATH-001
version: 1.2
minAppVersion: 1.0.0
```

Ini memudahkan update konten tanpa mengubah game engine.

------------------------------------------------------------------------

# 54. Future Remote Content

Jika aplikasi sudah memiliki pengguna:

``` text
APP
 |
 +-- Local Content
 |
 +-- Content Manifest
          |
          v
    Optional Remote
          |
          v
     New Content Pack
```

Aplikasi tetap dapat bermain dengan konten lama ketika offline.

------------------------------------------------------------------------

# 55. Strategi Peluncuran

Jangan langsung:

> SD + SMP + SMA + 1.000 soal + 10 dunia.

Lebih baik:

### Release 1

**EduQuest SD**

-   1 dunia
-   3 subject
-   100 soal
-   20 quest

Kemudian ukur:

-   apakah anak memahami gameplay?
-   apakah quest menyenangkan?
-   apakah soal terlalu mudah?
-   apakah retention bagus?
-   apakah orang tua memahami manfaatnya?

Baru diperluas.

------------------------------------------------------------------------

# 56. Roadmap 12 Bulan

## Bulan 1

Foundation:

-   project
-   architecture
-   database
-   navigation

## Bulan 2

Core gameplay:

-   quiz
-   quest
-   answer
-   XP

## Bulan 3

Progression:

-   level
-   achievement
-   reward
-   knowledge card

## Bulan 4

MVP content:

-   100 soal
-   20 quest
-   3 subject

## Bulan 5

Polish:

-   UI
-   animation
-   sound
-   onboarding

## Bulan 6

Testing + closed beta.

## Bulan 7

Monetization + Premium.

## Bulan 8

Public launch.

## Bulan 9

Content update.

## Bulan 10

Adaptive learning.

## Bulan 11

Parent mode.

## Bulan 12

World 2 + content expansion.

------------------------------------------------------------------------

# 57. KPI Produk

Jangan hanya mengukur revenue.

## Learning KPI

-   soal diselesaikan
-   topik dikuasai
-   kesalahan yang diperbaiki
-   quest selesai

## Product KPI

-   D1 retention
-   D7 retention
-   session length
-   quest completion

## Monetization KPI

-   Premium conversion
-   rewarded ad usage
-   ARPU
-   ad revenue

## Quality KPI

-   crash-free sessions
-   ANR
-   bug reports

------------------------------------------------------------------------

# 58. Prioritas Fitur

Gunakan:

### P0 --- Wajib MVP

-   offline
-   quiz
-   quest
-   XP
-   level
-   reward
-   local database
-   100 soal
-   20 quest

### P1 --- Setelah MVP

-   achievement
-   knowledge collection
-   daily mission
-   skill tree
-   sound
-   avatar

### P2 --- Advanced

-   adaptive learning
-   parent mode
-   content packs
-   cloud backup/sync

### P3 --- Sangat lanjut

-   multiplayer
-   social
-   real-time competition

P3 bukan prioritas.

------------------------------------------------------------------------

# 59. Risiko Utama

## Risiko 1 --- Game Terasa Seperti Aplikasi Soal

Solusi:

-   quest
-   world
-   karakter
-   puzzle
-   progression

## Risiko 2 --- Konten Cepat Habis

Solusi:

-   content pack
-   database modular
-   sistem generator soal yang terkontrol
-   update berkala

## Risiko 3 --- Terlalu Besar untuk MVP

Solusi:

> Mulai dengan satu dunia dan 100 soal.

## Risiko 4 --- Monetisasi Mengganggu Anak

Solusi:

-   iklan terbatas
-   premium ad-free
-   tidak pay-to-win
-   desain child-safe

## Risiko 5 --- Maintenance Sulit

Solusi:

-   modular architecture
-   dokumentasi
-   coding standards
-   small commits
-   automated tests

------------------------------------------------------------------------

# 60. Urutan Implementasi yang Disarankan

``` text
01. Project setup
02. Architecture
03. Theme
04. Navigation
05. Database
06. Player
07. Question
08. Quiz Engine
09. Quest Engine
10. XP
11. Level
12. Reward
13. Achievement
14. Knowledge Card
15. Daily Mission
16. World Map
17. Profile
18. Settings
19. Sound
20. Polish
21. Testing
22. Monetization
23. Release
```

Jangan melompat ke monetisasi sebelum core gameplay stabil.

------------------------------------------------------------------------

# 61. Backlog Awal

``` text
[ ] Create Android project
[ ] Configure build system
[ ] Create package structure
[ ] Create theme
[ ] Create navigation
[ ] Create database
[ ] Create Player entity
[ ] Create Question entity
[ ] Create Quest entity
[ ] Create XP system
[ ] Create Level system
[ ] Create Quiz screen
[ ] Create Quest screen
[ ] Create Result screen
[ ] Create World screen
[ ] Create Achievement
[ ] Create Knowledge Card
[ ] Create Daily Mission
[ ] Add 100 questions
[ ] Add 20 quests
[ ] Add 3 subjects
[ ] Add sound
[ ] Add onboarding
[ ] Test offline
[ ] Test fresh install
[ ] Test app restart
[ ] Optimize performance
[ ] Prepare release build
```

------------------------------------------------------------------------

# 62. Milestone MVP

MVP dianggap berhasil jika seorang anak dapat:

1.  membuka aplikasi
2.  memilih jenjang/kelas
3.  melihat world
4.  memilih quest
5.  memainkan quest
6.  menjawab soal
7.  melihat penjelasan
8.  memperoleh XP
9.  naik level
10. mendapatkan reward
11. membuka quest berikutnya
12. melihat achievement
13. mengumpulkan knowledge card
14. menyelesaikan daily mission
15. bermain tanpa internet

------------------------------------------------------------------------

# 63. Filosofi Produk

EduQuest harus selalu kembali pada tiga pertanyaan:

### Apakah ini menyenangkan?

Jika tidak, perbaiki gameplay.

### Apakah ini membuat anak belajar?

Jika tidak, perbaiki mekanisme pembelajarannya.

### Apakah ini aman untuk anak?

Jika tidak, jangan dirilis.

------------------------------------------------------------------------

# 64. Prinsip Akhir

Jangan membangun:

> **"Aplikasi soal dengan karakter."**

Bangun:

> **"Game petualangan yang membuat pengetahuan menjadi kekuatan
> pemain."**

Anak harus berpikir:

> "Aku ingin membuka area berikutnya."

Sementara orang tua berpikir:

> "Anak saya ternyata belajar."

Itulah positioning utama EduQuest.

------------------------------------------------------------------------

# 65. Next Step Setelah Dokumen Ini

Urutan kerja yang disarankan di VS Code + Antigravity:

``` text
STEP 1
Buat project Android kosong.

STEP 2
Buat PROJECT_SPEC.md.

STEP 3
Buat struktur architecture.

STEP 4
Implement database.

STEP 5
Implement Player.

STEP 6
Implement Question.

STEP 7
Implement Quiz Engine.

STEP 8
Implement Quest Engine.

STEP 9
Implement XP + Level.

STEP 10
Implement Reward.

STEP 11
Implement World.

STEP 12
Masukkan 20 quest + 100 soal.

STEP 13
Implement Achievement + Knowledge Card.

STEP 14
Implement Daily Mission.

STEP 15
Testing.

STEP 16
Polish.

STEP 17
Baru integrasikan monetisasi.
```

**Target pertama bukan membuat game besar.**

Target pertama adalah membuat **satu quest kecil yang benar-benar
menyenangkan dimainkan dan benar-benar mengajarkan sesuatu.**

Setelah loop tersebut terbukti, seluruh game dapat dibangun di atas
fondasi yang sama.
