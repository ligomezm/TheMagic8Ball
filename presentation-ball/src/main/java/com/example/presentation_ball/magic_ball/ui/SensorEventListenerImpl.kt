package com.example.presentation_ball.magic_ball.ui

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel

class SensorEventListenerImpl(viewModel: MagicBallViewModel) : SensorEventListener {

    private val viewModel = viewModel

    override fun onSensorChanged(p0: SensorEvent?) {
        val question: String = viewModel.innerText.value
        if ((p0?.values?.get(0) ?: 0).toFloat() > 7){
            Log.d("SensorData", (p0?.values?.get(0) ?: "None").toString())
            Log.d("SensorData", "The question is $question")
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}