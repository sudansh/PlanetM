package com.sudansh.planetm.domain.network.response

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("feed") val feed: Feed
) {
    data class Feed(
        @SerializedName("copyright") val copyright: String,
        @SerializedName("results") val result: List<ResultItem>
    ) {
        data class ResultItem(
            @SerializedName("id") val id: String,
            @SerializedName("name") val name: String,
            @SerializedName("artworkUrl100") val artwork: String,
            @SerializedName("artistName") val artistName: String,
            @SerializedName("genres") val genres: List<Genre>,
            @SerializedName("url") val url: String,
            @SerializedName("releaseDate") val releaseDate: String
        ) {
            data class Genre(
                @SerializedName("name") val name: String
            )
        }
    }
}