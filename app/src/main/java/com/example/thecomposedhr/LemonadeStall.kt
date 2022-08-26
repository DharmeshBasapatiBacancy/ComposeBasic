package com.example.thecomposedhr

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MyLemonadeStall(navController: NavHostController) {
    var stepNumber by remember { mutableStateOf(1) }
    var lemonSqueezedCount by remember { mutableStateOf(4) }
    val stepTitle: String
    val stepImage: Painter
    when (stepNumber) {
        1 -> {
            stepTitle = stringResource(id = R.string.txt_step_1)
            stepImage = painterResource(id = R.drawable.lemon_tree)
        }
        2 -> {
            stepTitle = stringResource(id = R.string.txt_step_2)
            stepImage = painterResource(id = R.drawable.lemon_squeeze)

        }
        3 -> {
            stepTitle = stringResource(id = R.string.txt_step_3)
            stepImage = painterResource(id = R.drawable.lemon_drink)
        }
        else -> {
            stepTitle = stringResource(id = R.string.txt_step_4)
            stepImage = painterResource(id = R.drawable.lemon_restart)
        }
    }

    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow(stringResource(id = R.string.txt_my_lemonade_stall), navController)
        },
        content = {
            Surface(color = Color.White) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stepTitle, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = stepImage,
                        contentDescription = null,
                        Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .padding(16.dp)
                            .clickable {
                                when (stepNumber) {
                                    1 -> {
                                        stepNumber = 2
                                        lemonSqueezedCount = (2..4).random()
                                    }
                                    2 -> {
                                        lemonSqueezedCount -= 1
                                        if (lemonSqueezedCount == 0) {
                                            stepNumber += 1
                                        }
                                    }
                                    3 -> {
                                        stepNumber = 4
                                    }
                                    4 -> {
                                        stepNumber = 1
                                    }
                                }
                            }
                    )
                }
            }
        }
    )

}