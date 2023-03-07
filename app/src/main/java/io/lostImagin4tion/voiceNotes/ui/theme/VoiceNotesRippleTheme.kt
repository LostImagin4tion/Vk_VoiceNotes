package io.lostImagin4tion.voiceNotes.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object VoiceNotesRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor(): Color = vkGray

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        pressedAlpha = 0.4f,
        focusedAlpha = 0.12f,
        draggedAlpha = 0.08f,
        hoveredAlpha = 0.04f
    )
}
