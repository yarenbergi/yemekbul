package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class NutrientsItem(@Json(name = "amount")
                         val amount: Float,
                         @Json(name = "unit")
                         val unit: String = "",
                         @Json(name = "percentOfDailyNeeds")
                         val percentOfDailyNeeds: Float,
                         @Json(name = "name")
                         val name: String = "")