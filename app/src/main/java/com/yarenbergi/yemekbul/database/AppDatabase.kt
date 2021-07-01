package com.yarenbergi.yemekbul.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yarenbergi.yemekbul.dao.favoriteDao
import com.yarenbergi.yemekbul.data.favorites.favoriteRecipes

@Database(entities = arrayOf(favoriteRecipes::class), version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favorite_dao(): favoriteDao
}