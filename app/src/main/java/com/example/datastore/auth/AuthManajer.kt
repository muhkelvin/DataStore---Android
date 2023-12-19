package com.example.datastore.auth

import android.net.wifi.hotspot2.pps.Credential.UserCredential
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AuthManajer(private val dataStore: DataStore<Preferences>) {
    companion object{
        val KEY_EMAIL = stringPreferencesKey("KEY_EMAIL")
        val KEY_USERNAME = stringPreferencesKey("KEY_USERNAME")
        val KEY_PASSWORD = stringPreferencesKey("KEY_PASSWORD")

        @Volatile
        private var instance: AuthManajer? = null
        fun getInstance(dataStore: DataStore<Preferences>): AuthManajer{
            return instance ?: synchronized(this){
                instance ?: AuthManajer(dataStore)
            }.also { instance = it }
        }
    }

    data class UserCredentials(val username:String,val email:String,val password:String)

    fun getUserCredential(): Flow<UserCredentials>{
        return dataStore.data.map {preference ->
            UserCredentials(
                preference[KEY_EMAIL].orEmpty(),
                preference[KEY_USERNAME].orEmpty(),
                preference[KEY_PASSWORD].orEmpty(),
            )

        }
    }

    suspend fun setCredentials(email: String,username: String,password: String){
        dataStore.edit {preference ->
            preference[KEY_EMAIL] = email
            preference[KEY_USERNAME] = username
            preference[KEY_PASSWORD] = password

        }
    }
}

