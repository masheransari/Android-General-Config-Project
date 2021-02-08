package com.dotinfiny.banglesystem.intent_helper

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dotinfiny.banglesystem.ui.view_model_factory.BaseViewModelFactory

inline fun <reified T : ViewModel> Fragment.getViewModel(
    noinline creator: (() -> T)? = null
): T {
    return if (creator == null) {
        ViewModelProvider(this).get(T::class.java)
    } else {
        ViewModelProvider(this, BaseViewModelFactory()).get(T::class.java)
    }
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) {
        ViewModelProvider(this).get(T::class.java)
    } else {
        ViewModelProvider(this, BaseViewModelFactory()).get(T::class.java)
    }
}