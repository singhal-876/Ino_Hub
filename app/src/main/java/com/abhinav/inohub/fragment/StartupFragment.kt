package com.abhinav.inohub.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhinav.inohub.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.adapter.StartupRecyclerAdapter

class StartupFragment : Fragment() {

    private lateinit var recyclerStartup: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: StartupRecyclerAdapter
    private val carsList= arrayListOf("")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_startup, container, false)

        recyclerStartup=view.findViewById(R.id.recyclerviewmesssages)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= StartupRecyclerAdapter(activity as Context, carsList)

        recyclerStartup.adapter = recyclerAdapter
        recyclerStartup.layoutManager = layoutManager
        return view
    }

}