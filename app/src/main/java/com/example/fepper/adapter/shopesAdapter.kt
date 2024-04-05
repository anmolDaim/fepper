package com.example.fepper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.shpesDataClass
import com.example.fepper.R

class shopesAdapter(val shpesArr:ArrayList<shpesDataClass>,
                    val onItemClick: (shpesDataClass,View) -> Unit):RecyclerView.Adapter<shopesAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val shopeNameTextView: TextView =itemView.findViewById(R.id.shopesName)
        val shopeImageView: ImageView =itemView.findViewById(R.id.shopeImage)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(shpesArr[position],itemView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.shopes_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shpesArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shopeNameTextView.setText(shpesArr[position].shopeName)
        holder.shopeImageView.setImageResource(shpesArr[position].shopeImage)
    }
}