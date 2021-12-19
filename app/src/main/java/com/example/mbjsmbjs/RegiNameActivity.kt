package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_name)

        val nextBtn = findViewById<Button>(R.id.nameButton)
        val nextIntent = Intent(this, RegiAgeActivity::class.java)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
        }
    }
}