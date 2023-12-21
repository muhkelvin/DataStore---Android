package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.datastore.R
import com.example.datastore.data.network.Pokemon.PokemonAPI
import com.example.datastore.data.network.Pokemon.PokemonRetrofitBuilder
import com.example.datastore.data.network.Post.PostApi
import com.example.datastore.data.network.Post.PostBuilder
import com.example.datastore.data.repository.PokemonRepository
import com.example.datastore.data.repository.PostRepository
import com.example.datastore.data.viewmodel.PokemonViewModel
import com.example.datastore.data.viewmodel.PostViewModel
import com.example.datastore.databinding.ActivityPokemon2Binding
import com.example.datastore.databinding.ActivityPokemonBinding
import com.example.datastore.ui.home.adapter.PokemonAdapter
import com.example.datastore.ui.home.adapter.PostAdapter

class PokemonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemon2Binding

    private val adapter: PokemonAdapter by lazy {
        PokemonAdapter()
    }

    private val pokemonApi: PokemonAPI by lazy {
        PokemonRetrofitBuilder.instancePokemon
    }

    private val repository: PokemonRepository by lazy {
        PokemonRepository(pokemonApi)
    }

    private val viewModel: PokemonViewModel by viewModels {
        PokemonViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemon2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur RecyclerView
        binding.rvContent.adapter = adapter

        // Mengamati LiveData dari ViewModel
        viewModel.pokemonLiveData.observe(this, { response ->
            if (response.isSuccessful) {
                val pokemonList = response.body()?.results
                if (pokemonList != null) {
                    // Memperbarui adapter dengan data baru
                    adapter.addAll(pokemonList)
                    Log.e("PokemonActivity", "Berhasil")
                    for (pokemon in pokemonList) {
                        Log.e("PokemonActivity", "Pokemon: ${pokemon.name}")
                    }
                }
            } else {
                // Penanganan jika respons tidak berhasil
                // Anda dapat menambahkan log atau pesan kesalahan sesuai kebutuhan
                Log.e("PokemonActivity", "Gagal mendapatkan data Pokemon")
            }
        })

        // Memanggil fungsi fetchData() di ViewModel untuk mendapatkan data
        viewModel.fetchData()
    }
}
