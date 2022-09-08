package com.example.data_repository.repository

import com.example.data_repository.data_source.local.LocalAnswerDataSource
import com.example.data_repository.data_source.remote.RemoteAnswerDataSource
import com.example.domain.entity.Answer
import com.example.domain.repository.AnswerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class AnswerRepositoryImpl @Inject constructor(
    private val localAnswerDataSource: LocalAnswerDataSource,
    private val remoteAnswerDataSource: RemoteAnswerDataSource
): AnswerRepository{

    override fun getAnswer(question: String): Flow<List<Answer>> = remoteAnswerDataSource.getAnswer(question).onEach {
        localAnswerDataSource.addAnswer(it)
    }

}