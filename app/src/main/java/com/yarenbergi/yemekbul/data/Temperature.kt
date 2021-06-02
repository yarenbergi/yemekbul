package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class Temperature(@SerializedName("number")
                       val number: Int = 0,
                       @SerializedName("unit")
                       val unit: String = "")