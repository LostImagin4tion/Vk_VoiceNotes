package io.lostImagin4tion.vkVoiceNotes.ui.screens.notesFeed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.lostImagin4tion.vkVoiceNotes.ui.theme.Dimensions
import io.lostImagin4tion.vkVoiceNotes.ui.uiKit.cards.VoiceNoteCard
import io.lostImagin4tion.vkVoiceNotes.ui.uiKit.text.SubtitleText
import io.lost_imagin4tion.vk_voicenotes.R

@Composable
fun NotesFeedScreen(

) {
    NotesFeedScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NotesFeedScreenContent(

) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = Color.White,
                modifier = Modifier
                    .padding(bottom = Dimensions.mainVerticalPadding * 2)
                    .size(64.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_mic),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Dimensions.mainHorizontalPadding / 2)
            ) {
                item {
                    Spacer(modifier = Modifier.height(Dimensions.mainVerticalPadding * 2))

                    SubtitleText(
                        textRes = R.string.notes_feed_header
                    )

                    Spacer(modifier = Modifier.height(Dimensions.mainVerticalPadding * 2))
                }

                item {
                    var isPlaying by rememberSaveable {
                        mutableStateOf(true)
                    }

                    VoiceNoteCard(
                        onIconButtonCLick = { isPlaying = !isPlaying },
                        cardName = "Поход к адвокату",
                        timestamp = "Сегодня в 12:51",
                        audioDuration = "5:32",
                        currentAudioTime = "2:18",
                        listeningProgress = 45f,
                        isPlaying = isPlaying
                    )

                    Spacer(modifier = Modifier.height(Dimensions.commonPadding))
                }

                item {
                    var isPlaying by rememberSaveable {
                        mutableStateOf(false)
                    }

                    VoiceNoteCard(
                        onIconButtonCLick = { isPlaying = !isPlaying },
                        cardName = "Разговор с Иваном",
                        timestamp = "14.02.2022 в 15:32",
                        audioDuration = "2:31",
                        isPlaying = isPlaying
                    )

                    Spacer(modifier = Modifier.height(Dimensions.commonPadding))
                }

                item {
                    var isPlaying by rememberSaveable {
                        mutableStateOf(false)
                    }

                    VoiceNoteCard(
                        onIconButtonCLick = { isPlaying = !isPlaying },
                        cardName = "Крутой трек - надо найти!21212121212121",
                        timestamp = "12.02.2022 в 13:11",
                        audioDuration = "0:31",
                        isPlaying = isPlaying
                    )

                    Spacer(modifier = Modifier.height(Dimensions.commonPadding))
                }
            }
        }
    }
}