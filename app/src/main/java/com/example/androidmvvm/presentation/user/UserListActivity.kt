package com.example.androidmvvm.presentation.user

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import com.example.androidmvvm.R
import com.example.androidmvvm.databinding.ActivityUserListBinding
import kotlinx.android.synthetic.main.activity_user_list.*
import org.koin.android.architecture.ext.viewModel

class UserListActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val userListViewModel: UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        setUpDataBinding()
        setUpViewModel()
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        userListViewModel.load()
    }

    private fun setUpDataBinding() {
        val binding: ActivityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        binding.viewModel = userListViewModel
    }

    private fun setUpViewModel() {
        userListViewModel.isLoading.observe(this, Observer<Boolean> {
            swipeRefreshLayout.isRefreshing = it as Boolean
        })
        userListViewModel.load()
    }
}
