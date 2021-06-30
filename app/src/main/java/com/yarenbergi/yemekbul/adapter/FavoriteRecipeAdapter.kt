package com.yarenbergi.yemekbul.adapter

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecipeOverviewAdapter
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.data.RecipesItem
import com.yarenbergi.yemekbul.recommender.RecipePointDTO
import com.yarenbergi.yemekbul.recommender.Recommender

class FavoriteRecipeAdapter(var recipe: RecipeInfo): RecyclerView.Adapter<FavoriteRecipeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteRecipeAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.favorite_recipes_row_layout,parent,false)
        return ViewHolder(view)
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: FavoriteRecipeAdapter.ViewHolder, position: Int) {

        holder.title.text = recipe.title.toString()
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.constraintLayoutForFavoriteRecipes)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView2)
        val title = view.findViewById<TextView>(R.id.recipeTitle2)
        val desc = view.findViewById<TextView>(R.id.description_textView2)
    }
}