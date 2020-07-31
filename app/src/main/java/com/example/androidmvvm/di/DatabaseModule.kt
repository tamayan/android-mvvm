package com.example.androidmvvm.di

import androidx.room.Room
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.data.db.AppDatabase
import com.example.androidmvvm.data.db.UserDatabase
import com.example.androidmvvm.data.db.UserRoomDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by tamayan on 2018/09/08.
 */

val databaseModule = module {

    factory<UserDatabase> { UserRoomDatabase(get(), get()) }

    single { get<AppDatabase>().userDao() }

    single {
        Room
                .databaseBuilder(
                        androidApplication(),
                        AppDatabase::class.java,
                        BuildConfig.ROOM_DATABASE_NAME)
                .build()
    }
}