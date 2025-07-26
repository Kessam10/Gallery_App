package com.example.data.online.services

import com.example.data.model.PexelsResponseModel
import com.example.data.model.PhotoDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosService {
    @GET("v1/curated")
    suspend fun fetchPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): PexelsResponseModel

//    @GET("photos")
//    suspend fun fetchPhotos(): List<PhotoDataModel>
}