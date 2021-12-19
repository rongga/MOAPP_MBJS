package com.example.mbjsmbjs

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_detail)

        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val ingredients = intent.getStringExtra("ingredients")
        val recipe = intent.getStringExtra("recipe")

        val imageView = findViewById<ImageView>(R.id.foodImageView)
        val nameView = findViewById<TextView>(R.id.foodName)
        val ingredientsView = findViewById<TextView>(R.id.ingredients)
        val recipeView = findViewById<TextView>(R.id.recipe)

        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = withContext(Dispatchers.IO){
                ImageLoader.loadImage(image!!)
            }
            imageView.setImageBitmap(bitmap)
        }

        nameView.setText(name)
        ingredientsView.setText(ingredients)
        recipeView.setText(recipe)

    }
}