package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class Metric(@SerializedName("amount")
                  val amount: Double = 0.0,
                  @SerializedName("unitShort")
                  val unitShort: String = "",
                  @SerializedName("unitLong")
                  val unitLong: String = "")