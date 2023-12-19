package com.example.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val authManajer: AuthManajer by lazy {
        AuthManajer.getInstance(this.datastore)
    }

    private val repository:AuthRepository by lazy {
        AuthRepository(authManajer)
    }

    private val viewModel:AuthViewModel by viewModels{
        AuthViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSubmit.setOnClickListener {
            val valueEmail = binding.etEmail.text.toString()
            val valueUsername = binding.etUsername.text.toString()

            if (valueEmail.isNotEmpty() && valueUsername.isNotEmpty()) {
                viewModel.setUserCredentials(valueEmail, valueUsername, null)
            } else {
                // Tampilkan pesan kesalahan atau lakukan sesuatu jika email atau username kosong
                Toast.makeText(this, "Email dan Username harus diisi", Toast.LENGTH_SHORT).show()
            }
        }


        viewModel.userCredential.observe(this) { value ->
            binding.tvEmail.text = "Hasil ${value.email ?: "N/A"}"
            binding.tvUsername.text = "Hasil ${value.username ?: "N/A"}"
        }



    }
}