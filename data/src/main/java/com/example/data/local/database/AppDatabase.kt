package com.example.data.local.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.PhotoDao
import com.example.data.model.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}
