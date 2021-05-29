package com.example.project2.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.Adapters.PostRecyclerAdapter
import com.example.project2.Models.Post
import com.example.project2.R
import com.example.project2.TopSpacingItemDecoration
import com.example.project2.ViewModels.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var postAdapter: PostRecyclerAdapter
    private lateinit var mMainActivityViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMainActivityViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        mMainActivityViewModel.getPosts().observe(viewLifecycleOwner, Observer<List<Post>> {
            Log.e("aaaa", "Inside Observer")
            postAdapter.submitList(it)
        })

        initRecyclerView()
    }


    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            postAdapter = PostRecyclerAdapter(object : PostRecyclerAdapter.OnClickListener{
                override fun onClick(Post: Post) {
                    val navHostFragment =
                        (activity as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                     navHostFragment.navController.navigate(R.id.action_homeFragment_to_detailFragment)
                }
            })
            adapter = postAdapter
        }

    }
}