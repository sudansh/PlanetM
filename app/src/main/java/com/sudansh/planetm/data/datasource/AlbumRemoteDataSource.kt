package com.sudansh.planetm.data.datasource

import com.sudansh.planetm.data.network.AppleApi
import com.sudansh.planetm.data.network.mapping.toDomain
import com.sudansh.planetm.domain.model.Album

class AlbumRemoteDataSource(private val api: AppleApi) {

    /**
     * Get All albums from apple service
     *
     * @return
     */
    suspend fun getAlbums(): List<Album> {
        return api.getAlbums().toDomain()
    }
}