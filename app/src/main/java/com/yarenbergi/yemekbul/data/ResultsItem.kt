package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class ResultsItem(@SerializedName("image")
                       val image: String = "",
                       @SerializedName("name")
                       val name: String = "",
                       @SerializedName("id")
                       val id: Int = 0)