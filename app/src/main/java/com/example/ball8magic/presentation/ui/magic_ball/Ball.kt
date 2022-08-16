package com.example.ball8magic.presentation.ui.magic_ball

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ball8magic.presentation.ui.theme.BlueVariantColor
import com.example.ball8magic.presentation.ui.theme.GrayShadowBall
import com.example.ball8magic.presentation.ui.theme.WhiteTextColor

@Composable
fun Ball() {
    val invertedTriangleShape = GenericShape { size, _ ->
        moveTo(size.width / 2f, size.height)
        lineTo(size.width, 0f)
        lineTo(0f, 0f)
    }

    val triangleSurfaceWidth = 125.dp
    val triangleSurfaceHeight = 110.dp

    val boxWidthToPx = with(LocalDensity.current) { triangleSurfaceWidth.toPx() }
    val boxHeightToPx = with(LocalDensity.current) { triangleSurfaceHeight.toPx() }

    Box (
        modifier = Modifier
            .size(285.dp, 278.dp)
            .clip(shape = CircleShape)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        WhiteTextColor, Color.DarkGray, Color.Black),
                    center = Offset(x= 210f, y= 160f),
                    radius = 345f,
                )
            )
            .padding(end = 30.dp, bottom = 12.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        Box(
            modifier = Modifier
                .size(191.dp)
                .clip(shape = CircleShape)
                .background(GrayShadowBall),
            contentAlignment = Alignment.TopStart
        ) {
            Box(
                modifier = Modifier
                    .size(188.dp)
                    .clip(shape = CircleShape)
                    .background(Color.Black)
                    .padding(top = 36.dp),
                contentAlignment = Alignment.Center,

                ) {
                Surface(
                    shape = invertedTriangleShape,
                    modifier = Modifier
                        .size(triangleSurfaceWidth, triangleSurfaceHeight)
                        .border(
                            2.dp,
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
    }
}

@Preview
@Composable
fun BallPreview() {
    Ball()
}