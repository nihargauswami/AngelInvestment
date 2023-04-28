package com.example.angelinvestment.ui.StartUp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelinvestment.Adapter.InvestmentAdapter
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.R
import com.example.angelinvestment.ui.login.LoginActivity

class TestActivity : AppCompatActivity(),InvestmentAdapter.MyClickListener{

    lateinit var  imageView : ImageView
//    private lateinit var Adapter: InvestmentAdapter
    private var titleList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

//        val imageView : ImageView = findViewById(R.id.view5)

        postToList()

        val Adapter =  InvestmentAdapter(titleList,imageList,this@TestActivity)
        var recyclerView = RecyclerView(this)
        recyclerView = findViewById(R.id.rv_RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Adapter

        imageView = findViewById(R.id.view5)
        imageView.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)


        }
//        cardView = findViewById(R.id.imageView6)
//        cardView.setOnClickListener {
//            onClick(cardView)
//        }

    }
    private fun addToList(title:String,image:Int){
        titleList.add(title)
        imageList.add(image)
    }
    private fun postToList(){
        for(i in 0..10){
            addToList("MERCEDES $i",R.drawable.photo)
        }
    }
//    private fun onClick(v : View){
//         if (v.id == R.id.imageView6){
//        supportFragmentManager.beginTransaction().replace(R.id.TestActivity,MercedesFragment()).commit()
//        imageView.visibility = GONE;
//
//    }



    override fun onClick(position: Int) {
        when(position){
            0 -> startActivity(Intent(this,InvestmentActivity::class.java))
            1 -> startActivity(Intent(this,InvestmentActivity::class.java))
            2 -> startActivity(Intent(this,InvestmentActivity::class.java))
            3 -> startActivity(Intent(this,InvestmentActivity::class.java))
            4 -> startActivity(Intent(this,InvestmentActivity::class.java))
            5 -> startActivity(Intent(this,InvestmentActivity::class.java))
            6 -> startActivity(Intent(this,InvestmentActivity::class.java))
            7 -> startActivity(Intent(this,InvestmentActivity::class.java))
            8 -> startActivity(Intent(this,InvestmentActivity::class.java))
            9 -> startActivity(Intent(this,InvestmentActivity::class.java))

        }
    }


}


