package com.yarenbergi.yemekbul.fragment.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.data.RecipeInfo

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instructions, container, false)
        val inst : TextView = view.findViewById(R.id.instructions_textView)
        val id = arguments?.getString("id")
        var recipeInfo : RecipeInfo? = id?.let { Service.getRecipeInformation(it.toBigDecimal(),false) }

        if (recipeInfo != null) {
            inst.text = recipeInfo.instructions
        }
        return view
    }

}