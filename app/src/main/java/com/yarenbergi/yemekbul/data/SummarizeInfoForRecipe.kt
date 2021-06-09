package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class SummarizeInfoForRecipe(@SerializedName("summary")
                                  val summary: String = "",
                                  @SerializedName("id")
                                  val id: Int = 0,
                                  @SerializedName("title")
                                  val title: String = "")