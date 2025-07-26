package com.example.data.dataSource

import com.example.data.local.dao.PhotoDao
import com.example.data.model.PhotoEntity
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.repository.PhotoLocalDataSource
import javax.inject.Inject

class PhotoLocalDataSourceImpl @Inject constructor(
    private val dao: PhotoDao
) : PhotoLocalDataSource {
    override suspend fun getCachedPhotos(): List<PhotoItemEntity> {
        return dao.getCachedPhotos().map {
            PhotoItemEntity(it.albumId, it.id, it.title, it.url, it.thumbnailUrl)
        }
    }

    override suspend fun savePhotos(list: List<PhotoItemEntity>) {
        dao.clearPhotos()
        dao.insertPhotos(list.map {
            PhotoEntity(it.id ?: 0, it.albumId, it.title, it.url, it.thumbnailUrl)
        })
    }
}
