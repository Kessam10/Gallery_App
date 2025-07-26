package com.example.data.repository

import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.repository.PhotoOnlineDataSource
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow

class PhotoRepositoryImpl(
    private val onlineDataSource: PhotoOnlineDataSource
):PhotoRepository {
    override suspend fun getPhotos(): Flow<ApiResult<List<PhotoItemEntity>>> {
        return onlineDataSource.fetchPhotos()
    }
}