package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project2.Models.Post

class PostRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var items: ArrayList<Post> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PostViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class PostViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView)
    {
        val movieImage = itemView.movie_image
        val movieTitle = itemView.movie_title
        val movieStreamCount = itemView.movie_stream_count

        fun bind(Post: Post)
        {
            movieTitle.setText(Post.title)
            movieStreamCount.setText(Post.streamCount)
            movieImage.setText(Post.title)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

                Glide.with(itemView.Context)
                    .load(Post.image)
                    .into(movieImage)
        }
    }
}