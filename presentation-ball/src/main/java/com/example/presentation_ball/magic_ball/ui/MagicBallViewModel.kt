package com.example.presentation_ball.magic_ball.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.presentation_common.state.MviViewModel
import com.example.presentation_common.state.UiSingleEvent
import com.example.presentation_common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MagicBallViewModel @Inject constructor() : MviViewModel<AnswerModel, UiState<AnswerModel>, AnswerUiAction, UiSingleEvent>() {

    val innerText = mutableStateOf("")
    override fun initState(): UiState<AnswerModel> = UiState.Loading

    override fun handleAction(action: AnswerUiAction) {
        when(action){
            is AnswerUiAction.Load ->{
                Log.d("viewmodlw", "ok")
            }
        }
    }

}