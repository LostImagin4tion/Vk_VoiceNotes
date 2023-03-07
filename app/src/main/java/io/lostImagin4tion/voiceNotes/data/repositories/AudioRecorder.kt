package io.lostImagin4tion.voiceNotes.data.repositories

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import io.lostImagin4tion.voiceNotes.data.repositories.entities.Timestamp
import io.lostImagin4tion.voiceNotes.data.repositories.entities.VoiceNote
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class AudioRecorder @Inject constructor(
    private val context: Context
) {

    private var recorder: MediaRecorder? = null

    private val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy,HH:mm:ss")

    private fun createRecorder(): MediaRecorder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            MediaRecorder()
        }
    }

    fun start(): VoiceNote {
        val currentDate = getCurrentTimeStamp()
        val outputFile = File(context.externalCacheDir, "$currentDate.mp3")

        val (date, time) = currentDate.split(",")

        createRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(FileOutputStream(outputFile).fd)

            prepare()
            start()

            recorder = this
        }


        return VoiceNote(
            name = currentDate,
            duration = "",
            timestamp = Timestamp(
                date = date,
                time = time
            ),
            file = outputFile
        )
    }

    fun stop() {
        recorder?.stop()
        recorder?.reset()
        recorder = null
    }

    private fun getCurrentTimeStamp() = dateTimeFormatter.format(LocalDateTime.now())
}