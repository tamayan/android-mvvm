package com.example.androidmvvm.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.androidmvvm.data.user.db.UserDao
import com.example.androidmvvm.data.user.db.UserEntity


@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}