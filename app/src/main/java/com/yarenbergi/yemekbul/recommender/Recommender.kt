package com.yarenbergi.yemekbul.recommender

import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import com.opencsv.CSVWriter
import com.yarenbergi.yemekbul.data.ExtendedIngredientsItem
import com.yarenbergi.yemekbul.data.Recipe
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.data.RecipesItem
import okio.source
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*
import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Recommender { //TODO: toplam puanı tutan bir metod olursa REcyclerviewAdapter_Recipes'de direk metodla çekebiliriz
    @RequiresApi(Build.VERSION_CODES.R)
    fun like(ingredientList: ArrayList<Int>) {
        givePoints(ingredientList, 2)
    }

    fun dislike(ingredientList: ArrayList<Int>) {
        givePoints(ingredientList, -1)
    }

    fun orderTheList(recipeList: List<RecipesItem>) : List<RecipePointDTO>{

        val csvParser = CSVParser(FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv" ).bufferedReader(), CSVFormat.DEFAULT);
        var recommendedList : ArrayList<RecipePointDTO> = ArrayList()
        val list:MutableMap<Int, Int> = HashMap()
        for (csvRecord in csvParser) {
            //val name = csvRecord.get(0);
            val id = csvRecord.get(1).toInt();
            val point = csvRecord.get(2).toInt();
            //println(name + id + point);
            //list.add(IngredientCsv(name, id, point))
            list[id] = point
        }
        csvParser.close()
        val pointList : ArrayList<Int> = ArrayList()
        for (recipe in recipeList){
            val recipeIngredients: List<ExtendedIngredientsItem>? = recipe.extendedIngredients
            var totalPoint = 0
            if (recipeIngredients != null) {
                for (ingredient in recipeIngredients){
                    if(list[ingredient.id] != null)
                        totalPoint += list[ingredient.id]!!
                }
            }
            pointList.add(totalPoint)
            recommendedList.add(RecipePointDTO(totalPoint, recipe ))
        }
        println(pointList)

        //order recipeList by pointList information
        /////////
        //create recipeListDTO and include point. Sort by points
        //println(recommendedList)

        return recommendedList.sortedWith(compareBy({-it.point}))
    }
//inputStream: InputStream,
    private fun givePoints(ingredientList: ArrayList<Int>, points: Int){
        try {
            val csvParser = CSVParser(FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv" ).bufferedReader(), CSVFormat.DEFAULT);
            //CSVWriter().
            val list:ArrayList<IngredientCsv> = ArrayList<IngredientCsv>()
            for (csvRecord in csvParser) {
                val name = csvRecord.get(0);
                val id = csvRecord.get(1).toInt();
                val point = csvRecord.get(2).toInt();
                //println(name + id + point);
                list.add(IngredientCsv(name, id, point))
            }
            csvParser.close()
            //finding the value
            for (ingredient in list){
                if(ingredientList.contains(ingredient.id.toInt())){
                    ingredient.point +=points
                    println(ingredient.ingredientName + " " + ingredient.id + " " + ingredient.point)
                }
            }

            //write back to csv
            val writer = CSVWriter(FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv" ).bufferedWriter(), ',')
            for(ingredient in list){
                writer.writeNext(arrayOf(ingredient.ingredientName, ingredient.id.toString(), ingredient.point.toString()))
            }
            //println("asdasasdasasdasads")
            writer.close()
            //println("asdasasdasasdasads")

        }
        catch (ffe: FileNotFoundException) {
            println(ffe.message)
        }
        catch(ioe: IOException) {
            println(ioe.message)
        }
    }

}