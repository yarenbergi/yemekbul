package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class MealsItem(@SerializedName("readyInMinutes")
                     val readyInMinutes: Int = 0,
                     @SerializedName("sourceUrl")
                     val sourceUrl: String = "",
                     @SerializedName("servings")
                     val servings: Int = 0,
                     @SerializedName("id")
                     val id: Int = 0,
                     @SerializedName("title")
                     val title: String = "",
                     @SerializedName("imageType")
                     val imageType: String = "")