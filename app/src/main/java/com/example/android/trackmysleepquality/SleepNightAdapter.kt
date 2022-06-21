package com.example.android.trackmysleepquality

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    val data = listOf<SleepNight>()

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val dataItem = data[position]
        holder.textView.text = dataItem.sleepQuality.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        TODO("Not yet implemented")
    }

}