package com.example.project2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity: Fragment(){
    private lateinit var postAdapter: PostRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater,
                          container: ViewGroup?,
                          savedInstanceState: Bundle?
    ):View? {

        val view = inflater.inflate(R.layout.activity_main,container,false)
        view.buttonme.setOnClickListener{Navigation.findNavController(view).navigate(R.id.main_to_about)}
        return view
    }

//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(itemView, savedInstanceState)
//        initRecyclerView()
//        addDataSet()
//    }
//
//    private fun addDataSet()
//    {
//        val data = DataSource.createDataSet()
//        postAdapter.submitList(data)
//    }
//
//    private fun initRecyclerView() {
//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(activity)
//            val topSpacingDecoration = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecoration)
//            postAdapter = PostRecyclerAdapter()
//            adapter = postAdapter
//        }
//    }
}

