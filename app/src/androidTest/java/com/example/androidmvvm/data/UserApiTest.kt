package com.example.androidmvvm.data

import android.support.test.runner.AndroidJUnit4
import com.example.androidmvvm.BuildConfig
import com.example.androidmvvm.data.api.UserApi
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import junit.framework.TestCase
import okhttp3.OkHttpClient
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

@RunWith(AndroidJUnit4::class)
class UserApiTest : TestCase() {

    @Test
    fun getUserTest() {
        val delegate = buildMockRetrofit().create(UserApi::class.java)
        MockUserApi(delegate)
                .getUserList()
                .flatMapObservable { Observable.fromIterable(it.userList) }
                .filter { it.id == 0 }
                .test()
                .assertNoErrors()
                .assertValue {
                    assertThat(it.firstName, `is`("Masayuki"))
                        true
                }
    }

    private fun buildMockRetrofit(): MockRetrofit {
        return MockRetrofit
                .Builder(buildRetrofit())
                .networkBehavior(NetworkBehavior.create())
                .build()
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(MoshiConverterFactory.create(buildMoshi()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
    }

    private fun buildMoshi(): Moshi {
        return Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }
}