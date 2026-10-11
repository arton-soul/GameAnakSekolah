# EduQuest --- PROJECT SPEC MVP

## 1. Tujuan Dokumen

Dokumen ini adalah spesifikasi teknis MVP untuk proyek **EduQuest**,
game edukasi Android offline-first.

Dokumen ini menjadi acuan utama ketika menggunakan VS Code +
Antigravity.

Prioritas:

1.  MVP kecil tetapi benar-benar playable.
2.  Offline-first.
3.  Arsitektur modular.
4.  Mudah dikembangkan.
5.  Mudah diuji.
6.  Tidak memasukkan fitur yang belum diperlukan.

------------------------------------------------------------------------

# 2. Scope MVP

MVP hanya memiliki:

-   1 jenjang: SD
-   1 world
-   3 area/subject
-   20 quest
-   100 soal
-   10 level
-   XP
-   Level Up
-   Coins
-   Achievement dasar
-   Knowledge Card dasar
-   Daily Mission
-   Local database
-   Offline gameplay
-   Profile
-   Settings
-   Sound ON/OFF

### Subject MVP

1.  Matematika
2.  Sains
3.  Bahasa

### Belum masuk MVP

-   SMP
-   SMA
-   multiplayer
-   chat
-   cloud account
-   social system
-   adaptive learning penuh
-   parent dashboard online
-   pet
-   seasonal event
-   remote content update
-   subscription kompleks

------------------------------------------------------------------------

# 3. Product Rule

## Rule 01 --- Offline First

Semua gameplay inti harus tetap berjalan tanpa internet.

## Rule 02 --- Local First

Progress pemain disimpan di database lokal.

## Rule 03 --- No Pay to Win

Premium tidak boleh memberikan keunggulan akademik yang tidak adil.

## Rule 04 --- Learning First

Setiap mekanik game harus mempunyai hubungan dengan tujuan belajar.

## Rule 05 --- Small Features

Antigravity harus mengerjakan task kecil dan terukur.

## Rule 06 --- No Unnecessary Dependencies

Jangan menambah library jika fungsi dapat dibuat menggunakan komponen
yang sudah tersedia.

------------------------------------------------------------------------

# 4. Recommended Technical Stack

Gunakan stack Android modern yang stabil dan sesuai versi tooling
project.

Rekomendasi:

-   Kotlin
-   Jetpack Compose
-   Android Architecture Components
-   ViewModel
-   Kotlin Coroutines
-   Flow
-   Room untuk local database
-   Navigation Compose
-   DataStore untuk preferensi sederhana
-   Gradle Version Catalog jika diperlukan

Untuk game 2D sederhana, utamakan UI Compose + custom drawing/animation
ringan terlebih dahulu.

Jangan menambahkan game engine besar pada MVP kecuali kebutuhan gameplay
benar-benar mengharuskannya.

------------------------------------------------------------------------

# 5. Architecture

Gunakan pola:

``` text
UI
 ↓
ViewModel
 ↓
Use Case / Domain
 ↓
Repository
 ↓
Local Data Source
 ↓
Room Database
```

Struktur:

``` text
presentation
domain
data
core
```

------------------------------------------------------------------------

# 6. Package Structure

Contoh:

``` text
com.example.eduquest

core/
    database/
    navigation/
    ui/
    util/

data/
    local/
        dao/
        entity/
        database/
    repository/

domain/
    model/
    repository/
    usecase/

feature/
    onboarding/
    home/
    world/
    quest/
    quiz/
    result/
    profile/
    achievement/
    collection/
    daily/
    settings/
```

Nama package final harus disesuaikan dengan applicationId project.

------------------------------------------------------------------------

# 7. Navigation

MVP routes:

``` text
Onboarding
    ↓
Home
    ↓
World
    ↓
Quest Detail
    ↓
Quiz
    ↓
Result
```

Route tambahan:

``` text
Home → Profile
Home → Achievement
Home → Collection
Home → Daily Mission
Home → Settings
```

Navigation tidak boleh bergantung pada network.

------------------------------------------------------------------------

# 8. Onboarding

Tujuan:

Membuat profile lokal.

Input minimum:

-   nama panggilan
-   jenjang
-   kelas

MVP hanya menerima:

``` text
Jenjang: SD
Kelas: 1–6
```

Tidak perlu email.

Tidak perlu password.

Tidak perlu akun online.

------------------------------------------------------------------------

# 9. Player Model

Fields:

``` text
id
nickname
educationLevel
grade
level
xp
coins
currentWorldId
createdAt
updatedAt
```

Default:

``` text
level = 1
xp = 0
coins = 0
```

------------------------------------------------------------------------

# 10. XP System

XP adalah integer non-negative.

Contoh reward:

``` text
Correct Answer      +100
Quest Complete      +150
Hard Question       +150
Daily Mission       +300
Retry               +20
```

XP tidak boleh menjadi negatif.

------------------------------------------------------------------------

# 11. Level System

MVP menggunakan level 1--10.

Contoh kebutuhan XP:

``` text
Level 1 → 0
Level 2 → 500
Level 3 → 1,200
Level 4 → 2,000
Level 5 → 3,000
Level 6 → 4,200
Level 7 → 5,600
Level 8 → 7,200
Level 9 → 9,000
Level 10 → 11,000
```

Nilai dapat di-balance setelah playtesting.

Level-up harus menghasilkan feedback jelas:

``` text
LEVEL UP!
Level 4 → Level 5

Reward:
+50 Coins
New Quest Unlocked
```

------------------------------------------------------------------------

# 12. Coins

Coins hanya untuk kosmetik atau fitur non-akademik.

Contoh:

``` text
Avatar frame
Avatar accessory
Profile badge
```

Coins tidak digunakan untuk:

-   membeli jawaban
-   meningkatkan nilai akademik
-   menghapus kesalahan
-   melewati seluruh pembelajaran

------------------------------------------------------------------------

# 13. Question Model

Fields:

``` text
id
educationLevel
grade
subjectId
topicId
difficulty
type
questionText
optionA
optionB
optionC
optionD
correctAnswer
explanation
xpReward
timeLimitSeconds
```

MVP question types:

``` text
MULTIPLE_CHOICE
TRUE_FALSE
```

Tipe lain ditambahkan setelah engine stabil.

------------------------------------------------------------------------

# 14. Question Rules

Setiap soal harus:

-   memiliki satu jawaban benar
-   memiliki explanation
-   memiliki subject
-   memiliki grade
-   memiliki difficulty
-   memiliki ID unik

Validation:

``` text
questionText != empty
correctAnswer != empty
explanation != empty
```

------------------------------------------------------------------------

# 15. Difficulty

Enum:

``` text
EASY
NORMAL
HARD
```

MVP menggunakan ketiga level tersebut.

------------------------------------------------------------------------

# 16. Subject

MVP:

``` text
MATH
SCIENCE
LANGUAGE
```

Setiap subject memiliki:

``` text
id
name
description
icon
```

------------------------------------------------------------------------

# 17. Topic

Contoh Math:

``` text
Addition
Subtraction
Multiplication
Division
Fractions
Geometry
```

Contoh Science:

``` text
Animals
Plants
Human Body
Earth
Solar System
Energy
```

Contoh Language:

``` text
Vocabulary
Reading
Grammar
Sentence
Spelling
```

------------------------------------------------------------------------

# 18. Quest Model

Fields:

``` text
id
worldId
title
description
subjectId
grade
difficulty
questionCount
xpReward
coinReward
unlockLevel
```

MVP:

``` text
20 quest
5 questions / quest
```

Total:

``` text
20 × 5 = 100 question slots
```

Question dapat digunakan kembali secara terbatas untuk Practice Mode,
tetapi quest utama harus memiliki komposisi soal yang terkontrol.

------------------------------------------------------------------------

# 19. Quest Progress

Fields:

``` text
playerId
questId
status
score
completedAt
attemptCount
```

Status:

``` text
LOCKED
AVAILABLE
IN_PROGRESS
COMPLETED
```

------------------------------------------------------------------------

# 20. Quiz Flow

``` text
START QUEST
 ↓
LOAD QUESTIONS
 ↓
QUESTION 1
 ↓
ANSWER
 ↓
SHOW RESULT
 ↓
SHOW EXPLANATION
 ↓
QUESTION 2
 ↓
...
 ↓
QUESTION 5
 ↓
QUEST RESULT
```

Jangan langsung berpindah ke soal berikutnya tanpa feedback kecuali
nanti tersedia mode khusus.

------------------------------------------------------------------------

# 21. Answer Processing

Ketika pemain menjawab:

``` text
answerSelected
 ↓
validate
 ↓
save result
 ↓
show correct/wrong
 ↓
show explanation
 ↓
continue
```

Jika benar:

``` text
+ question XP
```

Jika salah:

``` text
+ retry XP jika aturan mengizinkan
```

Jangan memberikan XP penuh untuk jawaban salah.

------------------------------------------------------------------------

# 22. Result Screen

Tampilkan:

``` text
Quest Complete!

Correct:
4 / 5

XP:
+450

Coins:
+20

New Achievement:
Math Explorer

Knowledge Card:
Unlocked
```

Tombol:

``` text
Continue
Replay
Back to World
```

------------------------------------------------------------------------

# 23. Achievement Model

Fields:

``` text
id
title
description
type
target
rewardXp
rewardCoins
```

Contoh:

``` text
MATH_EXPLORER
Target: 20 math questions correct

SCIENCE_STARTER
Target: 10 science questions correct

FIRST_QUEST
Target: complete first quest

KNOWLEDGE_COLLECTOR
Target: unlock 10 cards
```

------------------------------------------------------------------------

# 24. Achievement Progress

Fields:

``` text
playerId
achievementId
progress
unlocked
unlockedAt
```

Progress harus persistent.

------------------------------------------------------------------------

# 25. Knowledge Card

Fields:

``` text
id
title
category
description
fact
imageAsset
unlockCondition
```

MVP cukup menggunakan asset lokal.

Tidak perlu remote image.

------------------------------------------------------------------------

# 26. Daily Mission

MVP:

``` text
3 Math Questions
2 Science Questions
2 Language Questions
1 Logic/Bonus Challenge
```

Progress:

``` text
0/3
0/2
0/2
0/1
```

Reward:

``` text
300 XP
50 Coins
1 Knowledge Card chance
```

Daily mission menggunakan tanggal perangkat sebagai dasar rotasi.

------------------------------------------------------------------------

# 27. Date Handling

Simpan tanggal dalam format yang aman.

Jangan membandingkan tanggal menggunakan string yang tidak konsisten.

Daily reset harus mempertimbangkan local calendar date.

Jika device offline, Daily Mission tetap berfungsi.

------------------------------------------------------------------------

# 28. World

MVP:

``` text
WORLD_01
Kota Pengetahuan
```

Area:

``` text
Math Valley
Science Lab
Language Library
```

World dapat dibuat sebagai data, bukan hardcoded ke UI.

------------------------------------------------------------------------

# 29. Home Screen

Komponen:

``` text
Player Avatar
Nickname
Level
XP Progress

Daily Mission
Continue Quest

World Progress

Quick Access:
Achievement
Collection
Profile
Settings
```

Prioritas utama:

**Continue Quest** dan **Daily Mission**.

------------------------------------------------------------------------

# 30. World Screen

Tampilkan:

``` text
World Title

Area 1 — Math Valley
[Unlocked]

Area 2 — Science Lab
[Unlocked]

Area 3 — Language Library
[Locked]
```

Quest:

``` text
Quest 01
Quest 02
Quest 03
...
```

Gunakan unlock progression sederhana.

------------------------------------------------------------------------

# 31. Profile Screen

Tampilkan:

``` text
Nickname
Avatar
Level
XP
Coins

Quests Completed
Questions Answered
Correct Answers
Achievements
Knowledge Cards
```

Jangan tampilkan ranking sosial pada MVP.

------------------------------------------------------------------------

# 32. Settings

MVP:

``` text
Sound ON/OFF
Music ON/OFF
Reset Progress
About
Privacy
```

Reset Progress harus meminta konfirmasi.

------------------------------------------------------------------------

# 33. Database Design

Gunakan Room.

Tables minimum:

``` text
players
subjects
topics
questions
worlds
quests
quest_questions
quest_progress
answer_history
achievements
player_achievements
knowledge_cards
player_cards
daily_missions
player_daily_progress
```

------------------------------------------------------------------------

# 34. Relationship

``` text
Player
  |
  +-- QuestProgress
  |
  +-- AnswerHistory
  |
  +-- PlayerAchievement
  |
  +-- PlayerCard
  |
  +-- DailyMissionProgress
```

``` text
Quest
  |
  +-- QuestQuestion
       |
       +-- Question
```

------------------------------------------------------------------------

# 35. Seed Data

MVP harus memiliki seed data lokal.

Minimal:

``` text
3 Subjects
10+ Topics
20 Quests
100 Questions
10 Achievements
30 Knowledge Cards
7 Daily Mission templates
```

Seed data harus deterministic.

------------------------------------------------------------------------

# 36. Content Format

Sebelum masuk database, konten dapat dikelola sebagai JSON/CSV internal.

Contoh JSON:

``` json
{
  "id": "math_grade1_add_001",
  "grade": 1,
  "subject": "MATH",
  "topic": "ADDITION",
  "difficulty": "EASY",
  "type": "MULTIPLE_CHOICE",
  "question": "3 + 4 = ?",
  "options": ["5", "6", "7", "8"],
  "answer": "7",
  "explanation": "3 ditambah 4 sama dengan 7.",
  "xp": 100
}
```

Source content harus mudah diedit tanpa menyentuh logic game.

------------------------------------------------------------------------

# 37. UI Design Direction

Gaya:

-   modern
-   playful
-   bersih
-   tidak terlalu kekanak-kanakan untuk kelas tinggi
-   responsif
-   touch-friendly

SD:

-   ilustratif
-   friendly
-   feedback lebih ekspresif

MVP cukup fokus SD.

------------------------------------------------------------------------

# 38. Animation Rules

Gunakan animasi ringan untuk:

-   XP bertambah
-   level up
-   correct answer
-   achievement unlock
-   card unlock

Jangan menggunakan animasi berat pada setiap elemen.

Prioritas:

**performance \> visual effect.**

------------------------------------------------------------------------

# 39. Sound Rules

Sound effect:

``` text
button
correct
wrong
reward
level_up
achievement
```

Semua dapat dimatikan.

Tidak boleh ada sound yang memaksa pemain untuk terus bermain.

------------------------------------------------------------------------

# 40. Error Handling

Aplikasi harus tetap usable ketika:

-   database kosong
-   data tidak ditemukan
-   quest invalid
-   question invalid
-   progress tidak tersedia

Tampilkan fallback yang jelas.

Jangan crash karena satu data content rusak.

------------------------------------------------------------------------

# 41. Save Strategy

Progress disimpan setelah event penting:

``` text
Answer submitted
Quest completed
XP awarded
Achievement unlocked
Card unlocked
Daily mission progress
```

Jangan hanya menyimpan ketika aplikasi ditutup.

------------------------------------------------------------------------

# 42. Duplicate Reward Protection

Sistem harus mencegah:

-   XP diberikan dua kali
-   coin diberikan dua kali
-   achievement reward diberikan dua kali
-   quest completion diproses dua kali

Gunakan transaction/idempotent logic bila diperlukan.

------------------------------------------------------------------------

# 43. App Lifecycle

Jika aplikasi ditutup ketika quiz berlangsung:

MVP:

-   simpan progress minimal
-   ketika kembali, quest dapat dilanjutkan atau dimulai ulang sesuai
    aturan sederhana

Jangan kehilangan seluruh player profile.

------------------------------------------------------------------------

# 44. Offline Requirement Test

Test:

``` text
Airplane Mode ON

Open App
 ↓
Home
 ↓
World
 ↓
Quest
 ↓
Answer
 ↓
Result
 ↓
XP
 ↓
Level
 ↓
Achievement
```

Semua harus berfungsi.

------------------------------------------------------------------------

# 45. Performance Target

Target MVP:

-   tidak terasa lag pada device Android low-end
-   list/quest navigation responsif
-   database query cepat
-   tidak ada memory leak yang jelas
-   startup wajar
-   asset tidak berlebihan

Tidak perlu mengejar efek grafis berat.

------------------------------------------------------------------------

# 46. Testing Strategy

## Unit Test

Test:

-   XP calculation
-   level calculation
-   answer validation
-   quest completion
-   reward calculation
-   daily mission reset
-   achievement progress

## Database Test

Test:

-   insert
-   update
-   query
-   transaction
-   migration

## UI Test

Test:

-   onboarding
-   navigation
-   quiz
-   result
-   reset progress

------------------------------------------------------------------------

# 47. Task Breakdown untuk Antigravity

Antigravity tidak boleh diberikan task:

> "Buat seluruh EduQuest."

Gunakan task berikut.

## TASK-001 --- Project Bootstrap

Tujuan:

-   membuat project
-   package
-   build configuration
-   basic theme

Acceptance:

``` text
Build berhasil.
App dapat dibuka.
```

## TASK-002 --- Navigation

Buat:

-   onboarding
-   home
-   world
-   quest
-   quiz
-   result

Acceptance:

``` text
Semua route dapat dinavigasi.
```

## TASK-003 --- Database Foundation

Buat:

-   Room
-   entities
-   DAO
-   database

Acceptance:

``` text
Database dapat dibuat dan diakses.
```

## TASK-004 --- Player

Implement:

-   create player
-   load player
-   update player

Acceptance:

``` text
Player tetap ada setelah restart.
```

## TASK-005 --- Question Engine

Implement:

-   load question
-   answer
-   validate
-   explanation

Acceptance:

``` text
Question dapat dimainkan tanpa network.
```

## TASK-006 --- Quest Engine

Implement:

-   quest list
-   quest detail
-   quest progress
-   completion

## TASK-007 --- XP + Level

Implement:

-   XP calculation
-   persistence
-   level calculation
-   level-up event

## TASK-008 --- Reward

Implement:

-   coins
-   quest reward
-   duplicate protection

## TASK-009 --- Achievement

Implement:

-   progress
-   unlock
-   reward

## TASK-010 --- Knowledge Card

Implement:

-   collection
-   unlock
-   detail

## TASK-011 --- Daily Mission

Implement:

-   daily generation
-   progress
-   reset
-   reward

## TASK-012 --- World UI

Implement:

-   world
-   areas
-   quest unlock

## TASK-013 --- Home UI

Implement:

-   XP
-   level
-   daily mission
-   continue quest

## TASK-014 --- Profile

Implement:

-   stats
-   achievement count
-   collection count

## TASK-015 --- Settings

Implement:

-   sound
-   music
-   reset

## TASK-016 --- Seed Content

Import:

-   100 questions
-   20 quests
-   achievements
-   knowledge cards

## TASK-017 --- Polish

Improve:

-   spacing
-   typography
-   animation
-   feedback
-   sound

## TASK-018 --- Testing

Run:

-   unit tests
-   database tests
-   UI tests
-   offline test

## TASK-019 --- Release Preparation

Prepare:

-   app icon
-   version
-   release build
-   privacy documentation
-   store assets

Monetization dikerjakan setelah task ini atau setelah gameplay
dinyatakan stabil.

------------------------------------------------------------------------

# 48. Antigravity Prompt Template

Gunakan format berikut setiap memberikan task:

``` text
PROJECT: EduQuest

READ FIRST:
- rancangangame.md
- PROJECT_SPEC.md

TASK:
[jelaskan satu task]

CONSTRAINTS:
- offline-first
- jangan mengubah fitur yang tidak terkait
- jangan menambah dependency tanpa alasan
- gunakan architecture yang sudah ada
- ikuti naming convention
- jangan membuat placeholder yang dianggap selesai

BEFORE CODING:
- inspect project structure
- identify affected files
- explain implementation briefly

IMPLEMENT:
[detail]

AFTER CODING:
- run build
- run relevant tests
- fix errors
- summarize changed files
- report remaining issues

ACCEPTANCE CRITERIA:
[daftar kriteria]
```

------------------------------------------------------------------------

# 49. Rule untuk Perubahan Besar

Jika Antigravity menemukan bahwa task membutuhkan perubahan arsitektur:

**STOP sebelum implementasi besar.**

Buat:

``` text
ARCHITECTURE_CHANGE.md
```

Isi:

-   masalah
-   kondisi sekarang
-   solusi
-   file terdampak
-   risiko
-   alternatif
-   rekomendasi

Kemudian baru lanjut.

------------------------------------------------------------------------

# 50. Definition of Done MVP

MVP selesai jika:

``` text
[ ] Build berhasil
[ ] App dapat dibuka offline
[ ] Onboarding bekerja
[ ] Player tersimpan
[ ] World bekerja
[ ] Quest bekerja
[ ] Quiz bekerja
[ ] Explanation bekerja
[ ] XP bekerja
[ ] Level bekerja
[ ] Coins bekerja
[ ] Achievement bekerja
[ ] Knowledge Card bekerja
[ ] Daily Mission bekerja
[ ] Progress persistent
[ ] Duplicate reward dicegah
[ ] Reset progress bekerja
[ ] Sound toggle bekerja
[ ] Unit tests dasar tersedia
[ ] Offline test lulus
[ ] Tidak ada blocker crash
```

------------------------------------------------------------------------

# 51. Urutan Eksekusi Praktis

Mulai dari:

``` text
TASK-001
     ↓
TASK-002
     ↓
TASK-003
     ↓
TASK-004
     ↓
TASK-005
     ↓
TASK-006
     ↓
TASK-007
     ↓
TASK-008
     ↓
TASK-009
     ↓
TASK-010
     ↓
TASK-011
     ↓
TASK-012
     ↓
TASK-013
     ↓
TASK-014
     ↓
TASK-015
     ↓
TASK-016
     ↓
TASK-017
     ↓
TASK-018
     ↓
TASK-019
```

Setiap task:

``` text
Implement
→ Build
→ Test
→ Fix
→ Commit
→ Next
```

------------------------------------------------------------------------

# 52. Git Commit Strategy

Contoh:

``` text
feat: bootstrap eduquest project
feat: add navigation shell
feat: add local database
feat: add player repository
feat: add question engine
feat: add quest engine
feat: add xp progression
feat: add reward system
feat: add achievements
feat: add knowledge cards
feat: add daily missions
feat: add world progression
feat: add profile
feat: add settings
content: add initial question bank
test: add core progression tests
fix: prevent duplicate quest rewards
```

------------------------------------------------------------------------

# 53. MVP Exit Criteria

Jangan lanjut ke SMP/SMA sebelum MVP memenuhi:

1.  Anak dapat memahami gameplay tanpa penjelasan panjang.
2.  Quest dapat dimainkan offline.
3.  Progress tidak hilang.
4.  Soal dan penjelasan valid.
5.  Game tidak crash pada skenario umum.
6.  Gameplay loop terasa menyenangkan.
7.  Orang tua dapat memahami bahwa aktivitas utama adalah belajar.
8.  Arsitektur cukup stabil untuk menambah content pack.

------------------------------------------------------------------------

# 54. Prinsip Pengembangan Selanjutnya

Setelah MVP selesai:

``` text
CONTENT
   +
GAMEPLAY
   +
LEARNING
   +
SAFETY
   +
MONETIZATION
```

dikembangkan secara terpisah.

Jangan mencampurkan semuanya dalam satu sprint.

------------------------------------------------------------------------

# 55. Langkah Pertama Sekarang

Jangan coding fitur game dulu.

Urutan pertama:

``` text
1. Buat repository Git
2. Buat Android project
3. Buat PROJECT_SPEC.md
4. Jalankan TASK-001
5. Build
6. Commit
```

Setelah TASK-001 berhasil, lanjut TASK-002.

**Target awal hanya satu: aplikasi kosong yang build-nya bersih dan
fondasi project-nya benar.**
