package com.example.androidmvvm.di

import android.app.Application
import android.arch.persistence.room.Room
import android.util.Base64
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.data.db.AppDatabase
import com.example.androidmvvm.data.api.UserApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


/**
 * Created by tamayan on 2018/03/27.
 */

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room
                .databaseBuilder(
                        application,
                        AppDatabase::class.java,
                        "AppDatabase.db")
                .build()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient
                .Builder()
                .addNetworkInterceptor({ chain ->
                    // ユーザー名とパスワードを連結
                    val basicKey = BuildConfig.BASIC_USER_NAME + ":" + BuildConfig.BASIC_PASS
                    // バイト文字に変換
                    val value = Base64.encodeToString(basicKey.toByteArray(), Base64.NO_WRAP)
                    // Request Header にBasic認証を追加
                    val request = chain.request().newBuilder().addHeader("Authorization", value).build()
                    chain.proceed(request)
                })
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit):
            UserApi = retrofit.create(UserApi::class.java)
}