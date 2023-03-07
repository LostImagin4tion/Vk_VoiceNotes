package io.lostImagin4tion.vkVoiceNotes.ui.screens.notesFeed

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import io.lostImagin4tion.vkVoiceNotes.VkVoiceNotesApp
import io.lostImagin4tion.vkVoiceNotes.dagger.AppComponent
import io.lostImagin4tion.vkVoiceNotes.data.repositories.entities.VoiceNote
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRepository
import javax.inject.Inject

class NotesFeedViewModel(
    appComponent: AppComponent = VkVoiceNotesApp.appComponent
): ViewModel() {

    @Inject lateinit var audioRepository: IAudioRepository

    init {
        appComponent.inject(this)
    }

    val voiceNotes = mutableStateListOf<VoiceNote>()
    private var currentRecording: VoiceNote? = null

    fun startRecording() {
        currentRecording = audioRepository.startRecording()
    }

    fun stopRecording() {
        audioRepository.stopRecording()
    }

    fun addNewVoiceNote(name: String?) {
        currentRecording?.let {
            voiceNotes.add(
                it.copy(
                    name = name ?: it.name,
                    duration = audioRepository.getDurationOfAudio(it.file)
                )
            )
        }
    }

    fun startPlaying(voiceNote: VoiceNote) {
        audioRepository.startPlaying(voiceNote.file)
    }

    fun stopPlaying() {
        audioRepository.stopPlaying()
    }
}