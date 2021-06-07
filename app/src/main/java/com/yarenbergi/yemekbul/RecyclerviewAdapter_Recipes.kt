package com.yarenbergi.yemekbul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.data.AnalyzedRecipe
import com.yarenbergi.yemekbul.data.Recipe
import com.yarenbergi.yemekbul.data.RecipesItem

class RecyclerviewAdapter_Recipes(var recipeList:List<RecipesItem>): RecyclerView.Adapter<RecyclerviewAdapter_Recipes.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter_Recipes.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recipes_row_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerviewAdapter_Recipes.ViewHolder, position: Int) {
        holder.title.text=recipeList[position].title
        ImageAdapter.setImage(recipeList[position].image,holder.photo)
        holder.desc.text= recipeList[position].instructions
        holder.likes.text = recipeList[position].aggregateLikes.toString()
        holder.time.text = recipeList[position].readyInMinutes.toString()
        if(recipeList[position].vegan){
            holder.veganImage.visibility = View.VISIBLE
            holder.veganText.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val title=view.findViewById<TextView>(R.id.recipeTitle)
        val photo=view.findViewById<ImageView>(R.id.recipeImageView)
        val desc=view.findViewById<TextView>(R.id.description_textView)
        val likes=view.findViewById<TextView>(R.id.textView4)
        val time=view.findViewById<TextView>(R.id.textView5)
        val veganImage=view.findViewById<ImageView>(R.id.imageView5)
        val veganText=view.findViewById<TextView>(R.id.textView6)

    }
}