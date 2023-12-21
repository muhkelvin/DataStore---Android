package com.example.datastore.data.repository

import com.example.datastore.data.model.PostResponse
import com.example.datastore.data.network.Post.PostApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PostRepository(private val api:PostApi) {

    fun getPost(): Flow<Response<PostResponse>>{
    return flow {
        emit(api.getPosts())
    }

    }
}