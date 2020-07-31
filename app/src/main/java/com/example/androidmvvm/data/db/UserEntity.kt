package com.example.androidmvvm.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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