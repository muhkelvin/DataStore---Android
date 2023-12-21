package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking
 *
 * Created by Rizky Fadilah on 02/11/23.
 * https://github.com/rizkyfadilah
 *
 */

// 3.
object PokemonRetrofitBuilder {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val instancePokemon: PokemonAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(PokemonAPI::class.java)
    }

}