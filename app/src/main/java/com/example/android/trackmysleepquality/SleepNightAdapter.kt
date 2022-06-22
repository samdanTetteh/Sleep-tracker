package com.example.android.trackmysleepquality

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<ViewHolder>() {

    var data = listOf<SleepNight>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = data[position]
        val res = holder.itemView.context.resources

        dataItem.apply {
            holder.sleepLength.text = convertDurationToFormatted(startTimeMilli, endTimeMilli, res)
            holder.quality.text = convertNumericQualityToString(dataItem.sleepQuality, res)

            holder.qualityImage.setImageResource( when (dataItem.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent)
        return ViewHolder(view)
    }

}


class ViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    val sleepLength = viewItem.findViewById<TextView>(R.id.sleep_length)
    val quality = viewItem.findViewById<TextView>(R.id.quality_string)
    val qualityImage = viewItem.findViewById<ImageView>(R.id.quality_image)


}