package com.example.datastore.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.datastore.auth.AuthManajer
import com.example.datastore.auth.AuthRepository
import com.example.datastore.auth.AuthViewModel
import com.example.datastore.auth.datastore
import com.example.datastore.databinding.ActivitySplashBinding
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

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
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handler untuk menahan Splash Screen selama 3 detik
        Handler().postDelayed({
            // Cek apakah pengguna sudah login
            checkLoginStatus()
        }, 3000)
    }

    private fun checkLoginStatus() {
        lifecycleScope.launch {
            val isLoggedIn = authManager.loginStatus()

            if (isLoggedIn) {
                // Jika pengguna sudah login, pindah ke halaman home
                startHomeActivity()
            } else {
                // Jika pengguna belum login, lakukan sesuatu, misalnya, tampilkan halaman login
                startLoginActivity()

                // Contoh: startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        }
    }



    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}

