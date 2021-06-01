package com.yarenbergi.yemekbul.data

import com.google.gson.internal.LinkedHashTreeMap
import com.squareup.moshi.Json

data class MenuItems(@Json(name = "title")
                     val title: String = "",
                     @Json(name = "generatedText")
                     val generatedText: String = "",
                     @Json(name = "numberOfServings")
                     val numberOfServings: Int = 0,
                     @Json(name = "restaurantChain")
                     val restaurantChain: String = "",
                     @Json(name = "nutrition")
                     val nutrition: Nutrition,
                     @Json(name = "price")
                     val price: Int = 0,
                     @Json(name = "spoonacularScore")
                     val spoonacularScore: Int = 0,
                     @Json(name = "id")
                     val id: Int = 0,
                     @Json(name = "readableServingSize")
                     val readableServingSize: Int = 0,
                     @Json(name = "imageType")
                     val imageType: String = "",
                     @Json(name = "servingSize")
                     val servingSize: Int = 0,
                     @Json(name = "breadcrumbs")
                     val breadcrumbs: LinkedHashTreeMap<String, String>?,
                     @Json(name = "likes")
                     val likes: Int = 0)