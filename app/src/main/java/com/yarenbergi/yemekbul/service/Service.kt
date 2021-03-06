package com.yarenbergi.yemekbul.service

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.yarenbergi.yemekbul.api.com.spoonacular.DefaultApi
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ClientException
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ServerException
import com.yarenbergi.yemekbul.data.*
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
//  Service.ingredientSearch("apple",true,1.toBigDecimal(),90.toBigDecimal(),
//            1.toBigDecimal(),90.toBigDecimal(),1.toBigDecimal(),90.toBigDecimal(),false,
//        "","calories","asc",0.toBigDecimal(),10.toBigDecimal())

    fun ingredientSearch(query: kotlin.String, addChildren: kotlin.Boolean?, minProteinPercent: java.math.BigDecimal?, maxProteinPercent: java.math.BigDecimal?, minFatPercent: java.math.BigDecimal?, maxFatPercent: java.math.BigDecimal?, minCarbsPercent: java.math.BigDecimal?, maxCarbsPercent: java.math.BigDecimal?, metaInformation: kotlin.Boolean?, intolerances: kotlin.String?, sort: kotlin.String?, sortDirection: kotlin.String?, offset: java.math.BigDecimal?, number: java.math.BigDecimal?) : List<ResultsItem>? {
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.ingredientSearch(query, addChildren, minProteinPercent, maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent, metaInformation, intolerances, sort, sortDirection, offset, number)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<IngredientSearchResult?>() {}.type
            val recipes : IngredientSearchResult = gson.fromJson(gson.toJson(result), listType)
            return recipes.results

        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#ingredientSearch")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#ingredientSearch")
            e.printStackTrace()
        }
        return null!!
    }

    // Service.generateMealPlan("day",100.toBigDecimal(),"vegetarian","shellfish, olives")
    fun generateMealPlan(timeFrame: kotlin.String?, targetCalories: java.math.BigDecimal?, diet: kotlin.String?, exclude: kotlin.String?) : MealPlan {
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.generateMealPlan(timeFrame, targetCalories, diet, exclude)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<MealPlan?>() {}.type
            val mealPlan : MealPlan = gson.fromJson(gson.toJson(result), listType)
            println(result)
            return mealPlan
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#generateMealPlan")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#generateMealPlan")
            e.printStackTrace()
        }
        return null!!
    }

    //Service.summarizeRecipe(4632.toBigDecimal())
    fun summarizeRecipe(id: java.math.BigDecimal) : SummarizeInfoForRecipe {//TODO:Anasayfaya bu bilgi eklenebilir mi?
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.summarizeRecipe(id)
            println(result)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<SummarizeInfoForRecipe?>() {}.type
            val recipeInformation : SummarizeInfoForRecipe = gson.fromJson(gson.toJson(result), listType)
            return recipeInformation
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#summarizeRecipe")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#summarizeRecipe")
            e.printStackTrace()
        }
        return null!!
    }

    fun searchAllFood(query: kotlin.String, offset: java.math.BigDecimal?, number: java.math.BigDecimal?) : kotlin.Any {
        val apiInstance = DefaultApi()
        try {
            val result : kotlin.Any = apiInstance.searchAllFood(query, offset, number)
            println(result)
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#searchAllFood")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#searchAllFood")
            e.printStackTrace()
        }
        return null!!
    }
}