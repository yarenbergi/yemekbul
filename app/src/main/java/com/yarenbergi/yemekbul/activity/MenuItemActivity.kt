package com.yarenbergi.yemekbul.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.adapter.RecipeOverviewAdapter
import com.yarenbergi.yemekbul.service.Service


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

    }


}