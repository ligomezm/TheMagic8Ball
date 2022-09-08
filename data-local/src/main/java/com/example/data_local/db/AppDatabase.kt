package com.example.data_local.db

import androidx.room.RoomDatabase
import com.example.data_local.db.answer.AnswerDao

abstract class AppDatabase: RoomDatabase() {
    abstract fun answerDao(): AnswerDao
}