package com.example.presentation_ball.magic_ball.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetAnswerUseCase
import com.example.presentation_common.state.MviViewModel
import com.example.presentation_common.state.UiSingleEvent
import com.example.presentation_common.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MagicBallViewModel @Inject constructor(
    private val getAnswerUseCase: GetAnswerUseCase,
    private val converter: AnswerConverter
) : MviViewModel<AnswerModel, UiState<AnswerModel>, AnswerUiAction, UiSingleEvent>() {


    val innerText = mutableStateOf("")
    override fun initState(): UiState<AnswerModel> = UiState.Loading

    fun loadAnswer(question: String){
        viewModelScope.launch {
            getAnswerUseCase.execute(GetAnswerUseCase.Request(question)).map {
                Log.d("viewmodel", it.toString())
                converter.convert(it)
            }.collect{
                submitState(it)
            }
        }
    }

    override fun handleAction(action: AnswerUiAction) {
        when(action){
            is AnswerUiAction.Load ->{
                loadAnswer(action.question)
                Log.d("viewmodel", "ok")
            }
        }
    }
}