package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class AnalyzedRecipe(@SerializedName("name")
                          val name: String = "",
                          @SerializedName("steps")
                          val steps: List<StepsItem>?)