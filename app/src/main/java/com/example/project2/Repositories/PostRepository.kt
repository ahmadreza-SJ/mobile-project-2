package com.example.project2.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.project2.DataSource
import com.example.project2.Models.Post

public class PostRepository
{
    companion object {
        private  var instance: PostRepository? = null

        fun getInstance(): PostRepository
        {
            if(instance == null)
            {
                instance = PostRepository()
            }
            return instance!!
        }
    }

    private var dataSet: ArrayList<Post>  = ArrayList()

    fun getPosts(): List<Post>
    {
        setPosts()
        Log.e("AAAA", "repo : $dataSet" )

        return dataSet
    }

    private fun setPosts()
    {
        dataSet = DataSource.createDataSet()
    }


}