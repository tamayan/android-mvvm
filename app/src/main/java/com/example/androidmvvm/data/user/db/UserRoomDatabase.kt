package com.example.androidmvvm.data.user.db

import com.example.androidmvvm.data.AppDatabase
import io.reactivex.Single

class UserRoomDatabase(private val appDatabase: AppDatabase,
                       private val userDao: UserDao) : UserDatabase {

    override fun findAll(): Single<List<UserEntity>> = userDao.findAll()

    override fun save(userList: List<UserEntity>) {
        appDatabase.runInTransaction {
            userDao.deleteAndInsert(userList)
        }
    }
}