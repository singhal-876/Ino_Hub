package com.abhinav.inohub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R

class StartupRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<StartupRecyclerAdapter.StartupViewHolder>() {
    class StartupViewHolder (view:View) : RecyclerView.ViewHolder(view){
        val textView: TextView=view.findViewById(R.id.txt_recycle_startup_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_startup_view, parent,false)
        return StartupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: StartupViewHolder, position: Int) {
        val text=itemList[position]
        holder.textView.text=text
    }
}