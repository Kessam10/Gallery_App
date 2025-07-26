package com.example.data.mappers

import com.example.data.model.PhotosResponseModel
import com.example.data.model.PhotoDataModel
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.entities.PhotoResponse

fun PhotosResponseModel.toEntity():PhotoResponse{
    return PhotoResponse(
        data = data?.map {
            it.toEntity()
        }
    )
}

fun PhotoDataModel.toEntity():PhotoItemEntity{
    return PhotoItemEntity(
        albumId, id, title, url, thumbnailUrl
    )
}