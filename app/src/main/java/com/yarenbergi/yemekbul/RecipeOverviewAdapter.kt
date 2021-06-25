package com.yarenbergi.yemekbul

import android.content.Intent
import android.content.SharedPreferences
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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.fragment.RecipesFragment
import com.yarenbergi.yemekbul.recommender.Recommender

class RecipeOverviewAdapter(var recipe: RecipeInfo): RecyclerView.Adapter<RecipeOverviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeOverviewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_instructions,parent,false)
        return ViewHolder(view)
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: RecipeOverviewAdapter.ViewHolder, position: Int) {
        val ingrList : MutableList<String> = ArrayList()
        for(item in recipe.extendedIngredients!!){
            ingrList.add(item.name)
        }
        ImageAdapter.setImage(recipe.image, holder.image)
        holder.title.text = recipe.title.toString()
        holder.ingr.adapter = IngredientListAdapter(ingrList)
        holder.desc.text = recipe.instructions
        /*
        ingredientIds[0] = 12061
        ingredientIds[1] = 10014534
         */
        var ingredientList = recipe?.extendedIngredients
        var ingredientIds : ArrayList<Int> = ArrayList()
        if (ingredientList != null) {
            for (ingredients in ingredientList){
                ingredientIds.add(ingredients.id)
            }
        }
        var point = 0
        holder.likeButton.setOnClickListener {
            Recommender().like(ingredientIds)
        }
        holder.dislikeButton.setOnClickListener{
            Recommender().dislike(ingredientIds)
        }
        //recipeInfo.extendedIngredients.get(0).id

    }

    override fun getItemCount(): Int = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.recipesRowLayout1)
        val image = view.findViewById<ImageView>(R.id.recipeImageMain)
        val title = view.findViewById<TextView>(R.id.recipeTitleMain)
        val ingr = view.findViewById<ShimmerRecyclerView>(R.id.recipeDescMain)
        val desc = view.findViewById<TextView>(R.id.recipeIngrMain)
        val likeButton: Button = view.findViewById(R.id.like_button)
        val dislikeButton: Button = view.findViewById(R.id.dislike_button)
    }
}