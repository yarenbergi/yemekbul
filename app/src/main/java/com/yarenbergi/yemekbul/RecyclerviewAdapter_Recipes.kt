package com.yarenbergi.yemekbul

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.ImageAdapter
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
        if(recipeList[position].image != null){
            ImageAdapter.setImage(recipeList[position].image,holder.photo)
        }
        holder.desc.text= recipeList[position].instructions
        holder.likes.text = recipeList[position].aggregateLikes.toString()
        holder.time.text = recipeList[position].readyInMinutes.toString()
        if(recipeList[position].vegan){
            holder.veganImage.visibility = View.VISIBLE
            holder.veganText.visibility = View.VISIBLE
        }
        holder.layout.setOnClickListener {
            var intent = Intent(holder.layout.context, MenuItemActivity::class.java)
            intent.putExtra("id", recipeList[position].id.toString())
            startActivity(holder.layout.context,intent,Bundle.EMPTY)
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
    }
}