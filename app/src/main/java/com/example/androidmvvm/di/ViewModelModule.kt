package com.example.androidmvvm.di

import com.example.androidmvvm.presentation.user.UserListViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

/**
 * Created by kitagawayuki on 2018/09/08.
 */

val viewModelModule = applicationContext {

    viewModel { UserListViewModel(get()) }
}