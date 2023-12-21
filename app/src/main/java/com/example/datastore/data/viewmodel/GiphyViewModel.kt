package com.example.datastore.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.data.repository.Giphyrepository
import kotlinx.coroutines.launch
import retrofit2.Response

class GiphyViewModel(repository:Giphyrepository):ViewModel() {

    val getEmoji: LiveData<Response<EmojiResponse.Data>> = repository.getEmoji().asLiveData()


//    fun fetchEmoji() {
//        viewModelScope
//            .launch {
//            try {
//                val response = repository.getEmoji()
//                if (response.isSuccessful) {
//                    val emojiList = response.body()?.data
//                    Log.d("GiphyViewModel", "Response: $emojiList")
//                    // Lakukan sesuatu dengan emojiList, seperti mengirimkannya ke LiveData
//                } else {
//                    Log.e("GiphyViewModel", "Error: ${response.code()} - ${response.message()}")
//                }
//            } catch (e: Exception) {
//                Log.e("GiphyViewModel", "Exception: ${e.message}")
//            }
//        }
//    }

    class Factory(private val repository: Giphyrepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GiphyViewModel::class.java)) {
                return GiphyViewModel(repository) as T
            } else {
                throw RuntimeException("No Assignable ViewModel")
            }
        }
    }
}