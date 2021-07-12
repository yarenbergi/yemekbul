package com.yarenbergi.yemekbul.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.core.view.get
import com.yarenbergi.yemekbul.R
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.FileInputStream

class FridgeIngredientsActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    lateinit var searchView: SearchView
    lateinit var mList: ListView
    val ingredientList: MutableList<String> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_fridge)
        //FridgeFragment()

        val csvParser = CSVParser(
            FileInputStream(
                Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS
                ).toString() + "/ingredients.csv"
            ).bufferedReader(), CSVFormat.DEFAULT
        );

        for (csvRecord in csvParser) {
            ingredientList.add(csvRecord.get(0).toString())
            //val id = csvRecord.get(1).toInt()
        }
        csvParser.close()

        searchView = findViewById(R.id.search_bar)
        mList = findViewById(R.id.search_list)
        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            ingredientList
        )
        mList.setAdapter(adapter)
        mList.setTextFilterEnabled(true)
        mList.setOnItemClickListener {
                parent, view, position, id ->
            println(parent.get(id.toInt()));
            println(view);
            println(position);
            println(id); }
        setupSearch()
        //TODO setOnclick


    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun setupSearch() {
        searchView.setIconifiedByDefault(false)
        searchView.setOnQueryTextListener(this)
        searchView.setSubmitButtonEnabled(true)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        //save it to fridge db
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (TextUtils.isEmpty(newText))
            mList.clearTextFilter()
        else
            mList.setFilterText(newText)

        return true
    }


}