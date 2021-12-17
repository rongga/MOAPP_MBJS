package com.example.mbjsmbjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.mbjsmbjs.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    lateinit var tab1: Tab1
    lateinit var tab2: Tab2
    lateinit var tab3: Tab3

    var user: Map<*,*>? = null

    val database = Firebase.database
    val myRef = database.getReference("userInfo")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val bundle = Bundle()
        bundle.putString("test", "test msg")

        setContentView(R.layout.activity_main)

        // firebase code
        FirebaseApp.initializeApp(this)
        myRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.child("C8ATnnxBGXbpkq10t45FqkFfqgr2").getValue() as Map<*, *>
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        tab1 = Tab1()
        tab1.arguments = bundle

        tab2 = Tab2()
        tab3 = Tab3()
        // 프레그먼트 클래스 자체를 객체화 했네 ㅋ
        supportFragmentManager.beginTransaction().add(R.id.fl_main, tab1).commit()
        //이건 시작 프레그먼트를 지정

        var tabLayout : TabLayout = findViewById<TabLayout>(R.id.tl_main);
        var frameLayout : FrameLayout = findViewById(R.id.fl_main);
        tabLayout.addTab(tabLayout.newTab().setText("추천 운동"))
        tabLayout.addTab(tabLayout.newTab().setText("추천 식단"))
        tabLayout.addTab(tabLayout.newTab().setText("커뮤니티"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position){
                    0 -> replaceView(tab1)
                    1 -> replaceView(tab2)
                    2 -> replaceView(tab3)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab!!.position){
                    0 -> tab1.onStop()
                    1 -> tab2.onStop()
                    2 -> tab3.onStop()
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when (tab!!.position){
                    0 -> tab1.onResume()
                    1 -> tab2.onResume()
                    2 -> tab3.onResume()
                }
            }

        }
        )


    }

    private fun replaceView(tab : Fragment){
        //화면전환 함수

        var selectedFragment : Fragment? = null;
        selectedFragment = tab
        //let은 지정된 값이 null 이 아닌경우에 코드를 실행해야 하면
        selectedFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.fl_main, it).commit()
            // it 은 변수가 하나있을때 람다처럼 대체 가능한 변수
        }
    }

}
