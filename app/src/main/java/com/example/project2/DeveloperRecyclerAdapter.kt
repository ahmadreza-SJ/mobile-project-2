package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project2.Models.Developer
import kotlinx.android.synthetic.main.developer_item.view.*

class DeveloperRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var developers: List<Developer> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeveloperViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.developer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DeveloperViewHolder -> {
                holder.bind(developers.get(position))
            }
        }
    }

    fun submitList(DeveloperList: List<Developer>)
    {
        this.developers = DeveloperList
    }


    override fun getItemCount(): Int {
        return developers.size
    }


    class DeveloperViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView)
    {
        val developerImage = itemView.developer_image
        val developerName = itemView.developer_name
        val developerStdNum = itemView.developer_std_id

        fun bind(Developer: Developer)
        {
            developerName.setText(Developer.name)
            developerStdNum.setText(Developer.std_id)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Developer.image)
                .into(developerImage)
        }
    }
}