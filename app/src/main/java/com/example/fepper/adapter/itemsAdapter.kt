package com.example.fepper.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.itemsDataClass
import com.example.fepper.R
import com.example.fepper.VaritiesActivity

class itemsAdapter(private val context: Context,val itemArr:ArrayList<itemsDataClass>):RecyclerView.Adapter<itemsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemName: TextView =itemView.findViewById(R.id.itemName)
        val itemTitle: TextView =itemView.findViewById(R.id.itemTitle)
        val itemImage: ImageView =itemView.findViewById(R.id.itemImage)
        val itemRating: TextView =itemView.findViewById(R.id.itemRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.shop_category_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemArr[position]
        holder.itemName.setText(itemArr[position].ItemName)
        holder.itemTitle.setText(itemArr[position].ItemTitle)
        holder.itemRating.setText(itemArr[position].ItemRating)
        holder.itemImage.setImageResource(itemArr[position].ItemImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, VaritiesActivity::class.java)
            // Pass item data as extras
            intent.putExtra("ItemImage", item.ItemImage)
            intent.putExtra("ItemName", item.ItemName)
            context.startActivity(intent)
            //(context as AppCompatActivity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}