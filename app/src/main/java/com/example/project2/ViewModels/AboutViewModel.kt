package com.example.project2.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project2.Models.Developer
import com.example.project2.Repositories.DeveloperRepository

class AboutViewModel : ViewModel()
{
    private var mDevs : MutableLiveData<List<Developer>> = MutableLiveData()
    private var mRepo: DeveloperRepository = DeveloperRepository.getInstance()

    init
    {
        var posts= mRepo.getDevelopers()
        mDevs.value = posts
        Log.e("AAAA", "viewmodel : $posts" )
    }

    fun getDevelopers(): LiveData<List<Developer>>
    {
        return mDevs
    }
}