package com.example.domain.repository

import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun getPhotos(): Flow<ApiResult<List<PhotoItemEntity>>>
}

interface PhotoOnlineDataSource{
    suspend fun fetchPhotos(): Flow<ApiResult<List<PhotoItemEntity>>>
}