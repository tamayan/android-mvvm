package com.example.androidmvvm.data.user.db

import io.reactivex.Single

interface UserDatabase {

    fun findAll(): Single<List<UserEntity>>

    fun save(userList: List<UserEntity>)
}