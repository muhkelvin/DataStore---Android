package com.example.datastore.data.network.TMDB

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object TMDBRetrofitBuilder {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMG = "https://image.tmdb.org/t/p/w500"
    const val ACCESS_TOKEN =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MmU4ZmIwNTI3MzU0NGFlMTdjY2ZmMTRkOTk4ZDUzNSIsInN1YiI6IjY1NGUyMTQxNDFhNTYxMzM2YzVmYzhmNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.y-e1UReMT5_FUTVtvtffoITMGz0og-si0FHxzz1XMLE"


    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val headerInterceptor get() = TMDBHeaderInterceptor()

    private val client = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(logging)
        .build()

    val instanceTMDB: TMDBApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(TMDBApi::class.java)
    }

}

/*
Bagaimana cara kalian meng-handle Header pada API

Ketik 1: Kalau pakai interceptor, best practice
Ketik 2: Kalau pakai dari interface API, boleh lah di ketahui
Ketik 3: Belum pakai??

*/
