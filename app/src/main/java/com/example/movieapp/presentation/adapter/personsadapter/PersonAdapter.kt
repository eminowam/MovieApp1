package com.example.movieapp.presentation.adapter.personsadapter

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


interface MovieSetOnClickListener {
    fun goPersonDetails(page: Int)
}
class PersonAdapter(private val listener: MovieSetOnClickListener) :
    RecyclerView.Adapter<PersonsViewHolder>() {

    var person = emptyList<com.example.movieapp.domain.Person>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder =
        PersonsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movies_item, parent, false)
        )

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        holder.bind(person[position])
        holder.itemView.setOnClickListener{
            listener.goPersonDetails(person[position].personId)
        }
    }

    override fun getItemCount(): Int = person.size
}

class PersonsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.movies_image)
    private val title = view.findViewById<TextView>(R.id.movies_title)
    fun bind(movie: com.example.movieapp.domain.Person) {
        Glide.with(itemView.context)
            .load(Utils.IMAGE_URL + movie.profile_path)
            .centerCrop()
            .into(image);

        title.text = movie.name
    }

}