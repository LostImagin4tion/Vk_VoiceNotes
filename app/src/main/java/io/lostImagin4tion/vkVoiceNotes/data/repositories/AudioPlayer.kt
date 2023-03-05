package io.lostImagin4tion.vkVoiceNotes.data.repositories

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioPlayer
import java.io.File
import javax.inject.Inject

class AudioPlayer @Inject constructor(
    private val context: Context
): IAudioPlayer {

    private var player: MediaPlayer? = null

    override fun playFile(file: File) {
        MediaPlayer.create(context, file.toUri()).apply {
            player = this
            start()
        }
    }

    override fun stop() {
        player?.stop()
        player?.release()
        player = null
    }
}