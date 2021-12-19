package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiDiseaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_disease)

        val nextBtn = findViewById<Button>(R.id.diseaseButton)
        val nextIntent = Intent(this, RegiStrengthenActivity::class.java)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
        }
    }
}