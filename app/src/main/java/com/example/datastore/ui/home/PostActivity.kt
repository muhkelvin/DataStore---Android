package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.datastore.R
import com.example.datastore.data.network.Post.PostApi
import com.example.datastore.data.network.Post.PostBuilder
import com.example.datastore.data.repository.PostRepository
import com.example.datastore.data.viewmodel.PostViewModel
import com.example.datastore.databinding.ActivityPostBinding
import com.example.datastore.ui.home.adapter.PostAdapter

class PostActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPostBinding

    private val adapter: PostAdapter by lazy {
        PostAdapter()
    }

    private val postApi:PostApi by lazy {
        PostBuilder.instancePost
    }

    private val repository:PostRepository by lazy {
        PostRepository(postApi)
    }

    private val viewModel:PostViewModel by viewModels {
        PostViewModel.Factory(repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.liveData.observe(this, {

            binding.rvContent.adapter = adapter
        })



    }


}