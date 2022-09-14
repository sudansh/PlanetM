package com.sudansh.planetm.data.db

import com.sudansh.planetm.domain.model.Album
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class RealmAlbum : RealmObject {
    var remoteId: String = ""
    var albumName: String = ""
    var artworkUrl: String = ""
    var thumbnailUrl: String = ""
    var artistName: String = ""
    var genres: RealmList<String> = realmListOf()
    var releaseDate: String = ""
    var copyright: String = ""
    var url: String = ""
}

fun Album.toRealmAlbum(): RealmAlbum {
    return RealmAlbum().apply {
        remoteId = this@toRealmAlbum.id
        albumName = this@toRealmAlbum.name
        artworkUrl = this@toRealmAlbum.artworkUrl
        artistName = this@toRealmAlbum.artistName
        thumbnailUrl = this@toRealmAlbum.thumbnailUrl
        genres = this@toRealmAlbum.genres.toRealmList()
        releaseDate = this@toRealmAlbum.releaseData
        copyright = this@toRealmAlbum.copyright
        url = this@toRealmAlbum.url
    }
}