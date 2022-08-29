package com.example.presentation_ball.magic_ball.ui

import com.example.presentation_common.state.UiAction

sealed class AnswerUiAction : UiAction {
    data class Load(val question: String) : AnswerUiAction()
}
