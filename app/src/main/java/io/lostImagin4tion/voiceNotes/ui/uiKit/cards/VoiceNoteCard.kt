package io.lostImagin4tion.voiceNotes.ui.uiKit.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.lostImagin4tion.voiceNotes.ui.theme.Dimensions
import io.lostImagin4tion.voiceNotes.ui.theme.VoiceNotesTheme
import io.lostImagin4tion.voiceNotes.ui.uiKit.text.LabelText
import io.lostImagin4tion.voiceNotes.R

@Composable
fun VoiceNoteCard(
    cardName: String,
    timestamp: String,
    audioDuration: String,
    modifier: Modifier = Modifier,
    isPlaying: Boolean = false,
    listeningProgress: Float = 0.0f,
    currentAudioTime: String? = null,
    onIconButtonCLick: () -> Unit = {}
) = Column(
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start,
    modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20))
        .background(MaterialTheme.colorScheme.surfaceTint)
) {
    val iconBackgroundColor = if (isPlaying) {
        MaterialTheme.colorScheme.tertiaryContainer
    } else {
        MaterialTheme.colorScheme.primaryContainer
    }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                top = Dimensions.commonPadding,
                bottom = Dimensions.mainVerticalPadding,
                start = Dimensions.commonPadding,
                end = Dimensions.mainHorizontalPadding / 2
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(4f, fill = false)
                .fillMaxWidth()
                .padding(end = Dimensions.commonPadding)
        ) {
            LabelText(
                text = cardName,
                isLarge = true,
                textColor = MaterialTheme.colorScheme.primary,
            )

            LabelText(
                text = timestamp,
                textColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.wrapContentSize()
        ) {
            currentAudioTime?.let {
                LabelText(
                    text = "$currentAudioTime",
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer
                )

                LabelText(
                    text = " / ",
                    textColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }

            LabelText(
                text = audioDuration,
                textColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(modifier = Modifier.width(Dimensions.commonPadding))

            IconButton(
                onClick = onIconButtonCLick,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(iconBackgroundColor)
                    .size(30.dp)
            ) {
                Icon(
                    painter = if (isPlaying) {
                        painterResource(R.drawable.ic_pause)
                    } else {
                        painterResource(R.drawable.ic_play)
                    },
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

    LinearProgressIndicator(
        progress = listeningProgress / 100,
        color = MaterialTheme.colorScheme.primaryContainer,
        trackColor = Color.Transparent,
        strokeCap = StrokeCap.Round,
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
    )
}

@Preview
@Composable
private fun VoiceNoteCardPreview() = VoiceNotesTheme {
    VoiceNoteCard(
        cardName = "Крутой трек - надо найти!21212121212121",
        timestamp = "Сегодня в 12:51",
        audioDuration = "5:32",
        currentAudioTime = "2:18",
        listeningProgress = 45f,
        isPlaying = true
    )
}