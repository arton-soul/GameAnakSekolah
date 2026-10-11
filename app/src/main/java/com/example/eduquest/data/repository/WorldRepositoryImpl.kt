package com.example.eduquest.data.repository

import com.example.eduquest.data.local.dao.PlayerDao
import com.example.eduquest.data.local.dao.ProgressDao
import com.example.eduquest.data.local.dao.QuestDao
import com.example.eduquest.data.local.dao.WorldDao
import com.example.eduquest.data.local.seed.QuestStarterData
import com.example.eduquest.data.local.seed.WorldStarterData
import com.example.eduquest.domain.model.QuestStatus
import com.example.eduquest.domain.model.World
import com.example.eduquest.domain.model.WorldAreaWithProgress
import com.example.eduquest.domain.model.WorldWithProgress
import com.example.eduquest.domain.repository.WorldRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class WorldRepositoryImpl(
    private val worldDao: WorldDao,
    private val questDao: QuestDao,
    private val progressDao: ProgressDao,
    private val playerDao: PlayerDao
) : WorldRepository {

    override suspend fun ensureStarterWorldsSeeded() {
        if (worldDao.getWorldCount() < WorldStarterData.STARTER_WORLDS.size) {
            worldDao.insertWorlds(WorldStarterData.STARTER_WORLDS)
        }
    }

    override fun getWorldWithAreas(
        playerId: String,
        worldId: String
    ): Flow<WorldWithProgress?> = flow {
        ensureStarterWorldsSeeded()
        val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
            playerId
        } else {
            playerDao.getActivePlayerDirect()?.id ?: playerId
        }
        emitAll(
            combine(
                worldDao.getAllWorlds(),
                questDao.getAllQuests(),
                progressDao.getPlayerProgressFlow(effectivePlayerId),
                playerDao.getAllPlayers().map { list -> list.firstOrNull { it.id == effectivePlayerId } ?: list.firstOrNull() }
            ) { worlds, allQuests, progressList, player ->
                val playerEduLevel = player?.educationLevel ?: "SD"
                val defaultWorldId = when (playerEduLevel.uppercase()) {
                    "SMP" -> "WORLD_SMP_01"
                    "SMA" -> "WORLD_SMA_01"
                    else -> "WORLD_01"
                }
                val worldEntity = if (worldId.isNotEmpty() && worldId != "WORLD_01") {
                    worlds.firstOrNull { it.id == worldId }
                } else {
                    worlds.firstOrNull { it.id == defaultWorldId }
                } ?: worlds.firstOrNull { it.id == worldId }
                  ?: worlds.firstOrNull()
                  ?: WorldStarterData.STARTER_WORLDS.first()

                val quests = allQuests.filter { it.worldId == worldEntity.id }
                    .ifEmpty { QuestStarterData.STARTER_QUESTS.filter { it.worldId == worldEntity.id } }

                val playerLevel = player?.level ?: 1
                val isWorldUnlocked = playerLevel >= worldEntity.unlockLevel
                val progressMap = progressList.associateBy { it.questId }

                val areas = WorldStarterData.STARTER_AREAS
                    .filter { it.worldId == worldEntity.id }
                    .sortedBy { it.orderIndex }
                    .map { area ->
                        val areaQuests = quests.filter { it.subjectId == area.subjectId }
                        val completed = areaQuests.count { q ->
                            progressMap[q.id]?.status == QuestStatus.COMPLETED.name
                        }
                        val isAreaUnlocked = playerLevel >= area.unlockLevel

                        WorldAreaWithProgress(
                            area = area,
                            isUnlocked = isAreaUnlocked,
                            totalQuests = areaQuests.size,
                            completedQuests = completed
                        )
                    }

                val totalQuests = quests.size
                val totalCompleted = quests.count { q ->
                    progressMap[q.id]?.status == QuestStatus.COMPLETED.name
                }

                WorldWithProgress(
                    world = World(
                        id = worldEntity.id,
                        title = worldEntity.title,
                        description = worldEntity.description,
                        unlockLevel = worldEntity.unlockLevel,
                        orderIndex = worldEntity.orderIndex,
                        icon = "🏰"
                    ),
                    isUnlocked = isWorldUnlocked,
                    areas = areas,
                    totalQuests = totalQuests,
                    completedQuests = totalCompleted
                )
            }
        )
    }

    override fun getAllWorldsWithProgress(playerId: String): Flow<List<WorldWithProgress>> = flow {
        ensureStarterWorldsSeeded()
        val effectivePlayerId = if (playerId.isNotEmpty() && playerId != "PLAYER_LOCAL") {
            playerId
        } else {
            playerDao.getActivePlayerDirect()?.id ?: playerId
        }
        emitAll(
            combine(
                worldDao.getAllWorlds(),
                questDao.getAllQuests(),
                progressDao.getPlayerProgressFlow(effectivePlayerId),
                playerDao.getAllPlayers().map { list -> list.firstOrNull { it.id == effectivePlayerId } ?: list.firstOrNull() }
            ) { worlds, allQuests, progressList, player ->
                val activeWorlds = worlds.ifEmpty { WorldStarterData.STARTER_WORLDS }
                val playerLevel = player?.level ?: 1
                val progressMap = progressList.associateBy { it.questId }

                activeWorlds.map { worldEntity ->
                    val worldQuests = allQuests.filter { it.worldId == worldEntity.id }
                        .ifEmpty { QuestStarterData.STARTER_QUESTS.filter { it.worldId == worldEntity.id } }
                    val isWorldUnlocked = playerLevel >= worldEntity.unlockLevel

                    val areas = WorldStarterData.STARTER_AREAS
                        .filter { it.worldId == worldEntity.id }
                        .sortedBy { it.orderIndex }
                        .map { area ->
                            val areaQuests = worldQuests.filter { it.subjectId == area.subjectId }
                            val completed = areaQuests.count { q ->
                                progressMap[q.id]?.status == QuestStatus.COMPLETED.name
                            }
                            val isAreaUnlocked = playerLevel >= area.unlockLevel

                            WorldAreaWithProgress(
                                area = area,
                                isUnlocked = isAreaUnlocked,
                                totalQuests = areaQuests.size,
                                completedQuests = completed
                            )
                        }

                    val totalQuests = worldQuests.size
                    val totalCompleted = worldQuests.count { q ->
                        progressMap[q.id]?.status == QuestStatus.COMPLETED.name
                    }

                    WorldWithProgress(
                        world = World(
                            id = worldEntity.id,
                            title = worldEntity.title,
                            description = worldEntity.description,
                            unlockLevel = worldEntity.unlockLevel,
                            orderIndex = worldEntity.orderIndex,
                            icon = "🏰"
                        ),
                        isUnlocked = isWorldUnlocked,
                        areas = areas,
                        totalQuests = totalQuests,
                        completedQuests = totalCompleted
                    )
                }
            }
        )
    }

    override fun getAreasForWorld(
        playerId: String,
        worldId: String
    ): Flow<List<WorldAreaWithProgress>> =
        getWorldWithAreas(playerId, worldId).map { it?.areas ?: emptyList() }
}
