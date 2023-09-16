package com.example.gabrielmonteirorm87350_v2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seriesList = mutableListOf(
            Serie("Avatar", "Aventura", true),
            Serie("Barbie", "Aventura", true),
            Serie("Lost", "Melodrama", false),
            Serie("Naruto", "Anime", true)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SeriesAdapter(seriesList)
    }
}

