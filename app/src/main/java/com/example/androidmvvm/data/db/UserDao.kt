package com.example.androidmvvm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Single

@Dao
abstract class UserDao {

    @Query("SELECT * FROM user")
    abstract fun findAll(): Single<List<UserEntity>>

    @Insert
    abstract fun insert(userList: List<UserEntity>)

    @Query("DELETE FROM user")
    abstract fun delete()

    @Transaction
    open fun deleteAndInsert(userEntityList: List<UserEntity>) {
        delete()
        insert(userEntityList)
    }
}