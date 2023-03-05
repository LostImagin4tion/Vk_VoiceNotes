package io.lostImagin4tion.vkVoiceNotes.domain.repositories

import java.io.File

interface IAudioPlayer {

    fun playFile(file: File)
    fun stop()
}