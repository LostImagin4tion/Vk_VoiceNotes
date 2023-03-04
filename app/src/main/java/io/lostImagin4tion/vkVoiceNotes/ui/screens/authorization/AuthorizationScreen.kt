package io.lostImagin4tion.vkVoiceNotes.ui.screens.authorization

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import io.lostImagin4tion.vkVoiceNotes.domain.entities.navigation.Routes
import io.lostImagin4tion.vkVoiceNotes.ui.theme.Dimensions
import io.lostImagin4tion.vkVoiceNotes.ui.theme.VkVoiceNotesTheme
import io.lostImagin4tion.vkVoiceNotes.ui.uiKit.buttons.TextFilledButton
import io.lostImagin4tion.vkVoiceNotes.ui.uiKit.text.LabelText
import io.lost_imagin4tion.vk_voicenotes.R

@Composable
fun AuthorizationScreen(
    navController: NavHostController
) {
    val navigateToFeed = { navController.navigate(Routes.notesFeed) }

    AuthorizationScreenContent(
        navigateToFeed = navigateToFeed
    )
}

@Composable
private fun AuthorizationScreenContent(
    navigateToFeed: () -> Unit = {}
) = ConstraintLayout(
    modifier = Modifier
        .fillMaxSize()
        .imePadding()
) {
    val (logo, authButtons) = createRefs()

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

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .constrainAs(authButtons) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .fillMaxWidth()
            .padding(bottom = Dimensions.mainVerticalPadding * 2)
            .padding(horizontal = Dimensions.mainHorizontalPadding)
    ) {
        TextFilledButton(
            onClick = navigateToFeed,
            textResource = R.string.sign_in_with_vk,
            iconResource = R.drawable.vk_white_logo,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        TextButton(
            onClick = navigateToFeed,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            LabelText(
                textRes = R.string.continue_without_auth,
                textColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AuthorizationScreenPreview() = VkVoiceNotesTheme {
    AuthorizationScreenContent()
}