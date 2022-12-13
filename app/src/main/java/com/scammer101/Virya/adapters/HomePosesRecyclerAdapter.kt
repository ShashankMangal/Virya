package com.scammer101.Virya.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scammer101.Virya.R

class HomePosesRecyclerAdapter() : RecyclerView.Adapter<HomePosesRecyclerAdapter.HomePosesViewHolder>() {
    class HomePosesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePosesRecyclerAdapter.HomePosesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_poses_recyclerview, parent, false)
        return HomePosesRecyclerAdapter.HomePosesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomePosesRecyclerAdapter.HomePosesViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}