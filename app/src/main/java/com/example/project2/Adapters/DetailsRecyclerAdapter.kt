package com.example.project2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.project2.Models.Post
import com.example.project2.R
import kotlinx.android.synthetic.main.layout_details.view.*

class DetailsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var post: List<Post> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DetailsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DetailsViewHolder -> {
                holder.bind(post.get(position))
            }
        }
    }

    fun submitPost(post: List<Post>)
    {
        this.post = post
    }


    override fun getItemCount(): Int {
        return post.size
    }


    class DetailsViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView)
    {
        val movieImage = itemView.img_movie
        val movieName = itemView.movie_titles
        val movie_streamCount = itemView.txt_view_number
        val movie_seasonCount = itemView.seasons_num
        val movie_releaseDate = itemView.start_year
        val movie_endDate = itemView.end_year

        fun bind(Post: Post)
        {
            movieName.setText(Post.title)
            movie_streamCount.setText(Post.streamCount)
            movie_seasonCount.setText(Post.seasonCount)
            movie_releaseDate.setText(Post.releaseDate)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Post.image)
                .into(movieImage)
        }
    }
}