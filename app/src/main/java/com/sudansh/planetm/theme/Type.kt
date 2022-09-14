package com.sudansh.planetm.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sudansh.planetm.R

val sfPro = FontFamily(
    Font(R.font.sfprodisplay_bold, weight = FontWeight.Bold),
    Font(R.font.sfprodisplay_regular, weight = FontWeight.Normal),
    Font(R.font.sfprodisplay_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sfprodisplay_medium, weight = FontWeight.Medium),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = Dark,
        textAlign = TextAlign.Left,
        letterSpacing = (-1.36).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Dark,
        textAlign = TextAlign.Left,
    ),
    body1 = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = White,
        textAlign = TextAlign.Left
    ),
    body2 = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Gray,
        textAlign = TextAlign.Left
    ),
    caption = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = LightGray,
        textAlign = TextAlign.Center
    ),
    button = TextStyle(
        fontFamily = sfPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = White,
    )
)