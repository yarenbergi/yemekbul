package com.yarenbergi.yemekbul

import android.widget.ImageView
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.yarenbergi.yemekbul.api.com.spoonacular.DefaultApi
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ClientException
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ServerException
import com.yarenbergi.yemekbul.data.*
import kotlinx.android.synthetic.main.recipes_row_layout.view.*
import java.lang.reflect.Type

object Service {

    fun getMenuItemInformation(id: java.math.BigDecimal): MenuItems {
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.getMenuItemInformation(id)
            val gson = GsonBuilder().create()

            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val menuItem : MenuItems = gson.fromJson(gson.toJson(result), MenuItems::class.java)
            return menuItem
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getMenuItemInformation")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getMenuItemInformation")
            e.printStackTrace()
        }
        return null!!
    }
    fun getRecipeInformation(id: java.math.BigDecimal, includeNutrition: kotlin.Boolean? ): RecipeInfo {
        val apiInstance = DefaultApi()
        try {
            val result: kotlin.Any = apiInstance.getRecipeInformation(id, includeNutrition)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            return gson.fromJson(gson.toJson(result), RecipeInfo::class.java)
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        }
        return null!!
    }

    fun getRandomRecipes(limitLicense: kotlin.Boolean?, tags: kotlin.String?, number: java.math.BigDecimal?): List<RecipesItem>? {
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.getRandomRecipes(limitLicense, tags, number)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<Recipes?>() {}.type
            val recipe : Recipes = gson.fromJson(gson.toJson(result), listType)
            return recipe.recipes
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getRandomRecipes")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getRandomRecipes")
            e.printStackTrace()
        }
        return null!!
    }

    fun getAnalyzedRecipeInstructions(id: java.math.BigDecimal, stepBreakdown: kotlin.Boolean? ): List<AnalyzedRecipe> {
        //getAnalyzedRecipeInstructions
        val apiInstance = DefaultApi()
   try {
            val result : kotlin.Any = apiInstance.getAnalyzedRecipeInstructions(id, stepBreakdown)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<List<AnalyzedRecipe?>?>() {}.type
            val recipe : List<AnalyzedRecipe> = gson.fromJson(gson.toJson(result), listType)
            return recipe
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        }
        return null!!
    }

    fun setImage(url: String, view: ImageView){
        ImageAdapter.setImage(url,view)
    }

}