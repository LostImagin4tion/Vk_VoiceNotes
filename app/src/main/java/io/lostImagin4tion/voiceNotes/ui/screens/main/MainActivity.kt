package io.lostImagin4tion.voiceNotes.ui.screens.main

import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import io.lostImagin4tion.voiceNotes.domain.entities.navigation.Routes
import io.lostImagin4tion.voiceNotes.ui.screens.navigation.Navigation
import io.lostImagin4tion.voiceNotes.ui.theme.VoiceNotesRippleTheme
import io.lostImagin4tion.voiceNotes.ui.theme.VoiceNotesTheme
import timber.log.Timber

/**
 * [MainActivity] - the initial activity that starts navigation across the app
 *
 * @author Egor Danilov
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavHostController
    private val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
        when (result) {
            is VKAuthenticationResult.Success -> {
                Timber.d("VK TOKEN ${result.token.accessToken}")
                navController.navigate(Routes.notesFeed)
            }
            is VKAuthenticationResult.Failed -> {
                Timber.d("AUTH ERROR ${result.exception.message}")
                navController.navigate(Routes.authorization)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissions(this)

        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            navController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }

            val loginWithVK: () -> Unit = { authLauncher.launch(arrayListOf(VKScope.DOCS)) }

            VoiceNotesTheme {
                CompositionLocalProvider(
                    LocalRippleTheme provides VoiceNotesRippleTheme
                ) {
                    SetupStatusBarColor()

                    Scaffold(
                        snackbarHost = {
                            SnackbarHost(
                                hostState = snackbarHostState,
                                modifier = Modifier.navigationBarsPadding()
                            ) {
                                Snackbar(
                                    snackbarData = it,
                                    containerColor = MaterialTheme.colorScheme.inverseSurface,
                                    contentColor = MaterialTheme.colorScheme.inverseOnSurface,
                                    shape = MaterialTheme.shapes.small
                                )
                            }
                        },
                        content = {
                            Navigation(
                                snackbarHostState = snackbarHostState,
                                paddingValues = it,
                                navController = navController,
                                loginWithVK = loginWithVK
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SetupStatusBarColor() {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val currentWindow = (view.context as? Activity)?.window
            ?: error("Not in an activity - unable to get Window reference")

        val color = MaterialTheme.colorScheme.background.toArgb()
        val isLightStatusBar = !isSystemInDarkTheme()

        SideEffect {
            currentWindow.statusBarColor = color
            WindowCompat.getInsetsController(currentWindow, view)
                .isAppearanceLightStatusBars = isLightStatusBar
        }
    }
}

private fun requestPermissions(activity: Activity) {
    ActivityCompat.requestPermissions(
        activity,
        arrayOf(Manifest.permission.RECORD_AUDIO),
        0
    )
}