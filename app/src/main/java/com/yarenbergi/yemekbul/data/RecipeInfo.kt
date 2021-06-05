package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class RecipeInfo(@SerializedName("instructions")
                      val instructions: String = "",
                      @SerializedName("sustainable")
                      val sustainable: Boolean = false,
                      @SerializedName("glutenFree")
                      val glutenFree: Boolean = false,
                      @SerializedName("veryPopular")
                      val veryPopular: Boolean = false,
                      @SerializedName("title")
                      val title: String = "",
                      @SerializedName("healthScore")
                      val healthScore: Int = 0,
                      @SerializedName("aggregateLikes")
                      val aggregateLikes: Int = 0,
                      @SerializedName("readyInMinutes")
                      val readyInMinutes: Int = 0,
                      @SerializedName("sourceUrl")
                      val sourceUrl: String = "",
                      @SerializedName("creditsText")
                      val creditsText: String = "",
                      @SerializedName("dairyFree")
                      val dairyFree: Boolean = false,
                      @SerializedName("servings")
                      val servings: Int = 0,
                      @SerializedName("vegetarian")
                      val vegetarian: Boolean = false,
                      @SerializedName("whole30")
                      val whole: Boolean = false,
                      @SerializedName("id")
                      val id: Int = 0,
                      @SerializedName("imageType")
                      val imageType: String = "",
                      @SerializedName("winePairing")
                      val winePairing: WinePairing,
                      @SerializedName("summary")
                      val summary: String = "",
                      @SerializedName("image")
                      val image: String = "",
                      @SerializedName("veryHealthy")
                      val veryHealthy: Boolean = false,
                      @SerializedName("vegan")
                      val vegan: Boolean = false,
                      @SerializedName("cheap")
                      val cheap: Boolean = false,
                      @SerializedName("dishTypes")
                      val dishTypes: List<String>?,
                      @SerializedName("extendedIngredients")
                      val extendedIngredients: List<ExtendedIngredientsItem>?,
                      @SerializedName("gaps")
                      val gaps: String = "",
                      @SerializedName("lowFodmap")
                      val lowFodmap: Boolean = false,
                      @SerializedName("license")
                      val license: String = "",
                      @SerializedName("weightWatcherSmartPoints")
                      val weightWatcherSmartPoints: Int = 0,
                      @SerializedName("spoonacularScore")
                      val spoonacularScore: Int = 0,
                      @SerializedName("pricePerServing")
                      val pricePerServing: Double = 0.0,
                      @SerializedName("sourceName")
                      val sourceName: String = "",
                      @SerializedName("spoonacularSourceUrl")
                      val spoonacularSourceUrl: String = "",
                      @SerializedName("ketogenic")
                      val ketogenic: Boolean = false)