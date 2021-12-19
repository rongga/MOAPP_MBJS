package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegiStrengthenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regi_strengthen)

        val nextBtn = findViewById<Button>(R.id.strengthenButton)
        val nextIntent = Intent(this, MainActivity::class.java)
        nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)

        nextBtn.setOnClickListener{
            startActivity(nextIntent)
            finish()
        }
    }
}