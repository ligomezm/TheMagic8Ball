package com.example.data_local.db.answer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answer")
data class AnswerEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "type") val type: String
)
