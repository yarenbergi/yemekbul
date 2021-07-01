package com.yarenbergi.yemekbul

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yarenbergi.yemekbul.activity.MenuItemActivity
import com.yarenbergi.yemekbul.adapter.FavoriteRecipeAdapter
import com.yarenbergi.yemekbul.adapter.ImageAdapter
import com.yarenbergi.yemekbul.data.favorites.favoriteRecipes
import com.yarenbergi.yemekbul.database.AppDatabase
import com.yarenbergi.yemekbul.fragment.FavoriteRecipesFragment
import com.yarenbergi.yemekbul.recommender.RecipePointDTO
import kotlin.reflect.jvm.isAccessible

class RecyclerviewAdapter_Recipes(var recipeList:List<RecipePointDTO>): RecyclerView.Adapter<RecyclerviewAdapter_Recipes.ViewHolder>() {
    lateinit var auth: FirebaseAuth
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter_Recipes.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recipes_row_layout,parent,false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerviewAdapter_Recipes.ViewHolder, position: Int) {
        holder.title.text=recipeList[position].recipe.title
        if(recipeList[position].recipe.image != null){
            ImageAdapter.setImage(recipeList[position].recipe.image,holder.photo)
        }
        holder.desc.text= recipeList[position].recipe.instructions
        holder.likes.text = recipeList[position].recipe.aggregateLikes.toString()
        holder.time.text = recipeList[position].recipe.readyInMinutes.toString()
        holder.point.text = recipeList[position].point.toString();
        holder.point.visibility = View.VISIBLE;
        if(recipeList[position].recipe.vegan){
            holder.veganImage.visibility = View.VISIBLE
            holder.veganText.visibility = View.VISIBLE
        }
        holder.layout.setOnClickListener {
            var intent = Intent(holder.layout.context, MenuItemActivity::class.java)
            intent.putExtra("id", recipeList[position].recipe.id.toString())
            startActivity(holder.layout.context,intent,Bundle.EMPTY)
        }
        val fragment = FavoriteRecipesFragment()
        auth = Firebase.auth
        val currentUser = auth.currentUser
        fragment.favoritesdb = Room.databaseBuilder(holder.layout.context, AppDatabase::class.java, "myfavdb")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
        if (currentUser != null) {
            if(fragment.favoritesdb.favorite_dao().isFavorite(currentUser.uid,recipeList[position].recipe.id.toString()) == 1){
                holder.star.setImageResource(R.drawable.ic_star)
            }
            else{
                holder.star.setImageResource(R.drawable.ic_star_border)
            }
        }
        holder.star.setOnClickListener {
            auth = Firebase.auth
            val currentUser = auth.currentUser
            val favoriteList = favoriteRecipes()
            if (currentUser != null) {
                favoriteList.uid = currentUser.uid
            }
            favoriteList.recipe_id = recipeList[position].recipe.id.toString()
            //TODO : delete yapmıyor
            if (currentUser != null) {
                if(fragment.favoritesdb.favorite_dao().isFavorite(currentUser.uid,recipeList[position].recipe.id.toString()) != 1){
                    fragment.favoritesdb.favorite_dao().add(favoriteList)
                    holder.star.setImageResource(R.drawable.ic_star)
                } else{
                    holder.star.setImageResource(R.drawable.ic_star_border)
                    fragment.favoritesdb.favorite_dao().deleteByRecipeId(recipeList[position].recipe.id.toString())
                }
            }
        }
    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val layout=view.findViewById<ConstraintLayout>(R.id.constraintLayout)
        val title=view.findViewById<TextView>(R.id.recipeTitle)
        val photo=view.findViewById<ImageView>(R.id.recipeImageView)
        val desc=view.findViewById<TextView>(R.id.description_textView)
        val likes=view.findViewById<TextView>(R.id.textView4)
        val time=view.findViewById<TextView>(R.id.textView5)
        val veganImage=view.findViewById<ImageView>(R.id.imageView5)
        val veganText=view.findViewById<TextView>(R.id.textView6)
        val point = view.findViewById<TextView>(R.id.textView7)
        val star = view.findViewById<ImageView>(R.id.starButton)
    }
}