package com.dotinfiny.banglesystem.ui.view_model_factory

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dotinfiny.banglesystem.model.local.LiveResultModel
import com.dotinfiny.banglesystem.repository.DatabaseRepository
import com.org.dotinfiny.gamesprime.data.AppRepository
import com.org.dotinfiny.gamesprime.model.api.ResultModel

open class BaseViewModel(val context: Context) : ViewModel() {

    private var appRepository: AppRepository
        get() = appRepository

    private var response: MutableLiveData<LiveResultModel> = MutableLiveData<LiveResultModel>()
    var dbRepository: DatabaseRepository
        get() = dbRepository

    init {
        appRepository = AppRepository(context)
        dbRepository = DatabaseRepository(context)
    }

    fun getViewModelResponse(): LiveData<LiveResultModel> {
        return response
    }

    fun getApiResult(): LiveData<ResultModel> {
        return appRepository.resultData
    }


    fun initFunction() {
        Toast.makeText(context, "testing Content", Toast.LENGTH_SHORT).show()
    }


}