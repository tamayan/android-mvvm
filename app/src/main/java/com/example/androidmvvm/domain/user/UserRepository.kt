package com.example.androidmvvm.domain.user

import io.reactivex.Single

/**
 * Created by tamayan on 2018/03/27.
 */

interface UserRepository {

    val userList: Single<List<User>>
}