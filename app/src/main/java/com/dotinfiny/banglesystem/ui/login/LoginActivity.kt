package com.dotinfiny.banglesystem.ui.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dotinfiny.banglesystem.R
import com.dotinfiny.banglesystem.app.BaseActivity
import com.dotinfiny.banglesystem.databinding.ActivityLoginBinding
import com.dotinfiny.banglesystem.ui.view_model_factory.BaseViewModelFactory

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val baseFactory = BaseViewModelFactory(this);
        viewModel = ViewModelProvider(this, baseFactory).get(LoginViewModel::class.java)
        viewModel.initFunction()
    }
}