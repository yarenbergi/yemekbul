package com.yarenbergi.yemekbul.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.recommender.Recommender

class RecipeOverviewAdapter(var recipe: RecipeInfo): RecyclerView.Adapter<RecipeOverviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_instructions,parent,false)
        return ViewHolder(view)
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingrList : MutableList<String> = ArrayList()
        for(item in recipe.extendedIngredients!!){
            ingrList.add(item.name)
        }
        if(recipe.image != null)
            ImageAdapter.setImage(recipe.image, holder.image)
        holder.title.text = recipe.title.toString()
        holder.desc.text = recipe.instructions
        for (ingredient in ingrList)
        holder.desc.text = holder.desc.text as String + "\n " +  ingredient

        var ingredientList = recipe?.extendedIngredients
        var ingredientIds : ArrayList<Int> = ArrayList()
        if (ingredientList != null) {
            for (ingredients in ingredientList){
                ingredientIds.add(ingredients.id)
            }
        }
        holder.likeButton.setOnClickListener {
            Recommender().like(ingredientIds)
        }
        holder.dislikeButton.setOnClickListener{
            Recommender().dislike(ingredientIds)
        }
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.recipesRowLayout1)
        val image = view.findViewById<ImageView>(R.id.recipeImageMain)
        val title = view.findViewById<TextView>(R.id.recipeTitleMain)
        val desc = view.findViewById<TextView>(R.id.recipeIngrMain)
        val likeButton: Button = view.findViewById(R.id.like_button)
        val dislikeButton: Button = view.findViewById(R.id.dislike_button)
    }
}