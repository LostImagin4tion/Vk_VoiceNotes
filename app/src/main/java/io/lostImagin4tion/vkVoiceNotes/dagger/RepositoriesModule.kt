package io.lostImagin4tion.vkVoiceNotes.dagger

import dagger.Binds
import dagger.Module
import io.lostImagin4tion.vkVoiceNotes.data.repositories.AudioPlayer
import io.lostImagin4tion.vkVoiceNotes.data.repositories.AudioRecorder
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioPlayer
import io.lostImagin4tion.vkVoiceNotes.domain.repositories.IAudioRecorder
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindIAudioRecorder(impl: AudioRecorder): IAudioRecorder

    @Singleton
    @Binds
    abstract fun bindIAudioPlayer(impl: AudioPlayer): IAudioPlayer
}