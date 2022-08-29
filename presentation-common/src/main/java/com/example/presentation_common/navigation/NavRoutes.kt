package com.example.presentation_common.navigation

import androidx.navigation.NavArgument


private const val ROUTE_BALL = "ball"

sealed class NavRoutes(
val route: String,
val arguments: List<NavArgument> = emptyList()
){

    object Ball: NavRoutes(ROUTE_BALL)
}
