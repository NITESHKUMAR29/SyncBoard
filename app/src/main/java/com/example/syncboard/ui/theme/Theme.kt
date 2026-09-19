package com.example.syncboard.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkAccent,
    onPrimary = DarkAccentInk,
    primaryContainer = DarkAccentTint,
    onPrimaryContainer = DarkAccent,
    secondary = TodoFgDark,
    onSecondary = TodoBgDark,
    tertiary = ProgFgDark,
    onTertiary = DarkAccentTint,
    background = DarkStage,
    surface = DarkSurface,
    surfaceVariant = DarkSunk,
    onSurface = DarkInk,
    onSurfaceVariant = DarkInk2,
    outline = DarkLine,
    outlineVariant = DarkLine2,
    error = DarkDanger,
)

private val LightColorScheme = lightColorScheme(
    primary = LightAccent,
    onPrimary = LightAccentInk,
    primaryContainer = LightAccentTint,
    onPrimaryContainer = LightAccent,
    secondary = TodoFg,
    onSecondary = TodoBg,
    tertiary = ProgFg,
    onTertiary = LightAccentTint,
    background = LightStage,
    surface = LightSurface,
    surfaceVariant = LightSunk,
    onSurface = LightInk,
    onSurfaceVariant = LightInk2,
    outline = LightLine,
    outlineVariant = LightLine2,
    error = LightDanger,
)

@Composable
fun SyncBoardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Setting false to prioritize the prototype design
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        (dynamicColor && (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)) -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

    MaterialTheme(
      colorScheme = colorScheme,
      typography = Typography,
      shapes = Shapes,
      content = content
    )
}
