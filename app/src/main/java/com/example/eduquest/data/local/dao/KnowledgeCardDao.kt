package com.example.eduquest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eduquest.data.local.entity.KnowledgeCardEntity
import com.example.eduquest.data.local.entity.PlayerCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KnowledgeCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: KnowledgeCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCards(cards: List<KnowledgeCardEntity>)

    @Query("SELECT * FROM knowledge_cards")
    fun getAllCards(): Flow<List<KnowledgeCardEntity>>

    @Query("SELECT * FROM knowledge_cards WHERE category = :category")
    fun getCardsByCategory(category: String): Flow<List<KnowledgeCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerCard(playerCard: PlayerCardEntity)

    @Query("SELECT * FROM player_cards WHERE playerId = :playerId")
    fun getPlayerCards(playerId: String): Flow<List<PlayerCardEntity>>

    @Query("SELECT COUNT(*) FROM knowledge_cards")
    suspend fun getCardCount(): Int

    @Query("SELECT * FROM knowledge_cards")
    suspend fun getAllCardsList(): List<KnowledgeCardEntity>

    @Query("SELECT * FROM knowledge_cards WHERE id = :id")
    suspend fun getCardById(id: String): KnowledgeCardEntity?

    @Query("SELECT * FROM knowledge_cards WHERE unlockCondition = :condition")
    suspend fun getCardByUnlockCondition(condition: String): KnowledgeCardEntity?

    @Query("SELECT * FROM player_cards WHERE playerId = :playerId AND cardId = :cardId")
    suspend fun getPlayerCard(playerId: String, cardId: String): PlayerCardEntity?

    @Query("SELECT * FROM player_cards WHERE playerId = :playerId")
    suspend fun getPlayerCardsList(playerId: String): List<PlayerCardEntity>

    @Query("SELECT COUNT(*) FROM player_cards WHERE playerId = :playerId")
    fun getUnlockedCardCountFlow(playerId: String): Flow<Int>

    @Query("DELETE FROM player_cards")
    suspend fun deleteAllPlayerCards()
}
