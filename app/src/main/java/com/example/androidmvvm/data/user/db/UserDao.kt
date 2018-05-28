package com.example.androidmvvm.data.user.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
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