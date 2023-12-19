package com.example.datastore.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.data.repository.Giphyrepository

class GiphyViewModel(repository:Giphyrepository):ViewModel() {

    val getEmoji: LiveData<EmojiResponse> = repository.getEmoji().asLiveData()

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