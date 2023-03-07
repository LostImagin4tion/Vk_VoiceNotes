package io.lostImagin4tion.voiceNotes.dagger

import dagger.Binds
import dagger.Module
import io.lostImagin4tion.voiceNotes.data.repositories.AudioRepository
import io.lostImagin4tion.voiceNotes.domain.repositories.IAudioRepository
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindIAudioRepository(impl: AudioRepository): IAudioRepository
}