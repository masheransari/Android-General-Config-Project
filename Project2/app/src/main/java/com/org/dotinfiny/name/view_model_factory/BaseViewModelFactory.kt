package com.dotinfiny.banglesystem.ui.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BaseViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            return LoginViewModel() as T
//        } else if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
//            return SharedViewModel() as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}