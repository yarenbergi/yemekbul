package com.yarenbergi.yemekbul

import androidx.lifecycle.LiveData
import com.yarenbergi.yemekbul.data.MenuItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeService {
    @Headers("apiKey: " + "3b749f7ad30c48d9844cab1d2fcb0f23")
    @GET("/food/menuItems/")
    fun getMenuItem(@Query("id") id : String): Call<LiveData<MenuItems>>
}