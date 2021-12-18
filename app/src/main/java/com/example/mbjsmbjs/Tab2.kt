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

class Tab2 : Fragment() {
    val database = Firebase.database
    val foodRef = database.getReference("food")
    var dataList = ArrayList<DietData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab2, container, false)
        var recyclerView : RecyclerView = view.findViewById(R.id.rv_frag2)
        var adapter = FragAdapter2(requireContext())

        foodRef.get().addOnSuccessListener {
            dataList.clear()
            var foodList = it.getValue() as ArrayList<Map<*,*>>
            for (food in foodList) {
                if (food != null){
                    dataList.add(DietData(food["fd_Image"] as String, food["fd_Name"] as String))

                }
            }
        }

        adapter.dataList = dataList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.notifyDataSetChanged()

        // Inflate the layout for this fragment
        return view
    }
}