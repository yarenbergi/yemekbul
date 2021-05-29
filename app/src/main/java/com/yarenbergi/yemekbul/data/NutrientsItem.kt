package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class NutrientsItem(@SerializedName("amount")
                         val amount: Int = 0,
                         @SerializedName("unit")
                         val unit: String = "",
                         @SerializedName("percentOfDailyNeeds")
                         val percentOfDailyNeeds: Int = 0,
                         @SerializedName("name")
                         val name: String = "")