package com.example.datastore.data.network.Pokemon

import com.example.datastore.data.model.PokemonDetailResponse
import com.example.datastore.data.model.PokemonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking
 *
 * Created by Rizky Fadilah on 02/11/23.
 * https://github.com/rizkyfadilah
 *
 */

// 2.
interface PokemonAPI {
    @GET("pokemon")
    suspend fun getPokemon(): Response<PokemonResponse>
    @GET("pokemon/bulbasaur")
    fun getPokemonBulbasaur(): Call<PokemonDetailResponse>
}
