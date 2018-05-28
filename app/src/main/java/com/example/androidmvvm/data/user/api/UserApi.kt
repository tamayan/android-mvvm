package com.example.androidmvvm.data.user.api

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by tamayan on 2018/03/27.
 */

interface UserApi {

    @GET("user-list.json")
    fun getUserList(): Single<UserListJson>
}