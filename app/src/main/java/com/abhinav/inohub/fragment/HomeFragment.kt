package com.abhinav.inohub.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R
import com.abhinav.inohub.adapter.HomeRecyclerAdapter

class HomeFragment : Fragment() {

    private lateinit var recyclerHome: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: HomeRecyclerAdapter

    private val carsList= arrayListOf(
        "Home Page"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerHome=view.findViewById(R.id.recyclerviewhome)
        layoutManager=LinearLayoutManager(activity)
        recyclerAdapter= HomeRecyclerAdapter(activity as Context, carsList)

        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager
        return view
    }

}