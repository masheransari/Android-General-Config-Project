package com.org.dotinfiny.gamesprime.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.org.dotinfiny.gamesprime.helpers.RequestID

data class ResultModel(

    @Expose
    @SerializedName("success")
    val success: Boolean,

    @Expose
    @SerializedName("message")
    val message: String,


    var apiType: RequestID


)