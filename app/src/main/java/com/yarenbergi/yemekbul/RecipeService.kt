package com.yarenbergi.yemekbul

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yarenbergi.yemekbul.data.MenuItems
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeService {
    //@Headers("apiKey: " + "e1de17cefea24c36a776f31b15536d71")
    @GET("/food/menuItems/424571?apiKey=e1de17cefea24c36a776f31b15536d71&includeNutrition=true")
    fun getMenuItem(): Call<MenuItems>
}