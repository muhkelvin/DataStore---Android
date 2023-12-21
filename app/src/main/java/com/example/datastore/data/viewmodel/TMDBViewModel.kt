package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.NetworkResult
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.TMDBRepository
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb
 *
 * Created by Rizky Fadilah on 10/11/23.
 * https://github.com/rizkyfadilah
 *
 */

class TMDBViewModel(private val repository: TMDBRepository) : ViewModel() {

    val data: LiveData<NetworkResult<MovieResponse.Results>> get() = repository.getMovies().asLiveData()
    val dataDetail: MutableLiveData<NetworkResult<MovieResponse.Results>> = MutableLiveData()

//    fun getDetail(id: Int) {
//        // cara manggil menggunakan kotlin flow
//        viewModelScope.launch {
//            repository.getMovieDetail(id = id).collect { value ->
//                dataDetail.postValue(value)
//            }
//        }
//    }

    class Factory(private val repository: TMDBRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TMDBViewModel::class.java))
                return TMDBViewModel(repository) as T
            throw RuntimeException("No Viewmodel")
        }
    }
}