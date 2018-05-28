package com.example.androidmvvm.di

import com.example.androidmvvm.data.AppDatabase
import com.example.androidmvvm.data.user.api.UserApi
import com.example.androidmvvm.di.user.UserListComponent
import com.example.androidmvvm.di.user.UserListModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by tamayan on 2018/03/27.
 */

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun userListComponent(userListModule: UserListModule): UserListComponent

    fun appDatabase(): AppDatabase

    fun userApi(): UserApi
}