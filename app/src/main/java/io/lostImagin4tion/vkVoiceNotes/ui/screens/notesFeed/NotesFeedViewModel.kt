package io.lostImagin4tion.vkVoiceNotes.ui.screens.notesFeed

import android.content.Context
import androidx.lifecycle.ViewModel
import io.lostImagin4tion.vkVoiceNotes.VkVoiceNotesApp
import io.lostImagin4tion.vkVoiceNotes.dagger.AppComponent
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioPlayer
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRecorder
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class NotesFeedViewModel(
    appComponent: AppComponent = VkVoiceNotesApp.appComponent
): ViewModel() {

    @Inject lateinit var audioRecorder: IAudioRecorder
    @Inject lateinit var audioPlayer: IAudioPlayer

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    init {
        appComponent.inject(this)
    }

    fun startRecording() {
        val currentDate = LocalDateTime.now()
        val context = VkVoiceNotesApp.appComponent.context
        val file = File(context.cacheDir, dateFormatter.format(currentDate))

        audioRecorder.start(file)
    }

    fun stopRecording() {
        audioRecorder.stop()
    }
}