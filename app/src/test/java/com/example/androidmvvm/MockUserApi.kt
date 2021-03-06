package com.example.androidmvvm

import com.example.androidmvvm.data.api.UserApi
import com.example.androidmvvm.data.api.UserJson
import io.reactivex.Single
import retrofit2.mock.BehaviorDelegate


class MockUserApi(private val delegate: BehaviorDelegate<UserApi>) : UserApi {

    override fun getUserList(): Single<List<UserJson>> {
        return delegate
                .returningResponse(createList())
                .getUserList()
    }

    private fun createList(): List<UserJson> {
        val user1 = UserJson(
                0,
                "Masayuki",
                "Kuwahara",
                "1993/07/21",
                true)
        return listOf(user1)
    }
}