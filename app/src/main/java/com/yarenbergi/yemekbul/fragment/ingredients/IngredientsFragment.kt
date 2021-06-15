package com.yarenbergi.yemekbul.fragment.ingredients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.data.RecipeInfo

class IngredientsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ingredients, container, false)
        val id = arguments?.getString("id")
        var recipeInfo : RecipeInfo? = id?.let { Service.getRecipeInformation(it.toBigDecimal(),false) }
        val ingredients : RecyclerView = view.findViewById(R.id.ingredients_recylerview)
        //adapter ekleyip yazdır
        return view
    }

}