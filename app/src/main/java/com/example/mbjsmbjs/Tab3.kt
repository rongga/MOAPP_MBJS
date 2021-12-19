package com.example.mbjsmbjs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Tab3 : Fragment() {
    val database = Firebase.database
    val commRef = database.getReference("community/writing")
    var dataList = ArrayList<CommunityData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commRef.get().addOnSuccessListener {
            dataList = ArrayList<CommunityData>()
            var wList = it.getValue() as ArrayList<Map<*,*>>
            for (writing in wList) {
                if (writing != null){
                    dataList.add(CommunityData(writing["image"] as String, writing["writer"] as String,
                        writing["title"] as String, writing["contents"] as String, writing["date"] as String,3))

                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab3, container, false)

        var recyclerView : RecyclerView = view.findViewById(R.id.rv_frag3)
        var adapter = FragAdapter3(requireContext())
        adapter.dataList = dataList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //adapter.notifyDataSetChanged()

        return view
    }

}