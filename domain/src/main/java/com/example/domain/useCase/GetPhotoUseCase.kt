package com.example.domain.useCase

import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(): Flow<ApiResult<List<PhotoItemEntity>>> {
        return repository.getPhotos()
    }
}
