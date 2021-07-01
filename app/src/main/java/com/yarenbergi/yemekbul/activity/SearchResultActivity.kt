package com.yarenbergi.yemekbul.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yarenbergi.yemekbul.R

class SearchResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        val result = intent.getStringExtra("result")
        val text = findViewById<TextView>(R.id.search_result)
        text.text = result
    }
}