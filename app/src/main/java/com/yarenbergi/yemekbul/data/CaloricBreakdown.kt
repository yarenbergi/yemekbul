package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class CaloricBreakdown(@SerializedName("percentCarbs")
                            val percentCarbs: Float,
                            @SerializedName("percentProtein")
                            val percentProtein: Float,
                            @SerializedName("percentFat")
                            val percentFat: Float)