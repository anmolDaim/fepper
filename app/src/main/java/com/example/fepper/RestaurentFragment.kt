package com.example.fepper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.categoryDataClass
import com.example.fepper.DataClass.itemsDataClass
import com.example.fepper.DataClass.shpesDataClass
import com.example.fepper.adapter.categoryAdapter
import com.example.fepper.adapter.itemsAdapter


class RestaurentFragment : Fragment() {
    lateinit var RestaurantRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurent, container, false)
        RestaurantRecyclerView=view.findViewById(R.id.RestaurantRecyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val itemArr = ArrayList<itemsDataClass>()
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food1,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food2,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food3,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food4,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food5,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food6,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food7,"4.0",))
        itemArr.add(itemsDataClass("Chicken","wow wow wow",R.drawable.food8,"4.0",))

        // Set up RecyclerView
        val numColumns = 2 // Number of columns you want
        val layoutManager = GridLayoutManager(requireContext(), numColumns)
        RestaurantRecyclerView.layoutManager = layoutManager
        val adapter = itemsAdapter(requireContext(),itemArr)
        RestaurantRecyclerView.adapter = adapter
    }

}