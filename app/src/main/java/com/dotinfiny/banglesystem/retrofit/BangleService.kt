package com.org.dotinfiny.gamesprime.retrofit

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface BangleService {
    @POST
    fun getResponse(
        @Url url: String,
        @HeaderMap header: Map<String, String>,
        @Body requestBody: RequestBody
    ): Call<String>


}