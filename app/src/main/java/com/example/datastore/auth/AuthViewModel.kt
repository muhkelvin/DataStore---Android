package com.example.datastore.auth

import androidx.datastore.dataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository):ViewModel() {

    val userCredential: LiveData<AuthManajer.UserCredentials> = repository.getCredentials().asLiveData()

    fun setUserCredentials(email: String?, username: String?, password: String?) {
        viewModelScope.launch {
            // Menangani nilai null sebelum memanggil metode setUserCredential
            val safeEmail = email ?: ""
            val safeUsername = username ?: ""
            val safePassword = password ?: ""

            repository.setUserCredential(safeEmail, safeUsername, safePassword)
        }
    }

    class Factory(private val repository: AuthRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AuthViewModel::class.java)){
                return AuthViewModel(repository) as T
            }
            throw RuntimeException("no ViewModel Attach")
        }
    }
}