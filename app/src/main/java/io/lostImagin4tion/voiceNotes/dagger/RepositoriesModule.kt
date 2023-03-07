package io.lostImagin4tion.voiceNotes.dagger

import dagger.Binds
import dagger.Module
import io.lostImagin4tion.voiceNotes.data.repositories.RecorderAndPlayerRepository
import io.lostImagin4tion.voiceNotes.domain.repositories.IRecorderAndPlayerRepository
import javax.inject.Singleton

@Module
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun bindIAudioRepository(impl: RecorderAndPlayerRepository): IRecorderAndPlayerRepository
}