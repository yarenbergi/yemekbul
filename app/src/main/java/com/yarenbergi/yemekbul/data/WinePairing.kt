package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class WinePairing(@SerializedName("productMatches")
                       val productMatches: List<ProductMatchesItem>?,
                       @SerializedName("pairingText")
                       val pairingText: String = "",
                       @SerializedName("pairedWines")
                       val pairedWines: List<String>?)