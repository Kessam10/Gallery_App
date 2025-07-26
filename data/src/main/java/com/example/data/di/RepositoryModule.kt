package com.example.data.di

import com.example.data.dataSource.PhotoOnlineDataSourceImpl
import com.example.data.online.services.PhotosService
import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoOnlineDataSource
import com.example.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Provides
    @Singleton
    fun providePhotosOnlineDataSource(service: PhotosService):PhotoOnlineDataSource{
        return PhotoOnlineDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun providePhotosRepository(onlineDataSource: PhotoOnlineDataSource):PhotoRepository {
        return PhotoRepositoryImpl(onlineDataSource)
    }
}