package com.example.datastore.data.model

import com.google.gson.annotations.SerializedName

data class EmojiResponse(
    @SerializedName("data") var data: List<Data>,
    @SerializedName("pagination") var pagination: Pagination,
    @SerializedName("meta") var meta: Meta
) {
    data class Data(
        @SerializedName("type") var type: String,
        @SerializedName("id") var id: String,
        @SerializedName("url") var url: String,
        @SerializedName("slug") var slug: String,
        @SerializedName("bitly_gif_url") var bitlyGifUrl: String,
        @SerializedName("bitly_url") var bitlyUrl: String,
        @SerializedName("embed_url") var embedUrl: String,
        @SerializedName("username") var username: String,
        @SerializedName("source") var source: String,
        @SerializedName("title") var title: String,
        @SerializedName("rating") var rating: String,
        @SerializedName("content_url") var contentUrl: String,
        @SerializedName("source_tld") var sourceTld: String,
        @SerializedName("source_post_url") var sourcePostUrl: String,
        @SerializedName("is_sticker") var isSticker: Int,
        @SerializedName("import_datetime") var importDatetime: String,
        @SerializedName("trending_datetime") var trendingDatetime: String,
        @SerializedName("images") var images: Images,
        @SerializedName("emoji_group_id") var emojiGroupId: Int,
        @SerializedName("variation") var variation: String,
        @SerializedName("variation_count") var variationCount: Int,
    ) {
        data class Images(
            @SerializedName("downsized") var downsized: Downsized,
        ) {
            data class Downsized(
                @SerializedName("height") var height: String,
                @SerializedName("size") var size: String,
                @SerializedName("url") var url: String,
                @SerializedName("width") var width: String
            )
        }
    }

    data class Pagination(
        @SerializedName("count") var count: Int,
        @SerializedName("offset") var offset: Int,
        @SerializedName("next_cursor") var nextCursor: Int
    )

    data class Meta(
        @SerializedName("msg") var msg: String,
        @SerializedName("status") var status: Int,
        @SerializedName("response_id") var responseId: String
    )
}