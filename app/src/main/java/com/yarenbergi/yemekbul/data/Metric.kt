package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class Metric(@SerializedName("amount")
                  val amount: Int = 0,
                  @SerializedName("unitShort")
                  val unitShort: String = "",
                  @SerializedName("unitLong")
                  val unitLong: String = "")