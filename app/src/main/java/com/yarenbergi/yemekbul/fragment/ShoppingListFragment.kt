package com.yarenbergi.yemekbul.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yarenbergi.yemekbul.R
import kotlinx.android.synthetic.main.fragment_shopping_list.view.*

class ShoppingListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_shopping_list, container, false)
        return view
    }
}