package com.example.datastore.data.network.Reqres

import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.data.model.ReqresResponse
import com.example.datastore.data.network.Giphy.GiphyBuilder
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi {

    @GET("api/users")
    suspend fun getUsers(@Query("page") page: Int): Response<ReqresResponse>
}