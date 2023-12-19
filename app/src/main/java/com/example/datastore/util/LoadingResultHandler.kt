package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util
 *
 * Created by Rizky Fadilah on 06/11/23.
 * https://github.com/rizkyfadilah
 *
 */

sealed class LoadingResultHandler<T>(
    val data: T? = null
) {
    class Loading<T> : LoadingResultHandler<T>()
    class Content<T>(data: T?) : LoadingResultHandler<T>(data = data)
}
