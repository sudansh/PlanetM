package com.sudansh.planetm.data.datasource

import com.sudansh.planetm.data.db.RealmAlbum
import com.sudansh.planetm.data.db.mapper.toDomain
import com.sudansh.planetm.data.db.toRealmAlbum
import com.sudansh.planetm.domain.model.Album
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlbumLocalDataSource(
    private val realm: Realm
) {

    /**
     * Observe local albums
     *
     * @return
     */
    fun observeAlbums(): Flow<List<Album>> {
        return realm.query<RealmAlbum>().asFlow()
            .map { album -> album.list.map { it.toDomain() } }
    }

    /**
     * Find details of an album
     *
     * @param remoteId
     * @return
     */
    fun findAlbum(remoteId: String): Album? {
        return realm.query<RealmAlbum>("remoteId == $0", remoteId)
            .find()
            .firstOrNull()?.toDomain()
    }

    /**
     * Replace the old albums with new albums
     *
     * @param albums
     */
    suspend fun saveAlbums(albums: List<Album>) {
        realm.write {
            val query = query<RealmAlbum>().find()
            delete(query)
            albums.forEach { album ->
                val realm = album.toRealmAlbum()
                copyToRealm(realm)
            }
        }
    }
}