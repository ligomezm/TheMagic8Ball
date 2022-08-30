package com.example.domain.repository

import com.example.domain.entity.Answer
import kotlinx.coroutines.flow.Flow

interface AnswerRepository {
    fun getAnswer(question: String) : Flow<List<Answer>>
}