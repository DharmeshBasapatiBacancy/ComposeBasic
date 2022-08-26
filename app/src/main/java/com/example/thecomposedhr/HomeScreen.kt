package com.example.thecomposedhr

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thecomposedhr.Constants.BUSINESS_CARD
import com.example.thecomposedhr.Constants.DICE_ROLLER
import com.example.thecomposedhr.Constants.MY_ART_SPACE
import com.example.thecomposedhr.Constants.MY_LEMONADE_STALL
import com.example.thecomposedhr.Constants.WELLNESS_DAYS

@Composable
fun HomeScreenWithButtons(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbar(title = stringResource(R.string.txt_compose_basic_app))
        }
    ) {
        Surface(color = Color.White) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { navController.navigate(MY_LEMONADE_STALL) },
                    Modifier.width(200.dp)
                ) {
                    Text(text = stringResource(R.string.txt_my_lemonade_stall))
                }
                Button(
                    onClick = { navController.navigate(DICE_ROLLER) },
                    Modifier.width(200.dp)
                ) {
                    Text(text = stringResource(R.string.txt_my_dice_roller))
                }
                Button(
                    onClick = { navController.navigate(BUSINESS_CARD) },
                    Modifier.width(200.dp)
                ) {
                    Text(text = stringResource(R.string.txt_my_business_card))
                }
                Button(
                    onClick = { navController.navigate(MY_ART_SPACE) },
                    Modifier.width(200.dp)
                ) {
                    Text(text = stringResource(R.string.txt_my_art_space))
                }
                Button(
                    onClick = { navController.navigate(WELLNESS_DAYS) },
                    Modifier.width(200.dp)
                ) {
                    Text(text = stringResource(R.string.txt_days_of_wellness))
                }
            }
        }
    }


}