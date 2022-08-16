package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ball8magic.R
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults

@Composable
fun MagicBallScreen(navController: NavController) {
    var editable by remember { mutableStateOf(false) }
    var textInner by remember { mutableStateOf("")}

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(30.dp)
                .scale(1.2F))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = "Escribe tu pregunta a continuación",
                style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(25.dp))
            TextBox(text = textInner)
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedVisibility(visible = !editable){
                //PrimaryButton(text = "enviar")
                Button(
                        modifier = Modifier
                            .height(45.dp)
                            .width(196.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            editable = true
                        }
                    ) {
                        Text("ENVIAR")
                    }
            }

            Spacer(modifier = Modifier.height(10.dp))
            AnimatedVisibility(visible = editable) {
               // SecondaryButton(text = "Cambiar pregunta")
               Button(
                       onClick = {},
                       modifier = Modifier
                           .height(38.dp)
                           .width(200.dp),
                       shape = RoundedCornerShape(10.dp),
                       colors = ButtonDefaults.buttonColors(
                           backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.7f)),
                   ) {
                       Text(text = "Cambiar pregunta")
                   }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Ball()
        }
    }
}