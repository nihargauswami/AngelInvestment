package com.example.angelinvestment.ui.Portfolio

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.BottomSheetAdapter
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.Model.BottomSheetModel
import com.example.angelinvestment.R
import java.util.Locale


private var bottomsheetList = ArrayList<BottomSheetModel>()
val adapter =  BottomSheetAdapter(bottomsheetList)
lateinit var searchView: android.widget.SearchView
class TextandOtherDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textand_other_details)


        val button : ImageView = findViewById(R.id.imageView7)
        button.setOnClickListener {
//                        onClick()
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)
        }
        searchView = findViewById(R.id.searchView)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_text_Other_details)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        addData()

        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener,OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              filterList(newText)
                return true
            }

        })

    }

    private fun filterList(query : String?){
        if(query != null){
            val filterList  = ArrayList<BottomSheetModel>()
            for (i in bottomsheetList){
                if(i.tvName.toLowerCase(Locale.ROOT).contains(query)){
                    filterList.add(i)
                }
            }
            if(filterList.isEmpty()){
                Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show()
            }
            else{
                adapter.filterList(filterList)
            }
        }


    }
    private fun addData() {
        bottomsheetList.add(BottomSheetModel("Nihar",R.drawable.ellipse_38,"5","20,140","100,700","Self"))
        bottomsheetList.add(BottomSheetModel("Divyesh",R.drawable.ellipse_38,"2","30,201","60,420","Direct"))
        bottomsheetList.add(BottomSheetModel("Ashish",R.drawable.ellipse_38,"1","40,210","40,210","Direct"))
        bottomsheetList.add(BottomSheetModel("Nirav",R.drawable.ellipse_38,"10","50,000","5,00,000","Self"))
        bottomsheetList.add(BottomSheetModel("chirag",R.drawable.ellipse_38,"52","12,200","634,400","Self"))
        bottomsheetList.add(BottomSheetModel("kishan",R.drawable.ellipse_38,"15","20,000","3,00,000","Direct"))
        bottomsheetList.add(BottomSheetModel("jay",R.drawable.ellipse_38,"35","30,123","1,054,305","Self"))
        bottomsheetList.add(BottomSheetModel("akash",R.drawable.ellipse_38,"5","30,213","151,065","Self"))
        bottomsheetList.add(BottomSheetModel("gaurav",R.drawable.ellipse_38,"15","20,230","303,230","Direct"))
    }


}