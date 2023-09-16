package com.example.gabrielmonteirorm87350_v2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

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

    inner class SeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val genreTextView: TextView = itemView.findViewById(R.id.genreTextView)
        val iconImageButton: ImageButton = itemView.findViewById(R.id.iconImageButton)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)

        fun bind(serie: Serie) {
            nameTextView.text = serie.nome
            genreTextView.text = serie.genero
            iconImageButton.setImageResource(if (serie.recomendaria) R.drawable.ic_positive else R.drawable.ic_negative)

            iconImageButton.setOnClickListener {
                serie.recomendaria = !serie.recomendaria
                iconImageButton.setImageResource(if (serie.recomendaria) R.drawable.ic_positive else R.drawable.ic_negative)
            }

            deleteButton.setOnClickListener {
                seriesList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }
}

