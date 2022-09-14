package com.sudansh.planetm.data

import com.sudansh.planetm.data.datasource.AlbumLocalDataSource
import com.sudansh.planetm.data.datasource.AlbumRemoteDataSource
import com.sudansh.planetm.domain.model.Album
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val localSource: AlbumLocalDataSource,
    private val remoteSource: AlbumRemoteDataSource
) {
    /**
     * Observe on the albums from db
     *
     * @return
     */
    fun observeAlbums(): Flow<List<Album>> {
        return localSource.observeAlbums()
    }

    /**
     * Find the album by id from localdb
     *
     * @param albumId
     * @return
     */
    fun findAlbum(albumId: String): Album? {
        return localSource.findAlbum(albumId)
    }

    /**
     * Fetch latest music albums from network
     *
     */
    suspend fun refreshAlbums() {
        val remoteData = remoteSource.getAlbums()
        localSource.saveAlbums(remoteData)
    }

}