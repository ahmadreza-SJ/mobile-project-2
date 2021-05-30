package com.example.project2.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project2.Models.Post
import com.example.project2.Repositories.PostRepository
public class MainViewModel: ViewModel()
{
    private var mPost : MutableLiveData<Post> = MutableLiveData()

    init
    {
        Log.e("AAAA", "initial mainviewmodel : $mPost" )
    }

    fun getPost(): LiveData<Post>
    {
        return mPost
    }

    fun setPost(post: Post)
    {
        mPost.value = post
        Log.e("AAAA", "viewmodel : ${mPost.value }" )
    }

}