package com.example.androidmvvm.presentation.user

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidmvvm.R
import com.example.androidmvvm.databinding.ActivityUserListBinding
import com.example.androidmvvm.presentation.myApplication
import javax.inject.Inject

class UserListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        inject()
        setUp()
    }

    private fun inject() {
        myApplication
                .applicationComponent
                .userListComponent()
                .inject(this)
    }

    private fun setUp() {
        val binding = DataBindingUtil.setContentView<ActivityUserListBinding>(this, R.layout.activity_user_list)
        binding.viewModel = viewModel
        lifecycle.addObserver(viewModel)
    }
}
