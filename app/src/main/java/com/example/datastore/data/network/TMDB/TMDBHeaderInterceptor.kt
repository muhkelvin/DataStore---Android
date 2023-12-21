package com.example.datastore.data.network.TMDB

import okhttp3.Interceptor
import okhttp3.Response

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data
 *
 * Created by Rizky Fadilah on 10/11/23.
 * https://github.com/rizkyfadilah
 *
 */

class TMDBHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Bearer ${TMDBRetrofitBuilder.ACCESS_TOKEN}")
            .addHeader("accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}
