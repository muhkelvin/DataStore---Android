package com.example.datastore.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.datastore.databinding.ActivityTmdbBinding
import com.example.datastore.ui.home.adapter.TMDBAdapter
import com.google.android.material.snackbar.Snackbar // Import Snackbar di sini
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.LoadingResultHandler
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.NetworkResult
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.TMDBRepository
import com.example.datastore.data.network.TMDB.TMDBRetrofitBuilder
import com.example.datastore.data.network.TMDB.TMDBApi
import com.example.datastore.ui.home.adapter.TMDAdapter
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.ui.TMDBViewModel

class TmdbActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTmdbBinding
    private val adapter: TMDAdapter by lazy {
        TMDAdapter()
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

        // Mengatur RecyclerView
        binding.rvContent.adapter = adapter

        viewModel.data.observe(this) { response ->
            if (response.isSuccessful) {
                val tmdbList = response.body()?.results
                if (tmdbList != null) {
                    // Memperbarui adapter dengan data baru
                    adapter.addAll(tmdbList)
                    Log.e("TmdbActivity", "Berhasil")
                    for (tmdb in tmdbList) {
                        Log.e("MovieActivity", "Movie: ${tmdb.title}")
                    }
                } else {
                    Log.e("TmdbActivity", "Gagal mendapatkan data Tmdb")
                }
            }
        }
    }


}
