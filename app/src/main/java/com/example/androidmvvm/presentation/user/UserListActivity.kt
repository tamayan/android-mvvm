package com.example.androidmvvm.presentation.user

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androidmvvm.R
import com.example.androidmvvm.databinding.ActivityUserListBinding
import com.example.androidmvvm.di.user.UserListModule
import com.example.androidmvvm.presentation.myApplication
import javax.inject.Inject

class UserListActivity : AppCompatActivity() {

    /**
     * ViewModel
     */
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
                .userListComponent(UserListModule(this))
                .inject(this)
    }

    private fun setUp() {
        // Handling Lifecycles
        lifecycle.addObserver(viewModel)

        // DataBinding
        val binding = DataBindingUtil.setContentView<ActivityUserListBinding>(this, R.layout.activity_user_list)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }
}
