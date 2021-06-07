package com.yarenbergi.yemekbul.data

import com.google.gson.annotations.SerializedName

data class Recipes(@SerializedName("recipes")
                   val recipes: List<RecipesItem>?)