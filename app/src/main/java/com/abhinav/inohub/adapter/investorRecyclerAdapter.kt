package com.abhinav.inohub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R

class investorRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<investorRecyclerAdapter.InvestorViewHolder>() {
    class InvestorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.txt_recycle_investor_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestorViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_investor_view, parent, false)
        return InvestorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: InvestorViewHolder, position: Int) {
        val text = itemList[position]
        holder.textView.text = text
    }
}