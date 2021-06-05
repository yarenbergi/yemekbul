package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class ProductMatchesItem(@SerializedName("score")
                              val score: Double = 0.0,
                              @SerializedName("price")
                              val price: String = "",
                              @SerializedName("imageUrl")
                              val imageUrl: String = "",
                              @SerializedName("averageRating")
                              val averageRating: Double = 0.0,
                              @SerializedName("link")
                              val link: String = "",
                              @SerializedName("description")
                              val description: String = "",
                              @SerializedName("id")
                              val id: Int = 0,
                              @SerializedName("title")
                              val title: String = "",
                              @SerializedName("ratingCount")
                              val ratingCount: Int = 0)