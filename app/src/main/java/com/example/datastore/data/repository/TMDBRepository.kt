package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.NetworkResult
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.SafeApiCall
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse
import com.example.datastore.data.network.TMDB.TMDBApi
import retrofit2.Response

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb
 *
 * Created by Rizky Fadilah on 10/11/23.
 * https://github.com/rizkyfadilah
 *
 */

class TMDBRepository(private val api: TMDBApi){
//    fun getMovies(): Flow<NetworkResult<MovieResponse.Results>> {
//        return flow {
//            emit(NetworkResult.Loading())
//            emit(safeApiCall { api.getMovies() })
//        }.flowOn(Dispatchers.IO)
//    }

    fun getMovie():Flow<Response<MovieResponse>> = flow {
     try {
         val response = api.getMovies()
         if (response.isSuccessful) {
             emit(response)
         } else {
             Log.e("TAG", "getMovie: ${response.message()}")
         }
     }catch (e: Exception) {
         Log.e("TAG", "getMovie: ${e.message}")
     }
    }.flowOn(Dispatchers.IO)


    fun getMovieDetail(id: Int): Flow<Response<MovieResponse.Results>> = flow {
        try {
            val response = api.getMovieDetail(id)
            emit(response)
        } catch (e: Exception) {
            Log.e("TAG", "getMovieDetail: ${e.message}")
        }
    }.flowOn(Dispatchers.IO)



}


//    fun getMovieDetail(id: Int): Flow<NetworkResult<MovieResponse.Results>> {
//        return flow {
//            emit(NetworkResult.Loading())
//            emit(safeApiCall { api.getMovieDetail(id = id) })
//        }.flowOn(Dispatchers.IO)
//    }