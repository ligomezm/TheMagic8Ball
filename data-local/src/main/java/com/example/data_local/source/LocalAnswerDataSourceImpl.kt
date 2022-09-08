package com.example.data_local.source

import com.example.data_repository.data_source.local.LocalAnswerDataSource
import com.example.domain.entity.Answer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalAnswerDataSourceImpl @Inject constructor(): LocalAnswerDataSource {
    override fun getAnswer(): Flow<List<Answer>> {
        TODO("Not yet implemented")
    }

    override fun addAnswer(answer: List<Answer>) {
        TODO("Not yet implemented")
    }
}