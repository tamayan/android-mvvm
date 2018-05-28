package com.example.androidmvvm.data.user.api

import com.squareup.moshi.Json

/**
 * Created by tamayan on 2018/03/27.
 */

data class UserJson(
        val id: Int,
        @Json(name = "first_name") val firstName: String,
        @Json(name = "last_name") val lastName: String,
        val birthdate: String,
        @Json(name = "is_regular") val isRegular: Boolean)