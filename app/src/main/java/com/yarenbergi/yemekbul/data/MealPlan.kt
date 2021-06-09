package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class MealPlan(@SerializedName("meals")
                    val meals: List<MealsItem>?,
                    @SerializedName("nutrients")
                    val nutrients: Nutrients)