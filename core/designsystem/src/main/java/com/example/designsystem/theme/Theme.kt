package com.example.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

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
    onBackground = LightInk,
    onSurface = LightInk,
    onSurfaceVariant = LightMuted,
    outline = LightLine,
    outlineVariant = LightLine2,
    error = LightDanger,
)

@Composable
fun SyncBoardTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
