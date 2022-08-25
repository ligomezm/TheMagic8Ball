package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ball8magic.R
import com.example.ball8magic.presentation.ui.theme.Ball8MagicTheme

@Composable
fun MagicBallScreen(navController: NavController, viewModel: MagicBallViewModel = hiltViewModel()) {

    var editable by remember { mutableStateOf(false) }
    var readOnly by remember { mutableStateOf(false) }
    var innerText by remember { mutableStateOf("") }

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
                TextBoxNeonEffect(readOnly = true)
            } else {
                TextBoxNeonEffect(readOnly = false)
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

            Spacer(modifier = Modifier.height(34.dp))
            Ball()
            Spacer(modifier = Modifier.height(34.dp))
        }
    }
}


@Preview
@Composable
fun MagicBallScreenPreview() {
    val navController = rememberNavController()
    Ball8MagicTheme {
        MagicBallScreen(navController = navController)
    }
}