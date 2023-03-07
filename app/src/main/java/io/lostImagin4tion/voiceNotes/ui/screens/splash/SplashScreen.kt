package io.lostImagin4tion.voiceNotes.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import io.lostImagin4tion.voiceNotes.ui.theme.VkVoiceNotesTheme
import io.lost_imagin4tion.vk_voicenotes.R

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
private fun SplashScreenContent() = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
) {
    val (logo, loader) = createRefs()

    Icon(
        painter = painterResource(R.drawable.ic_mic),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .constrainAs(logo) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
            .padding(top = 200.dp)
            .size(100.dp)
    )

    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .constrainAs(loader) {
                centerHorizontallyTo(parent)
                bottom.linkTo(parent.bottom)
            }
            .padding(bottom = 100.dp)
            .size(48.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview() = VkVoiceNotesTheme {
    SplashScreenContent()
}
