package com.example.fepper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.notificationDataClass
import com.example.fepper.R

class notificationAdapter(val notiArr:ArrayList<notificationDataClass>):RecyclerView.Adapter<notificationAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val notiImage:ImageView=itemView.findViewById(R.id.notiImage)
        val notiHeading:TextView=itemView.findViewById(R.id.notiHeading)
        val notiTitle:TextView=itemView.findViewById(R.id.notiTitle)
        val notiePath:TextView=itemView.findViewById(R.id.notiePath)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): notificationAdapter.ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.notification_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: notificationAdapter.ViewHolder, position: Int) {
        holder.notiImage.setImageResource(notiArr[position].notiImage)
        holder.notiHeading.setText(notiArr[position].notiHeading)
        holder.notiTitle.setText(notiArr[position].notiTitle)
        holder.notiePath.setText(notiArr[position].notiPath)
    }

    override fun getItemCount(): Int {
       return notiArr.size
    }
}