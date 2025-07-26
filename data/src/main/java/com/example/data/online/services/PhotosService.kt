package com.example.data.online.services

import com.example.data.model.PhotosResponseModel
import retrofit2.http.GET

interface PhotosService {
    @GET("photos")
    suspend fun fetchPhotos(): PhotosResponseModel
}