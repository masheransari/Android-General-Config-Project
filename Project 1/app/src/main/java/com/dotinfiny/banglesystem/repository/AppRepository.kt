package com.org.dotinfiny.gamesprime.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.dotinfiny.banglesystem.Utils.Constants
import com.dotinfiny.banglesystem.retrofit.AppUtil
import com.dotinfiny.banglesystem.retrofit.RetrofitBaseCallBack
import com.google.gson.Gson
import com.org.dotinfiny.gamesprime.helpers.KotlinHelper
import com.org.dotinfiny.gamesprime.helpers.RequestID
import com.org.dotinfiny.gamesprime.model.api.ResultModel
import com.org.dotinfiny.gamesprime.retrofit.BangleService
import com.orhanobut.hawk.Hawk
import org.json.JSONException
import org.json.JSONObject

class AppRepository(val ctx: Context) {


    //private var loggedInUser: LoginSignupResponse? = null
    private val mService: BangleService
    private val hm = java.util.HashMap<String, String>()
    var resultData: MutableLiveData<ResultModel> = MutableLiveData()
    private var gson = Gson()

    init {

        Hawk.init(ctx).build()

//        if (Hawk.get<LoginSignupResponse>("loginResponse") != null) {
//            loggedInUser = Hawk.get<LoginSignupResponse>("loginResponse")
//            hm["Authorization"] = loggedInUser?.token.toString()
//        }


        hm["Content-Type"] = "application/json"
        hm["Authorization"] = Hawk.get(
            Constants.PREF_USER_TOKEN,
            ""
        )
        mService = AppUtil.getBangleService() as BangleService
    }

    fun createRequest(
        requestObject: JSONObject,
        requestID: RequestID
    ) {

        mService.getResponse(
            getEndoint(requestID),
            hm,
            KotlinHelper.getRequestBody(requestObject.toString())
        )
            .enqueue(object : RetrofitBaseCallBack<String>() {
                override fun onResponse(response: String?, error: Error?) {

                    if (error == null) {
                        try {
                            val jsonObject = JSONObject(response.toString())
                            val status = jsonObject.getString("status")

                            if (status == "OK") {

                                val resultObject = jsonObject.getJSONObject("result")
                                val success: Boolean = resultObject.getBoolean("success")

                                if (success) {

                                    when (requestID) {
                                        RequestID.REQ_API -> {
                                        }

                                    }

                                } else {
                                    val result = gson.fromJson<ResultModel>(
                                        resultObject.toString(),
                                        ResultModel::class.java
                                    )
                                    result.apiType = requestID
                                    resultData.value = result
//                                    errorMessage?.value = resultObject.getString("message")
                                }
                            }

                        } catch (ex: JSONException) {
                            resultData?.value = getCustomErrorResponse(requestID)
                            ex.printStackTrace()
                        }

                    } else {
                        resultData?.value = getCustomErrorResponse(requestID)
                    }
                }
            })
    }

    fun getCustomErrorResponse(requestID: RequestID): ResultModel {
        var result = ResultModel(
            false,
            "Something went wrong\n Please check your internet connection",
            requestID
        )
        return result
    }

    fun getEndoint(requestID: RequestID): String {

        var URL = ""
        URL = when (requestID) {
            RequestID.REQ_API -> Constants.API_TEST
        }
        return URL
    }
}

