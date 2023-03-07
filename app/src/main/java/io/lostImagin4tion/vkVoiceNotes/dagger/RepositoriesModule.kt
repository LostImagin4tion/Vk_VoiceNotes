package io.lostImagin4tion.vkVoiceNotes.dagger

import dagger.Binds
import dagger.Module
import io.lostImagin4tion.vkVoiceNotes.data.repositories.AudioPlayer
import io.lostImagin4tion.vkVoiceNotes.data.repositories.AudioRecorder
import io.lostImagin4tion.vkVoiceNotes.data.repositories.AudioRepository
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRepository
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindIAudioRepository(impl: AudioRepository): IAudioRepository
}