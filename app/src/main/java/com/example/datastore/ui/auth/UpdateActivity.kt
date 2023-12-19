package com.example.datastore.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivityUpdateBinding
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUpdateBinding

    private val authManager: AuthManajer by lazy {
        AuthManajer.getInstance(this.datastore)
    }

    private val repository: AuthRepository by lazy {
        AuthRepository(authManager)
    }

    private val viewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory(repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btUpdate.setOnClickListener {
            val nama = binding.etNamaLengkap.text.toString()
            val tanggal = binding.etTanggal.text.toString()
            val alamat = binding.etAlamat.text.toString()

            lifecycleScope.launch {
                viewModel.updateIdentitas(nama, tanggal, alamat)
                startActivity(Intent(this@UpdateActivity, HomeActivity::class.java))
                finish()
            }
        }

    }
}