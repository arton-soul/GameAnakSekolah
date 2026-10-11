package com.example.eduquest

import com.example.eduquest.data.local.seed.AchievementStarterData
import com.example.eduquest.data.local.seed.KnowledgeCardStarterData
import com.example.eduquest.data.local.seed.QuestStarterData
import com.example.eduquest.data.local.seed.QuestionStarterData
import com.example.eduquest.data.local.seed.WorldStarterData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SeedContentTest {

    @Test
    fun questions_threeHundredQuestions_andValidStructureAcrossLevels() {
        val questions = QuestionStarterData.STARTER_QUESTIONS
        assertEquals("Total questions across SD, SMP, SMA must be exactly 300", 300, questions.size)

        // Unique IDs
        val ids = questions.map { it.id }.toSet()
        assertEquals("All 300 question IDs must be unique", 300, ids.size)

        // Level distribution
        val sdQuestions = questions.filter { it.educationLevel == "SD" }
        val smpQuestions = questions.filter { it.educationLevel == "SMP" }
        val smaQuestions = questions.filter { it.educationLevel == "SMA" }

        assertEquals("SD questions count must be 100", 100, sdQuestions.size)
        assertEquals("SMP questions count must be 100", 100, smpQuestions.size)
        assertEquals("SMA questions count must be 100", 100, smaQuestions.size)

        // SD Subject distribution: 35 MATH, 35 SCIENCE, 30 LANGUAGE
        assertEquals(35, sdQuestions.count { it.subjectId == "MATH" })
        assertEquals(35, sdQuestions.count { it.subjectId == "SCIENCE" })
        assertEquals(30, sdQuestions.count { it.subjectId == "LANGUAGE" })

        // SMP Subject distribution: 25 SMP_MATH, 25 SMP_IPA, 25 SMP_IPS, 25 SMP_LANG
        assertEquals(25, smpQuestions.count { it.subjectId == "SMP_MATH" })
        assertEquals(25, smpQuestions.count { it.subjectId == "SMP_IPA" })
        assertEquals(25, smpQuestions.count { it.subjectId == "SMP_IPS" })
        assertEquals(25, smpQuestions.count { it.subjectId == "SMP_LANG" })

        // SMA Subject distribution: 25 SMA_MATH_ADV, 25 SMA_MIPA, 25 SMA_SOSHUM, 25 SMA_GENERAL
        assertEquals(25, smaQuestions.count { it.subjectId == "SMA_MATH_ADV" })
        assertEquals(25, smaQuestions.count { it.subjectId == "SMA_MIPA" })
        assertEquals(25, smaQuestions.count { it.subjectId == "SMA_SOSHUM" })
        assertEquals(25, smaQuestions.count { it.subjectId == "SMA_GENERAL" })

        val validAnswers = setOf("A", "B", "C", "D")
        val validDifficulties = setOf("EASY", "NORMAL", "HARD")

        for (q in questions) {
            assertTrue("ID must start with Q_: ${q.id}", q.id.startsWith("Q_"))
            val validGrades = when (q.educationLevel) {
                "SMP" -> 7..9
                "SMA" -> 10..12
                else -> 1..6
            }
            assertTrue("Grade must be within $validGrades for ${q.educationLevel}: ${q.grade}", q.grade in validGrades)
            assertTrue("Difficulty must be EASY, NORMAL, or HARD: ${q.difficulty}", validDifficulties.contains(q.difficulty))
            assertTrue("Question text must be meaningful: ${q.question}", q.question.length >= 10)
            assertTrue("Option A non-empty: ${q.id}", q.optionA.isNotBlank())
            assertTrue("Option B non-empty: ${q.id}", q.optionB.isNotBlank())
            assertTrue("Option C non-empty: ${q.id}", q.optionC.isNotBlank())
            assertTrue("Option D non-empty: ${q.id}", q.optionD.isNotBlank())
            assertTrue("Answer must be A, B, C, or D: ${q.answer} in ${q.id}", validAnswers.contains(q.answer))
            assertTrue("Explanation must be educational: ${q.id}", q.explanation.length >= 10)
            assertTrue("XP must be positive: ${q.xp}", q.xp > 0)
        }
    }

    @Test
    fun quests_sixtyQuests_andValidConfigurationAcrossLevels() {
        val quests = QuestStarterData.STARTER_QUESTS
        assertEquals("Total quests must be exactly 60 (20 SD, 20 SMP, 20 SMA)", 60, quests.size)

        // Unique IDs
        val ids = quests.map { it.id }.toSet()
        assertEquals("All quest IDs must be unique", 60, ids.size)

        val sdQuests = quests.filter { it.educationLevel == "SD" }
        val smpQuests = quests.filter { it.educationLevel == "SMP" }
        val smaQuests = quests.filter { it.educationLevel == "SMA" }

        assertEquals(20, sdQuests.size)
        assertEquals(20, smpQuests.size)
        assertEquals(20, smaQuests.size)

        for (quest in quests) {
            assertEquals("Each quest must have 5 questions", 5, quest.questionCount)
            val expectedWorldId = when (quest.educationLevel) {
                "SMP" -> "WORLD_SMP_01"
                "SMA" -> "WORLD_SMA_01"
                else -> "WORLD_01"
            }
            assertEquals("World must match education level: ${quest.id}", expectedWorldId, quest.worldId)
            assertTrue("Title must not be empty", quest.title.isNotBlank())
            assertTrue("Description must not be empty", quest.description.isNotBlank())
            assertTrue("XP reward must be positive", quest.xpReward > 0)
            assertTrue("Coin reward must be positive", quest.coinReward > 0)
            assertTrue("Unlock level must be 1, 2, or 3", quest.unlockLevel in 1..3)
            val validGrades = when (quest.educationLevel) {
                "SMP" -> 7..9
                "SMA" -> 10..12
                else -> 1..6
            }
            assertTrue("Grade must be $validGrades", quest.grade in validGrades)
        }
    }

    @Test
    fun questQuestions_perfectThreeHundredMappings_andIntegrity() {
        val mappings = QuestStarterData.STARTER_QUEST_QUESTIONS
        val quests = QuestStarterData.STARTER_QUESTS.associateBy { it.id }
        val questions = QuestionStarterData.STARTER_QUESTIONS.associateBy { it.id }

        assertEquals("Total quest-question links must be exactly 300", 300, mappings.size)

        val mappedQuestionIds = mutableSetOf<String>()

        // Group by quest
        val byQuest = mappings.groupBy { it.questId }
        assertEquals("All 60 quests must have mappings", 60, byQuest.size)

        for ((questId, qMappings) in byQuest) {
            assertTrue("Quest ID must exist in STARTER_QUESTS: $questId", quests.containsKey(questId))
            assertEquals("Each quest must have exactly 5 questions mapped: $questId", 5, qMappings.size)

            val orderIndices = qMappings.map { it.orderIndex }
            assertEquals("Order indices must be 0, 1, 2, 3, 4: $questId", listOf(0, 1, 2, 3, 4), orderIndices)

            for (m in qMappings) {
                val qEntity = questions[m.questionId]
                assertNotNull("Question ${m.questionId} in quest $questId must exist in STARTER_QUESTIONS", qEntity)
                mappedQuestionIds.add(m.questionId)
            }
        }

        // Verify no orphan questions
        assertEquals("Every single one of the 300 questions must be mapped to a quest", 300, mappedQuestionIds.size)
    }

    @Test
    fun knowledgeCards_haveValidConfiguration_andLinkToQuests() {
        val cards = KnowledgeCardStarterData.STARTER_CARDS
        val quests = QuestStarterData.STARTER_QUESTS.associateBy { it.id }

        assertEquals("Must have 29 knowledge cards", 29, cards.size)

        val cardIds = cards.map { it.id }.toSet()
        assertEquals("All card IDs must be unique", 29, cardIds.size)

        for (card in cards) {
            assertTrue("Card title non-empty", card.title.isNotBlank())
            assertTrue("Card category non-empty", card.category.isNotBlank())
            assertTrue("Card description non-empty", card.description.isNotBlank())
            assertTrue("Card fact non-empty", card.fact.isNotBlank())
            assertTrue("Card image asset non-empty", card.imageAsset.isNotBlank())

            // Unlock condition must reference a valid quest
            assertTrue(
                "Card ${card.id} unlock condition '${card.unlockCondition}' must reference a valid quest",
                quests.containsKey(card.unlockCondition)
            )
        }
    }

    @Test
    fun worldAndAreas_haveValidConfiguration() {
        val worlds = WorldStarterData.STARTER_WORLDS
        val areas = WorldStarterData.STARTER_AREAS

        assertEquals(3, worlds.size)
        val worldIds = worlds.map { it.id }.toSet()
        assertTrue(worldIds.contains("WORLD_01"))
        assertTrue(worldIds.contains("WORLD_SMP_01"))
        assertTrue(worldIds.contains("WORLD_SMA_01"))

        assertEquals(11, areas.size)
        val areaSubjects = areas.map { it.subjectId }.toSet()
        // SD
        assertTrue(areaSubjects.contains("MATH"))
        assertTrue(areaSubjects.contains("SCIENCE"))
        assertTrue(areaSubjects.contains("LANGUAGE"))
        // SMP
        assertTrue(areaSubjects.contains("SMP_MATH"))
        assertTrue(areaSubjects.contains("SMP_IPA"))
        assertTrue(areaSubjects.contains("SMP_IPS"))
        assertTrue(areaSubjects.contains("SMP_LANG"))
        // SMA
        assertTrue(areaSubjects.contains("SMA_MATH_ADV"))
        assertTrue(areaSubjects.contains("SMA_MIPA"))
        assertTrue(areaSubjects.contains("SMA_SOSHUM"))
        assertTrue(areaSubjects.contains("SMA_GENERAL"))
    }
}
