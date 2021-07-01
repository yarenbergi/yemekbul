package com.yarenbergi.yemekbul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
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

        val searchView : SearchView = findViewById(R.id.searchView)
        val listView : ListView = findViewById(R.id.search_list)
        val adapter : ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, ingredientList)

        mList.setAdapter(adapter)
        mList.isTextFilterEnabled()
        setupArama()
        

    }
    private fun setupArama(){
        searchView.isIconifiedByDefault(false)
        searchView.setOnQueryTextListener(this)
        searchView.isSubmitButtonEnabled(true)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(TextUtils.isEmpty(newText))
            mList.clearTextFilter()
        else
            mList.setFilterText(newText)

        return true
    }



}