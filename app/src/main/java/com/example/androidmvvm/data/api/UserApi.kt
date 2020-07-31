package com.example.androidmvvm.data.api

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by tamayan on 2018/03/27.
 */

interface UserApi {

    @GET(value = "users")
    fun getUserList(): Single<List<UserJson>>
}