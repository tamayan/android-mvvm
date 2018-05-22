package com.example.androidmvvm.data.user

import com.example.androidmvvm.domain.user.User
import com.example.androidmvvm.domain.user.UserRepository
import io.reactivex.Single

/**
 * Created by tamayan on 2018/03/27.
 */

class UserRepositoryImpl(userApi: UserApi) : UserRepository {

    override val userList: Single<List<User>> =
            userApi.getUserList()
                    .map { userListJson ->
                        userListJson.userList.map { userJson ->
                            User(
                                    userJson.id,
                                    userJson.firstName,
                                    userJson.lastName,
                                    userJson.age,
                                    userJson.birthdate,
                                    userJson.isRegular)
                        }
                    }
}