package io.lostImagin4tion.voiceNotes.ui.screens.notesFeed

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import io.lostImagin4tion.voiceNotes.VoiceNotesApp
import io.lostImagin4tion.voiceNotes.dagger.AppComponent
import io.lostImagin4tion.voiceNotes.data.repositories.entities.VoiceNote
import io.lostImagin4tion.voiceNotes.domain.repositories.IRecorderAndPlayerRepository
import javax.inject.Inject

class NotesFeedViewModel(
    appComponent: AppComponent = VoiceNotesApp.appComponent
): ViewModel() {

    @Inject lateinit var audioRepository: IRecorderAndPlayerRepository

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