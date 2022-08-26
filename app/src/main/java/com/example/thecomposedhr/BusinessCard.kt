package com.example.thecomposedhr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.example.thecomposedhr.ui.theme.AndroidGreen
import com.example.thecomposedhr.ui.theme.DarkTeal
import com.example.thecomposedhr.ui.theme.LightTeal

@Composable
fun BusinessCardApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow(stringResource(id = R.string.txt_my_business_card), navController)
        },
        content = {
            Surface(color = DarkTeal) {
                Column {
                    Spacer(modifier = Modifier.weight(1f))
                    AppLogoNameTitleCard()
                    Spacer(modifier = Modifier.weight(1f))
                    ContactDetailsCard()
                }
            }
        }
    )
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