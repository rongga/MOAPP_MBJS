package com.example.mbjsmbjs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mbjsmbjs.databinding.FragmentTab1Binding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private val DISEASE = mapOf<String, String>(
    "dementia" to "치매", "arthritis" to "관절염", "diabetes" to "당뇨",
    "disc" to "디스크", "hypertension" to "고혈압"
)

private val STRENGTHEN = mapOf<String, String>(
    "arms" to "팔", "back" to "등", "chest" to "가슴",
    "core" to "복근", "diet" to "다이어트", "legs" to "다리"
)


class Tab1 : Fragment() {
    lateinit var adapter: FragAdapter
    var dataList = ArrayList<WorkoutData>()
    val database = Firebase.database
    val videoRef = database.getReference("video")
    lateinit var diseaseList: ArrayList<String>
    lateinit var strengthenList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diseaseList = arguments?.getStringArrayList("diseaseList") as ArrayList<String>
        strengthenList = arguments?.getStringArrayList("strengthenList") as ArrayList<String>
        videoRef.get().addOnSuccessListener {
            dataList = ArrayList()
            val allVideo = it.getValue() as Map<String, Map<String,Map<String,Map<String,Int>>>>

            for (disease in diseaseList){
                val video_list = allVideo[disease] as Map<String, Map<String, Map<String, Int>>>
                for ((vId, vStrengthen) in video_list) {
                    var sNameTmp = ArrayList<String>()
                    var check = false
                    for ((sName,sBool) in vStrengthen["strengthen"] as Map<String,Int>){
                        if (sBool == 1){
                            if (strengthenList.contains(sName)){
                                sNameTmp.add(STRENGTHEN[sName]!!)
                                check = true
                            }
                        }
                    }
                    if (check) {
                        dataList.add(WorkoutData(DISEASE[disease]!!, sNameTmp.joinToString(separator = ", "), vId))
                    }
                }
            }

            adapter.dataList = dataList
            adapter.notifyDataSetChanged()
        }
        adapter = FragAdapter(requireContext())
        adapter.dataList = dataList
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)

        var recyclerView : RecyclerView = view.findViewById(R.id.rv_frag1)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inflate the layout for this fragment
        return view
    }
}