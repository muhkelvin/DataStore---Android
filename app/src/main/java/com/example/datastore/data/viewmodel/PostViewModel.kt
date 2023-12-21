package com.example.datastore.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.datastore.data.model.PostResponse
import com.example.datastore.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.TMDBRepository
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.ui.TMDBViewModel

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val liveData: LiveData<Response<PostResponse>> = repository.getPost().asLiveData()

    class Factory(private val repository: PostRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
                return PostViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        }
    }

