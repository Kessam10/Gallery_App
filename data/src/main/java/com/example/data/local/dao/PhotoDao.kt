package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.PhotoEntity

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(list: List<PhotoEntity>)

    @Query("SELECT * FROM photos")
    suspend fun getCachedPhotos(): List<PhotoEntity>

    @Query("DELETE FROM photos")
    suspend fun clearPhotos()
}
