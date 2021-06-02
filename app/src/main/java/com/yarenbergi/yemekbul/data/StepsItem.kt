package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class StepsItem(@SerializedName("number")
                     val number: Int = 0,
                     @SerializedName("equipment")
                     val equipment: List<EquipmentItem>?,
                     @SerializedName("step")
                     val step: String = "")