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
        lateinit var menuItemList: MutableLiveData<LiveData<MenuItems>>
        recipeService = ApiClient.getClient().create(RecipeService::class.java)
        var post = recipeService.getMenuItem("1")

        post.enqueue(object : Callback<LiveData<MenuItems>> {
            override fun onFailure(call: Call<LiveData<MenuItems>>, t: Throwable) {
                Log.d("DENEME : ", "ERROR")
               // Toast.makeText(, t.message.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<LiveData<MenuItems>>, response: Response<LiveData<MenuItems>>) {

                if (response.isSuccessful) {
                    menuItemList = (response.body() as MutableLiveData<LiveData<MenuItems>>?)!!
                    Log.d("DENEMEEEEEEEEE : -----", response.body().toString())
                    menuItemList.postValue(response.body())
                }
            }

        })
    }
}