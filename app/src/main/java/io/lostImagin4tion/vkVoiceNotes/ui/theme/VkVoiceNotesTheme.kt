package io.lostImagin4tion.vkVoiceNotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = vkPrimary,
    secondary = vkPrimaryVariant,
    primaryContainer = vkPrimaryButton,
    secondaryContainer = vkSecondaryButton,
    tertiaryContainer = vkTertiaryButton,
    onPrimaryContainer = vkPrimaryButton,
    surface = Color.Black,
    surfaceVariant = vkGray,
    surfaceTint = vkDarkGray,
    inverseSurface = vkLightBackground,
    onSurface = Color.White,
    inverseOnSurface = Color.Black,
    onBackground = vkBlue,
    background = vkDarkBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = vkPrimaryVariant,
    secondary = vkPrimary,
    primaryContainer = vkPrimaryButton,
    secondaryContainer = vkSecondaryButton,
    tertiaryContainer = vkTertiaryButton,
    onPrimaryContainer = vkDarkGray,
    surface = Color.White,
    surfaceVariant = vkGray,
    surfaceTint = vkLightGray,
    inverseSurface = vkDarkBackground,
    onSurface = Color.Black,
    inverseOnSurface = Color.White,
    onBackground = vkBlue,
    background = vkLightBackground
)

@Composable
fun VkVoiceNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}