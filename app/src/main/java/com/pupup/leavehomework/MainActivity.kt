package com.pupup.leavehomework

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login : Button =findViewById(R.id.login_btn)
        val username :EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)

        login.setOnClickListener {
            val intent = Intent(this,WelcomeActivity::class.java)
            intent.putExtra("username",username.text.toString())
            intent.putExtra("passwrod",password.text.toString())
            startActivity(intent)
        }
        val registration_here : TextView = findViewById(R.id.register_here)
        registration_here.setOnClickListener {
            startActivity(Intent(this,RegisterationActivity::class.java))
        }
    }
}