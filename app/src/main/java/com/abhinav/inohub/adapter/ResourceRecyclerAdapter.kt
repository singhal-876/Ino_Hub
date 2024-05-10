package com.abhinav.inohub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R

class ResourceRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<ResourceRecyclerAdapter.ResourceViewHolder>() {
    class ResourceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.txt_recycle_resource_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_resource_view, parent, false)
        return ResourceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val text = itemList[position]
        holder.textView.text = text
    }
}