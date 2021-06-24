package com.yarenbergi.yemekbul.recommender

import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import com.opencsv.CSVWriter
import okio.source
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*


class Recommender {
    @RequiresApi(Build.VERSION_CODES.R)
    fun like(inputStream: InputStream, ingredientList: IntArray) {
        givePoints(inputStream, ingredientList, 2)

    }

    fun dislike(inputStream: InputStream, ingredientList: IntArray) {
        givePoints(inputStream, ingredientList, -1)
    }

    fun givePoints(inputStream: InputStream, ingredientList: IntArray, points: Int){
        try {

            val csvParser = CSVParser(FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv" ).bufferedReader(), CSVFormat.DEFAULT);
            //CSVWriter().
            val list:ArrayList<IngredientCsv> = ArrayList<IngredientCsv>()
            for (csvRecord in csvParser) {
                val name = csvRecord.get(0);
                val id = csvRecord.get(1).toBigDecimal();
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