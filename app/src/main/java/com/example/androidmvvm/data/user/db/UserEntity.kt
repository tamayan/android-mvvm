package com.example.androidmvvm.data.user.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

        @PrimaryKey
        val id: Int,

        @ColumnInfo(name = "first_name")
        val firstName: String,

        @ColumnInfo(name = "last_name")
        val lastName: String,

        val birthdate: String,

        @ColumnInfo(name = "is_regular")
        val isRegular: Boolean
)