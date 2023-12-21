package com.example.datastore.data.network.Post

import com.example.datastore.data.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): Response<PostResponse>
}