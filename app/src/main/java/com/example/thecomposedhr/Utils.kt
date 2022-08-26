package com.example.thecomposedhr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CustomToolbarWithBackArrow(title: String, navController: NavHostController) {
    androidx.compose.material.TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            // navigation icon is use
            // for drawer icon.
            IconButton(onClick = { navController.popBackStack() }) {
                // below line is use to
                // specify navigation icon.
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun CustomToolbar(title: String) {
    androidx.compose.material.TopAppBar(
        title = { Text(text = title) },
    )
}

@Composable
fun TopAppBarWithCenteredTitle(stringResource: String) {
    Surface(color = Color(0xFF7fb34f)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(56.dp)
                .padding(10.dp, 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource,
                color = Color.White,
                style = MaterialTheme.typography.h5,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}