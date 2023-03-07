package io.lostImagin4tion.voiceNotes.data.repositories.entities

import java.io.File

data class VoiceNote(
    val name: String,
    val timestamp: Timestamp,
    val duration: String,
    val file: File
)

data class Timestamp(
    val date: String,
    val time: String
)