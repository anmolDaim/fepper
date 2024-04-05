package com.example.fepper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.itemsDataClass
import com.example.fepper.adapter.itemsAdapter


class BakesFragment : Fragment() {
lateinit var BakesRecyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bakes, container, false)
        BakesRecyclerView=view.findViewById(R.id.BakesRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemArr = ArrayList<itemsDataClass>()
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food1,"4.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food2,"3.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food3,"2.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food4,"1.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food5,"0.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food6,"5.0",))
        itemArr.add(itemsDataClass("Baked Cookies","wow wow wow",R.drawable.food7,"4.0",))

        // Set up RecyclerView
        val numColumns = 2 // Number of columns you want
        val layoutManager = GridLayoutManager(requireContext(), numColumns)
        BakesRecyclerView.layoutManager = layoutManager
        val adapter = itemsAdapter(requireContext(),itemArr)
        BakesRecyclerView.adapter = adapter
    }
}