package com.example.project2.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project2.Models.Post
import com.example.project2.Repositories.PostRepository

public class MainActivityViewModel: ViewModel()
{
    private var mPosts : MutableLiveData<List<Post>> = MutableLiveData()
    private var mRepo: PostRepository = PostRepository.getInstance()

    init
    {
        var posts= mRepo.getPosts()
        mPosts.value = posts
        Log.e("AAAA", "viewmodel : $posts" )
    }

    fun getPosts(): LiveData<List<Post>>
    {
        return mPosts
    }

}