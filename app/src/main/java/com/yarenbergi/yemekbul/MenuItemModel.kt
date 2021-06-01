package com.yarenbergi.yemekbul

import android.util.Log
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yarenbergi.yemekbul.data.MenuItems

class MenuItemModel : ViewModel() {
    fun getMenuItem(){
        lateinit var recipeService: RecipeService
        lateinit var menuItemList: MenuItems
        recipeService = ApiClient.getClient().create(RecipeService::class.java)
        var post = recipeService.getMenuItem()

        post.enqueue(object : Callback<MenuItems> {
            override fun onFailure(call: Call<MenuItems>, t: Throwable) {

                Log.d("-----------------: ", t.message.toString())
               // Toast.makeText(, t.message.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MenuItems>, response: Response<MenuItems>) {
                if (response.isSuccessful) {
                    menuItemList = (response.body())!!

                    Log.d("DENEMEEEEEEEEE : -----", menuItemList.toString())
                } else {
                    Log.d("ssssssssssssssssssss", response.message())
                }
            }

        })
    }
}