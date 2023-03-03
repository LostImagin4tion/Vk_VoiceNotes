package io.lostImagin4tion.vkVoiceNotes.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.lostImagin4tion.vkVoiceNotes.ui.theme.VkVoiceNotesTheme

/**
 * [SplashScreen] - screen with logo and loader,
 * that is shown when the application is launched
 *
 * @author Egor Danilov
 */
@Composable
fun SplashScreen() {
    SplashScreenContent()
}

@Composable
private fun SplashScreenContent() = Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .fillMaxSize()
        .imePadding()
) {
    HopperLoader(
        context = LocalContext.current,
        modifier = Modifier.size(64.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview() = VkVoiceNotesTheme {
    SplashScreenContent()
}
