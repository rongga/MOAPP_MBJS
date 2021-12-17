package com.example.mbjsmbjs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class FragAdapter(private  val context: Context) :
    RecyclerView.Adapter<FragAdapter.ViewHolder>() {

    var dataList = mutableListOf<WorkoutData>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val video : YouTubePlayerView = itemView.findViewById(R.id.videoItem)
        private val disease : TextView = itemView.findViewById(R.id.diseaseTextView)
        private val strengthen: TextView = itemView.findViewById(R.id.strengthenTextView)


//        private val itemImage : ImageButton = itemView.findViewById(R.id.iv_itemOfFrag1)
//        private val itemWorkoutName : TextView = itemView.findViewById(R.id.tv_itemOfFrag1_nameOfWorkout)
//        private val itemWorkoutTarget : TextView = itemView.findViewById(R.id.tv_itemOfFrag1_targetOfWorkout)
//        private val itemWorkoutHardness : TextView = itemView.findViewById(R.id.tv_itemOfFrag1_hardness)

        fun bind(item : WorkoutData){
//            itemWorkoutName.setText(item.name)
//            itemWorkoutTarget.setText(item.target)
//            itemWorkoutHardness.setText(item.hardness.toString())
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag1,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

    override fun getItemCount(): Int = dataList.size
}
