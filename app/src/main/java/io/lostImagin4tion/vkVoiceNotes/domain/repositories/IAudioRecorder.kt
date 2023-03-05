package io.lostImagin4tion.vkVoiceNotes.domain.repositories

import java.io.File

interface IAudioRecorder {

    fun start(): File
    fun stop()
}