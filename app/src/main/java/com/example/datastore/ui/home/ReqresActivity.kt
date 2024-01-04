package com.example.datastore.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.datastore.data.network.Reqres.ReqresApi
import com.example.datastore.data.network.Reqres.ReqresBuilder
import com.example.datastore.data.repository.ReqresRepository
import com.example.datastore.data.viewmodel.ReqresViewModel
import com.example.datastore.databinding.ActivityReqresBinding
import com.example.datastore.ui.home.adapter.ReqresAdapter

class ReqresActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReqresBinding

    private val adapter: ReqresAdapter by lazy {
        ReqresAdapter()
    }

    private val reqresApi: ReqresApi by lazy {
        ReqresBuilder.instanceReqres
    }

    private val repository: ReqresRepository by lazy {
        ReqresRepository(reqresApi)
    }

    private val viewModel: ReqresViewModel by viewModels {
        ReqresViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReqresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atur adapter ke RecyclerView
        binding.rvContent.adapter = adapter

        // Observasi data dari ViewModel
        viewModel.reqresData.observe(this, { response ->
            if (response.isSuccessful) {
                val reqresList = response.body()?.result
                reqresList?.let {
                    // Memperbarui adapter dengan data baru
                    adapter.addAll(it)
                    Log.e("ReqresActivity", "Berhasil")
                    for (reqres in it) {
                        Log.e("ReqresActivity", "Reqres: ${reqres.first_name} ${reqres.last_name}")
                    }
                }
            } else {
                Log.e("ReqresActivity", "Terjadi kesalahan: ${response.message()}")
            }
        })
    }
}
