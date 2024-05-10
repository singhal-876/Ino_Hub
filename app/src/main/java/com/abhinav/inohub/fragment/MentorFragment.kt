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
import com.abhinav.inohub.adapter.MentorRecyclerAdapter

class MentorFragment : Fragment() {

    private lateinit var recyclerMentor: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: MentorRecyclerAdapter

    private val carsList= arrayListOf(
       ""
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mentor, container, false)

        recyclerMentor=view.findViewById(R.id.recyclerviewmentor)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= MentorRecyclerAdapter(activity as Context, carsList)

        recyclerMentor.adapter = recyclerAdapter
        recyclerMentor.layoutManager = layoutManager
        return view
    }
}