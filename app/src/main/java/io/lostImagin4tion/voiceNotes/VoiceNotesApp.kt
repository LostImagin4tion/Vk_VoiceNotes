package io.lostImagin4tion.voiceNotes

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import io.lostImagin4tion.voiceNotes.dagger.AppComponent
import io.lostImagin4tion.voiceNotes.dagger.DaggerAppComponent
import timber.log.Timber

class VoiceNotesApp: Application() {

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            // token expired
        }
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        VK.addTokenExpiredHandler(tokenTracker)
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