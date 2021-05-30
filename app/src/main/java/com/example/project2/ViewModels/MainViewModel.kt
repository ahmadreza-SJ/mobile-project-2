package com.example.project2.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project2.Models.Post
public class MainViewModel: ViewModel()
{
    private var mPost : MutableLiveData<Post> = MutableLiveData()

    init
    {
        Log.e("AAAA", "initial mainviewmodel : $mPost" )
    }

    fun getPost(): LiveData<Post>
    {
        Log.e("AAAA", "get post viewmodel : ${mPost.value }" )
        return mPost
    }

    fun setPost(post: Post)
    {
        mPost.value = post
        Log.e("AAAA", "set post viewmodel : ${mPost.value }" )
    }

}