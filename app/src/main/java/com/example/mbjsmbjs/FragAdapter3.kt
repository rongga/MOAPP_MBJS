package com.example.mbjsmbjs

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragAdapter3(private  val context: Context) :
    RecyclerView.Adapter<FragAdapter3.ViewHolder>() {

    var dataList = mutableListOf<CommunityData>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage : ImageButton = itemView.findViewById(R.id.iv_itemOfFrag1)
        private val itemCommunityTitle : TextView = itemView.findViewById(R.id.tv_itemOfFrag3_title)
        private val itemCommunityDate : TextView = itemView.findViewById(R.id.tv_itemOfFrag3_date)
        private val itemCommunityName : TextView = itemView.findViewById(R.id.tv_itemOfFrag3_name)
        private val itemCommunityContent : TextView = itemView.findViewById(R.id.tv_itemOfFrag3_content)

        fun bind(item : CommunityData){
            CoroutineScope(Dispatchers.Main).launch {
                val bitmap = withContext(Dispatchers.IO){
                    ImageLoader.loadImage(item.image)
                }
                itemImage.setImageBitmap(bitmap)
            }
            itemCommunityTitle.setText(item.title)
            itemCommunityDate.setText(item.date)
            itemCommunityName.setText(item.name)
            itemCommunityContent.setText(item.content)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag3,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    override fun getItemCount(): Int = dataList.size
}
