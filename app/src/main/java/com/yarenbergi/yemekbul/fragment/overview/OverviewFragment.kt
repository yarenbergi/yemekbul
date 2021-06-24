package com.yarenbergi.yemekbul.fragment.overview

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.recommender.Recommender

class OverviewFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val image : ImageView = view.findViewById(R.id.main_imageView)
        val title : TextView = view.findViewById(R.id.title_textView)
        val summary : TextView = view.findViewById(R.id.summary_textView)
        val id = arguments?.getString("id")
        var recipeInfo : RecipeInfo? = id?.let { Service.getRecipeInformation(it.toBigDecimal(),false) }
        var ingredientList = recipeInfo?.extendedIngredients
        //functionality of like and dislike
        val likeButton: Button = view.findViewById(R.id.like_button)
        val dislikeButton: Button = view.findViewById(R.id.dislike_button)
        var ingredientIds : ArrayList<Int> = ArrayList()
        println(recipeInfo)
        if (ingredientList != null) {
            for (ingredients in ingredientList){
                ingredientIds.add(ingredients.id)
            }
        }
        /*
        ingredientIds[0] = 12061
        ingredientIds[1] = 10014534
         */

        likeButton.setOnClickListener(View.OnClickListener { context?.resources?.let { Recommender().like(ingredientIds) } })
        dislikeButton.setOnClickListener(View.OnClickListener { context?.resources?.let { Recommender().dislike(ingredientIds) } })
//recipeInfo.extendedIngredients.get(0).id

        if (recipeInfo != null) {
            println(recipeInfo.title)
        }
        if (recipeInfo != null) {
            ImageAdapter.setImage(recipeInfo.image,image)
            title.text = recipeInfo.title
            summary.text = recipeInfo.instructions
            println(recipeInfo.title)
        }
        return view
    }

}