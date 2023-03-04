package io.lostImagin4tion.vkVoiceNotes.ui.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object VkVoiceNotesRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor(): Color = vkGray

    @Composable
    override fun rippleAlpha() = RippleAlpha(
        pressedAlpha = 0.2f,
        focusedAlpha = 0.12f,
        draggedAlpha = 0.08f,
        hoveredAlpha = 0.04f
    )
}
