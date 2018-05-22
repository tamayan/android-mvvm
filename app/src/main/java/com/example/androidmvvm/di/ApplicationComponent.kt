package com.example.androidmvvm.di

import com.example.androidmvvm.data.user.UserApi
import com.example.androidmvvm.di.user.UserListComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by tamayan on 2018/03/27.
 */

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun userListComponent(): UserListComponent

    fun userApi(): UserApi
}