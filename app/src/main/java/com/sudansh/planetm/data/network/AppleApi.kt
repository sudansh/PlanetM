package com.sudansh.planetm.data.network

import com.sudansh.planetm.domain.network.response.AlbumResponse
import retrofit2.http.GET

interface AppleApi {
    @GET("us/music/most-played/100/albums.json")
    suspend fun getAlbums(): AlbumResponse
}