package com.example.ball8magic.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ball8magic.R
import com.example.ball8magic.presentation.ui.theme.TitleColor


@Composable
fun MagicBallScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(80.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .scale(1.2F))
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = "Escribe tu pregunta a continuación",
                color = TitleColor,
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(horizontal = 54.dp),
                textAlign = TextAlign.Center
                
            )

        }
    }
}