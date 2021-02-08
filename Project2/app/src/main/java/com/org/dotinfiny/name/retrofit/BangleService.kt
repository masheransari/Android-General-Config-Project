package com.org.dotinfiny.gamesprime.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface BangleService {

    @GET
    fun getPost(
        @Url url: String
    ): Call<String>

    @GET()
    suspend fun getData(@Url url: String): Call<String>

}