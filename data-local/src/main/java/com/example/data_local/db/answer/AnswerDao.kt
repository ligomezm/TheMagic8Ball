package com.example.data_local.db.answer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AnswerDao {

    @Query("SELECT * FROM answer")
    fun getAnswers(): Flow<List<AnswerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswers(users: List<AnswerEntity>)

}