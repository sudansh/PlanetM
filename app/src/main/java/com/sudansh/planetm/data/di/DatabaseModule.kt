package com.sudansh.planetm.data.di

import com.sudansh.planetm.data.db.RealmAlbum
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesRealmConfig(): RealmConfiguration =
        RealmConfiguration.Builder(schema = setOf(RealmAlbum::class)).build()

    @Provides
    @Singleton
    fun provideRealm(configuration: RealmConfiguration): Realm = Realm.open(configuration)
}