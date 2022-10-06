package com.example.data_repository.data_source.remote

import com.example.domain.entity.Answer
import kotlinx.coroutines.flow.Flow

interface RemoteAnswerDataSource {
    fun getAnswer(question: String): Flow<Answer>
}