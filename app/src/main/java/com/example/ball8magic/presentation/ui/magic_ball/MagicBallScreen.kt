package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ball8magic.R

@Composable
fun MagicBallScreen(navController: NavController) {
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
            TextBox(text = "")
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryButton(text = "enviar")
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryButton(text = "Cambiar pregunta")
            Spacer(modifier = Modifier.height(10.dp))
            Ball()
        }
    }
}