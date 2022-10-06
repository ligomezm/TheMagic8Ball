package com.example.presentation_ball.magic_ball.ui

import android.content.Context
import com.example.domain.usecase.GetAnswerUseCase
import com.example.presentation_common.state.CommonResultConverter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class AnswerConverter @Inject constructor(@ApplicationContext private val context: Context):
    CommonResultConverter<GetAnswerUseCase.Response, AnswerModel>() {

    override fun convertSuccess(data: GetAnswerUseCase.Response): AnswerModel {
        return AnswerModel(
            data.answer.answer,
            data.answer.question,
            data.answer.type
        )
    }
}