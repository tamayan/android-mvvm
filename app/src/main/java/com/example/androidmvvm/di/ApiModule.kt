package com.example.androidmvvm.di

import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.data.api.UserApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.Credentials
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

/**
 * Created by kitagawayuki on 2018/09/08.
 */

val apiModule = module {

    single { get<Retrofit>().create(UserApi::class.java) }
}

val retrofitModule = module {

    single {
        Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(get())
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}

val moshiModule = module {

    single {
        Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }
}

val okHttpModule = module {

    single {
        OkHttpClient
                .Builder()
                .addNetworkInterceptor { chain ->
                    val request = chain
                            .request()
                            .newBuilder()
                            // Basic Authorization
                            .addHeader("Authorization", Credentials.basic(BuildConfig.BASIC_USER_NAME, BuildConfig.BASIC_PASS))
                            .build()
                    chain.proceed(request)
                }
                .connectTimeout(10, SECONDS)
                .writeTimeout(10, SECONDS)
                .readTimeout(10, SECONDS)
                .build()
    }
}