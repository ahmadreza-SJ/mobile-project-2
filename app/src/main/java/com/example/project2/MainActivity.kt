package com.example.project2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.Adapters.PostRecyclerAdapter
import com.example.project2.Models.Post
import com.example.project2.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostRecyclerAdapter
    private lateinit var mMainActivityViewModel: MainActivityViewModel
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mMainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mMainActivityViewModel.getPosts().observe(this, Observer<List<Post>> {
            Log.e("aaaa", "Inside Observer")
            postAdapter.submitList(it)
            //postAdapter.notifyDataSetChanged()
        })

        initRecyclerView()
    }


    private fun initRecyclerView()
    {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            postAdapter = PostRecyclerAdapter()
            adapter = postAdapter
        }

    }

}