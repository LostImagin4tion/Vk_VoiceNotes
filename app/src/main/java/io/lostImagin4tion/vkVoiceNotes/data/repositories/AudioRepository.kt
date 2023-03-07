package io.lostImagin4tion.vkVoiceNotes.data.repositories

import android.content.Context
import android.media.MediaMetadataRetriever
import io.lostImagin4tion.vkVoiceNotes.data.repositories.entities.VoiceNote
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRepository
import java.io.File
import javax.inject.Inject

class AudioRepository @Inject constructor(
    private val context: Context
): IAudioRepository {

    private val audioRecorder by lazy { AudioRecorder(context) }
    private val audioPlayer by lazy { AudioPlayer(context) }

    private val metadataRetriever = MediaMetadataRetriever()

    override fun startRecording(): VoiceNote {
        return audioRecorder.start()
    }

    override fun stopRecording() {
        audioRecorder.stop()
    }

    override fun startPlaying(file: File) {
        audioPlayer.playFile(file)
    }

    override fun stopPlaying() {
        audioPlayer.stop()
    }

    override fun getDurationOfAudio(file: File): String {
        metadataRetriever.setDataSource(file.absolutePath)

        val duration = metadataRetriever.extractMetadata(
            MediaMetadataRetriever.METADATA_KEY_DURATION
        )?.toLong()

        return if (duration != null) {
            val minutes = duration / (1000 * 60)
            val seconds = duration % (1000 * 60) / 1000

            if (seconds < 10) {
                "$minutes:0$seconds"
            } else {
                "$minutes:$seconds"
            }
        } else ""
    }
}