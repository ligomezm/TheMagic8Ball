package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ball8magic.presentation.ui.theme.BlueVariantColor

@Composable
fun Ball() {
    val invertedTriangleShape = GenericShape { size, _ ->
        moveTo(size.width / 2f, size.height)
        lineTo(size.width, 0f)
        lineTo(0f, 0f)
    }

    val triangleSurfaceWidth = 100.dp
    val triangleSurfaceHeight = 86.dp

    val boxWidthToPx = with(LocalDensity.current) { triangleSurfaceWidth.toPx() }
    val boxHeightToPx = with(LocalDensity.current) { triangleSurfaceHeight.toPx() }

    Box(
        modifier = Modifier
            .size(140.dp, 135.dp)
            .background(
                Color.Black)
            .padding(top = 20.dp),
        contentAlignment = Alignment.Center,

    ) {
        Surface(
            shape = invertedTriangleShape,
            modifier = Modifier
                .size(triangleSurfaceWidth, triangleSurfaceHeight)
                .border(
                    1.dp,
                    color = BlueVariantColor,
                    shape = invertedTriangleShape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                BlueVariantColor, Color.Black),
                            center = Offset(x = boxWidthToPx / 2, y = boxHeightToPx / 3),
                            radius = boxWidthToPx / 3
                        ))
            )
        }
    }

}

@Preview
@Composable
fun BallPreview() {
    Ball()
}