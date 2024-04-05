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


class PureVegFregment : Fragment() {
    lateinit var purevegRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.pure_veg_fregment, container, false)
        purevegRecyclerView=view.findViewById(R.id.purevegRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val itemArr = ArrayList<itemsDataClass>()
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food5,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food2,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food1,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food4,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food5,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food6,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food8,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food8,"4.0",))

        // Set up RecyclerView
        val numColumns = 2 // Number of columns you want
        val layoutManager = GridLayoutManager(requireContext(), numColumns)
        purevegRecyclerView.layoutManager = layoutManager
        val adapter = itemsAdapter(requireContext(),itemArr)
        purevegRecyclerView.adapter = adapter
    }
}