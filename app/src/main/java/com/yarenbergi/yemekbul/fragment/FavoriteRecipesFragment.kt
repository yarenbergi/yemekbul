package com.yarenbergi.yemekbul.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service

class FavoriteRecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Service.getRandomRecipes(true, "",3.toBigDecimal())
        return inflater.inflate(R.layout.fragment_favorite_recipes, container, false)
    }
}