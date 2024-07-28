package com.team1.datamahasiswaapps

import android.app.Application
import com.team1.datamahasiswaapps.di.koinModule
import com.team1.datamahasiswaapps.ui.koinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(koinModule, koinViewModel)
        }
    }
}