package com.yarenbergi.yemekbul.data.favorites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class favoriteRecipes(
    @PrimaryKey(autoGenerate = true) var key: Int = 0,
    var uid: String = "",
    @ColumnInfo(name = "recipe_id") var recipe_id: String? = "",
)

