package io.lostImagin4tion.vkVoiceNotes.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = vkPrimary,
    secondary = vkPrimaryVariant,
    primaryContainer = vkPrimaryButton,
    secondaryContainer = vkSecondaryButton,
    tertiaryContainer = vkTertiaryButton,
    surface = Color.Black,
    surfaceVariant = vkPrimaryButton,
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
    surface = Color.White,
    surfaceVariant = Color.Black,
    inverseSurface = vkDarkBackground,
    surfaceTint = vkLightBackground,
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