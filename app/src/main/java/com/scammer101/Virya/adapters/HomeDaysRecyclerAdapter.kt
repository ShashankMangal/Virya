package com.scammer101.Virya.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.scammer101.Virya.R

class HomeDaysRecyclerAdapter(date: Int) :RecyclerView.Adapter<HomeDaysRecyclerAdapter.HomeDaysViewHolder>() {
    var date = date
    class HomeDaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.day)
        val date: TextView = itemView.findViewById(R.id.date)
        val background: CardView = itemView.findViewById(R.id.background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeDaysViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_day_recyclerview, parent, false)
        return HomeDaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeDaysViewHolder, position: Int) {
        holder.day.text = "Day"
        holder.date.text = "${position + 1}"
        if (position + 1 == date) {
            holder.background.setCardBackgroundColor(holder.background.context.getColor(R.color.black))
            holder.day.setTextColor(holder.itemView.context.getColor(R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return  31
    }

}