package com.example.androidmvvm.data.user.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun findAll(): List<UserEntity>
}