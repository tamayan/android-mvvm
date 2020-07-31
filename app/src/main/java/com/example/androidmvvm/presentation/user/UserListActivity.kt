package com.example.androidmvvm.presentation.user


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidmvvm.R
import com.example.androidmvvm.databinding.ActivityUserListBinding
import kotlinx.android.synthetic.main.activity_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserListActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val userListViewModel: UserListViewModel by viewModel()

    private val binding: ActivityUserListBinding by lazy {
        DataBindingUtil
                .setContentView<ActivityUserListBinding>(
                        this,
                        R.layout.activity_user_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        swipeRefreshLayout.setOnRefreshListener(this)
        binding.viewModel = userListViewModel
        userListViewModel.isLoading.observe(this, Observer<Boolean> {
            swipeRefreshLayout.isRefreshing = it as Boolean
        })
        userListViewModel.load()
    }

    override fun onRefresh() {
        userListViewModel.load()
    }
}
