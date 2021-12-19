package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiAgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_age)

        val nextBtn = findViewById<Button>(R.id.ageButton)
        val nextIntent = Intent(this, RegiHeightActivity::class.java)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
        }
    }
}