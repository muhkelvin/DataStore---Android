package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.NetworkResult
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.SafeApiCall
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse
import com.example.datastore.data.network.TMDB.TMDBApi

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb
 *
 * Created by Rizky Fadilah on 10/11/23.
 * https://github.com/rizkyfadilah
 *
 */

class TMDBRepository(private val api: TMDBApi) : SafeApiCall() {
    fun getMovies(): Flow<NetworkResult<MovieResponse.Results>> {
        return flow {
            emit(NetworkResult.Loading())
            emit(safeApiCall { api.getMovies() })
        }.flowOn(Dispatchers.IO)
    }


//    fun getMovieDetail(id: Int): Flow<NetworkResult<MovieResponse.Results>> {
//        return flow {
//            emit(NetworkResult.Loading())
//            emit(safeApiCall { api.getMovieDetail(id = id) })
//        }.flowOn(Dispatchers.IO)
//    }
}