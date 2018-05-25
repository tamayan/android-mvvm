package com.example.androidmvvm.presentation.user

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.androidmvvm.domain.user.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by tamayan on 2018/03/27.
 *
 */

class UserListViewModel @Inject constructor(
        private val userRepository: UserRepository) : ViewModel(), LifecycleObserver {

    // LiveData
    val adapter = MutableLiveData<UserListAdaptor>()

    val message = MutableLiveData<String>()

    val isExist = MutableLiveData<Boolean>()

    val isDisplay = MutableLiveData<Boolean>()

    private val compositeDisposable = CompositeDisposable()

    init {
        adapter.value = UserListAdaptor()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        userRepository
                .userList
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { isDisplay.value = true }
                .doFinally { isDisplay.value = false }
                .subscribeBy(
                        onSuccess = {
                            isExist.value = it.isNotEmpty()
                            adapter.value?.update(it)
                        },
                        onError = {
                            isExist.value = false
                            message.value = it.message.toString()
                        }
                )
                .addTo(compositeDisposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        // 購読を解除
        compositeDisposable.clear()
    }

    class Factory(private val userRepository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //noinspection unchecked
            return UserListViewModel(userRepository) as T
        }
    }
}