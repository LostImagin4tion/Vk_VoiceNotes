package io.lostImagin4tion.vkVoiceNotes.ui.screens.notesFeed

import android.media.MediaMetadataRetriever
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.lostImagin4tion.vkVoiceNotes.VkVoiceNotesApp
import io.lostImagin4tion.vkVoiceNotes.dagger.AppComponent
import io.lostImagin4tion.vkVoiceNotes.domain.entities.VoiceNote
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioPlayer
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRecorder
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

class NotesFeedViewModel(
    appComponent: AppComponent = VkVoiceNotesApp.appComponent
): ViewModel() {

    @Inject lateinit var audioRecorder: IAudioRecorder
    @Inject lateinit var audioPlayer: IAudioPlayer

    init {
        appComponent.inject(this)
    }

    val voiceNotes = mutableStateListOf<VoiceNote>()
    private var currentRecordingFile: File? = null

    fun startRecording() = viewModelScope.launch {
        val outputFile = audioRecorder.start()
    }

    fun stopRecording() {
        audioRecorder.stop()
    }

    fun addNewVoiceNote(name: String?) {
        currentRecordingFile?.let {
            voiceNotes.add(
                VoiceNote(
                    name = name ?: it.name,
                    duration = getDurationOfAudio(it),
                    file = it
                )
            )
        }
    }

    private fun getDurationOfAudio(file: File): String {
        val retriever = MediaMetadataRetriever().apply {
            setDataSource(file.absolutePath)
        }

        val duration = retriever.extractMetadata(
            MediaMetadataRetriever.METADATA_KEY_DURATION
        )?.toLong()

        return if (duration != null) {
            val minutes = duration / (1000 * 60)
            val seconds = duration % (1000 * 60) / 1000

            "$minutes:$seconds"
        } else ""
    }
}