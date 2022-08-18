package com.example.ball8magic.presentation.ui.magic_ball

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MagicBallViewModel @Inject constructor() : ViewModel() {

    val _state = mutableStateOf("")
    val state : String = _state.value

    fun updateInnerText(text: String) {
        Log.d("viewModel", text)
        viewModelScope.launch { _state.value = text }
    }
}