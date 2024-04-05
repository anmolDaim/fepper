package com.example.fepper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.orderDataClass
import com.example.fepper.R

class orderAdapter(val orderArr:ArrayList<orderDataClass>):RecyclerView.Adapter<orderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val BookedOrderName:TextView=itemView.findViewById(R.id.bookedOrderName)
        val BookedOrderquantity:TextView=itemView.findViewById(R.id.bookedOrderquantity)
        val BookedOrderPrice:TextView=itemView.findViewById(R.id.bookedOrderPrice)
        val BookedOrderHeading:TextView=itemView.findViewById(R.id.bookedOrderHeading)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.booked_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orderArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.BookedOrderPrice.setText(orderArr[position].orderedPrice)
        holder.BookedOrderName.setText(orderArr[position].orderedName)
        holder.BookedOrderquantity.setText(orderArr[position].orderedQuantity)
        holder.BookedOrderHeading.setText(orderArr[position].orderedHeading)
    }
}