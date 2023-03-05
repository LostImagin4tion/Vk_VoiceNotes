package io.lostImagin4tion.vkVoiceNotes.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.lostImagin4tion.vkVoiceNotes.ui.screens.notesFeed.NotesFeedViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoriesModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(notesFeedViewModel: NotesFeedViewModel)
}