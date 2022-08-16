package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ball8magic.presentation.ui.theme.Ball8MagicTheme
import com.example.ball8magic.presentation.ui.theme.GreenColor

@Composable
fun TextBox(text: String) {
    Box(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .height(162.dp)
                .align(Alignment.TopStart)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, true)
                    .border(BorderStroke(4.dp, GreenColor), shape = RoundedCornerShape(25.dp))
            )
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(8.dp)
            )
        }

        Row(
            modifier = Modifier
                .height(162.dp)
                .align(Alignment.BottomEnd)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(4.dp, GreenColor),
                        shape = RoundedCornerShape(25.dp))
            )
        }

        Text(
            text = "",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(18.dp)
        )
    }
    Text(text = text)
}


@Preview
@Composable
fun TextBoxPreview() {
    Ball8MagicTheme {
        TextBox(text = "")
    }
}