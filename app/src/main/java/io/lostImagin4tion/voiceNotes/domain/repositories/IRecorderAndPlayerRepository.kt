package io.lostImagin4tion.voiceNotes.domain.repositories

import io.lostImagin4tion.voiceNotes.data.repositories.entities.VoiceNote
import java.io.File


interface IRecorderAndPlayerRepository {

    fun startRecording(): VoiceNote
    fun stopRecording()

    fun startPlaying(file: File)
    fun stopPlaying()

    fun getDurationOfAudio(file: File): String
}