package com.yarenbergi.yemekbul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import com.yarenbergi.yemekbul.R

class FridgeIngredientsActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    lateinit var searchView: SearchView
    lateinit var mList: ListView
    val ingredientList : MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge_ingredients)
        ingredientList.add("apple")
        ingredientList.add("sugar")
        ingredientList.add("chicken")
        ingredientList.add("beef")
        ingredientList.add("flour")
        ingredientList.add("egg")
        ingredientList.add("olive oil")

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }
}