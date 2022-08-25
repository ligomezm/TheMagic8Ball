package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ball8magic.presentation.ui.theme.GreenColor
import com.example.ball8magic.presentation.ui.theme.GreenColorShadowAccent

@Composable
fun TextBoxNeonEffect(readOnly: Boolean, viewModel: MagicBallViewModel = hiltViewModel()) {

    var innerText by remember { mutableStateOf(viewModel.innerText.value) }

    Box(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
    ) {
        val paint = remember {
            Paint().apply {
                style = PaintingStyle.Stroke
                strokeWidth = 12f
            }
        }

        val frameworkPaint = remember {
            paint.asFrameworkPaint()
        }

        val shadowColor = GreenColorShadowAccent
        val strokeColor = GreenColor

        BasicTextField(
            value = innerText,
            textStyle = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .padding(top = 60.dp, start = 20.dp, end = 25.dp),
            onValueChange = {
                innerText = it
                viewModel.innerText.value = innerText
            },
            readOnly = readOnly
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            this.drawIntoCanvas {

                val transparent = shadowColor
                    .copy(0f)
                    .toArgb()

                frameworkPaint.color = transparent

                frameworkPaint.setShadowLayer(
                    25f,
                    0f,
                    0f,
                    shadowColor.copy(.9f).toArgb()
                )

                it.drawRoundRect(
                    left = 0f,
                    top = 95f,
                    right = 845f,
                    bottom = 525f,
                    radiusX = 25.dp.toPx(), 25.dp.toPx(),
                    paint = paint
                )

                drawRoundRect(
                    strokeColor,
                    topLeft = Offset(5f, 100f),
                    size = Size(840f, 430f),
                    cornerRadius = CornerRadius(25.dp.toPx(), 25.dp.toPx()),
                    style = Stroke(width = 4.dp.toPx())
                )
            }
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            this.drawIntoCanvas {

                val transparent = shadowColor
                    .copy(0f)
                    .toArgb()

                frameworkPaint.color = transparent

                frameworkPaint.setShadowLayer(
                    25f,
                    10f,
                    10f,
                    shadowColor.copy(.9f).toArgb()
                )

                it.drawRoundRect(
                    left = 20f,
                    top = 117f,
                    right = 865f,
                    bottom = 547f,
                    radiusX = 25.dp.toPx(), 25.dp.toPx(),
                    paint = paint
                )

                drawRoundRect(
                    strokeColor,
                    topLeft = Offset(25f, 122f),
                    size = Size(840f, 430f),
                    cornerRadius = CornerRadius(25.dp.toPx(), 25.dp.toPx()),
                    style = Stroke(width = 4.dp.toPx())
                )
            }
        }
    }
}