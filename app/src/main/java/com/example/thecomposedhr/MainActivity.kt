package com.example.thecomposedhr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecomposedhr.ui.theme.AndroidGreen
import com.example.thecomposedhr.ui.theme.DarkTeal
import com.example.thecomposedhr.ui.theme.LightTeal
import com.example.thecomposedhr.ui.theme.TheComposeDHRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheComposeDHRTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyLemonadeStallApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyLemonadeStallApp() {
    MyLemonadeStall()
}

@Composable
fun MyLemonadeStall() {
    var stepNumber by remember { mutableStateOf(1) }
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
                    .border(1.dp, color = Color.Blue)
                    .padding(20.dp)
                    .clickable {
                        when (stepNumber) {
                            4 -> {
                                stepNumber = 1
                            }
                            2 -> {
                                //Do random tapping logic
                                stepNumber += 1
                            }
                            else -> {
                                stepNumber += 1
                            }
                        }
                    }
            )
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when (result) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "Six"
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = imageResource,
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TheComposeDHRTheme {
        BusinessCardApp()
    }
}

@Composable
fun BusinessCardApp() {
    Surface(color = DarkTeal) {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            AppLogoNameTitleCard()
            Spacer(modifier = Modifier.weight(1f))
            ContactDetailsCard()
        }
    }
}

@Composable
fun AppLogoNameTitleCard() {
    val logo = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        Text(
            text = stringResource(R.string.user_name),
            color = Color.White,
            fontSize = 50.sp,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Light
        )
        Text(
            text = stringResource(R.string.user_position),
            color = AndroidGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactDetailsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp)
            .wrapContentHeight()
    ) {
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_local_phone_24),
            stringResource(R.string.user_number)
        )
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_share_24),
            stringResource(R.string.user_handle)
        )
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_email_24),
            stringResource(R.string.user_email)
        )
    }
}

@Composable
fun LightTealDivider() {
    Divider(color = LightTeal, thickness = 2.dp)
}

@Composable
fun IconWithText(painterResource: Painter, text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp)
    ) {
        Icon(
            painter = painterResource,
            contentDescription = null,
            tint = AndroidGreen,
            modifier = Modifier.weight(1.3f)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(3f)
        )
    }
}
