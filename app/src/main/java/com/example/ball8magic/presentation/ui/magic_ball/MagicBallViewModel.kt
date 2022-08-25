package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MagicBallViewModel @Inject constructor() : ViewModel() {

    val innerText = mutableStateOf("")

}