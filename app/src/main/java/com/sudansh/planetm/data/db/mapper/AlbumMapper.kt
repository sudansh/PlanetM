package com.sudansh.planetm.data.db.mapper

import com.sudansh.planetm.data.db.RealmAlbum
import com.sudansh.planetm.domain.model.Album

fun RealmAlbum.toDomain() = Album(
    id = remoteId,
    name = albumName,
    artworkUrl = artworkUrl,
    artistName = artistName,
    genres = genres,
    releaseData = releaseDate,
    copyright = copyright,
    url = url,
    thumbnailUrl = artworkUrl
)