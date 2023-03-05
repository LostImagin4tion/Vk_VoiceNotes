package io.lostImagin4tion.vkVoiceNotes.domain.entities

import java.io.File

data class VoiceNote(
    var name: String,
    val duration: String,
    val file: File
)