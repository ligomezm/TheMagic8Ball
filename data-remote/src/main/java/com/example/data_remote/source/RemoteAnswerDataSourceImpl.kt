package com.example.data_remote.source

import android.util.Log
import com.example.data_remote.networking.answer.AnswerApiModel
import com.example.data_remote.networking.answer.AnswerService
import com.example.data_repository.data_source.remote.RemoteAnswerDataSource
import com.example.domain.entity.Answer
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RemoteAnswerDataSourceImpl @Inject constructor(
    private val answerService: AnswerService
) : RemoteAnswerDataSource{

    override fun getAnswer(question: String): Flow<Answer> = flow {
        emit(answerService.getAnswer(question))
    }.map { answers ->
        Log.d("api", answers.toString())
        convert(answers)
//        answers.map {
//            Log.d("api", it.toString())
//            convert(it)
//        }
    }.catch {
        Log.d("api", it.toString())
        throw UseCaseException.AnswerException(it)
    }

    private fun convert(answerApiModel: AnswerApiModel) = Answer(answerApiModel.magic.answer, answerApiModel.magic.question, answerApiModel.magic.type)


}