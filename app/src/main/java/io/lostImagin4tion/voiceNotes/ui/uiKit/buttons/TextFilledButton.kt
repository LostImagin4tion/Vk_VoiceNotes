package io.lostImagin4tion.voiceNotes.ui.uiKit.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.lostImagin4tion.voiceNotes.ui.theme.Dimensions

/**
 * [TextFilledButton] - basic Material You filled button
 * Contains Text and optional Icon
 *
 * @author Egor Danilov
 */
@Composable
fun TextFilledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    contentPadding: PaddingValues = PaddingValues(vertical = 14.dp),
    colors: ButtonColors,
    @StringRes textResource: Int,
    @DrawableRes iconResource: Int? = null,
    isEnabled: Boolean = true,
    textAlign: TextAlign = TextAlign.Center,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
) = Button(
    onClick = onClick,
    enabled = isEnabled,
    contentPadding = contentPadding,
    colors = colors,
    modifier = modifier
) {
    iconResource?.let {
        Image(
            painter = painterResource(iconResource),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
    }

    Text(
        text = stringResource(textResource),
        textAlign = textAlign,
        style = textStyle,
        modifier = Modifier
            .iconPadding(iconResource)
    )
}

private fun Modifier.iconPadding(iconResource: Int?): Modifier =
    if (iconResource != null) then(this.padding(start = Dimensions.commonPadding)) else this
