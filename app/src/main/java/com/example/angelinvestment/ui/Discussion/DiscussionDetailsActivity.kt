package com.example.angelinvestment.ui.Discussion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.R

class DiscussionDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discussion_details)

    val imageButton  : ImageView = findViewById(R.id.Add_Comment_Discussion)
    val editText : EditText  = findViewById(R.id.Comment_Text_Discussion)
val button : ImageView = findViewById(R.id.back_to_Discussion)
        button.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        imageButton.setOnClickListener {
            val fragment = CommentDiscussionFragment()
            val bundle = Bundle()

            bundle.putString("String",editText.text.toString())
            fragment.arguments  = bundle
            supportFragmentManager.beginTransaction().replace(R.id.Frame_Layout_Discussion,fragment).commit()
        }

    }
}