package com.example.galleryapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
private val LightColorScheme = lightColorScheme(
    background = White,
    surface = White,
    onBackground = Black,
    onSurface = Black,
    primary = PrimaryLight,
    onPrimary = White
)

private val DarkColorScheme = darkColorScheme(
    background = Black,
    surface = Black,
    onBackground = White,
    onSurface = White,
    primary = PrimaryDark,
    onPrimary = Black
)


@Composable
fun GalleryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}