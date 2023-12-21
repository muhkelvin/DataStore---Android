package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

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
    fun getPokemon(): Call<PokemonResponse>
    @GET("pokemon/bulbasaur")
    fun getPokemonBulbasaur(): Call<PokemonDetailResponse>
}
