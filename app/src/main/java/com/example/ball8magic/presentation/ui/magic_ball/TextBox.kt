package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ball8magic.presentation.ui.theme.GreenColor
import com.example.ball8magic.presentation.ui.theme.GreenColorShadowAccent
import com.example.ball8magic.presentation.ui.theme.WhiteTextColor

@Composable
fun TextBox(readOnly: Boolean, viewModel: MagicBallViewModel = hiltViewModel()) {

    var innerText by remember { mutableStateOf(viewModel.innerText.value) }

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
                    .border(
                        BorderStroke(4.dp, GreenColor),
                        shape = RoundedCornerShape(25.dp))
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
                    .width(8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        BorderStroke(4.dp, GreenColor),
                        shape = RoundedCornerShape(25.dp)
                    )
            )
        }

        BasicTextField(
            value = innerText,
            textStyle = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(20.dp),
            onValueChange = {
                innerText = it
                viewModel.innerText.value = innerText
            },
            readOnly = readOnly
        )
    }
}


//@Preview
//@Composable
//fun TextBoxPreview() {
//    Ball8MagicTheme {
//        TextBox(true)
//    }
//}