package com.example.domain.usecase

import com.example.domain.entity.Answer
import com.example.domain.repository.AnswerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAnswerUseCase(
    configuration: Configuration,
    private val answerRepository: AnswerRepository
) : UseCase<GetAnswerUseCase.Request, GetAnswerUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        answerRepository.getAnswer(request.question).map {
            Response(it)
        }

    data class Request(val question: String): UseCase.Request
    data class Response(val answer: List<Answer>): UseCase.Response

}