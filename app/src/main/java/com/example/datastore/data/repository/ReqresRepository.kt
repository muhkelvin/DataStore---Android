package com.example.datastore.data.repository

import android.util.Log
import com.example.datastore.data.model.ReqresResponse
import com.example.datastore.data.network.Reqres.ReqresApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class ReqresRepository(private val api:ReqresApi) {

    fun getReqres(): Flow<Response<ReqresResponse>> = flow {
        try {
            val response = api.getUsers(1) // Menggunakan halaman 1

            if (response.isSuccessful) {
                emit(response)
            } else {
                Log.e("TAG", "getReqres: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("TAG", "getReqres: ${e.message}")
        }
    }


}