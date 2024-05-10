package com.abhinav.inohub.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.inohub.R
import com.abhinav.inohub.adapter.FundingRecyclerAdapter

class FundingFragment : Fragment() {

    private lateinit var recyclerFunding: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: FundingRecyclerAdapter

    private val carsList= arrayListOf(
        "3rd week of Saturday (20/01/24)\n\n" +
                "Republic Day (26/01/24)\n\n" +
        "1st week of Saturday (03/02/24)\n\n" +
        "Vasant Panchami (14/02/24)\n\n" +
                "3rd week of Saturday (17/02/24)\n\n" +
                "1st week of Saturday (02/03/24)\n\n" +
        "Maha Shivratri (08/03/24)\n\n" +
                "3rd week of Saturday (16/03/24)\n\n" +
        "Holi (25/03/24)"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_funding, container, false)

        recyclerFunding=view.findViewById(R.id.recyclerviewfunding)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= FundingRecyclerAdapter(activity as Context, carsList)

        recyclerFunding.adapter = recyclerAdapter
        recyclerFunding.layoutManager = layoutManager
        return view
    }
}