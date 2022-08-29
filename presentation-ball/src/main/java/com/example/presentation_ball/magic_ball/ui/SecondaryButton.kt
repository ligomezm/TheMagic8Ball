package com.example.presentation_ball.magic_ball.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation_ball.magic_ball.ui.theme.Ball8MagicTheme

@Composable
fun SecondaryButton(text: String, action: () -> Unit) {

    Box(
        modifier = Modifier.size(214.dp, 45.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Button(
            onClick = { action() },
            modifier = Modifier
                .height(38.dp)
                .width(214.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.7f)),
        ) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun SecondaryButtonPreview() {
    Ball8MagicTheme {
        SecondaryButton(text = "Cambiar pregunta") {}
    }
}