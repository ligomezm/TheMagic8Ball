package com.example.ball8magic.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation_ball.magic_ball.ui.theme.Ball8MagicTheme
import com.example.presentation_ball.magic_ball.ui.MagicBallScreen
import com.example.presentation_common.navigation.NavRoutes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ball8MagicTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                   App(navController)
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavRoutes.Ball.route){
        composable(route = NavRoutes.Ball.route){
            MagicBallScreen(navController, hiltViewModel())
        }

    }

}