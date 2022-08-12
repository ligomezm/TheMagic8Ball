package com.example.ball8magic.presentation

sealed class Screen(val route: String) {
    object MagicBallScreen : Screen("magic_ball_screen")
}
