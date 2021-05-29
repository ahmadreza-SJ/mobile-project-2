package com.example.project2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*

class AboutPage : AppCompatActivity(){
//    private lateinit var developerAdapter: DeveloperRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)
//        aboutRecyclerView()
//        addDevelopers()
    }
//    private  fun addDevelopers()
//    {
//        val developers = DataSource.aboutUsInfo()
//        developerAdapter.submitList(developers)
//    }
//    private fun aboutRecyclerView(){
//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@AboutPage)
//            val topSpacingDecoration = TopSpacingItemDecoration(5)
//            addItemDecoration(topSpacingDecoration)
//            developerAdapter = DeveloperRecyclerAdapter()
//            adapter = developerAdapter
//        }
//    }
}