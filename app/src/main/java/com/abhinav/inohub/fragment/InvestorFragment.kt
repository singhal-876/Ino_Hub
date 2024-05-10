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
import com.abhinav.inohub.adapter.investorRecyclerAdapter

class InvestorFragment : Fragment() {

    private lateinit var recyclerCollaborator: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: investorRecyclerAdapter
    private var isResourceSubmissionEnabled = true
    private val carsList= arrayListOf(
        ""
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_investor, container, false)

        recyclerCollaborator=view.findViewById(R.id.recyclerviewinvestor)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= investorRecyclerAdapter(activity as Context, carsList)

        recyclerCollaborator.adapter = recyclerAdapter
        recyclerCollaborator.layoutManager = layoutManager
        return view
    }
}