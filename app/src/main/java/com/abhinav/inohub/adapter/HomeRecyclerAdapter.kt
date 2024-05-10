package com.abhinav.inohub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R

class HomeRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
    class HomeViewHolder (view:View) : RecyclerView.ViewHolder(view){
        val textView: TextView=view.findViewById(R.id.txt_recycle_home_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_home_view, parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val text=itemList[position]
        holder.textView.text=text
    }
}