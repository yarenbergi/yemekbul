package com.yarenbergi.yemekbul.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yarenbergi.yemekbul.data.favorites.favoriteRecipes

@Dao
interface favoriteDao {
    @Insert
    fun add(favoriteList: favoriteRecipes?)

    @Query("SELECT * FROM favoriteRecipes")
    fun getAll(): List<favoriteRecipes>

    @Query("SELECT * FROM favoriteRecipes WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: String): List<favoriteRecipes>

    @Query("SELECT EXISTS (SELECT 1 FROM favoriteRecipes WHERE uid=:id AND recipe_id=:recipeId)")
    fun isFavorite(id: String, recipeId: String): Int

    @Insert
    fun insertAll(vararg favorite_recipes: favoriteRecipes)

    @Query("DELETE FROM favoriteRecipes WHERE recipe_id = :id")
    fun deleteByRecipeId(id: String?)
}