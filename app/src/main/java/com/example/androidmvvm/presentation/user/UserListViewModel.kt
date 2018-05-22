package com.example.androidmvvm.presentation.user

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.ObservableField
import com.example.androidmvvm.domain.user.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by tamayan on 2018/03/27.
 */

class UserListViewModel @Inject constructor(
        private val userRepository: UserRepository) : LifecycleObserver {

    val adapter = ObservableField<UserListAdaptor>()

    val message = ObservableField<String>()

    val isExist = ObservableField<Boolean>()

    val isDisplay = ObservableField<Boolean>()

    private val compositeDisposable = CompositeDisposable()

    init {
        adapter.set(UserListAdaptor())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        userRepository
                .userList
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { isDisplay.set(true) }
                .doFinally { isDisplay.set(false) }
                .subscribeBy(
                        onSuccess = {
                            isExist.set(it.isNotEmpty())
                            adapter.get()?.update(it)
                        },
                        onError = {
                            isExist.set(false)
                            message.set(it.message.toString())
                        }
                )
                .addTo(compositeDisposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        // 購読を解除
        compositeDisposable.clear()
    }
}