package com.example.presentation_ball.magic_ball.ui

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.util.Log

class SensorEventListenerImpl: SensorEventListener {

    override fun onSensorChanged(p0: SensorEvent?) {

        if ((p0?.values?.get(0) ?: 0).toFloat() > 1){
            Log.d("SensorData", (p0?.values?.get(0) ?: "None").toString())
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}