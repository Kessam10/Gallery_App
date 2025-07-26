package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.dataSource.PhotoOnlineDataSourceImpl
import com.example.data.local.dao.PhotoDao
import com.example.data.local.database.AppDatabase
import com.example.data.online.services.PhotosService
import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoLocalDataSource
import com.example.domain.repository.PhotoOnlineDataSource
import com.example.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun providePhotosRepository(onlineDataSource: PhotoOnlineDataSource,localDataSource: PhotoLocalDataSource):PhotoRepository {
        return PhotoRepositoryImpl(onlineDataSource,localDataSource)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "gallery_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePhotoDao(db: AppDatabase): PhotoDao = db.photoDao()

}