package com.example.datastore.data.repository

import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.data.network.GiphyApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Giphyrepository(private val api: GiphyApi) {
    fun getEmoji(): Flow<EmojiResponse>{
        return flow {
            emit(api.getEmoji())
        }
    }
}