package com.example.eduquest

import com.example.eduquest.data.local.seed.WorldStarterData
import com.example.eduquest.domain.model.Difficulty
import com.example.eduquest.domain.model.Quest
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.QuestWithProgress
import com.example.eduquest.domain.model.World
import com.example.eduquest.domain.model.WorldArea
import com.example.eduquest.domain.model.WorldAreaWithProgress
import com.example.eduquest.domain.model.WorldWithProgress
import com.example.eduquest.feature.world.WorldUiState
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WorldUiTest {

    @Test
    fun starterWorldsAndAreas_haveValidConfiguration() {
        val worlds = WorldStarterData.STARTER_WORLDS
        val areas = WorldStarterData.STARTER_AREAS

        assertEquals(3, worlds.size)
        val world1 = worlds.first()
        assertEquals("WORLD_01", world1.id)
        assertTrue(world1.title.contains("Kota Pengetahuan"))
        assertEquals(1, world1.unlockLevel)

        assertEquals(11, areas.size)

        // Area 1: Math Valley
        val mathArea = areas.first { it.subjectId == "MATH" }
        assertEquals("area_math", mathArea.id)
        assertEquals("Math Valley", mathArea.name)
        assertEquals(1, mathArea.unlockLevel)

        // Area 2: Science Lab
        val scienceArea = areas.first { it.subjectId == "SCIENCE" }
        assertEquals("area_science", scienceArea.id)
        assertEquals("Science Lab", scienceArea.name)
        assertEquals(1, scienceArea.unlockLevel)

        // Area 3: Language Library (Unlocks at Level 2, as specified in PROJECT_SPEC Section 30)
        val langArea = areas.first { it.subjectId == "LANGUAGE" }
        assertEquals("area_language", langArea.id)
        assertEquals("Language Library", langArea.name)
        assertEquals(2, langArea.unlockLevel)
    }

    @Test
    fun areaUnlockProgression_unlocksBasedOnPlayerLevel() {
        val areas = WorldStarterData.STARTER_AREAS

        // Level 1 Player (Matches Section 30: Math & Science [Unlocked], Language [Locked])
        val playerLevel1 = 1
        val areaStatusLevel1 = areas.map { area ->
            WorldAreaWithProgress(
                area = area,
                isUnlocked = playerLevel1 >= area.unlockLevel,
                totalQuests = 3,
                completedQuests = 0
            )
        }

        val mathL1 = areaStatusLevel1.first { it.area.subjectId == "MATH" }
        val scienceL1 = areaStatusLevel1.first { it.area.subjectId == "SCIENCE" }
        val langL1 = areaStatusLevel1.first { it.area.subjectId == "LANGUAGE" }

        assertTrue("Math Valley should be unlocked at Level 1", mathL1.isUnlocked)
        assertTrue("Science Lab should be unlocked at Level 1", scienceL1.isUnlocked)
        assertFalse("Language Library should be LOCKED at Level 1", langL1.isUnlocked)

        // Level 2 Player (Language Library unlocks!)
        val playerLevel2 = 2
        val areaStatusLevel2 = areas.map { area ->
            WorldAreaWithProgress(
                area = area,
                isUnlocked = playerLevel2 >= area.unlockLevel,
                totalQuests = 3,
                completedQuests = 0
            )
        }

        val langL2 = areaStatusLevel2.first { it.area.subjectId == "LANGUAGE" }
        assertTrue("Language Library should be UNLOCKED at Level 2", langL2.isUnlocked)
    }

    @Test
    fun worldProgressCalculation_calculatesRatioAndPercentage() {
        val world = World(
            id = "WORLD_01",
            title = "Kota Pengetahuan",
            description = "Pusat petualangan ilmu",
            unlockLevel = 1,
            orderIndex = 0
        )

        val emptyProgress = WorldWithProgress(
            world = world,
            isUnlocked = true,
            areas = emptyList(),
            totalQuests = 9,
            completedQuests = 0
        )
        assertEquals(0f, emptyProgress.progressRatio, 0.001f)
        assertEquals(0, emptyProgress.completionPercentage)

        val halfProgress = WorldWithProgress(
            world = world,
            isUnlocked = true,
            areas = emptyList(),
            totalQuests = 10,
            completedQuests = 5
        )
        assertEquals(0.5f, halfProgress.progressRatio, 0.001f)
        assertEquals(50, halfProgress.completionPercentage)

        val fullProgress = WorldWithProgress(
            world = world,
            isUnlocked = true,
            areas = emptyList(),
            totalQuests = 8,
            completedQuests = 8
        )
        assertEquals(1.0f, fullProgress.progressRatio, 0.001f)
        assertEquals(100, fullProgress.completionPercentage)
    }

    @Test
    fun worldUiState_filtersQuestsBySubject() {
        val q1 = Quest("q1", "WORLD_01", "Math 1", "desc", "MATH", 1, Difficulty.EASY, 2, 100, 20, 1)
        val q2 = Quest("q2", "WORLD_01", "Science 1", "desc", "SCIENCE", 1, Difficulty.EASY, 2, 100, 20, 1)
        val q3 = Quest("q3", "WORLD_01", "Lang 1", "desc", "LANGUAGE", 1, Difficulty.EASY, 2, 100, 20, 2)

        val quests = listOf(
            QuestWithProgress(q1, QuestStatus.AVAILABLE),
            QuestWithProgress(q2, QuestStatus.AVAILABLE),
            QuestWithProgress(q3, QuestStatus.LOCKED)
        )

        val allQuestsState = WorldUiState(
            quests = quests,
            selectedSubjectId = null
        )
        assertEquals(3, allQuestsState.filteredQuests.size)

        val mathState = WorldUiState(
            quests = quests,
            selectedSubjectId = "MATH"
        )
        assertEquals(1, mathState.filteredQuests.size)
        assertEquals("MATH", mathState.filteredQuests.first().quest.subjectId)

        val scienceState = WorldUiState(
            quests = quests,
            selectedSubjectId = "SCIENCE"
        )
        assertEquals(1, scienceState.filteredQuests.size)
        assertEquals("SCIENCE", scienceState.filteredQuests.first().quest.subjectId)
    }

    @Test
    fun worldAreaWithProgress_isCompletedCalculatedCorrectly() {
        val area = WorldStarterData.STARTER_AREAS.first()

        val notStarted = WorldAreaWithProgress(area, isUnlocked = true, totalQuests = 3, completedQuests = 0)
        assertFalse(notStarted.isCompleted)

        val inProgress = WorldAreaWithProgress(area, isUnlocked = true, totalQuests = 3, completedQuests = 2)
        assertFalse(inProgress.isCompleted)

        val completed = WorldAreaWithProgress(area, isUnlocked = true, totalQuests = 3, completedQuests = 3)
        assertTrue(completed.isCompleted)
    }

    @Test
    fun questStatus_allStatusesAreDistinctAndHandled() {
        assertEquals(4, QuestStatus.entries.size)
        assertTrue(QuestStatus.entries.contains(QuestStatus.LOCKED))
        assertTrue(QuestStatus.entries.contains(QuestStatus.AVAILABLE))
        assertTrue(QuestStatus.entries.contains(QuestStatus.IN_PROGRESS))
        assertTrue(QuestStatus.entries.contains(QuestStatus.COMPLETED))
    }
}
