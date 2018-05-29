package com.example.androidmvvm.domain

/**
 * Created by tamayan on 2018/03/27.
 */

data class User(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val birthdate: String,
        val isRegular: Boolean
)