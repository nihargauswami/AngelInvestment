package com.example.angelinvestment.ui.Portfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.angelinvestment.R

class PendingDocsDtailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_docs_dtails)
        val button: ImageView = findViewById(R.id.Back_to_Pending_Docs)

        button.setOnClickListener {
            val i = Intent(this, PendingDocsActivity::class.java)
            startActivity(i)
        }

    }
}