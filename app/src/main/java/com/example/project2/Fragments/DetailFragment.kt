package com.example.project2.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project2.Models.Developer
import com.example.project2.Models.Post
import com.example.project2.R
import com.example.project2.ViewModels.MainViewModel
import kotlinx.android.synthetic.main.fragment_detail.view.*

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

    private val parentViewModel: MainViewModel by activityViewModels<MainViewModel>()
    private  var thepost : Post? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("aaaa", "on vie created :")
        view.movie_titles.text = thepost!!.title
        view.end_year.text = thepost!!.releaseDate
        view.seasons_num.text = thepost!!.seasonCount
        view.txt_view_number.text = thepost!!.streamCount
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        parentViewModel.getPost().observe(viewLifecycleOwner, Observer<Post> {

            Log.e("aaaa", "in get post : $it")
        })
        Log.e("aaaa", "Inside Observer: $thepost")
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}