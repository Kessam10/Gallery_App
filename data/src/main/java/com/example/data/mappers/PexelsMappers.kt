package com.example.data.mappers

import com.example.data.model.PexelsPhotoItem
import com.example.domain.entities.PhotoItemEntity

fun PexelsPhotoItem.toEntity(): PhotoItemEntity {
    return PhotoItemEntity(
        id = id,
        albumId = null,
        title = photographer,
        url = this.src?.medium,
        thumbnailUrl = this.src?.tiny
    )
}
