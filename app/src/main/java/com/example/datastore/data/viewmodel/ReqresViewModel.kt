package com.example.datastore.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.datastore.data.model.PokemonResponse
import com.example.datastore.data.model.ReqresResponse
import com.example.datastore.data.repository.PokemonRepository
import com.example.datastore.data.repository.ReqresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse

class ReqresViewModel(repository: ReqresRepository): ViewModel() {

    val reqresData: LiveData<Response<ReqresResponse>> = repository.getReqres()
        .flowOn(Dispatchers.Main) // Opsional: Menentukan dispatcher untuk operasi jaringan
        .asLiveData()


    class Factory(private val repository: ReqresRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ReqresViewModel::class.java)) {
                return ReqresViewModel(repository) as T
            } else {
                throw IllegalArgumentException("Tidak dapat membuat instance ViewModel yang diminta")
            }
        }
    }
}