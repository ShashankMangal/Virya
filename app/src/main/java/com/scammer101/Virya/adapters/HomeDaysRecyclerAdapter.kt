package com.scammer101.Virya.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.scammer101.Virya.R
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class HomeDaysRecyclerAdapter(date: Int,listener:OnClick) :RecyclerView.Adapter<HomeDaysRecyclerAdapter.HomeDaysViewHolder>() {
    var date = date
    var listener = listener

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
        var cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, position+1)
        holder.day.text = cal.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.getDefault())!!.toString().subSequence(0,3)
        holder.date.text = buildString { append(position + 1)}
        if (position == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1) {
            holder.background.setCardBackgroundColor(holder.background.context.getColor(R.color.black))
            holder.day.setTextColor(holder.itemView.context.getColor(R.color.white))
        }else{
            holder.background.setCardBackgroundColor(holder.background.context.getColor(R.color.white))
            holder.day.setTextColor(holder.itemView.context.getColor(R.color.black))
        }
        var date = DateFormat.getDateInstance(DateFormat.DEFAULT).format(cal.time)
        holder.background.setOnClickListener {
            parseDateToddMMyyyy(date)?.let { it1 -> listener.onDayClickListener(it1) }
        }
    }

    override fun getItemCount(): Int {
        return Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)
    }

    fun parseDateToddMMyyyy(time: String?): String? {
        val inputPattern = "dd-MMM-yyyy"
        val outputPattern = "MM-dd-yyyy"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(outputPattern)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(time)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }


    interface OnClick {
        fun onDayClickListener(date: String)
    }

}