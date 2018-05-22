package com.example.androidmvvm.presentation

import android.app.Activity
import android.app.Application
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.di.ApplicationComponent
import com.example.androidmvvm.di.ApplicationModule
import com.example.androidmvvm.di.DaggerApplicationComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(DebugTree())
    }
}

val Activity.myApplication get() = application as MyApplication