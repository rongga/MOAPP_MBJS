package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiHeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_height)

        val nextBtn = findViewById<Button>(R.id.heightButton)
        val nextIntent = Intent(this, RegiWeightActivity::class.java)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
        }
    }
}