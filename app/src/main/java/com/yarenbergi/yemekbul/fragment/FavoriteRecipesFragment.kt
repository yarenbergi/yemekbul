package com.yarenbergi.yemekbul.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.service.Service
import com.yarenbergi.yemekbul.adapter.FavoriteRecipeAdapter
import com.yarenbergi.yemekbul.data.RecipeInfo
import com.yarenbergi.yemekbul.database.AppDatabase


class FavoriteRecipesFragment : Fragment() {
    lateinit var favoritesdb : AppDatabase
    lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite_recipes, container, false)
        if(!::favoritesdb.isInitialized){
            favoritesdb = Room.databaseBuilder(requireActivity(), AppDatabase::class.java, "myfavdb")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
        val recyclerView : androidx.recyclerview.widget.RecyclerView = view.findViewById(R.id.favouriteRecipes_recyclerView)

        auth = Firebase.auth
        val currentUser = auth.currentUser
        val recipeList : MutableList<RecipeInfo> = ArrayList()
        if (currentUser != null) {
            if(::favoritesdb.isInitialized) {
                for (item in favoritesdb.favorite_dao().loadAllByIds(currentUser.uid.toString())) {
                    val recipe: RecipeInfo? = item.recipe_id?.let {
                        Service.getRecipeInformation(
                            it.toBigDecimal(),
                            false
                        )
                    }
                    if (recipe != null) {
                        recipeList.add(recipe)
                    }
                }
            }
        }
        recyclerView.layoutManager= LinearLayoutManager(this.context)
        recyclerView.adapter= FavoriteRecipeAdapter(recipeList)
        return view
    }
}