package com.example.domain.usecase

import android.util.Log
import com.example.domain.entity.Answer
import com.example.domain.repository.AnswerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetAnswerUseCase @Inject constructor(
    configuration: Configuration,
    private val answerRepository: AnswerRepository
) : UseCase<GetAnswerUseCase.Request, GetAnswerUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        answerRepository.getAnswer(request.question).map {
            Log.d("usecase", it.first().toString())
            Response(it)
        }

    data class Request(val question: String): UseCase.Request
    data class Response(val answer: List<Answer>): UseCase.Response

}