package com.abhinav.inohub.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.adapter.ResourceRecyclerAdapter
import com.abhinav.inohub.R

class ResourceFragment : Fragment() {

    private lateinit var recyclerResource: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: ResourceRecyclerAdapter
    private var isResourceSubmissionEnabled = true
    private val carsList= arrayListOf(
""
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resource, container, false)

        recyclerResource=view.findViewById(R.id.recyclerviewresource)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= ResourceRecyclerAdapter(activity as Context, carsList)

        recyclerResource.adapter = recyclerAdapter
        recyclerResource.layoutManager = layoutManager
        return view
    }
}