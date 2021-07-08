package com.yarenbergi.yemekbul.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.todkars.shimmer.ShimmerRecyclerView
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.RecyclerviewAdapter_Recipes
import com.yarenbergi.yemekbul.Service
import com.yarenbergi.yemekbul.activity.SearchResultActivity
import com.yarenbergi.yemekbul.api.com.spoonacular.DefaultApi
import com.yarenbergi.yemekbul.recommender.RecipePointDTO
import com.yarenbergi.yemekbul.recommender.Recommender
import kotlinx.android.synthetic.main.activity_search.view.*
import kotlinx.android.synthetic.main.fragment_recipes.view.*
import kotlinx.android.synthetic.main.recipes_bottom_sheet.*
import kotlinx.android.synthetic.main.recipes_bottom_sheet.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter

class RecipesFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)
        val recyclerView: ShimmerRecyclerView = view.findViewById(R.id.recycler_view)
        val recipes = Service.getRandomRecipes(true, "", 10.toBigDecimal())
        auth = Firebase.auth
        val currentUser = auth.currentUser
        val storage = Firebase.storage
        val storageRef = storage.reference

        //checking the user data
        var file = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .toString() + "/ingredients.csv"
        )
        var fileExists = file.exists()
        if (!fileExists) {
            //context?.resources?.openRawResource(R.raw.ingredients)?.copyTo(FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/ingredients.csv"))
            val islandRef =
                storageRef.child(currentUser?.email.toString() + "/" + "ingredients.csv")
            val localFile = File.createTempFile("ingredients", "csv")

            islandRef.getFile(file).addOnSuccessListener {

                // Local temp file has been created

            }.addOnFailureListener {

            }
            val writer = FileOutputStream(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString() + "/ingredients.csv"
            )
            FileWriter(file)

        }

        var orederedRecipes: List<RecipePointDTO> = ArrayList();
        if (recipes != null)
            orederedRecipes = Recommender().orderTheList(recipes)


        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = orederedRecipes?.let { RecyclerviewAdapter_Recipes(it) }
        //    view.recycler_view.showShimmer() //TODO: bu olunca yazdırmıyor!





        setHasOptionsMenu(true)

        view.recipes_fab.setOnClickListener {
            findNavController().navigate(R.id.action_recipesFragment_to_recipesBottomSheet)
            /*
            val bottomView = inflater.inflate(R.layout.recipes_bottom_sheet, container, false)
            bottomView.findViewById<Button>(R.id.apply_btn).setOnClickListener { println("lalalallalala") }
            println(bottomView.findViewById<Button>(R.id.apply_btn).isClickable)

             */
        }


        return view
    }

    //search part
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.recipes_menu, menu)

        val logout = menu.findItem(R.id.menu_logout)

        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                var intent = Intent(context, SearchResultActivity::class.java)
                intent.putExtra("result", DefaultApi().autocompleteRecipeSearch(query, 10.toBigDecimal()).toString())
                startActivity(intent,Bundle.EMPTY)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                println("Text Changed!")
                return false
            }
        })
    }

    private lateinit var auth: FirebaseAuth
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_logout -> {
                auth = Firebase.auth
                auth.signOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}