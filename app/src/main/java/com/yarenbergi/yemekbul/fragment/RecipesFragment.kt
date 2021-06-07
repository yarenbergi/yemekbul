package com.yarenbergi.yemekbul.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecyclerviewAdapter_Recipes
import com.yarenbergi.yemekbul.Service
import kotlinx.android.synthetic.main.fragment_recipes.view.*

class RecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        val recyclerView : ShimmerRecyclerView = view.findViewById(R.id.recycler_view)

        val recipes = Service.getRandomRecipes(true, "",10.toBigDecimal())
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter= recipes?.let { RecyclerviewAdapter_Recipes(it) }

    //    view.recycler_view.showShimmer() //TODO: bu olunca yazdırmıyor!

        return view
    }

}