package com.example.ball8magic.domain.usecase

import com.example.ball8magic.domain.entity.Answer
import com.example.ball8magic.domain.repository.AnswerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAnswerUseCase @Inject constructor(
    configuration: Configuration,
    private val answerRepository: AnswerRepository
) : UseCase<GetAnswerUseCase.Request, GetAnswerUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        answerRepository.getAnswer(request.question).map {
            Response(it)
        }

    data class Request(val question: String): UseCase.Request
    data class Response(val answer: Answer): UseCase.Response

}