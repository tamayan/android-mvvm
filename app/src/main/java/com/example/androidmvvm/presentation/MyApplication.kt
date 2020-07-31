package com.example.androidmvvm.presentation

import android.app.Application
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(DebugTree())

        startKoin {
            androidContext(this@MyApplication)
            listOf(
                    retrofitModule,
                    moshiModule,
                    okHttpModule,
                    apiModule,
                    databaseModule,
                    repositoryModule,
                    viewModelModule
            )
        }
    }
}