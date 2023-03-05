package io.lostImagin4tion.vkVoiceNotes.data.repositories

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRecorder
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class AudioRecorder @Inject constructor(
    private val context: Context
): IAudioRecorder {

    private var recorder: MediaRecorder? = null

    private fun createRecorder(): MediaRecorder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            MediaRecorder()
        }
    }

    override fun start(outputFile: File) {
        createRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(FileOutputStream(outputFile).fd)

            prepare()
            start()

            recorder = this
        }
    }

    override fun stop() {
        recorder?.stop()
        recorder?.reset()
        recorder = null
    }
}