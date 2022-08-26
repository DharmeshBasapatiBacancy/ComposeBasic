package com.example.thecomposedhr.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thecomposedhr.R

val SrirachaFont = FontFamily(Font(R.font.sriracha_regular))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = SrirachaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = SrirachaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = SrirachaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        fontFamily = SrirachaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    body1 = TextStyle(
        fontFamily = SrirachaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)