package com.yarenbergi.yemekbul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service
import kotlinx.android.synthetic.main.deneme.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.yarenbergi.yemekbul.RecyclerviewAdapter

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipes_row_layout)

        val analyzedRecipe = Service.getAnalyzedRecipeInstructions(324694.toBigDecimal(), true)
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter= RecyclerviewAdapter(analyzedRecipe)
    }
}