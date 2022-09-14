package com.sudansh.planetm.domain.model

data class Album(
    val id: String,
    val name: String,
    val artworkUrl: String,
    val artistName: String,
    val genres: List<String>,
    val releaseData: String,
    val copyright: String,
    val url: String,
    val thumbnailUrl: String
)