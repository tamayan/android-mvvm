package com.example.androidmvvm.di

import com.example.androidmvvm.presentation.user.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by kitagawayuki on 2018/09/08.
 */

val viewModelModule = module {

    viewModel() { UserListViewModel(get()) }
}