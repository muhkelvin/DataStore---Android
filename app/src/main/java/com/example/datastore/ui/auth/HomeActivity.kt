package com.example.datastore.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding

    private val authManajer: AuthManajer by lazy {
        AuthManajer.getInstance(this.datastore)
    }

    private val repository: AuthRepository by lazy {
        AuthRepository(authManajer)
    }

    private val viewModel: AuthViewModel by viewModels{
        AuthViewModel.Factory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btLogout.setOnClickListener {
             viewModel.logout()
             val intent = Intent(this, LoginActivity::class.java)
             startActivity(intent)
         }

        binding.btUpdate.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        viewModel.userCredential.observe(this) { data ->
            binding.tvNama.text = "Data telah Dirubah : ${data.nama}"
            binding.tanggal.text = "Data telah Dirubah : ${data.tanggal}"
            binding.alamat.text = "Data telah Dirubah : ${data.alamat}"
        }
    }
}