package com.example.angelinvestment.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.angelinvestment.Model.UserModel
import com.example.angelinvestment.R
import com.example.angelinvestment.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {


    private lateinit var  auth: FirebaseAuth
    private lateinit var  Email : TextView
    private lateinit var  Password : TextView
    private lateinit var  Name : TextView
    private lateinit var  ConfirmPassword : TextView
    private lateinit var  MobileNumber : TextView
    private lateinit var  CompanyName : TextView
    private lateinit var  CurrentDesignation : TextView
    private lateinit var  PostalAddress : TextView
    private lateinit var  City : TextView
    private lateinit var  PinCode : TextView


    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize Firebase Auth
        auth = Firebase.auth
        database = Firebase.database.reference

        supportActionBar?.setTitle("Sign up")
        val SignupText : TextView = findViewById(R.id.login)


        SignupText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val Login : Button = findViewById(R.id.Login_From_SignUp)
        Login.setOnClickListener {
            performSignUp()
        }


    }
    private fun performSignUp() {

        Email = findViewById<EditText>(R.id.rectangle_2)
        Password= findViewById<EditText>(R.id.rectangle_3)
        Name= findViewById<EditText>(R.id.rectangle_1)
        ConfirmPassword= findViewById<EditText>(R.id.rectangle_4)
        MobileNumber= findViewById<EditText>(R.id.rectangle_5)
        CompanyName= findViewById<EditText>(R.id.rectangle_6)
        CurrentDesignation= findViewById<EditText>(R.id.rectangle_7)
        PostalAddress= findViewById<EditText>(R.id.rectangle_8)
        City= findViewById<EditText>(R.id.rectangle_9)
        PinCode= findViewById<EditText>(R.id.pin_code)



        if (Email.text.isEmpty() || Password.text.isEmpty()){
            Toast.makeText(this,"Please fill all fields", Toast.LENGTH_SHORT)
                .show()
            return
        }


        val inputEmail = Email.text.toString().trim()
        val inputPassword = Password.text.toString().trim()


        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // for user sign up
                    val user = auth.currentUser
                    auth.currentUser?.sendEmailVerification()
                        ?.addOnSuccessListener {
                            Toast.makeText(baseContext, "Please verify your Email!",
                                Toast.LENGTH_SHORT).show()

                        }
                        ?.addOnFailureListener{
                            Toast.makeText(this,"Please Enter Valid Email", Toast.LENGTH_SHORT).show()
                        }

                    updateUI(user)
                    saveData()
                    // Sign in success, update UI with the signed-in user's information
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }
            .addOnFailureListener {
                Toast.makeText(this,"error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT)
                    .show()
            }


    }

    private fun saveData() {
        var inputEmail : String = Email.text.toString().trim()
        var inputName : String= Name.text.toString().trim()
        var inputMobileNumber : String = MobileNumber.text.toString().trim()
        var inputCompanyName : String = CompanyName.text.toString().trim()
        var inputCurrentDesignation : String = CurrentDesignation.text.toString().trim()
        var inputPostalAddress : String = PostalAddress.text.toString().trim()
        var inputCity : String = City.text.toString().trim()
        var inputPinCode : String = PinCode.text.toString().trim()


        val user = UserModel(inputEmail,inputName,inputMobileNumber,inputCompanyName,inputCurrentDesignation,inputPostalAddress,inputCity,inputPinCode)


        val userID = FirebaseAuth.getInstance().currentUser!!.uid

        database.child("User").child(userID).setValue(user)


    }

    private fun updateUI(user: FirebaseUser?) {
        val j = Intent(this, LoginActivity::class.java)
        startActivity(j)

    }

}
