package com.pupup.leavehomework

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text
import javax.xml.transform.Transformer
import kotlin.math.log

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val get_username : TextView = findViewById(R.id.get_username) // username get welcome.xml
        val name = intent.extras?.getString("name") // name get Registration.xml
        val username01 = intent.extras?.getString("username01") // username get from Registration.xml
        val name01 = intent.extras?.getString("name01")
        val email = intent.extras?.getString("email")
        val phone = intent.extras?.getString("phone")
        val gender  = intent.extras?.getString("gender")
        val male = intent.extras?.getString("male")
        val female = intent.extras?.getString("female")
        if (name != null) {
            if(!name.isEmpty()){
                    get_username.text=name
            }
        }
        val username = intent.extras?.getString("username")


        if (username != null) {
            if (!username.isEmpty()){
                get_username.text=username
            }
        }
//        Logout section start from here
        val logout : Button = findViewById(R.id.logout)
        logout.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
//        View profile Details here
        val show_profile : Button = findViewById(R.id.profile_show)
        show_profile.setOnClickListener {
            val layout = LayoutInflater.from(this).inflate(R.layout.custome_dialog,null,false)
            val ok_btn : Button = layout.findViewById(R.id.ok_btn)
            val username001 : EditText = layout.findViewById(R.id.username001)
            username001.setText(username01)
            val name : EditText = layout.findViewById(R.id.c_name)
            name.setText(name01)
            val email01 : EditText = layout.findViewById(R.id.email)
            email01.setText(email)
            val phone01 : EditText = layout.findViewById(R.id.phone)
            phone01.setText(phone)
            val gender01 : TextView = layout.findViewById(R.id.gender)
            if (!male.toString().isEmpty()){
                gender01.setText(male)
            }
            else if (female != null) {
                if (!female.isEmpty()){
                    gender01.setText(female)
                }
            }
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(layout)
            val dialog = alertDialog.create()
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            dialog.window?.setLayout(880,1390)
            ok_btn.setOnClickListener {
                dialog.cancel()
                Toast.makeText(this, "Ok Quits this dialog!!", Toast.LENGTH_SHORT).show()
            }
        }
//        bottom_sheet start here
        val more_vert : ImageView = findViewById(R.id.more_vert)
        more_vert.setOnClickListener {
            val layout = LayoutInflater.from(this).inflate(R.layout.bottom_sheet,null,false)
            val bottom_name : TextView = layout.findViewById(R.id.bottom_name)
            bottom_name.setText(name01)
            val bottom_phone : TextView = layout.findViewById(R.id.bottom_phone)
            bottom_phone.setText(phone)
            val bottom_email : TextView = layout.findViewById(R.id.bottom_email)
            bottom_email.setText(email)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(layout)
            dialog.show()
        }
    }
}