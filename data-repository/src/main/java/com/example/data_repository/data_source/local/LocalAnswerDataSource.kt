package com.example.data_repository.data_source.local

import com.example.domain.entity.Answer
import kotlinx.coroutines.flow.Flow

interface LocalAnswerDataSource {

    fun getAnswer(): Flow<List<Answer>>
    fun addAnswer(answer: List<Answer>)
}