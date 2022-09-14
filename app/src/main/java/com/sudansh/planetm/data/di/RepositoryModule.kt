package com.sudansh.planetm.data.di

import com.sudansh.planetm.data.AlbumRepository
import com.sudansh.planetm.data.datasource.AlbumLocalDataSource
import com.sudansh.planetm.data.datasource.AlbumRemoteDataSource
import com.sudansh.planetm.data.network.AppleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm

@Module
@InstallIn(ViewModelComponent::class, SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(
        api: AppleApi,
        realm: Realm
    ): AlbumRepository {
        return AlbumRepository(
            AlbumLocalDataSource(realm),
            AlbumRemoteDataSource(api),
        )
    }
}