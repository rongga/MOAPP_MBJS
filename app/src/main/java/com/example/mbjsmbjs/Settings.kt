package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        var backBtn : TextView = findViewById<TextView>(R.id.setting_back_btn)
        var logoutBtn : TextView = findViewById<TextView>(R.id.logout)
        var modifyInfoBtn : TextView = findViewById<TextView>(R.id.modify_info)

        backBtn.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        logoutBtn.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(getApplicationContext(), "안녕히가시고 항상 건강하세요!", Toast.LENGTH_SHORT).show();
        }
        modifyInfoBtn.setOnClickListener(){
            val intent = Intent(this, RegiAgeActivity::class.java)
            startActivity(intent)
        }
    }
}