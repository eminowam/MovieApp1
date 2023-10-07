package com.example.movieapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.network.utils.api.Utils
import com.example.movieapp.domain.Movie

interface MovieSetOnClickListener<T> {
    fun goMovieDetails(movieId: Int)
    fun saveMovie(item: T)
}
class MoviesAdapter(
    private val itemType: Int,
    private val listener: MovieSetOnClickListener<Movie>
) : RecyclerView.Adapter<MoviesViewHolder>() {

    var movies = emptyList<Movie>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return if (itemType == ITEM_MOVIE) {
            ITEM_MOVIE
        } else ITEM_STORAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        var layout = when (viewType) {
            ITEM_MOVIE -> R.layout.movies_item
            ITEM_STORAGE -> R.layout.item_storage
            else -> throw java.lang.RuntimeException("Unknown View Type")
        }
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])

        holder.itemView.setOnClickListener {
            listener.goMovieDetails(movies[position].movieId)
        }
        holder.itemView.setOnLongClickListener {
            listener.saveMovie(movies[position])
            true
        }
    }

    override fun getItemCount(): Int = movies.size

    companion object {
        const val ITEM_MOVIE = 0
        const val ITEM_STORAGE = 1
    }
}

class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.movies_image)
    private val title = view.findViewById<TextView>(R.id.movies_title)
    fun bind(movie: Movie) {
        Glide.with(itemView.context)
            .load(Utils.IMAGE_URL + movie.posterImage)
            .centerCrop()
            .into(image);
        title.text = movie.title
    }
}