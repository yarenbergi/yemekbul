package com.yarenbergi.yemekbul.data.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.ChipGroup
import com.yarenbergi.yemekbul.R

class RecipesBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recipes_bottom_sheet, container, false)
        val applyButton : Button = view.findViewById(R.id.apply_btn)
        val dietType_chip : ChipGroup = view.findViewById(R.id.dietType_chipGroup)

        applyButton.setOnClickListener {
            println(dietType_chip.checkedChipIds)
        }
        return inflater.inflate(R.layout.recipes_bottom_sheet, container, false)
    }

}