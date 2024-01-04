package com.example.datastore.data.model

import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var results: List<Results>
) {
    data class Results(
        @SerializedName("name") var name: String,
        @SerializedName("url") var url: String
    )
}
