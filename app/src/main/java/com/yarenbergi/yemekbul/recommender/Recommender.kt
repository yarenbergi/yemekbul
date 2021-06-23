package com.yarenbergi.yemekbul.recommender

import android.os.Environment
import com.opencsv.CSVReader
import com.yarenbergi.yemekbul.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*


class Recommender {
    fun like(inputStream: InputStream, ingredientList: Int) {
        try {
            val csvParser = CSVParser(inputStream.bufferedReader(), CSVFormat.DEFAULT);
            val list:ArrayList<IngredientCsv> = ArrayList<IngredientCsv>()
            for (csvRecord in csvParser) {
                val name = csvRecord.get(0);
                val id = csvRecord.get(1).toBigDecimal();
                val point = csvRecord.get(2).toInt();
                println(name + id + point);
                list.add(IngredientCsv(name, id, point))
            }
            

        }
        catch (ffe: FileNotFoundException) {
            println(ffe.message)
        }
        catch(ioe: IOException) {
            println(ioe.message)
        }

    }

    fun dislike(ingredientList: IntArray) {
        for (i in ingredientList.indices) {
            //ingredientList[i] sql query
        }
    }


}