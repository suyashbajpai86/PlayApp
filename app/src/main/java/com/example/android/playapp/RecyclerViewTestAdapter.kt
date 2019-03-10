package com.example.android.playapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerViewTestAdapter(private val items: List<Int>,private val context: Context): RecyclerView.Adapter<RecyclerViewTestViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, number: Int): RecyclerViewTestViewHolder {
        return RecyclerViewTestViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewTestViewHolder, position: Int) {
        viewHolder.tvNumber.text = items.get(position).toString()
    }

}

class RecyclerViewTestViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvNumber: TextView = view.findViewById(R.id.tv_number)

}
