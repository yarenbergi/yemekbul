package com.yarenbergi.yemekbul.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecipeOverviewAdapter
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.database.AppDatabase


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