package com.sudansh.planetm.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val Dark = Color(0xFF111226)
val White = Color(0xFFFFFFFF)
val LightGray = Color(0xFFB5B5B5)
val Gray = Color(0xFF8E8E93)
val BrightBlue = Color(0xFF007AFF)

private val LightColorPalette = lightColors(
    primary = BrightBlue,
    secondary = LightGray,
    background = White,
    onPrimary = White,
    surface = White,
    onSurface = Dark
)

@Composable
fun PlanetMTheme(
    content: @Composable () -> Unit
) {
    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}