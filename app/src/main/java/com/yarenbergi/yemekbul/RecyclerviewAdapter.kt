package com.yarenbergi.yemekbul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.data.AnalyzedRecipe
import com.yarenbergi.yemekbul.data.Recipe

class RecyclerviewAdapter(var recipeList:List<AnalyzedRecipe>): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recipes_row_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
        holder.title.text=recipeList[position].name
        holder.desc.text= recipeList[position].steps.toString()    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val title=view.findViewById<TextView>(R.id.recipeTitle)
        val desc=view.findViewById<TextView>(R.id.description_textView)
    }
}