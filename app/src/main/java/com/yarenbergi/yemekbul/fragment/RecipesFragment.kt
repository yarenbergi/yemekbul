package com.yarenbergi.yemekbul.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecyclerviewAdapter_Recipes
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.recommender.RecipePointDTO
import com.yarenbergi.yemekbul.recommender.Recommender
import kotlinx.android.synthetic.main.fragment_recipes.view.*
import java.io.*

class RecipesFragment : Fragment(), SearchView.OnQueryTextListener {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        val recyclerView : ShimmerRecyclerView = view.findViewById(R.id.recycler_view)
        val recipes = Service.getRandomRecipes(true, "",10.toBigDecimal())

        //checking the user data
        var file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv")
        var fileExists = file.exists()
        if(!fileExists){
            context?.resources?.openRawResource(R.raw.ingredients)?.copyTo(FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv"))
        }



        //recipes[0].extendedIngredients[0].id

        //testing the recommender: ingredient likes
/*
        val ingredientIds : ArrayList<Int> = ArrayList()

        for (ingredient in recipes!![0].extendedIngredients!!){
            ingredientIds.add(ingredient.id)
        }
        Recommender().like(ingredientIds)
 */
        var orederedRecipes: List<RecipePointDTO> = ArrayList();
        if(recipes != null)
            orederedRecipes=Recommender().orderTheList(recipes)


        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter= orederedRecipes?.let { RecyclerviewAdapter_Recipes(it) }
    //    view.recycler_view.showShimmer() //TODO: bu olunca yazdırmıyor!

        setHasOptionsMenu(true)


        view.recipes_fab.setOnClickListener {
            findNavController().navigate(R.id.action_recipesFragment_to_recipesBottomSheet)
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.recipes_menu, menu)

        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }
}