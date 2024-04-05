package com.example.fepper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.bestSellerDataClass
import com.example.fepper.R
import com.example.fepper.VaritiesActivity

class BestSellerAdapter(private val listener: VaritiesActivity, var bestSellerArr:ArrayList<bestSellerDataClass>):RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val bestSellerImageView: ImageView =itemView.findViewById(R.id.bestSellerImage)
        val bestSellerPriceTextView: TextView =itemView.findViewById(R.id.bestSellerPrice)
        val bestSellerNameTextView: TextView =itemView.findViewById(R.id.bestSellerText)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.bestseller_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerAdapter.ViewHolder, position: Int) {
        val currentItem = bestSellerArr[position]
        holder.bestSellerPriceTextView.setText(bestSellerArr[position].bestPrice)
        holder.bestSellerImageView.setImageResource(bestSellerArr[position].bestImage)
        holder.bestSellerNameTextView.setText(bestSellerArr[position].bestName)

        holder.itemView.setOnClickListener {
            listener.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
       return bestSellerArr.size
    }
    fun showAllItems(allItems: ArrayList<bestSellerDataClass>) {
        bestSellerArr = allItems
        notifyDataSetChanged()
    }

}