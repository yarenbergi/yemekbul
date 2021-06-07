package com.yarenbergi.yemekbul.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service
import kotlinx.android.synthetic.main.deneme.*
import kotlinx.android.synthetic.main.recipes_row_layout.view.*


class recipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.deneme, container, false)
   //     val recyclerView : RecyclerView = view.findViewById(R.id.recyclerview)


   //     val analyzedRecipe = Service.getAnalyzedRecipeInstructions(324694.toBigDecimal(), true)

   //     recyclerView.layoutManager= LinearLayoutManager(context)
   //     recyclerView.adapter= RecyclerviewAdapter(analyzedRecipe)
    /*    val analyzedRecipe = Service.getAnalyzedRecipeInstructions(324694.toBigDecimal(), true)
        view.recipeTitle.setText(analyzedRecipe[1].name)
        Service.setImage("https://spoonacular.com/cdn/ingredients_100x100/white-powder.jpg", view.recipeImageView)
        view.description_textView.setText(analyzedRecipe[1].steps?.get(0)?.equipment?.get(0)?.name)*/
        return view
    }


}