package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util

import retrofit2.Response

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util
 *
 * Created by Rizky Fadilah on 06/11/23.
 * https://github.com/rizkyfadilah
 *
 */

abstract class SafeApiCall {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response: Response<T> = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    /*return it*/
                    return NetworkResult.Success(data = it)
                }
            }
            /*throw Exception("Error Endpoint")*/
            return error(errorMessage = "${response.code()} : ${response.message()}")
        } catch (e: Exception) {
            /*throw e*/
            return error(errorMessage = e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> {
        return NetworkResult.Error(message = errorMessage)
    }
}