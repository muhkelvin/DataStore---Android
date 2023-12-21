package com.example.datastore.data.repository


import android.util.Log
import com.example.datastore.data.model.PokemonResponse
import com.example.datastore.data.network.Pokemon.PokemonAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response



class PokemonRepository(private val api: PokemonAPI) {
    fun getPokemon(): Flow<Response<PokemonResponse>> = flow {
        try {
            val response = api.getPokemon()

            if (response.isSuccessful) {
                emit(response)
            } else {
                Log.e("TAG", "getPokemon: ${response.message()}")
            }

        } catch (e: Exception) {
            Log.e("TAG", "getPokemon: ${e.message}")
        }
    }
}