package com.example.datastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding

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
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btDaftar.setOnClickListener{
            val valueUsername = binding.etUsername.text.toString()
            val valueEmail = binding.etEmail.text.toString()
            val valuePassword = binding.etPassword.text.toString()
            val valueKonfirmasi = binding.etKonfirmasi.text.toString()

            if (valueEmail.isNotEmpty() && valueUsername.isNotEmpty() && valuePassword.isNotEmpty() && valueKonfirmasi.isNotEmpty()){
                if (valuePassword == valueKonfirmasi) {
                    viewModel.setUserCredentials(valueUsername, valueEmail, valuePassword)
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Password dan konfirmasi password harus sama", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Email, Username, Password, dan Konfirmasi harus diisi", Toast.LENGTH_SHORT).show()
            }
        }



    }
}