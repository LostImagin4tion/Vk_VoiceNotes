package io.lostImagin4tion.voiceNotes

import android.app.Application
import io.lostImagin4tion.voiceNotes.dagger.AppComponent
import io.lostImagin4tion.voiceNotes.dagger.DaggerAppComponent
import io.lost_imagin4tion.vk_voicenotes.BuildConfig
import timber.log.Timber

class VoiceNotesApp: Application() {

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