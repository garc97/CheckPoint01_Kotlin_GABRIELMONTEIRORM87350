package com.example.gabrielmonteirorm87350_v2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeriesAdapter(private val seriesList: MutableList<Serie>) : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_series, parent, false)
        return SeriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val currentItem = seriesList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = seriesList.size

    fun removeItem(position: Int) {
        seriesList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class SeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconImageButton: ImageButton = itemView.findViewById(R.id.icon_recommended)
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_series_name)
        private val genreTextView: TextView = itemView.findViewById(R.id.tv_series_genre)

        init {
            itemView.setOnClickListener {
                removeItem(adapterPosition)
            }
        }

        fun bind(serie: Serie) {
            nameTextView.text = serie.nome
            genreTextView.text = serie.genero
            iconImageButton.setImageResource(if (serie.recomendaria) R.drawable.ic_positive else R.drawable.ic_negative)
        }
    }
}
