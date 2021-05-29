package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName
import com.yarenbergi.yemekbul.data.CaloricBreakdown
import com.yarenbergi.yemekbul.data.NutrientsItem

data class Nutrition(@SerializedName("caloricBreakdown")
                     val caloricBreakdown: CaloricBreakdown,
                     @SerializedName("nutrients")
                     val nutrients: List<NutrientsItem>?)