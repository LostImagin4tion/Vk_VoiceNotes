package io.lostImagin4tion.vkVoiceNotes

import android.app.Application
import io.lostImagin4tion.vkVoiceNotes.dagger.AppComponent
import io.lostImagin4tion.vkVoiceNotes.dagger.DaggerAppComponent
import timber.log.Timber

class VkVoiceNotesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        Timber.plant()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}