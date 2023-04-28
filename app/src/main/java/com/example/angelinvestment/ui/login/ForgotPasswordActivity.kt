package com.example.angelinvestment.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.angelinvestment.R
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var email : EditText
    private lateinit var submit : Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        supportActionBar?.setTitle("Forgot Password")

        email = findViewById(R.id.Reset_Password)
        submit = findViewById(R.id.Submit_Password)

        auth = FirebaseAuth.getInstance()

        submit.setOnClickListener {


            if (email.text.isEmpty()){
                Toast.makeText(this,"Please fill all field", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val Email = email.text.toString()
            auth.sendPasswordResetEmail(Email)
                .addOnCompleteListener(this) {task ->
                    if (task.isSuccessful){
                        Toast.makeText(baseContext, "Success",
                            Toast.LENGTH_SHORT).show()

                        val i = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
                        startActivity(i)
                    }else{
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }

                }

                .addOnFailureListener {
                    Toast.makeText(this,"Authentication failed. ${it.localizedMessage}",
                        Toast.LENGTH_SHORT).show()
                }


        }

    }

    }