package com.yarenbergi.yemekbul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MenuItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)

        var menuItemModel = MenuItemModel()
        menuItemModel.getMenuItem()
        var text: TextView = findViewById(R.id.menuItemView) as TextView
        text.setText("asd")
    }


}