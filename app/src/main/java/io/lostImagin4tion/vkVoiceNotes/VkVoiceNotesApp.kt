package io.lostImagin4tion.vkVoiceNotes

import android.app.Application
import io.lostImagin4tion.vkVoiceNotes.dagger.AppComponent
import io.lostImagin4tion.vkVoiceNotes.dagger.DaggerAppComponent
import io.lost_imagin4tion.vk_voicenotes.BuildConfig
import timber.log.Timber

class VkVoiceNotesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}