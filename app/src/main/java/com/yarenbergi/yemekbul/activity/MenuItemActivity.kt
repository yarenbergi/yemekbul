package com.yarenbergi.yemekbul.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecipeOverviewAdapter
import com.yarenbergi.yemekbul.RecyclerviewAdapter_Recipes
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.fragment.recipeFragment
import com.yarenbergi.yemekbul.recommender.Recommender
import kotlinx.android.synthetic.main.activity_menu_item.*
import kotlinx.android.synthetic.main.fragment_overview.*
import kotlinx.android.synthetic.main.placeholder_row_layout.*


class MenuItemActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)
        val recyclerView : ShimmerRecyclerView = findViewById(R.id.recycler_view_ingredients2)

        val id = intent.getStringExtra("id")
        val recipe = id?.let { Service.getRecipeInformation(it.toBigDecimal(), false) }

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= recipe?.let { RecipeOverviewAdapter(it) }

    /*    val id = intent.getStringExtra("id")
        val list: ArrayList<String> = ArrayList<String>()
        var text: TextView = findViewById(R.id.recipeTitleTextView)
        var image: ImageView = findViewById(R.id.recipeImage)
        var ingredients: TextView = findViewById(R.id.ingredientsList)
        var desc: TextView = findViewById(R.id.recipeDescription)
        if (id != null) {
            var recipeInfo : RecipeInfo = Service.getRecipeInformation(id.toBigDecimal(),false)
            text.text = recipeInfo.title
            ImageAdapter.setImage(recipeInfo.image, image)
            for(item in recipeInfo.extendedIngredients!!){
                list.add(item.originalName.toString())
            }
            ingredients.text = list.toString()
            desc.text = recipeInfo.instructions
        }

     */

    }


}