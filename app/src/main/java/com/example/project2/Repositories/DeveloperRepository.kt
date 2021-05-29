package com.example.project2.Repositories

import android.util.Log
import com.example.project2.DataSource
import com.example.project2.Models.Developer

class DeveloperRepository {
    companion object {
        private  var instance: DeveloperRepository? = null

        fun getInstance(): DeveloperRepository
        {
            if(instance == null)
            {
                instance = DeveloperRepository()
            }
            return instance!!
        }
    }

    private var dataSet: ArrayList<Developer>  = ArrayList()

    fun getDevelopers(): List<Developer>
    {
        setDevelopers()
        Log.e("AAAA", "repo : $dataSet" )

        return dataSet
    }

    private fun setDevelopers()
    {
        dataSet = DataSource.CreateInfoDataset()
    }

}