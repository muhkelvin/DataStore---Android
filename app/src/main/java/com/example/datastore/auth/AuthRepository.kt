package com.example.datastore.auth

import android.provider.ContactsContract.CommonDataKinds.Email
import kotlinx.coroutines.flow.Flow

class AuthRepository(private val authdataStore:AuthManajer) {

    fun getCredentials():Flow<AuthManajer.UserCredentials>{
        return authdataStore.getUserCredential()
    }

    suspend fun setUserCredentials(email: String, username:String,password:String){
        authdataStore.setCredentials(email,username,password)
    }

//    suspend fun updateCredentials(email: String, username: String, password: String) {
//        authdataStore.updateCredentials(email, username, password)
//    }

    suspend fun updateIdentitas(nama:String,tanggal:String,alamat:String){
        authdataStore.updateIdentitas(nama,tanggal,alamat)
    }
    suspend fun login(email: String, password: String): Boolean {
        return authdataStore.login(email, password)
    }

    suspend fun logout(){
        authdataStore.logout()
    }
}