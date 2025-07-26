package com.example.data.dataSource

import com.example.data.executeAPI
import com.example.data.mappers.toEntity
import com.example.data.online.services.PhotosService
import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.repository.PhotoOnlineDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PhotoOnlineDataSourceImpl @Inject constructor(
    private val webService: PhotosService
):PhotoOnlineDataSource {
    override suspend fun fetchPhotos(): Flow<ApiResult<List<PhotoItemEntity>>> {
        return executeAPI {
            webService.fetchPhotos().photos?.map {
                it.toEntity()
            }?: listOf()
        }
    }
}