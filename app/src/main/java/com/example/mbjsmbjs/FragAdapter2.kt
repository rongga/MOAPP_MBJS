package com.example.mbjsmbjs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL
object ImageLoader{
    suspend fun loadImage(imageUrl: String): Bitmap? {
        val bmp: Bitmap? = null
        try{
            val url = URL(imageUrl)
            val stream = url.openStream()

            return BitmapFactory.decodeStream(stream)
        }catch (e: MalformedURLException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return bmp
    }
}

class FragAdapter2(private  val context: Context) :
    RecyclerView.Adapter<FragAdapter2.ViewHolder>() {

    var dataList = mutableListOf<DietData>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage : ImageView = itemView.findViewById(R.id.iv_itemOfFrag1)
        private val itemWorkoutName : TextView = itemView.findViewById(R.id.tv_itemOfFrag1_nameOfWorkout)

        fun bind(item : DietData){
            CoroutineScope(Dispatchers.Main).launch {
                val bitmap = withContext(Dispatchers.IO){
                    ImageLoader.loadImage(item.image)
                }
                itemImage.setImageBitmap(bitmap)
            }

            itemWorkoutName.setText(item.name)
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
