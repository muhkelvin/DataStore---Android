package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
import com.example.datastore.R
import com.example.datastore.data.network.TMDB.TMDBApi
import com.example.datastore.data.network.TMDB.TMDBRetrofitBuilder
import com.example.datastore.databinding.ActivityTmdbDetailBinding
import com.example.datastore.ui.home.adapter.TMDAdapter
import retrofit2.Response
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.TMDBRepository
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.ui.TMDBViewModel

class TmdbDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTmdbDetailBinding

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
        binding = ActivityTmdbDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra("movieId", 0)

        viewModel.detailDataMovie(movieId).observe(this, Observer { movieData ->
            // Menampilkan data di UI
            val image = movieData?.body()?.posterPath // Ubah ke "posterPath"
            val title = movieData?.body()?.title

            val baseUrlImg = TMDBRetrofitBuilder.BASE_URL_IMG
            val posterPath = image
            val imgUrl = baseUrlImg + posterPath

            binding.tvTitle.text = "Movie Title: $title"

            Glide.with(binding.ivImage).load(imgUrl).into(binding.ivImage)

            // Tambahkan kode untuk menampilkan data lainnya di sini
        })




//        binding.tvOverview.text = intent.getStringExtra("overview")


    }
}