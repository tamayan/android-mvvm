package com.example.androidmvvm.di.user

import com.example.androidmvvm.data.user.UserApi
import com.example.androidmvvm.data.user.UserRepositoryImpl
import com.example.androidmvvm.domain.user.UserRepository
import com.example.androidmvvm.presentation.user.UserListViewModel
import dagger.Module
import dagger.Provides
import kotlin.reflect.jvm.internal.impl.javax.inject.Singleton

@Module
class UserListModule {

    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi):
            UserRepository = UserRepositoryImpl(userApi)

    @Provides
    fun provideViewModel(userRepository: UserRepository):
            UserListViewModel = UserListViewModel(userRepository)
}