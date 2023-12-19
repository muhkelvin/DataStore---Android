package com.example.datastore.data.network

import com.example.datastore.data.model.EmojiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("emoji")
    suspend fun getEmoji(
        @Query("api_key") apiKey: String = GiphyBuilder.API_KEY,
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0,
    ): EmojiResponse

    @GET("emoji")
    suspend fun getEmojiesSafe(
        @Query("api_key") apiKey: String = GiphyBuilder.API_KEY,
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0,
    ): Response<EmojiResponse>

}