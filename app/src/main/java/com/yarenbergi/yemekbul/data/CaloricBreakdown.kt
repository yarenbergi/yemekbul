package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class CaloricBreakdown(@SerializedName("percentCarbs")
                            val percentCarbs: Int = 0,
                            @SerializedName("percentProtein")
                            val percentProtein: Int = 0,
                            @SerializedName("percentFat")
                            val percentFat: Int = 0)