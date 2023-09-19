package com.pupup.leavehomework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class RegisterationActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        val register: Button = findViewById(R.id.register)
        val name : EditText = findViewById(R.id.name)
        val username : EditText = findViewById(R.id.username)
        val name01 : EditText = findViewById(R.id.name)
        val email : EditText = findViewById(R.id.r_email)
        val phone : EditText = findViewById(R.id.r_phone)
        val gender : RadioGroup = findViewById(R.id.r_gender)
        val male : RadioButton  = findViewById(R.id.male)
        val female : RadioButton = findViewById(R.id.female)


        register.setOnClickListener {
            val intent = Intent(this,WelcomeActivity::class.java)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("username01",username.text.toString())
            intent.putExtra("name01",name01.text.toString())
            intent.putExtra("email",email.text.toString())
            intent.putExtra("phone",phone.text.toString())
//            intent.putExtra("gender",gender..toString())
            intent.putExtra("male",male.text.toString())
            intent.putExtra("female",female.text.toString())

            startActivity(intent)
        }
    }
}