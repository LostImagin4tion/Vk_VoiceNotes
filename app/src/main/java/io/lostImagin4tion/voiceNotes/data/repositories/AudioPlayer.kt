package io.lostImagin4tion.voiceNotes.data.repositories

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import java.io.File
import javax.inject.Inject

class AudioPlayer @Inject constructor(
    private val context: Context
) {

    private var player: MediaPlayer? = null

    fun playFile(file: File) {
        if (file.exists()) {
            MediaPlayer.create(context, file.toUri()).apply {
                player = this
                start()
            }
        }
    }

    fun stop() {
        player?.stop()
        player?.release()
        player = null
    }
}