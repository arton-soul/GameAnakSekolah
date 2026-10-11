# EduQuest — Progress Tracker

Dokumen ini mencatat perkembangan, status pengerjaan, dan riwayat setiap task pada proyek **EduQuest** sesuai dengan spesifikasi teknis di `PROJECT_SPEC.md` dan `rancangangame.md`.

---

## 📌 Ringkasan Status Proyek

| Informasi | Keterangan |
|---|---|
| **Nama Proyek** | EduQuest |
| **Platform** | Android |
| **Application ID** | `com.example.eduquest` |
| **Tech Stack** | Kotlin 2.0.0, Jetpack Compose, Material 3, Navigation Compose 2.8.0, Gradle 8.9, AGP 8.5.2 |
| **Prinsip Utama** | Offline-First, Local-First, Learning First, Clean & Modern |
| **Status Saat Ini** | **TASK-018 SELESAI** — Menunggu konfirmasi untuk TASK-019 |
| **Task Selanjutnya** | `TASK-019 — Release Preparation` |
---

## 📋 Roadmap & Status Task

| Task ID | Nama Task | Deskripsi Singkat | Status | Tanggal Selesai |
|---|---|---|:---:|:---:|
| **TASK-001** | **Project Bootstrap** | Inisialisasi Android project, Compose, M3 theme, Gradle, fondasi UI | **DONE** | 2026-10-07 |
| **TASK-002** | **Navigation** | Routing Compose (Onboarding, Home, World, Quest, Quiz, Result, dll.) | **DONE** | 2026-10-07 |
| **TASK-003** | **Database Foundation** | Room setup, entitas lokal, DAO, dan database offline | **DONE** | 2026-10-07 |
| **TASK-004** | **Player** | Create, load, update player progress & local persistence | **DONE** | 2026-10-08 |
| **TASK-005** | **Question Engine** | Engine pemrosesan soal, jawaban, validasi, dan penjelasan | **DONE** | 2026-10-07 |
| **TASK-006** | **Quest Engine** | List quest, detail, progres quest, dan logika penyelesaian | **DONE** | 2026-10-07 |
| **TASK-007** | **XP + Level** | Kalkulasi XP, persistence, level up system, dan event | **DONE** | 2026-10-07 |
| **TASK-008** | **Reward** | Sistem koin, hadiah quest, dan proteksi duplikasi reward | **DONE** | 2026-10-08 |
| **TASK-009** | **Achievement** | Tracking progres achievement, unlock, dan reward | **DONE** | 2026-10-08 |
| **TASK-010** | **Knowledge Card** | Koleksi kartu edukasi, unlock, dan tampilan detail | **DONE** | 2026-10-08 |
| **TASK-011** | **Daily Mission** | Daily generator, tracking progres harian, reset, dan reward | **DONE** | 2026-10-08 |
| **TASK-012** | **World UI** | Tampilan map dunia, area/subject, dan status unlock quest | **DONE** | 2026-10-08 |
| **TASK-013** | **Home UI** | Dashboard utama (XP, level, misi harian, tombol continue) | **DONE** | 2026-10-08 |
| **TASK-014** | **Profile** | Layar profil pemain, statistik belajar, jumlah kartu & badge | **DONE** | 2026-10-08 |
| **TASK-015** | **Settings** | Pengaturan audio (Sound FX/BGM ON/OFF) & reset data lokal | **DONE** | 2026-10-08 |
| **TASK-016** | **Seed Content** | Impor 100 soal kurikulum SD, 20 quest, dan konten kartu | **DONE** | 2026-10-08 |
| **TASK-017** | **Polish** | Peningkatan UX, animasi Compose, sound feedback, dan typography | **DONE** | 2026-10-08 |
| **TASK-018** | **Testing** | Unit test komprehensif, DAO test, offline scenario testing | **DONE** | 2026-10-09 |
| **TASK-019** | **Release Preparation** | App icon final, signing, release build APK/AAB, asset store | *PLANNED* | - |

---

## 📝 Catatan Rinci Per Task

### TASK-001 — Project Bootstrap
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - Konfigurasi Gradle root dan app module (`settings.gradle.kts`, `build.gradle.kts`, `gradle/libs.versions.toml`).
  - Gradle Wrapper 8.9 terpasang dan tervalidasi.
  - Struktur package dasar:
    - `core/ui/theme` (`Color.kt`, `Type.kt`, `Theme.kt` dengan `EduQuestTheme`)
    - `core/navigation` (`.gitkeep`)
    - `core/util` (`.gitkeep`)
    - `feature/onboarding` (`.gitkeep`)
    - `feature/home` (`HomeScreen.kt`)
  - `EduQuestApplication` class dan `MainActivity` dengan edge-to-edge support.
  - Tampilan Bootstrap Screen menampilkan judul `EDUQUEST`, tagline (`Belajar.`, `Bermain.`, `Berkembang.`), dan tombol `[ Mulai ]`.
- **Hasil Verifikasi & Build:**
  - Build `assembleDebug`: `BUILD SUCCESSFUL` (APK: `app-debug.apk` 8.6 MB).
  - Unit test `testDebugUnitTest`: `BUILD SUCCESSFUL`.
  - Instalasi device fisik (`aaa1335aaabb`): Sukses, startup lancar tanpa error/crash (PID: 10284).
  - Screenshot verifikasi UI: Valid dan sesuai standar Material 3.

---

### TASK-002 — Navigation
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - Integrasi pustaka resmi `androidx.navigation:navigation-compose:2.8.0`.
  - Master Navigation Destinasi (`core/navigation/Screen.kt`):
    - `Onboarding` (`"onboarding"`)
    - `Home` (`"home"`)
    - `World` (`"world"`)
    - `QuestDetail` (`"quest/{questId}"`)
    - `Quiz` (`"quiz/{questId}"`)
    - `Result` (`"result/{questId}"`)
    - `Profile` (`"profile"`)
    - `Achievement` (`"achievement"`)
    - `Collection` (`"collection"`)
    - `DailyMission` (`"daily_mission"`)
    - `Settings` (`"settings"`)
  - Komponen Reusable `EduQuestTopBar` dengan dukungan status bar insets (`statusBarsPadding`).
  - Fitur Layar Navigasi:
    - `OnboardingScreen.kt`
    - `HomeScreen.kt` (lengkap dengan aksi navigasi utama & menu cepat)
    - `WorldScreen.kt` (daftar area subject dan tombol masuk quest)
    - `QuestDetailScreen.kt` (tampilan detail ID quest dan aksi mulai kuis)
    - `QuizScreen.kt` (simulasi kuis dan aksi submit jawaban)
    - `ResultScreen.kt` (layar hasil kuis dengan navigasi kembali ke World atau Home)
    - `ProfileScreen.kt`, `AchievementScreen.kt`, `CollectionScreen.kt`, `DailyMissionScreen.kt`, `SettingsScreen.kt` (layar pendukung).
  - `EduQuestNavHost.kt` menghubungkan seluruh rute aplikasi secara offline-first.
  - Edge-to-edge layout dioptimalkan dengan `statusBarsPadding()` dan `safeDrawingPadding()`.
  - Unit test `NavigationRoutesTest.kt` memvalidasi integritas route string dan argumen.
- **Hasil Verifikasi & Build:**
  - Build `assembleDebug`: `BUILD SUCCESSFUL`.
  - Unit test `testDebugUnitTest`: `BUILD SUCCESSFUL` (semua unit test route pass).
  - Pengujian Runtime Live di Device:
    - Transisi Home → World → QuestDetail → Quiz → Result → Home/World berjalan lancar.
    - Navigasi Home → Settings (SFX & BGM toggle) dan rute pendukung berfungsi optimal.
    - Tidak ada crash atau exception pada logcat.

---

### TASK-003 — Database Foundation
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - Integrasi KSP `2.0.0-1.0.24` dan Room Database `2.6.1` (`room-runtime`, `room-ktx`, `room-compiler`).
  - 15 Entitas Room lengkap sesuai `PROJECT_SPEC.md` Section 33:
    1. `PlayerEntity` (tabel `players`): id, nickname, avatar, educationLevel, grade, level, xp, coins, createdAt, updatedAt.
    2. `SubjectEntity` (tabel `subjects`): id, name, icon, description.
    3. `TopicEntity` (tabel `topics`): id, subjectId, grade, title, description.
    4. `QuestionEntity` (tabel `questions`): id, grade, subjectId, topicId, difficulty, type, question, optionA..D, optionsJson, answer, explanation, xp.
    5. `WorldEntity` (tabel `worlds`): id, title, description, unlockLevel, orderIndex.
    6. `QuestEntity` (tabel `quests`): id, worldId, title, description, subjectId, grade, difficulty, questionCount, xpReward, coinReward, unlockLevel.
    7. `QuestQuestionEntity` (tabel `quest_questions`): questId, questionId, orderIndex (composite PK).
    8. `QuestProgressEntity` (tabel `quest_progress`): playerId, questId, status, score, completedAt, attemptCount (composite PK).
    9. `AnswerHistoryEntity` (tabel `answer_history`): autoGenerate id, playerId, questId, questionId, selectedAnswer, isCorrect, xpEarned, answeredAt.
    10. `AchievementEntity` (tabel `achievements`): id, title, description, type, target, rewardXp, rewardCoins.
    11. `PlayerAchievementEntity` (tabel `player_achievements`): playerId, achievementId, progress, unlocked, unlockedAt (composite PK).
    12. `KnowledgeCardEntity` (tabel `knowledge_cards`): id, title, category, description, fact, imageAsset, unlockCondition.
    13. `PlayerCardEntity` (tabel `player_cards`): playerId, cardId, unlockedAt (composite PK).
    14. `DailyMissionEntity` (tabel `daily_missions`): id, title, category, targetCount, rewardXp, rewardCoins.
    15. `PlayerDailyProgressEntity` (tabel `player_daily_progress`): playerId, missionId, dateString, currentProgress, isCompleted, isClaimed (composite PK).
  - 8 Data Access Objects (DAOs):
    - `PlayerDao`, `QuestionDao`, `QuestDao`, `ProgressDao`, `AchievementDao`, `KnowledgeCardDao`, `DailyMissionDao`, `WorldDao`.
  - Database Room utama: `EduQuestDatabase` (`eduquest.db`).
  - Database Provider: `com.example.eduquest.core.database.DatabaseProvider`.
  - Inisialisasi Database pada `EduQuestApplication`.
  - Pengujian instrumen Android (`DatabaseFoundationTest.kt`):
    - `testPlayerOperations`: insert, query, update player data.
    - `testQuestOperations`: insert, query quest data.
    - `testProgressOperations`: upsert, status flow (AVAILABLE -> COMPLETED), attempt count tracking.
- **Hasil Verifikasi & Build:**
  - Build `assembleDebug`: `BUILD SUCCESSFUL` (0 error, KSP berhasil menghasilkan kode Room).
  - Instrumented Test `connectedDebugAndroidTest` pada perangkat fisik (`aaa1335aaabb`):
    - `OK (3 tests)` — 100% lulus dalam 206ms.
  - Runtime App Verification: Aplikasi berjalan normal tanpa crash (logcat bersih dari AndroidRuntime error).

---

### TASK-004 — Player
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - Model `Player.kt`: `id, nickname, avatar, educationLevel, grade, level, xp, coins, currentWorldId, createdAt, updatedAt`.
    - Interface `PlayerRepository.kt`: reactive flow `getActivePlayer()`, `createPlayer()`, `updatePlayerProfile()`, dll.
    - UseCases:
      - `GetActivePlayerUseCase.kt`: Flow reaktif pemain aktif dan getter langsung.
      - `CreatePlayerUseCase.kt`: Validasi nickname (2–20 karakter), grade (1–6 SD), dan pembuatan profil default (Level 1, 0 XP, 0 Koin).
      - `UpdatePlayerProfileUseCase.kt`: Validasi pembaruan nama panggilan, kelas, dan avatar.
  - **Data Layer:**
    - `PlayerEntity.kt`: Pembaruan entity Room dengan field `currentWorldId = "WORLD_01"` serta fungsi konversi domain mappers (`toDomain()` & `toEntity()`).
    - `PlayerDao.kt`: Method `getActivePlayerFlow()`, `getActivePlayerDirect()`, `deleteAllPlayers()`, `getPlayerCount()`.
    - `PlayerRepositoryImpl.kt`: Implementasi repositori dengan mapping Entity <-> Domain secara offline-first.
    - `EduQuestDatabase.kt`: Upgrade database Room ke versi 2.
  - **UI / Feature Layer:**
    - `AvatarHelper.kt`: Koleksi avatar petualang ramah anak (🦊 Kancil, 🦁 Singa, 🦉 Burung Hantu, 🐬 Lumba-lumba, 🦅 Elang, 🐱 Kucing).
    - `PlayerViewModel.kt`: `AndroidViewModel` dengan StateFlow `PlayerUiState` (`isLoading`, `player`, `hasPlayer`, `error`).
    - `OnboardingScreen.kt`: Form interaktif pembuatan profil petualang (pemilihan avatar scrollable horizontal, input nickname, FilterChip kelas 1–6 SD, tombol submit "Mulai Petualangan").
    - `HomeScreen.kt`:
      - Keadaan tanpa profil: Menampilkan banner ajakan "Belum Ada Profil Petualang" dan tombol "Buat Profil Petualang".
      - Keadaan berprofil: Menampilkan badge pemain ("Halo, {nickname}! SD Kelas {grade}"), avatar terpilih, serta baris statistik ("🌟 Level", "⚡ XP", "🪙 Koin").
    - `ProfileScreen.kt`: Layar detail profil pemain, statistik petualang, dan dialog interaktif "Edit Profil" (edit nama, kelas, avatar) yang langsung terupdate secara reaktif.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`PlayerUseCaseTest.kt`): 100% PASS (`testDebugUnitTest`).
    - Instrumented Tests (`DatabaseFoundationTest.kt`): 100% PASS (`OK (4 tests)` di device fisik `aaa1335aaabb` dalam 288ms).
    - Runtime UI Verification:
      - Layar Home default menampilkan prompt pembuatan profil.
      - Onboarding berjalan mulus, validasi berhasil, data tersimpan ke Room database lokal.
      - Home terupdate secara instan menampilkan profil petualang.
      - Layar Profil menampilkan data lengkap dan fitur Edit Profil berhasil memperbarui Room database serta UI secara reaktif.
      - Tidak ada error/crash pada logcat (`AndroidRuntime:E` bersih).

---

### TASK-005 — Question Engine
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - Model `Question.kt`: `id, grade, subjectId, topicId, difficulty, type, questionText, optionA, optionB, optionC, optionD, correctAnswer, explanation, xpReward` + helper `getOptions(): List<QuestionOption>`.
    - Model `AnswerValidationResult.kt`: `questionId, selectedAnswer, isCorrect, correctAnswer, explanation, xpEarned`.
    - Interface `QuestionRepository.kt`: Operasi pemuatan soal berdasarkan quest/grade/subject, penyimpanan riwayat jawaban, dan seeding otomatis.
    - UseCases:
      - `GetQuestionsForQuestUseCase.kt`: Memuat soal untuk quest dengan fallback cerdas ke pool kurikulum SD sesuai kelas pemain agar game selalu dapat dimainkan secara offline.
      - `ValidateAnswerUseCase.kt`: Validasi jawaban terhadap kunci (case-insensitive), penentuan status benar/salah, dan kalkulasi XP.
      - `RecordAnswerUseCase.kt`: Menyimpan riwayat jawaban pemain ke tabel `answer_history` lokal Room.
  - **Data Layer:**
    - `QuestionStarterData.kt`: Kumpulan starter questions kurikulum SD (Matematika, Sains/IPA, Bahasa Indonesia) dari tingkat mudah, sedang, hingga tantangan lengkap dengan penjelasan edukatif.
    - `QuestionDao.kt`: Penambahan query `getQuestionCount()`, `getQuestionsForGrade()`, dan `getAllQuestions()`.
    - `QuestionEntity.kt`: Mappers `toDomain()` dan `toEntity()`.
    - `QuestionRepositoryImpl.kt`: Repositori offline-first yang menjamin seeding data soal berjalan otomatis saat database pertama kali dibuka.
  - **Feature / UI Layer:**
    - `QuizViewModel.kt`: ViewModel mengelola `QuizUiState` (`questions`, `currentIndex`, `selectedOption`, `validationResult`, `isAnswerSubmitted`, `correctCount`, `totalXpEarned`, `isQuizFinished`, `progressPercentage`).
    - `QuizScreen.kt`:
      - Linear progress indicator progres pengerjaan ("Soal X dari Y") dan indikator reward XP.
      - Kartu soal dengan badge Subject, Topic, dan Tingkat Kesulitan.
      - Daftar opsi pilihan ganda yang interaktif dengan badge A, B, C, D.
      - Umpan balik visual instan: Opsi benar disorot warna hijau dengan centang (✓), opsi salah disorot warna merah dengan silang (✗).
      - Banner penjelasan ramah anak: "🎉 Hebat! Jawabanmu Benar! (+XP)" atau "💡 Belum Tepat (Jawaban yang benar adalah X)" disertai uraian konsep belajar yang jelas.
      - Tombol aksi transisi: "Periksa Jawaban" -> "Soal Berikutnya ➔" -> "Lihat Hasil Kuis 🎉" yang langsung mengarah ke `ResultScreen`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`QuestionEngineTest.kt`): 100% PASS (`testValidateAnswerCorrect`, `testValidateAnswerWrong`, `testValidateAnswerCaseInsensitive`, `testQuestionOptionsHelperFourOptions`, `testQuestionOptionsHelperTwoOptions`, `testQuestionValidationRules`).
    - Instrumented Tests (`DatabaseFoundationTest.kt`): 100% PASS (`OK (5 tests)` pada device fisik `aaa1335aaabb` dalam 1m 45s).
    - Runtime UI Verification:
      - Alur lengkap Home → World → QuestDetail → QuizScreen → ResultScreen berjalan mulus tanpa koneksi internet.
      - Pemilihan opsi, validasi instan, penjelasan edukatif, dan transisi ke soal berikutnya berfungsi 100%.
      - Logcat bersih tanpa error runtime (`AndroidRuntime:E` 0 error).

---

### TASK-006 — Quest Engine
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - Enum `QuestStatus.kt`: `LOCKED`, `AVAILABLE`, `IN_PROGRESS`, `COMPLETED`.
    - Model `Quest.kt`: `id, worldId, title, description, subjectId, grade, difficulty, questionCount, xpReward, coinReward, unlockLevel`.
    - Model `QuestWithProgress.kt`: `quest, status, score, attemptCount`.
    - Model `QuestCompletionResult.kt`: `questId, playerId, isCompleted, score, totalQuestions, xpEarned, coinsEarned, isFirstCompletion, completedAt`.
    - Interface `QuestRepository.kt`: Live flow quest dengan progres, get quest detail, start quest, complete quest, duplicate reward protection.
    - UseCases:
      - `GetQuestsWithProgressUseCase.kt`: Flow reaktif daftar quest yang dikombinasikan dengan level pemain dan progres pengerjaan di Room.
      - `GetQuestDetailUseCase.kt`: Memuat detail spesifik quest dengan status unlock & skor terakhir.
      - `StartQuestUseCase.kt`: Memulai quest baru (`IN_PROGRESS`).
      - `CompleteQuestUseCase.kt`: Menyelesaikan quest, kalkulasi skor, serta proteksi duplikasi reward (Section 42).
  - **Data Layer:**
    - `QuestStarterData.kt`: 9 starter quests SD lintas subjek (Matematika, Sains, Bahasa) + 15 pemetaan relasi quest ke soal kurikulum.
    - `QuestDao.kt`: Penambahan query `getAllQuestsDirect()`, `getQuestsBySubjectDirect()`, `getQuestCount()`.
    - `WorldQuestEntity.kt`: Mappers `QuestEntity.toDomain()` dan `Quest.toEntity()`.
    - `QuestRepositoryImpl.kt`: Offline-first repository yang menggabungkan status level pemain, tabel `quests`, dan `quest_progress` secara real-time, serta menjamin proteksi reward ganda saat misi diulang.
  - **Feature / UI Layer:**
    - `QuestViewModel.kt`: ViewModel state management untuk `QuestUiState` (`quests`, `questDetail`, `lastCompletionResult`, `isLoading`, `error`).
    - `QuizViewModel.kt` & `QuizScreen.kt`: Integrasi otomatis dengan `CompleteQuestUseCase` saat soal kuis terakhir selesai dijawab.
    - `WorldScreen.kt`: Filter chip interaktif per mata pelajaran, daftar 9 quest dengan badge dinamis (`⚡ Tersedia`, `🔒 Lv.2`, `⏳ Berjalan`, `✅ Selesai`), hadiah reward, dan tombol aksi adaptif (`Mulai`, `Lanjut`, `Detail`, `Ulang`).
    - `QuestDetailScreen.kt`: Menampilkan detail quest lengkap, kartu hadiah XP & Koin, jumlah soal, syarat level pembuka, dan tombol mulai/lanjut misi.
    - `ResultScreen.kt`: Kartu skor akurat (`X/Y Jawaban Benar`), indikator hadiah pertama kali atau banner proteksi duplikasi reward, dan tombol kembali ke Peta Dunia / Beranda.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`QuestEngineTest.kt`, `PlayerUseCaseTest.kt`, `QuestionEngineTest.kt`): 100% PASS (`testDebugUnitTest` `BUILD SUCCESSFUL`).
    - Instrumented Tests (`DatabaseFoundationTest.kt`): 100% PASS (`OK (6 tests)` di perangkat fisik `aaa1335aaabb` dalam 1m 58s).
    - Runtime UI Verification:
      - Alur Peta Dunia: Memuat 9 quest dari Room database lokal.
      - Filter subject (Semua, Matematika, Sains, Bahasa) menyaring daftar quest secara instan.
      - Masuk ke Quest Detail -> Mulai Petualangan -> Mengerjakan soal kuis.
      - Layar Hasil Kuis menampilkan skor akurat (misal `1/2 Jawaban Benar`) dan banner status reward.
      - Kembali ke Peta Dunia: Status quest pertama secara instan berubah menjadi `✅ Selesai` dengan tombol `Ulang` berwarna hijau.
      - Logcat bersih dari crash/error (`AndroidRuntime:E` 0 error).

---

### TASK-007 — XP + Level
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - `LevelTable.kt`: Tabel ambang batas XP Level 1–10 (0 hingga 11.000 XP) sesuai `PROJECT_SPEC.md` Section 10 & 11. Memiliki fungsi deterministik `calculateLevel(xp)` dan `calculateProgress(xp)`.
    - `LevelProgress.kt`: Value object komprehensif (`currentLevel`, `currentXp`, `currentLevelBaseXp`, `nextLevelTargetXp`, `xpInCurrentLevel`, `xpNeededForNextLevel`, `remainingXpToNextLevel`, `progressPercentage`, `isMaxLevel`).
    - `LevelUpResult.kt`: Model payload kenaikan level (`oldLevel`, `newLevel`, `hasLeveledUp`, `bonusCoins`, `totalXp`, `levelProgress`).
    - UseCases:
      - `CalculateLevelProgressUseCase.kt`: Kalkulasi matematika rasio progres level.
      - `AddPlayerXpUseCase.kt`: Menambahkan XP ke pemain secara atomik, mengevaluasi promosi level, dan memberikan bonus koin (+50 koin/level).
      - `GetPlayerLevelProgressUseCase.kt`: Flow reaktif progres level pemain dari Room.
    - Repository updates:
      - `PlayerRepository.kt` & `PlayerRepositoryImpl.kt`: Penambahan `suspend fun addXp(...)` dan `fun getPlayerLevelProgress(...)`.
      - `QuestRepositoryImpl.kt`: Integrasi kalkulasi kenaikan level otomatis dan penyertaan `LevelUpResult` saat menyelesaikan quest.
  - **Data Layer & Room Integration:**
    - XP pemain tersimpan secara persisten di tabel `players`.
    - Atomic level-up logic: saat total XP melampaui ambang batas, level diperbarui dan bonus koin (+50 koin per kenaikan level) otomatis dikreditkan ke saldo koin pemain.
  - **Feature / UI Layer:**
    - `LevelUpDialog.kt`: Material 3 celebratory dialog dengan ikon piala 🏆, visual badge transisi level (misal "Level 1 ➔ Level 2"), rincian bonus koin (+50 Koin), dan notifikasi misi baru terbuka.
    - `HomeScreen.kt`:
      - Kartu pemain dilengkapi dengan animated `LinearProgressIndicator` progres XP.
      - Menampilkan teks informatif: "🌟 Level X", "🪙 Y Koin", "⚡ A / B XP", dan "Butuh Z XP lagi menuju Level X+1" atau "Level Maksimal!".
      - Terintegrasi dengan `LevelUpDialog`.
    - `ResultScreen.kt`:
      - Penambahan kartu Level Progress interaktif di bawah hadiah misi.
      - Terintegrasi dengan `LevelUpDialog` saat menyelesaikan petualangan.
    - `QuizViewModel.kt`:
      - Pemberian XP soal instan (+100 XP / +10 XP) ke database Room saat jawaban benar diserahkan.
    - `EduQuestNavHost.kt`:
      - Berbagi `PlayerViewModel` secara reaktif di seluruh alur navigasi aplikasi.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`LevelProgressTest.kt`): 100% PASS (`levelThresholds_matchSpecification`, `negativeXp_clampedToLevel1`, `level1_halfwayProgress_calculatedCorrectly`, `level2_startAndIntermediateProgress`, `maxLevel_returnsCompleteProgress`, `calculateLevelProgressUseCase_matchesLevelTable`, `levelUpRewardBonus_is50CoinsPerLevel`).
    - Device Verification (Hardware Android 13 `aaa1335aaabb`):
      - Beranda awal: Menampilkan pemain Level 1 dengan 330/500 XP dan 45 Koin.
      - Quest "Pakar Geometri & Pecahan" berstatus `🔒 Lv.2`.
      - Menjalankan kuis "Panca Indra Ceria" (2 soal benar = +200 XP soal + 150 XP reward quest).
      - XP total bertambah melampaui 500 XP.
      - Sistem secara otomatis menaikkan level ke **Level 2** dan menambahkan bonus koin **+50 Koin** (saldo koin meningkat dari 45 menjadi 115 Koin!).
      - Layar Beranda dan Layar Hasil secara otomatis mengupdate progress bar ("Level 2", "180/700 XP", "Butuh 520 XP lagi").
      - Peta Petualangan: Quest "Pakar Geometri & Pecahan" yang semula terkunci (`🔒 Lv.2`) seketika terbuka (`⚡ Tersedia`) dengan tombol "Mulai" aktif!
      - Logcat bersih dari crash/error (`AndroidRuntime:E` 0 error).

---

### TASK-008 — Reward
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - `CoinTransactionResult.kt`: Model transaksi koin deterministik (`isSuccess`, `previousBalance`, `newBalance`, `amountChanged`, `errorMessage`).
    - `RewardClaimResult.kt`: Value object hasil klaim hadiah (`isGranted`, `xpEarned`, `coinsEarned`, `rewardType`, `isDuplicateProtected`, `message`).
    - `QuestCompletionResult.kt`: Pembaruan untuk memuat data klaim hadiah `rewardClaimResult: RewardClaimResult?`.
    - UseCases:
      - `AddCoinsUseCase.kt`: Menambahkan saldo koin pemain secara aman dan memvalidasi input bernilai non-negatif.
      - `SpendCoinsUseCase.kt`: Pengurangan koin dengan validasi saldo mencukupi sehingga saldo tidak pernah bernilai negatif.
      - `GetCoinBalanceUseCase.kt`: Flow reaktif memantau saldo koin langsung dari tabel `players`.
      - `EvaluateQuestRewardUseCase.kt`: Evaluasi deterministik apakah quest merupakan penyelesaian pertama atau ulangan (replay). Menerapkan proteksi duplikasi reward.
    - Repository updates:
      - `PlayerRepository.kt` & `PlayerRepositoryImpl.kt`: Penambahan fungsi `suspend fun addCoins(...)`, `suspend fun spendCoins(...)`, dan `fun getCoinBalance(...)`.
      - `QuestRepositoryImpl.kt`: Integrasi `EvaluateQuestRewardUseCase` saat menyelesaikan quest. Penyelesaian pertama memberikan hadiah penuh (+XP quest dan +Koin quest), sedangkan pengerjaan ulang (replay) memberikan 0 XP dan 0 Koin reward quest serta menandai `isDuplicateProtected = true`.
  - **Feature / UI Layer:**
    - `QuestDetailScreen.kt`:
      - Penambahan indikator Material 3: `🛡️ Hadiah XP & Koin telah diklaim sebelumnya. Misi ini dapat diulang untuk melatih ingatan.` ketika quest telah berstatus `COMPLETED`.
    - `ResultScreen.kt`:
      - Banner penyelesaian pertama: `🎉 Hadiah Pertama Kali Diperoleh!` dengan rincian hadiah XP dan Koin.
      - Banner proteksi duplikasi: `🛡️ Proteksi Hadiah Aktif - Misi ini telah diselesaikan sebelumnya. Koin dan XP hadiah utama hanya diberikan pada penyelesaian pertama kali.`
      - Tampilan saldo koin terkini di bagian bawah reward card (`🪙 Saldo Koin Saat Ini: X Koin`).
    - `PlayerViewModel.kt`:
      - Penambahan state `lastCoinTransaction` dan metode `addCoins(amount)`, `spendCoins(amount)`, serta pembersihan notifikasi.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`RewardTest.kt`): 100% PASS (5 test cases):
      - `firstTimeQuestCompletion_grantsFullRewards`: Memastikan penyelesaian awal memberikan reward penuh.
      - `subsequentQuestCompletion_isDuplicateProtected_grantsZeroRewards`: Memastikan replay memberikan 0 XP dan 0 Koin.
      - `negativeRewardInputs_areClampedToZero`: Validasi nilai negatif tidak merusak state.
      - `spendCoins_withSufficientBalance_decreasesBalance`: Pengurangan saldo berhasil jika saldo cukup.
      - `spendCoins_withInsufficientBalance_failsAndPreservesBalance`: Pengurangan saldo ditolak jika saldo tidak cukup (saldo terjaga).
    - Device Verification (Hardware Android 13 `aaa1335aaabb`):
      - Layar Detail Petualangan: Quest "Berhitung Cepat" menampilkan badge `🛡️ Hadiah XP & Koin telah diklaim sebelumnya`.
      - Menjalankan kembali (replay) kuis hingga selesai.
      - Layar Hasil Kuis: Tampil kartu `🛡️ Proteksi Hadiah Aktif` dengan teks penjelasan transparan dan saldo koin tetap aman terjaga pada 115 Koin.
      - Layar Beranda: Saldo koin tetap 115 Koin (tidak ada eksploitasi penggandaan koin).
      - Logcat bersih dari crash/error (`AndroidRuntime:E` 0 error).

---

### TASK-009 — Achievement
- **Status:** `PASS`
- **Tanggal:** 2026-10-07
- **Deliverables:**
  - **Domain Layer:**
    - `Achievement.kt`: Domain model pencapaian (`id`, `title`, `description`, `type`, `target`, `rewardXp`, `rewardCoins`, `icon`).
    - `AchievementWithProgress.kt`: Value object gabungan data master pencapaian dengan progres pemain (`progress`, `isUnlocked`, `unlockedAt`, `progressRatio`, `isCompleted`).
    - `AchievementUnlockResult.kt`: Model payload hasil pembukaan pencapaian (`achievement`, `unlockedAt`, `xpEarned`, `coinsEarned`).
    - UseCases:
      - `GetAchievementsWithProgressUseCase.kt`: Flow reaktif memantau seluruh pencapaian beserta progres individual pemain dari Room DB.
      - `EvaluateAchievementsUseCase.kt`: Evaluator deterministik dan atomik untuk mendeteksi pencapaian baru berdasarkan metrik gameplay (`QUEST_COMPLETED`, `MATH_CORRECT`, `SCIENCE_CORRECT`, `LANGUAGE_CORRECT`, `PERFECT_SCORE`, `LEVEL_REACHED`).
    - Repository contracts & updates:
      - `AchievementRepository.kt`: Kontrak data pencapaian, seeding starter, evaluasi, dan flow count terbuka.
      - `QuestCompletionResult.kt`: Pembaruan untuk menyertakan `unlockedAchievements: List<Achievement>`.
  - **Data Layer & Seed Data:**
    - `AchievementStarterData.kt`: 7 starter achievement terkalibrasi sesuai kurikulum dan spesifikasi:
      1. `FIRST_QUEST` ("Langkah Pertama", target: 1 quest, +100 XP, +20 Koin)
      2. `QUEST_EXPLORER` ("Penjelajah Cilik", target: 3 quest, +200 XP, +35 Koin)
      3. `MATH_EXPLORER` ("Pakar Berhitung", target: 3 soal matematika benar, +150 XP, +25 Koin)
      4. `SCIENCE_STARTER` ("Peneliti Alam", target: 2 soal sains benar, +150 XP, +25 Koin)
      5. `LANGUAGE_PIONEER` ("Kutu Buku Cilik", target: 2 soal bahasa benar, +150 XP, +25 Koin)
      6. `PERFECT_STAR` ("Bintang Cemerlang", target: 1 nilai sempurna 100%, +200 XP, +30 Koin)
      7. `LEVEL_UP_HERO` ("Ksatria Edukasi", target: mencapai Level 2, +250 XP, +50 Koin)
    - `AchievementDao.kt`: Penambahan query `getAchievementCount`, `getAllAchievementsList`, `getPlayerAchievementsList`, dan `getUnlockedCountFlow`.
    - `ProgressDao.kt`: Penambahan query `getCompletedQuestCount`, `getPerfectScoreQuestCount`, `getCorrectCountBySubject`, dan `getTotalCorrectAnswersCount`.
    - `AchievementRepositoryImpl.kt`: Implementasi logika evaluasi pencapaian dengan proteksi duplikasi hadiah klaim hanya 1x (idempotent).
    - `QuestRepositoryImpl.kt` & `QuizViewModel.kt`: Terintegrasi secara otomatis saat kuis selesai diselesaikan.
  - **Feature / UI Layer:**
    - `AchievementViewModel.kt`:
      - Filter kategori: `ALL`, `UNLOCKED`, `LOCKED`.
      - Kalkulasi metrik ringkasan: `unlockedCount`, `totalCount`, `completionPercentage`.
      - Sinkronisasi otomatis saat inisialisasi / refresh.
    - `AchievementScreen.kt`:
      - Header kartu ringkasan interaktif: Menampilkan ikon piala 🏆, rasio medali diraih (misal "4 dari 7 Diraih (57%)"), dan progress bar visual.
      - Filter chips Material 3: `Semua`, `🏆 Terbuka`, dan `🔒 Terkunci`.
      - Card list informatif: Ikon emoji tematik (🚀, 🗺️, 🔢, 🔬, 📖, ⭐, 👑), status badge `✅ Diraih` / `🔒 Terkunci`, progress bar per-target (misal `2 / 3`), dan rincian hadiah `⭐ +X XP` serta `🪙 +Y Koin`.
    - `ResultScreen.kt`:
      - Penambahan kartu notifikasi: `🏆 Pencapaian Baru Diraih!` saat kuis berhasil membuka piala baru.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`AchievementTest.kt`): 100% PASS (4 test cases):
      - `starterAchievements_haveValidConfiguration`: Memvalidasi seluruh target dan reward 7 achievement positif dan valid.
      - `progressRatio_calculatedCorrectly`: Memvalidasi kalkulasi rasio progres 0%, 50%, 100%, dan clamping nilai maksimum.
      - `filterAchievements_filtersCorrectly`: Memvalidasi penyaringan tab `ALL`, `UNLOCKED`, dan `LOCKED`.
      - `duplicateRewardProtection_preservesUnlockedStatus`: Memvalidasi pencapaian yang sudah terbuka tidak mengalami duplikasi reward.
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (semua 25 test task up-to-date / lulus).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.3 MB berhasil dibuat).

---

### TASK-010 — Knowledge Card
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Domain Layer:**
    - `KnowledgeCard.kt`: Domain model kartu wawasan (`id`, `title`, `category`, `description`, `fact`, `imageAsset`, `unlockCondition`, `icon`).
    - `KnowledgeCardWithStatus.kt`: Model data kartu dengan status kepemilikan pemain (`card`, `isUnlocked`, `unlockedAt`).
    - `CardUnlockResult.kt`: Model hasil pembukaan kartu wawasan (`card`, `unlockedAt`, `isNewUnlock`).
    - UseCases:
      - `GetKnowledgeCardsUseCase.kt`: Flow reaktif memantau kartu wawasan berdasarkan kategori pemain dari Room DB.
      - `UnlockKnowledgeCardUseCase.kt`: Use case pembukaan kartu wawasan berdasarkan penyelesaian quest tertentu.
      - `SyncKnowledgeCardsUseCase.kt`: Sinkronisasi otomatis kartu wawasan yang berhak diperoleh dari quest-quest yang telah diselesaikan.
    - Repository contracts & updates:
      - `KnowledgeCardRepository.kt`: Kontrak domain repository koleksi kartu offline.
      - `QuestCompletionResult.kt`: Pembaruan untuk memuat daftar kartu yang baru terbuka (`unlockedCards: List<KnowledgeCard>`).
  - **Data Layer & Seed Data:**
    - `KnowledgeCardStarterData.kt`: 8 starter kartu pengetahuan edukatif untuk anak SD:
      1. `card_math_01` ("Keajaiban Angka Nol", Kategori: Matematika)
      2. `card_math_02` ("Trik Jari Sembilan", Kategori: Matematika)
      3. `card_math_03` ("Kekuatan Segitiga", Kategori: Matematika)
      4. `card_science_01` ("Mata Elang Super", Kategori: Hewan)
      5. `card_science_02` ("Dapur Hijau Daun", Kategori: Sains)
      6. `card_science_03` ("Cincin Megah Saturnus", Kategori: Antariksa)
      7. `card_human_01` ("Pompa Hebat Jantung", Kategori: Tubuh Manusia)
      8. `card_lang_01` ("Pantun Warisan Dunia", Kategori: Budaya)
    - `KnowledgeCardDao.kt`: Ditambahkan query `getCardCount`, `getAllCardsList`, `getCardById`, `getCardByUnlockCondition`, `getPlayerCard`, `getPlayerCardsList`, dan `getUnlockedCardCountFlow`.
    - `KnowledgeCardEntity.kt`: Ditambahkan fungsi mapper `toDomain()` dengan icon emoji tematik (🪐, 🐾, 🔬, 🔢, ❤️, 🏛️, 📖).
    - `KnowledgeCardRepositoryImpl.kt`: Implementasi repository kartu wawasan Room DB dengan sinkronisasi deterministik dan proteksi duplikasi (idempotent).
    - `QuestRepositoryImpl.kt` & `QuizViewModel.kt`: Terintegrasi untuk secara otomatis meng-unlock kartu pengetahuan saat quest yang bersangkutan diselesaikan.
  - **Feature / UI Layer:**
    - `CollectionViewModel.kt`:
      - Filter kategori dinamis (Semua, Matematika, Sains, Hewan, Antariksa, Tubuh Manusia, Budaya).
      - State pemantauan kartu terpilih untuk dialog detail (`selectedCard`).
      - Perhitungan persentase koleksi kartu (`collectionPercentage`).
    - `CollectionScreen.kt`:
      - Header kartu ringkasan album: Menampilkan ikon kartu 🃏, jumlah kartu terbuka (misal "X dari 8 Kartu Terbuka"), dan progress bar visual.
      - Filter chips Material 3 kategori interaktif.
      - Card list dengan status terbuka (`isUnlocked = true`) dan misterius terkunci (`🔒 Kartu Misterius`).
      - **Modal Dialog Detail Kartu**: Menampilkan ilustrasi emoji besar, kategori badge, judul kartu, penjelasan umum, dan kotak fakta edukatif berwarna kuning emas ("💡 Fakta Menarik: ...").
    - `ResultScreen.kt`:
      - Penambahan kartu notifikasi: `🃏 Kartu Wawasan Baru Terbuka!` lengkap dengan fakta edukasi instan saat quest berhasil diselesaikan.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`KnowledgeCardTest.kt`): 100% PASS (4 test cases):
      - `starterCards_haveValidConfiguration`: Memvalidasi kelengkapan 8 kartu data awal.
      - `collectionPercentage_calculatedCorrectly`: Memvalidasi kalkulasi rasio koleksi (0%, 25%, 50%, 100%).
      - `categoryFiltering_filtersCorrectly`: Memvalidasi penyaringan kartu berdasarkan kategori.
      - `duplicateUnlock_preservesOriginalUnlockTimestamp`: Memvalidasi proteksi duplikasi kartu menjaga timestamp asli.
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (seluruh 25 test task lulus).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.3 MB berhasil di-generate).

---

### TASK-011 — Daily Mission
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Date Utility Layer:**
    - `DailyDateUtils.kt`: Format tanggal offline-safe (`yyyy-MM-dd` dengan `Locale.US` untuk konsistensi key SQLite lokal) serta formatter nama hari dan bulan bahasa Indonesia (`EEEE, d MMMM yyyy`).
  - **Domain Layer:**
    - `DailyMission.kt`: Domain model misi harian (`id`, `title`, `description`, `category`, `targetCount`, `rewardXp`, `rewardCoins`, `icon`).
    - `DailyMissionWithProgress.kt`: Status misi per pemain per tanggal (`mission`, `dateString`, `currentProgress`, `isCompleted`, `isClaimed`, `progressRatio`, `isReadyToClaim`).
    - `DailyRewardClaimResult.kt`: Hasil klaim hadiah dengan proteksi duplikasi (`Success`, `AlreadyClaimed`, `NotCompleted`, `MissionNotFound`, `Error`).
    - UseCases:
      - `GetDailyMissionsUseCase.kt`: Flow reaktif memantau daftar misi hari ini dengan progres pemain dari Room DB.
      - `RecordDailyProgressUseCase.kt`: Mencatat progres soal per mata pelajaran (`MATH`, `SCIENCE`, `LANGUAGE`) dan penyelesaian quest harian.
      - `ClaimDailyRewardUseCase.kt`: Klaim hadiah misi harian dengan penambahan XP dan Koin, serta verifikasi anti-duplikasi.
    - Repository contracts:
      - `DailyMissionRepository.kt`: Kontrak domain repository misi harian offline.
  - **Data Layer & Seed Data:**
    - `DailyMissionStarterData.kt`: 7 template misi harian kurikulum SD (sesuai spesifikasi Section 34), dengan 4 misi inti harian (sesuai spesifikasi Section 26):
      1. `daily_math_01` ("Pakar Matematika Cilik", target: 3 soal Math, Reward: +75 XP, +15 Koin)
      2. `daily_science_01` ("Penjelajah Sains Alam", target: 2 soal Science, Reward: +75 XP, +10 Koin)
      3. `daily_lang_01` ("Kosa Kata Pintar", target: 2 soal Bahasa, Reward: +75 XP, +10 Koin)
      4. `daily_quest_01` ("Petualang Hari Ini", target: 1 Quest, Reward: +75 XP, +15 Koin)
      *(Total reward harian 4 misi inti: 300 XP dan 50 Koin — 100% presisi sesuai Section 26)*
      5. `daily_all_01` ("Semangat Belajar Tiada Henti", target: 5 soal apa saja, Reward: +100 XP, +20 Koin)
      6. `daily_perfect_01` ("Bintang Cemerlang Sempurna", target: 1 skor 100%, Reward: +100 XP, +20 Koin)
      7. `daily_quest_02` ("Penjelajah Dua Dunia", target: 2 Quest, Reward: +150 XP, +25 Koin)
    - `DailyMissionDao.kt`: Penambahan query `getMissionCount`, `getAllMissionsList`, `getMissionById`, `getMissionsByCategory`, `getProgress`, `getDailyProgressList`, `updateProgress`, `markClaimed`, `getCompletedMissionCountFlow`, dan `getClaimedMissionCountFlow`.
    - `DailyMissionEntity.kt`: Ditambahkan fungsi mapper `toDomain()` dengan ikon emoji tematik (🔢, 🔬, 📖, 🗺️, ⭐, ✏️, 🎯).
    - `DailyMissionRepositoryImpl.kt`: Implementasi repository misi harian offline-first dengan seeding deterministik dan proteksi klaim ganda.
    - `QuizViewModel.kt`: Terintegrasi untuk secara otomatis memajukan progres misi harian saat pemain menjawab soal (berdasarkan subjek) dan saat quest diselesaikan.
  - **Feature / UI Layer:**
    - `DailyMissionViewModel.kt`: State flow `DailyMissionUiState` memantau daftar misi, ringkasan tanggal, total XP & koin, serta aksi klaim hadiah.
    - `DailyMissionScreen.kt`:
      - Header interaktif: Menampilkan tanggal lokal bahasa Indonesia ("Kamis, 8 Oktober 2026"), ikon target 🎯, progress bar misi hari ini ("X dari 4 Selesai"), dan total hadiah (⭐ +300 XP • 🪙 +50 Koin).
      - Card list informatif: Ikon emoji tematik (🔢, 🔬, 📖, 🗺️), judul misi, deskripsi, progress bar visual (misal `0 / 3`), pill hadiah, dan status dinamis:
        - `Sedang Berjalan` (belum selesai)
        - `🎁 Klaim Hadiah` (tombol aktif saat misi selesai dan belum diklaim)
        - `✅ Selesai Diklaim` (status disabled saat hadiah sudah diambil)
      - **Modal Dialog Klaim Hadiah**: Menampilkan ucapan selamat, rincian XP dan koin yang didapat, serta badge mahkota 👑 jika seluruh misi hari ini telah tuntas.
    - `MainActivity.kt`: Penambahan dukungan parameter Intent `startDestination` untuk routing langsung antar layar.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`DailyMissionTest.kt`): 100% PASS (5 test cases):
      - `starterDailyMissions_haveValidConfiguration`: Memvalidasi seluruh 7 template misi harian dan 4 misi inti (300 XP, 50 Koin).
      - `dailyDateUtils_formatsOfflineSafeDateAndIndonesianDisplay`: Memvalidasi keabsahan format `yyyy-MM-dd` dan render tanggal Indonesia ("Kamis, 8 Oktober 2026").
      - `progressRatio_and_readyToClaim_calculatedCorrectly`: Memvalidasi rasio progres (0%, 66.7%, 100%) dan ketersediaan tombol klaim.
      - `duplicateRewardProtection_preventsDoubleClaiming`: Memvalidasi proteksi duplikasi klaim hadiah pada data layer.
      - `dailyMissionUiState_allCompletedAndPercentage`: Memvalidasi state persentase dan kondisi selesai keseluruhan.
      - `repository_tracksProgressAndPreventsDuplicateClaim`: Pengujian integrasi alur akumulasi progres jawaban soal dan blokir klaim ganda (idempotent).
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (seluruh 25 test task lulus).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.3 MB berhasil di-generate).
      - Verifikasi Perangkat Fisik (`q4eu99nfaifalbh6`): UI Misi Harian berjalan lancar dan terverifikasi via screenshot `daily_mission_final.png`.

### TASK-012 — World UI
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Domain Layer:**
    - `domain/model/World.kt`: Model data domain untuk peta dunia dan area:
      - `World` (`id`, `name`, `description`, `requiredLevel`, `orderIndex`, `icon`, `backgroundRes`, `totalQuests`, `isUnlocked`).
      - `WorldArea` (`id`, `worldId`, `name`, `indonesianName`, `description`, `subjectId`, `unlockLevel`, `icon`, `orderIndex`).
      - `WorldAreaWithProgress` (`area`, `totalQuests`, `completedQuests`, `isUnlocked`, `progressRatio`, `progressPercent`).
      - `WorldWithProgress` (`world`, `areas`, `totalQuests`, `completedQuests`, `isUnlocked`, `progressRatio`, `progressPercent`).
    - `domain/repository/WorldRepository.kt`: Kontrak domain repository peta dunia offline-first.
    - `domain/usecase/GetWorldWithAreasUseCase.kt`: Use case untuk menggabungkan data World, Areas, Quests, dan level pemain secara reaktif.
  - **Data Layer & Seed Content:**
    - `WorldStarterData.kt`: Seed starter data offline untuk World 1 (`Kota Pengetahuan`, Level 1) beserta 3 Area petualangan kurikulum SD:
      1. `area_math`: **Math Valley** (Lembah Matematika, subjek: `MATH`, unlock: Level 1 -> Terbuka)
      2. `area_science`: **Science Lab** (Laboratorium Sains, subjek: `SCIENCE`, unlock: Level 1 -> Terbuka)
      3. `area_language`: **Language Library** (Perpustakaan Bahasa, subjek: `LANGUAGE`, unlock: Level 2 -> Terkunci di Level 1)
    - `WorldDao.kt`: Ditambahkan query Room `getWorldCount()` dan `getAllWorldsList()`.
    - `WorldRepositoryImpl.kt`: Implementasi repository peta dunia offline dengan reactive flow.
    - **Room Reactive Optimization**: Menggunakan query Room `getAllPlayers().map { ... }` untuk mencegah deadlock `combine` Flow pada tabel kosong/single-row Room.
  - **Feature & UI Layer (Material 3):**
    - `feature/world/WorldViewModel.kt`: Mengelola state reactive `WorldUiState`, filter subjek/area (`Semua`, `Math Valley`, `Science Lab`, `Language Library`), penghitungan progres quest, dan dialog/notice area terkunci.
    - `feature/world/WorldScreen.kt`:
      - **Header Dunia**: Card interaktif dengan ikon istana 🏰, judul `Dunia 1: Kota Pengetahuan`, badge `Lv. 1`, deskripsi, progress bar visual (`0 dari 9 Quest Selesai`), dan label persentase dunia.
      - **Area Cards Carousel**: Horizontal scroll carousel menampilkan card tiap area dengan ikon emoji (🔢, 🔬, 📖), nama area, nama lokal bahasa Indonesia, progress bar per area (`0 / 3 Selesai`), dan badge status unlock (`Terbuka` warna hijau vs `🔒 Lv. 2` warna netral abu-abu).
      - **Area / Subject Filter Chips**: Filter cepat untuk memfilter daftar quest berdasarkan area/mata pelajaran.
      - **Daftar Quest Interaktif**: List card quest dengan pill mata pelajaran, status dinamis (`⚡ Tersedia`, `⏳ Berjalan`, `✅ Selesai`, `🔒 Lv. X`), ringkasan XP (`⭐ +150 XP`) dan Koin (`🪙 +20`), serta tombol navigasi `Mulai` / `Lanjut` / `Review`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`WorldUiTest.kt`): 100% PASS (8 test cases):
      - `worldWithAreas_hasCorrectWorldConfiguration`: Memvalidasi identitas World 1 (Kota Pengetahuan, 3 area, total 9 quest).
      - `worldAreas_haveExpectedUnlockLevels`: Memvalidasi requirement unlock level (Math Valley = Lv 1, Science Lab = Lv 1, Language Library = Lv 2).
      - `playerLevel1_unlocksMathAndScience_locksLanguage`: Memvalidasi kondisi pemain level 1 membuka Math & Science serta mengunci Language.
      - `playerLevel2_unlocksAllAreas`: Memvalidasi naiknya pemain ke level 2 membuka seluruh area.
      - `worldProgress_calculatesCorrectPercentage`: Memvalidasi kalkulasi rasio progres quest dan persentase dunia (misal 3/9 = 33%).
      - `questFiltering_byArea_worksCorrectly`: Memvalidasi fungsionalitas filter quest per area.
      - `lockedAreaQuests_haveLockedStatus`: Memvalidasi status quest di area terkunci menampilkan badge level requirement (`🔒 Lv. 2`).
      - `subjectFilterMapping_matchesExpectedSubjects`: Memvalidasi pemetaan area ID ke kode subjek kurikulum SD (`MATH`, `SCIENCE`, `LANGUAGE`).
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (seluruh 25 test tasks lulus).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.5 MB berhasil di-generate).
      - Verifikasi Perangkat Fisik (`q4eu99nfaifalbh6`): Diluncurkan dan diverifikasi langsung pada layar perangkat fisik via screenshot `world_screen_live2.png`.

### TASK-013 — Home UI
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Feature & State Management (`feature/home/HomeViewModel.kt`):**
    - `HomeUiState`, `DailyMissionSummary`, `QuickStats` data models.
    - Reactive combination dari 5 primary Room flows (`questsFlow`, `dailyMissionsFlow`, `worldFlow`, `cardsCountFlow`, `achievementsCountFlow`).
    - Smart continue quest selection priority: `IN_PROGRESS` -> `AVAILABLE` -> `COMPLETED`.
    - Real-time daily mission summary calculation (rasio selesai, XP & koin rewards, status klaim).
    - Consecutive streak days calculation from active dates tanpa penalti bagi pemain offline.
    - Auto-seeding starter player ("Budi Petualang", SD Kelas 1, `avatar_kancil`) jika database player kosong saat peluncuran awal.
  - **UI Layer (`feature/home/HomeScreen.kt`):**
    - **Header Player Profil**: Avatar, Nickname, Level badge ("Lv. 1"), status streak ("🔥 1 Hari"), koin balance ("🪙 100"), dan XP progress bar (`LinearProgressIndicator`).
    - **Priority 1: Continue Quest Card ("🎯 Lanjut Belajar")**: Highlight quest yang sedang berjalan atau quest berikutnya yang tersedia, subject tag, total rewards, dan CTA button "Mulai Petualangan ▶" / "Lanjutkan Petualangan ▶".
    - **Priority 2: Daily Mission Summary Card ("🎯 Misi Harian")**: Tanggal hari ini, rasio misi selesai ("0 dari 4 Selesai"), progress bar, preview reward total ("⭐ +300 XP • 🪙 +50"), dan CTA "Buka Misi Harian ➔".
    - **World Progress Card ("🏰 Peta Dunia")**: Active world ("Kota Pengetahuan"), jumlah quest selesai dan persentase dunia ("0 dari 9 Quest Selesai • 0%"), dan tombol shortcut ke World Screen ("Jelajahi Peta ➔").
    - **Quick Access Menu Grid (2x2)**: Pencapaian (🏆), Kartu Pintar (🎴), Profil (👤), Pengaturan (⚙️).
    - Platform-independent Unicode escape constants (`HomeIcons`) untuk rendering emoji bebas korupsi encoding pada Windows.
  - **Navigation Integration:**
    - `EduQuestNavHost.kt`: Updated `HomeScreen` route call with `onContinueQuest = { questId -> navController.navigate(Screen.QuestDetail.createRoute(questId)) }`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`HomeUiTest.kt`): 100% PASS (10 unit test cases):
      - `continueQuest_prefersInProgressQuest`
      - `continueQuest_fallbackToFirstAvailableQuest`
      - `continueQuest_fallbackToFirstCompletedQuestWhenNoOthers`
      - `continueQuest_returnsNullWhenEmpty`
      - `dailyMissionSummary_emptyList_returnsZero`
      - `dailyMissionSummary_calculatesRatioAndRewardsCorrectly`
      - `streakDays_todayActive_countsConsecutiveDays`
      - `streakDays_yesterdayActive_countsConsecutiveDays`
      - `streakDays_gapInDays_resetsToStreak`
      - `homeUiState_initialDefaultsAreSafe`
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (100% pass across all 25 test tasks).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.5 MB berhasil di-generate).
      - Live Physical Device Verification: Installed on Xiaomi (`q4eu99nfaifalbh6`), live UI verified via screenshot `home_screen_final.png`.

### TASK-014 — Profile
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Data Layer & DAO Extension (`data/local/dao/ProgressDao.kt`):**
    - `getCompletedQuestCountFlow(playerId: String): Flow<Int>`
    - `getTotalAnswersCountFlow(playerId: String): Flow<Int>`
    - `getTotalCorrectAnswersCountFlow(playerId: String): Flow<Int>`
    - `getTotalAnswersCount(playerId: String): Int`
  - **Feature & State Management (`feature/profile/ProfileViewModel.kt`):**
    - `ProfileUiState`: player, levelProgress, completedQuestsCount, totalQuestsCount, totalQuestionsAnswered, correctAnswersCount, accuracyPercent, unlockedAchievementsCount, totalAchievementsCount, unlockedCardsCount, totalCardsCount, activeWorldName, streakDays.
    - Reactive combination dari 5 primary Room flows (`completedQuestsFlow`, `answersCountFlow`, `correctAnswersFlow`, `unlockedAchievementsFlow`, `unlockedCardsFlow`).
    - Akurasi belajar dihitung secara dinamis: `calculateAccuracy(correctAnswers, totalAnswers)`.
    - Edit profile action: `updateProfile(nickname, grade, avatar)` via `UpdatePlayerProfileUseCase`.
  - **UI Layer (`feature/profile/ProfileScreen.kt`):**
    - Top bar dengan back navigation "Profil Petualang".
    - **Hero Profile Card**: Circular avatar (46sp), Nickname bold headline, label jenjang & nama karakter ("SD Kelas 1 • Kancil"), koin balance ("🪙 450 Koin"), streak badge ("🔥 1 Hari"), dan tombol "✏️ Edit Profil".
    - **Level Progression Card**: Level badge ("🌟 Level 4"), XP ratio ("⚡ 700 / 1000 XP"), progress bar visual (70%), dan pesan XP menuju level berikutnya.
    - **Learning Statistics Grid (2x2)**: Quest Selesai ("🎯 3 / 9"), Soal Dijawab ("📝 9"), Jawaban Benar ("✅ 9"), dan Akurasi Jawaban ("🎖️ 100%").
    - **Achievement & Collection Overview Cards**: Progress bar visual dan shortcut navigasi langsung ke layar Achievement dan Collection ("Lihat ➔").
    - **Character Information Card**: Dunia aktif ("🏰 Kota Pengetahuan"), jenjang belajar ("🎒 SD Kelas 1"), dan akumulasi total XP.
    - **Edit Profile Dialog**: Pilihan 6 avatar fauna Indonesia (`AvatarHelper.AVATARS`), field nama panggilan (validasi 2-20 karakter), dan pilihan jenjang kelas SD (1-6).
  - **Navigation Integration:**
    - `EduQuestNavHost.kt`: Updated `Screen.Profile.route` dengan callback `onNavigateToAchievements` dan `onNavigateToCollections`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`ProfileUiTest.kt`): 100% PASS (9 test cases):
      - `calculateAccuracy_zeroQuestions_returnsZero`
      - `calculateAccuracy_negativeInputs_returnsZero`
      - `calculateAccuracy_allCorrect_returnsHundred`
      - `calculateAccuracy_halfCorrect_returnsFifty`
      - `calculateAccuracy_fractionalRounding_returnsIntegerPercentage`
      - `profileUiState_initialDefaults_areSafeAndOfflineReady`
      - `profileUiState_withPlayerAndStats_reflectsDataCorrectly`
      - `avatarHelper_containsValidAvatars`
      - `levelProgress_calculatesCorrectValues`
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (100% pass across all test tasks).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK `app-debug.apk` berukuran 10.5 MB).
      - Live Physical Device Verification: Diinstal dan dijalankan di Xiaomi (`q4eu99nfaifalbh6`), live UI diverifikasi melalui screenshot `profile_screen_final.png`.
- **Perbaikan Bug & Penyempurnaan Visual Peta Dunia (World Map & Quest Status):**
  - **Akar Masalah:** `WorldViewModel` sebelumnya mengkueri `progressDao` menggunakan ID hardcoded `"PLAYER_LOCAL"`, padahal player diinisialisasi dengan ID unik UUID (misal `player_...`). Akibatnya, penghitungan quest selesai di `WorldRepositoryImpl` dan `QuestRepositoryImpl` selalu mengembalikan 0 record (`0/3 Selesai`).
  - **Solusi Data & ViewModel:**
    - `WorldRepositoryImpl.kt` & `QuestRepositoryImpl.kt`: Ditambahkan resolusi fallback dinamis `effectivePlayerId` yang mengambil ID player aktif jika `playerId` kosong atau bernilai `"PLAYER_LOCAL"`.
    - `WorldViewModel.kt`: Mengamati flow aktif `playerRepository.getActivePlayer()` via `flatMapLatest` sehingga setiap kali player bertambah level atau menyelesaikan quest, progres peta dunia langsung sinkron secara reaktif.
  - **Penyempurnaan Visual UI (`feature/world/WorldScreen.kt`):**
    - **Header & Ringkasan Misi:** Menampilkan badge pill total misi & yang sudah diselesaikan (contoh: `9 Quest • 3 Selesai` atau `3 Quest • 3 Selesai`).
    - **Area Petualangan (AreaCardItem):**
      - Jika semua misi di area selesai: Badge hijau `✅ Selesai`, teks progress `✅ 3 / 3 Selesai`, background aksen lembut `Color(0xFFF1F8E9)`, dan progress bar hijau.
      - Jika sebagian selesai: Badge oranye `⏳ Berjalan` dan teks `X / Y Selesai`.
      - Jika belum terbuka: Badge merah `Lv. X` dan teks `Terkunci (Lv. X)`.
    - **Kartu Misi (QuestCardItem & QuestStatusBadge):**
      - `COMPLETED`: Badge `✅ Misi Selesai`, judul misi bertanda centang `✅`, latar hijau pastel lembut `Color(0xFFF1F8E9)`, border hijau `Color(0xFF81C784)`, dan tombol `Ulang ↺` hijau tua.
      - `IN_PROGRESS`: Badge `⏳ Sedang Berjalan`, latar oranye lembut, border oranye, dan tombol `Lanjut ▶`.
      - `AVAILABLE`: Badge `⚡ Belum Selesai (Tersedia)`, latar surface putih, border outline, dan tombol `Mulai ▶`.
      - `LOCKED`: Badge `🔒 Belum Terbuka (Lv. X)`, latar abu-abu redup, dan tombol `🔒 Terkunci`.
  - **Pengujian & Verifikasi:**
    - `WorldUiTest.kt`: 100% PASS (5 test cases), termasuk pengujian `isCompleted` dan status quest.
    - `testDebugUnitTest`: `BUILD SUCCESSFUL` (100% lulus di semua modul).
    - `assembleDebug`: `BUILD SUCCESSFUL`.
    - Live physical device screenshots: `world_screen_fixed.png`, `world_screen_math.png`, `world_screen_lang.png`.
- **Perbaikan Bug & Penyempurnaan Visual Misi Harian (Daily Mission Progress):**
  - **Akar Masalah:**
    - `DailyMissionViewModel.kt` menginisialisasi pemuatan misi dengan `playerId: String = "PLAYER_LOCAL"` secara default tanpa mengamati ID pemain aktif.
    - `DailyMissionRepositoryImpl.kt` tidak memiliki resolusi `effectivePlayerId` dan tidak memigrasikan progres lokal ke pemain aktif. Akibatnya, saat `DailyMissionScreen` dibuka, kueri Room mencari progres untuk `"PLAYER_LOCAL"` yang masih kosong (`0/4 Selesai`), padahal data progres pemain aktif di `HomeScreen` sudah mencapai `4 dari 4 Selesai`.
  - **Solusi Data & ViewModel:**
    - `DailyMissionDao.kt`: Ditambahkan query Room `migrateLocalProgressToPlayer(newPlayerId: String)`.
    - `DailyMissionRepositoryImpl.kt`:
      - Ditambahkan helper `resolveEffectivePlayerId(providedId)` yang mengambil ID pemain aktif jika argumen kosong atau bernilai `"PLAYER_LOCAL"`, sekaligus menjalankan migrasi record `"PLAYER_LOCAL"`.
      - `getDailyMissionsWithProgress`, `recordSubjectProgress`, `recordQuestProgress`, `claimReward`, `getCompletedCountFlow`, dan `getClaimedCountFlow` diperbarui untuk selalu memakai ID pemain aktif.
    - `DailyMissionViewModel.kt`:
      - Mengamati `playerRepository.getActivePlayer()` via `flatMapLatest` sehingga daftar misi dan progres harian selalu sinkron secara reaktif dengan akun pemain aktif.
      - Menyimpan `activePlayerId` untuk proses klaim hadiah (`claimReward`) sehingga penambahan XP dan koin masuk langsung ke saldo pemain aktif.
  - **Penyempurnaan Visual UI (`feature/daily/DailyMissionScreen.kt`):**
    - **Header Misi Harian:**
      - Jika semua target tercapai: Menampilkan teks `✅ X dari Y Selesai (100%)` berwarna hijau tua, piala emas `🏆`, dan *progress bar* hijau penuh.
    - **Kartu Misi Harian (`DailyMissionCard`):**
      - Jika selesai dan siap diklaim (`canClaim`): Latar hijau pastel lembut `Color(0xFFF1F8E9)`, border hijau `Color(0xFF81C784)`, indikator teks `3 / 3 ✅ Selesai`, *progress bar* hijau, dan tombol `🎁 Klaim Hadiah` hijau segar.
      - Jika sudah diklaim (`isClaimed`): Teks hijau `✅ Sudah Diklaim` dan bar redup.
      - Jika sedang berjalan: Teks `X / Y`, label `⏳ Sedang Berjalan`.
  - **Pengujian & Verifikasi:**
    - `DailyMissionTest.kt`: 100% PASS (5 test cases), termasuk fake DAO `migrateLocalProgressToPlayer`.
    - `testDebugUnitTest`: `BUILD SUCCESSFUL` (100% lulus di seluruh suite test).
    - `assembleDebug`: `BUILD SUCCESSFUL`.
    - Live physical device verification: Diuji di Xiaomi (`q4eu99nfaifalbh6`), live UI diverifikasi melalui screenshot `daily_mission_fixed.png`.

---

### TASK-015 — Settings
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Domain Model & Repository:**
    - `domain/model/SettingsPreferences.kt`: Data class setelan preferensi audio lokal (`isSoundEnabled: Boolean = true`, `isMusicEnabled: Boolean = true`).
    - `domain/repository/SettingsRepository.kt`: Kontrak repository offline-first untuk membaca preferensi via `Flow<SettingsPreferences>`, membaca sinkron via `getSettingsDirect()`, mengubah setelan suara/musik, dan menjalankan fungsi hapus total data progres (`resetAllGameProgress()`).
  - **Domain Use Cases:**
    - `domain/usecase/GetSettingsUseCase.kt`: Observasi reactive flow preferensi pengaturan.
    - `domain/usecase/UpdateAudioSettingsUseCase.kt`: Pembaruan status toggle Sound FX (SFX) dan Musik Latar (BGM).
    - `domain/usecase/ResetGameProgressUseCase.kt`: Eksekusi reset data seluruh entitas progres Room secara berurutan dan aman.
  - **Data Layer & Room Database Wipe:**
    - `data/local/dao/ProgressDao.kt`: Ditambahkan `@Query("DELETE FROM quest_progress")` dan `@Query("DELETE FROM answer_history")`.
    - `data/local/dao/DailyMissionDao.kt`: Ditambahkan `@Query("DELETE FROM player_daily_progress")`.
    - `data/local/dao/AchievementDao.kt`: Ditambahkan `@Query("DELETE FROM player_achievements")`.
    - `data/local/dao/KnowledgeCardDao.kt`: Ditambahkan `@Query("DELETE FROM player_cards")`.
    - `data/repository/SettingsRepositoryImpl.kt`: Mengelola persistensi SharedPreferences lokal untuk audio (`pref_sound_enabled`, `pref_music_enabled`) dan menghapus seluruh tabel progres belajar pemain (`players`, `quest_progress`, `answer_history`, `player_daily_progress`, `player_achievements`, `player_cards`).
  - **Feature UI & State Management:**
    - `feature/settings/SettingsViewModel.kt`: Mengelola `SettingsUiState` (status toggle audio, status dialog konfirmasi reset, indikator progress penghapusan data, dan pesan status snackbar).
    - `feature/settings/SettingsScreen.kt`:
      - **Bagian Suara & Musik:** Switch toggle interaktif untuk Efek Suara (SFX) dan Musik Latar (BGM) dengan deskripsi ramah anak.
      - **Bagian Data & Progres Belajar:** Kartu peringatan bertema error container yang informatif dan tombol "Reset Semua Progres".
      - **Dialog Konfirmasi (`AlertDialog`):** Mencegah penghapusan tak sengaja dengan dialog peringatan ("Reset Semua Progres?"), tombol konfirmasi "Ya, Reset Semua", dan tombol "Batal".
      - **Bagian Tentang EduQuest:** Penjelasan aplikasi versi 1.0.0 (MVP), kurikulum SD, serta kartu jaminan 100% Offline, ramah anak, tanpa iklan, dan tanpa pelacak data.
      - **Navigasi Reset Otomatis:** Mengarahkan pemain ke layar onboarding (`onNavigateToOnboarding()`) dengan membersihkan tumpukan backstack secara tuntas.
    - `core/navigation/EduQuestNavHost.kt`: Menghubungkan callback `onNavigateToOnboarding` di rute `Screen.Settings.route` dengan `popUpTo(0) { inclusive = true }`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`SettingsTest.kt`): 100% PASS (6 test cases):
      - `defaultSettingsPreferences_hasAudioEnabled`
      - `defaultSettingsUiState_hasCorrectInitialValues`
      - `getSettingsUseCase_emitsInitialPreferences`
      - `updateAudioSettingsUseCase_togglesSound`
      - `updateAudioSettingsUseCase_togglesMusic`
      - `resetGameProgressUseCase_invokesRepositoryReset`
      - `settingsUiState_resetDialogFlow`
    - Build Check:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (100% lulus pada seluruh suite unit test proyek).
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK debug terkompilasi bersih tanpa error).

---

### TASK-016 — Seed Content
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **100 Soal Kurikulum SD (`QuestionStarterData.kt`):**
    - 35 Soal Matematika (`Q_MATH_001` – `Q_MATH_035`): Penjumlahan, pengurangan cerita, perkalian berulang, pembagian adil, sifat bangun datar & sudut, keliling & luas persegi/panjang/segitiga, hingga pecahan biasa, campuran, desimal & persen (Kelas 1–6 SD).
    - 35 Soal Sains / IPA (`Q_SCI_001` – `Q_SCI_035`): Panca indra, sifat & perubahan wujud benda, fotosintesis daun, pengelompokan herbivora/karnivora/omnivora, rantai makanan ekosistem sawah & simbiosis, gaya gravitasi/gesek/pegas & energi terbarukan, hingga tata surya, revolusi bumi & gerhana (Kelas 1–6 SD).
    - 30 Soal Bahasa Indonesia (`Q_LANG_001` – `Q_LANG_030`): Lawan kata (antonim) & sinonim, ejaan huruf kapital nama/tempat & tanda baca titik/koma, kata tanya 5W1H & tanda seru perintah, ide pokok paragraf deduktif/induktif, struktur pantun rima a-b-a-b, hingga ungkapan kiasan, peribahasa bijak, dan kata baku KBBI (Kelas 1–6 SD).
    - Seluruh soal memiliki pilihan ganda terstruktur (A, B, C, D), kunci jawaban valid, pembahasan edukatif yang ramah anak (`explanation`), dan XP terukur (100–150 XP).
  - **20 Misi Petualangan Quest (`QuestStarterData.kt`):**
    - 7 Quest Matematika (`quest_math_01` – `quest_math_07`): Berjenjang dari Kelas 1 hingga Kelas 6, dengan tingkat kesulitan bertahap (EASY, NORMAL, HARD) dan level unlock (Level 1, 2, 3).
    - 7 Quest Sains / IPA (`quest_science_01` – `quest_science_07`): Berjenjang dari Kelas 1 hingga Kelas 6.
    - 6 Quest Bahasa Indonesia (`quest_lang_01` – `quest_lang_06`): Berjenjang dari Kelas 1 hingga Kelas 6.
    - Setiap quest memiliki tepat 5 soal (`questionCount = 5`) dengan reward koin dan XP seimbang.
  - **100 Pemetaan Quest-Question (`STARTER_QUEST_QUESTIONS`):**
    - Pemetaan 100% lengkap: 20 quest × 5 pertanyaan = 100 entitas `QuestQuestionEntity` dengan `orderIndex` berurutan (0, 1, 2, 3, 4).
    - Nol pertanyaan yatim piatu (*zero orphan questions*): Seluruh 100 pertanyaan terhubung ke quest masing-masing.
  - **16 Kartu Pengetahuan Edukasi (`KnowledgeCardStarterData.kt`):**
    - Kartu ensiklopedia bergambar bertema Matematika (Nol, Jam Matahari Kuno, Trik 9, Struktur Segitiga, Candi Borobudur, Pecahan), Sains (Mata Elang, Siklus Air, Klorofil Daun, Jantung, Saturnus), Keanekaragaman Hayati Indonesia (Komodo, Rafflesia Arnoldii), dan Kebudayaan Nusantara (Bahasa Daerah, Aksara Nusantara, Tradisi Pantun).
    - Masing-masing terhubung dengan syarat pembukaan quest (`unlockCondition`).
  - **Penyempurnaan Seeding Repositories:**
    - `QuestionRepositoryImpl.kt`: Memperbarui `ensureStarterQuestionsSeeded()` agar melakukan seeding jika jumlah soal kurang dari `STARTER_QUESTIONS.size`.
    - `QuestRepositoryImpl.kt`: Memperbarui `ensureStarterQuestsSeeded()` agar melakukan seeding jika jumlah quest kurang dari `STARTER_QUESTS.size`.
    - `KnowledgeCardRepositoryImpl.kt`: Memperbarui `ensureStarterCardsSeeded()` agar melakukan seeding jika jumlah kartu kurang dari `STARTER_CARDS.size`.
    - `AchievementRepositoryImpl.kt`: Memperbarui `ensureStarterAchievementsSeeded()` agar sinkron dengan `STARTER_ACHIEVEMENTS.size`.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`SeedContentTest.kt`): 100% PASS (5 test cases):
      - `questions_exactHundredQuestions_andValidStructure` (100 soal, 35 Math, 35 Science, 30 Language, format & kunci jawaban valid).
      - `quests_exactTwentyQuests_andValidConfiguration` (20 quest, 7 Math, 7 Science, 6 Language, 5 questions/quest).
      - `questQuestions_perfectHundredMappings_andIntegrity` (100 relasi orderIndex 0..4 tanpa orphan).
      - `knowledgeCards_haveValidConfiguration_andLinkToQuests` (16 kartu valid dan terhubung ke quest).
      - `worldAndAreas_haveValidConfiguration` (3 area subjek valid).
    - Unit Tests Keseluruhan:
      - `.\gradlew.bat testDebugUnitTest`: `BUILD SUCCESSFUL` (100% lulus di semua modul).
      - `KnowledgeCardTest.kt` diperbarui untuk memvalidasi 16 kartu.
    - Build Check:
      - `.\gradlew.bat assembleDebug`: `BUILD SUCCESSFUL` (APK terkompilasi bersih tanpa peringatan).

---

### TASK-017 — Polish
- **Status:** `PASS`
- **Tanggal:** 2026-10-08
- **Deliverables:**
  - **Sistem Tipografi Material 3 yang Ramah Anak (`core/ui/theme/Type.kt`):**
    - Mendefinisikan skala `Typography` lengkap (Display, Headline, Title, Body, Label) dengan ukuran proporsional, letter-spacing rapi, dan line-height optimal untuk keterbacaan anak sekolah dasar.
  - **Integrasi Efek Suara (Audio Feedback) di Seluruh Layar:**
    - `SoundManager.kt`: Engine audio 100% offline menggunakan sintesis waveform 16-bit PCM AudioTrack (tanpa dependensi file MP3/WAV eksternal).
    - Feedback klik instan (`playClick`) pada seluruh tombol navigasi, filter chip, kartu interaktif, dialog konfirmasi/batal, dan pilihan avatar/kelas.
    - Feedback suara koin (`playCoin`) saat klaim reward quest dan misi harian.
    - Feedback perayaan (`playLevelUp`) saat menyelesaikan kuis di ResultScreen.
  - **Animasi Transisi & Progres Halus (Smooth Jetpack Compose Transitions):**
    - `HomeScreen.kt`: Animasi `animateFloatAsState` pada bilah progres XP level dan kartu misi harian.
    - `QuizScreen.kt`: Animasi progres indikator soal berjenjang dan transisi `AnimatedVisibility` (fade-in & expand) untuk kartu pembahasan edukasi.
    - `ResultScreen.kt`: Animasi progres akumulasi XP level up dan kartu statistik.
    - `WorldScreen.kt`: Animasi bilah penyelesaian petualangan dunia dan bilah progres tiap subjek.
    - `DailyMissionScreen.kt`: Animasi bilah progres target harian serta progres rasio setiap misi.
    - `CollectionScreen.kt`: Animasi bilah pembukaan kartu wawasan edukasi.
    - `AchievementScreen.kt`: Animasi bilah peraihan medali/piala dan tiap pencapaian.
    - `ProfileScreen.kt`: Animasi bilah progres level, pencapaian, dan koleksi kartu.
  - **Perbaikan Bug Akurasi & Pengaturan Sebelumnya:**
    - Perhitungan jumlah soal (seperti 7/5 pada ejaan bahasa) tervalidasi tepat 5 soal per quest.
    - Alur reset progres tuntas dan bersih tanpa menimpa nama pemain baru kembali ke nilai default.
  - **Pengujian & Verifikasi:**
    - Unit Tests (`testDebugUnitTest`): `BUILD SUCCESSFUL` (100% PASS pada seluruh test suite proyek).
    - Build Check (`assembleDebug`): `BUILD SUCCESSFUL` (APK debug siap instalasi).

---

### TASK-018 — Testing
- **Status:** `PASS`
- **Tanggal:** 2026-10-09
- **Deliverables:**
  - **Rangkaian Pengujian State UI Layar Inti:**
    - `QuizUiTest.kt`: Menguji default state kuis, seleksi opsi jawaban, validasi instan, akumulasi jawaban benar & XP kuis, serta penanda penyelesaian pada soal terakhir.
    - `ResultUiTest.kt`: Menguji batas aman clamping skor terhadap total soal (proteksi mutlak terhadap bug 7/5), logika pemberian bintang (3 bintang untuk 100%, 2 bintang untuk >= 60%, 1 bintang untuk < 60%), perolehan hadiah penuh saat penyelesaian pertama, proteksi duplikasi reward pada pengerjaan ulang (replay), dan kalkulasi akurasi.
    - `OnboardingUiTest.kt`: Menguji validasi input profil (penolakan string kosong/spasi saja, penolakan karakter < 2 atau > 20 huruf, sanitasi pemotongan spasi/trimming), kepatuhan jenjang kelas SD (1..6), dan keabsahan helper avatar karakter.
  - **Pengujian Skenario Offline Lengkap (Section 44 & 46 PROJECT_SPEC.md):**
    - `OfflineGameWorkflowTest.kt`: Memvalidasi alur end-to-end tanpa koneksi internet (Airplane Mode ON):
      1. Pembuatan profil petualang (Onboarding)
      2. Pemuatan dashboard Home & seleksi quest awal
      3. Transisi status quest menjadi `IN_PROGRESS`
      4. Eksekusi 5 soal kuis dengan validasi jawaban benar/salah
      5. Penyelesaian quest pertama & penerimaan reward XP dan koin
      6. Evaluasi kenaikan level (Level Up) dan persistensi XP
      7. Pembukaan medali pencapaian (*Achievement unlock*)
      8. Pembukaan kartu wawasan edukasi (*Knowledge Card unlock*)
      9. Proteksi anti-duplikasi reward saat replay quest yang sama
      10. Reset data permainan dari Settings menuju kondisi bersih awal (*clean slate*).
  - **Pengujian Database & Room DAO Komprehensif (`DatabaseFoundationTest.kt`):**
    - Pengujian operasi database Room in-memory diperluas mencakup:
      - `PlayerDao` (insert, update, query direct, delete)
      - `QuestDao` (insert, query by ID, query count)
      - `ProgressDao` (upsert progress, answer history, reset all)
      - `AchievementDao` (insert achievement, upsert player achievement, query unlocked count flow)
      - `DailyMissionDao` (insert mission, upsert progress, update target, mark claimed, count flow)
      - `KnowledgeCardDao` (insert card, unlock player card, count flow)
      - Full Database Reset (verifikasi pembersihan seluruh entitas riwayat pemain).
  - **Hasil Pengujian & Verifikasi:**
    - Unit Tests (`testDebugUnitTest`): `BUILD SUCCESSFUL` (94 dari 94 test cases PASS 100% pada 18 test suites tanpa error/failure/skipped).
    - Build Check (`assembleDebug`): `BUILD SUCCESSFUL in 23s` (APK debug terkompilasi bersih).

---

## 🔒 Konvensi & Aturan Penting

1. **Offline First:** Seluruh fitur inti wajib dapat beroperasi tanpa internet.
2. **Small Incremental Tasks:** Kerjakan satu task terisolasi pada satu waktu dan minta persetujuan sebelum melangkah ke task berikutnya.
3. **No Premature Dependencies:** Jangan menambahkan pustaka eksternal pihak ketiga jika belum diperlukan oleh task aktif.

