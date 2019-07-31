package com.betkey.ui.login

import android.os.Bundle
import com.betkey.R
import com.betkey.base.BaseActivity
import com.betkey.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(LoginFragment.newInstance(), R.id.login_container, LoginFragment.TAG)
    }
}