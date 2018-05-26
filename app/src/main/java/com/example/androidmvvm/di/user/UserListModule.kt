package com.example.androidmvvm.di.user

import android.arch.lifecycle.ViewModelProviders
import com.example.androidmvvm.data.user.UserApi
import com.example.androidmvvm.data.user.UserRepositoryImpl
import com.example.androidmvvm.domain.user.UserRepository
import com.example.androidmvvm.presentation.user.UserListActivity
import com.example.androidmvvm.presentation.user.UserListViewModel
import dagger.Module
import dagger.Provides
import kotlin.reflect.jvm.internal.impl.javax.inject.Singleton

@Module
class UserListModule(private val userListActivity: UserListActivity) {

    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi): UserRepository = UserRepositoryImpl(userApi)

    @Provides
    fun provideViewModel(userRepository: UserRepository): UserListViewModel {
        return ViewModelProviders
                .of(userListActivity, UserListViewModel.Factory(userRepository))
                .get(UserListViewModel::class.java)
    }
}