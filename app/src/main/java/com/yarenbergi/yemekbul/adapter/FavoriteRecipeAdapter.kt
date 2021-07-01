package com.yarenbergi.yemekbul.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.data.favorites.favoriteRecipes
import com.yarenbergi.yemekbul.fragment.FavoriteRecipesFragment

class FavoriteRecipeAdapter(var recipeList: MutableList<RecipeInfo>): RecyclerView.Adapter<FavoriteRecipeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteRecipeAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.favorite_recipes_row_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteRecipeAdapter.ViewHolder, position: Int) {
        ImageAdapter.setImage(recipeList[position].image.toString(), holder.imageView)
        holder.title.text = recipeList[position].title.toString()
        holder.desc.text = recipeList[position].instructions.toString()
    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.constraintLayoutForFavoriteRecipes)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView2)
        val title = view.findViewById<TextView>(R.id.recipeTitle2)
        val desc = view.findViewById<TextView>(R.id.description_textView2)
    }
}