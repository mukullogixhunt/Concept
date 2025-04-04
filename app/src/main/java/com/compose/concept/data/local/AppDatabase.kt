package com.compose.concept.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.concept.data.local.dao.UserDao
import com.compose.concept.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao


}