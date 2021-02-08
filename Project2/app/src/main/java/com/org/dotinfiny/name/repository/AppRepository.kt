package com.org.dotinfiny.gamesprime.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.dotinfiny.gamesprime.helpers.RequestID
import com.org.dotinfiny.gamesprime.model.api.ResultModel
import com.org.dotinfiny.gamesprime.retrofit.BangleService
import com.org.dotinfiny.name.retrofit.AppUtil
import com.org.dotinfiny.name.retrofit.RetrofitBaseCallBack
import com.orhanobut.hawk.Hawk
import java.lang.reflect.Type

class AppRepository(ctx: Context) {

    private val mService: BangleService
    var resultData: MutableLiveData<ResultModel> = MutableLiveData()
    private var gson = Gson()

    init {

        Hawk.init(ctx).build()

//        if (Hawk.get<LoginSignupResponse>("loginResponse") != null) {
//            loggedInUser = Hawk.get<LoginSignupResponse>("loginResponse")
//            hm["Authorization"] = loggedInUser?.token.toString()
//        }


        mService = AppUtil.getBangleService() as BangleService
    }

    suspend fun getData(ids: String?) {
        mService.getData("data/" + ids).enqueue(object : RetrofitBaseCallBack<String>() {
            override fun onResponse(response: String?, error: Error?) {
                if (error == null) {

                } else {
                }
            }
        })
    }

    fun createPostRequest(requestID: RequestID, id: String?) {
        mService.getPost(
            getEndoint(requestID, id!!)
        ).enqueue(object : RetrofitBaseCallBack<String>() {
            override fun onResponse(response: String?, error: Error?) {
                if (error == null) {
                    when (requestID) {
                        //Fetch code here
                    }
                } else {
                    resultData.value = getCustomErrorResponse(requestID)
                }
            }
        })
    }

    fun getCustomErrorResponse(requestID: RequestID): ResultModel {
        var result = ResultModel(
            false,
            "Something went wrong\n Please check your internet connection",
            null,
            null,
            requestID
        )
        return result
    }

    fun getEndoint(requestID: RequestID, id: String): String {

        var URL = ""
//        URL = when (requestID) {
//            RequestID.REQ_POST -> Constants.API_POST
//            RequestID.REQ_COMMENT -> Constants.API_COMMENT.replace("{post_id}", id)
//        }
        return URL
    }
}

