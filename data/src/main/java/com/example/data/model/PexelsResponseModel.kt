package com.example.data.model

data class PexelsResponseModel(
    val photos: List<PexelsPhotoItem>?
)

data class PexelsPhotoItem(
    val id: Int,
    val photographer: String?,
    val src: PhotoSrc?
)

data class PhotoSrc(
    val original: String?,
    val medium: String?,
    val small: String?,
    val tiny: String?
)
