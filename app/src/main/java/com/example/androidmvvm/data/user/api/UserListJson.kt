package com.example.androidmvvm.data.user.api

import com.squareup.moshi.Json

/**
 * Created by tamayan on 2018/03/27.
 */

data class UserListJson(
        @Json(name = "user_list") val userList: List<UserJson>)