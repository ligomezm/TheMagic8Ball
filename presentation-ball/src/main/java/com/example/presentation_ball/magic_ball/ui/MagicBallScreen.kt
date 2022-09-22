package com.example.presentation_ball.magic_ball.ui

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.navigation.NavController
import com.example.presentation_ball.R

@Composable
fun MagicBallScreen(navController: NavController, viewModel: MagicBallViewModel) {

    var editable by remember { mutableStateOf(false) }
    var readOnly by remember { mutableStateOf(false) }
    var innerText by remember { mutableStateOf("") }

    val sensorManager = LocalContext.current.getSystemService(SENSOR_SERVICE) as SensorManager
    val sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

    sensorManager.registerListener(SensorEventListenerImpl(), sensor, SensorManager.SENSOR_DELAY_NORMAL)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .scale(1.2F),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier.height(50.dp)
            )

            AnimatedVisibility(visible = !editable) {
                if (!editable) {
                    Text(
                        text = "Escribe tu pregunta a continuación",
                        style = MaterialTheme.typography.h2
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )

//            if (editable) {
//                TextBox(readOnly = true)
//            } else {
//                TextBox(readOnly = false)
//            }

            if (editable) {
                TextBoxNeonEffect(readOnly = true, viewModel)
            } else {
                TextBoxNeonEffect(readOnly = false, viewModel)
            }


            Spacer(
                modifier = Modifier.height(70.dp)
            )

            AnimatedVisibility(visible = !editable) {
                PrimaryButton(text = "ENVIAR") {
                    editable = true
                }
            }

            AnimatedVisibility(visible = editable) {
                SecondaryButton(text = "Cambiar pregunta") {
                    editable = false
                }

            }

//            AnimatedVisibility(
//                visible = editable,
//                enter = fadeIn(initialAlpha = 0.4f),
//                exit = fadeOut(animationSpec = tween(durationMillis = 250))
//            ) {
//
//                Text(text = "Shake your phone to get the answer", textAlign = TextAlign.Center)
//            }

            Spacer(modifier = Modifier.height(34.dp))
            AnimatedVisibility(
                visible = editable,
                enter = fadeIn(
                    // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
//                    initialAlpha = 0.4f,
                    animationSpec = tween(durationMillis = 600)
                ),
                exit = fadeOut(
                    // Overwrites the default animation with tween

                )
            ) {
                // Content that needs to appear/disappear goes here:

                Text(text = "Shake your phone to get the answer", textAlign = TextAlign.Center)
            }

            Spacer(modifier = Modifier.height(34.dp))
            Ball()
            Spacer(modifier = Modifier.height(34.dp))
        }
    }
}


//@Preview
//@Composable
//fun MagicBallScreenPreview() {
//    val navController = rememberNavController()
//    Ball8MagicTheme {
//        MagicBallScreen(navController = navController)
//    }
//}