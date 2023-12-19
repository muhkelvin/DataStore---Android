package com.example.datastore.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

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
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btLogin.setOnClickListener {
            val valueEmail = binding.etEmail.text.toString()
            val valuePassword = binding.etPassword.text.toString()

            if (valueEmail.isNotEmpty() && valuePassword.isNotEmpty()) {
                // Lakukan logika login, contoh menggunakan ViewModel
                viewModel.login(valueEmail, valuePassword).observe(this) { isSuccess ->
                    if (isSuccess) {
                        // Jika login berhasil, pindah ke halaman home
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish() // Optional: Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman login
                    } else {
                        // Jika login gagal, tampilkan toast
                        Toast.makeText(this, "Login Gagal. Cek Email dan Password", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Jika email atau password kosong, tampilkan toast
                Toast.makeText(this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
            }
        }


        binding.tvRegister.setOnClickListener {
            val action = Intent(this, RegisterActivity::class.java)
            startActivity(action)
        }
    }
}