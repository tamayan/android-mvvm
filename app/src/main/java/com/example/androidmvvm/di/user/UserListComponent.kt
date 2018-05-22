package com.example.androidmvvm.di.user

import com.example.androidmvvm.presentation.user.UserListActivity
import dagger.Subcomponent

@Subcomponent(modules = [(UserListModule::class)])
interface UserListComponent {

    fun inject(userListActivity: UserListActivity)
}