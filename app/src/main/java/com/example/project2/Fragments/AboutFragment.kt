package com.example.project2.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.Adapters.PostRecyclerAdapter
import com.example.project2.DeveloperRecyclerAdapter
import com.example.project2.Models.Developer
import com.example.project2.Models.Post
import com.example.project2.R
import com.example.project2.TopSpacingItemDecoration
import com.example.project2.ViewModels.AboutViewModel
import com.example.project2.ViewModels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class AboutFragment : Fragment() {
    private lateinit var developerAdapter: DeveloperRecyclerAdapter
    private lateinit var mAboutViewModel: AboutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAboutViewModel = ViewModelProvider(this).get(AboutViewModel::class.java)

        mAboutViewModel.getDevelopers().observe(viewLifecycleOwner, Observer<List<Developer>> {
            Log.e("AAAA", "Inside Observer")
            developerAdapter.submitList(it)
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        Log.e("AAAA", "Inside Recycler view")
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(5)
            addItemDecoration(topSpacingDecoration)
            developerAdapter = DeveloperRecyclerAdapter()
            adapter = developerAdapter
        }

    }

}