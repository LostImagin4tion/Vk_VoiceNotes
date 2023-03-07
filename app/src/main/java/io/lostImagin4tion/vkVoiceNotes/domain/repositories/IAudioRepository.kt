package io.lostImagin4tion.vkVoiceNotes.domain.repositories

import io.lostImagin4tion.vkVoiceNotes.data.repositories.entities.VoiceNote
import java.io.File


interface IAudioRepository {

    fun startRecording(): VoiceNote
    fun stopRecording()

    fun startPlaying(file: File)
    fun stopPlaying()

    fun getDurationOfAudio(file: File): String
}