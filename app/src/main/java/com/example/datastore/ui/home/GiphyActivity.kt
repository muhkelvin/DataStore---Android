package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.datastore.data.network.Giphy.GiphyApi
import com.example.datastore.data.network.Giphy.GiphyBuilder
import com.example.datastore.data.repository.Giphyrepository
import com.example.datastore.data.viewmodel.GiphyViewModel
import com.example.datastore.databinding.ActivityGiphyBinding
import com.example.datastore.ui.home.adapter.GiphyAdapter

class GiphyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGiphyBinding

    private val adapter: GiphyAdapter by lazy {
        GiphyAdapter()
    }

    private val giphyAPI: GiphyApi by lazy {
        GiphyBuilder.instanceGihpy
    }

    private val repository: Giphyrepository by lazy {
        Giphyrepository(giphyAPI)
    }

    private val viewModel: GiphyViewModel by viewModels {
        GiphyViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiphyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
//        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.rvContent.adapter = adapter
    }

//    private fun observeViewModel() {
//        viewModel.getEmoji.observe(this, { emojiList ->
//            // Update adapter data when LiveData changes
//            adapter.se(emojiList)
//        })
//
//        viewModel.error.observe(this, { error ->
//            // Handle error if needed
//        })
//    }
}
