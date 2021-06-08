package com.yarenbergi.yemekbul.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yarenbergi.yemekbul.ImageAdapter
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service


class MenuItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)

        val id = intent.getStringExtra("id")
        var text: TextView = findViewById<TextView>(R.id.menuItemView)
        if (id != null) {
            text.text = Service.getRecipeInformation(id.toBigDecimal(),false).title
        }
/*
        var menuItemModel = MenuItemModel()
        menuItemModel.getMenuItem("1")
        var text: TextView = findViewById(R.id.menuItemView) as TextView
        text.setText("asd")
*/
        /*
        val apiInstance = DefaultApi()
        val id : java.math.BigDecimal = 1.toBigDecimal() // java.math.BigDecimal | The menu item id.
        try {
            val result : kotlin.Any = apiInstance.getMenuItemInformation(id)
            val gson = GsonBuilder().create()

            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            //println(gson.toJson(result))
            //println(result)

            val driverlocationsList : MenuItems = gson.fromJson(gson.toJson(result), MenuItems::class.java)
            println(driverlocationsList)
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getMenuItemInformation")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getMenuItemInformation")
            e.printStackTrace()
        }

         */
/*
        //getAnalyzedRecipeInstructions
        val apiInstance = DefaultApi()
        val id : java.math.BigDecimal = 324694.toBigDecimal() // java.math.BigDecimal | The recipe id.
        val stepBreakdown : kotlin.Boolean = true // kotlin.Boolean | Whether to break down the recipe steps even more.
        try {
            val result : kotlin.Any = apiInstance.getAnalyzedRecipeInstructions(id, stepBreakdown)
            val gson = GsonBuilder().create()
            val mapper = ObjectMapper()
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            val listType: Type = object : TypeToken<List<AnalyzedRecipe?>?>() {}.type
            val recipe : List<AnalyzedRecipe> = gson.fromJson(gson.toJson(result), listType)
            var text: TextView = findViewById(R.id.menuItemView) as TextView
            text.setText(recipe[1].name)
            println(recipe[1].name)
            println(result)
        } catch (e: ClientException) {
            println("4xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        } catch (e: ServerException) {
            println("5xx response calling DefaultApi#getAnalyzedRecipeInstructions")
            e.printStackTrace()
        }
 */
        val imageView: ImageView = findViewById(R.id.imageView)
        ImageAdapter.setImage(
            "https://spoonacular.com/cdn/ingredients_100x100/white-powder.jpg",
            imageView
        )


    }


}