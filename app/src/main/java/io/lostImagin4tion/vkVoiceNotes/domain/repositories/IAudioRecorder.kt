package io.lostImagin4tion.vkVoiceNotes.domain.repositories

import java.io.File

interface IAudioRecorder {

    fun start(outputFile: File)
    fun stop()
}