package com.example.androidmvvm.di.user

import android.arch.lifecycle.ViewModelProviders
import com.example.androidmvvm.data.UserRepositoryImpl
import com.example.androidmvvm.data.api.UserApi
import com.example.androidmvvm.data.db.AppDatabase
import com.example.androidmvvm.data.db.UserDatabase
import com.example.androidmvvm.data.db.UserRoomDatabase
import com.example.androidmvvm.domain.UserRepository
import com.example.androidmvvm.presentation.user.UserListActivity
import com.example.androidmvvm.presentation.user.UserListViewModel
import dagger.Module
import dagger.Provides

@Module
class UserListModule(private val userListActivity: UserListActivity) {

    @Provides
    fun provideUserDatabase(appDatabase: AppDatabase): UserDatabase =
            UserRoomDatabase(appDatabase, appDatabase.userDao())

    @Provides
    fun provideUserRepository(userApi: UserApi, userDatabase: UserDatabase): UserRepository =
            UserRepositoryImpl(userApi, userDatabase)

    @Provides
    fun provideViewModel(userRepository: UserRepository): UserListViewModel {
        return ViewModelProviders
                .of(userListActivity, UserListViewModel.Factory(userRepository))
                .get(UserListViewModel::class.java)
    }
}