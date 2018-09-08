package com.example.androidmvvm.presentation.user

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.androidmvvm.domain.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tamayan on 2018/03/27.
 *
 */

class UserListViewModel(private val userRepository: UserRepository) : ViewModel() {

    val adapter = MutableLiveData<UserListAdaptor>()

    val isLoading = MediatorLiveData<Boolean>()

    private val compositeDisposable = CompositeDisposable()

    init {
        adapter.value = UserListAdaptor()
    }

    fun load() {
        userRepository
                .fetch()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { isLoading.value = true }
                .doFinally { isLoading.value = false }
                .subscribeBy(
                        onSuccess = {
                            adapter.value?.update(it)
                        },
                        onError = {
                            it.printStackTrace()
                        }
                )
                .addTo(compositeDisposable)
    }
}