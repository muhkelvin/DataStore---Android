package com.example.datastore.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import android.util.Log
import com.example.datastore.data.model.PokemonResponse
import com.example.datastore.data.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    // LiveData untuk data Pokemon
    val pokemonLiveData: LiveData<Response<PokemonResponse>> = repository.getPokemon().asLiveData()

    // LiveData untuk menangani kesalahan
    val errorLiveData: LiveData<String> get() = _errorLiveData
    private val _errorLiveData = MutableLiveData<String>()

    // Fungsi untuk mengambil data Pokemon
//    fun fetchData() {
//        viewModelScope.launch {
//            try {
//                // Panggil fungsi repository di sini
//                val response = repository.getPokemon()
//                // Lakukan sesuatu dengan respons jika perlu
//            } catch (e: Exception) {
//                Log.e("PokemonViewModel", "Terjadi kesalahan: ${e.message}")
//                _errorLiveData.value = "Terjadi kesalahan saat mengambil data Pokemon"
//            }
//        }
//    }

    // Factory untuk ViewModel
    class Factory(private val repository: PokemonRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
                return PokemonViewModel(repository) as T
            } else {
                throw IllegalArgumentException("Tidak dapat membuat instance ViewModel yang diminta")
            }
        }
    }
}
