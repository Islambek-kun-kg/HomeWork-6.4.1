package com.example.lesson641

import android.app.Application
import com.example.lesson641.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YouTubeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@YouTubeApp)
            modules(KoinModules)
        }
    }
}