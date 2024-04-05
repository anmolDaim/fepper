package com.example.fepper

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bookingDataClass
import com.example.fepper.DataClass.orderDataClass
import com.example.fepper.adapter.bookingAdapter
import com.example.fepper.adapter.orderAdapter


class BookingFragment : Fragment() {
    lateinit var orderRecyclerView: RecyclerView
    lateinit var orderTitle: TextView
    lateinit var orderText: TextView
    lateinit var orderBtn: AppCompatButton
    lateinit var orderImage: ImageView
     val orderArr=ArrayList<orderDataClass>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_booking, container, false)
        orderRecyclerView = view.findViewById(R.id.orderRecyclerView)
        orderBtn=view.findViewById(R.id.orderBtn)
        orderTitle=view.findViewById(R.id.orderTitle)
        orderText = view.findViewById(R.id.orderText)
        orderImage = view.findViewById(R.id.orderImage)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val linearLayout=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        orderRecyclerView.layoutManager=linearLayout
        val OrderAdapter=orderAdapter(orderArr)
        orderRecyclerView.adapter=OrderAdapter
//        arguments?.let { args ->
//            val totalPrice = args.getString("totalPrice")
//            val Heading = args.getString("Heading")
//            val itemName = args.getString("buyPriceValue")
//
//            // Create an orderDataClass object using the fetched data
//            val orderItem = orderDataClass(Heading!!, itemName!!, totalPrice!!)
//
//            // Add the created orderItem to the orderArr
//            orderArr.add(orderItem)
//
//            // Notify the adapter about the data change
//            OrderAdapter.notifyDataSetChanged()
//        }



//        val adapter = bookingAdapter(addedProducts)
//        orderRecyclerView.adapter = adapter
        orderBtn.setOnClickListener {
            val fragment = HomeFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
        updateVisibility()
    }

    private fun updateVisibility() {

        if (orderArr.isEmpty()) {
            orderImage.visibility = View.VISIBLE
            orderText.visibility = View.VISIBLE
            orderTitle.visibility = View.VISIBLE
            orderBtn.visibility = View.VISIBLE
            orderRecyclerView.visibility = View.GONE

        } else {
            orderImage.visibility = View.GONE
            orderText.visibility = View.GONE
            orderTitle.visibility = View.GONE
            orderBtn.visibility = View.GONE
            orderRecyclerView.visibility = View.VISIBLE
        }
    }

}