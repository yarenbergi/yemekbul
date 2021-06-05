package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class ExtendedIngredientsItem(@SerializedName("originalName")
                                   val originalName: String = "",
                                   @SerializedName("image")
                                   val image: String = "",
                                   @SerializedName("amount")
                                   val amount: Int = 0,
                                   @SerializedName("measures")
                                   val measures: Measures,
                                   @SerializedName("unit")
                                   val unit: String = "",
                                   @SerializedName("original")
                                   val original: String = "",
                                   @SerializedName("consitency")
                                   val consitency: String = "",
                                   @SerializedName("name")
                                   val name: String = "",
                                   @SerializedName("id")
                                   val id: Int = 0,
                                   @SerializedName("aisle")
                                   val aisle: String = "")