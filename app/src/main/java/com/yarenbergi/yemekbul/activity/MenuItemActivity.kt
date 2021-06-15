package com.yarenbergi.yemekbul.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yarenbergi.yemekbul.R
import com.yarenbergi.yemekbul.adapter.PagerAdapter
import com.yarenbergi.yemekbul.fragment.ingredients.IngredientsFragment
import com.yarenbergi.yemekbul.fragment.instructions.InstructionsFragment
import com.yarenbergi.yemekbul.fragment.overview.OverviewFragment
import kotlinx.android.synthetic.main.activity_menu_item.*


class MenuItemActivity : AppCompatActivity() {

    //private val args by navArgs<MenuItemActivity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)

        val fragments = ArrayList<Fragment>()
        fragments.add(OverviewFragment())
        fragments.add(IngredientsFragment())
        fragments.add(InstructionsFragment())

        val titles = ArrayList<String>()
        titles.add("Overview")
        titles.add("Ingredients")
        titles.add("Instructions")

        val resultBundle = Bundle()
        //resultBundle.putParcelable("recipeBundle", args.result)

        val adapter = PagerAdapter(
            resultBundle,
            fragments,
            titles,
            supportFragmentManager
        )

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        val id = intent.getStringExtra("id")
        val bundle = Bundle()
        bundle.putString("id", id.toString())
    /*    val id = intent.getStringExtra("id")
        val list: ArrayList<String> = ArrayList<String>()
        var text: TextView = findViewById(R.id.recipeTitleTextView)
        var image: ImageView = findViewById(R.id.recipeImage)
        var ingredients: TextView = findViewById(R.id.ingredientsList)
        var desc: TextView = findViewById(R.id.recipeDescription)
        if (id != null) {
            var recipeInfo : RecipeInfo = Service.getRecipeInformation(id.toBigDecimal(),false)
            text.text = recipeInfo.title
            ImageAdapter.setImage(recipeInfo.image, image)
            for(item in recipeInfo.extendedIngredients!!){
                list.add(item.originalName.toString())
            }
            ingredients.text = list.toString()
            desc.text = recipeInfo.instructions
        }

     */

    }


}