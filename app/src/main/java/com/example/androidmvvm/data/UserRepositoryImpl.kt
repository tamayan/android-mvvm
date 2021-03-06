package com.example.androidmvvm.data

import com.example.androidmvvm.data.api.UserApi
import com.example.androidmvvm.data.db.UserDatabase
import com.example.androidmvvm.data.db.UserEntity
import com.example.androidmvvm.domain.User
import com.example.androidmvvm.domain.UserRepository
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by tamayan on 2018/03/27.
 */

class UserRepositoryImpl(
        private val userApi: UserApi,
        private val userDatabase: UserDatabase) : UserRepository {

    override fun fetch(): Single<List<User>> {
        // 成功：APIから取得→DBに保存→DBから取り出す
        // 失敗：DBから取り出す
        return userApi
                .getUserList()
                .flatMapObservable { Observable.fromIterable(it) }
                .map { User(it.id, it.firstName, it.lastName, it.birthdate, it.isRegular) }
                .toList()
                .onErrorResumeNext {
                    userDatabase
                            .findAll()
                            .flatMapObservable { Observable.fromIterable(it) }
                            .map { User(it.id, it.firstName, it.lastName, it.birthdate, it.isRegular) }
                            .toList()
                }
                .doOnSuccess { userDatabase.save(it.map { UserEntity(it.id, it.firstName, it.lastName, it.birthdate, it.isRegular) }) }
                .ignoreElement()
                .andThen(userDatabase.findAll())
                .flatMapObservable { Observable.fromIterable(it) }
                .map { User(it.id, it.firstName, it.lastName, it.birthdate, it.isRegular) }
                .toList()
    }
}