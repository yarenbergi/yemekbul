package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class MenuItems(@SerializedName("title")
                     val title: String = "",
                     @SerializedName("generatedText")
                     val generatedText: String = "",
                     @SerializedName("numberOfServings")
                     val numberOfServings: Int = 0,
                     @SerializedName("restaurantChain")
                     val restaurantChain: String = "",
                     @SerializedName("nutrition")
                     val nutrition: Nutrition,
                     @SerializedName("price")
                     val price: Int = 0,
                     @SerializedName("spoonacularScore")
                     val spoonacularScore: Int = 0,
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("readableServingSize")
                     val readableServingSize: Int = 0,
                     @SerializedName("imageType")
                     val imageType: String = "",
                     @SerializedName("servingSize")
                     val servingSize: Int = 0,
                     @SerializedName("breadcrumbs")
                     val breadcrumbs: List<String>?,
                     @SerializedName("likes")
                     val likes: Int = 0)