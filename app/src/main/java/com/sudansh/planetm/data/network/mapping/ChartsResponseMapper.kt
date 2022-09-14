package com.sudansh.planetm.data.network.mapping

import com.sudansh.planetm.domain.model.Album
import com.sudansh.planetm.domain.network.response.AlbumResponse

fun AlbumResponse.toDomain() = this.feed.result.map { it.toDomain(feed.copyright) }

fun AlbumResponse.Feed.ResultItem.toDomain(copyright: String) = Album(
    id = id,
    name = name,
    artworkUrl = artwork.replace("100x100bb", "400x400bb"),
    artistName = artistName,
    genres = genres.map { it.name },
    releaseData = releaseDate,
    copyright = copyright,
    url = url,
    thumbnailUrl = artwork.replace("100x100bb", "200x200bb"),
)