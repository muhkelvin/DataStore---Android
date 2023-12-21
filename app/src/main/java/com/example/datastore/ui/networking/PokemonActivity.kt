package com.example.datastore.ui.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datastore.R
import com.example.datastore.databinding.ActivityPokemonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking.PokemonDetailResponse
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking.PokemonResponse
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking.PokemonRetrofitBuilder

class PokemonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonBinding
    private lateinit var adapter: PokemonAdapter // Tambahkan baris ini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi adapter
        adapter = PokemonAdapter(ArrayList()) // Sesuaikan dengan data yang ingin Anda tampilkan

        // Set adapter ke RecyclerView
        binding.rvContent.adapter = adapter

        // ... (Kode lainnya)

        PokemonRetrofitBuilder.instancePokemon.getPokemon()
            .enqueue(object : Callback<PokemonResponse> {
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    val body = response.body()
                    Log.d("POKEMON", body?.results.toString())

                    // Tambahkan data ke adapter setelah mendapatkan respons
                    body?.results?.let {
                        adapter.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    Log.e("POKEMON", t.localizedMessage)
                }
            })

        // ... (Kode lainnya)
    }
}

