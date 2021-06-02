package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class EquipmentItem(@SerializedName("image")
                         val image: String = "",
                         @SerializedName("name")
                         val name: String = "",
                         @SerializedName("temperature")
                         val temperature: Temperature,
                         @SerializedName("id")
                         val id: Int = 0)