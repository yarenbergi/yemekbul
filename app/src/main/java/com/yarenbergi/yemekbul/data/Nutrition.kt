package com.yarenbergi.yemekbul.data

import com.google.gson.internal.LinkedHashTreeMap
import com.squareup.moshi.Json

data class Nutrition(@Json(name = "caloricBreakdown")
                     val caloricBreakdown: CaloricBreakdown,
                     @Json(name = "nutrients")
                     val nutrients: LinkedHashTreeMap<String, NutrientsItem>?)