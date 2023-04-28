package com.example.angelinvestment.ui.StartUp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.angelinvestment.R

class InvestmentActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment)


        val imageView : ImageView = findViewById(R.id.backbutton_Investment)
      imageView.setOnClickListener {
          val i = Intent(this,TestActivity::class.java)
          startActivity(i)
      }

    }

}