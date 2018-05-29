package com.example.androidmvvm.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.androidmvvm.data.db.UserDao
import com.example.androidmvvm.data.db.UserEntity


@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}