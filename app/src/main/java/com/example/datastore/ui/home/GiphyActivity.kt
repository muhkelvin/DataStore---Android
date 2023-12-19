package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.datastore.R
import com.example.datastore.data.network.GiphyApi
import com.example.datastore.data.network.GiphyBuilder
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


    }
}