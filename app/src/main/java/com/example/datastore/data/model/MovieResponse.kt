package rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model

import com.google.gson.annotations.SerializedName

/**
 * rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.model
 *
 * Created by Rizky Fadilah on 10/11/23.
 * https://github.com/rizkyfadilah
 *
 */

data class MovieResponse(
    @SerializedName("dates") var dates: Dates,
    @SerializedName("page") var page: Int,
    @SerializedName("results") var results: List<Results>,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("total_results") var totalResults: Int
) {
    data class Dates(
        @SerializedName("maximum") var maximum: String,
        @SerializedName("minimum") var minimum: String
    )

    data class Results(
        @SerializedName("adult") var adult: Boolean,
        @SerializedName("backdrop_path") var backdropPath: String,
        @SerializedName("genre_ids") var genreIds: List<Int>,
        @SerializedName("id") var id: Int,
        @SerializedName("original_language") var originalLanguage: String,
        @SerializedName("original_title") var originalTitle: String,
        @SerializedName("overview") var overview: String,
        @SerializedName("popularity") var popularity: Double,
        @SerializedName("poster_path") var posterPath: String,
        @SerializedName("release_date") var releaseDate: String,
        @SerializedName("title") var title: String,
        @SerializedName("video") var video: Boolean,
        @SerializedName("vote_average") var voteAverage: Double,
        @SerializedName("vote_count") var voteCount: Int
    )
}