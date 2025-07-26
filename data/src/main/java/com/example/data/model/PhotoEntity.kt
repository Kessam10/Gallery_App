package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey val id: Int,
    val albumId: Int?,
    val title: String?,
    val url: String?,
    val thumbnailUrl: String?
)

