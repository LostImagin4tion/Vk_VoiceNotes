package io.lostImagin4tion.vkVoiceNotes.ui.screens.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.lostImagin4tion.vkVoiceNotes.domain.entities.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * [Navigation] - composable function, which is intended to initialize navigation
 * between screens
 *
 * To add new screen, enter the corresponding path to [Routes]
 * and add new [composable] в [NavHost]
 *
 * @author Egor Danilov
 */
@Composable
fun Navigation(
    snackbarHostState: SnackbarHostState,
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val showMessage: (Int) -> Unit = { message ->
        val strMessage = context.getString(message)
        scope.launch {
            snackbarHostState.showSnackbar(strMessage)
        }
    }

    NavigationContent(
        paddingValues = paddingValues,
        navController = navController,
        showMessage = showMessage,
    )
}

@Suppress("MagicNumber")
@Composable
fun NavigationContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    showMessage: (Int) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = remember { Routes.splash }
        ) {
            composable(Routes.splash) {
                SplashScreen()

                LaunchedEffect(Unit) {
                    delay(2000)
                    navController.navigate(Routes.authorization)
                }
            }

            composable(Routes.authorization) {
                AuthorizationScreen(
                    navController = navController,
                    showMessage = showMessage
                )
            }
        }
    }
}