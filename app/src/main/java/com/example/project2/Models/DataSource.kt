package com.example.project2.Models

import com.example.project2.Models.Post

class DataSource
{
    companion object
    {
        fun createDataSet(): ArrayList<Post>
        {
            val list = ArrayList<Post>()
            list.add(
                Post(
                    "Film1",
                    "url1",
                    "1000",
                    "10",
                    "12-2-23 to 12-31-13"
                )
            )
            list.add(
                Post(
                    "Film2",
                    "url2",
                    "1000",
                    "10",
                    "12-2-23 to 12-31-13"
                )
            )
            list.add(
                Post(
                    "Film3",
                    "url3",
                    "1000",
                    "10",
                    "12-2-23 to 12-31-13"
                )
            )
            return list
        }
    }
}