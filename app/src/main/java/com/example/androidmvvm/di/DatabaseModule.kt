package com.example.androidmvvm.di

import android.arch.persistence.room.Room
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.data.db.AppDatabase
import com.example.androidmvvm.data.db.UserDatabase
import com.example.androidmvvm.data.db.UserRoomDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

/**
 * Created by tamayan on 2018/09/08.
 */

val databaseModule = applicationContext {

    bean { UserRoomDatabase(get(), get()) as UserDatabase }

    bean { get<AppDatabase>().userDao() }

    bean {
        Room
                .databaseBuilder(
                        androidApplication(),
                        AppDatabase::class.java,
                        BuildConfig.ROOM_DATABASE_NAME)
                .build()
    }
}