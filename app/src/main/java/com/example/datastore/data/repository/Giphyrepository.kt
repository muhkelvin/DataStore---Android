package com.example.datastore.data.repository

import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.data.network.Giphy.GiphyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Giphyrepository(private val api: GiphyApi) {
    fun getEmoji(): Flow<Response<EmojiResponse.Data>>{
        return flow {
            emit(api.getEmoji())
        }
    }
}