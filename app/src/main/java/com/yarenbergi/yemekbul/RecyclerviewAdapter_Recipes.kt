package com.yarenbergi.yemekbul

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.RecipesItem
import com.yarenbergi.yemekbul.recommender.RecipePointDTO

class RecyclerviewAdapter_Recipes(var recipeList:List<RecipePointDTO>): RecyclerView.Adapter<RecyclerviewAdapter_Recipes.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter_Recipes.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recipes_row_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerviewAdapter_Recipes.ViewHolder, position: Int) {
        holder.title.text=recipeList[position].recipe.title
        if(recipeList[position].recipe.image != null){
            ImageAdapter.setImage(recipeList[position].recipe.image,holder.photo)
        }
        holder.desc.text= recipeList[position].recipe.instructions
        holder.likes.text = recipeList[position].recipe.aggregateLikes.toString()
        holder.time.text = recipeList[position].recipe.readyInMinutes.toString()
        holder.point.text = recipeList[position].point.toString();
        holder.point.visibility = View.VISIBLE;
        if(recipeList[position].recipe.vegan){
            holder.veganImage.visibility = View.VISIBLE
            holder.veganText.visibility = View.VISIBLE
        }
        holder.layout.setOnClickListener {
            var intent = Intent(holder.layout.context, MenuItemActivity::class.java)
            intent.putExtra("id", recipeList[position].recipe.id.toString())
            startActivity(holder.layout.context,intent,Bundle.EMPTY)
        }
        holder.star.setOnClickListener {
            holder.star.setImageResource(R.drawable.ic_star)
        }
    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.constraintLayout)
        val title=view.findViewById<TextView>(R.id.recipeTitle)
        val photo=view.findViewById<ImageView>(R.id.recipeImageView)
        val desc=view.findViewById<TextView>(R.id.description_textView)
        val likes=view.findViewById<TextView>(R.id.textView4)
        val time=view.findViewById<TextView>(R.id.textView5)
        val veganImage=view.findViewById<ImageView>(R.id.imageView5)
        val veganText=view.findViewById<TextView>(R.id.textView6)
        val point = view.findViewById<TextView>(R.id.textView7)
        val star = view.findViewById<ImageView>(R.id.starButton)
    }
}