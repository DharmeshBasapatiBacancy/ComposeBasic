package com.example.thecomposedhr

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thecomposedhr.data.DataSource
import com.example.thecomposedhr.data.models.Wellness

@Composable
fun DaysOfWellnessApp() {
    Scaffold(
        topBar = {
            TopAppBarWithCenteredTitle(stringResource(id = R.string.txt_days_of_wellness))
        },
        content = {
            LazyColumn {
                items(DataSource.wellnessList) { item: Wellness ->
                    WellnessCard(item)
                }
            }
        }
    )
}

@Composable
fun WellnessCard(item: Wellness) {
    var expanded by remember { mutableStateOf(false) }
    Surface {
        Card(
            elevation = 10.dp, modifier = Modifier.padding(20.dp),
            border = BorderStroke(1.dp, color = Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                Text(
                    text = item.dayOfTheMonth,
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = item.goalSummary, color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = item.goalImage),
                    contentDescription = item.goalSummary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded },
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (expanded) {
                    Text(
                        text = item.goalDescription, color = Color.Black,
                        fontSize = 12.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

