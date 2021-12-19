package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiWeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_weight)

        val nextBtn = findViewById<Button>(R.id.weightButton)
        val nextIntent = Intent(this, RegiDiseaseActivity::class.java)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
        }
    }
}