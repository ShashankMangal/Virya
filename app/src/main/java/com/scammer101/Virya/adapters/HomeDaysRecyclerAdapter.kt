package com.scammer101.Virya.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.scammer101.Virya.R

class HomeDaysRecyclerAdapter:RecyclerView.Adapter<HomeDaysRecyclerAdapter.HomeDaysViewHolder>() {
    class HomeDaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.day)
        val date: TextView = itemView.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDaysViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_recyclerview, parent, false)
        return HomeDaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeDaysViewHolder, position: Int) {
        holder.day.text = "Day"
        holder.date.text = "${position + 1}"
    }

    override fun getItemCount(): Int {
        return  31
    }

}