package com.example.datastore.auth

import android.provider.ContactsContract.CommonDataKinds.Email
import kotlinx.coroutines.flow.Flow

class AuthRepository(private val authdataStore:AuthManajer) {

    fun getCredentials():Flow<AuthManajer.UserCredentials>{
        return authdataStore.getUserCredential()
    }

    suspend fun setUserCredential(email: String, username:String,password:String){
        authdataStore.setCredentials(email,username,password)
    }
}