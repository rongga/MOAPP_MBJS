package com.example.mbjsmbjs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tab3.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tab3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab3, container, false)

        var dataList = ArrayList<CommunityData>()
        var recyclerView : RecyclerView = view.findViewById(R.id.rv_frag3)

        //여긴 임의 데이터고 실제로는 파베 데이터 넣어야함
        dataList.add(CommunityData("a","신형진","운동 일지","야무지게 운동했습니다.",123))
        dataList.add(CommunityData("a","이재준","다이어트","야무지게 운동했습니다.",123))
        dataList.add(CommunityData("a","홍길동","재활 운동","야무지게 운동했습니다.",123))
        dataList.add(CommunityData("a","정영준","운동 일지","야무지게 운동했습니다.",123))
        dataList.add(CommunityData("a","김옥지","다이어트","야무지게 운동했습니다.",123))
        dataList.add(CommunityData("a","호반우","재활 운동","야무지게 운동했습니다.",123))

        var adapter = FragAdapter3(requireContext())
        adapter.dataList = dataList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //adapter.notifyDataSetChanged()

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tab3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}