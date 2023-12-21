package com.example.datastore.data.model


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("result")
    val result: List<Result> = emptyList()
){
    data class Result(
        @SerializedName("body")
        val body: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("userId")
        val userId: Int = 0
    )

}

