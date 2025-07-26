package com.example.domain.entities


data class PhotoResponse(
	val data: List<PhotoItemEntity?>? = null
)

data class PhotoItemEntity(
	val albumId: Int? = null,
	val id: Int? = null,
	val title: String? = null,
	val url: String? = null,
	val thumbnailUrl: String? = null
)

