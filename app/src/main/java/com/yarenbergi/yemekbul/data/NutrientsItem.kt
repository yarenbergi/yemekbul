package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class NutrientsItem(@SerializedName("amount")
                         val amount: Float,
                         @SerializedName("unit")
                         val unit: String = "",
                         @SerializedName("percentOfDailyNeeds")
                         val percentOfDailyNeeds: Float,
                         @SerializedName("name")
                         val name: String = "")