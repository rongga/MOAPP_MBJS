package com.example.mbjsmbjs

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL


class FragAdapter2(private val context: Context) :
    RecyclerView.Adapter<FragAdapter2.ViewHolder>() {

    var dataList = mutableListOf<DietData>()


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage : ImageButton = itemView.findViewById(R.id.foodImageButton)
        private val itemWorkoutName : TextView = itemView.findViewById(R.id.foodItemName)

        fun bind(item : DietData){
            CoroutineScope(Dispatchers.Main).launch {
                val bitmap = withContext(Dispatchers.IO){
                    ImageLoader.loadImage(item.image)
                }
                itemImage.setImageBitmap(bitmap)
            }

            itemWorkoutName.setText(item.name)

            val intent = Intent(context, FoodDetailActivity::class.java)
            intent.putExtra("image", item.image)
            intent.putExtra("name", item.name)
            intent.putExtra("ingredients", item.ingredient)
            intent.putExtra("recipe", item.recipe)

            itemImage.setOnClickListener{
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag2,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    override fun getItemCount(): Int = dataList.size
}
