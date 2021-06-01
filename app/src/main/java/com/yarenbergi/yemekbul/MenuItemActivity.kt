package com.yarenbergi.yemekbul

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.GsonBuilder
import com.yarenbergi.yemekbul.api.com.spoonacular.DefaultApi
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ClientException
import com.yarenbergi.yemekbul.api.spoonacular.infrastructure.ServerException
import com.yarenbergi.yemekbul.data.MenuItems


class MenuItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)
/*
        var menuItemModel = MenuItemModel()
        menuItemModel.getMenuItem("1")
        var text: TextView = findViewById(R.id.menuItemView) as TextView
        text.setText("asd")
*/

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
    }


}