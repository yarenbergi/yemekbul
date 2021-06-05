package com.yarenbergi.yemekbul

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageAdapter {
    @JvmStatic
    fun setImage(url:String, imageView:ImageView){
        Picasso.get().load(url).into(imageView)
    }

}