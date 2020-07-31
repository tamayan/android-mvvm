package com.example.androidmvvm.di

import com.example.androidmvvm.data.UserRepositoryImpl
import com.example.androidmvvm.domain.UserRepository
import org.koin.dsl.module

/**
 * Created by kitagawayuki on 2018/09/08.
 */

val repositoryModule = module {

    factory { UserRepositoryImpl(get(), get()) as UserRepository }
}