package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View;

import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        var userId = findViewById<EditText>(R.id.et_login_id)
        var userPassWord = findViewById<EditText>(R.id.et_login_password)

        var loginBtn : Button = findViewById<Button>(R.id.btn_login_enter)
        var registerBtn : TextView = findViewById<TextView>(R.id.tv_login_regi)

        loginBtn.setOnClickListener(){
            val id = userId.text.toString()
            val pw = userPassWord.text.toString()

            // 파베에서 유저 있는지

            var t1 = Toast.makeText(this, "회원님 무병장수하세요!", Toast.LENGTH_SHORT)
            t1.show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        registerBtn.setOnClickListener(){

            val intentRegi = Intent(this,RegiActivity::class.java)
            startActivity(intentRegi)
        }

    }

}