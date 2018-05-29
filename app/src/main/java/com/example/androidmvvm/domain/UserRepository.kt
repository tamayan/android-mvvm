package com.example.androidmvvm.domain

import io.reactivex.Single

/**
 * Created by tamayan on 2018/03/27.
 */

interface UserRepository {

    fun fetch(): Single<List<User>>
}