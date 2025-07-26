package com.example.data.repository

import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.repository.PhotoLocalDataSource
import com.example.domain.repository.PhotoOnlineDataSource
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//class PhotoRepositoryImpl(
//    private val onlineDataSource: PhotoOnlineDataSource
//):PhotoRepository {
//    override suspend fun getPhotos(): Flow<ApiResult<List<PhotoItemEntity>>> {
//        return onlineDataSource.fetchPhotos()
//    }
//}
class PhotoRepositoryImpl @Inject constructor(
    private val onlineDataSource: PhotoOnlineDataSource,
    private val localDataSource: PhotoLocalDataSource
) : PhotoRepository {

    override suspend fun getPhotos(): Flow<ApiResult<List<PhotoItemEntity>>> = flow {
        emit(ApiResult.Loading())

        try {
            onlineDataSource.fetchPhotos().collect { result ->
                when (result) {
                    is ApiResult.Success -> {
                        localDataSource.savePhotos(result.data)
                        emit(ApiResult.Success(result.data))
                    }
                    is ApiResult.Error -> {
                        val cached = localDataSource.getCachedPhotos()
                        if (cached.isNotEmpty()) {
                            emit(ApiResult.Success(cached))
                        } else {
                            emit(result)
                        }
                    }
                    is ApiResult.Loading -> emit(result)
                }
            }
        } catch (e: Exception) {
            val cached = localDataSource.getCachedPhotos()
            if (cached.isNotEmpty()) {
                emit(ApiResult.Success(cached))
            } else {
                emit(ApiResult.Error(e.message ?: "Unknown Error"))
            }
        }
    }
}
