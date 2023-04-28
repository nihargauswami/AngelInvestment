package com.example.angelinvestment.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.angelinvestment.MainActivity
import com.example.angelinvestment.R
import com.example.angelinvestment.ui.signup.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.setTitle("Login")


        auth = Firebase.auth

        val logintext: TextView = findViewById(R.id.don_t_have_)
        val forgotPasswordText: TextView = findViewById(R.id.forgot_password)

        logintext.setOnClickListener {
            val Intent = Intent(this, SignUpActivity::class.java)
            startActivity(Intent)

        }
        forgotPasswordText.setOnClickListener {
            val i = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(i)
        }
        val Login: Button = findViewById(R.id.Login_home)
        Login.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        // input from user
        val Email: EditText = findViewById(R.id.rectangle_4)
        val Password: EditText = findViewById(R.id.rectangle_5)

        // null check
        if (Email.text.isEmpty() || Password.text.isEmpty()) {
            Toast.makeText(this, "Please fill all field", Toast.LENGTH_SHORT)
                .show()
            return
        }
        val EmailInput = Email.text.toString()
        val inputPassword = Password.text.toString()

        auth.signInWithEmailAndPassword(EmailInput, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success
                    auth.currentUser
                    val verification = auth.currentUser?.isEmailVerified
                    if (verification == true){

                        Toast.makeText(
                            baseContext, "Success",
                            Toast.LENGTH_SHORT
                        ).show()

                    }

                    else{
                        Toast.makeText(this,"Please verify your Email", Toast.LENGTH_SHORT).show()
                    }

                    updateUI()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    baseContext, "Authentication failed. ${it.localizedMessage}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun updateUI() {
        val j = Intent(this, MainActivity::class.java)
        startActivity(j)
    }
//
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//          updateUI()
//        }
//    }
    }
