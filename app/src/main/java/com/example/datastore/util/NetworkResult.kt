package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util
 *
 * Created by Rizky Fadilah on 06/11/23.
 * https://github.com/rizkyfadilah
 *
 */

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : NetworkResult<T>(data = data)
    class Loading<T>() : NetworkResult<T>()
    class Error<T>(data: T? = null, message: String?) :
        NetworkResult<T>(data = null, message = message)
}
