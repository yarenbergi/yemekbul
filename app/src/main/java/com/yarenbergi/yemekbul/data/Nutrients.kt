package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class Nutrients(@SerializedName("carbohydrates")
                     val carbohydrates: Double = 0.0,
                     @SerializedName("protein")
                     val protein: Double = 0.0,
                     @SerializedName("fat")
                     val fat: Double = 0.0,
                     @SerializedName("calories")
                     val calories: Double = 0.0)