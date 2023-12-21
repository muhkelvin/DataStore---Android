package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.datastore.databinding.ActivityTmdbBinding
import com.example.datastore.ui.home.adapter.TMDBAdapter
import com.google.android.material.snackbar.Snackbar // Import Snackbar di sini
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.LoadingResultHandler
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.NetworkResult
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.TMDBRepository
import com.example.datastore.data.network.TMDB.TMDBRetrofitBuilder
import com.example.datastore.data.network.TMDB.TMDBApi
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.ui.TMDBViewModel

class TmdbActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTmdbBinding
    private val adapter: TMDBAdapter by lazy {
        TMDBAdapter()
    }

    private val TmdbApi: TMDBApi by lazy {
        TMDBRetrofitBuilder.instanceTMDB
    }

    private val repository: TMDBRepository by lazy {
        TMDBRepository(TmdbApi)
    }

    private val viewModel: TMDBViewModel by viewModels {
        TMDBViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContent.adapter = adapter

        viewModel.data.observe(this) { result ->
            when (result) {
                is NetworkResult.Success -> {
                    Log.d("GIPHY", result.toString())

                    result.data.let {
//                        adapter.updateView(it.apply { LoadingResultHandler.Content(it) })
                    }
                }



                is NetworkResult.Loading -> {
                    Log.v("GIPHY", result.toString())

                    adapter.updateLoading(listOf(LoadingResultHandler.Loading()))
                }

                is NetworkResult.Error -> {
                    Log.e("GIPHY", result.message.orEmpty())

                    Snackbar.make(
                        binding.root,
                        result.message.orEmpty(),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}