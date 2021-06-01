package com.yarenbergi.yemekbul

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yarenbergi.yemekbul.data.MenuItems
import com.yarenbergi.yemekbul.data.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("/food/menuItems/{id}")
    fun getMenuItem(@Path("id") id: String, @Query("apiKey") apiKey:String)

    @GET("/recipes/{id}/similar")
    fun getSimilarRecipes(@Path("id") id: String, @Query("apiKey") apiKey:String): Call<List<Recipe>>
}