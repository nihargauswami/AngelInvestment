package com.example.angelinvestment.ui.Agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.R

class AgendaDetailsActivity : AppCompatActivity() {
    private lateinit var button : ImageView
    private lateinit var sendText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_details)


        val backButton : ImageView = findViewById(R.id.Back_Button_Agenda)
        backButton.setOnClickListener {
            val  i = Intent(this , MainActivity::class.java)
            startActivity(i)
        }

        button = findViewById(R.id.Add_Comment)
        sendText = findViewById(R.id.Text_Comment_Agenda)

        button.setOnClickListener {
            val fragment = AgendaCommentFragment()

            val bundle = Bundle()

            bundle.putString("string",sendText.text.toString())
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.Frame_Layout , fragment).commit()
        }

    }
}