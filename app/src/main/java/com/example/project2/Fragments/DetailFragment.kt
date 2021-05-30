package com.example.project2.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.project2.Adapters.DetailsRecyclerAdapter
import com.example.project2.Adapters.PostRecyclerAdapter
import com.example.project2.Models.Post
import com.example.project2.R
import com.example.project2.ViewModels.MainViewModel
import kotlinx.android.synthetic.main.layout_details.view.*
import kotlinx.android.synthetic.main.layout_list_item.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private lateinit var mMainActivityViewModel: MainViewModel
    private lateinit var detailsAdapter: DetailsRecyclerAdapter
//    private val args: FragmentArgs by navArgs()
//    private lateinit varx thepost: Post

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        thepost = args.thepost
//        view.movie_title.text = thepost.title
//        view.end_year.text = thepost.releaseDate
//        view.seasons_num.text = thepost.seasonCount
//        view.movie_stream_count.text = thepost.streamCount
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mMainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mMainActivityViewModel.getPost().observe(viewLifecycleOwner, Observer<Post> {post ->
            Log.e("aaaa", "Inside Observer")
            val mylist: List<Post> = listOf(post)
            detailsAdapter.submitPost(mylist)
        })
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}