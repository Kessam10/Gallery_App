package com.example.domain.repository

import com.example.domain.entities.PhotoItemEntity

interface PhotoLocalDataSource {
    suspend fun getCachedPhotos(): List<PhotoItemEntity>
    suspend fun savePhotos(list: List<PhotoItemEntity>)
}
