package com.example.eduquest

import com.example.eduquest.domain.model.CoinTransactionResult
import com.example.eduquest.domain.model.LevelProgress
import com.example.eduquest.domain.model.LevelUpResult
import com.example.eduquest.domain.model.Player
import com.example.eduquest.domain.model.SettingsPreferences
import com.example.eduquest.domain.repository.PlayerRepository
import com.example.eduquest.domain.repository.SettingsRepository
import com.example.eduquest.domain.usecase.ChangeEducationLevelUseCase
import com.example.eduquest.domain.usecase.CreatePlayerUseCase
import com.example.eduquest.domain.usecase.UpdatePlayerProfileUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class PlayerUseCaseTest {

    private class FakePlayerRepository : PlayerRepository {
        var activePlayer: Player? = null

        override fun getActivePlayer(): Flow<Player?> = flowOf(activePlayer)
        override suspend fun getActivePlayerDirect(): Player? = activePlayer
        override suspend fun createPlayer(
            nickname: String,
            educationLevel: String,
            grade: Int,
            avatar: String
        ): Player {
            val player = Player(
                id = "p_test",
                nickname = nickname,
                avatar = avatar,
                educationLevel = educationLevel,
                grade = grade,
                level = 1,
                xp = 0,
                coins = 0,
                currentWorldId = when (educationLevel.uppercase()) {
                    "SMP" -> "WORLD_SMP_01"
                    "SMA" -> "WORLD_SMA_01"
                    else -> "WORLD_01"
                }
            )
            activePlayer = player
            return player
        }

        override suspend fun updatePlayer(player: Player) {
            activePlayer = player
        }

        private val dummyProgress = LevelProgress(
            currentLevel = 1,
            currentXp = 0,
            currentLevelBaseXp = 0,
            nextLevelTargetXp = 500,
            xpInCurrentLevel = 0,
            xpNeededForNextLevel = 500,
            remainingXpToNextLevel = 500,
            progressPercentage = 0f,
            isMaxLevel = false
        )

        override suspend fun addXp(playerId: String, amount: Int): LevelUpResult {
            val current = activePlayer ?: throw IllegalStateException()
            val newXp = current.xp + amount
            val updated = current.copy(xp = newXp)
            activePlayer = updated
            return LevelUpResult(1, 1, false, amount, newXp, dummyProgress)
        }

        override fun getPlayerLevelProgress(playerId: String): Flow<LevelProgress> =
            flowOf(dummyProgress)

        override suspend fun addCoins(playerId: String, amount: Int) = CoinTransactionResult(true, 0, amount, 0)
        override suspend fun spendCoins(playerId: String, amount: Int) = CoinTransactionResult(true, 0, amount, 0)
        override fun getCoinBalance(playerId: String): Flow<Int> = flowOf(0)
        override suspend fun hasPlayer(): Boolean = activePlayer != null
        override suspend fun resetPlayerData() { activePlayer = null }
    }

    private class FakeSettingsRepository : SettingsRepository {
        var resetCalled = false
        override fun getSettingsFlow(): Flow<SettingsPreferences> = flowOf(SettingsPreferences())
        override suspend fun getSettingsDirect(): SettingsPreferences = SettingsPreferences()
        override suspend fun setSoundEnabled(enabled: Boolean) {}
        override suspend fun setMusicEnabled(enabled: Boolean) {}
        override suspend fun setSoundVolume(volume: Float) {}
        override suspend fun setMusicVolume(volume: Float) {}
        override suspend fun resetAllGameProgress() { resetCalled = true }
    }

    @Test
    fun defaultPlayer_hasInitialProperties() {
        val player = Player(
            id = "PLAYER_LOCAL",
            nickname = "Petualang Muda",
            avatar = "boy_1",
            grade = 1,
            level = 1,
            xp = 0,
            coins = 0
        )

        assertEquals("PLAYER_LOCAL", player.id)
        assertEquals("Petualang Muda", player.nickname)
        assertEquals(1, player.grade)
        assertEquals(1, player.level)
        assertEquals(0, player.xp)
        assertEquals(0, player.coins)
    }

    @Test
    fun createPlayerUseCase_validatesLevelsAndGradesCorrectly() = runBlocking {
        val repo = FakePlayerRepository()
        val useCase = CreatePlayerUseCase(repo)

        // Valid SD
        val sdRes = useCase("Budi", "SD", 3, "avatar_kancil")
        assertTrue(sdRes.isSuccess)
        assertEquals("SD", sdRes.getOrNull()?.educationLevel)
        assertEquals(3, sdRes.getOrNull()?.grade)
        assertEquals("WORLD_01", sdRes.getOrNull()?.currentWorldId)

        // Valid SMP
        val smpRes = useCase("Rian", "SMP", 8, "avatar_cendekia")
        assertTrue(smpRes.isSuccess)
        assertEquals("SMP", smpRes.getOrNull()?.educationLevel)
        assertEquals(8, smpRes.getOrNull()?.grade)
        assertEquals("WORLD_SMP_01", smpRes.getOrNull()?.currentWorldId)

        // Valid SMA
        val smaRes = useCase("Citra", "SMA", 11, "avatar_ilmuwan")
        assertTrue(smaRes.isSuccess)
        assertEquals("SMA", smaRes.getOrNull()?.educationLevel)
        assertEquals(11, smaRes.getOrNull()?.grade)
        assertEquals("WORLD_SMA_01", smaRes.getOrNull()?.currentWorldId)

        // Invalid SD grade (grade 7 in SD is invalid)
        val invalidSd = useCase("Budi", "SD", 7, "avatar_kancil")
        assertTrue(invalidSd.isFailure)

        // Invalid SMP grade (grade 1 in SMP is invalid)
        val invalidSmp = useCase("Rian", "SMP", 1, "avatar_cendekia")
        assertTrue(invalidSmp.isFailure)

        // Invalid SMA grade (grade 8 in SMA is invalid)
        val invalidSma = useCase("Citra", "SMA", 8, "avatar_ilmuwan")
        assertTrue(invalidSma.isFailure)
    }

    @Test
    fun updatePlayerProfileUseCase_validatesGradeMatchingLevel() = runBlocking {
        val repo = FakePlayerRepository()
        val updateUseCase = UpdatePlayerProfileUseCase(repo)

        val player = Player(
            id = "p1",
            nickname = "Budi",
            avatar = "avatar_kancil",
            educationLevel = "SMP",
            grade = 8
        )

        // Valid update
        val validRes = updateUseCase(player.copy(nickname = "Budi Cendekia", grade = 9))
        assertTrue(validRes.isSuccess)
        assertEquals("WORLD_SMP_01", repo.activePlayer?.currentWorldId)

        // Invalid update (grade 4 for SMP)
        val invalidRes = updateUseCase(player.copy(grade = 4))
        assertTrue(invalidRes.isFailure)
    }

    @Test
    fun changeEducationLevelUseCase_resetsProgressAndCreatesNewPlayer() = runBlocking {
        val playerRepo = FakePlayerRepository()
        val settingsRepo = FakeSettingsRepository()
        val changeLevelUseCase = ChangeEducationLevelUseCase(playerRepo, settingsRepo)

        val result = changeLevelUseCase("Rio", "SMA", 10, "avatar_inovator")
        assertTrue(result.isSuccess)
        assertTrue("Reset progress must be invoked on changing education level", settingsRepo.resetCalled)
        val newPlayer = result.getOrNull()
        assertNotNull(newPlayer)
        assertEquals("SMA", newPlayer?.educationLevel)
        assertEquals(10, newPlayer?.grade)
        assertEquals("WORLD_SMA_01", newPlayer?.currentWorldId)
        assertEquals(1, newPlayer?.level)
        assertEquals(0, newPlayer?.xp)
    }
}
