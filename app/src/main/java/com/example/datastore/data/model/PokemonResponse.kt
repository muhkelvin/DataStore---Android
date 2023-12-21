package com.example.datastore.data.model

import com.google.gson.annotations.SerializedName

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking
 *
 * Created by Rizky Fadilah on 02/11/23.
 * https://github.com/rizkyfadilah
 *
 */

// 1.
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
