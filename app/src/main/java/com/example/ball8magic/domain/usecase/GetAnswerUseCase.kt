package com.example.ball8magic.domain.usecase

import com.example.ball8magic.common.Resource
import com.example.ball8magic.domain.entity.Answer
import com.example.ball8magic.domain.repository.AnswerRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetAnswerUseCase @Inject constructor(private val answerRespository: AnswerRespository) {
    operator fun invoke(question: String): Flow<Resource<Answer>> = flow{
        try {
            emit(Resource.Loading())
            val answer = answerRespository.getAnswer(question)
            emit(Resource.Success(answer))
        } catch (e: IOException) {
            emit(Resource.Error("Ocurrió un error, vuelve a intentarlo"))
        }
    }
}