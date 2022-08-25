package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ball8magic.presentation.ui.theme.Ball8MagicTheme

@Composable
fun PrimaryButton(text: String, action: () -> Unit) {

    Button(
        onClick = { action() },
        modifier = Modifier
            .height(45.dp)
            .width(214.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.9f)
        )

    ) {
        Text(text)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    Ball8MagicTheme {
        PrimaryButton("ENVIAR") {

        }
    }
}