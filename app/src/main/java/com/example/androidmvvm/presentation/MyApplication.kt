package com.example.androidmvvm.presentation

import android.app.Application
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.di.apiModule
import com.example.androidmvvm.di.databaseModule
import com.example.androidmvvm.di.moshiModule
import com.example.androidmvvm.di.okHttpModule
import com.example.androidmvvm.di.repositoryModule
import com.example.androidmvvm.di.retrofitModule
import com.example.androidmvvm.di.viewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Timber.plant(DebugTree())

        startKoin(this, listOf(
                retrofitModule,
                moshiModule,
                okHttpModule,
                apiModule,
                databaseModule,
                repositoryModule,
                viewModelModule)
        )
    }
}