package com.example.androidmvvm.data.db

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