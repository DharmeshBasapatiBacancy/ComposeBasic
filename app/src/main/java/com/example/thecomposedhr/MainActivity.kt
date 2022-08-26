package com.example.thecomposedhr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thecomposedhr.Constants.BUSINESS_CARD
import com.example.thecomposedhr.Constants.DICE_ROLLER
import com.example.thecomposedhr.Constants.HOME_SCREEN
import com.example.thecomposedhr.Constants.MY_ART_SPACE
import com.example.thecomposedhr.Constants.MY_LEMONADE_STALL
import com.example.thecomposedhr.Constants.WELLNESS_DAYS
import com.example.thecomposedhr.ui.theme.TheComposeDHRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheComposeDHRTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EntryPoint()
                }
            }
        }
    }
}

@Composable
fun EntryPoint() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = HOME_SCREEN) {
        composable(route = HOME_SCREEN) {
            HomeScreenWithButtons(navController)
        }
        composable(route = MY_LEMONADE_STALL) {
            MyLemonadeStall(navController)
        }
        composable(route = DICE_ROLLER) {
            DiceWithButtonAndImage(navController)
        }
        composable(route = BUSINESS_CARD) {
            BusinessCardApp(navController)
        }
        composable(route = MY_ART_SPACE) {
            MyArtSpaceApp(navController)
        }
        composable(route = WELLNESS_DAYS) {
            DaysOfWellnessApp()
        }
    }
}






