package com.example.datastore.data.model

import com.google.gson.annotations.SerializedName

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking
 *
 * Created by Rizky Fadilah on 02/11/23.
 * https://github.com/rizkyfadilah
 *
 */

data class PokemonDetailResponse(
    @SerializedName("abilities") var abilities: List<Abilities>,
    @SerializedName("base_experience") var baseExperience: Int,
    @SerializedName("height") var height: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("is_default") var isDefault: Boolean,
    @SerializedName("location_area_encounters") var locationAreaEncounters: String,
    @SerializedName("name") var name: String,
    @SerializedName("order") var order: Int,
    @SerializedName("past_abilities") var pastAbilities: List<String>,
    @SerializedName("past_types") var pastTypes: List<String>,
    @SerializedName("weight") var weight: Int
) {
    data class Abilities(
        @SerializedName("ability") var ability: Ability,
        @SerializedName("is_hidden") var isHidden: Boolean,
        @SerializedName("slot") var slot: Int
    ) {
        data class Ability(
            @SerializedName("name") var name: String,
            @SerializedName("url") var url: String
        )
    }
}